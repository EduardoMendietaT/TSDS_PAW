package com.ProyectoTDSBackend.service;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.ProyectoTDSBackend.EntityMethod.SeguimientoEntityMethod;
import com.ProyectoTDSBackend.EntityMethod.VisitasEntityMethod;


@Service
public class VisitasService {
	
	@Autowired
	VisitasEntityMethod visitasEntityMethod;
	
	public byte[] getJasperReport(Integer personaId) {
		return visitasEntityMethod.getJasperReport(personaId);
	}
}
