package com.everm.log;

public class JobInfo {
	private String jobId;
	private String userId;
	private String jobPrinterType;
	private String jobProcessPhaseType;
	private long jobProcessTotalTime;
	private long convertTotalTime;
	private long convertOriginDowloadTime;
	private long convertPdfUploadTime;
	private long convertPdfDowloadTime;
	private long convertPdlUploadTime;
	private long convertPdlCompressTime;
	private long convertPdfTime;
	private long convertPdlTime;
	private long sqsTime;
	private String originFileName;
	private long originFileSize;
	private String pdfFileName;
	private long pdfFileSize;
	private String pdlFileName;
	private long pdlFileSize;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJobPrinterType() {
		return jobPrinterType;
	}
	public void setJobPrinterType(String jobPrinterType) {
		this.jobPrinterType = jobPrinterType;
	}
	public String getJobProcessPhaseType() {
		return jobProcessPhaseType;
	}
	public void setJobProcessPhaseType(String jobProcessPhaseType) {
		this.jobProcessPhaseType = jobProcessPhaseType;
	}
	public long getJobProcessTotalTime() {
		return jobProcessTotalTime;
	}
	public void setJobProcessTotalTime(long jobProcessTotalTime) {
		this.jobProcessTotalTime = jobProcessTotalTime;
	}
	public long getConvertTotalTime() {
		return convertTotalTime;
	}
	public void setConvertTotalTime(long convertTotalTime) {
		this.convertTotalTime = convertTotalTime;
	}
	public long getConvertOriginDowloadTime() {
		return convertOriginDowloadTime;
	}
	public void setConvertOriginDowloadTime(long convertOriginDowloadTime) {
		this.convertOriginDowloadTime = convertOriginDowloadTime;
	}
	public long getConvertPdfUploadTime() {
		return convertPdfUploadTime;
	}
	public void setConvertPdfUploadTime(long convertPdfUploadTime) {
		this.convertPdfUploadTime = convertPdfUploadTime;
	}
	public long getConvertPdfDowloadTime() {
		return convertPdfDowloadTime;
	}
	public void setConvertPdfDowloadTime(long convertPdfDowloadTime) {
		this.convertPdfDowloadTime = convertPdfDowloadTime;
	}
	public long getConvertPdlUploadTime() {
		return convertPdlUploadTime;
	}
	public void setConvertPdlUploadTime(long convertPdlUploadTime) {
		this.convertPdlUploadTime = convertPdlUploadTime;
	}
	public long getConvertPdlCompressTime() {
		return convertPdlCompressTime;
	}
	public void setConvertPdlCompressTime(long convertPdlCompressTime) {
		this.convertPdlCompressTime = convertPdlCompressTime;
	}
	public long getConvertPdfTime() {
		return convertPdfTime;
	}
	public void setConvertPdfTime(long convertPdfTime) {
		this.convertPdfTime = convertPdfTime;
	}
	public long getConvertPdlTime() {
		return convertPdlTime;
	}
	public void setConvertPdlTime(long convertPdlTime) {
		this.convertPdlTime = convertPdlTime;
	}
	public long getSqsTime() {
		return sqsTime;
	}
	public void setSqsTime(long sqsTime) {
		this.sqsTime = sqsTime;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public long getOriginFileSize() {
		return originFileSize;
	}
	public void setOriginFileSize(long originFileSize) {
		this.originFileSize = originFileSize;
	}
	public String getPdfFileName() {
		return pdfFileName;
	}
	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}
	public long getPdfFileSize() {
		return pdfFileSize;
	}
	public void setPdfFileSize(long pdfFileSize) {
		this.pdfFileSize = pdfFileSize;
	}
	public String getPdlFileName() {
		return pdlFileName;
	}
	public void setPdlFileName(String pdlFileName) {
		this.pdlFileName = pdlFileName;
	}
	public long getPdlFileSize() {
		return pdlFileSize;
	}
	public void setPdlFileSize(long pdlFileSize) {
		this.pdlFileSize = pdlFileSize;
	}

}