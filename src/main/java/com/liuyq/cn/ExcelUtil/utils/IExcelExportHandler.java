package com.liuyq.cn.ExcelUtil.utils;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public interface IExcelExportHandler<T> {

    public void export(XSSFSheet sheet, List<T> datas);

}
