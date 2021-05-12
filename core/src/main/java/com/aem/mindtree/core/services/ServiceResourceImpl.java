package com.aem.mindtree.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.osgi.service.component.propertytypes.ServiceDescription;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = ServiceResourceInterface.class, immediate = true)
//@ServiceDescription("Description of subservice")
public class ServiceResourceImpl implements ServiceResourceInterface {

	@Reference
	ResourceResolverFactory resolverFactory;

	ResourceResolver resourceResolver;

	ResourceResolverFactory resourceResolverFactory;
	private static final Logger logger = LoggerFactory.getLogger(ServiceResourceImpl.class);

	@Override
	public Map<String, Object> getPageInformation() {
		// TODO Auto-generated method stub
		Map<String, Object> information = null;

		information = new HashMap<String, Object>();
		Resource resource = resourceResolver.getResource("/apps/SlingTest/components/content/StyleExmp");

		information.put("title", resource.getName());
		information.put("path", resource.getPath());
		information.put("If true it has children", resource.hasChildren());

		if (resource.hasChildren()) {
			Iterator<Resource> childrenResources = resource.listChildren();

			List<String> childrenPageNames = new ArrayList<String>();
			while (childrenResources.hasNext()) {
				Resource childrenResource = childrenResources.next();

				childrenPageNames.add(childrenResource.getName());

			}
			information.put("Childreninformation", childrenPageNames);
		}

		return information;
	}

	@Activate
	@Modified
	public void activate() throws LoginException {

		final String SUBSERVICE = "firstsubservice";
		resourceResolver = getResolver(resourceResolverFactory, SUBSERVICE);

		logger.info("Logger information");

	}

	public ResourceResolver getResolver(ResourceResolverFactory resourceResolverFactory, String SUBSERVICE)
			throws LoginException {
		ResourceResolver resourceResolver = null;

		Map<String, Object> payload = new HashMap<String, Object>();
		payload.put(ResourceResolverFactory.SUBSERVICE, SUBSERVICE);

		resourceResolver = resourceResolverFactory.getServiceResourceResolver(payload);

		return resourceResolver;

	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		String path = "";
		Resource res2 = resourceResolver.getResource("/content/SlingTest/en");

		path = res2.getPath();
		return path;
	}

}
