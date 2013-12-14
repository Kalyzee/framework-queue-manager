package com.kalyzee.framework.queuemanager.factories.impl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.kalyzee.framework.queuemanager.factories.api.IQueueServiceFactory;
import com.kalyzee.framework.queuemanager.factories.impl.InMemoryQueueServiceFactory;
import com.kalyzee.framework.queuemanager.service.api.IQueueService;
import com.kalyzee.framework.queuemanager.service.impl.LocalQueueService;


public class InMemoryQueueServiceFactoryTest {
	
	private IQueueServiceFactory queueServiceFactory;
	
	@Before
	public void before(){
		queueServiceFactory = new InMemoryQueueServiceFactory();
	}
	
	@Test
	public void testCreateQueueService(){
		IQueueService queueService = queueServiceFactory.createQueueService();
		Assert.assertTrue(queueService instanceof LocalQueueService);
	}

}


