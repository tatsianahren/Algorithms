package dynamicConnectivity;

public interface DynamicConnectivity {

    void init(int N);

    boolean connected(int p, int q);

    void union(int p, int q);

    int[] getPoints();
}
