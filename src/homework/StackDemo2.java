package homework;

/**
 * 使用链表来实现栈
 */
public class StackDemo2 {
    public static void main(String[] args) {
        Node3Manage manage = new Node3Manage();
        for (int i = 0 ; i < 10; i++){
            manage.push(i);
        }
        System.out.println(manage);

        System.out.println("从栈顶开始遍历所有元素");
        manage.listNode();

        System.out.println("\n从栈顶开始全部出栈所有元素");
        for (int i = 0; i < 10; i++){
            manage.pop();
        }

        String s = "12*3-5/2*5+4/3*7-8/3";
        System.out.println("12*3-5/2*5+4/3*7-8/3="+manage.Calculation(s));

        System.out.println("\n===============================");
        String s1 = "(({[]}))";
        String s2 = "({[}])";
        String s3 = "(){[]}";
        System.out.println("s1是否为有效字符串："+manage.isMate(s1));
        System.out.println("s2是否为有效字符串："+manage.isMate(s2));
        System.out.println("s3是否为有效字符串："+manage.isMate(s3));

        /**
         * 中缀表达式转换成后缀表达式 （未实现）
         */
//        String s2 = "( 3 + 4 ) * 5 - 6";
//        manage.Postfix(s2);

    }
}

//创建管理节点类
class Node3Manage{

    //设置头节点
    Node3 top = null;

    //判断栈是否为空
    public boolean isEmpty(){
        return top == null;
    }

    //创建括号字符串是否匹配的方法
    public boolean isMate(String s){
        boolean flag = true;
        char c;
        int i;
        for (i = 0;i < s.length(); i++){
            c = s.charAt(i);
           //判断选择性入栈
            if (isEmpty()){
                push(c);
            }else {
                if (c == ')'){
                    //遇到匹配的括号，将左括号出栈
                    if (pop2() == '('){
                        pop();
                    }else {
                        flag = false;
                    }
                }else if (c == ']'){
                    //遇到匹配的括号，将左括号出栈
                    if (pop2() == '['){
                        pop();
                    }else {
                        flag = false;
                    }
                }else if (c == '}'){
                    //遇到匹配的括号，将左括号出栈
                    if (pop2() == '{'){
                        pop();
                    }else {
                        flag = false;
                    }
                }else{
                    push(c);
                }
            }
        }
        return flag;
    }

    //添加数据的方法push()
    public void push(int value){

        Node3 addNode = new Node3(value);
        if (isEmpty()){
            top = addNode;
        }else {
            Node3 stp = top;
            top = addNode;
            top.next = stp;
        }
//        System.out.println("top:"+top);
//        System.out.println("top.next:"+top.next);
//        System.out.println("数据"+value+"添加成功");
//        System.out.println("========================");
    }

