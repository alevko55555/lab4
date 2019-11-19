package lab4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActorTest {
    private final String testName;
    private final String expectedResult;
    private final Object[] params;
    public ActorTest(@JsonProperty("testName") String testName, @JsonProperty("expectedResult") String expectedResult, @JsonProperty("params") Object[] params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public Object[] getParams() {
        return params;
    }
}
