package my.service.custom;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Default implementation of the request object from an API Gateway AWS_PROXY integration
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomRequest {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------

    private String body;
//    private String resource;
//    private AwsProxyRequestContext requestContext;
//    private MultiValuedTreeMap<String, String> multiValueQueryStringParameters;
//    private Headers multiValueHeaders;
//    private Map<String, String> pathParameters;
//    private String httpMethod;
//    private Map<String, String> stageVariables;
//    private String path;
//    private boolean isBase64Encoded;
//
//    public CustomRequest() {
//
//    }


//    //-------------------------------------------------------------
//    // Methods - Getter/Setter
//    //-------------------------------------------------------------
//
//    @JsonIgnore
//    public String getQueryString() {
//        StringBuilder params = new StringBuilder("");
//
//        if (this.getMultiValueQueryStringParameters() == null) {
//            return "";
//        }
//
//        for (String key : this.getMultiValueQueryStringParameters().keySet()) {
//            for (String val : this.getMultiValueQueryStringParameters().get(key)) {
//                String separator = params.length() == 0 ? "?" : "&";
//
//                params.append(separator + key + "=" + val);
//            }
//        }
//
//        return params.toString();
//    }
//
//    public RequestSource getRequestSource() {
//        if (getRequestContext() != null && getRequestContext().getElb() != null) {
//            return RequestSource.ALB;
//        }
//
//        return RequestSource.API_GATEWAY;
//    }
//
//
    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }
//
//
//    public String getResource() {
//        return resource;
//    }
//
//
//    public void setResource(String resource) {
//        this.resource = resource;
//    }
//
//
//    public AwsProxyRequestContext getRequestContext() {
//        return requestContext;
//    }
//
//
//    public void setRequestContext(AwsProxyRequestContext requestContext) {
//        this.requestContext = requestContext;
//    }
//
//    public MultiValuedTreeMap<String, String> getMultiValueQueryStringParameters() {
//        return multiValueQueryStringParameters;
//    }
//
//
//    public void setMultiValueQueryStringParameters(
//            MultiValuedTreeMap<String, String> multiValueQueryStringParameters) {
//        this.multiValueQueryStringParameters = multiValueQueryStringParameters;
//    }
//
//    public Headers getMultiValueHeaders() {
//        return multiValueHeaders;
//    }
//
//
//    public void setMultiValueHeaders(Headers multiValueHeaders) {
//        this.multiValueHeaders = multiValueHeaders;
//    }
//
//
//    public Map<String, String> getPathParameters() {
//        return pathParameters;
//    }
//
//
//    public void setPathParameters(Map<String, String> pathParameters) {
//        this.pathParameters = pathParameters;
//    }
//
//
//    public String getHttpMethod() {
//        return httpMethod;
//    }
//
//
//    public void setHttpMethod(String httpMethod) {
//        this.httpMethod = httpMethod;
//    }
//
//
//    public Map<String, String> getStageVariables() {
//        return stageVariables;
//    }
//
//
//    public void setStageVariables(Map<String, String> stageVariables) {
//        this.stageVariables = stageVariables;
//    }
//
//
//    public String getPath() {
//        return path;
//    }
//
//
//    public void setPath(String path) {
//        this.path = path;
//    }
//
//    @JsonProperty("isBase64Encoded")
//    public boolean isBase64Encoded() {
//        return isBase64Encoded;
//    }
//
//
//    public void setIsBase64Encoded(boolean base64Encoded) {
//        isBase64Encoded = base64Encoded;
//    }
//
//    public static enum RequestSource {
//        ALB,
//        API_GATEWAY
//    }


}
