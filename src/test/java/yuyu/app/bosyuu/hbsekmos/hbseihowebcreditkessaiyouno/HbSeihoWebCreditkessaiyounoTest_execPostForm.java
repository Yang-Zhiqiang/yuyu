package yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.file.util.FixedlengthConvertUtil;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyounoImpl;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengen;
import yuyu.common.bosyuu.hbcommon.HbSeihoWebHanteiKengenMockForSinkeiyaku;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNo;
import yuyu.common.hozen.khcommon.SaibanCreditKessaiyouNoForSinkeiyaku;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.bosyuu.bean.webservice.WsHbSeihoWebCreditkessaiyounoOutputBean;
import yuyu.def.classification.C_CreditCardKeySyuruiKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 生保Ｗｅｂクレジットカード決済用番号取得のメイン処理{@link HbSeihoWebCreditkessaiyounoImpl#execPostForm(MultivaluedMap<String, String> pMap)}
 * テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
@SuppressWarnings({ "unchecked" })
public class HbSeihoWebCreditkessaiyounoTest_execPostForm extends AbstractTest {

    @Inject
    private HbSeihoWebCreditkessaiyounoImpl hbSeihoWebCreditkessaiyounoImpl;

    @Before
    public void before() {

        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(HbSeihoWebHanteiKengen.class).to(HbSeihoWebHanteiKengenMockForSinkeiyaku.class);
                bind(SaibanCreditKessaiyouNo.class).to(SaibanCreditKessaiyouNoForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        HbSeihoWebHanteiKengenMockForSinkeiyaku.caller = HbSeihoWebCreditkessaiyounoTest_execPostForm.class;
        SaibanCreditKessaiyouNoForSinkeiyaku.caller = HbSeihoWebCreditkessaiyounoTest_execPostForm.class;

    }

    @Test
    @TestOrder(10)
    public void testExecPostForm_A1() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "0", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "11223344556600000000000000", "（ＩＷＳ）クレジットカード決済用番号");

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = (WsBzWebserviceReqParamBean)MockObjectManager.getArgument(
            HbSeihoWebHanteiKengenMockForSinkeiyaku.class, "execChkTanmatuKengen", 0, 0);
        exStringEquals(wsBzWebserviceReqParamBean.getOperatorId(), "user0001", "（ＩＷＳ）オペレータＩＤ");
        exStringEquals(wsBzWebserviceReqParamBean.getOrgCode(), "testCode", "（ＩＷＳ）事務単位コード（論理）");
        exStringEquals(wsBzWebserviceReqParamBean.getGyoumuData(), "860000017", "（ＩＷＳ）業務データ");

        exClassificationEquals((C_CreditCardKeySyuruiKbn)MockObjectManager.getArgument(
            SaibanCreditKessaiyouNoForSinkeiyaku.class, "exec", 0, 0), C_CreditCardKeySyuruiKbn.MOSNO, "クレジットカードキー種類区分");
        exStringEquals((String)MockObjectManager.getArgument(
            SaibanCreditKessaiyouNoForSinkeiyaku.class, "exec", 0, 1), "860000017", "クレジットカードＤＢキー");
    }

    @Test
    @TestOrder(20)
    public void testExecPostForm_A2() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", "86000abc");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "00000000000000000000000000", " （ＩＷＳ）クレジットカード決済用番号 ");
    }

    @Test
    @TestOrder(30)
    public void testExecPostForm_A3() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", "860000018");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "00000000000000000000000000", " （ＩＷＳ）クレジットカード決済用番号 ");
    }

    @Test
    @TestOrder(40)
    public void testExecPostForm_A4() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN2;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "00000000000000000000000000", " （ＩＷＳ）クレジットカード決済用番号 ");
    }

    @Test
    @TestOrder(50)
    public void testExecPostForm_A5() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN3;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN1;

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "00000000000000000000000000", " （ＩＷＳ）クレジットカード決済用番号 ");
    }

    @Test
    @TestOrder(60)
    public void testExecPostForm_A6() throws Exception {
        MultivaluedMap<String, String> pMap = (MultivaluedMap<String, String>) Class.forName(
            "org.jboss.resteasy.specimpl.MultivaluedMapImpl").newInstance();

        HbSeihoWebHanteiKengenMockForSinkeiyaku.SYORIPTN = HbSeihoWebHanteiKengenMockForSinkeiyaku.TESTPATTERN1;
        SaibanCreditKessaiyouNoForSinkeiyaku.SYORIPTN = SaibanCreditKessaiyouNoForSinkeiyaku.TESTPATTERN2;

        pMap.add("gyoumuData", "860000017");
        pMap.add("operatorId", "user0001");
        pMap.add("orgCode", "testCode");
        pMap.add("methodName", "yuyu.app.bosyuu.hbsekmos.hbseihowebcreditkessaiyouno.HbSeihoWebCreditkessaiyouno");
        pMap.add("coopClass", "01");

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = hbSeihoWebCreditkessaiyounoImpl.execPostForm(pMap);

        WsHbSeihoWebCreditkessaiyounoOutputBean wsHbSeihoWebCreditkessaiyounoOutputBean = FixedlengthConvertUtil.stringToBeanForFixedlength(
            wsBzWebserviceResParamBean.getGyoumuData(), WsHbSeihoWebCreditkessaiyounoOutputBean.class);

        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsErrkbn(), "1", "（ＩＷＳ）エラー区分");
        exStringEquals(wsHbSeihoWebCreditkessaiyounoOutputBean.getIwsCreditkessaiyouno(),
            "00000000000000000000000000", " （ＩＷＳ）クレジットカード決済用番号 ");
    }
}
