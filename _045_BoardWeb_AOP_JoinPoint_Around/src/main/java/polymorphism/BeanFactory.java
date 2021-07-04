package polymorphism;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
	Map<String, Object> map = new HashMap<String, Object>();
	
	public void regBean(String bean, String className) {
		try {
			map.put(bean, Class.forName(className).newInstance());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String beanName) {
		return map.get(beanName);
	}
}
