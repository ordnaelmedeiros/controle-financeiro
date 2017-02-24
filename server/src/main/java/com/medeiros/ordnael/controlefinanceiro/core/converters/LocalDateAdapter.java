package com.medeiros.ordnael.controlefinanceiro.core.converters;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String v) throws Exception {
    	LocalDate parse = LocalDate.parse(v);
        return parse;
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
    
}
