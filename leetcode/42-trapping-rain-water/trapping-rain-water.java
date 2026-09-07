class Solution {
    public int trap(int[] a) {
        int leftmax = Integer.MIN_VALUE;
        int rightmax = Integer.MIN_VALUE;
        int l = 0, r = a.length - 1, water = 0;
        
        while (l < r) {
            if (a[l] < a[r]) {
                // first we will consider the lowest height among left and right so it will be safe to 
                // calculate the water in that side
                if (a[l] < leftmax) {
                    // if the currheight is less than max height we subtract that height from max height 
                    // because the water will be present on the block so the height diff will give us that water quantity
                    water += (leftmax - a[l]);
                    l++;
                } else {
                    // if curr height is greater than max height of that side we will not calculate water 
                    // we will just change our leftmax
                    leftmax = a[l];
                    l++;
                }
            } else {
                // if right height is smaller we will perform same operations on right
                if (a[r] < rightmax) {
                    water += (rightmax - a[r]);
                    r--;
                } else {
                    rightmax = a[r];
                    r--;
                }
            }
        }
        return water;
    }
}
