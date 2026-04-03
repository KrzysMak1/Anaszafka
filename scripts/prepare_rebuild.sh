#!/usr/bin/env bash
set -euo pipefail

JAR_FILE="${1:-STORMSZAFKA_1.0 (2).jar}"
WORK_DIR="${2:-build/rebuild-work}"
OUT_SRC_DIR="${3:-recovered-src/main/java}"
OUT_RES_DIR="${4:-recovered-src/main/resources}"
CFR_VERSION="0.152"
CFR_JAR="tools/cfr-${CFR_VERSION}.jar"
PACKAGE_PATH="pl/ziffy/STORMSZAFKA"

if [[ ! -f "$JAR_FILE" ]]; then
  echo "[ERROR] Nie znaleziono pliku JAR: $JAR_FILE" >&2
  exit 1
fi

mkdir -p "$WORK_DIR" "$OUT_SRC_DIR" "$OUT_RES_DIR" tools

if [[ ! -f "$CFR_JAR" ]]; then
  echo "[INFO] Pobieranie CFR ${CFR_VERSION}..."
  curl -fsSL "https://repo1.maven.org/maven2/org/benf/cfr/${CFR_VERSION}/cfr-${CFR_VERSION}.jar" -o "$CFR_JAR"
fi

rm -rf "$WORK_DIR/extracted" "$WORK_DIR/classes"
mkdir -p "$WORK_DIR/extracted" "$WORK_DIR/classes"

echo "[INFO] Rozpakowywanie JAR..."
unzip -q -o "$JAR_FILE" -d "$WORK_DIR/extracted"

if [[ ! -d "$WORK_DIR/extracted/$PACKAGE_PATH" ]]; then
  echo "[ERROR] Nie znaleziono pakietu $PACKAGE_PATH w jarze." >&2
  exit 1
fi

mkdir -p "$WORK_DIR/classes/pl/ziffy"
cp -R "$WORK_DIR/extracted/$PACKAGE_PATH" "$WORK_DIR/classes/pl/ziffy/"

echo "[INFO] Dekompilacja klas pluginu do $OUT_SRC_DIR..."
find "$WORK_DIR/classes/$PACKAGE_PATH" -type f -name '*.class' ! -name '*$*.class' -print0 |
  while IFS= read -r -d '' class_file; do
    java -jar "$CFR_JAR" "$class_file" --decodestringswitch false --silent true --outputdir "$OUT_SRC_DIR" >/dev/null 2>&1 || true
  done

echo "[INFO] Kopiowanie zasobów..."
resources=(
  "plugin.yml"
  "config.yml"
  "MenuConfig.yml"
  "PetMenuConfig.yml"
  "CostumeMenuConfig.yml"
)
for resource in "${resources[@]}"; do
  if [[ -f "$WORK_DIR/extracted/$resource" ]]; then
    cp "$WORK_DIR/extracted/$resource" "$OUT_RES_DIR/$resource"
  fi
done

for folder in costumes lang; do
  if [[ -d "$WORK_DIR/extracted/$folder" ]]; then
    rm -rf "$OUT_RES_DIR/$folder"
    cp -R "$WORK_DIR/extracted/$folder" "$OUT_RES_DIR/$folder"
  fi
done

echo "[DONE] Gotowe. Zrodla zapisane w katalogu recovered-src (lub podanym argumentem)."
