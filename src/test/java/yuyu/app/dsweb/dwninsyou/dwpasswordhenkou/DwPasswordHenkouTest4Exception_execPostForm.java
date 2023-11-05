package yuyu.app.dsweb.dwninsyou.dwpasswordhenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * パスワード変更のメイン処理{@link DwPasswordHenkouImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwPasswordHenkouTest4Exception_execPostForm extends AbstractTest{

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception{


        MultivaluedMap<String,String> pMap = (MultivaluedMap<String,String>)Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsDskokno':'0000001','iwsSclakatopassword':'123456'}");

        DwPasswordHenkouImpl dwPasswordHenkouImpl = SWAKInjector.getInstance(DwPasswordHenkouImpl.class);


        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwPasswordHenkouImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");


    }

}
