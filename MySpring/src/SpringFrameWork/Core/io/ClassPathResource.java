package SpringFrameWork.Core.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource extends AbstractResource {

	
	public String path;
	
	public ClassPathResource(String path)
	{
		this.path=path;
	}
	
	
	@Override
	public InputStream getInputStream() throws IOException {

		InputStream is=null;
		
		is= ClassLoader.getSystemResourceAsStream(this.path);
		
		return is;
	}

}
