package com.liuyq.cn.ExcelUtil.utils;

import org.apache.poi.ss.usermodel.CellCopyPolicy;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public abstract class AbstractExcelExportHandler {

    protected int startRow;

    protected int startCell;

    protected int rowIndex = 0;

    public AbstractExcelExportHandler(int startRow, int startCell) {
        this.startRow = startRow;
        this.startCell = startCell;
    }

    protected int getLastRowIndex() {
        return rowIndex + startRow - 1;
    }

    protected XSSFRow getLastRow(XSSFSheet sheet) {
        if(rowIndex == 0) {
            return getRow(sheet, rowIndex);
        }
        return getRow(sheet, rowIndex - 1);
    }

    protected XSSFRow getRow(XSSFSheet sheet, int rowIndex) {
        return sheet.getRow(rowIndex + startRow);
    }

    /**
     * 复制计算公式
     * @param sheet
     */
    protected void copyCellFormulaAndStyle(XSSFSheet sheet) {
        int rowIndex = this.rowIndex - 1;
        if(rowIndex > 0) {
            XSSFRow lastRow = getRow(sheet, rowIndex - 1);
            XSSFRow row = getRow(sheet, rowIndex);
            CellCopyPolicy policy = new CellCopyPolicy();
            for(int i = startCell; i < lastRow.getLastCellNum(); i++) {
                XSSFCell lastCell = lastRow.getCell(i);
                if(lastCell != null) {
                    XSSFCell cell = createCell(row, i);
                    if(lastCell.getCellType() == CellType.FORMULA) {
                        String formula = lastCell.getCellFormula();
                        cell.copyCellFrom(lastCell, policy);
                        cell.setCellFormula(formula.replaceAll("([A-Z]+)" + (lastRow.getRowNum() + 1), "$1" + (row.getRowNum() + 1)));
                    }
                    cell.setCellStyle(lastCell.getCellStyle());
                }
            }
        }
    }

    /**
     * 创建行
     * @param sheet
     * @return
     */
    protected XSSFRow createRow(XSSFSheet sheet) {
        XSSFRow row = sheet.getRow(rowIndex + startRow);
        if(row == null) {
            row = sheet.createRow(rowIndex + startRow);
        }
        rowIndex++;
        return row;
    }

    /**
     * 创建单元格
     * @param row
     * @param cellIndex
     * @return
     */
    protected XSSFCell createCell(XSSFRow row, int cellIndex) {
        XSSFCell cell = row.getCell(cellIndex + startCell);
        if(cell == null) {
            cell = row.createCell(cellIndex + startCell);
        }
        return cell;
    }

}
