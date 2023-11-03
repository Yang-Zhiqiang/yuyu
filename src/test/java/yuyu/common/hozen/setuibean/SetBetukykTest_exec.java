package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.PALBetuSakuinSyoukaiMock;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 別契約情報設定クラスのメソッド {@link SetBetukyk#exec(KhozenCommonParam,SetBetukykExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetBetukykTest_exec {

    @Inject
    SetBetukyk setBetukyk;

    @Inject
    private SetBetukykExecUiBeanParamImpl setBetukykExecUiBeanParamImpl;

    @Inject
    private AS_Kinou Kinou;

    @Inject
    KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_別契約情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    public static void testInit() {
        PALBetuSakuinSyoukaiMock.caller = SetBetukykTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        PALBetuSakuinSyoukaiMock.caller = null;
        PALBetuSakuinSyoukaiMock.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetBetukykTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000013");

        MockObjectManager.initialize();
        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().size(), 1, "ワーニングメッセージIDリストの件数");
        exStringEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().get(0), "WIA1006", "ワーニングメッセージIDリストの1件目");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().size(), 1, "ワーニングメッセージリストの件数");
        exStringEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().get(0),
            "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト1件目");

        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 0, "17806000013");
        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 1, C_SakuintsnTaisyouKbn.HHKN);
        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 2,
            C_SakuintaisyoukykKbn.TAISYOU_HHKN);

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);

        setBetukykExecUiBeanParamImpl.setSyono("17806000024");

        MockObjectManager.initialize();
        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().size(), 1, "ワーニングメッセージIDリストの件数");
        exStringEquals(setBetukykExecUiBeanParamImpl.getWarningMessageIdList().get(0), "WIA1006", "ワーニングメッセージIDリストの1件目");
        exNumericEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().size(), 1, "ワーニングメッセージリストの件数");
        exStringEquals(setBetukykExecUiBeanParamImpl.getWarningMessageList().get(0),
            "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト1件目");

        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 0, "17806000024");
        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 1, C_SakuintsnTaisyouKbn.KYK);
        MockObjectManager.assertArgumentPassed(PALBetuSakuinSyoukaiMock.class, "exec", 2,
            C_SakuintaisyoukykKbn.TAISYOU_KYK);

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000046");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getKikeiyakuInfoDataSourceBeanList().size(), 0,
            "別契約（既契約） のデータソースのデータの件数");
        exBooleanEquals(result, true, "処理結果");

    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000035");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN2;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getKikeiyakuInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getKikeiyakuInfoDataSourceBeanList().size(), 1,
            "別契約（既契約） のデータソースのデータの件数");
        exStringEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyono(), "17806000035", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykyuuksumtkbn(), C_YuukousyoumetuKbn.YUUKOU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HARAIMAN,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyouhnnm(), "商品名", "（別契約情報）（表示用）別契約商品名");
        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000057");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN3;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getKikeiyakuInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getKikeiyakuInfoDataSourceBeanList().size(), 1,
            "別契約（既契約） のデータソースのデータの件数");
        exStringEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyono(), "17806000057", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykyuuksumtkbn(), C_YuukousyoumetuKbn.YUUKOU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HARAIMAN,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean.getVbtkkdispbtkyksyouhnnm(), "", "（別契約情報）（表示用）別契約商品名");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000068");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN4;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getKikeiyakuInfoDataSourceBeanList();

        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean1 = kikeiyakuInfoDataSourceBeanLst.get(0);
        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean2 = kikeiyakuInfoDataSourceBeanLst.get(1);
        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean3 = kikeiyakuInfoDataSourceBeanLst.get(2);

        exNumericEquals(kikeiyakuInfoDataSourceBeanLst.size(), 3, "別契約（既契約） のデータソースのデータの件数");
        exStringEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyono(), "17806000068", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykyuuksumtkbn(), C_YuukousyoumetuKbn.YUUKOU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HARAIMAN,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksumetujiyuu(),
            C_Syoumetujiyuu.KYKTORIKESI, "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyouhnnm(), "商品名", "（別契約情報）（表示用）別契約商品名");

        exStringEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyono(), "17806000068", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykyuuksumtkbn(),
            C_YuukousyoumetuKbn.SYOUMETU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HRKMTYUU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.MUKOU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyouhnnm(), "商品名１", "（別契約情報）（表示用）別契約商品名");

        exStringEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyono(), "17806000068", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkykyuuksumtkbn(),
            C_YuukousyoumetuKbn.SYOUMETU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HRKMTYUU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20160101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.MUKOU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20160102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyouhnnm(), "商品名１", "（別契約情報）（表示用）別契約商品名");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000079");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN5;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<KikeiyakuInfoDataSourceBeanCommonParam> kikeiyakuInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getKikeiyakuInfoDataSourceBeanList();
        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean1 = kikeiyakuInfoDataSourceBeanLst.get(0);
        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean2 = kikeiyakuInfoDataSourceBeanLst.get(1);
        KikeiyakuInfoDataSourceBeanCommonParam kikeiyakuInfoDataSourceBean3 = kikeiyakuInfoDataSourceBeanLst.get(2);

        exNumericEquals(kikeiyakuInfoDataSourceBeanLst.size(), 3, "別契約（既契約） のデータソースのデータの件数");
        exStringEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyono(), "17806000079", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykyuuksumtkbn(), C_YuukousyoumetuKbn.YUUKOU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HARAIMAN,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksumetujiyuu(),
            C_Syoumetujiyuu.KYKTORIKESI, "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean1.getVbtkkdispbtkyksyouhnnm(), "", "（別契約情報）（表示用）別契約商品名");

        exStringEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyono(), "17806000079", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykyuuksumtkbn(),
            C_YuukousyoumetuKbn.SYOUMETU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HRKMTYUU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.MUKOU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkyksyouhnnm(), "", "（別契約情報）（表示用）別契約商品名");

        exStringEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyono(), "17806000079", "（別契約情報）（表示用）別契約証券番号");
        exClassificationEquals(kikeiyakuInfoDataSourceBean2.getVbtkkdispbtkykyuuksumtkbn(),
            C_YuukousyoumetuKbn.SYOUMETU,
            "（別契約情報）（表示用）別契約有効消滅区分");
        exClassificationEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkykkykjyoutai(), C_Kykjyoutai.HRKMTYUU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkykkykymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）別契約契約日");
        exClassificationEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksumetujiyuu(), C_Syoumetujiyuu.MUKOU,
            "（別契約情報）（表示用）別契約契約状態");
        exDateEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyoumetuymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）別契約消滅日");
        exStringEquals(kikeiyakuInfoDataSourceBean3.getVbtkkdispbtkyksyouhnnm(), "", "（別契約情報）（表示用）別契約商品名");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000080");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getNenkinsiharaiInfoDataSourceBeanList().size(), 0,
            "別契約（年金支払契約） のデータソースのデータの件数");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000091");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN6;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        NenkinsiharaiInfoDataSourceBeanCommonParam nenkinsiharaiInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getNenkinsiharaiInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getNenkinsiharaiInfoDataSourceBeanList().size(), 1,
            "別契約（年金支払契約） のデータソースのデータの件数");
        exStringEquals(nenkinsiharaiInfoDataSourceBean.getVbtkkdispbtkyknksysyno(), "17806000091",
            "（別契約情報）（表示用）別契約年金証書番号");
        exDateEquals(nenkinsiharaiInfoDataSourceBean.getVbtkkdispbtkyknkshrsymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約年金支払開始日");
        exClassificationEquals(nenkinsiharaiInfoDataSourceBean.getVbtkkdispbtkyknksymtjiyuu(),
            C_NkSyoumetuCd.LASTNKSHR, "（別契約情報）（表示用）別契約年金消滅事由");
        exDateEquals(nenkinsiharaiInfoDataSourceBean.getVbtkkdispbtkyknksymtymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約年金消滅日");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000105");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN7;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<NenkinsiharaiInfoDataSourceBeanCommonParam> nenkinsiharaiInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getNenkinsiharaiInfoDataSourceBeanList();

        NenkinsiharaiInfoDataSourceBeanCommonParam nenkinsiharaiInfoDataSourceBean1 = nenkinsiharaiInfoDataSourceBeanLst
            .get(0);
        NenkinsiharaiInfoDataSourceBeanCommonParam nenkinsiharaiInfoDataSourceBean2 = nenkinsiharaiInfoDataSourceBeanLst
            .get(1);
        NenkinsiharaiInfoDataSourceBeanCommonParam nenkinsiharaiInfoDataSourceBean3 = nenkinsiharaiInfoDataSourceBeanLst
            .get(2);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getNenkinsiharaiInfoDataSourceBeanList().size(), 3,
            "別契約（年金支払契約） のデータソースのデータの件数");
        exStringEquals(nenkinsiharaiInfoDataSourceBean1.getVbtkkdispbtkyknksysyno(), "17806000105",
            "（別契約情報）（表示用）別契約年金証書番号");
        exDateEquals(nenkinsiharaiInfoDataSourceBean1.getVbtkkdispbtkyknkshrsymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）別契約年金支払開始日");
        exClassificationEquals(nenkinsiharaiInfoDataSourceBean1.getVbtkkdispbtkyknksymtjiyuu(),
            C_NkSyoumetuCd.NKSEISAN, "（別契約情報）（表示用）別契約年金消滅事由");
        exDateEquals(nenkinsiharaiInfoDataSourceBean1.getVbtkkdispbtkyknksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）別契約年金消滅日");

        exStringEquals(nenkinsiharaiInfoDataSourceBean2.getVbtkkdispbtkyknksysyno(), "17806000105",
            "（別契約情報）（表示用）別契約年金証書番号");
        exDateEquals(nenkinsiharaiInfoDataSourceBean2.getVbtkkdispbtkyknkshrsymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）別契約年金支払開始日");
        exClassificationEquals(nenkinsiharaiInfoDataSourceBean2.getVbtkkdispbtkyknksymtjiyuu(),
            C_NkSyoumetuCd.LASTNKSHR, "（別契約情報）（表示用）別契約年金消滅事由");
        exDateEquals(nenkinsiharaiInfoDataSourceBean2.getVbtkkdispbtkyknksymtymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）別契約年金消滅日");

        exStringEquals(nenkinsiharaiInfoDataSourceBean3.getVbtkkdispbtkyknksysyno(), "17806000105",
            "（別契約情報）（表示用）別契約年金証書番号");
        exDateEquals(nenkinsiharaiInfoDataSourceBean3.getVbtkkdispbtkyknkshrsymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）別契約年金支払開始日");
        exClassificationEquals(nenkinsiharaiInfoDataSourceBean3.getVbtkkdispbtkyknksymtjiyuu(),
            C_NkSyoumetuCd.LASTNKSHR, "（別契約情報）（表示用）別契約年金消滅事由");
        exDateEquals(nenkinsiharaiInfoDataSourceBean3.getVbtkkdispbtkyknksymtymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）別契約年金消滅日");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000116");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalkikeiyakuInfoDataSourceBeanList().size(), 0,
            "別契約（ＰＡＬ既契約） のデータソースのデータの件数");
        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000127");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN8;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        PalkikeiyakuInfoDataSourceBeanCommonParam palkikeiyakuInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getPalkikeiyakuInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalkikeiyakuInfoDataSourceBeanList().size(), 1,
            "別契約（ＰＡＬ既契約） のデータソースのデータの件数");
        exStringEquals(palkikeiyakuInfoDataSourceBean.getVbtkkdisppalbtkyksyono(), "17806000127",
            "（別契約情報）（表示用）ＰＡＬ別契約証券番号");
        exDateEquals(palkikeiyakuInfoDataSourceBean.getVbtkkdisppalbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約契約日");
        exStringEquals(palkikeiyakuInfoDataSourceBean.getVbtkkdisppalbtkyksymtcd(), "1234", "（別契約情報）（表示用）ＰＡＬ別契約消滅コード");
        exDateEquals(palkikeiyakuInfoDataSourceBean.getVbtkkdisppalbtkyksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約消滅日");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000138");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN9;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<PalkikeiyakuInfoDataSourceBeanCommonParam> palkikeiyakuInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getPalkikeiyakuInfoDataSourceBeanList();

        PalkikeiyakuInfoDataSourceBeanCommonParam palkikeiyakuInfoDataSourceBeanist1 = palkikeiyakuInfoDataSourceBeanLst
            .get(0);
        PalkikeiyakuInfoDataSourceBeanCommonParam palkikeiyakuInfoDataSourceBeanist2 = palkikeiyakuInfoDataSourceBeanLst
            .get(1);
        PalkikeiyakuInfoDataSourceBeanCommonParam palkikeiyakuInfoDataSourceBeanist3 = palkikeiyakuInfoDataSourceBeanLst
            .get(2);

        exNumericEquals(palkikeiyakuInfoDataSourceBeanLst.size(), 3, "別契約（ＰＡＬ既契約） のデータソースのデータの件数");
        exStringEquals(palkikeiyakuInfoDataSourceBeanist1.getVbtkkdisppalbtkyksyono(), "17806000138",
            "（別契約情報）（表示用）ＰＡＬ別契約証券番号");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist1.getVbtkkdisppalbtkykkykymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約契約日");
        exStringEquals(palkikeiyakuInfoDataSourceBeanist1.getVbtkkdisppalbtkyksymtcd(), "1111",
            "（別契約情報）（表示用）ＰＡＬ別契約消滅コード");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist1.getVbtkkdisppalbtkyksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約消滅日");

        exStringEquals(palkikeiyakuInfoDataSourceBeanist2.getVbtkkdisppalbtkyksyono(), "17806000138",
            "（別契約情報）（表示用）ＰＡＬ別契約証券番号");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist2.getVbtkkdisppalbtkykkykymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）ＰＡＬ別契約契約日");
        exStringEquals(palkikeiyakuInfoDataSourceBeanist2.getVbtkkdisppalbtkyksymtcd(), "2222",
            "（別契約情報）（表示用）ＰＡＬ別契約消滅コード");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist2.getVbtkkdisppalbtkyksymtymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）ＰＡＬ別契約消滅日");

        exStringEquals(palkikeiyakuInfoDataSourceBeanist3.getVbtkkdisppalbtkyksyono(), "17806000138",
            "（別契約情報）（表示用）ＰＡＬ別契約証券番号");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist3.getVbtkkdisppalbtkykkykymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）ＰＡＬ別契約契約日");
        exStringEquals(palkikeiyakuInfoDataSourceBeanist3.getVbtkkdisppalbtkyksymtcd(), "3333",
            "（別契約情報）（表示用）ＰＡＬ別契約消滅コード");
        exDateEquals(palkikeiyakuInfoDataSourceBeanist3.getVbtkkdisppalbtkyksymtymd(), BizDate.valueOf("20150102"),
            "（別契約情報）（表示用）ＰＡＬ別契約消滅日");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("12806345719");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000150");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN10;


        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        PalNenkinsiharaiInfoDataSourceBeanCommonParam palNenkinsiharaiInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getPalNenkinsiharaiInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalNenkinsiharaiInfoDataSourceBeanList().size(), 1,
            "別契約（ＰＡＬ年金支払契約） のデータソースのデータの件数");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean.getVbtkkdisppalbtkyknksysyno(), "17806000150",
            "（別契約情報）（表示用）ＰＡＬ別契約年金証書番号");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean.getVbtkkdisppalbtkyknkshrymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約初回年金支払年月日");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean.getVbtkkdisppalbtkyknksymtcd(), "1234",
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅コード");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean.getVbtkkdisppalbtkyknksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅日");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000161");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN11;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> palNenkinsiharaiInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getPalNenkinsiharaiInfoDataSourceBeanList();

        PalNenkinsiharaiInfoDataSourceBeanCommonParam palNenkinsiharaiInfoDataSourceBean1 = palNenkinsiharaiInfoDataSourceBeanLst
            .get(0);
        PalNenkinsiharaiInfoDataSourceBeanCommonParam palNenkinsiharaiInfoDataSourceBean2 = palNenkinsiharaiInfoDataSourceBeanLst
            .get(1);
        PalNenkinsiharaiInfoDataSourceBeanCommonParam palNenkinsiharaiInfoDataSourceBean3 = palNenkinsiharaiInfoDataSourceBeanLst
            .get(2);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalNenkinsiharaiInfoDataSourceBeanList().size(), 3,
            "別契約（ＰＡＬ年金支払契約） のデータソースのデータの件数");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean1.getVbtkkdisppalbtkyknksysyno(), "17806000161",
            "（別契約情報）（表示用）ＰＡＬ別契約年金証書番号");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean1.getVbtkkdisppalbtkyknkshrymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）ＰＡＬ別契約初回年金支払年月日");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean1.getVbtkkdisppalbtkyknksymtcd(), "4567",
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅コード");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean1.getVbtkkdisppalbtkyknksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅日");

        exStringEquals(palNenkinsiharaiInfoDataSourceBean2.getVbtkkdisppalbtkyknksysyno(), "17806000161",
            "（別契約情報）（表示用）ＰＡＬ別契約年金証書番号");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean2.getVbtkkdisppalbtkyknkshrymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約初回年金支払年月日");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean2.getVbtkkdisppalbtkyknksymtcd(), "1234",
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅コード");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean2.getVbtkkdisppalbtkyknksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅日");

        exStringEquals(palNenkinsiharaiInfoDataSourceBean3.getVbtkkdisppalbtkyknksysyno(), "17806000161",
            "（別契約情報）（表示用）ＰＡＬ別契約年金証書番号");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean3.getVbtkkdisppalbtkyknkshrymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約初回年金支払年月日");
        exStringEquals(palNenkinsiharaiInfoDataSourceBean3.getVbtkkdisppalbtkyknksymtcd(), "1234",
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅コード");
        exDateEquals(palNenkinsiharaiInfoDataSourceBean3.getVbtkkdisppalbtkyknksymtymd(), BizDate.valueOf("20140102"),
            "（別契約情報）（表示用）ＰＡＬ別契約年金消滅日");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000172");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN1;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalsueokiInfoDataSourceBeanList().size(), 0,
            "別契約（ＰＡＬ保険金据置契約） のデータソースのデータの件数");
        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000183");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN12;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        PalsueokiInfoDataSourceBeanCommonParam palsueokiInfoDataSourceBean = setBetukykExecUiBeanParamImpl
            .getPalsueokiInfoDataSourceBeanList().get(0);

        exNumericEquals(setBetukykExecUiBeanParamImpl.getPalsueokiInfoDataSourceBeanList().size(), 1,
            "別契約（ＰＡＬ保険金据置契約） のデータソースのデータの件数");
        exStringEquals(palsueokiInfoDataSourceBean.getVbtkkdisppalbtkyksosysyno(), "17806000183",
            "（別契約情報）（表示用）ＰＡＬ別契約据置証書番号");
        exDateEquals(palsueokiInfoDataSourceBean.getVbtkkdisppalbtkyksosymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約据置開始年月日");

        exBooleanEquals(result, true, "処理結果");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {
        Kinou.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);

        setBetukykExecUiBeanParamImpl.setSyono("17806000194");

        PALBetuSakuinSyoukaiMock.SYORIPTN = PALBetuSakuinSyoukaiMock.TESTPATTERN13;

        boolean result = setBetukyk.exec(khozenCommonParam, setBetukykExecUiBeanParamImpl);

        List<PalsueokiInfoDataSourceBeanCommonParam> palsueokiInfoDataSourceBeanLst = setBetukykExecUiBeanParamImpl
            .getPalsueokiInfoDataSourceBeanList();

        PalsueokiInfoDataSourceBeanCommonParam palsueokiInfoDataSourceBean1 = palsueokiInfoDataSourceBeanLst.get(0);
        PalsueokiInfoDataSourceBeanCommonParam palsueokiInfoDataSourceBean2 = palsueokiInfoDataSourceBeanLst.get(1);
        PalsueokiInfoDataSourceBeanCommonParam palsueokiInfoDataSourceBean3 = palsueokiInfoDataSourceBeanLst.get(2);

        exNumericEquals(palsueokiInfoDataSourceBeanLst.size(), 3, "別契約（ＰＡＬ保険金据置契約） のデータソースのデータの件数");
        exStringEquals(palsueokiInfoDataSourceBean1.getVbtkkdisppalbtkyksosysyno(), "17806000194",
            "（別契約情報）（表示用）ＰＡＬ別契約据置証書番号");
        exDateEquals(palsueokiInfoDataSourceBean1.getVbtkkdisppalbtkyksosymd(), BizDate.valueOf("20140101"),
            "（別契約情報）（表示用）ＰＡＬ別契約据置開始年月日");

        exStringEquals(palsueokiInfoDataSourceBean2.getVbtkkdisppalbtkyksosysyno(), "17806000194",
            "（別契約情報）（表示用）ＰＡＬ別契約据置証書番号");
        exDateEquals(palsueokiInfoDataSourceBean2.getVbtkkdisppalbtkyksosymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）ＰＡＬ別契約据置開始年月日");

        exStringEquals(palsueokiInfoDataSourceBean3.getVbtkkdisppalbtkyksosysyno(), "17806000194",
            "（別契約情報）（表示用）ＰＡＬ別契約据置証書番号");
        exDateEquals(palsueokiInfoDataSourceBean3.getVbtkkdisppalbtkyksosymd(), BizDate.valueOf("20150101"),
            "（別契約情報）（表示用）ＰＡＬ別契約据置開始年月日");

        exBooleanEquals(result, true, "処理結果");

    }
}
