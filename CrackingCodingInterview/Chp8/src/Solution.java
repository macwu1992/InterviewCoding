public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str == null || str.length() == 0){
            return null;
        }

        int spaceCount = 0;

        for (int i=0;i<str.length();i++){
            if (str.charAt(i) == ' '){
                spaceCount++;
            }
        }

        str.setLength(str.length()+spaceCount*2);

        int p1 = str.length()-1;
        int p2 = str.length()-1;

        while(str.charAt(p1) == 0){
            p1--;
        }

        for (;p1>=0 && p2>=p1;p1--){
            if(str.charAt(p1) != ' '){
                str.setCharAt(p2, str.charAt(p1));
                p2--;
            }else{
                str.setCharAt(p2, '0');
                --p2;
                str.setCharAt(p2, '2');
                --p2;
                str.setCharAt(p2, '%');
                --p2;
            }
        }

        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Hello World");

        Solution solution = new Solution();
        solution.replaceSpace(str);
    }
}