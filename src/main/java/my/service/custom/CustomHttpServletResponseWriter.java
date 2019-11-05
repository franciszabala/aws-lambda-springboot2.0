package my.service.custom;

import java.util.Base64;

import javax.ws.rs.core.Response;

import com.amazonaws.serverless.exceptions.InvalidResponseObjectException;
import com.amazonaws.serverless.proxy.ResponseWriter;
import com.amazonaws.serverless.proxy.internal.LambdaContainerHandler;
import com.amazonaws.serverless.proxy.internal.servlet.AwsHttpServletResponse;
import com.amazonaws.serverless.proxy.internal.testutils.Timer;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;


/**
 * Creates an <code>AwsProxyResponse</code> object given an <code>AwsHttpServletResponse</code> object. If the
 * response is not populated with a status code we infer a default 200 status code.
 */
public class CustomHttpServletResponseWriter extends ResponseWriter<AwsHttpServletResponse, AwsProxyResponse> {

    //-------------------------------------------------------------
    // Methods - Implementation
    //-------------------------------------------------------------

    @Override
    public AwsProxyResponse writeResponse(AwsHttpServletResponse containerResponse, Context lambdaContext)
            throws InvalidResponseObjectException {
        Timer.start("SERVLET_RESPONSE_WRITE");
        AwsProxyResponse awsProxyResponse = new AwsProxyResponse();
//        if (containerResponse.getAwsResponseBodyString() != null) {
//            String responseString;
//
//            if (!isBinary(containerResponse.getContentType()) && isValidUtf8(containerResponse.getAwsResponseBodyBytes())) {
//                responseString = containerResponse.getAwsResponseBodyString();
//            } else {
//                responseString = Base64.getMimeEncoder().encodeToString(containerResponse.getAwsResponseBodyBytes());
//                awsProxyResponse.setBase64Encoded(true);
//            }
//
//            awsProxyResponse.setBody(responseString);
//        }
//        awsProxyResponse.setMultiValueHeaders(containerResponse.getAwsResponseHeaders());
//
//        awsProxyResponse.setStatusCode(containerResponse.getStatus());
//
//        if (containerResponse.getAwsProxyRequest().getRequestSource() == AwsProxyRequest.RequestSource.ALB) {
//            awsProxyResponse.setStatusDescription(containerResponse.getStatus() + " " + Response.Status.fromStatusCode(containerResponse.getStatus()).getReasonPhrase());
//        }
//
        Timer.stop("SERVLET_RESPONSE_WRITE");
        return awsProxyResponse;
    }

    private boolean isBinary(String contentType) {
        if(contentType != null) {
            int semidx = contentType.indexOf(';');
            if(semidx >= 0) {
                return LambdaContainerHandler.getContainerConfig().isBinaryContentType(contentType.substring(0, semidx));
            }
            else {
                return LambdaContainerHandler.getContainerConfig().isBinaryContentType(contentType);
            }
        }
        return false;
    }
}
