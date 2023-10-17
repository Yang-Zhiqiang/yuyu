package yuyu.app.dsweb.dwcommon.dwhukamojicheck;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import net.arnx.jsonic.JSON;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.dsweb.bean.webservice.WsDwHukamojiCheckOutputBean;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 不可文字チェックのメイン処理{@link DwHukamojiCheckImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DwHukamojiCheckTest_execPostForm extends AbstractTest {

    @Inject
    private DwHukamojiCheckImpl dwHukamojiCheckImpl;

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsCheckObjLst':['①㈲Σ','12.34','業務データ１２３456abcａ　 Ｂ!@']}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHukamojiCheckImpl.execPostForm(pMap);

        WsDwHukamojiCheckOutputBean wsDwHukamojiCheckOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwHukamojiCheckOutputBean.class);

        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsDsmsgcd(), "008000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsCheckKekkaLst().get(0), "0", "（ＩＷＳ）チェック結果");
        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsCheckKekkaLst().get(1), "1", "（ＩＷＳ）チェック結果");
        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsCheckKekkaLst().get(2), "1", "（ＩＷＳ）チェック結果");

    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsCheckObjLst':['あいうえおかきくけこ']}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHukamojiCheckImpl.execPostForm(pMap);

        WsDwHukamojiCheckOutputBean wsDwHukamojiCheckOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwHukamojiCheckOutputBean.class);

        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsDsmsgcd(), "008000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsCheckKekkaLst().get(0), "1", "（ＩＷＳ）チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsCheckObjLst':''}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwHukamojiCheckImpl.execPostForm(pMap);

        WsDwHukamojiCheckOutputBean wsDwHukamojiCheckOutputBean = JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(),
            WsDwHukamojiCheckOutputBean.class);

        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsDsmsgcd(), "008000", "（ＩＷＳ）ＤＳメッセージコード");
        exStringEquals(wsDwHukamojiCheckOutputBean.getIwsCheckKekkaLst().get(0), "1", "（ＩＷＳ）チェック結果");
    }

    private void setKibanKoumoku(MultivaluedMap<String, String> pMap){

        pMap.add("operatorId","operatorId");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwcommon.dwhukamojicheck.DwHukamojiCheck/execPostForm");
    }
}
