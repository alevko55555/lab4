package lab4;

public class MessageWithResultOfOneTest {
    private final long packageId;
    private final Result result;

    public MessageWithResultOfOneTest(long packageId, Result result) {
        this.packageId = packageId;
        this.result = result;
    }

    public MessageWithResultOfOneTest(long packageId, Test test, String result) {
        this(packageId, new Result(test, result));
    }

    public long getPackageId() {
        return packageId;
    }

    public Result getResult() {
        return result;
    }
}
