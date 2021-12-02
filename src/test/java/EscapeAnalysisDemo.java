/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/02/10:32
 * @Description:
 */
public class EscapeAnalysisDemo {
    public EscapeAnalysisDemo obj;


    /**
     * 方法返回 escapeAnalysisDemo 对象，发生逃逸
     * @return
     */
    public EscapeAnalysisDemo getInstance(){
        return obj == null ? new EscapeAnalysisDemo() :obj;
    }

    /**
     * 为成员属性赋值，发生逃逸
     * 思考：如果当前的 obj 引用声明为 static 的，会发生逃逸吗？
     * 会，生命周期更长
     */
    public void setObj(){
        this.obj = new EscapeAnalysisDemo();
    }

    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useEscapeAnalysisDemo(){
        EscapeAnalysisDemo escapeAnalysisDemo = new EscapeAnalysisDemo();
    }

    /**
     * 引用 getInstance，发生逃逸
     */
    public void useEscapeAnalysisDemo1(){
        EscapeAnalysisDemo instance = getInstance();
    }

    /**
     * 引用对象传递，发生逃逸
     * @param demo
     */
    public void operation(EscapeAnalysisDemo demo){
        // demo
    }
}
