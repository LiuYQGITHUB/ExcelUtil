package com.liuyq.cn.ExcelUtil.bean;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Orders {

	private static final long serialVersionUID = 1L;
	
    /**
	 * 客户方订单号
	*/
	private String orderNumber;
	
	/**
	 * 权益产品id（冗余字段，根据用户订购的权益产品id）
	*/
	private Long productId;
	
	/**
	 * 供货商id，冗余字段，即权益产品的供货商id。关联system_user表的id。
	*/
	private Long supplierId;
	
	/**
	 * B端的渠道或客户id，关联system_user表的id字段。
	*/
	private Long customerId;
	
	/**
	 * C端的订购用户手机号码
	*/
	private String mobile;
	
	/**
	 * C端的订购用户qq号
	*/
	private String qq;
	
	/**
	 * C端的订购用户微信号。
	*/
	private String weixin;
	
	/**
	 * C端用户订购数目
	*/
	private Integer counts;
	
	/**
	 * C端订购单价，单位（元）。
	*/
	private BigDecimal price;
	
	/**
	 * 订购成功或失败的时间。
	*/
	private Date buyTime;
	
	/**
	 * 是否订购成功。1是0否。
	*/
	private Boolean isSuccess;
	
	/**
	 * 月份（冗余字段，根据用户订购时间来的，从1到12），根据buy_time得来。
	*/
	private Integer month;
	
	/**
	 * 年份（冗余字段，根据用户订购的时间来），根据buy_time得来。
	*/
	private Integer year;
	
	/**
	 * 日期（冗余字段，根据用户订购的时间来，从1到31），根据buy_time得来。
	*/
	private Integer dates;
	
	/**
	 * 提交到科创或向科创查询返回的code
	*/
	private String kcCode;
	
	/**
	 * 提交到科创或向科创查询返回的提示信息
	*/
	private String kcMessage;
	
	/**
	 * 提交次数。提交一次，失败时过2分钟重试一次。共2次。
	*/
	private Integer submitCount;
	
	/**
	 * 异步回调客户的url
	*/
	private String callbackUrl;
	
	/**
	 * 回调客户状态，0待回调，1回调成功，2回调失败。
	*/
	private Integer callbackStatus;
	
	/**
	 * 回调客户失败次数。
	*/
	private Integer callbackFailCount;
	
	/**
	 * 最后回调时间
	*/
	private Date callbackTime;
	
	/**
	 * 订单处理状态。0收到客户请求刚生成，1已提交科创订购处理中，2科创已返回成功，3科创已返回失败，6超时关闭。
	*/
	private Integer processStatus;
	
	/**
	 * 是否逻辑删除，1是0否。
	*/
	private Integer isDelete;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getQq() {
		return qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getWeixin() {
		return weixin;
	}
	
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
	public Integer getCounts() {
		return counts;
	}
	
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public Date getBuyTime() {
		return buyTime;
	}
	
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	
	public Boolean getIsSuccess() {
		return isSuccess;
	}
	
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public Integer getMonth() {
		return month;
	}
	
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getDates() {
		return dates;
	}
	
	public void setDates(Integer dates) {
		this.dates = dates;
	}
	
	public String getKcCode() {
		return kcCode;
	}
	
	public void setKcCode(String kcCode) {
		this.kcCode = kcCode;
	}
	
	public String getKcMessage() {
		return kcMessage;
	}
	
	public void setKcMessage(String kcMessage) {
		this.kcMessage = kcMessage;
	}
	
	public Integer getSubmitCount() {
		return submitCount;
	}
	
	public void setSubmitCount(Integer submitCount) {
		this.submitCount = submitCount;
	}
	
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	public Integer getCallbackStatus() {
		return callbackStatus;
	}
	
	public void setCallbackStatus(Integer callbackStatus) {
		this.callbackStatus = callbackStatus;
	}
	
	public Integer getCallbackFailCount() {
		return callbackFailCount;
	}
	
	public void setCallbackFailCount(Integer callbackFailCount) {
		this.callbackFailCount = callbackFailCount;
	}
	
	public Date getCallbackTime() {
		return callbackTime;
	}
	
	public void setCallbackTime(Date callbackTime) {
		this.callbackTime = callbackTime;
	}
	
	public Integer getProcessStatus() {
		return processStatus;
	}
	
	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}
	
	public Integer getIsDelete() {
		return isDelete;
	}
	
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
	


	/**
	 * 订购状态，用于导出订单详情到Excel展示。
	 */
	public String getOrderStatus() {
		// 是否订购成功。1是0否
		Boolean orderStatus = this.getIsSuccess();

		if (orderStatus == null) {
			return "未知";
		} else if (!orderStatus) {
			return "订购失败";
		} else if (orderStatus) {
			return "订购成功";
		}
		return "未知";
	}

	/**
	 * 订购时间，用于导出订单详情到Excel展示。
	 */
	public String getOrderTime() {
		// 订购时间，Date类型
		Date buyTime = this.getBuyTime();

		if (null == buyTime) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String orderTime = sdf.format(buyTime);

		return orderTime;
	}

}