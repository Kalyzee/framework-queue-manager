package com.kalyzee.framework.queuemanager.service.api;

import com.kalyzee.framework.queuemanager.job.api.IJob;
import com.kalyzee.framework.queuemanager.service.listener.api.IQueueServiceListener;

public interface IQueueService {
	
	void addJob(IJob job);
	void cancelJob(IJob job);
	void subscribeJobEvent(IQueueServiceListener queueServiceListener, int jobID);
	public void unSuscribeJobEvent(IQueueServiceListener queueServiceListener, int jobID);
	
	void subscribeJobEvents(IQueueServiceListener queueServiceListener);
	void unSubscribeJobEvents(IQueueServiceListener queueServiceListener);

	IJob getNextJob();
}
