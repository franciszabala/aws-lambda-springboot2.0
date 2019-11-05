package my.service.now;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.AwsProxyExceptionHandler;
import com.amazonaws.serverless.proxy.AwsProxySecurityContextWriter;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import my.service.custom.CustomRequest;
import my.service.custom.CustomRequestReader;
import my.service.custom.CustomResponse;
import my.service.custom.CustomResponseWriter;


public class StreamLambdaHandler implements RequestStreamHandler {
//    private static SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
//    static {
//        try {
//            handler = SpringLambdaContainerHandler.getAwsProxyHandler(SpringApiConfig.class);
//        } catch (ContainerInitializationException e) {
//            // if we fail here. We re-throw the exception to force another cold start
//            e.printStackTrace();
//            throw new RuntimeException("Could not initialize Spring framework", e);
//        }
//    }

	
	private static SpringLambdaContainerHandler<CustomRequest, CustomResponse> handler;
    static {
        try {
            AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
            applicationContext.register(SpringApiConfig.class);
            handler = new SpringLambdaContainerHandler<>(
                CustomRequest.class,
                CustomResponse.class,
                new CustomRequestReader(),
                new CustomResponseWriter(),
                new AwsProxySecurityContextWriter(),
                new AwsProxyExceptionHandler(),
                applicationContext
            );
        } catch (ContainerInitializationException e) {
            // if we fail here. We re-throw the exception to force another cold start
            e.printStackTrace();
            throw new RuntimeException("Could not initialize Spring framework", e);
        }
    }
    
    
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context)
            throws IOException {
        handler.proxyStream(inputStream, outputStream, context);
    }
}