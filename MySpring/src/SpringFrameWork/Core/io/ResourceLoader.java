package SpringFrameWork.Core.io;





public interface ResourceLoader {

	String CLASSPATH_URL_PREFIX ="CLASSPATH";
	
	Resource getResource(String location);
	
}
