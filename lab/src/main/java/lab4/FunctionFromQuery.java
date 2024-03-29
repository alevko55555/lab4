package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FunctionFromQuery {
    private final long packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    public FunctionFromQuery(@JsonProperty("packageId") long packageId,
                             @JsonProperty("jsScript") String jsScript,
                             @JsonProperty("functionName") String functionName,
                             @JsonProperty("tests") Test[] tests){
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public long getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Test[] getTests() {
        return tests;
    }
}
