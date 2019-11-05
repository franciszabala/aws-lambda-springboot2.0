package my.service.custom;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


/**
 * Response object for an API Gateway method using AWS_PROXY integrations
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {

    //-------------------------------------------------------------
    // Variables - Private
    //-------------------------------------------------------------

    private String body;
    


    //-------------------------------------------------------------
    // Constructors
    //-------------------------------------------------------------

    public CustomResponse() {

    }


   


    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }

 
}
