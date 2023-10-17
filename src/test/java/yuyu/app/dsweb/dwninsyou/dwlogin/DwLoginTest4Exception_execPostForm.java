package yuyu.app.dsweb.dwninsyou.dwlogin;

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
 * ログイン認証のメイン処理{@link DwLoginImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwLoginTest4Exception_execPostForm extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception{


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("orgCode", "{'iwsSyono':'','iwsPassword':'123456'}");

        DwLoginImpl dwLoginImpl = SWAKInjector.getInstance(DwLoginImpl.class);


        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwLoginImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");
    }
}
