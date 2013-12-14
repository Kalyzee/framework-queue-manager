package com.kalyzee.framework.queuemanager.factories.api;

import com.kalyzee.framework.queuemanager.service.api.IQueueService;

public interface IQueueServiceFactory {
	IQueueService createQueueService();
}
