package com.liuyq.cn.ExcelUtil.excel;

import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.liuyq.cn.ExcelUtil.utils.AbstractExcelExportHandler;
import com.liuyq.cn.ExcelUtil.utils.IExcelExportHandler;




public class SummaryProductExcelExportHandler extends AbstractExcelExportHandler implements IExcelExportHandler<Map<String, Object>> {

	String[] keyArr;
	String[] titleArr;
	
    public SummaryProductExcelExportHandler(String[] keyArr,String[] titleArr) {
        super(0, 0);
        this.keyArr = keyArr;
        this.titleArr = titleArr;
    }

    private void createHeader(XSSFSheet sheet) {
        XSSFRow row = createRow(sheet);
        
        for(int  i=0;i<titleArr.length;i++) {
        	createCell(row, i).setCellValue(titleArr[i]);
        }
    }

    @Override
    public void export(XSSFSheet sheet, List<Map<String, Object>> datas) {
        this.rowIndex = 0;
        createHeader(sheet);

        if(datas != null && datas.size() > 0) {
            for(Map<String, Object> map : datas) {
                export(sheet, map);
            }
        }
    }

    private void export(XSSFSheet sheet, Map<String, Object> map) {
        XSSFRow row = createRow(sheet);
        for(int  i=0;i<keyArr.length;i++) {
        	createCell(row, i).setCellValue(map.get(keyArr[i])+"");
        }
    }

    
}
