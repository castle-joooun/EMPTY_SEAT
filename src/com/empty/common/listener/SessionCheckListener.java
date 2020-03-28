package com.empty.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCheckListener
 *
 */
@WebListener
public class SessionCheckListener implements HttpSessionListener, HttpSessionAttributeListener {
	private static int lifeCount=0;
	private static int sessionCount=0;
	
    public SessionCheckListener() {}

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	lifeCount++;
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	lifeCount--;
    }

    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
    	sessionCount++;
    }

    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
    	sessionCount--;
    }

    public void attributeReplaced(HttpSessionBindingEvent arg0)  {}

	public static int getLifeCount() {
		return lifeCount;
	}

	public static int getSessionCount() {
		return sessionCount;
	}
	
}