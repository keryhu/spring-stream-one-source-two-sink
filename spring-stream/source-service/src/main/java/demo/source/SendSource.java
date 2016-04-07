package demo.source;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;

@EnableBinding(Source.class)
/**
 * send time message periodicity
 * @author hushuming
 *
 */
public class SendSource {
	
	private String format = "yyyy-MM-dd HH:mm:ss";
	
	
	
	@Bean
	@InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "1"))
	 public MessageSource<String>  send(){
		
		return ()->MessageBuilder.withPayload(new SimpleDateFormat(this.format).format(new Date())).build();
	}
	 
	


}
