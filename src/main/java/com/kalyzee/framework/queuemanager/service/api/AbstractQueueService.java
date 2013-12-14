package com.kalyzee.framework.queuemanager.service.api;

import java.util.HashMap;

import javax.swing.event.EventListenerList;

import com.kalyzee.framework.queuemanager.job.api.IJob;
import com.kalyzee.framework.queuemanager.service.listener.api.IQueueServiceListener;

public abstract class AbstractQueueService implements IQueueService{
	private EventListenerList jobEventListener = new EventListenerList();
	private HashMap<Integer, EventListenerList> listenerByJobs = new HashMap<Integer, EventListenerList>(); 
	
	
	
	public void subscribeJobEvent(IQueueServiceListener queueServiceListener,
			int jobID) {
		if(!listenerByJobs.containsKey(jobID)){
			listenerByJobs.put(jobID, new EventListenerList());
		}
		listenerByJobs.get(jobID).add(IQueueServiceListener.class, queueServiceListener);
	}

	
	public void unSuscribeJobEvent(IQueueServiceListener queueServiceListener, int jobID){
		if(!listenerByJobs.containsKey(jobID)){
			listenerByJobs.get(jobID).remove(IQueueServiceListener.class, queueServiceListener);	
		}
	}

	
	public void fireJobAdded(IJob job){
		for (IQueueServiceListener queueServiceListener : getQueueServiceListenersByJob(job)){
			queueServiceListener.onJobAdded(job);
		}
	}


	public void fireJobException(IJob job){
		for (IQueueServiceListener queueServiceListener : getQueueServiceListenersByJob(job)){
			queueServiceListener.onJobException(job);
		}
	}

	public void fireJobCanceled(IJob job){
		for (IQueueServiceListener queueServiceListener : getQueueServiceListenersByJob(job)){
			queueServiceListener.onJobCanceled(job);
		}
	}
	

	public void fireJobStarted(IJob job){
		for (IQueueServiceListener queueServiceListener : getQueueServiceListenersByJob(job)){
			queueServiceListener.onJobAdded(job);
		}
	}
	
	public void fireJobFinished(IJob job){
		for (IQueueServiceListener queueServiceListener : getQueueServiceListenersByJob(job)){
			queueServiceListener.onJobFinished(job);
		}
	}
	
	public void subscribeJobEvents(IQueueServiceListener queueServiceListener) {
		jobEventListener.add(IQueueServiceListener.class, queueServiceListener);
	}
	
	
	public void unSubscribeJobEvents(IQueueServiceListener queueServiceListener) {
		jobEventListener.remove(IQueueServiceListener.class, queueServiceListener);
	
	}
	
	protected IQueueServiceListener[] getQueueServiceListeners(){
		return jobEventListener.getListeners(IQueueServiceListener.class);
	}
	
	/**
	 * 
	 * @param job
	 * @return getQueueServiceListeners() + getQueueServiceListenersByJob()
	 */
	protected IQueueServiceListener[] getQueueServiceListenersByJob(IJob job){
		
		IQueueServiceListener[] allWithoutJobID = getQueueServiceListeners();
		IQueueServiceListener[] result = allWithoutJobID;
		if (listenerByJobs.containsKey(job.getJobId()) && listenerByJobs.get(job.getJobId()) != null){
			IQueueServiceListener[] queueListenerByJobId = listenerByJobs.get(job.getJobId()).getListeners(IQueueServiceListener.class);
			result = new IQueueServiceListener[allWithoutJobID.length + queueListenerByJobId.length];
			for (int i=0; i<allWithoutJobID.length; i++){
				result[i] = allWithoutJobID[i];
			}
			for (int i=0; i<queueListenerByJobId.length; i++){
				result[allWithoutJobID.length-1+i] = queueListenerByJobId[i];
			}
		}
		return result;
	}
}
