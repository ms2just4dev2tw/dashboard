package com.ex.codec.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class ObjectToCsvEncoder {

    public static String encode (Object obj) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = configCsvSchema(mapper.schemaFor(obj.getClass()), true);
        return mapper.writer(schema).writeValueAsString(obj);
    }

    public static  <T> String encode (Iterable<T> iter, Class<T> objClass) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = configCsvSchema(mapper.schemaFor(objClass), true);
        return mapper.writer(schema).writeValueAsString(iter);
    }

    private static CsvSchema configCsvSchema (CsvSchema schema, boolean withHeader) {
        CsvSchema.Builder builder = new CsvSchema.Builder(schema);
        builder.disableQuoteChar();
        return builder.setUseHeader(withHeader).build();
    }
}
