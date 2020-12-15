/**
 * 
 */
package com.mystudy.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 * @author Keshav
 *
 */
public class StudentAssessmentReport extends AbstractXlsView {
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.setHeader("Content-Disposition", "attachment; filename=\"Student Report.xls\"");
		Sheet sheet =  workbook.createSheet("StaticTestReport");
	}
}
