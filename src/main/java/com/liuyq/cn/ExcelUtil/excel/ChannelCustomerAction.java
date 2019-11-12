package com.liuyq.cn.ExcelUtil.excel;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuyq.cn.ExcelUtil.bean.Orders;
import com.liuyq.cn.ExcelUtil.utils.DownloadUtils;
import com.liuyq.cn.ExcelUtil.utils.ExcelExporter;
import com.liuyq.cn.ExcelUtil.utils.IExcelExportHandler;


@Controller
public class ChannelCustomerAction {

    
	/**
	 * Excel导出测试
	 * 	访问路径url： http://localhost:8080/exportExcel
	 */
	@RequestMapping("/exportExcel")
    public void exportSummaryProduct(HttpServletRequest request, HttpServletResponse response
    		) throws Exception {
    	
    	
    	List<Map<String,Object>> dataList = new ArrayList<>();
    	Map<String,Object> map = null;
    	for(int i=0;i<5;i++) {
    		map = new HashMap<String, Object>();
    		map.put("id", i);
    		map.put("name", "师妃暄");
    		map.put("age", 20+i);
    		map.put("sex", "女");
    		map.put("book", "《大唐双龙传》");
    		dataList.add(map);
    	}
    	
        String fileName = "产品数据分析.xlsx";
        String[] keyArr = new String[] {"id","name","age","sex","book"};
        String[] titleArr = new String[] {"序号","姓名","年龄","性别","出处"};
        
        IExcelExportHandler<Map<String, Object>> exportHandler = new SummaryProductExcelExportHandler(keyArr,titleArr);
        ExcelExporter excelExporter = new ExcelExporter();

        if(dataList!=null && dataList.size()>0) {
            excelExporter.exportData(fileName,dataList, exportHandler);
        }else {
            throw new Exception("Excel导出数据为空");
        }

        excelExporter.export(DownloadUtils.getOutputStream(request, response, fileName));
    }

    
	/**
	 * Excel导出测试
	 * 	访问路径url： http://localhost:8080/exportExcelOrders
	 */
	@RequestMapping("/exportExcelOrders")
	public void exportOrders(HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		
		List<Orders> dataList = new ArrayList<>();
		Orders o = null;
		for(int i=0;i<5;i++) {
			o = new Orders();
			o.setOrderNumber("num"+i);
			o.setMobile("mobile_"+i);
			o.setQq("QQ_"+i);
			o.setWeixin("weixin_"+i);
			o.setBuyTime(new Date());
			dataList.add(o);
		}
		
		String fileName = "订单详情.xlsx";
		
		IExcelExportHandler<Orders> exportHandler = new OrdersExcelExportHandler();
		ExcelExporter excelExporter = new ExcelExporter();
		
		if(dataList!=null && dataList.size()>0) {
			excelExporter.exportData(fileName,dataList, exportHandler);
		}else {
			throw new Exception("Excel导出数据为空");
		}
		
		excelExporter.export(DownloadUtils.getOutputStream(request, response, fileName));
	}
	
	
    
    
    
}
