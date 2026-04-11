class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> arrL = new ArrayList<>();
        int i = 0; 
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]){
                arrL.add(nums1[i]);
                i++;
            } else { 
                arrL.add(nums2[j]);
                j++;
            }
        }  
        while (i < nums1.length) {
            arrL.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            arrL.add(nums2[j]);
            j++;
        }

        int n1 = nums1.length;
        int n2 = nums2.length;
        int mid = (n1 + n2 - 1) / 2; 
        if((n1 + n2) % 2 == 0){
            double sum = (double)(arrL.get(mid) + arrL.get(mid+1));
            // System.out.println(sum/2);
            return sum / 2 ;
        } else {
            return arrL.get(mid)/1.00;
        }
    }
}
