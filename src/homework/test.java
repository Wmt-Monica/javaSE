package homework;

public class test {
    public static void main(String[] args) {
//        String s = "123+34-2/5";
//        for (int i = 1; i < s.length() ; i++){
//            char c = s.charAt(s.length()-i);
//            System.out.println(c);
//        }

//        StringBuffer s = new StringBuffer();
//        s.append('1');
//        s.append('2');
//        s.append('3');
//        s.append('4');
//        System.out.println(s);

//        String s1 = "csdbaiv bcsdi";
//        String[] data = s1.split(" ");

        String s2 = "3923";
        int[] tep = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++){
            tep[i] = Integer.parseInt(s2.substring(i,i+1));
            System.out.print(tep[i]+"\t");
        }
    }
}
