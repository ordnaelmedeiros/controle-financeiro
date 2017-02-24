@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class, type = LocalDate.class)//,
    //@XmlJavaTypeAdapter(value = LocalTimeAdapter.class, type = LocalTime.class)
})

package com.medeiros.ordnael.controlefinanceiro.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.medeiros.ordnael.controlefinanceiro.core.converters.LocalDateAdapter;
