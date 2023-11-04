package yuyu.app.dsweb.dwnetservicesousin.dwmailaddresshenkou;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import net.arnx.jsonic.JSON;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwMailaddressHenkouOutputBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * メール変更のメイン処理{@link DwMailAddressHenkouImpl#execPostFormForPrepare(MultivaluedMap<String, String>)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({"unchecked"})
public class DwMailaddressHenkou_execPostFormForPrepare {

    @Inject
    private DwMailAddressHenkouImpl dwMailAddressHenkouImpl;

    @Inject
    private static Logger logger;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1001111001");
        dsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("1"));
        MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk = dsKokyakuKanri1.createDsMailAddressSpiralYyk();
        dsMailAddressSpiralYyk.setDsmailaddressrenban(1);
        dsMailAddressSpiralYyk.setDsdatasakuseiymd(BizDate.getSysDate());
        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.KOUSIN);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("1001111004");
        dsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("1"));

        MT_DsMailAddress dsMailAddress = dsKokyakuKanri2.createDsMailAddress();
        dsMailAddress.setDsmailaddressrenban(1);
        directDomManager.insert(dsKokyakuKanri2);

        AS_Sequence sequence = new AS_Sequence();
        sequence.setId("19");
        sequence.setName("ＤＳ送信番号連番");
        sequence.setStartWith(Long.valueOf(1));
        sequence.setIncrease(1);
        sequence.setMaxValue(Long.valueOf(999999999));
        sequence.setCacheSize(1);
        sequence.setPadding(C_UmuKbn.ARI);
        sequence.setLength(10);
        sequence.setKousinsyaId("init");
        sequence.setKousinTime("0");
        sequence.setKousinKinou("init");
        sequence.setVersion(Long.valueOf(0));
        baseDomManager.insert(sequence);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());
    }

    @Test
    @TestOrder(10)
    public void testExecPostFormForPrepare_A1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'',  'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_009100, "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");
    }

    @Test
    @TestOrder(20)
    public void testExecPostFormForPrepare_A2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'100001', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_009100, "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ１");
    }

    @Test
    @TestOrder(30)
    public void testExecPostFormForPrepare_A3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111001', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'123456789012345678901'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_009200, "（ＩＷＳ）ＤＳメッセージコード");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), "2", "（ＩＷＳ）ＤＳメールＤＢ処理区分");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDssousinno(), null, "（ＩＷＳ）ＤＳ送信番号");

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), null, "（ＩＷＳ）配信ルールＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testExecPostFormForPrepare_A4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        setKibanKoumoku(pMap);

        pMap.add("gyoumuData", "{'iwsDskokno':'1001111004', 'iwsDsmailaddress':'www.liant@co.jp', 'iwsDssousinno':'1'}");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = dwMailAddressHenkouImpl.execPostFormForPrepare(pMap);
        WsDwMailaddressHenkouOutputBean wsDwMailaddressHenkouOutputBean =
            JSON.decode(wsBzWebserviceResParamBean.getGyoumuData(), WsDwMailaddressHenkouOutputBean.class);

        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmailaddressdbsyorikbn(), null, "（ＩＷＳ）ＤＳメールＤＢ処理区分");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsHaisinruleid1(), "447399", "（ＩＷＳ）配信ルールＩＤ");
        exStringEquals(wsDwMailaddressHenkouOutputBean.getIwsDsmsgcd(), DwMessageCodeConstants.IWSDSMSGCD_000000, "（ＩＷＳ）ＤＳメッセージコード");
        logger.info(wsDwMailaddressHenkouOutputBean.getIwsDssousinno());

    }

    private void setKibanKoumoku(MultivaluedMap<String, String> pMap){

        pMap.add("operatorId","operatorId");
        pMap.add("coopClass","1234567");
        pMap.add("orgCode","9876543");
        pMap.add("methodName","dsweb.dwnetservicesousin.dwmailaddresshenkou.DwMailAddressHenkou/execPostFormUpdate");
    }

}
