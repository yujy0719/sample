package collection.bean.di;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectioinBeanMain {
	public static void main(String[] args) {
		AbstractApplicationContext factory = 
			new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionProperties properties = 
				(CollectionProperties)factory.getBean("collectionProperties");
		Properties addressProperties = properties.getAddressProperties();
		for(Object name : addressProperties.keySet())
			System.out.println(name + " : " + addressProperties.get(name));
		
		factory.close();
	}
}
