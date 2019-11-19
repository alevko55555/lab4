package lab4;

public class ActorTest {
    private final String testName;
    private final String expectedResult;
    private final Object[] params;
    public ActorTest {
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
