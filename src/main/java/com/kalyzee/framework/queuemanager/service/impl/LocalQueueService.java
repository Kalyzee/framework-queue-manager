package com.kalyzee.framework.queuemanager.service.impl;

import java.util.PriorityQueue;
import java.util.Queue;


import com.kalyzee.framework.queuemanager.job.api.IJob;
import com.kalyzee.framework.queuemanager.service.api.AbstractQueueService;
import com.kalyzee.framework.queuemanager.service.api.IQueueService;

public class LocalQueueService extends AbstractQueueService implements IQueueService{
	
	private Queue<IJob> jobs = new PriorityQueue<IJob>();

	
	public void addJob(IJob job){
		jobs.add(job);
		fireJobAdded(job);
	}
	
	public void cancelJob(IJob job){
		jobs.remove(job);
		fireJobCanceled(job);
	}
	
	
	public IJob getNextJob() {
		IJob job = jobs.poll();
		fireJobStarted(job);
		return job;
		
	}


}
