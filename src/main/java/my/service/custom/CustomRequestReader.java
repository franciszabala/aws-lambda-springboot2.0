package my.service.custom;

import javax.servlet.ServletContext;
import javax.ws.rs.core.SecurityContext;

import com.amazonaws.serverless.exceptions.InvalidRequestEventException;
import com.amazonaws.serverless.proxy.RequestReader;
import com.amazonaws.serverless.proxy.model.ContainerConfig;
import com.amazonaws.services.lambda.runtime.Context;

/**
 * Simple implementation of the <code>RequestReader</code> interface that receives an <code>AwsProxyRequest</code>
 * object and uses it to initialize a <code>AwsProxyHttpServletRequest</code> object.
 */

//public class CustomRequestReader extends RequestReader<CustomRequest, AwsProxyHttpServletRequest> {
public class CustomRequestReader extends RequestReader<CustomRequest, CustomHttpServletRequest> {

    private ServletContext servletContext;
    //-------------------------------------------------------------
    // Methods - Implementation
    //-------------------------------------------------------------

    public void setServletContext(ServletContext ctx) {
        servletContext = ctx;
    }
	
    @Override
    protected Class<? extends CustomRequest> getRequestClass() {
        return CustomRequest.class;
    }

	@Override
	public CustomHttpServletRequest readRequest(CustomRequest request, SecurityContext securityContext,
			Context lambdaContext, ContainerConfig config) throws InvalidRequestEventException {
		// TODO Auto-generated method stub        
		CustomHttpServletRequest servletRequest = new CustomHttpServletRequest(request, lambdaContext, securityContext, config);
        servletRequest.setServletContext(servletContext);
        //servletRequest.setAttribute(API_GATEWAY_CONTEXT_PROPERTY, request.getRequestContext());
        //servletRequest.setAttribute(API_GATEWAY_STAGE_VARS_PROPERTY, request.getStageVariables());
        servletRequest.setAttribute(API_GATEWAY_EVENT_PROPERTY, request);
        //servletRequest.setAttribute(ALB_CONTEXT_PROPERTY, request.getRequestContext().getElb());
        servletRequest.setAttribute(LAMBDA_CONTEXT_PROPERTY, lambdaContext);
        servletRequest.setAttribute(JAX_SECURITY_CONTEXT_PROPERTY, securityContext);

        return servletRequest;
	}
}

//public class CustomRequestReader extends RequestReader<CustomRequest, AwsHttpServletRequest> {
//    static final String INVALID_REQUEST_ERROR = "The incoming event is not a valid request from Amazon API Gateway or an Application Load Balancer";
//    private ServletContext servletContext;
//    //-------------------------------------------------------------
//    // Methods - Implementation
//    //-------------------------------------------------------------
//
//    public void setServletContext(ServletContext ctx) {
//        servletContext = ctx;
//    }
//
//    @Override
//    public AwsHttpServletRequest readRequest(CustomRequest request, SecurityContext securityContext, Context lambdaContext, ContainerConfig config)
//            throws InvalidRequestEventException {
//        // Expect the HTTP method and context to be populated. If they are not, we are handling an
//        // unsupported event type.
//
//    	CustomHttpServletRequest servletRequest = new CustomHttpServletRequest(request, lambdaContext, securityContext, config);
//        servletRequest.setServletContext(servletContext);
//        //servletRequest.setAttribute(API_GATEWAY_CONTEXT_PROPERTY, request.getRequestContext());
//        //servletRequest.setAttribute(API_GATEWAY_STAGE_VARS_PROPERTY, request.getStageVariables());
//        servletRequest.setAttribute(API_GATEWAY_EVENT_PROPERTY, request);
//        //servletRequest.setAttribute(ALB_CONTEXT_PROPERTY, request.getRequestContext().getElb());
//        servletRequest.setAttribute(LAMBDA_CONTEXT_PROPERTY, lambdaContext);
//        servletRequest.setAttribute(JAX_SECURITY_CONTEXT_PROPERTY, securityContext);
//
//        return servletRequest;
//    }
//
//    //-------------------------------------------------------------
//    // Methods - Protected
//    //-------------------------------------------------------------
//
//    @Override
//    protected Class<? extends CustomRequest> getRequestClass() {
//        return CustomRequest.class;
//    }
//    //-------------------------------------------------------------
//    // Methods - Private
//    //-------------------------------------------------------------
//
//    private String getContentTypeWithCharset(String headerValue, ContainerConfig config) {
//        if (headerValue == null || "".equals(headerValue.trim())) {
//            return headerValue;
//        }
//
//        if (headerValue.contains("charset=")) {
//            return headerValue;
//        }
//
//        String newValue = headerValue;
//        if (!headerValue.trim().endsWith(";")) {
//            newValue += "; ";
//        }
//
//        newValue += "charset=" + config.getDefaultContentCharset();
//        return newValue;
//    }
//}
