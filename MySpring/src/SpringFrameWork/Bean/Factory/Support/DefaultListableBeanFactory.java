package SpringFrameWork.Bean.Factory.Support;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;















import SpringFrameWork.Bean.Factory.BeanFactory;
import SpringFrameWork.Bean.Factory.Config.BeanDefinition;

public  class DefaultListableBeanFactory implements BeanFactory ,BeanDefinitionRegistry{

	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
	
	private final Map<Class<?>, String[]> allBeanNamesByType = new HashMap<Class<?>, String[]>();

	private  List<String> beanDefinitionNames = new ArrayList<String>();

	
	
	public DefaultListableBeanFactory ()
	{
		
	}
	
	@Override
	public Object getBean(String name) {
		
		String path=this.getBeanDefinition(name).getClasspath();
		
		try {
			return Class.forName(path).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T getBean(String name, Class<T> requiredType) {
		
		String path=this.getBeanDefinition(name).getClasspath();
		
		try {
			if(Class.forName(path) == requiredType)
			{
				
					return (T) Class.forName(path).newInstance();
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public <T> T getBean(Class<T> requiredType) {
		
		for(String name:this.getBeanDefinitionNames())
		{
			String path=this.getBeanDefinition(name).getClasspath();
			
			try {
				if(Class.forName(path) == requiredType)
				{
					
						return (T) Class.forName(path).newInstance();
					
				}
			} catch (Exception e) {
				
			}
		}
		
		return null;
	}

	@Override
	public boolean containsBean(String name) {
		
		for(String temp:this.getBeanDefinitionNames())
		{
			if(name.equals(temp))
			{
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Class<?> getType(String name) {
		
		for(String temp:this.getBeanDefinitionNames())
		{
			if(name.equals(temp))
			{
				String path=this.getBeanDefinition(name).getClasspath();
				try {
					return Class.forName(path);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	@Override
	public String[] getAliases(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerBeanDefinition(String beanName,
			BeanDefinition beanDefinition) {

		this.beanDefinitionMap.put(beanName, beanDefinition);
	}

	@Override
	public void removeBeanDefinition(String beanName) {

		this.beanDefinitionMap.remove(beanName);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanName) {
		return this.beanDefinitionMap.get(beanName);
	}

	@Override
	public int getBeanDefinitionCount() {
		// TODO Auto-generated method stub
		return this.beanDefinitionMap.size();
	}

	@Override
	public String[] getBeanDefinitionNames() {
		return (String[]) this.beanDefinitionMap.keySet().toArray();
	}
	
	
	

}
