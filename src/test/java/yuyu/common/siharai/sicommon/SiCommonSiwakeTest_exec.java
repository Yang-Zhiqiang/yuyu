package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.kaikei.BzDenpyouDataSks;
import yuyu.common.biz.kaikei.BzDenpyouDataTourokuBean;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金仕訳共通処理のメソッド{@link SiCommonSiwake#exec(SiCommonSiwakeBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiCommonSiwakeTest_exec {
    @Inject
    private SiCommonSiwake siCommonSiwake;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険金給付金仕訳共通処理";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    public static void insertTestData1() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(SiCommonSiwakeTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertTestData2() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(SiCommonSiwakeTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertTestData3() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(SiCommonSiwakeTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ003", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(expected = BizAppException.class)
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData3();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(1000));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        try {
            siCommonSiwake.exec(siCommonSiwakeBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "テーブル取得エラー　BM_TantouCd　key:tantouCdKbn=R", "エラーメッセージ");
            bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
            throw e;
        }
    }


    @Test(expected = BizAppException.class)
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {
        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.BLNK);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ2");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(1000));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        try {
            siCommonSiwake.exec(siCommonSiwakeBean);
        } catch (BizAppException e) {
            exStringEquals(e.getMessage(), "inputShrhousiteiKbnが不正です。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_B1() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(100));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(0));
        siCommonSiwake.exec(siCommonSiwakeBean);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exStringEquals(bzDenpyouDataTourokuBean.getIbSyono(), "11807111118", "証券番号");
        exStringEquals(bzDenpyouDataTourokuBean.getIbHuridenatesakicd(), "353", "振替伝票宛先部課コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(bzDenpyouDataTourokuBean.getIbDenymd(), BizDate.valueOf("20160303"), "伝票日付");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.ONLINEFB, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenhnknhoukbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.FBSOUKINYOKU, "伝票用支払方法区分");
        exDateEquals(bzDenpyouDataTourokuBean.getIbSyoriymd(), BizDate.valueOf("20160302"), "処理年月日");
        exStringEquals(bzDenpyouDataTourokuBean.getIbSyoricd(), "0001", "処理コード");
        exStringEquals(bzDenpyouDataTourokuBean.getIbSyorisosikicd(), "438", "処理組織コード ");
        exStringEquals(bzDenpyouDataTourokuBean.getIbGyoumuKousinsyaId(), "JUNIT", "業務用更新者ＩＤ");
        exBooleanEquals(bzDenpyouDataTourokuBean.getIbKakokawaserateshiteiflg(), true, "過去為替レート指定フラグ");
        exDateEquals(bzDenpyouDataTourokuBean.getIbKakokawaserateshiteiymd(), BizDate.valueOf("20160301"),
            "過去為替レート指定年月日");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_B2() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();
        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(0));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(0));
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.ONLINEFB, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.FBSOUKINYOKU, "伝票用支払方法区分");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_B3() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();
        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111222");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(30100));
        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(10000));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBeanSecond = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBeanSecond.setKanjyouKmkCd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siharaigakuBeanSecond.setSiharaiGk(BizCurrency.valueOf(20000));
        siharaigakuBeanList.add(siharaigakuBeanSecond);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.ONLINEFB, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.FBSOUKINYOKU, "伝票用支払方法区分");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 5, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(20000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(), BizCurrency.valueOf(2000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(), BizCurrency.valueOf(32100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_B4() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBeanSecond = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBeanSecond.setKanjyouKmkCd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siharaigakuBeanSecond.setSiharaiGk(BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBeanSecond);
        SiharaigakuBean siharaigakuBeanThird = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBeanThird.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBeanThird.setSiharaiGk(BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBeanThird);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.SIBOUTETUZUKI, "担当コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.KARIUKERSKARI, "伝票用支払方法区分");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 5, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY ,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(40000, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(), null, "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_B5() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();
        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBeanSecond = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBeanSecond.setKanjyouKmkCd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        siharaigakuBeanSecond.setSiharaiGk(BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBeanSecond);
        SiharaigakuBean siharaigakuBeanThird = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBeanThird.setKanjyouKmkCd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        siharaigakuBeanThird.setSiharaiGk(BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBeanThird);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siCommonSiwake.exec(siCommonSiwakeBean);

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.SIBOUTETUZUKI, "担当コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.KARIUKERSKNASI, "伝票用支払方法区分");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 6, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(20000, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(30000, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(), null, "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_B6() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();
        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(10100));

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(10000));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(2000));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbTantocd(), C_TantouCdKbn.SIBOUTETUZUKI, "担当コード");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbHuridenskskbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(bzDenpyouDataTourokuBean.getIbDenshrhoukbn(), C_DenshrhouKbn.KARIUKERSKARI, "伝票用支払方法区分");
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 4, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(10000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(2000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(), BizCurrency.valueOf(12100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_B7() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(100));

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        siCommonSiwake.exec(siCommonSiwakeBean);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_B8() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(100));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(), BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_B9() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(0));

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 1, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_B10() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(100));
        siCommonSiwake.exec(siCommonSiwakeBean);
        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_B11() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(100));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(), null, "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_B12() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20160303"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("ｱ1");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);
        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 1, "仕訳明細リストのサイズ");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_C1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method getTuukabetuKanjyoukmkcd =  SiCommonSiwake.class.getDeclaredMethod("getTuukabetuKanjyoukmkcd",
            C_Kanjyoukmkcd.class, C_Tuukasyu.class, C_Tuukasyu.class);

        getTuukabetuKanjyoukmkcd.setAccessible(true);

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            C_Tuukasyu.USD, C_Tuukasyu.USD), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_C2() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method getTuukabetuKanjyoukmkcd =  SiCommonSiwake.class.getDeclaredMethod("getTuukabetuKanjyoukmkcd",
            C_Kanjyoukmkcd.class, C_Tuukasyu.class, C_Tuukasyu.class);

        getTuukabetuKanjyoukmkcd.setAccessible(true);

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SAIGAISIBOUHOKENKIN_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            C_Tuukasyu.AUD, C_Tuukasyu.AUD), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD,
            "勘定科目コード");

    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_C3() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Method getTuukabetuKanjyoukmkcd =  SiCommonSiwake.class.getDeclaredMethod("getTuukabetuKanjyoukmkcd",
            C_Kanjyoukmkcd.class, C_Tuukasyu.class, C_Tuukasyu.class);

        getTuukabetuKanjyoukmkcd.setAccessible(true);

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU,
            "勘定科目コード");

        exClassificationEquals((C_Kanjyoukmkcd)getTuukabetuKanjyoukmkcd.invoke(siCommonSiwake,
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU,
            "勘定科目コード");

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_D1() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600,BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 10, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_D2() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1002");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(450, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(2200, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(2200, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1950, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_D3() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBean.setKeiyakuGk(BizCurrency.valueOf(11, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(1300, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1300, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(11, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_D4() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(BizCurrency.valueOf(150));
        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(450, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        List<SiDetailMisyuupBean> siDetailMisyuupBeanLst = new ArrayList<>();
        SiDetailMisyuupBean siDetailMisyuupBean = SWAKInjector.getInstance(SiDetailMisyuupBean.class);
        siDetailMisyuupBean.setDtlmisyuup(BizCurrency.valueOf(1));
        siDetailMisyuupBean.setDtlmisyuupgaika(BizCurrency.valueOf(2, BizCurrencyTypes.DOLLAR));
        siDetailMisyuupBean.setDtlmisyuupgaikayenkingk(BizCurrency.valueOf(101));
        siDetailMisyuupBean.setDtlmisyuupiktnyuukinnumu(C_UmuKbn.ARI);
        siDetailMisyuupBean.setDtlmisyuuphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMisyuupBean.setDtlmisyuupjyutoukaisuuy(3);
        siDetailMisyuupBean.setDtlmisyuupjyutoukaisuum(4);
        siDetailMisyuupBean.setDtlmisyuupjyuutouym(BizDateYM.valueOf("201901"));
        siDetailMisyuupBeanLst.add(siDetailMisyuupBean);

        SiDetailMisyuupBean siDetailMisyuupBean1 = SWAKInjector.getInstance(SiDetailMisyuupBean.class);
        siDetailMisyuupBean1.setDtlmisyuupgaikayenkingk(BizCurrency.valueOf(102));
        siDetailMisyuupBeanLst.add(siDetailMisyuupBean1);

        SiDetailMisyuupBean siDetailMisyuupBean2 = SWAKInjector.getInstance(SiDetailMisyuupBean.class);
        siDetailMisyuupBean2.setDtlmisyuupgaikayenkingk(BizCurrency.valueOf(103));
        siDetailMisyuupBeanLst.add(siDetailMisyuupBean2);

        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(siDetailMisyuupBeanLst);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(601, BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(132894));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(131100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(2201, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(133044), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(306), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_D5() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(450, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        List<SiDetailMisyuupBean> siDetailMisyuupBeanLst = new ArrayList<>();
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(siDetailMisyuupBeanLst);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(601, BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(11));
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(132211));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(130100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1301, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(11), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(132211), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_D6() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1003");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300));
        siCommonSiwakeBean.setYenkaHaitoukin(null);
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500));
        siCommonSiwakeBean.setYenkaMikeikap(null);
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700));
        siCommonSiwakeBean.setYenkaZennouseisank(null);
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500));
        siCommonSiwakeBean.setYenkaKrkgk(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(BizCurrency.valueOf(21));
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(3100));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 6, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(300), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(500), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(500), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(700), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(700), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(1500), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(3100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(21), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_D7() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaMisyuup(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(null);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(100));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 2, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_HUTUU,
            "勘定科目コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDenyenkagk(),BizCurrency.valueOf(100), "伝票金額（円）");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(100), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_D8() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20171202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20170402"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(null);
        siCommonSiwakeBean.setYenkaHaitoukin(null);
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);
        siCommonSiwakeBean.setMikeikapJyuutouym(null);
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(null);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20160501"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(1));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(0));

        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setKrkgk(null);
        siCommonSiwakeBean.setYenkaKrkgk(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);

        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(201));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160501"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 3, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(1), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(201), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_D9() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180512"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20180510"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(null);
        siCommonSiwakeBean.setYenkaHaitoukin(null);
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);
        siCommonSiwakeBean.setMikeikapJyuutouym(null);
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(1));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(0));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(null);
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(0));

        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setKrkgk(null);
        siCommonSiwakeBean.setYenkaKrkgk(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);

        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(201));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20180405"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201804"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 3, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(1), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(201), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_D10() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1002");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 10, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(800), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(290)
    @Transactional
    public void testExec_D11() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20171202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20170402"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(null);
        siCommonSiwakeBean.setYenkaHaitoukin(null);
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(200));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);
        siCommonSiwakeBean.setMikeikapJyuutouym(null);
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(null);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20160501"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(1));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(0));

        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(100));
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(null);
        siCommonSiwakeBean.setKrkgk(null);
        siCommonSiwakeBean.setYenkaKrkgk(null);
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);

        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(101));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160501"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 4, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(101), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(101), "契約通貨金額");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(101), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(200), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(300)
    @Transactional
    public void testExec_D12() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1004");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.YEN));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setSindansyo(null);
        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(450, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        List<SiDetailMisyuupBean> siDetailMisyuupBeanLst = new ArrayList<>();
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(siDetailMisyuupBeanLst);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(601));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(null);
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(11));
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(3512));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(1401), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1127.01, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(11), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(3512), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(310)
    @Transactional
    public void testExec_D13() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData2();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1004");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(450, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20170101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 7, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUHOKENKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(1127, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1127, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "564", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1950, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.SIBOUTETUZUKI));
    }
    @Test
    @TestOrder(320)
    @Transactional
    public void testExec_D14() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1004");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600,BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.NONE);
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 10, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(800), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(1113, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1113, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1700, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(9).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(9).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(330)
    @Transactional
    public void testExec_D15() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600,BizCurrencyTypes.DOLLAR));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(29300));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 8, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(12000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(14000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(700,BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(900, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(29300), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(340)
    @Transactional
    public void testExec_D16() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1004");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(700, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 8, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(800), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(1165, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(4700), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(350)
    @Transactional
    public void testExec_D17() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 8, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(800), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(900), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(4700), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(360)
    @Transactional
    public void testExec_D18() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.JPY);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1002");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(600));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(900));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 8, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(800), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(1000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(900), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(4700), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(370)
    @Transactional
    public void testExec_D19() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1004");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(600));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 9, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(800), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(4700), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(380)
    @Transactional
    public void testExec_D20() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1001");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(600));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 9, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(600), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(800), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(4700), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }
    @Test
    @TestOrder(390)
    @Transactional
    public void testExec_D21() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1002");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(100, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        SiharaigakuBean siharaigakuBean1 = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean1.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean1.setSiharaiGk(BizCurrency.valueOf(200, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean1);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(300, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(400));
        siCommonSiwakeBean.setMisyuup(null);
        siCommonSiwakeBean.setYenkaMisyuup(null);
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);

        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(600));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(600));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(10));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(20, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(1);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(2);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);

        SiDetailMikeikapBean siDetailMikeikapBean1 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean1.setDtlmikeikap(BizCurrency.valueOf(30));
        siDetailMikeikapBean1.setDtlmikeikapgaika(BizCurrency.valueOf(40, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean1.setDtlmikeikapnykdenymd(BizDate.valueOf("20160312"));
        siDetailMikeikapBean1.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.HALFY);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuuy(3);
        siDetailMikeikapBean1.setDtlmikeikapjyutoukaisuum(4);
        siDetailMikeikapBean1.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201605"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean1);

        SiDetailMikeikapBean siDetailMikeikapBean2 = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean2.setDtlmikeikap(BizCurrency.valueOf(50));
        siDetailMikeikapBean2.setDtlmikeikapgaika(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean2.setDtlmikeikapnykdenymd(BizDate.valueOf("20160313"));
        siDetailMikeikapBean2.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.NEN);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuuy(5);
        siDetailMikeikapBean2.setDtlmikeikapjyutoukaisuum(6);
        siDetailMikeikapBean2.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201606"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean2);

        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(BizDate.valueOf("20180101"));
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(800));
        siCommonSiwakeBean.setAzukarikingk(null);
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(1100, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1200));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1300));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(1400));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(1600));
        siCommonSiwakeBean.setShrtienRsk(null);
        siCommonSiwakeBean.setKeiyakuShrtienRsk(null);
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(4700));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(20));
        siCommonSiwakeBean.setGaikaknsnKwsrate(null);
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160332"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 9, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO,
            "勘定科目コード");
        exBooleanEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDenyenkagk(),BizCurrency.valueOf(400), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDengaikagk(),
            BizCurrency.valueOf(600), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(3).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(600), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDengaikagk(),
            BizCurrency.valueOf(800), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(4).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(800), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbDenyenkagk(),BizCurrency.valueOf(1600), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(5).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(5).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(6).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(6).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSuitoubumoncd(), "521", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDengaikagk(),
            BizCurrency.valueOf(4700), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(7).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(7).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD,
            "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSuitoubumoncd(), "516", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDengaikagk(),
            BizCurrency.valueOf(1500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbDenyenkagk(),BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(8).getIbSeg2cd(), C_Segcd.BLNK, "セグメント2コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(8).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "契約通貨金額");

        bizDomManager.delete(bizDomManager.getTantouCd(C_TantouCdKbn.KAIYAKU));
    }

    @Test
    @TestOrder(400)
    @Transactional
    public void testExec_E1() {
        MockObjectManager.initialize();
        baseUserInfo.getUser().setUserId("JUNIT");
        insertTestData1();

        SiCommonSiwakeBean siCommonSiwakeBean = SWAKInjector.getInstance(SiCommonSiwakeBean.class);
        siCommonSiwakeBean.setSyoNo("11807111118");
        siCommonSiwakeBean.setDenYmd(BizDate.valueOf("20180202"));
        siCommonSiwakeBean.setTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setKeiyakuTuukasyu(C_Tuukasyu.USD);
        siCommonSiwakeBean.setInputShrhousiteiKbn(C_InputShrhousiteiKbn.FBSOUKIN);
        siCommonSiwakeBean.setSyoriYmd(BizDate.valueOf("20160302"));
        siCommonSiwakeBean.setSyoriCd("0001");
        siCommonSiwakeBean.setSyoriSosikiCd("438");
        siCommonSiwakeBean.setKakoKawaserateShiteiFlg(true);
        siCommonSiwakeBean.setKakoKawaserateShiteiYmd(BizDate.valueOf("20160301"));
        siCommonSiwakeBean.setSyouhnCd("1003");
        siCommonSiwakeBean.setSyouhnsdNo(1);
        siCommonSiwakeBean.setNkRendouUmu(C_UmuKbn.NONE);

        List<SiharaigakuBean> siharaigakuBeanList = new ArrayList<>();
        SiharaigakuBean siharaigakuBean = SWAKInjector.getInstance(SiharaigakuBean.class);
        siharaigakuBean.setKanjyouKmkCd(C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_JPY);
        siharaigakuBean.setSiharaiGk(BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR));
        siharaigakuBeanList.add(siharaigakuBean);
        siCommonSiwakeBean.setSiharaigakuBeanList(siharaigakuBeanList);

        siCommonSiwakeBean.setHaitoukin(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaHaitoukin(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setMisyuup(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMisyuup(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setSiDetailMisyuupBeanLst(null);


        siCommonSiwakeBean.setMikeikapJyuutouym(BizDateYM.valueOf("201603"));
        siCommonSiwakeBean.setMikeikap(BizCurrency.valueOf(50, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaMikeikap(BizCurrency.valueOf(5050));
        List<SiDetailMikeikapBean> siDetailMikeikapBeanLst = new ArrayList<>();
        SiDetailMikeikapBean siDetailMikeikapBean = SWAKInjector.getInstance(SiDetailMikeikapBean.class);
        siDetailMikeikapBean.setDtlmikeikap(BizCurrency.valueOf(5050));
        siDetailMikeikapBean.setDtlmikeikapgaika(BizCurrency.valueOf(50, BizCurrencyTypes.DOLLAR));
        siDetailMikeikapBean.setDtlmikeikapnykdenymd(BizDate.valueOf("20160311"));
        siDetailMikeikapBean.setDtlmikeikaphrkkaisuu(C_Hrkkaisuu.TUKI);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuuy(0);
        siDetailMikeikapBean.setDtlmikeikapjyutoukaisuum(1);
        siDetailMikeikapBean.setDtlmikeikapjyuutouym(BizDateYM.valueOf("201604"));
        siDetailMikeikapBeanLst.add(siDetailMikeikapBean);
        siCommonSiwakeBean.setSiDetailMikeikapBeanLst(siDetailMikeikapBeanLst);

        siCommonSiwakeBean.setZennouryosyuymd(null);
        siCommonSiwakeBean.setZennouseisank(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaZennouseisank(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setAzukarikingk(BizCurrency.valueOf(60, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaAzukarikingk(BizCurrency.valueOf(6050));
        siCommonSiwakeBean.setZitkAzukarikingkSiteituuka(BizCurrency.valueOf(50, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(5050));
        siCommonSiwakeBean.setZitkAzukarikingkYen(BizCurrency.valueOf(1000));
        siCommonSiwakeBean.setGaikknsnZitkAzukarikingkYen(BizCurrency.valueOf(10));
        siCommonSiwakeBean.setKrkgk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setYenkaKrkgk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setShrtienRsk(BizCurrency.valueOf(0));
        siCommonSiwakeBean.setKeiyakuShrtienRsk(BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setShrgkkei(BizCurrency.valueOf(610.5, BizCurrencyTypes.DOLLAR));
        siCommonSiwakeBean.setItijibrumu(C_UmuKbn.ARI);
        siCommonSiwakeBean.setKawaserate(BizNumber.valueOf(101));
        siCommonSiwakeBean.setGaikaknsnKwsrate(BizNumber.valueOf(100));
        siCommonSiwakeBean.setKykymd(BizDate.valueOf("20160331"));
        siCommonSiwakeBean.setNexthrkym(BizDateYM.valueOf("201703"));
        siCommonSiwakeBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        siCommonSiwakeBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);

        siCommonSiwake.exec(siCommonSiwakeBean);

        BzDenpyouDataTourokuBean bzDenpyouDataTourokuBean = (BzDenpyouDataTourokuBean) MockObjectManager.getArgument(
            BzDenpyouDataSks.class, "execSi", 0, 0);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanResult = bzDenpyouDataTourokuBean.getBzSiwakeMeisaiBeanList();
        exNumericEquals(bzSiwakeMeisaiBeanResult.size(), 3, "仕訳明細リストのサイズ");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SIBOUKYUUHUKIN_GAIHO_USD,
            "勘定科目コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(0).getIbDengaikagk(),
            BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD,
            "勘定科目コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(1).getIbDengaikagk(),
            BizCurrency.valueOf(110.5, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");

        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanResult.get(2).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN,
            "勘定科目コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanResult.get(2).getIbDengaikagk(),
            BizCurrency.valueOf(610.5, BizCurrencyTypes.DOLLAR), "伝票金額（外貨）");
    }

}
