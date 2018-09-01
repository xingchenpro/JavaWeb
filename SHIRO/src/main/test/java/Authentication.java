import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author :hly
 * @github :github.com/SiriusHly
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/9/1
 */

public class Authentication {

    @Test
    public void testLogin(){
        //1.指定ini文件创建Security1Manager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();
        //2.获取SecurityManager绑定到SecurityUtils，全局设置，设置一次即可
        SecurityUtils.setSecurityManager(securityManager);
        //3.得到Subject绑定到当前线程
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("hly","123");

        try {
            //4.进行登录，委托给SecurityManager.login管理
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //判断用户已经登录
        //junit Assert类，第一个的期望值，第二个是实际值，可以指出报错信息，调用A equal B 都是null为true
        Assert.assertEquals(true,subject.isAuthenticated());
        //5.退出
        subject.logout();

    }







}
