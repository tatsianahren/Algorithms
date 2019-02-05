package dynamicConnectivity;

public class QuickFind implements DynamicConnectivity {

    private int[] points;

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
    public boolean connected(int p, int q){

        return points[p] == points[q] ;
    }

    @Override
    public void union(int p, int q){
        int newIndex = points[q];
        int toChangeIndex = points[p];
        if(!connected(p, q)) {
            points[p] = newIndex;

            for (int i = 0; i < points.length; i++) {
                if (points[i] == toChangeIndex) {
                    points[i] = newIndex;
                }
            }
        }
    }

    public int[] getPoints() {
        return points;
    }
}
