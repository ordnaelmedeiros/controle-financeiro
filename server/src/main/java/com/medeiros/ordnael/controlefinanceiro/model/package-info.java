@XmlJavaTypeAdapters({
	@XmlJavaTypeAdapter(type=LocalDate.class,  value=LocalDateAdapter.class),
})
package com.medeiros.ordnael.controlefinanceiro.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.medeiros.ordnael.core.adapters.LocalDateAdapter;

