package lab4;

public class Result {
    private final Test test;
    private final String result;
    public Result(Test test, String result){
        this.test = test;
        this.result = result;
    }

    public Test getTest() {
        return test;
    }

    public String getResult() {
        return result;
    }
}
