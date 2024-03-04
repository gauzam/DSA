class Solution {
    public int trap(int[] height) {

        int n = height.length;

        //array that contains the max height to the left of any index 'i'
        int maxL[] = new int[n];

        //array that contains the max height to the right of any index 'i'
        int maxR[] = new int[n];

        int maxtillnow = -1;

        //building maxL
        for(int i = 0; i < n; i++){
            if(i == 0){
                maxL[i] = -1;
                maxtillnow = height[i];
                continue;
            }

            maxL[i] = maxtillnow;
            maxtillnow = Math.max(height[i], maxtillnow);

        }

        maxtillnow = -1;

        //building maxR
        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                maxR[i] = -1;
                maxtillnow = height[i];
                continue;
            }

            maxR[i] = maxtillnow;
            maxtillnow = Math.max(maxtillnow, height[i]);
        }

        int trapped = 0;

        for(int i = 0; i < n ; i++){

            //max possible rain water that can be trapped
            int maxtrap = Math.min(maxL[i], maxR[i]);

            //actual rain water trapped
            int actualtrap = maxtrap - height[i];

            if(actualtrap > 0){
                trapped = trapped + actualtrap;
            }
        }

        return trapped;

    }
}