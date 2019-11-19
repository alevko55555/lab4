package lab4;

import java.util.List;

public class ActorTestResults {
    private final long packageId;
    private final List<ActortResult> results;
    public ActorTestResults(long packageId, List<ActortResult> results) {
        this.packageId = packageId;
        this.results = results;
    }
    public long getPackageId() {
        return packageId;
    }
    public List<ActortResult> getResults() {
        return results;
    }
}
