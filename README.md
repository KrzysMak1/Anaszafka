# Anaszafka

Repozytorium zawiera gotowy do kompilacji plugin `STORMSZAFKA`.

## Kompilacja

```bash
mvn -DskipTests package
```

Wynikowy plik JAR będzie w katalogu `target/`.

## plugin.yml

`src/main/resources/plugin.yml` jest skopiowany 1:1 z oryginalnego pliku `STORMSZAFKA_1.0 (2).jar`.

## Odtworzenie/dekompilacja (opcjonalnie)

Jeśli chcesz wygenerować surowe źródła z oryginalnego JAR do dalszej analizy, uruchom:

```bash
./scripts/prepare_rebuild.sh
```

Domyślnie wynik trafia do `recovered-src/`, żeby nie psuć kompilowalnego kodu w `src/main/java`.
