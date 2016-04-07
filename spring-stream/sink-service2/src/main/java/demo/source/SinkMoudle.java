package demo.source;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


/**
 * 接受消息
 * @author hushuming
 *
 */
@EnableBinding(Sink.class)
public class SinkMoudle {
	
	
	/**
	 * @StreamListener,在自动格式转换方面要优于 @ServiceActivator
	 * @param payload
	 */
	@StreamListener(Sink.INPUT)
	public void loggerSink(Object payload) {
		System.out.println("Received from sink2: " + payload);
	}


}
