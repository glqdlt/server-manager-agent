package com.glqdlt.servermanageragent;

import com.glqdlt.servermanageragent.utill.TerminalHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@ComponentScan("com.glqdlt.servermanageragent.**")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerManagerAgentApplicationTests {


	@Test
	public void contextLoads() {
	}


	@Test
	public void terminalFunction(){
		TerminalHandler.getInstance().getIp();
	}

}
