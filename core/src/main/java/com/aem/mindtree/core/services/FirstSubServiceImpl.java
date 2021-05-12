package com.aem.mindtree.core.services;



import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component(service=FirstSubServiceInterface.class,immediate=true)
public class FirstSubServiceImpl implements  FirstSubServiceInterface
{
public static final Logger log=LoggerFactory.getLogger(FirstSubServiceImpl.class);

public static final String SERVICE_USER="variablename1";

@Reference
ResourceResolverFactory resolverFactory;

ResourceResolver resourceResolver;

String message;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
