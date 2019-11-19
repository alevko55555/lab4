package lab4;

public class MessageWithResults {
    private final long packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;
    public MessageWithResults(long packageId, String jsScript, String functionName, Test[] tests){
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }
}
