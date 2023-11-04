package yuyu.app.dsweb.dwninsyou.dwhonninkakunin;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 本人確認処理のメイン処理{@link DwHonninKakuninImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwHonninKakuninTest4Exception_execPostForm {

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception{


        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsSyono':'10000000001', 'iwsDskokno':'0010020034',"
            + " 'iwsNmkn':'アカサ', 'iwsSeiymd':'19880414', 'iwsTelnosimo4':'3383'}");


        DwHonninKakuninImpl dwHonninKakuninImpl = SWAKInjector.getInstance(DwHonninKakuninImpl.class);


        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHonninKakuninImpl.execPostForm(pMap);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

}
