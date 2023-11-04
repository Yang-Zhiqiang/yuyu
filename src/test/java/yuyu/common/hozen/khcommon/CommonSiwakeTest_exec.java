package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_DseisantetudukimeiKbn;
import yuyu.def.classification.C_HijynbrKanritukaHantKbn;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全 契約保全共通 仕訳共通処理クラスのメソッド {@link CommonSiwake#exec(CommonSiwakeInBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CommonSiwakeTest_exec {

    @Inject
    private CommonSiwake commonSiwake;

    @Inject
    private TaisyouGkBean taisyouGkBean;

    @Inject
    private CommonSiwakeInBean commonSiwakeInBean;

    @Inject
    private AS_Kinou kinou;

    private final static String fileName = "UT-SP_単体テスト仕様書_仕訳共通処理";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(CommonSiwakeTest_exec.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllTantouCd());
        bizDomManager.delete(bizDomManager.getAllSyouhnbetuSegment());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testExec_A1() {

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_JYUUSYOHENKOU);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1001");
        commonSiwakeInBean.setSyouhnsdNo(11);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);


        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10010));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));


        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        try {


            commonSiwake.exec(commonSiwakeInBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。仕訳共通処理エラー　対象外の機能ＩＤです。機能ＩＤ＝khjyuusyohenkou", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(20)
    public void testExec_A2() {

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.BLNK);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1001");
        commonSiwakeInBean.setSyouhnsdNo(11);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10010));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        try {


            commonSiwake.exec(commonSiwakeInBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。仕訳共通処理エラー　対象外の通貨種類です。通貨種類＝", "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(30)
    public void testExec_A3() {

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1001");
        commonSiwakeInBean.setSyouhnsdNo(11);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.BLNK);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10010));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        try {


            commonSiwake.exec(commonSiwakeInBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。商品別セグメントマスタからセグメントコードが取得できません。  主契約商品コード＝1001主契約商品世代番号＝11",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10040));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(999999999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10040), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(10040), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            true, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10070));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10070), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10080));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10080), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KYKTORIKESI);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10090));


        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10090), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(81.73, BizCurrencyTypes.AU_DOLLAR),
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10100));


        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10100), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10100), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10120));


        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10120), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10120), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20120204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10130));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10130), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20120204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10140));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10140), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20120204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10150));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10150), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10130));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10130), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBMENSEKI);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.EUR);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10140));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.EUR,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10140), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10150));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10150), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10170));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10170), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            true, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10180));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10180), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10190));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10190), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10200));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(10200));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "521",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10200), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10200), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10220));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(10220));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "521",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10220), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10220), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10230));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(10230));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "521",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10230), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10230), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10240));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(10240));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10240), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10240), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20170928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10250));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(10250));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10250), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10250), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10270));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);

        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(10270));

        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(10270));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        taisyouGkBeanLst.add(taisyouGkBean1);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10270), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(10270), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10270), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(280)
    public void testExec_A28() {

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.BLNK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10280));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        try {


            commonSiwake.exec(commonSiwakeInBean);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。仕訳共通処理エラー　対象外の金額種類です。金額種類＝", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(0));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);

        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(-10290));

        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(999999));
        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);

        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);

        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(10290));

        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(10290));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        taisyouGkBeanLst.add(taisyouGkBean1);
        taisyouGkBeanLst.add(taisyouGkBean2);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "103", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUTORIKESI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "103",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10290), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(10290), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KAIYAKUHENREIKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUTORIKESI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHYENDTHNKHRSHR);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "110", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUHOZEN, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "110", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.KAIYAKUHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KAIYAKUHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        assertNull( "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード", commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd());
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(81.41, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        assertNull( "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード", commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd());
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(430)
    public void testExec_A43() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(440)
    public void testExec_A44() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_PTUMITATEKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        assertNull( "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード", commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd());
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_YENDTHNKHR);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        assertNull( "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード", commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd());
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(81.41, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(0));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean1.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(10290));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(999999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        taisyouGkBeanLst.add(taisyouGkBean1);
        taisyouGkBeanLst.add(taisyouGkBean2);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "106",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(10290), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(83.35, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
        exBizCalcbleEquals(commonSiwakeOutBean.getGaikataikagk(), BizCurrency.valueOf(83.35, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．外貨対価額");
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.ARI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(0));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean1.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(10290));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(999999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        taisyouGkBeanLst.add(taisyouGkBean1);
        taisyouGkBeanLst.add(taisyouGkBean2);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "106",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(10290), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 2, "仕訳明細Beanリストのサイズ");
        exBizCalcbleEquals(commonSiwakeOutBean.getGaikataikagk(), BizCurrency.valueOf(999999), "仕訳共通処理出力Bean．外貨対価額");
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_DSHR);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.ARI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "111", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SOUKATU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "111",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "106", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(590)
    public void testExec_A59() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(650)
    public void testExec_A65() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(700)
    public void testExec_A70() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(720)
    public void testExec_A72() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(730)
    public void testExec_A73() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(740)
    public void testExec_A74() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(750)
    public void testExec_A75() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(760)
    public void testExec_A76() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(770)
    public void testExec_A77() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(780)
    public void testExec_A78() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(790)
    public void testExec_A79() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(800)
    public void testExec_A80() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(810)
    public void testExec_A81() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);


        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);



        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[1]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");


        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[2]．（ＩＢ）貸借調整フラグ");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(820)
    public void testExec_A82() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_DSHR);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(830)
    public void testExec_A83() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(840)
    public void testExec_A84() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(850)
    public void testExec_A85() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(860)
    public void testExec_A86() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(870)
    public void testExec_A87() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(880)
    public void testExec_A88() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(890)
    public void testExec_A89() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(900)
    public void testExec_A90() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(910)
    public void testExec_A91() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(920)
    public void testExec_A92() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(930)
    public void testExec_A93() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(940)
    public void testExec_A94() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(950)
    public void testExec_A95() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(960)
    public void testExec_A96() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(970)
    public void testExec_A97() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_GENGAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(980)
    public void testExec_A98() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(990)
    public void testExec_A99() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1000)
    public void testExec_A100() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1010)
    public void testExec_A101() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1020)
    public void testExec_A102() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1030)
    public void testExec_A103() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1040)
    public void testExec_A104() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.ARI);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1050)
    public void testExec_A105() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1060)
    public void testExec_A106() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.EUR);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1070)
    public void testExec_A107() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.SBKAIJO);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setAzukarikinUmuKbn(C_UmuKbn.NONE);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1080)
    public void testExec_A108() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "109",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
        exClassificationEquals(commonSiwakeInBean.getAzukarikinUmuKbn(),
            null, "仕訳共通処理入力Bean．預り金有無区分");
        exClassificationEquals(commonSiwakeInBean.getGstszeigkUmuKbn(),
            null, "仕訳共通処理入力Bean．源泉徴収税額有無区分");
    }

    @Test
    @TestOrder(1090)
    public void testExec_A109() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHPMINYUUSYOUMETU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.GKDTYENHRKGKKOTEI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD,
            "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
        exClassificationEquals(commonSiwakeInBean.getAzukarikinUmuKbn(),
            null, "仕訳共通処理入力Bean．預り金有無区分");
        exClassificationEquals(commonSiwakeInBean.getGstszeigkUmuKbn(),
            null, "仕訳共通処理入力Bean．源泉徴収税額有無区分");
    }

    @Test
    @TestOrder(1100)
    public void testExec_A110() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);

        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));

        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");

        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI);

        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.SIBOU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");

        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
    }

    @Test
    @TestOrder(1110)
    public void testExec_A111() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);

        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));

        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");

        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI);

        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.KAIYAKU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");

        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
    }

    @Test
    @TestOrder(1120)
    public void testExec_A112() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);

        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));

        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");

        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI);

        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.KAIYAKU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.AUD);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999999999));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");

        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.AUD,
            "仕訳共通処理出力Bean．契約通貨種類");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_GAIHO_AUD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
    }
    @Test
    @TestOrder(1130)
    public void testExec_A113() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);

        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));

        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);

        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));

        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));

        commonSiwakeInBean.setSyouhnCd("1002");

        commonSiwakeInBean.setSyouhnsdNo(12);

        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);

        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_SOUDAIKAI_YOKUEI);

        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.KAIYAKU);

        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_D);

        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));

        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");

        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");

        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");

        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");

        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN,
            "仕訳共通処理出力Bean．振替伝票作成区分");

        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI,
            "仕訳共通処理出力Bean．伝票用返金方法区分");

        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN,
            "仕訳共通処理出力Bean．伝票用支払方法区分");

        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY,
            "仕訳共通処理出力Bean．契約通貨種類");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYAINHAITOUKIN_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
    }

    @Test
    @TestOrder(1140)
    public void testExec_A114() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI);
        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.SIBOU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.ARI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "104", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI,
            "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");

        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");

        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "104",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
    }

    @Test
    @TestOrder(1150)
    public void testExec_A115() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KHDSEISANTUIBARAI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20160205"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20140928"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI_SOUDAIKAI_YOKUEI);
        commonSiwakeInBean.setHaitoukinTuibaraiHanteiKbn(C_DseisantetudukimeiKbn.KAIYAKU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        commonSiwakeInBean.setGstszeigkUmuKbn(C_UmuKbn.ARI);
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10290));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(0));
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "102", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20160205"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKARI, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");

        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "102",
            "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(10290), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");

        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),

            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");

        exBizCalcbleEquals(commonSiwakeOutBean.getGaikataikagk(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．外貨対価額");
    }

    @Test
    @TestOrder(1160)
    public void testExec_A116() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_BATCH_KAIYAKU);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.GENSENTYOUSYU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "109", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DS, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HOZENYAKAN, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "516", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1170)
    public void testExec_A117() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1180)
    public void testExec_A118() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1190)
    public void testExec_A119() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1200)
    public void testExec_A120() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYOP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1210)
    public void testExec_A121() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1220)
    public void testExec_A122() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1230)
    public void testExec_A123() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_SYONENDO2KAIMEIKOU);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1240)
    public void testExec_A124() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1250)
    public void testExec_A125() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1260)
    public void testExec_A126() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1270)
    public void testExec_A127() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_JINENDO);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1280)
    public void testExec_A128() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1290)
    public void testExec_A129() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0,BizCurrencyTypes.DOLLAR), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1300)
    public void testExec_A130() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1310)
    public void testExec_A131() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(11);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setTuukasyuKansanKawaserate(BizNumber.valueOf(123.45));
        taisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        taisyouGkBean.setTaisyouGk(BizCurrency.valueOf(10050));
        taisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI );
        taisyouGkBean.setSeg2cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI );
        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();
        taisyouGkBeanLst.add(taisyouGkBean);
        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "仕訳共通処理出力Bean．伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(), "108", "仕訳共通処理出力Bean．振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "仕訳共通処理出力Bean．担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20150928"), "仕訳共通処理出力Bean．伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "仕訳共通処理出力Bean．通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.BLNK, "仕訳共通処理出力Bean．振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "仕訳共通処理出力Bean．伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20160118"), "仕訳共通処理出力Bean．処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RB", "仕訳共通処理出力Bean．処理コード");
        exClassificationEquals(commonSiwakeOutBean.getKyktuukaSyu(), C_Tuukasyu.USD, "仕訳共通処理出力Bean．契約通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(), null, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）勘定科目コード");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(10050), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(99999), "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）伝票用仮勘定番号");

        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "仕訳共通処理出力Bean．仕訳明細Beanリスト[0]．（ＩＢ）貸借調整フラグ");
        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 1, "仕訳明細Beanリストのサイズ");
    }

    @Test
    @TestOrder(1320)
    public void testExec_A132() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean2);

        TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean3.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean3.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBeanLst.add(taisyouGkBean3);

        TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean4.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean4.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
        taisyouGkBeanLst.add(taisyouGkBean4);

        TaisyouGkBean taisyouGkBean5 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean5.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean5.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean5.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        taisyouGkBeanLst.add(taisyouGkBean5);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 6, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(5).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU, "（ＩＢ）勘定科目コード");
    }

    @Test
    @TestOrder(1330)
    public void testExec_A133() {

        kinou.setSyoricd("RB");
        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean2);

        TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean3.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean3.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBeanLst.add(taisyouGkBean3);

        TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean4.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean4.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
        taisyouGkBeanLst.add(taisyouGkBean4);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 5, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");
    }

    @Test
    @TestOrder(1340)
    public void testExec_A134() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean2);

        TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean3.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean3.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBeanLst.add(taisyouGkBean3);

        TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean4.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean4.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
        taisyouGkBeanLst.add(taisyouGkBean4);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 5, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_USD, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
    }

    @Test
    @TestOrder(1350)
    public void testExec_A135() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_KEIYAKUINFOTORIKOMI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.AUD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setHijynbrKanritukaHantKbn(C_HijynbrKanritukaHantKbn.BLNK);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDOSYOKAIP);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SYONENDO2KAIMEIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_JINENDOIKOUP);
        taisyouGkBeanLst.add(taisyouGkBean2);

        TaisyouGkBean taisyouGkBean3 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean3.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean3.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_SONOTAHENREIKIN);
        taisyouGkBeanLst.add(taisyouGkBean3);

        TaisyouGkBean taisyouGkBean4 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean4.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean4.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean4.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANP_HENKAN);
        taisyouGkBeanLst.add(taisyouGkBean4);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 5, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(3).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSuitoubumoncd(), "108",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDengaikagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(4).getIbDenyenkagk(),
            BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
    }

    @Test
    @TestOrder(1360)
    public void testExec_A136() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.JPY);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        taisyouGkBeanLst.add(taisyouGkBean2);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "担当コード");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "（ＩＢ）伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI, "伝票用支払方法区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");
    }

    @Test
    @TestOrder(1370)
    public void testExec_A137() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.JPY);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        taisyouGkBeanLst.add(taisyouGkBean2);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);
        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.HOZEN, "仕訳共通処理出力Bean．伝票用システム区分");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "担当コード");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "（ＩＢ）伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.BLNK, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");
    }

    @Test
    @TestOrder(1380)
    public void testExec_A138() {

        kinou.setSyoricd("RB");

        commonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_SEINENGAPPISEI);
        commonSiwakeInBean.setDenYmd(BizDate.valueOf("20150928"));
        commonSiwakeInBean.setTuukasyu(C_Tuukasyu.USD);
        commonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20160118"));
        commonSiwakeInBean.setKykYmd(BizDate.valueOf("20160204"));
        commonSiwakeInBean.setSyouhnCd("1002");
        commonSiwakeInBean.setSyouhnsdNo(12);
        commonSiwakeInBean.setSyoriKbn(C_SyoriKbn.CLGOFF);
        commonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        commonSiwakeInBean.setKyktuukaSyu(C_Tuukasyu.USD);

        List<TaisyouGkBean> taisyouGkBeanLst = new ArrayList<>();

        TaisyouGkBean taisyouGkBean0 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean0.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean0.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean0.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP_TUITYOU);
        taisyouGkBeanLst.add(taisyouGkBean0);

        TaisyouGkBean taisyouGkBean1 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        taisyouGkBeanLst.add(taisyouGkBean1);

        TaisyouGkBean taisyouGkBean2 = SWAKInjector.getInstance(TaisyouGkBean.class);
        taisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(999999999));
        taisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(99999));
        taisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        taisyouGkBeanLst.add(taisyouGkBean2);

        commonSiwakeInBean.setTaisyouGkBeanLst(taisyouGkBeanLst);

        CommonSiwakeOutBean commonSiwakeOutBean = commonSiwake.exec(commonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KEIYAKUHENKOU, "担当コード");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "（ＩＢ）伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.BLNK, "伝票用支払方法区分");

        exNumericEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().size(), 3, "仕訳明細Beanリストのサイズ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(),
            C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(1).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakukbn(),
            C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSuitoubumoncd(), "106",
            "（ＩＢ）出納部門コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg1cd(),
            C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbSeg2cd(),
            C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKeiyakutuukagk(),
            BizCurrency.valueOf(99999), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKawasetekiyokbn(),
            C_KawasetekiyoKbn.TTM, "（ＩＢ）為替適用区分");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenkarikanjyono(),
            "", "（ＩＢ）伝票用仮勘定番号");
        exBooleanEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbTaisyakutyouseiflg(),
            false, "（ＩＢ）貸借調整フラグ");

        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbKanjyoukmkcd(),
            null, "（ＩＢ）勘定科目コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDengaikagk(),
            BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(2).getIbDenyenkagk(),
            BizCurrency.valueOf(999999999), "（ＩＢ）伝票金額（円）");
    }
}
