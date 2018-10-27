package spring.excel.upload;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class FileDataView extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition",
				"attachment; filename=\"abc.xls\";");

		Sheet sheet = createFirstSheet(workbook);
		createColumnLabel(sheet);

		List<FileData> fileDTO = (List<FileData>) model.get("FileData");
		int rowNum = 1;
		for (FileData file : fileDTO) {
			createPageRankRow(sheet, file, rowNum++);
		}
	}

	private Sheet createFirstSheet(Workbook workbook) {
		Sheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "페이지 순위");
		sheet.setColumnWidth(1, 256 * 20);
		return sheet;
	}

	private void createColumnLabel(Sheet sheet) {
		Row firstRow = sheet.createRow(0);
		Cell cell = firstRow.createCell(0);
		cell.setCellValue("sno");

		cell = firstRow.createCell(1);
		cell.setCellValue("Orig_name");
		
		cell = firstRow.createCell(2);
		cell.setCellValue("Sys_name");
		
		cell = firstRow.createCell(3);
		cell.setCellValue("F_size");
		
		cell = firstRow.createCell(4);	
		cell.setCellValue("Regdate");
	}

	private void createPageRankRow(Sheet sheet, FileData file, int rowNum) {
		Row row = sheet.createRow(rowNum);
		Cell cell = row.createCell(0);
		cell.setCellValue(file.getSno());

		cell = row.createCell(1);
		cell.setCellValue(file.getOrig_name());
		
		cell = row.createCell(2);
		cell.setCellValue(file.getSys_name());
		
		cell = row.createCell(3);
		cell.setCellValue(file.getF_size());
		
		cell = row.createCell(4);
		cell.setCellValue(file.getRegdate());
	}
}