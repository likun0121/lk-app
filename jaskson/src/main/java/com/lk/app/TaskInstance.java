package com.lk.app;

import java.util.Date;
import java.util.UUID;

public class TaskInstance {
	
	public static enum InstanceStatus {
		EXCEPTION,
		SUCCESS,FAILED,EXEC_ING
	}
	private String id;
	private String archiveTaskId;
	private String originalId;
	private String taskName;
	private String instanceType;
	private InstanceStatus status;
	private String execParameters;
	private String email;
	private String sftp;
	private Date modifyDataTime;
	private Date createDataTime;
	private String workDir;
	private String reportName;
	private String attachName;
	private String exceptionMessage;
	private String reportId;
	private Date lastStartDatetime;
	private Date lastStopDatetime;
	private String errorMailAddress;
	private String fileName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArchiveTaskId() {
		return archiveTaskId;
	}
	public void setArchiveTaskId(String archiveTaskId) {
		this.archiveTaskId = archiveTaskId;
	}
	
	public String getOriginalId() {
		return originalId;
	}
	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getInstanceType() {
		return instanceType;
	}
	public void setInstanceType(String instanceType) {
		this.instanceType = instanceType;
	}
	public InstanceStatus getStatus() {
		return status;
	}
	public void setStatus(InstanceStatus status) {
		this.status = status;
	}
	public String getExecParameters() {
		return execParameters;
	}
	public void setExecParameters(String execParameters) {
		this.execParameters = execParameters;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSftp(){
		return sftp;
	}
	public void setSftp(String sftp){
		this.sftp = sftp;
	}
	public Date getCreateDataTime() {
		return createDataTime;
	}
	public void setCreateDataTime(Date createDataTime) {
		this.createDataTime = createDataTime;
	}
	public Date getModifyDataTime() {
		return modifyDataTime;
	}
	public void setModifyDataTime(Date modifyDataTime) {
		this.modifyDataTime = modifyDataTime;
	}
	public String getWorkDir() {
		return workDir;
	}
	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public Date getLastStartDatetime() {
		return lastStartDatetime;
	}
	public void setLastStartDatetime(Date lastStartDatetime) {
		this.lastStartDatetime = lastStartDatetime;
	}
	public Date getLastStopDatetime() {
		return lastStopDatetime;
	}
	public void setLastStopDatetime(Date lastStopDatetime) {
		this.lastStopDatetime = lastStopDatetime;
	}
	public TaskInstance() {
		super();
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	
	public String getErrorMailAddress() {
		return errorMailAddress;
	}
	public void setErrorMailAddress(String errorMailAddress) {
		this.errorMailAddress = errorMailAddress;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public TaskInstance(String archiveTaskId, String originalId, String taskName,
						String instanceType, InstanceStatus status, String execParameters,
						String email, String sftp, Date modifyDataTime, Date createDataTime,
						String workDir, String reportName, String attachName, String exceptionMessage,
						String reportId, Date lastStartDateTime, Date lastStopDateTime, String errorMailAddress, String fileName) {
		super();
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.archiveTaskId = archiveTaskId;
		this.originalId = originalId;
		this.taskName = taskName;
		this.instanceType = instanceType;
		this.status = status;
		this.execParameters = execParameters;
		this.email = email;
		this.sftp = sftp;
		this.modifyDataTime = modifyDataTime;
		this.createDataTime = createDataTime;
		this.workDir = workDir;
		this.reportName = reportName;
		this.attachName = attachName;
		this.exceptionMessage = exceptionMessage;
		this.reportId = reportId;
		this.lastStartDatetime = lastStartDateTime;
		this.lastStopDatetime = lastStopDateTime;
		this.errorMailAddress=errorMailAddress;
		this.fileName=fileName;
	}
	
}
