package lab4;

public class Result {
    private final long packageId;
    private final String result;
    public Result(long packageId, String result){
        this.packageId = packageId;
        this.result = result;
    }

    public long getPackageId() {
        return packageId;
    }

    public String getResult() {
        return result;
    }
}
