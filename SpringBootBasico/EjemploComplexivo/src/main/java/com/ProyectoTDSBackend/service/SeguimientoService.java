package com.ProyectoTDSBackend.service;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ProyectoTDSBackend.EntityMethod.SeguimientoEntityMethod;


@Service
public class SeguimientoService {
	
	@Autowired
	SeguimientoEntityMethod seguimientoEntityMethod;
	
	public byte[] getJasperReport(Integer personaId) {
		return seguimientoEntityMethod.getJasperReport(personaId);
	}
}
