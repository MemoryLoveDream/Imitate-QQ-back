package com.example.easychat;

import com.example.easychat.netty.WSServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NettyStarter implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent()==null) {
			try {
				WSServer.getInstance().start();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
	}

}
