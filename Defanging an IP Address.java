class Solution {
    public String defangIPaddr(String address) {
        char[] arr = address.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '.') {

            }
        }
        return arr.toString();
    }
    
    public static void insert() {

        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
     
         // Insert an element in 3rd position of the array (index->2, value->5)
        
        int Index_position = 2;
        int newValue    = 5;
     
       System.out.println("Original Array : "+my_array.toString());     
        
       for(int i=my_array.length-1; i > Index_position; i--){
         my_array[i] = my_array[i-1];
        }
        my_array[Index_position] = newValue;
        System.out.println("New Array: "+ my_array.toString());
      }
}