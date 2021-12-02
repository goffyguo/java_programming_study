/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/02/11:16
 * @Description: 标量替换测试
 */
public class ScalarReplaceTest {
    public static class User{
        public int id;
        public String name;
    }

    public static void alloc(){
        User user = new User();
        user.id = 5;
        user.name = "Guo";
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "ms");
    }
}
