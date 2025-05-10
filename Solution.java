import java.util.HashMap;

// class Solution {
//     public boolean isPalindrome(int x) {
//         String rev = "", temp = ""+x;
//         for(int i = temp.length()-1;i>=0;i--){
//             rev = rev+temp.charAt(i);
        
//         }
//         String dummy = ""+x;
        

//         if(rev.equals(dummy)){
//             return true;
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         System.out.println(sol.isPalindrome(121)); // true
//         System.out.println(sol.isPalindrome(-121)); // false
//         System.out.println(sol.isPalindrome(10)); // false
//     }
// }
class Solution {
    public int romanToInt(String s) {
        HashMap<String,Integer> roman = new HashMap<String,Integer>();
        roman.put("I",1);
        roman.put("V",5);
        roman.put("X",10);
        roman.put("L",50);
        roman.put("C",100);
        roman.put("D",500);
        roman.put("M",1000);
        Integer ans = 0;
        for(int i = 0; i<s.length(); i++){
            String current =""+ s.charAt(i);
            ans += roman.get(current);
            System.out.println("Current: "+current);
            System.out.println("Value: "+roman.get(current));
            System.out.println("answer: "+ans);

        }
        System.out.println("answer: "+ans);

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.romanToInt("MCMXCIV")); // 1994
    }
}