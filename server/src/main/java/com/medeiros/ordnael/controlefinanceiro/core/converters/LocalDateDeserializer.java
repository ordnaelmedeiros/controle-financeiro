package com.medeiros.ordnael.controlefinanceiro.core.converters;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        //return LocalDate.parse(p.getValueAsString(), FORMATTER);
    	return LocalDate.of(2000, 1, 1);
    }
}