package IO;

import java.io.*;

/**
 * 数据流：
 * DataInputStream / DataOutputStream
 */
public class DataStreamDemo1 {
    public static void main(String[] args) {
        //字节流ByteArrayOutputStream 不需要传入参数，是自己管理的
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        //使用数据流DataOutputStream用来接收各种数据类型的数据
        //为为了提高性能使用BufferedOutputStream
        DataOutputStream output =
                new DataOutputStream(
                        new BufferedOutputStream(byteArray));

        //output是输入流对象，是一个用于数据输入的渠道
        //使用数据流的写入方法 数据类型+数据
        try {
            output.writeFloat((float) 5.21);
            output.writeDouble(34.13);
            output.writeByte(8);
            output.writeChar('w');
            output.writeBoolean(true);

            //写完数据后，最后一定要记得刷新数据
            output.flush();

            //使用一个字节数组将写入的数据传入一个临时存储的字节数组
            byte[] data = byteArray.toByteArray();

            //使用DataInputStream来读取数据
            DataInputStream input =
                    new DataInputStream(
                            new BufferedInputStream(
                                    new ByteArrayInputStream(data)));
            //读取数据的顺序需要和写入的顺序一致，否则报错
            float a1 = input.readFloat();
            double a2 = input.readDouble();
            byte a3 = input.readByte();
            char a4 = input.readChar();
            boolean a5 = input.readBoolean();
            System.out.println(a5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
