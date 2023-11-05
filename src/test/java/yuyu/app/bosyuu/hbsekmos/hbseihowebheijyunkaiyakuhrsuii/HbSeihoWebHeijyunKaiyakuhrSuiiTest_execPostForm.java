package yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.GetInputGyoumuData;
import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.KeisanWExtBean;
import yuyu.common.hozen.khcommon.WSuiihyouParam;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin3;
import yuyu.common.hozen.khcommon.WSuiihyouSyuusin3MockForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 生保Ｗｅｂ平準払終身用解約返戻金推移表作成のメイン処理{@link HbSeihoWebHeijyunKaiyakuhrSuiiImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebHeijyunKaiyakuhrSuiiImpl hbSeihoWebHeijyunKaiyakuhrSuiiImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_生保Ｗｅｂ平準払終身用解約返戻金推移表作成";

    private final static String sheetName = "INデータ";

    private final static String requestSheetName = "業務データ";

    private static Map<String, String> gyoumuInfoMap;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(WSuiihyouSyuusin3.class).to(WSuiihyouSyuusin3MockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class;

        WSuiihyouSyuusin3MockForSinkeiyaku.caller = HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void getGyoumutData() throws Exception {
        gyoumuInfoMap = new HashMap<String, String>();
        GetInputGyoumuData getInputGyoumuData = new GetInputGyoumuData();
        gyoumuInfoMap = getInputGyoumuData.getGyoumuDataMap(
            HbSeihoWebHeijyunKaiyakuhrSuiiTest_execPostForm.class, fileName, requestSheetName);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = null;
        WSuiihyouSyuusin3MockForSinkeiyaku.caller = null;

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = null;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = null;

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkHokenSyuruiNo());
    }


    @Test
    @TestOrder(10)
    public void testExecPostForm_E1() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E1"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "基本Ｓ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_E2() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E2"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "外貨基本Ｓ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_E3() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E3"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "基本Ｐ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_E4() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E4"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "外貨基本Ｐ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_E5() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E5"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "契約時予定利率（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_E6() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E6"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "一括払回数エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(70)
    public void testExecPostForm_E7() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E7"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "一括払Ｐ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(80)
    public void testExecPostForm_E8() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E8"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "前納Ｐ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(90)
    public void testExecPostForm_E9() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E9"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "外貨前納Ｐ（文字列）エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(100)
    public void testExecPostForm_E10() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E10"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "特殊項目コード１エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(110)
    public void testExecPostForm_E11() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E11"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "特殊項目コード２エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(120)
    public void testExecPostForm_E12() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E12"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "特殊項目コード３エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(130)
    public void testExecPostForm_E13() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E13"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "特殊項目コード４エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(140)
    public void testExecPostForm_E14() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_E14"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "特殊項目コード５エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(310)
    public void testExecPostForm_A1() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A1"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "端末権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(320)
    public void testExecPostForm_A2() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A2"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "使用者権限エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(330)
    public void testExecPostForm_A3() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A3"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(340)
    public void testExecPostForm_A4() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A4"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(350)
    public void testExecPostForm_A5() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A5"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "才満期表示エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(360)
    public void testExecPostForm_A6() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A6"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "Ｓ建Ｐ建区分エラー", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(370)
    public void testExecPostForm_A7() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A7"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(380)
    public void testExecPostForm_A8() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN1;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A8"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(390)
    public void testExecPostForm_A9() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A9"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(400)
    public void testExecPostForm_A10() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN3;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A10"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk1(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsHrkkknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）払込期間満了直後Ｗ");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１０");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１０");

        WsBzWebserviceReqParamBean hbSeihoWebHanteiKengenBean = (WsBzWebserviceReqParamBean) MockObjectManager
            .getArgument(HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "execChkTanmatuKengen", 0, 0);
        exStringEquals(hbSeihoWebHanteiKengenBean.getGyoumuData()
            , "119940211219950131235720210415202104142020013109999999998888888888888777777777766666666666662199101511123411255555555551134444444444680000000000023344556673"
            , "（ＩＷＳ）業務データ");

        WSuiihyouParam wSuiihyouParam = (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin3MockForSinkeiyaku.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(),"ﾆｱ","商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(),1,"商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(),"L","料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(),BizNumber.valueOf(0.1234),"予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(),C_Hrkkaisuu.NEN,"払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(),C_HknkknsmnKbn.SAIMANKI,"保険期間歳満期区分");
        exClassificationEquals(keisanWExtBean.getHrkkknsmnkbn(),C_HrkkknsmnKbn.SAIMANKI,"払込期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHrkkkn(),15,"払込期間");
        exNumericEquals(keisanWExtBean.getHknkkn(),99,"保険期間");
        exNumericEquals(keisanWExtBean.getHhknnen(),26,"被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(),C_Hhknsei.FEMALE,"被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(),BizCurrency.valueOf(88888888888.88, BizCurrencyTypes.DOLLAR),"基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(),BizCurrency.valueOf(66666666666.66, BizCurrencyTypes.DOLLAR),"保険料");
        exDateEquals(keisanWExtBean.getKykymd(),BizDate.valueOf(20210415),"契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(),C_Tuukasyu.USD,"通貨種類");
        exNumericEquals(keisanWExtBean.getDai1hknkkn(),10,"第１保険期間");
        exClassificationEquals(keisanWExtBean.getKykJyoutai(),C_Kykjyoutai.ZENNOU,"契約状態");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), null, "為替レート基準日 ");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20210415), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.BLNK, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getZennouUmuKbn(), C_UmuKbn.ARI, "前納有無区分");
        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(66666666666.66, BizCurrencyTypes.DOLLAR), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getZennouKaisiYmd(), BizDate.valueOf(20220415), "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), BizDate.valueOf(20210415), "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), BizCurrency.valueOf(1333333333.34, BizCurrencyTypes.DOLLAR), "前納入金額");
        exClassificationEquals(wSuiihyouParam.getSdpd(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
        exClassificationEquals(wSuiihyouParam.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
    }

    @Test
    @TestOrder(410)
    public void testExecPostForm_A11() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN2;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A11"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk1(), BizNumber.valueOf(4000), "（ＩＷＳ）毎年保険料払込累計額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1(), BizNumber.valueOf(2000), "（ＩＷＳ）毎年解約返戻金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs1(), BizNumber.valueOf(1000), "（ＩＷＳ）毎年死亡保険金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk1(), BizNumber.valueOf(3000), "（ＩＷＳ）毎年前納残高１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk2(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk3(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsHrkkknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）払込期間満了直後Ｗ");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１０");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１０");

        WSuiihyouParam wSuiihyouParam = (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin3MockForSinkeiyaku.class, "exec", 0, 0);
        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exClassificationEquals(keisanWExtBean.getKykJyoutai(),C_Kykjyoutai.HRKMTYUU,"契約状態");

        exBizCalcbleEquals(wSuiihyouParam.getZennoujiHrkP(), BizCurrency.valueOf(0), "前納時払込保険料");
        exDateEquals(wSuiihyouParam.getZennouKaisiYmd(), null, "前納開始年月日");
        exDateEquals(wSuiihyouParam.getRyosyuYmd(), null, "領収日");
        exBizCalcbleEquals(wSuiihyouParam.getZennouNyuukingk(), null, "前納入金額");
    }

    @Test
    @TestOrder(420)
    public void testExecPostForm_A12() throws Exception {

        MockObjectManager.initialize();
        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN4;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A12"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk1(), BizNumber.valueOf(400000), "（ＩＷＳ）毎年保険料払込累計額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk2(), BizNumber.valueOf(440000), "（ＩＷＳ）毎年保険料払込累計額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk3(), BizNumber.valueOf(444000), "（ＩＷＳ）毎年保険料払込累計額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年保険料払込累計額９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1(), BizNumber.valueOf(200000), "（ＩＷＳ）毎年解約返戻金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2(), BizNumber.valueOf(220000), "（ＩＷＳ）毎年解約返戻金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3(), BizNumber.valueOf(222000), "（ＩＷＳ）毎年解約返戻金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年解約返戻金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs1(), BizNumber.valueOf(100000), "（ＩＷＳ）毎年死亡保険金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs2(), BizNumber.valueOf(888888), "（ＩＷＳ）毎年死亡保険金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs3(), BizNumber.valueOf(888888), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年死亡保険金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk1(), BizNumber.valueOf(300000), "（ＩＷＳ）毎年前納残高１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk2(), BizNumber.valueOf(330000), "（ＩＷＳ）毎年前納残高２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk3(), BizNumber.valueOf(333000), "（ＩＷＳ）毎年前納残高３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk4(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk5(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk6(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk7(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk8(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk9(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk10(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk11(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk12(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk13(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk14(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk15(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk16(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk17(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk18(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk19(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk20(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk21(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk22(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk23(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk24(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk25(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk26(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk27(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk28(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk29(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk30(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk31(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk32(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk33(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk34(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk35(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk36(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk37(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk38(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk39(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk40(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk41(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk42(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk43(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk44(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk45(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk46(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk47(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk48(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk49(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk50(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk51(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk52(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk53(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk54(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk55(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk56(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk57(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk58(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk59(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk60(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk61(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk62(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk63(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk64(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk65(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk66(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk67(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk68(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk69(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk70(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk71(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk72(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk73(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk74(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk75(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk76(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk77(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk78(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk79(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk80(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk81(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk82(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk83(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk84(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk85(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk86(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk87(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk88(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk89(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk90(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk91(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk92(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk93(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk94(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk95(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk96(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk97(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk98(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk99(), BizNumber.valueOf(0), "（ＩＷＳ）毎年前納残高９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsHrkkknmnryutykgw(), BizNumber.valueOf(222000), "（ＩＷＳ）払込期間満了直後Ｗ");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１０");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１０");

        WSuiihyouParam wSuiihyouParam = (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouSyuusin3MockForSinkeiyaku.class, "exec", 0, 0);
        exDateEquals(wSuiihyouParam.getZennouKaisiYmd(), BizDate.valueOf(20210228), "前納開始年月日");
    }

    @Test
    @TestOrder(430)
    public void testExecPostForm_A13() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN5;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A13"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk1(), BizNumber.valueOf(301), "（ＩＷＳ）毎年保険料払込累計額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk2(), BizNumber.valueOf(302), "（ＩＷＳ）毎年保険料払込累計額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk3(), BizNumber.valueOf(303), "（ＩＷＳ）毎年保険料払込累計額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk4(), BizNumber.valueOf(304), "（ＩＷＳ）毎年保険料払込累計額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk5(), BizNumber.valueOf(305), "（ＩＷＳ）毎年保険料払込累計額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk6(), BizNumber.valueOf(306), "（ＩＷＳ）毎年保険料払込累計額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk7(), BizNumber.valueOf(307), "（ＩＷＳ）毎年保険料払込累計額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk8(), BizNumber.valueOf(308), "（ＩＷＳ）毎年保険料払込累計額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk9(), BizNumber.valueOf(309), "（ＩＷＳ）毎年保険料払込累計額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk10(), BizNumber.valueOf(310), "（ＩＷＳ）毎年保険料払込累計額１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk11(), BizNumber.valueOf(311), "（ＩＷＳ）毎年保険料払込累計額１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk12(), BizNumber.valueOf(312), "（ＩＷＳ）毎年保険料払込累計額１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk13(), BizNumber.valueOf(313), "（ＩＷＳ）毎年保険料払込累計額１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk14(), BizNumber.valueOf(314), "（ＩＷＳ）毎年保険料払込累計額１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk15(), BizNumber.valueOf(315), "（ＩＷＳ）毎年保険料払込累計額１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk16(), BizNumber.valueOf(316), "（ＩＷＳ）毎年保険料払込累計額１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk17(), BizNumber.valueOf(317), "（ＩＷＳ）毎年保険料払込累計額１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk18(), BizNumber.valueOf(318), "（ＩＷＳ）毎年保険料払込累計額１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk19(), BizNumber.valueOf(319), "（ＩＷＳ）毎年保険料払込累計額１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk20(), BizNumber.valueOf(320), "（ＩＷＳ）毎年保険料払込累計額２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk21(), BizNumber.valueOf(321), "（ＩＷＳ）毎年保険料払込累計額２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk22(), BizNumber.valueOf(322), "（ＩＷＳ）毎年保険料払込累計額２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk23(), BizNumber.valueOf(323), "（ＩＷＳ）毎年保険料払込累計額２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk24(), BizNumber.valueOf(324), "（ＩＷＳ）毎年保険料払込累計額２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk25(), BizNumber.valueOf(325), "（ＩＷＳ）毎年保険料払込累計額２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk26(), BizNumber.valueOf(326), "（ＩＷＳ）毎年保険料払込累計額２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk27(), BizNumber.valueOf(327), "（ＩＷＳ）毎年保険料払込累計額２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk28(), BizNumber.valueOf(328), "（ＩＷＳ）毎年保険料払込累計額２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk29(), BizNumber.valueOf(329), "（ＩＷＳ）毎年保険料払込累計額２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk30(), BizNumber.valueOf(330), "（ＩＷＳ）毎年保険料払込累計額３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk31(), BizNumber.valueOf(331), "（ＩＷＳ）毎年保険料払込累計額３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk32(), BizNumber.valueOf(332), "（ＩＷＳ）毎年保険料払込累計額３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk33(), BizNumber.valueOf(333), "（ＩＷＳ）毎年保険料払込累計額３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk34(), BizNumber.valueOf(334), "（ＩＷＳ）毎年保険料払込累計額３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk35(), BizNumber.valueOf(335), "（ＩＷＳ）毎年保険料払込累計額３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk36(), BizNumber.valueOf(336), "（ＩＷＳ）毎年保険料払込累計額３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk37(), BizNumber.valueOf(337), "（ＩＷＳ）毎年保険料払込累計額３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk38(), BizNumber.valueOf(338), "（ＩＷＳ）毎年保険料払込累計額３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk39(), BizNumber.valueOf(339), "（ＩＷＳ）毎年保険料払込累計額３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk40(), BizNumber.valueOf(340), "（ＩＷＳ）毎年保険料払込累計額４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk41(), BizNumber.valueOf(341), "（ＩＷＳ）毎年保険料払込累計額４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk42(), BizNumber.valueOf(342), "（ＩＷＳ）毎年保険料払込累計額４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk43(), BizNumber.valueOf(343), "（ＩＷＳ）毎年保険料払込累計額４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk44(), BizNumber.valueOf(344), "（ＩＷＳ）毎年保険料払込累計額４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk45(), BizNumber.valueOf(345), "（ＩＷＳ）毎年保険料払込累計額４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk46(), BizNumber.valueOf(346), "（ＩＷＳ）毎年保険料払込累計額４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk47(), BizNumber.valueOf(347), "（ＩＷＳ）毎年保険料払込累計額４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk48(), BizNumber.valueOf(348), "（ＩＷＳ）毎年保険料払込累計額４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk49(), BizNumber.valueOf(349), "（ＩＷＳ）毎年保険料払込累計額４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk50(), BizNumber.valueOf(350), "（ＩＷＳ）毎年保険料払込累計額５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk51(), BizNumber.valueOf(351), "（ＩＷＳ）毎年保険料払込累計額５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk52(), BizNumber.valueOf(352), "（ＩＷＳ）毎年保険料払込累計額５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk53(), BizNumber.valueOf(353), "（ＩＷＳ）毎年保険料払込累計額５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk54(), BizNumber.valueOf(354), "（ＩＷＳ）毎年保険料払込累計額５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk55(), BizNumber.valueOf(355), "（ＩＷＳ）毎年保険料払込累計額５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk56(), BizNumber.valueOf(356), "（ＩＷＳ）毎年保険料払込累計額５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk57(), BizNumber.valueOf(357), "（ＩＷＳ）毎年保険料払込累計額５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk58(), BizNumber.valueOf(358), "（ＩＷＳ）毎年保険料払込累計額５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk59(), BizNumber.valueOf(359), "（ＩＷＳ）毎年保険料払込累計額５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk60(), BizNumber.valueOf(360), "（ＩＷＳ）毎年保険料払込累計額６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk61(), BizNumber.valueOf(361), "（ＩＷＳ）毎年保険料払込累計額６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk62(), BizNumber.valueOf(362), "（ＩＷＳ）毎年保険料払込累計額６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk63(), BizNumber.valueOf(363), "（ＩＷＳ）毎年保険料払込累計額６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk64(), BizNumber.valueOf(364), "（ＩＷＳ）毎年保険料払込累計額６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk65(), BizNumber.valueOf(365), "（ＩＷＳ）毎年保険料払込累計額６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk66(), BizNumber.valueOf(366), "（ＩＷＳ）毎年保険料払込累計額６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk67(), BizNumber.valueOf(367), "（ＩＷＳ）毎年保険料払込累計額６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk68(), BizNumber.valueOf(368), "（ＩＷＳ）毎年保険料払込累計額６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk69(), BizNumber.valueOf(369), "（ＩＷＳ）毎年保険料払込累計額６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk70(), BizNumber.valueOf(370), "（ＩＷＳ）毎年保険料払込累計額７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk71(), BizNumber.valueOf(371), "（ＩＷＳ）毎年保険料払込累計額７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk72(), BizNumber.valueOf(372), "（ＩＷＳ）毎年保険料払込累計額７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk73(), BizNumber.valueOf(373), "（ＩＷＳ）毎年保険料払込累計額７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk74(), BizNumber.valueOf(374), "（ＩＷＳ）毎年保険料払込累計額７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk75(), BizNumber.valueOf(375), "（ＩＷＳ）毎年保険料払込累計額７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk76(), BizNumber.valueOf(376), "（ＩＷＳ）毎年保険料払込累計額７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk77(), BizNumber.valueOf(377), "（ＩＷＳ）毎年保険料払込累計額７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk78(), BizNumber.valueOf(378), "（ＩＷＳ）毎年保険料払込累計額７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk79(), BizNumber.valueOf(379), "（ＩＷＳ）毎年保険料払込累計額７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk80(), BizNumber.valueOf(380), "（ＩＷＳ）毎年保険料払込累計額８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk81(), BizNumber.valueOf(381), "（ＩＷＳ）毎年保険料払込累計額８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk82(), BizNumber.valueOf(382), "（ＩＷＳ）毎年保険料払込累計額８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk83(), BizNumber.valueOf(383), "（ＩＷＳ）毎年保険料払込累計額８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk84(), BizNumber.valueOf(384), "（ＩＷＳ）毎年保険料払込累計額８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk85(), BizNumber.valueOf(385), "（ＩＷＳ）毎年保険料払込累計額８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk86(), BizNumber.valueOf(386), "（ＩＷＳ）毎年保険料払込累計額８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk87(), BizNumber.valueOf(387), "（ＩＷＳ）毎年保険料払込累計額８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk88(), BizNumber.valueOf(388), "（ＩＷＳ）毎年保険料払込累計額８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk89(), BizNumber.valueOf(389), "（ＩＷＳ）毎年保険料払込累計額８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk90(), BizNumber.valueOf(390), "（ＩＷＳ）毎年保険料払込累計額９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk91(), BizNumber.valueOf(391), "（ＩＷＳ）毎年保険料払込累計額９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk92(), BizNumber.valueOf(392), "（ＩＷＳ）毎年保険料払込累計額９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk93(), BizNumber.valueOf(393), "（ＩＷＳ）毎年保険料払込累計額９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk94(), BizNumber.valueOf(394), "（ＩＷＳ）毎年保険料払込累計額９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk95(), BizNumber.valueOf(395), "（ＩＷＳ）毎年保険料払込累計額９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk96(), BizNumber.valueOf(396), "（ＩＷＳ）毎年保険料払込累計額９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk97(), BizNumber.valueOf(397), "（ＩＷＳ）毎年保険料払込累計額９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk98(), BizNumber.valueOf(398), "（ＩＷＳ）毎年保険料払込累計額９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk99(), BizNumber.valueOf(399), "（ＩＷＳ）毎年保険料払込累計額９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1(), BizNumber.valueOf(101),"（ＩＷＳ）毎年解約返戻金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2(),BizNumber.valueOf(102),"（ＩＷＳ）毎年解約返戻金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3(),BizNumber.valueOf(103),"（ＩＷＳ）毎年解約返戻金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr4(),BizNumber.valueOf(104),"（ＩＷＳ）毎年解約返戻金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr5(),BizNumber.valueOf(105),"（ＩＷＳ）毎年解約返戻金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr6(),BizNumber.valueOf(106),"（ＩＷＳ）毎年解約返戻金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr7(),BizNumber.valueOf(107),"（ＩＷＳ）毎年解約返戻金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr8(),BizNumber.valueOf(108),"（ＩＷＳ）毎年解約返戻金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr9(),BizNumber.valueOf(109),"（ＩＷＳ）毎年解約返戻金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr10(),BizNumber.valueOf(110),"（ＩＷＳ）毎年解約返戻金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr11(),BizNumber.valueOf(111),"（ＩＷＳ）毎年解約返戻金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr12(),BizNumber.valueOf(112),"（ＩＷＳ）毎年解約返戻金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr13(),BizNumber.valueOf(113),"（ＩＷＳ）毎年解約返戻金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr14(),BizNumber.valueOf(114),"（ＩＷＳ）毎年解約返戻金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr15(),BizNumber.valueOf(115),"（ＩＷＳ）毎年解約返戻金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr16(),BizNumber.valueOf(116),"（ＩＷＳ）毎年解約返戻金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr17(),BizNumber.valueOf(117),"（ＩＷＳ）毎年解約返戻金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr18(),BizNumber.valueOf(118),"（ＩＷＳ）毎年解約返戻金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr19(),BizNumber.valueOf(119),"（ＩＷＳ）毎年解約返戻金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr20(),BizNumber.valueOf(120),"（ＩＷＳ）毎年解約返戻金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr21(),BizNumber.valueOf(121),"（ＩＷＳ）毎年解約返戻金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr22(),BizNumber.valueOf(122),"（ＩＷＳ）毎年解約返戻金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr23(),BizNumber.valueOf(123),"（ＩＷＳ）毎年解約返戻金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr24(),BizNumber.valueOf(124),"（ＩＷＳ）毎年解約返戻金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr25(),BizNumber.valueOf(125),"（ＩＷＳ）毎年解約返戻金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr26(),BizNumber.valueOf(126),"（ＩＷＳ）毎年解約返戻金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr27(),BizNumber.valueOf(127),"（ＩＷＳ）毎年解約返戻金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr28(),BizNumber.valueOf(128),"（ＩＷＳ）毎年解約返戻金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr29(),BizNumber.valueOf(129),"（ＩＷＳ）毎年解約返戻金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr30(),BizNumber.valueOf(130),"（ＩＷＳ）毎年解約返戻金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr31(),BizNumber.valueOf(131),"（ＩＷＳ）毎年解約返戻金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr32(),BizNumber.valueOf(132),"（ＩＷＳ）毎年解約返戻金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr33(),BizNumber.valueOf(133),"（ＩＷＳ）毎年解約返戻金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr34(),BizNumber.valueOf(134),"（ＩＷＳ）毎年解約返戻金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr35(),BizNumber.valueOf(135),"（ＩＷＳ）毎年解約返戻金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr36(),BizNumber.valueOf(136),"（ＩＷＳ）毎年解約返戻金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr37(),BizNumber.valueOf(137),"（ＩＷＳ）毎年解約返戻金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr38(),BizNumber.valueOf(138),"（ＩＷＳ）毎年解約返戻金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr39(),BizNumber.valueOf(139),"（ＩＷＳ）毎年解約返戻金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr40(),BizNumber.valueOf(140),"（ＩＷＳ）毎年解約返戻金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr41(),BizNumber.valueOf(141),"（ＩＷＳ）毎年解約返戻金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr42(),BizNumber.valueOf(142),"（ＩＷＳ）毎年解約返戻金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr43(),BizNumber.valueOf(143),"（ＩＷＳ）毎年解約返戻金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr44(),BizNumber.valueOf(144),"（ＩＷＳ）毎年解約返戻金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr45(),BizNumber.valueOf(145),"（ＩＷＳ）毎年解約返戻金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr46(),BizNumber.valueOf(146),"（ＩＷＳ）毎年解約返戻金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr47(),BizNumber.valueOf(147),"（ＩＷＳ）毎年解約返戻金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr48(),BizNumber.valueOf(148),"（ＩＷＳ）毎年解約返戻金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr49(),BizNumber.valueOf(149),"（ＩＷＳ）毎年解約返戻金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr50(),BizNumber.valueOf(150),"（ＩＷＳ）毎年解約返戻金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr51(),BizNumber.valueOf(151),"（ＩＷＳ）毎年解約返戻金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr52(),BizNumber.valueOf(152),"（ＩＷＳ）毎年解約返戻金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr53(),BizNumber.valueOf(153),"（ＩＷＳ）毎年解約返戻金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr54(),BizNumber.valueOf(154),"（ＩＷＳ）毎年解約返戻金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr55(),BizNumber.valueOf(155),"（ＩＷＳ）毎年解約返戻金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr56(),BizNumber.valueOf(156),"（ＩＷＳ）毎年解約返戻金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr57(),BizNumber.valueOf(157),"（ＩＷＳ）毎年解約返戻金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr58(),BizNumber.valueOf(158),"（ＩＷＳ）毎年解約返戻金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr59(),BizNumber.valueOf(159),"（ＩＷＳ）毎年解約返戻金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr60(),BizNumber.valueOf(160),"（ＩＷＳ）毎年解約返戻金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr61(),BizNumber.valueOf(161),"（ＩＷＳ）毎年解約返戻金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr62(),BizNumber.valueOf(162),"（ＩＷＳ）毎年解約返戻金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr63(),BizNumber.valueOf(163),"（ＩＷＳ）毎年解約返戻金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr64(),BizNumber.valueOf(164),"（ＩＷＳ）毎年解約返戻金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr65(),BizNumber.valueOf(165),"（ＩＷＳ）毎年解約返戻金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr66(),BizNumber.valueOf(166),"（ＩＷＳ）毎年解約返戻金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr67(),BizNumber.valueOf(167),"（ＩＷＳ）毎年解約返戻金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr68(),BizNumber.valueOf(168),"（ＩＷＳ）毎年解約返戻金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr69(),BizNumber.valueOf(169),"（ＩＷＳ）毎年解約返戻金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr70(),BizNumber.valueOf(170),"（ＩＷＳ）毎年解約返戻金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr71(),BizNumber.valueOf(171),"（ＩＷＳ）毎年解約返戻金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr72(),BizNumber.valueOf(172),"（ＩＷＳ）毎年解約返戻金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr73(),BizNumber.valueOf(173),"（ＩＷＳ）毎年解約返戻金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr74(),BizNumber.valueOf(174),"（ＩＷＳ）毎年解約返戻金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr75(),BizNumber.valueOf(175),"（ＩＷＳ）毎年解約返戻金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr76(),BizNumber.valueOf(176),"（ＩＷＳ）毎年解約返戻金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr77(),BizNumber.valueOf(177),"（ＩＷＳ）毎年解約返戻金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr78(),BizNumber.valueOf(178),"（ＩＷＳ）毎年解約返戻金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr79(),BizNumber.valueOf(179),"（ＩＷＳ）毎年解約返戻金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr80(),BizNumber.valueOf(180),"（ＩＷＳ）毎年解約返戻金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr81(),BizNumber.valueOf(181),"（ＩＷＳ）毎年解約返戻金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr82(),BizNumber.valueOf(182),"（ＩＷＳ）毎年解約返戻金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr83(),BizNumber.valueOf(183),"（ＩＷＳ）毎年解約返戻金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr84(),BizNumber.valueOf(184),"（ＩＷＳ）毎年解約返戻金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr85(),BizNumber.valueOf(185),"（ＩＷＳ）毎年解約返戻金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr86(),BizNumber.valueOf(186),"（ＩＷＳ）毎年解約返戻金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr87(),BizNumber.valueOf(187),"（ＩＷＳ）毎年解約返戻金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr88(),BizNumber.valueOf(188),"（ＩＷＳ）毎年解約返戻金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr89(),BizNumber.valueOf(189),"（ＩＷＳ）毎年解約返戻金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr90(),BizNumber.valueOf(190),"（ＩＷＳ）毎年解約返戻金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr91(),BizNumber.valueOf(191),"（ＩＷＳ）毎年解約返戻金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr92(),BizNumber.valueOf(192),"（ＩＷＳ）毎年解約返戻金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr93(),BizNumber.valueOf(193),"（ＩＷＳ）毎年解約返戻金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr94(),BizNumber.valueOf(194),"（ＩＷＳ）毎年解約返戻金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr95(),BizNumber.valueOf(195),"（ＩＷＳ）毎年解約返戻金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr96(),BizNumber.valueOf(196),"（ＩＷＳ）毎年解約返戻金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr97(),BizNumber.valueOf(197),"（ＩＷＳ）毎年解約返戻金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr98(),BizNumber.valueOf(198),"（ＩＷＳ）毎年解約返戻金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr99(),BizNumber.valueOf(199),"（ＩＷＳ）毎年解約返戻金９９");


        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs1(), BizNumber.valueOf(401), "（ＩＷＳ）毎年死亡保険金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs2(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs3(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs4(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs5(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs6(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs7(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs8(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs9(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs10(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs11(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs12(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs13(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs14(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs15(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs16(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs17(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs18(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs19(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs20(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs21(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs22(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs23(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs24(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs25(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs26(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs27(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs28(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs29(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs30(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs31(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs32(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs33(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs34(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs35(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs36(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs37(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs38(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs39(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs40(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs41(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs42(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs43(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs44(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs45(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs46(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs47(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs48(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs49(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs50(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs51(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs52(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs53(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs54(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs55(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs56(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs57(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs58(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs59(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs60(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs61(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs62(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs63(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs64(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs65(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs66(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs67(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs68(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs69(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs70(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs71(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs72(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs73(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs74(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs75(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs76(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs77(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs78(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs79(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs80(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs81(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs82(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs83(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs84(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs85(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs86(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs87(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs88(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs89(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs90(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs91(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs92(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs93(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs94(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs95(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs96(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs97(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs98(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs99(), BizNumber.valueOf(999999999), "（ＩＷＳ）毎年死亡保険金９９");


        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk1(), BizNumber.valueOf(201), "（ＩＷＳ）毎年前納残高１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk2(), BizNumber.valueOf(202), "（ＩＷＳ）毎年前納残高２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk3(), BizNumber.valueOf(203), "（ＩＷＳ）毎年前納残高３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk4(), BizNumber.valueOf(204), "（ＩＷＳ）毎年前納残高４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk5(), BizNumber.valueOf(205), "（ＩＷＳ）毎年前納残高５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk6(), BizNumber.valueOf(206), "（ＩＷＳ）毎年前納残高６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk7(), BizNumber.valueOf(207), "（ＩＷＳ）毎年前納残高７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk8(), BizNumber.valueOf(208), "（ＩＷＳ）毎年前納残高８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk9(), BizNumber.valueOf(209), "（ＩＷＳ）毎年前納残高９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk10(), BizNumber.valueOf(210), "（ＩＷＳ）毎年前納残高１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk11(), BizNumber.valueOf(211), "（ＩＷＳ）毎年前納残高１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk12(), BizNumber.valueOf(212), "（ＩＷＳ）毎年前納残高１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk13(), BizNumber.valueOf(213), "（ＩＷＳ）毎年前納残高１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk14(), BizNumber.valueOf(214), "（ＩＷＳ）毎年前納残高１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk15(), BizNumber.valueOf(215), "（ＩＷＳ）毎年前納残高１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk16(), BizNumber.valueOf(216), "（ＩＷＳ）毎年前納残高１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk17(), BizNumber.valueOf(217), "（ＩＷＳ）毎年前納残高１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk18(), BizNumber.valueOf(218), "（ＩＷＳ）毎年前納残高１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk19(), BizNumber.valueOf(219), "（ＩＷＳ）毎年前納残高１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk20(), BizNumber.valueOf(220), "（ＩＷＳ）毎年前納残高２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk21(), BizNumber.valueOf(221), "（ＩＷＳ）毎年前納残高２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk22(), BizNumber.valueOf(222), "（ＩＷＳ）毎年前納残高２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk23(), BizNumber.valueOf(223), "（ＩＷＳ）毎年前納残高２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk24(), BizNumber.valueOf(224), "（ＩＷＳ）毎年前納残高２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk25(), BizNumber.valueOf(225), "（ＩＷＳ）毎年前納残高２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk26(), BizNumber.valueOf(226), "（ＩＷＳ）毎年前納残高２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk27(), BizNumber.valueOf(227), "（ＩＷＳ）毎年前納残高２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk28(), BizNumber.valueOf(228), "（ＩＷＳ）毎年前納残高２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk29(), BizNumber.valueOf(229), "（ＩＷＳ）毎年前納残高２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk30(), BizNumber.valueOf(230), "（ＩＷＳ）毎年前納残高３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk31(), BizNumber.valueOf(231), "（ＩＷＳ）毎年前納残高３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk32(), BizNumber.valueOf(232), "（ＩＷＳ）毎年前納残高３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk33(), BizNumber.valueOf(233), "（ＩＷＳ）毎年前納残高３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk34(), BizNumber.valueOf(234), "（ＩＷＳ）毎年前納残高３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk35(), BizNumber.valueOf(235), "（ＩＷＳ）毎年前納残高３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk36(), BizNumber.valueOf(236), "（ＩＷＳ）毎年前納残高３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk37(), BizNumber.valueOf(237), "（ＩＷＳ）毎年前納残高３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk38(), BizNumber.valueOf(238), "（ＩＷＳ）毎年前納残高３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk39(), BizNumber.valueOf(239), "（ＩＷＳ）毎年前納残高３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk40(), BizNumber.valueOf(240), "（ＩＷＳ）毎年前納残高４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk41(), BizNumber.valueOf(241), "（ＩＷＳ）毎年前納残高４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk42(), BizNumber.valueOf(242), "（ＩＷＳ）毎年前納残高４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk43(), BizNumber.valueOf(243), "（ＩＷＳ）毎年前納残高４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk44(), BizNumber.valueOf(244), "（ＩＷＳ）毎年前納残高４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk45(), BizNumber.valueOf(245), "（ＩＷＳ）毎年前納残高４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk46(), BizNumber.valueOf(246), "（ＩＷＳ）毎年前納残高４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk47(), BizNumber.valueOf(247), "（ＩＷＳ）毎年前納残高４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk48(), BizNumber.valueOf(248), "（ＩＷＳ）毎年前納残高４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk49(), BizNumber.valueOf(249), "（ＩＷＳ）毎年前納残高４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk50(), BizNumber.valueOf(250), "（ＩＷＳ）毎年前納残高５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk51(), BizNumber.valueOf(251), "（ＩＷＳ）毎年前納残高５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk52(), BizNumber.valueOf(252), "（ＩＷＳ）毎年前納残高５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk53(), BizNumber.valueOf(253), "（ＩＷＳ）毎年前納残高５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk54(), BizNumber.valueOf(254), "（ＩＷＳ）毎年前納残高５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk55(), BizNumber.valueOf(255), "（ＩＷＳ）毎年前納残高５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk56(), BizNumber.valueOf(256), "（ＩＷＳ）毎年前納残高５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk57(), BizNumber.valueOf(257), "（ＩＷＳ）毎年前納残高５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk58(), BizNumber.valueOf(258), "（ＩＷＳ）毎年前納残高５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk59(), BizNumber.valueOf(259), "（ＩＷＳ）毎年前納残高５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk60(), BizNumber.valueOf(260), "（ＩＷＳ）毎年前納残高６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk61(), BizNumber.valueOf(261), "（ＩＷＳ）毎年前納残高６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk62(), BizNumber.valueOf(262), "（ＩＷＳ）毎年前納残高６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk63(), BizNumber.valueOf(263), "（ＩＷＳ）毎年前納残高６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk64(), BizNumber.valueOf(264), "（ＩＷＳ）毎年前納残高６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk65(), BizNumber.valueOf(265), "（ＩＷＳ）毎年前納残高６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk66(), BizNumber.valueOf(266), "（ＩＷＳ）毎年前納残高６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk67(), BizNumber.valueOf(267), "（ＩＷＳ）毎年前納残高６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk68(), BizNumber.valueOf(268), "（ＩＷＳ）毎年前納残高６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk69(), BizNumber.valueOf(269), "（ＩＷＳ）毎年前納残高６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk70(), BizNumber.valueOf(270), "（ＩＷＳ）毎年前納残高７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk71(), BizNumber.valueOf(271), "（ＩＷＳ）毎年前納残高７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk72(), BizNumber.valueOf(272), "（ＩＷＳ）毎年前納残高７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk73(), BizNumber.valueOf(273), "（ＩＷＳ）毎年前納残高７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk74(), BizNumber.valueOf(274), "（ＩＷＳ）毎年前納残高７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk75(), BizNumber.valueOf(275), "（ＩＷＳ）毎年前納残高７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk76(), BizNumber.valueOf(276), "（ＩＷＳ）毎年前納残高７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk77(), BizNumber.valueOf(277), "（ＩＷＳ）毎年前納残高７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk78(), BizNumber.valueOf(278), "（ＩＷＳ）毎年前納残高７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk79(), BizNumber.valueOf(279), "（ＩＷＳ）毎年前納残高７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk80(), BizNumber.valueOf(280), "（ＩＷＳ）毎年前納残高８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk81(), BizNumber.valueOf(281), "（ＩＷＳ）毎年前納残高８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk82(), BizNumber.valueOf(282), "（ＩＷＳ）毎年前納残高８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk83(), BizNumber.valueOf(283), "（ＩＷＳ）毎年前納残高８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk84(), BizNumber.valueOf(284), "（ＩＷＳ）毎年前納残高８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk85(), BizNumber.valueOf(285), "（ＩＷＳ）毎年前納残高８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk86(), BizNumber.valueOf(286), "（ＩＷＳ）毎年前納残高８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk87(), BizNumber.valueOf(287), "（ＩＷＳ）毎年前納残高８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk88(), BizNumber.valueOf(288), "（ＩＷＳ）毎年前納残高８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk89(), BizNumber.valueOf(289), "（ＩＷＳ）毎年前納残高８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk90(), BizNumber.valueOf(290), "（ＩＷＳ）毎年前納残高９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk91(), BizNumber.valueOf(291), "（ＩＷＳ）毎年前納残高９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk92(), BizNumber.valueOf(292), "（ＩＷＳ）毎年前納残高９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk93(), BizNumber.valueOf(293), "（ＩＷＳ）毎年前納残高９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk94(), BizNumber.valueOf(294), "（ＩＷＳ）毎年前納残高９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk95(), BizNumber.valueOf(295), "（ＩＷＳ）毎年前納残高９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk96(), BizNumber.valueOf(296), "（ＩＷＳ）毎年前納残高９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk97(), BizNumber.valueOf(297), "（ＩＷＳ）毎年前納残高９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk98(), BizNumber.valueOf(298), "（ＩＷＳ）毎年前納残高９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk99(), BizNumber.valueOf(299), "（ＩＷＳ）毎年前納残高９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsHrkkknmnryutykgw(), BizNumber.valueOf(199), "（ＩＷＳ）払込期間満了直後Ｗ");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１０");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１０");
    }

    @Test
    @TestOrder(440)
    public void testExecPostForm_A14() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN6;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A14"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(450)
    public void testExecPostForm_A15() throws Exception {

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A15"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), "システムエラーが発生しました　住友生命に連絡してください", "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebNenkinKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(460)
    public void testExecPostForm_A16() throws Exception {

        MockObjectManager.initialize();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        WSuiihyouSyuusin3MockForSinkeiyaku.SYORIPTN = WSuiihyouSyuusin3MockForSinkeiyaku.TESTPATTERN7;

        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        pMap.add("gyoumuData", gyoumuInfoMap.get("testExecPostForm_A16"));
        pMap.add("operatorId", "testId");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebheijyunkaiyakuhrsuii.HbSeihoWebHeijyunKaiyakuhrSuii");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebHeijyunKaiyakuhrSuiiImpl.execPostForm(pMap);

        WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean = FixedlengthConvertUtil
            .stringToBeanForFixedlength(wsBzWebserviceResParamBean.getGyoumuData(),
                WsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.class);

        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg1(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ１");
        exStringEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsSekmoserrormsg2(), null, "（ＩＷＳ）設計書申込書作成エラーメッセージ２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk1(), BizNumber.valueOf(301), "（ＩＷＳ）毎年保険料払込累計額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk2(), BizNumber.valueOf(302), "（ＩＷＳ）毎年保険料払込累計額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk3(), BizNumber.valueOf(303), "（ＩＷＳ）毎年保険料払込累計額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk4(), BizNumber.valueOf(304), "（ＩＷＳ）毎年保険料払込累計額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk5(), BizNumber.valueOf(305), "（ＩＷＳ）毎年保険料払込累計額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk6(), BizNumber.valueOf(306), "（ＩＷＳ）毎年保険料払込累計額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk7(), BizNumber.valueOf(307), "（ＩＷＳ）毎年保険料払込累計額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk8(), BizNumber.valueOf(308), "（ＩＷＳ）毎年保険料払込累計額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk9(), BizNumber.valueOf(309), "（ＩＷＳ）毎年保険料払込累計額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk10(), BizNumber.valueOf(310), "（ＩＷＳ）毎年保険料払込累計額１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk11(), BizNumber.valueOf(311), "（ＩＷＳ）毎年保険料払込累計額１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk12(), BizNumber.valueOf(312), "（ＩＷＳ）毎年保険料払込累計額１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk13(), BizNumber.valueOf(313), "（ＩＷＳ）毎年保険料払込累計額１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk14(), BizNumber.valueOf(314), "（ＩＷＳ）毎年保険料払込累計額１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk15(), BizNumber.valueOf(315), "（ＩＷＳ）毎年保険料払込累計額１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk16(), BizNumber.valueOf(316), "（ＩＷＳ）毎年保険料払込累計額１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk17(), BizNumber.valueOf(317), "（ＩＷＳ）毎年保険料払込累計額１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk18(), BizNumber.valueOf(318), "（ＩＷＳ）毎年保険料払込累計額１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk19(), BizNumber.valueOf(319), "（ＩＷＳ）毎年保険料払込累計額１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk20(), BizNumber.valueOf(320), "（ＩＷＳ）毎年保険料払込累計額２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk21(), BizNumber.valueOf(321), "（ＩＷＳ）毎年保険料払込累計額２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk22(), BizNumber.valueOf(322), "（ＩＷＳ）毎年保険料払込累計額２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk23(), BizNumber.valueOf(323), "（ＩＷＳ）毎年保険料払込累計額２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk24(), BizNumber.valueOf(324), "（ＩＷＳ）毎年保険料払込累計額２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk25(), BizNumber.valueOf(325), "（ＩＷＳ）毎年保険料払込累計額２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk26(), BizNumber.valueOf(326), "（ＩＷＳ）毎年保険料払込累計額２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk27(), BizNumber.valueOf(327), "（ＩＷＳ）毎年保険料払込累計額２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk28(), BizNumber.valueOf(328), "（ＩＷＳ）毎年保険料払込累計額２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk29(), BizNumber.valueOf(329), "（ＩＷＳ）毎年保険料払込累計額２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk30(), BizNumber.valueOf(330), "（ＩＷＳ）毎年保険料払込累計額３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk31(), BizNumber.valueOf(331), "（ＩＷＳ）毎年保険料払込累計額３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk32(), BizNumber.valueOf(332), "（ＩＷＳ）毎年保険料払込累計額３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk33(), BizNumber.valueOf(333), "（ＩＷＳ）毎年保険料払込累計額３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk34(), BizNumber.valueOf(334), "（ＩＷＳ）毎年保険料払込累計額３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk35(), BizNumber.valueOf(335), "（ＩＷＳ）毎年保険料払込累計額３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk36(), BizNumber.valueOf(336), "（ＩＷＳ）毎年保険料払込累計額３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk37(), BizNumber.valueOf(337), "（ＩＷＳ）毎年保険料払込累計額３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk38(), BizNumber.valueOf(338), "（ＩＷＳ）毎年保険料払込累計額３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk39(), BizNumber.valueOf(339), "（ＩＷＳ）毎年保険料払込累計額３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk40(), BizNumber.valueOf(340), "（ＩＷＳ）毎年保険料払込累計額４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk41(), BizNumber.valueOf(341), "（ＩＷＳ）毎年保険料払込累計額４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk42(), BizNumber.valueOf(342), "（ＩＷＳ）毎年保険料払込累計額４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk43(), BizNumber.valueOf(343), "（ＩＷＳ）毎年保険料払込累計額４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk44(), BizNumber.valueOf(344), "（ＩＷＳ）毎年保険料払込累計額４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk45(), BizNumber.valueOf(345), "（ＩＷＳ）毎年保険料払込累計額４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk46(), BizNumber.valueOf(346), "（ＩＷＳ）毎年保険料払込累計額４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk47(), BizNumber.valueOf(347), "（ＩＷＳ）毎年保険料払込累計額４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk48(), BizNumber.valueOf(348), "（ＩＷＳ）毎年保険料払込累計額４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk49(), BizNumber.valueOf(349), "（ＩＷＳ）毎年保険料払込累計額４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk50(), BizNumber.valueOf(350), "（ＩＷＳ）毎年保険料払込累計額５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk51(), BizNumber.valueOf(351), "（ＩＷＳ）毎年保険料払込累計額５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk52(), BizNumber.valueOf(352), "（ＩＷＳ）毎年保険料払込累計額５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk53(), BizNumber.valueOf(353), "（ＩＷＳ）毎年保険料払込累計額５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk54(), BizNumber.valueOf(354), "（ＩＷＳ）毎年保険料払込累計額５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk55(), BizNumber.valueOf(355), "（ＩＷＳ）毎年保険料払込累計額５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk56(), BizNumber.valueOf(356), "（ＩＷＳ）毎年保険料払込累計額５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk57(), BizNumber.valueOf(357), "（ＩＷＳ）毎年保険料払込累計額５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk58(), BizNumber.valueOf(358), "（ＩＷＳ）毎年保険料払込累計額５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk59(), BizNumber.valueOf(359), "（ＩＷＳ）毎年保険料払込累計額５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk60(), BizNumber.valueOf(360), "（ＩＷＳ）毎年保険料払込累計額６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk61(), BizNumber.valueOf(361), "（ＩＷＳ）毎年保険料払込累計額６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk62(), BizNumber.valueOf(362), "（ＩＷＳ）毎年保険料払込累計額６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk63(), BizNumber.valueOf(363), "（ＩＷＳ）毎年保険料払込累計額６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk64(), BizNumber.valueOf(364), "（ＩＷＳ）毎年保険料払込累計額６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk65(), BizNumber.valueOf(365), "（ＩＷＳ）毎年保険料払込累計額６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk66(), BizNumber.valueOf(366), "（ＩＷＳ）毎年保険料払込累計額６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk67(), BizNumber.valueOf(367), "（ＩＷＳ）毎年保険料払込累計額６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk68(), BizNumber.valueOf(368), "（ＩＷＳ）毎年保険料払込累計額６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk69(), BizNumber.valueOf(369), "（ＩＷＳ）毎年保険料払込累計額６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk70(), BizNumber.valueOf(370), "（ＩＷＳ）毎年保険料払込累計額７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk71(), BizNumber.valueOf(371), "（ＩＷＳ）毎年保険料払込累計額７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk72(), BizNumber.valueOf(372), "（ＩＷＳ）毎年保険料払込累計額７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk73(), BizNumber.valueOf(373), "（ＩＷＳ）毎年保険料払込累計額７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk74(), BizNumber.valueOf(374), "（ＩＷＳ）毎年保険料払込累計額７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk75(), BizNumber.valueOf(375), "（ＩＷＳ）毎年保険料払込累計額７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk76(), BizNumber.valueOf(376), "（ＩＷＳ）毎年保険料払込累計額７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk77(), BizNumber.valueOf(377), "（ＩＷＳ）毎年保険料払込累計額７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk78(), BizNumber.valueOf(378), "（ＩＷＳ）毎年保険料払込累計額７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk79(), BizNumber.valueOf(379), "（ＩＷＳ）毎年保険料払込累計額７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk80(), BizNumber.valueOf(380), "（ＩＷＳ）毎年保険料払込累計額８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk81(), BizNumber.valueOf(381), "（ＩＷＳ）毎年保険料払込累計額８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk82(), BizNumber.valueOf(382), "（ＩＷＳ）毎年保険料払込累計額８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk83(), BizNumber.valueOf(383), "（ＩＷＳ）毎年保険料払込累計額８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk84(), BizNumber.valueOf(384), "（ＩＷＳ）毎年保険料払込累計額８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk85(), BizNumber.valueOf(385), "（ＩＷＳ）毎年保険料払込累計額８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk86(), BizNumber.valueOf(386), "（ＩＷＳ）毎年保険料払込累計額８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk87(), BizNumber.valueOf(387), "（ＩＷＳ）毎年保険料払込累計額８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk88(), BizNumber.valueOf(388), "（ＩＷＳ）毎年保険料払込累計額８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk89(), BizNumber.valueOf(389), "（ＩＷＳ）毎年保険料払込累計額８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk90(), BizNumber.valueOf(390), "（ＩＷＳ）毎年保険料払込累計額９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk91(), BizNumber.valueOf(391), "（ＩＷＳ）毎年保険料払込累計額９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk92(), BizNumber.valueOf(392), "（ＩＷＳ）毎年保険料払込累計額９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk93(), BizNumber.valueOf(393), "（ＩＷＳ）毎年保険料払込累計額９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk94(), BizNumber.valueOf(394), "（ＩＷＳ）毎年保険料払込累計額９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk95(), BizNumber.valueOf(395), "（ＩＷＳ）毎年保険料払込累計額９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk96(), BizNumber.valueOf(396), "（ＩＷＳ）毎年保険料払込累計額９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk97(), BizNumber.valueOf(397), "（ＩＷＳ）毎年保険料払込累計額９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk98(), BizNumber.valueOf(398), "（ＩＷＳ）毎年保険料払込累計額９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiphrkrkgk99(), BizNumber.valueOf(399), "（ＩＷＳ）毎年保険料払込累計額９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr1(), BizNumber.valueOf(101),"（ＩＷＳ）毎年解約返戻金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr2(),BizNumber.valueOf(102),"（ＩＷＳ）毎年解約返戻金２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr3(),BizNumber.valueOf(103),"（ＩＷＳ）毎年解約返戻金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr4(),BizNumber.valueOf(104),"（ＩＷＳ）毎年解約返戻金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr5(),BizNumber.valueOf(105),"（ＩＷＳ）毎年解約返戻金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr6(),BizNumber.valueOf(106),"（ＩＷＳ）毎年解約返戻金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr7(),BizNumber.valueOf(107),"（ＩＷＳ）毎年解約返戻金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr8(),BizNumber.valueOf(108),"（ＩＷＳ）毎年解約返戻金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr9(),BizNumber.valueOf(109),"（ＩＷＳ）毎年解約返戻金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr10(),BizNumber.valueOf(110),"（ＩＷＳ）毎年解約返戻金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr11(),BizNumber.valueOf(111),"（ＩＷＳ）毎年解約返戻金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr12(),BizNumber.valueOf(112),"（ＩＷＳ）毎年解約返戻金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr13(),BizNumber.valueOf(113),"（ＩＷＳ）毎年解約返戻金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr14(),BizNumber.valueOf(114),"（ＩＷＳ）毎年解約返戻金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr15(),BizNumber.valueOf(115),"（ＩＷＳ）毎年解約返戻金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr16(),BizNumber.valueOf(116),"（ＩＷＳ）毎年解約返戻金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr17(),BizNumber.valueOf(117),"（ＩＷＳ）毎年解約返戻金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr18(),BizNumber.valueOf(118),"（ＩＷＳ）毎年解約返戻金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr19(),BizNumber.valueOf(119),"（ＩＷＳ）毎年解約返戻金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr20(),BizNumber.valueOf(120),"（ＩＷＳ）毎年解約返戻金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr21(),BizNumber.valueOf(121),"（ＩＷＳ）毎年解約返戻金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr22(),BizNumber.valueOf(122),"（ＩＷＳ）毎年解約返戻金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr23(),BizNumber.valueOf(123),"（ＩＷＳ）毎年解約返戻金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr24(),BizNumber.valueOf(124),"（ＩＷＳ）毎年解約返戻金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr25(),BizNumber.valueOf(125),"（ＩＷＳ）毎年解約返戻金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr26(),BizNumber.valueOf(126),"（ＩＷＳ）毎年解約返戻金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr27(),BizNumber.valueOf(127),"（ＩＷＳ）毎年解約返戻金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr28(),BizNumber.valueOf(128),"（ＩＷＳ）毎年解約返戻金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr29(),BizNumber.valueOf(129),"（ＩＷＳ）毎年解約返戻金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr30(),BizNumber.valueOf(130),"（ＩＷＳ）毎年解約返戻金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr31(),BizNumber.valueOf(131),"（ＩＷＳ）毎年解約返戻金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr32(),BizNumber.valueOf(132),"（ＩＷＳ）毎年解約返戻金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr33(),BizNumber.valueOf(133),"（ＩＷＳ）毎年解約返戻金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr34(),BizNumber.valueOf(134),"（ＩＷＳ）毎年解約返戻金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr35(),BizNumber.valueOf(135),"（ＩＷＳ）毎年解約返戻金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr36(),BizNumber.valueOf(136),"（ＩＷＳ）毎年解約返戻金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr37(),BizNumber.valueOf(137),"（ＩＷＳ）毎年解約返戻金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr38(),BizNumber.valueOf(138),"（ＩＷＳ）毎年解約返戻金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr39(),BizNumber.valueOf(139),"（ＩＷＳ）毎年解約返戻金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr40(),BizNumber.valueOf(140),"（ＩＷＳ）毎年解約返戻金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr41(),BizNumber.valueOf(141),"（ＩＷＳ）毎年解約返戻金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr42(),BizNumber.valueOf(142),"（ＩＷＳ）毎年解約返戻金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr43(),BizNumber.valueOf(143),"（ＩＷＳ）毎年解約返戻金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr44(),BizNumber.valueOf(144),"（ＩＷＳ）毎年解約返戻金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr45(),BizNumber.valueOf(145),"（ＩＷＳ）毎年解約返戻金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr46(),BizNumber.valueOf(146),"（ＩＷＳ）毎年解約返戻金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr47(),BizNumber.valueOf(147),"（ＩＷＳ）毎年解約返戻金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr48(),BizNumber.valueOf(148),"（ＩＷＳ）毎年解約返戻金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr49(),BizNumber.valueOf(149),"（ＩＷＳ）毎年解約返戻金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr50(),BizNumber.valueOf(150),"（ＩＷＳ）毎年解約返戻金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr51(),BizNumber.valueOf(151),"（ＩＷＳ）毎年解約返戻金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr52(),BizNumber.valueOf(152),"（ＩＷＳ）毎年解約返戻金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr53(),BizNumber.valueOf(153),"（ＩＷＳ）毎年解約返戻金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr54(),BizNumber.valueOf(154),"（ＩＷＳ）毎年解約返戻金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr55(),BizNumber.valueOf(155),"（ＩＷＳ）毎年解約返戻金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr56(),BizNumber.valueOf(156),"（ＩＷＳ）毎年解約返戻金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr57(),BizNumber.valueOf(157),"（ＩＷＳ）毎年解約返戻金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr58(),BizNumber.valueOf(158),"（ＩＷＳ）毎年解約返戻金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr59(),BizNumber.valueOf(159),"（ＩＷＳ）毎年解約返戻金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr60(),BizNumber.valueOf(160),"（ＩＷＳ）毎年解約返戻金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr61(),BizNumber.valueOf(161),"（ＩＷＳ）毎年解約返戻金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr62(),BizNumber.valueOf(162),"（ＩＷＳ）毎年解約返戻金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr63(),BizNumber.valueOf(163),"（ＩＷＳ）毎年解約返戻金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr64(),BizNumber.valueOf(164),"（ＩＷＳ）毎年解約返戻金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr65(),BizNumber.valueOf(165),"（ＩＷＳ）毎年解約返戻金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr66(),BizNumber.valueOf(166),"（ＩＷＳ）毎年解約返戻金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr67(),BizNumber.valueOf(167),"（ＩＷＳ）毎年解約返戻金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr68(),BizNumber.valueOf(168),"（ＩＷＳ）毎年解約返戻金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr69(),BizNumber.valueOf(169),"（ＩＷＳ）毎年解約返戻金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr70(),BizNumber.valueOf(170),"（ＩＷＳ）毎年解約返戻金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr71(),BizNumber.valueOf(171),"（ＩＷＳ）毎年解約返戻金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr72(),BizNumber.valueOf(172),"（ＩＷＳ）毎年解約返戻金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr73(),BizNumber.valueOf(173),"（ＩＷＳ）毎年解約返戻金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr74(),BizNumber.valueOf(174),"（ＩＷＳ）毎年解約返戻金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr75(),BizNumber.valueOf(175),"（ＩＷＳ）毎年解約返戻金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr76(),BizNumber.valueOf(176),"（ＩＷＳ）毎年解約返戻金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr77(),BizNumber.valueOf(177),"（ＩＷＳ）毎年解約返戻金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr78(),BizNumber.valueOf(178),"（ＩＷＳ）毎年解約返戻金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr79(),BizNumber.valueOf(179),"（ＩＷＳ）毎年解約返戻金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr80(),BizNumber.valueOf(180),"（ＩＷＳ）毎年解約返戻金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr81(),BizNumber.valueOf(181),"（ＩＷＳ）毎年解約返戻金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr82(),BizNumber.valueOf(182),"（ＩＷＳ）毎年解約返戻金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr83(),BizNumber.valueOf(183),"（ＩＷＳ）毎年解約返戻金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr84(),BizNumber.valueOf(184),"（ＩＷＳ）毎年解約返戻金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr85(),BizNumber.valueOf(185),"（ＩＷＳ）毎年解約返戻金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr86(),BizNumber.valueOf(186),"（ＩＷＳ）毎年解約返戻金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr87(),BizNumber.valueOf(187),"（ＩＷＳ）毎年解約返戻金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr88(),BizNumber.valueOf(188),"（ＩＷＳ）毎年解約返戻金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr89(),BizNumber.valueOf(189),"（ＩＷＳ）毎年解約返戻金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr90(),BizNumber.valueOf(190),"（ＩＷＳ）毎年解約返戻金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr91(),BizNumber.valueOf(191),"（ＩＷＳ）毎年解約返戻金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr92(),BizNumber.valueOf(192),"（ＩＷＳ）毎年解約返戻金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr93(),BizNumber.valueOf(193),"（ＩＷＳ）毎年解約返戻金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr94(),BizNumber.valueOf(194),"（ＩＷＳ）毎年解約返戻金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr95(),BizNumber.valueOf(195),"（ＩＷＳ）毎年解約返戻金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr96(),BizNumber.valueOf(196),"（ＩＷＳ）毎年解約返戻金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr97(),BizNumber.valueOf(197),"（ＩＷＳ）毎年解約返戻金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr98(),BizNumber.valueOf(198),"（ＩＷＳ）毎年解約返戻金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosikaiyakuhr99(),BizNumber.valueOf(199),"（ＩＷＳ）毎年解約返戻金９９");


        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs1(), BizNumber.valueOf(401), "（ＩＷＳ）毎年死亡保険金１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs2(), BizNumber.valueOf(402), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs3(), BizNumber.valueOf(403), "（ＩＷＳ）毎年死亡保険金３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs4(), BizNumber.valueOf(404), "（ＩＷＳ）毎年死亡保険金４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs5(), BizNumber.valueOf(405), "（ＩＷＳ）毎年死亡保険金５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs6(), BizNumber.valueOf(406), "（ＩＷＳ）毎年死亡保険金６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs7(), BizNumber.valueOf(407), "（ＩＷＳ）毎年死亡保険金７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs8(), BizNumber.valueOf(408), "（ＩＷＳ）毎年死亡保険金８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs9(), BizNumber.valueOf(409), "（ＩＷＳ）毎年死亡保険金９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs10(), BizNumber.valueOf(410), "（ＩＷＳ）毎年死亡保険金１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs11(), BizNumber.valueOf(411), "（ＩＷＳ）毎年死亡保険金１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs12(), BizNumber.valueOf(412), "（ＩＷＳ）毎年死亡保険金１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs13(), BizNumber.valueOf(413), "（ＩＷＳ）毎年死亡保険金１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs14(), BizNumber.valueOf(414), "（ＩＷＳ）毎年死亡保険金１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs15(), BizNumber.valueOf(415), "（ＩＷＳ）毎年死亡保険金１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs16(), BizNumber.valueOf(416), "（ＩＷＳ）毎年死亡保険金１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs17(), BizNumber.valueOf(417), "（ＩＷＳ）毎年死亡保険金１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs18(), BizNumber.valueOf(418), "（ＩＷＳ）毎年死亡保険金１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs19(), BizNumber.valueOf(419), "（ＩＷＳ）毎年死亡保険金１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs20(), BizNumber.valueOf(420), "（ＩＷＳ）毎年死亡保険金２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs21(), BizNumber.valueOf(421), "（ＩＷＳ）毎年死亡保険金２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs22(), BizNumber.valueOf(422), "（ＩＷＳ）毎年死亡保険金２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs23(), BizNumber.valueOf(423), "（ＩＷＳ）毎年死亡保険金２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs24(), BizNumber.valueOf(424), "（ＩＷＳ）毎年死亡保険金２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs25(), BizNumber.valueOf(425), "（ＩＷＳ）毎年死亡保険金２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs26(), BizNumber.valueOf(426), "（ＩＷＳ）毎年死亡保険金２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs27(), BizNumber.valueOf(427), "（ＩＷＳ）毎年死亡保険金２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs28(), BizNumber.valueOf(428), "（ＩＷＳ）毎年死亡保険金２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs29(), BizNumber.valueOf(429), "（ＩＷＳ）毎年死亡保険金２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs30(), BizNumber.valueOf(430), "（ＩＷＳ）毎年死亡保険金３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs31(), BizNumber.valueOf(431), "（ＩＷＳ）毎年死亡保険金３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs32(), BizNumber.valueOf(432), "（ＩＷＳ）毎年死亡保険金３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs33(), BizNumber.valueOf(433), "（ＩＷＳ）毎年死亡保険金３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs34(), BizNumber.valueOf(434), "（ＩＷＳ）毎年死亡保険金３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs35(), BizNumber.valueOf(435), "（ＩＷＳ）毎年死亡保険金３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs36(), BizNumber.valueOf(436), "（ＩＷＳ）毎年死亡保険金３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs37(), BizNumber.valueOf(437), "（ＩＷＳ）毎年死亡保険金３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs38(), BizNumber.valueOf(438), "（ＩＷＳ）毎年死亡保険金３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs39(), BizNumber.valueOf(439), "（ＩＷＳ）毎年死亡保険金３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs40(), BizNumber.valueOf(440), "（ＩＷＳ）毎年死亡保険金４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs41(), BizNumber.valueOf(441), "（ＩＷＳ）毎年死亡保険金４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs42(), BizNumber.valueOf(442), "（ＩＷＳ）毎年死亡保険金４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs43(), BizNumber.valueOf(443), "（ＩＷＳ）毎年死亡保険金４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs44(), BizNumber.valueOf(444), "（ＩＷＳ）毎年死亡保険金４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs45(), BizNumber.valueOf(445), "（ＩＷＳ）毎年死亡保険金４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs46(), BizNumber.valueOf(446), "（ＩＷＳ）毎年死亡保険金４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs47(), BizNumber.valueOf(447), "（ＩＷＳ）毎年死亡保険金４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs48(), BizNumber.valueOf(448), "（ＩＷＳ）毎年死亡保険金４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs49(), BizNumber.valueOf(449), "（ＩＷＳ）毎年死亡保険金４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs50(), BizNumber.valueOf(450), "（ＩＷＳ）毎年死亡保険金５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs51(), BizNumber.valueOf(451), "（ＩＷＳ）毎年死亡保険金５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs52(), BizNumber.valueOf(452), "（ＩＷＳ）毎年死亡保険金５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs53(), BizNumber.valueOf(453), "（ＩＷＳ）毎年死亡保険金５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs54(), BizNumber.valueOf(454), "（ＩＷＳ）毎年死亡保険金５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs55(), BizNumber.valueOf(455), "（ＩＷＳ）毎年死亡保険金５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs56(), BizNumber.valueOf(456), "（ＩＷＳ）毎年死亡保険金５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs57(), BizNumber.valueOf(457), "（ＩＷＳ）毎年死亡保険金５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs58(), BizNumber.valueOf(458), "（ＩＷＳ）毎年死亡保険金５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs59(), BizNumber.valueOf(459), "（ＩＷＳ）毎年死亡保険金５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs60(), BizNumber.valueOf(460), "（ＩＷＳ）毎年死亡保険金６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs61(), BizNumber.valueOf(461), "（ＩＷＳ）毎年死亡保険金６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs62(), BizNumber.valueOf(462), "（ＩＷＳ）毎年死亡保険金６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs63(), BizNumber.valueOf(463), "（ＩＷＳ）毎年死亡保険金６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs64(), BizNumber.valueOf(464), "（ＩＷＳ）毎年死亡保険金６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs65(), BizNumber.valueOf(465), "（ＩＷＳ）毎年死亡保険金６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs66(), BizNumber.valueOf(466), "（ＩＷＳ）毎年死亡保険金６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs67(), BizNumber.valueOf(467), "（ＩＷＳ）毎年死亡保険金６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs68(), BizNumber.valueOf(468), "（ＩＷＳ）毎年死亡保険金６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs69(), BizNumber.valueOf(469), "（ＩＷＳ）毎年死亡保険金６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs70(), BizNumber.valueOf(470), "（ＩＷＳ）毎年死亡保険金７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs71(), BizNumber.valueOf(471), "（ＩＷＳ）毎年死亡保険金７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs72(), BizNumber.valueOf(472), "（ＩＷＳ）毎年死亡保険金７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs73(), BizNumber.valueOf(473), "（ＩＷＳ）毎年死亡保険金７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs74(), BizNumber.valueOf(474), "（ＩＷＳ）毎年死亡保険金７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs75(), BizNumber.valueOf(475), "（ＩＷＳ）毎年死亡保険金７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs76(), BizNumber.valueOf(476), "（ＩＷＳ）毎年死亡保険金７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs77(), BizNumber.valueOf(477), "（ＩＷＳ）毎年死亡保険金７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs78(), BizNumber.valueOf(478), "（ＩＷＳ）毎年死亡保険金７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs79(), BizNumber.valueOf(479), "（ＩＷＳ）毎年死亡保険金７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs80(), BizNumber.valueOf(480), "（ＩＷＳ）毎年死亡保険金８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs81(), BizNumber.valueOf(481), "（ＩＷＳ）毎年死亡保険金８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs82(), BizNumber.valueOf(482), "（ＩＷＳ）毎年死亡保険金８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs83(), BizNumber.valueOf(483), "（ＩＷＳ）毎年死亡保険金８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs84(), BizNumber.valueOf(484), "（ＩＷＳ）毎年死亡保険金８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs85(), BizNumber.valueOf(485), "（ＩＷＳ）毎年死亡保険金８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs86(), BizNumber.valueOf(486), "（ＩＷＳ）毎年死亡保険金８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs87(), BizNumber.valueOf(487), "（ＩＷＳ）毎年死亡保険金８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs88(), BizNumber.valueOf(488), "（ＩＷＳ）毎年死亡保険金８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs89(), BizNumber.valueOf(489), "（ＩＷＳ）毎年死亡保険金８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs90(), BizNumber.valueOf(490), "（ＩＷＳ）毎年死亡保険金９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs91(), BizNumber.valueOf(491), "（ＩＷＳ）毎年死亡保険金９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs92(), BizNumber.valueOf(492), "（ＩＷＳ）毎年死亡保険金９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs93(), BizNumber.valueOf(493), "（ＩＷＳ）毎年死亡保険金９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs94(), BizNumber.valueOf(494), "（ＩＷＳ）毎年死亡保険金９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs95(), BizNumber.valueOf(495), "（ＩＷＳ）毎年死亡保険金９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs96(), BizNumber.valueOf(496), "（ＩＷＳ）毎年死亡保険金９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs97(), BizNumber.valueOf(497), "（ＩＷＳ）毎年死亡保険金９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs98(), BizNumber.valueOf(498), "（ＩＷＳ）毎年死亡保険金９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosisbs99(), BizNumber.valueOf(499), "（ＩＷＳ）毎年死亡保険金９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk1(), BizNumber.valueOf(201), "（ＩＷＳ）毎年前納残高１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk2(), BizNumber.valueOf(202), "（ＩＷＳ）毎年前納残高２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk3(), BizNumber.valueOf(203), "（ＩＷＳ）毎年前納残高３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk4(), BizNumber.valueOf(204), "（ＩＷＳ）毎年前納残高４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk5(), BizNumber.valueOf(205), "（ＩＷＳ）毎年前納残高５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk6(), BizNumber.valueOf(206), "（ＩＷＳ）毎年前納残高６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk7(), BizNumber.valueOf(207), "（ＩＷＳ）毎年前納残高７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk8(), BizNumber.valueOf(208), "（ＩＷＳ）毎年前納残高８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk9(), BizNumber.valueOf(209), "（ＩＷＳ）毎年前納残高９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk10(), BizNumber.valueOf(210), "（ＩＷＳ）毎年前納残高１０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk11(), BizNumber.valueOf(211), "（ＩＷＳ）毎年前納残高１１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk12(), BizNumber.valueOf(212), "（ＩＷＳ）毎年前納残高１２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk13(), BizNumber.valueOf(213), "（ＩＷＳ）毎年前納残高１３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk14(), BizNumber.valueOf(214), "（ＩＷＳ）毎年前納残高１４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk15(), BizNumber.valueOf(215), "（ＩＷＳ）毎年前納残高１５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk16(), BizNumber.valueOf(216), "（ＩＷＳ）毎年前納残高１６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk17(), BizNumber.valueOf(217), "（ＩＷＳ）毎年前納残高１７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk18(), BizNumber.valueOf(218), "（ＩＷＳ）毎年前納残高１８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk19(), BizNumber.valueOf(219), "（ＩＷＳ）毎年前納残高１９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk20(), BizNumber.valueOf(220), "（ＩＷＳ）毎年前納残高２０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk21(), BizNumber.valueOf(221), "（ＩＷＳ）毎年前納残高２１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk22(), BizNumber.valueOf(222), "（ＩＷＳ）毎年前納残高２２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk23(), BizNumber.valueOf(223), "（ＩＷＳ）毎年前納残高２３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk24(), BizNumber.valueOf(224), "（ＩＷＳ）毎年前納残高２４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk25(), BizNumber.valueOf(225), "（ＩＷＳ）毎年前納残高２５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk26(), BizNumber.valueOf(226), "（ＩＷＳ）毎年前納残高２６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk27(), BizNumber.valueOf(227), "（ＩＷＳ）毎年前納残高２７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk28(), BizNumber.valueOf(228), "（ＩＷＳ）毎年前納残高２８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk29(), BizNumber.valueOf(229), "（ＩＷＳ）毎年前納残高２９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk30(), BizNumber.valueOf(230), "（ＩＷＳ）毎年前納残高３０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk31(), BizNumber.valueOf(231), "（ＩＷＳ）毎年前納残高３１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk32(), BizNumber.valueOf(232), "（ＩＷＳ）毎年前納残高３２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk33(), BizNumber.valueOf(233), "（ＩＷＳ）毎年前納残高３３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk34(), BizNumber.valueOf(234), "（ＩＷＳ）毎年前納残高３４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk35(), BizNumber.valueOf(235), "（ＩＷＳ）毎年前納残高３５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk36(), BizNumber.valueOf(236), "（ＩＷＳ）毎年前納残高３６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk37(), BizNumber.valueOf(237), "（ＩＷＳ）毎年前納残高３７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk38(), BizNumber.valueOf(238), "（ＩＷＳ）毎年前納残高３８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk39(), BizNumber.valueOf(239), "（ＩＷＳ）毎年前納残高３９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk40(), BizNumber.valueOf(240), "（ＩＷＳ）毎年前納残高４０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk41(), BizNumber.valueOf(241), "（ＩＷＳ）毎年前納残高４１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk42(), BizNumber.valueOf(242), "（ＩＷＳ）毎年前納残高４２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk43(), BizNumber.valueOf(243), "（ＩＷＳ）毎年前納残高４３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk44(), BizNumber.valueOf(244), "（ＩＷＳ）毎年前納残高４４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk45(), BizNumber.valueOf(245), "（ＩＷＳ）毎年前納残高４５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk46(), BizNumber.valueOf(246), "（ＩＷＳ）毎年前納残高４６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk47(), BizNumber.valueOf(247), "（ＩＷＳ）毎年前納残高４７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk48(), BizNumber.valueOf(248), "（ＩＷＳ）毎年前納残高４８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk49(), BizNumber.valueOf(249), "（ＩＷＳ）毎年前納残高４９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk50(), BizNumber.valueOf(250), "（ＩＷＳ）毎年前納残高５０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk51(), BizNumber.valueOf(251), "（ＩＷＳ）毎年前納残高５１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk52(), BizNumber.valueOf(252), "（ＩＷＳ）毎年前納残高５２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk53(), BizNumber.valueOf(253), "（ＩＷＳ）毎年前納残高５３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk54(), BizNumber.valueOf(254), "（ＩＷＳ）毎年前納残高５４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk55(), BizNumber.valueOf(255), "（ＩＷＳ）毎年前納残高５５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk56(), BizNumber.valueOf(256), "（ＩＷＳ）毎年前納残高５６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk57(), BizNumber.valueOf(257), "（ＩＷＳ）毎年前納残高５７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk58(), BizNumber.valueOf(258), "（ＩＷＳ）毎年前納残高５８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk59(), BizNumber.valueOf(259), "（ＩＷＳ）毎年前納残高５９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk60(), BizNumber.valueOf(260), "（ＩＷＳ）毎年前納残高６０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk61(), BizNumber.valueOf(261), "（ＩＷＳ）毎年前納残高６１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk62(), BizNumber.valueOf(262), "（ＩＷＳ）毎年前納残高６２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk63(), BizNumber.valueOf(263), "（ＩＷＳ）毎年前納残高６３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk64(), BizNumber.valueOf(264), "（ＩＷＳ）毎年前納残高６４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk65(), BizNumber.valueOf(265), "（ＩＷＳ）毎年前納残高６５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk66(), BizNumber.valueOf(266), "（ＩＷＳ）毎年前納残高６６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk67(), BizNumber.valueOf(267), "（ＩＷＳ）毎年前納残高６７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk68(), BizNumber.valueOf(268), "（ＩＷＳ）毎年前納残高６８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk69(), BizNumber.valueOf(269), "（ＩＷＳ）毎年前納残高６９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk70(), BizNumber.valueOf(270), "（ＩＷＳ）毎年前納残高７０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk71(), BizNumber.valueOf(271), "（ＩＷＳ）毎年前納残高７１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk72(), BizNumber.valueOf(272), "（ＩＷＳ）毎年前納残高７２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk73(), BizNumber.valueOf(273), "（ＩＷＳ）毎年前納残高７３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk74(), BizNumber.valueOf(274), "（ＩＷＳ）毎年前納残高７４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk75(), BizNumber.valueOf(275), "（ＩＷＳ）毎年前納残高７５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk76(), BizNumber.valueOf(276), "（ＩＷＳ）毎年前納残高７６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk77(), BizNumber.valueOf(277), "（ＩＷＳ）毎年前納残高７７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk78(), BizNumber.valueOf(278), "（ＩＷＳ）毎年前納残高７８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk79(), BizNumber.valueOf(279), "（ＩＷＳ）毎年前納残高７９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk80(), BizNumber.valueOf(280), "（ＩＷＳ）毎年前納残高８０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk81(), BizNumber.valueOf(281), "（ＩＷＳ）毎年前納残高８１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk82(), BizNumber.valueOf(282), "（ＩＷＳ）毎年前納残高８２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk83(), BizNumber.valueOf(283), "（ＩＷＳ）毎年前納残高８３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk84(), BizNumber.valueOf(284), "（ＩＷＳ）毎年前納残高８４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk85(), BizNumber.valueOf(285), "（ＩＷＳ）毎年前納残高８５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk86(), BizNumber.valueOf(286), "（ＩＷＳ）毎年前納残高８６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk87(), BizNumber.valueOf(287), "（ＩＷＳ）毎年前納残高８７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk88(), BizNumber.valueOf(288), "（ＩＷＳ）毎年前納残高８８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk89(), BizNumber.valueOf(289), "（ＩＷＳ）毎年前納残高８９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk90(), BizNumber.valueOf(290), "（ＩＷＳ）毎年前納残高９０");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk91(), BizNumber.valueOf(291), "（ＩＷＳ）毎年前納残高９１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk92(), BizNumber.valueOf(292), "（ＩＷＳ）毎年前納残高９２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk93(), BizNumber.valueOf(293), "（ＩＷＳ）毎年前納残高９３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk94(), BizNumber.valueOf(294), "（ＩＷＳ）毎年前納残高９４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk95(), BizNumber.valueOf(295), "（ＩＷＳ）毎年前納残高９５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk96(), BizNumber.valueOf(296), "（ＩＷＳ）毎年前納残高９６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk97(), BizNumber.valueOf(297), "（ＩＷＳ）毎年前納残高９７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk98(), BizNumber.valueOf(298), "（ＩＷＳ）毎年前納残高９８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsMaitosiznnzndk99(), BizNumber.valueOf(299), "（ＩＷＳ）毎年前納残高９９");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsHrkkknmnryutykgw(), BizNumber.valueOf(0), "（ＩＷＳ）払込期間満了直後Ｗ");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukoujyoritu10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除率１０");

        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk1(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk2(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額２");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk3(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額３");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk4(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額４");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk5(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額５");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk6(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額６");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk7(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額７");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk8(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額８");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk9(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額９");
        exBizCalcbleEquals(wsHbSeihoWebHeijyunKaiyakuhrSuiiOutputBean.getIwsKaiyakukjgk10(), BizNumber.valueOf(0), "（ＩＷＳ）解約控除額１０");
    }
}
