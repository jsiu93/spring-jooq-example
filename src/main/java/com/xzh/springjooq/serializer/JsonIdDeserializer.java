package com.xzh.springjooq.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class JsonIdDeserializer extends JsonDeserializer<Long> {

	@Override
	public Long deserialize(JsonParser json, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		
		String value = json.getText();
		try {
			return Long.parseLong(value);
		} catch (Exception e) {
			return null;
		}
	}

}
