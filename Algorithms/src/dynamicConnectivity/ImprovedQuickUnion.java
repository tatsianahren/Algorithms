package dynamicConnectivity;

public class ImprovedQuickUnion extends QuickUnion {

    private int[] pointsWeight;

    @Override
    public void init(int N){
        if(N > 0){
            pointsWeight = new int[N];
        }

        for(int i = 0; i < N; i++ ){
            pointsWeight[i] = 1;
        }

        super.init(N);
    }

    @Override
    public void union(int p, int q){
        int pRoot = getRoot(p);
        int qRoot = getRoot(q);
        if(pRoot == qRoot)
            return;
        if(pointsWeight[pRoot] < pointsWeight[qRoot]){
            points[pRoot] = qRoot;
            pointsWeight[qRoot] += pointsWeight[pRoot];
        } else {
            points[qRoot] = pRoot;
            pointsWeight[pRoot] += pointsWeight[qRoot];
        }
    }
}
