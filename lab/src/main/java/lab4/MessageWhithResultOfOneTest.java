package lab4;

public class MessageWhithResultOfOneTest {
    private final long packageId;
    private final Result result;

    public MessageWhithResultOfOneTest(long packageId, Result result) {
        this.packageId = packageId;
        this.result = result;
    }

    public long getPackageId() {
        return packageId;
    }

    public Result getResult() {
        return result;
    }
}
