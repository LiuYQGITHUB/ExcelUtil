package com.liuyq.cn.ExcelUtil.excel;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.liuyq.cn.ExcelUtil.bean.Orders;
import com.liuyq.cn.ExcelUtil.utils.AbstractExcelExportHandler;
import com.liuyq.cn.ExcelUtil.utils.IExcelExportHandler;




public class OrdersExcelExportHandler extends AbstractExcelExportHandler implements IExcelExportHandler<Orders> {

    public OrdersExcelExportHandler() {
        super(0, 0);
    }

    private void createHeader(XSSFSheet sheet) {
        XSSFRow row = createRow(sheet);

        createCell(row, 0).setCellValue("订单号");
        createCell(row, 1).setCellValue("手机号");
        createCell(row, 2).setCellValue("QQ号");
        createCell(row, 3).setCellValue("微信号");
        createCell(row, 4).setCellValue("订购状态");
        createCell(row, 5).setCellValue("订购时间");
    }

    @Override
    public void export(XSSFSheet sheet, List<Orders> datas) {
        this.rowIndex = 0;
        createHeader(sheet);

        if(datas != null && datas.size() > 0) {
            for(Orders orders : datas) {
                export(sheet, orders);
            }
        }
    }

    private void export(XSSFSheet sheet, Orders orders) {
        XSSFRow row = createRow(sheet);
        createCell(row, 0).setCellValue(orders.getOrderNumber());
        createCell(row, 1).setCellValue(orders.getMobile());
        createCell(row, 2).setCellValue(orders.getQq());
        createCell(row, 3).setCellValue(orders.getWeixin());
        createCell(row, 4).setCellValue(orders.getOrderStatus());
        createCell(row, 5).setCellValue(orders.getOrderTime());
    }
    
}
