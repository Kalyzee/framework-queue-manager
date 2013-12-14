package com.kalyzee.framework.queuemanager.job.impl;

import java.util.HashMap;

import com.kalyzee.framework.queuemanager.job.api.IJob;

public class Job implements IJob{
	
	private int jobId;
	private HashMap<String, Object> parameters;
	
	
	public int getJobId() {
		return jobId;
	}

	
	public Object getParameter(String key) {
		return parameters.get(key);
	}
	
}
