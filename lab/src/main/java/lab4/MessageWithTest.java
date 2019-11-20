package lab4;

public class MessageWithTest {
    private final long packageId;
    private final String jsScript;
    private final String functionName;
    private final Test test;
    public MessageWithTest(long packageId, String jsScript, String functionName, Test test){
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.test = test;
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

    public Test getTest() {
        return test;
    }
}
