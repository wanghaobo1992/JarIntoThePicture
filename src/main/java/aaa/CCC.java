package aaa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.web.AAAA;

public class CCC {

	public static void main(String[] args) throws IOException {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		AAAA aa = (AAAA) ctx.getBean("aaaa");
		
		System.out.println(aa.getImgs().getInputStream());
		
		byte[] bytes = new byte[1024];
		
		InputStream in = aa.getImgs().getInputStream();
		
		OutputStream out = new FileOutputStream(new File("D:/aaa.jpg"));
		
		int a = 0;
		
		while(( a = in.read(bytes)) != -1){
//			System.out.println(a);
			out.write(bytes, 0, a);
			out.flush();
		}
		in.close();
		out.close();
		
	}

}
