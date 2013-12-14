package com.kalyzee.framework.queuemanager.factories.impl;

import com.kalyzee.framework.queuemanager.factories.api.IQueueServiceFactory;
import com.kalyzee.framework.queuemanager.service.api.IQueueService;
import com.kalyzee.framework.queuemanager.service.impl.LocalQueueService;

public class InMemoryQueueServiceFactory implements IQueueServiceFactory{

	
	public IQueueService createQueueService() {
		return new LocalQueueService();
	}
	
}
