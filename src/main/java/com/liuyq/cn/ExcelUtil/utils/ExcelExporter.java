package com.liuyq.cn.ExcelUtil.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelExporter {

    private XSSFWorkbook workbook;

    /**
     * 根据模板文件创建excel文件
     * @param templateFile
     * @throws Exception
     */
    public void create(InputStream templateFile) throws Exception {
        if(templateFile == null) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook(templateFile);
        }
    }

    public void create() throws Exception {
        create(null);
    }

    public void export(OutputStream os) throws Exception {
        if(workbook == null) {
//            throw new BusinessException("8001", "请先创建workbook再导出");
            throw new Exception("请先创建workbook再导出");
        }
        if(os != null) {
            try {
                workbook.write(os);
                os.flush();
            } finally {
                workbook.close();
            }
        }
    }

    /**
     * 获取sheet，如果没有，则创建一个
     * @param name
     * @return
     */
    private XSSFSheet createSheet(String name) throws Exception {
        if(workbook == null) {
            create();
        }
        XSSFSheet sheet = workbook.getSheet(name);
        if(sheet == null) {
            sheet = workbook.createSheet(name);
        }
        return sheet;
    }

    /**
     * 导出数据
     * @param name
     * @param datas
     */
    public <T> void exportData(String name, List<T> datas, IExcelExportHandler<T> handler) throws Exception {
        handler.export(createSheet(name), datas);
    }

}
