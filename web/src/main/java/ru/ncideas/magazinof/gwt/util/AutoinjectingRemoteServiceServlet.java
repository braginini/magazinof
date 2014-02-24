package ru.ncideas.magazinof.gwt.util;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class AutoinjectingRemoteServiceServlet extends RemoteServiceServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(config.getServletContext());
		AutowireCapableBeanFactory beanFactory = ctx.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

}
