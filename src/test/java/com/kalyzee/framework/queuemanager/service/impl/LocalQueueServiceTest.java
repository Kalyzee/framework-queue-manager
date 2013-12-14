package com.kalyzee.framework.queuemanager.service.impl;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.kalyzee.framework.queuemanager.job.api.IJob;
import com.kalyzee.framework.queuemanager.job.impl.Job;
import com.kalyzee.framework.queuemanager.service.listener.api.IQueueServiceListener;

public class LocalQueueServiceTest {
	
	private LocalQueueService queueService;
	private ListenerTester listenerTester;
	
	@Before
	public void before(){
		listenerTester = new ListenerTester();
		queueService = new LocalQueueService();
		queueService.subscribeJobEvents(listenerTester);
	}
	
	@Test
	public void testAddJob(){
		queueService.addJob(new Job());
		Assert.assertTrue(listenerTester.getOk());
		listenerTester.init();
		queueService.getNextJob();
		Assert.assertTrue(listenerTester.getOk());
	}
	
}

class ListenerTester implements IQueueServiceListener{
	private boolean ok;

	public void onJobAdded(IJob job) {
		ok = true;
	}

	public void onJobException(IJob job) {
		ok = true;
	}

	public void onJobStarted(IJob job) {
		ok = true;
	}

	public void onJobFinished(IJob job) {
		ok = true;
	}

	public void onJobCanceled(IJob job) {
		ok = true;
	}
	
	public void init(){
		ok = false;
	}
	
	public boolean getOk(){
		return ok;
	}
	
}