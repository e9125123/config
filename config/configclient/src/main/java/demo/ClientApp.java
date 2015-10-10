package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RefreshScope
public class ClientApp {
	
	private static Logger logger = LoggerFactory.getLogger("hgfhg");
	
    @Value("${bar:World!}")
    String bar;
    
    @Value("${parent:???}")
    String parent;
    
    @Value("${child:???}")
    String child;

    @RequestMapping("/")
    String hello() {
    	logger.debug("deb");
    	logger.info("info");
    	
        return "Hello " + bar + "!"+parent+"/"+child;
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientApp.class, args);
    }
}