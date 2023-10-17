package yuyu.app.dsweb.dwcommon.dwhukamojicheck;

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
 * 不可文字チェックのメイン処理{@link DwHukamojiCheckImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class DwHukamojiCheckTestException_execPostForm extends AbstractTest {

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", "{'iwsCheckObjLst':['①㈲Σ','12.34','業務データ１２３456abcａ　 Ｂ!@']}");

        DwHukamojiCheckImpl dwHukamojiCheckImpl = SWAKInjector.getInstance(DwHukamojiCheckImpl.class);

        String className = "";

        try {
            WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHukamojiCheckImpl.execPostForm(pMap);
        } catch (Exception e) {
            className = e.getMessage();
        }

        exStringEquals(className, "java.lang.reflect.InvocationTargetException", "例外");

    }

}
