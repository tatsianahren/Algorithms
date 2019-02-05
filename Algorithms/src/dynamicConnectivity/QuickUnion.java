package dynamicConnectivity;

public class QuickUnion implements DynamicConnectivity {

    protected int[] points;

    @Override
    public void init(int N) {
        if(N > 0){
            points = new int[N];
        }

        for(int i = 0; i < N; i++ ){
            points[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);

        return qRoot == pRoot;
    }

    @Override
    public void union(int p, int q) {

        System.out.println("Union(" + p +", " + q + ")");
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        points[pRoot] = qRoot;
    }

    @Override
    public int[] getPoints() {
        return points;
    }

    public int getRoot(int p){
        int root = points[p];

        while(root != points[root]){
            root = points[root];
        }

        return root;
    }
}
