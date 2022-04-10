package com.ex.codec.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CsvToObjectDecoder {

    public <T> T decode (String str, Class<T> objClass) throws JsonProcessingException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(objClass);
        return mapper.readerFor(objClass).with(schema).readValue(str);
    }

    public <T> List<T> decode (Reader reader, Class<T> objClass) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(objClass);
        MappingIterator<T> iter = mapper.readerFor(objClass).with(schema).readValues(reader);
        return iter.readAll();
    }

}
