package com.ex.codec.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

public class JsonToObjectDecoder {

    public <T> T decode (String str, Class<T> objClass) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(str, objClass);
    }

    public <T> MappingIterator<T> decode (Reader reader, Class<T> objClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = new JsonFactory();
        return mapper.readValues(factory.createParser(reader), objClass);
    }

}
