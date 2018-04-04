package com.study.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.study.data.DataCenter;

public class WebContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 初始化方法
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		DataCenter dataCenter = DataCenter.getInstance();
		dataCenter.init();
	}

}
