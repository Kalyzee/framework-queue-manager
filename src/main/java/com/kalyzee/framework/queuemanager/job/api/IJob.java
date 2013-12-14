package com.kalyzee.framework.queuemanager.job.api;

public interface IJob {
	
	int getJobId();
	Object getParameter(String key);
}
