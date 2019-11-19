package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionFromQuery {
    private final long packageId;
    private final String jsScript;
    private final String functionName;
    private final ActorTest[] tests;

    public FunctionFromQuery(@JsonProperty("packageId") long packageId,
                             @JsonProperty("jsScript") String jsSript,
                             @JsonProperty("functionName") String functionName,
                             @JsonProperty("tests") ActorTest[] tests){
        this.
    }

    /*
    "packageId":"11",
"jsScript":"var divideFn = function(a,b) { return a/b} ",
"functionName":"divideFn",
"tests": [
     */
}
