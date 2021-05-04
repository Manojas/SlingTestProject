package com.aem.mindtree.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables=SlingHttpServletRequest.class,
adapters=SlingTestInterface.class,
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class SlingTestImpl implements SlingTestInterface{

	@ValueMapValue
	List<String> names;
	//i have changed something.
	@ValueMapValue
	String pathBrowser;

	@ValueMapValue
	Boolean isIndian;
	//this is boolean
	@ValueMapValue
	String gender;
	@ValueMapValue
	String fileReference;
	
	@Override
	public List<String> getNames() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public String getPathBrowser() {
		// TODO Auto-generated method stub
		return pathBrowser;
	}

	@Override
	public Boolean getIsIndian() {
		// TODO Auto-generated method stub
		return isIndian;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return gender;
	}

	@Override	
	public String getFileReference() {
		// TODO Auto-generated method stub
		return fileReference;
	}

}
