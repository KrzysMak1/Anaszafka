// 
// Decompiled by Procyon v0.6.0
// 

package pl.ziffy.sTORMSZAFKA.bstats.json;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Arrays;

public class JsonObjectBuilder
{
    private StringBuilder B;
    private boolean A;
    
    public JsonObjectBuilder() {
        this.B = new StringBuilder();
        this.A = false;
        this.B.append("{");
    }
    
    public JsonObjectBuilder appendNull(final String s) {
        this.A(s, "null");
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final String s2) {
        if (s2 == null) {
            throw new IllegalArgumentException("JSON value must not be null");
        }
        this.A(s, "\"" + B(s2) + "\"");
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final int i) {
        this.A(s, String.valueOf(i));
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final JsonObject jsonObject) {
        if (jsonObject == null) {
            throw new IllegalArgumentException("JSON object must not be null");
        }
        this.A(s, jsonObject.toString());
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        this.A(s, "[" + Arrays.stream(array).map(s2 -> "\"" + B(s2) + "\"").collect((Collector<? super Object, ?, String>)Collectors.joining(",")) + "]");
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        this.A(s, "[" + Arrays.stream(array).mapToObj((IntFunction<?>)String::valueOf).collect((Collector<? super Object, ?, String>)Collectors.joining(",")) + "]");
        return this;
    }
    
    public JsonObjectBuilder appendField(final String s, final JsonObject[] array) {
        if (array == null) {
            throw new IllegalArgumentException("JSON values must not be null");
        }
        this.A(s, "[" + Arrays.stream(array).map((Function<? super JsonObject, ?>)JsonObject::toString).collect((Collector<? super Object, ?, String>)Collectors.joining(",")) + "]");
        return this;
    }
    
    private void A(final String s, final String str) {
        if (this.B == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        if (s == null) {
            throw new IllegalArgumentException("JSON key must not be null");
        }
        if (this.A) {
            this.B.append(",");
        }
        this.B.append("\"").append(B(s)).append("\":").append(str);
        this.A = true;
    }
    
    public JsonObject build() {
        if (this.B == null) {
            throw new IllegalStateException("JSON has already been built");
        }
        final JsonObject jsonObject = new JsonObject(this.B.append("}").toString());
        this.B = null;
        return jsonObject;
    }
    
    private static String B(final String s) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\"') {
                sb.append("\\\"");
            }
            else if (char1 == '\\') {
                sb.append("\\\\");
            }
            else if (char1 <= '\u000f') {
                sb.append("\\u000").append(Integer.toHexString(char1));
            }
            else if (char1 <= '\u001f') {
                sb.append("\\u00").append(Integer.toHexString(char1));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    public static class JsonObject
    {
        private final String A;
        
        private JsonObject(final String a) {
            this.A = a;
        }
        
        @Override
        public String toString() {
            return this.A;
        }
    }
}
