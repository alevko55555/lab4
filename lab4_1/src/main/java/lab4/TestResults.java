package lab4;

import java.util.List;

public class TestResults {
    private final long packageId;
    private final List<Result> results;
    public TestResults(long packageId, List<Result> results) {
        this.packageId = packageId;
        this.results = results;
    }
    public long getPackageId() {
        return packageId;
    }
    public List<Result> getResults() {
        return results;
    }
}
