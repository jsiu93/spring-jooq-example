package com.xzh.springjooq.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalDateTimeToLongSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime date, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(date.atZone(ZoneId.systemDefault()).toEpochSecond());
    }
}