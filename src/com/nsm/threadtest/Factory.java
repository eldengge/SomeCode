package com.nsm.threadtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Factory {
	
	private Lock lock = new ReentrantLock();
	
	private int goodNumber = 0;
	
	private static final int MAX = 10;
	
	private static final int MIN = 1;
	
	public void consume(){
		try {
			lock.lock();
			while(goodNumber<=MIN){
				lock.wait();
			}
			Thread.sleep(2000);
			--goodNumber;
			System.out.println(Thread.currentThread().getName()+" consume one good "+goodNumber+" goods now...");
			lock.notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			lock.unlock();
		}
	}
	
	public void production(){
		
		try {
			lock.lock();
			while(goodNumber>=MAX){
				lock.wait();
			}
			Thread.sleep(2000);
			++goodNumber;
			System.out.println(Thread.currentThread().getName()+" production one good "+goodNumber+" goods now...");
			lock.notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		Factory f =new Factory();
		
		new Thread(()->{
			while(true){
				f.consume();
			}
		},"c1").start();
		new Thread(()->{
			while(true){
				f.consume();
			}
		},"c2").start();
		new Thread(()->{
			while(true){
				f.production();
			}
		},"p1").start();
	}

}
