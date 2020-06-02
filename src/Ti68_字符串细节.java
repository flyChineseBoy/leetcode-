import java.util.List;
import java.util.Stack;

public class Ti68_字符串细节 {
        public List<String> fullJustify(String[] words, int maxWidth) {
            // 本题最大的难度在于细节考虑，如何优雅的写出代码
            // 首先需要判断取出满足一行的长度：取出i，j标识使用i和j之间的单词。
            // 然后计算中间空格，先计算出基础空格数量，再计算出左边有几个空位多一个空格。
            // 用一个‘空格集成’位来标识还有几个空位是多一个空格的。
            // 然后就可以快了的build字符串了。
            // 最后一行的问题：比较简单，判断为最后一行的话，直接左对齐build。

            return null;
        }

    public static void main(String[] args) {
        Stack stack = new Stack<String>();
        stack.push("asd");
        stack.push("zxc");

        System.out.println(stack);
    }
}
