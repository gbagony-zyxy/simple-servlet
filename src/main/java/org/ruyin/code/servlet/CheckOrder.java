package org.ruyin.code.servlet;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;

public class CheckOrder implements Runnable{

	private AsyncContext asyncContext = null;
	
	public CheckOrder(AsyncContext asyncContext) {
		this.asyncContext = asyncContext;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(3000);
			PrintWriter out = asyncContext.getResponse().getWriter();
			out.print("Let's go! " +new Date());
			out.flush();
			asyncContext.complete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