    //将栈顶删除并返回，创建pop()方法
    public Node3 pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }else {
            Node3 stp = top;
            top = top.next;
//            System.out.println("删除栈顶："+stp);
            return stp;
        }
    }

    //将栈顶不删除的返回，创建pop2()方法
    public int pop2(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }else {
            return top.num;
        }
    }

    //从栈顶开始遍历栈打印输出元素
    public void listNode(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }else{
            Node3 stp = top;
            while (stp != null){
                System.out.println(stp);
                stp = stp.next;
            }
        }
    }

    //重写toString方法
    @Override
    public String toString() {
        Node3 stp = top;
        while (stp.next != null){
            System.out.println(stp);
            stp = stp.next;
        }
        return "";
    }

    //创建实现将一串计算的世子以栈的方式实现计算功能
    public int Calculation(String s){
        int result = 0; //初始化结果
        boolean flag = false;
        //创建两个栈，数字栈和运算符栈
        Node3Manage figure = new Node3Manage();
        Node3Manage operator = new Node3Manage();

        //获取字符串中的每一个字符
        System.out.println("s.length:"+s.length());
        char c1;
        for (int i = 0; i < s.length(); i++){
            c1 = s.charAt(i);
            System.out.println("c1:"+c1);
        }

        for (int i = 0;i < s.length(); i++){
            //用于多位数存放使用的字符串用于连接数字字符
            String stp = "";
            char c = s.charAt(i);
            if (isFigure(c)){
//                figure.push((c-'0')); //将字符串转换成数字
//                System.out.println("数字栈添加数据："+figure.pop2());
                stp = stp+""+c;
                System.out.println("stp="+stp);
                 //当为多位数时添加数字数据进入数字栈
                 if (i != (s.length()-1)){  //当这个不是最后一个数字字符
                     while (isFigure(s.charAt(i+1))){
                         System.out.println("下一个数字："+s.charAt(i+1));
                         char c2 = s.charAt(i+1);
                         stp = stp+""+c2;
                         System.out.println("stp="+stp);
                         i++;
                         System.out.println("=============入栈了一个多位数==============");
                         System.out.println("多位数："+Integer.parseInt(stp));
                     }
                     //将得到的多位数字符串转换成int数字入数字栈
                     figure.push(Integer.parseInt(stp));
                     //将存放多位数的字符串初始化操作
                     stp = "";
                 }else {
                     figure.push((c-'0'));
                 }
            }else if (isOperator(c)){
                if (operator.isEmpty()){
                    operator.push(c);
                }else {
                    //判断后面的运算符比前面的字符串的优先级小于或等于，将前面两个数字先计算
                    if (Compare(operator.pop2(),c)){
                        int num1 = figure.pop().num;
                        int num2 = figure.pop().num;
                        int yun = operator.pop().num;
                        System.out.println("-----------------判断后面的运算符比前一个运算符优先级小-----------------");
                        System.out.println("num1="+num1);
                        System.out.println("num2="+num2);
                        System.out.println("result="+ Count(num1,num2,yun));
                        System.out.println("--------------------------------------------------------------------");
                        figure.push(Count(num1, num2, yun));  //计算后的结果入数字栈
                        System.out.println("计算前两个添加的数据结果"+figure.pop2());
                    }
                    operator.push(c);
                    char c3 = s.charAt(i+1);

                    //检查计算式子是否又错误
                    if (!isFigure(c3) || isOperator(c3)){
                        throw new RuntimeException("计算的式子输入有误，运算符后面不能是运算符或者没有数字");
                    }
                }
                System.out.println("运算符栈添加数据："+(char)(operator.pop2()));
            }else {
                System.out.println("输入错误");
                break;
            }
        }

        //将后面的算数式子计算出
        int lastnum1 = figure.pop().num;
        int lastnum2 = figure.pop().num;
        int lastyun = operator.pop().num;
        figure.push(Count(lastnum1,lastnum2,lastyun));
        System.out.println("最后的式子计算结果："+lastnum1+(char)lastyun+lastnum2+"="+Count(lastnum1,lastnum2,lastyun));


        //将数字栈和运算符栈反转
        figure = figure.reverse(figure);
        operator = operator.reverse(operator);

        System.out.println("\n\n\n\n开始运算");
        while (true){
            int num1 = figure.pop().num;
            int num2 = figure.pop().num;
            int yun = operator.pop().num;
            System.out.println("num1:"+num1);
            System.out.println("num2:"+num2);
            System.out.println("yun:"+(char)yun);
            System.out.println(num2+""+(char)yun+""+num1+" = "+Count(num2, num1, yun));
            if (!figure.isEmpty()){  //当数字还未取完时
                figure.push(Count(num2, num1, yun));
            }else {
                result = Count(num2, num1, yun);
                break;
            }
        }

        return result;
    }

    //创建判断时数字的方法
    public boolean isFigure(char num){
        return (num >= '0' && num <= '9');
    }
    public boolean isFigure(String num){
        for (int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            if (!isFigure(c)){
                return false;
            }
        }
        return true;
    }

    //创建判断是否为运算符
    public boolean isOperator(char operator){
        return (operator == '+'||operator == '-'||operator == '*'|| operator =='/');
    }
    public boolean isOperator(String s){
        for (int i= 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!isOperator(c)){
                return false;
            }
        }
        return true;
    }

    //创建判断运算符优先级
    public boolean Compare(int ch1, int ch2){
        int num1,num2;

        //给一个符号赋运算优先级值
        if (ch1 == '/'){
            num1 = 4;
        }else if (ch1 == '*'){
            num1 = 3;
        }else if (ch1 == '-'){
            num1 = 2;
        }else {
            num1 = 1;
        }

        //给另一个符号赋运算优先级值
        if (ch2 == '/'){
            num2 = 4;
        }else if (ch2 == '*'){
            num2 = 3;
        }else if (ch2 == '-'){
            num2 = 2;
        }else {
            num2 = 1;
        }

        if (num2 < num1)
            return true;
        else
            return false;
    }

    //创建用于将中缀表达式转换成后缀表达式用的判断运算符优先级
    public boolean Compare2(int ch1 , int ch2){
        int num1 = 0;
        int num2 = 0;
        if (ch1 == '-' || ch1 == '+'){
            num1 = 1;
        }else if (ch1 == '*' || ch1 == '/'){
            num1 = 2;
        }

        if (ch2 == '-' || ch2 == '+'){
            num2 = 1;
        }else if (ch2 == '*' || ch2 == '/'){
            num2 = 2;
        }

        return (num2 > num1);
    }

    //计算功能
    public int Count(int num1,int num2,int yun){
        int result;
        switch (yun){
            case '+':
                result = num1 + num2; break;
            case '-':
                result = num2 - num1; break;
            case '*':
                result = num1 * num2; break;
            case '/':
                result = num2 / num1; break;
            default:
                throw new IllegalStateException("运算符输入错误");
        }
        return result;
    }

    //反转栈的reverse()方法
    public Node3Manage reverse(Node3Manage manage){
        Node3Manage tep = new Node3Manage();
        while (!manage.isEmpty()){
            tep.push(manage.pop().num);
        }
        return tep;
    }

    /**
     * 将中缀表达式转换成后缀表达式
     */
    public void Postfix(String s){
        //将字符串先按照空格间隔来存放计算式子存放进字符串数组中
        String data[] = s.split(" ");


        //创建两个空栈：运算符栈s1和中间结果的栈s2
        Node3Manage s1 = new Node3Manage();
        Node3Manage s2 = new Node3Manage();

        //从左至右扫描中缀表达式,重复扫描判断操作，直到表达式最右边
        for (int i = 0;i < data.length; i++){
            if (isFigure(data[i])){
                //当遇见操作数时，将其压入中间结果栈
                s2.push(Integer.parseInt(data[i]));
            }else if (isOperator(data[i].charAt(0))){
                //当遇见运算符时，比较与其运算符栈顶运算符的优先级
                //1.当运算符栈s1为空时，或者栈顶运算符元素为'('时，直接入栈
                //2.否则，若优先级比栈顶运算符高，也将运算符压入s1
                if (s1.isEmpty() || (s1.pop2() == '(') || (Compare2(s1.pop2(),Integer.parseInt(data[i])))){
                    String tep = data[i];
                    s1.push(Integer.parseInt(tep));
                }else {
                    //3.否则，将s1栈顶元素弹出并压入到s2中，再次转到判断运算符头部与s1新的栈顶元素相比较
                    s2.push(s1.pop().num);
                    i--;
                }
            }else if (data[i] == "("){
                //当遇到是左括号"(",直接压入栈s1
                s1.push(Integer.parseInt(data[i]));
            }else if (data[i] == ")"){
                //当遇到的是右括号")",则依次弹出s1栈顶运算符，并压入s2,直到遇到左括为止，此时将这一对括号丢弃
                while (s1.pop2() != '('){
                    s2.push(s1.pop().num);
                }
                s1.pop();
            }
        }
        //将s1中剩余运算符一次弹出并压入s2
        while (!s1.isEmpty()){
            s2.push(s1.pop().num);
        }
        //依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀的表达式
        while (!s2.isEmpty()){
            System.out.print(s2.pop()+"\t");
        }
    }
}



//创建节点类
class Node3{
    int num;
    Node3 next;

    //构造器
    public Node3(int num) {
        this.num = num;
    }

    //重写toString方法
    @Override
    public String toString() {
        return "Node3{" +
                "num=" + num +
                '}';
    }
}