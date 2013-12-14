package com.kalyzee.framework.queuemanager.service.listener.api;

import java.util.EventListener;

import com.kalyzee.framework.queuemanager.job.api.IJob;

public interface IQueueServiceListener extends EventListener{
	void onJobAdded(IJob job);
	void onJobException(IJob job);
	void onJobStarted(IJob job);
	void onJobFinished(IJob job);
	void onJobCanceled(IJob job);
}
