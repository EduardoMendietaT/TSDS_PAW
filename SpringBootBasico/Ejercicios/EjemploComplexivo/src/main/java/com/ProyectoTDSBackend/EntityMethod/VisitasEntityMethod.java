package com.ProyectoTDSBackend.EntityMethod;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Repository
//@Transactional
public class VisitasEntityMethod {
	
	@Autowired
	DataSource dataSource;
	
	public byte[] getJasperReport(Integer personaId) {
		try{
			File file = ResourceUtils.getFile("classpath:anexo11.jrxml");
			JasperReport jr = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			Map<String, Object> parameters = new LinkedHashMap<>();
			parameters.put("PERSONA_ID", personaId);
			
			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, new JREmptyDataSource(1));//, DataSourceUtils.getConnection(dataSource));
			return JasperExportManager.exportReportToPdf(jp);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
