import org.junit.Test;

/**
 * @author sunbaojin
 * @date 2020/5/17 22:26
 */
public class TestDigui {



    @Test
    public void testDigui(){
        printInt(6);
    }

    public void printInt(int n){
        if(n > 0){
            printInt(n-1);
        }
        //打印n的值
        System.out.println("当前N的值为："+n);
    }
}
