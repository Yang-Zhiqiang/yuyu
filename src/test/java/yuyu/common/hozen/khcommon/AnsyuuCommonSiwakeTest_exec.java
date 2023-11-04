package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DenSyorisyousaiKbn;
import yuyu.def.classification.C_DenhnknhouKbn;
import yuyu.def.classification.C_DenshrhouKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HuridensksKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KhDengkSyuruiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * KeisanIkkatuPGkクラスのメソッド {@link KeisanIkkatuPGk#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class AnsyuuCommonSiwakeTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_案内収納用仕訳共通処理";

    private final static String sheetName = "INデータ";

    @Inject
    private  AnsyuuCommonSiwake  ansyuuCommonSiwake;

    @Inject
    private  AS_Kinou kinou;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanIkkatuWaribikiPTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        bizDomManager.delete(bizDomManager.getTantouCd (C_TantouCdKbn.KAIYAKU));
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(-1, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(-1));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(0, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(100));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);


        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201712"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(667), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }


        }
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201801"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201802"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20180110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20180110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }

        }
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20180110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }

        }
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setDenkarikanjyono("");

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
                exStringEquals(bzSiwakeMeisaiBean.getIbDenkarikanjyono(), "", "（ＩＢ）伝票用仮勘定番号");

            }

        }
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRTIENRSK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KZHRK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(C_Syuudaikocd.SIS);
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"511", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.YOHURI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.KZHURIKAE_SIS, "伝票用処理詳細区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "511", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.CREDIT);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SYUUDANTEIKI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.CREDIT, "伝票用処理詳細区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
            }
        }
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        kinou.setSyoricd("RD34");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD34", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.HKNKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"512", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SIBOUTETUZUKI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.CONVENI);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"511", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.YOHURI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKIN, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "521", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        kinou.setSyoricd("RD36");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SHRGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"516", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.KAIYAKU, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.ONLINEFB, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.KOUZAHURIKOMI, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.FBSOUKINYOKU, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD36", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "521", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HURIKOMIRYOUSYUGK);
        ansyuuTaisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean1.setNykdenYmd(null);
        ansyuuTaisyouGkBean1.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean1.setJyutouStartYm(null);
        ansyuuTaisyouGkBean1.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean1.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean1);



        ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.RYOUSYUP);
        ansyuuTaisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean2.setNykdenYmd(null);
        ansyuuTaisyouGkBean2.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean2.setJyutouStartYm(null);
        ansyuuTaisyouGkBean2.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean2.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean2);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean2 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean3 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);

        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean1.setNykdenYmd(null);
        ansyuuTaisyouGkBean1.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean1.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean1.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean1.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean1);

        ansyuuTaisyouGkBean2.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean2.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean2.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean2.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean2.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean2.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean2.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean2.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean2);

        ansyuuTaisyouGkBean3.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean3.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean3.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean3.setNykdenYmd(null);
        ansyuuTaisyouGkBean3.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean3.setJyutouStartYm(null);
        ansyuuTaisyouGkBean3.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean3.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean3);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(5, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;


            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(666), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(668), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }
            if(i==3){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }
            if(i==4){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(666), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

            if(i==5){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(668), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }
        }
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);

        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        kinou.setSyoricd("RD36");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD36", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY  , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(500), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(270)
    public void testExec_A27() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20180110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20180110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(280)
    public void testExec_A28() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(290)
    public void testExec_A29() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(300)
    public void testExec_A30() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(3, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }
        }
    }

    @Test
    @TestOrder(310)
    public void testExec_A31() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");
    }

    @Test
    @TestOrder(320)
    public void testExec_A32() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20180110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20180110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(330)
    public void testExec_A33() {

        kinou.setSyoricd("RD34");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201712"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD34", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }

    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        kinou.setSyoricd("RD86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BANK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSuitouSoshikiCd("1");
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(350)
    public void testExec_A35() {

        kinou.setSyoricd("RD12");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.HKNKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"513", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SOUKATU, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD12", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(360)
    public void testExec_A36() {

        kinou.setSyoricd("RD35");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD35", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(370)
    public void testExec_A37() {

        kinou.setSyoricd("RDHU");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_YOKUJITU);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(380)
    public void testExec_A38() {

        kinou.setSyoricd("RDHU");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(390)
    public void testExec_A39() {

        kinou.setSyoricd("RDHU");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_2EIGYOUBI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        kinou.setSyoricd("RG87");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG87", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(410)
    public void testExec_A41() {

        kinou.setSyoricd("RG87");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.FB_3EIGYOUBI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG87", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(420)
    public void testExec_A42() {

        kinou.setSyoricd("RG87");
        kinou.setKinouKbn(C_KinouKbn.BATCH);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKIN);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KYHKIN);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG87", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(430)
    @Transactional
    public void testExec_A43() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ｱｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);

        try{

            ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);
        }

        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "商品属性マスタからセグメントコードが取得できません。  主契約商品コード＝ｱｱ契約通貨種類＝ユーロ",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(440)
    @Transactional
    public void testExec_A44() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111184");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);

        try{

            ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);
        }

        catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。"
                + "契約商品テーブルから契約通貨種類が取得できません。  証券番号＝11807111184",
                "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(450)
    public void testExec_A45() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999, BizCurrencyTypes.DOLLAR));
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean1.setNykdenYmd(null);
        ansyuuTaisyouGkBean1.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean1.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean1.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean1.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean1);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(),
                    BizCurrency.valueOf(499.5, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
                    "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK,
                    "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(),
                    BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(460)
    public void testExec_A46() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999, BizCurrencyTypes.AU_DOLLAR));
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean1.setNykdenYmd(null);
        ansyuuTaisyouGkBean1.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean1.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean1.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean1.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean1);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(),
                    BizCurrency.valueOf(499.5, BizCurrencyTypes.AU_DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
                    "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(),
                    BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(470)
    public void testExec_A47() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean1 = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean1.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean1.setTaisyouGk(BizCurrency.valueOf(999, BizCurrencyTypes.EURO));
        ansyuuTaisyouGkBean1.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean1.setNykdenYmd(null);
        ansyuuTaisyouGkBean1.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean1.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean1.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean1.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean1);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.BLNK, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(),
                    BizCurrency.valueOf(499.5, BizCurrencyTypes.EURO), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
                    "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(),
                    BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(480)
    public void testExec_A48() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.33, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.34, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(490)
    public void testExec_A49() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.33, BizCurrencyTypes.AU_DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.34, BizCurrencyTypes.AU_DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(500)
    public void testExec_A50() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.BLNK, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.33, BizCurrencyTypes.EURO), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.BLNK, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(333.34, BizCurrencyTypes.EURO), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(510)
    public void testExec_A51() {

        kinou.setSyoricd("RD34");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"513", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SOUKATU, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.BLNK, "伝票用処理詳細区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD34", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_USD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "513", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(520)
    public void testExec_A52() {

        kinou.setSyoricd("RD86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.AUD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_AUD, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(1000, BizCurrencyTypes.AU_DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(530)
    public void testExec_A53() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.EURO));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.EUR, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.BLNK, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(1000, BizCurrencyTypes.EURO), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(540)
    public void testExec_A54() {

        kinou.setSyoricd("RG34");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setDenkarikanjyono("1");

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG34", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SONOTA, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
                exStringEquals(bzSiwakeMeisaiBean.getIbDenkarikanjyono(), "1", "（ＩＢ）伝票用仮勘定番号");

            }

        }
    }

    @Test
    @TestOrder(550)
    public void testExec_A55() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KZHRK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(C_Syuudaikocd.CSS);
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.YOHURI, "担当コード");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.NET_KOUHURI_CSS, "伝票用処理詳細区分");
    }

    @Test
    @TestOrder(560)
    public void testExec_A56() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.KZHRK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyuudaikoCd(C_Syuudaikocd.BLNK);
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.HOZEN_RYOUSYUGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.BLNK, "伝票用処理詳細区分");
    }

    @Test
    @TestOrder(570)
    public void testExec_A57() {

        kinou.setSyoricd("RDHU");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_NASI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.CREDITTORIKESIGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SYUUDANTEIKI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.CREDITHENKIN_MINUSURIAGE, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.CREDITHENKIN_MINUSURIAGE, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RDHU", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE, "（ＩＢ）勘定科目コード ");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.CREDITHENKIN_MINUSURIAGE, "（ＩＢ）伝票用返金方法区分");

    }

    @Test
    @TestOrder(580)
    public void testExec_A58() {

        kinou.setSyoricd("RD36");
        kinou.setKinouKbn(C_KinouKbn.ONLINE);

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.KARIUKE_RISOKU_ARI);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.CREDITTORIKESIGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SYUUDANTEIKI, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.CREDITHENKIN_MINUSURIAGE, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.CREDITHENKIN_MINUSURIAGE, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD36", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKanjyoukmkcd(),
            C_Kanjyoukmkcd.HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE, "（ＩＢ）勘定科目コード ");
        exStringEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
        exClassificationEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
        exBizCalcbleEquals(commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst().get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.CREDITHENKIN_MINUSURIAGE, "（ＩＢ）伝票用返金方法区分");
    }
    @Test
    @TestOrder(590)
    public void testExec_A59() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(600)
    public void testExec_A60() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }

        }
    }

    @Test
    @TestOrder(610)
    public void testExec_A61() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20180110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20180110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SONOTAHENREIKIN_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
        }
    }

    @Test
    @TestOrder(620)
    public void testExec_A62() {

        kinou.setSyoricd("RD34");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"513", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.SOUKATU, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.USD, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.HONSYARYOUKIN, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDensyorisyousaikbn(), C_DenSyorisyousaiKbn.BLNK, "伝票用処理詳細区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD34", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "513", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(630)
    public void testExec_A63() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setDenkarikanjyono("");


        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
                exStringEquals(bzSiwakeMeisaiBean.getIbDenkarikanjyono(), "", "（ＩＢ）伝票用仮勘定番号");

            }

        }
    }

    @Test
    @TestOrder(640)
    public void testExec_A64() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111182");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setDenkarikanjyono("");


        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.KARIUKEKIN_HUHOKOBETU_GAIHO_JPY , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
                exStringEquals(bzSiwakeMeisaiBean.getIbDenkarikanjyono(), "", "（ＩＢ）伝票用仮勘定番号");

            }

        }
    }


    @Test
    @TestOrder(650)
    public void testExec_A65() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111118");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setDenkarikanjyono("");


        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");
                exStringEquals(bzSiwakeMeisaiBean.getIbDenkarikanjyono(), "", "（ＩＢ）伝票用仮勘定番号");

            }

        }
    }

    @Test
    @TestOrder(660)
    public void testExec_A66() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(null);
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KARIUKEGK);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(null);
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(0));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(670)
    public void testExec_A67() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201712"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(667), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }


        }
    }

    @Test
    @TestOrder(680)
    public void testExec_A68() {

        kinou.setSyoricd("RD36");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(999, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), C_HuridensksKbn.KOBETU, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), C_DenshrhouKbn.KARIUKERSKNASI, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RD36", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU , "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(500), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }

    @Test
    @TestOrder(690)
    public void testExec_A69() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111185");



        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201801"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(1, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(1000), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.BLNK, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }

        }
    }
    @Test
    @TestOrder(700)
    public void testExec_A70() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111118");


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.KEIJYOUP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(1000));
        ansyuuTaisyouGkBean.setNykdenYmd(null);

        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(0));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);

        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(0, list.size(), "仕訳明細Beanリスト件数");

    }

    @Test
    @TestOrder(710)
    public void testExec_A71() {

        kinou.setSyoricd("RG86");

        AnsyuuCommonSiwakeInBean  ansyuuCommonSiwakeInBean  =SWAKInjector.getInstance(AnsyuuCommonSiwakeInBean.class);
        List<AnsyuuTaisyouGkBean> listansyuuTaisyouGkBean  = new ArrayList<AnsyuuTaisyouGkBean>();
        AnsyuuTaisyouGkBean ansyuuTaisyouGkBean = SWAKInjector.getInstance(AnsyuuTaisyouGkBean.class);

        ansyuuCommonSiwakeInBean.setKinouId(IKhozenCommonConstants.KINOUID_NYUUKINTORIKESI);
        ansyuuCommonSiwakeInBean.setDensysKbn(C_DensysKbn.SKEI);
        ansyuuCommonSiwakeInBean.setDenYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setSyoriYmd(BizDate.valueOf("20170106"));
        ansyuuCommonSiwakeInBean.setKykYmd(BizDate.valueOf("20170110"));
        ansyuuCommonSiwakeInBean.setNykkeiro(C_Nykkeiro.BLNK);
        ansyuuCommonSiwakeInBean.setShrhousiteiKbn(C_ShrhousiteiKbn.BLNK);
        ansyuuCommonSiwakeInBean.setSyono("11807111118");
        ansyuuCommonSiwakeInBean.setSyouhinCd("ﾕｱ");
        ansyuuCommonSiwakeInBean.setSyouhnsdno(1);


        ansyuuTaisyouGkBean.setKhDengkSyuruiKbn(C_KhDengkSyuruiKbn.SEISANK_KIHRKMP);
        ansyuuTaisyouGkBean.setTaisyouGk(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        ansyuuTaisyouGkBean.setKeiyakutuukaGk(BizCurrency.valueOf(2000));
        ansyuuTaisyouGkBean.setNykdenYmd(BizDate.valueOf("20170110"));
        ansyuuTaisyouGkBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        ansyuuTaisyouGkBean.setJyutouStartYm(BizDateYM.valueOf("201701"));
        ansyuuTaisyouGkBean.setJyutouKaisuuY(Integer.valueOf(1));
        ansyuuTaisyouGkBean.setJyutouKaisuuM(Integer.valueOf(1));

        listansyuuTaisyouGkBean.add(ansyuuTaisyouGkBean);
        ansyuuCommonSiwakeInBean.setAnsyuuTaisyouGkBeanLst(listansyuuTaisyouGkBean);

        CommonSiwakeOutBean commonSiwakeOutBean = ansyuuCommonSiwake.exec(ansyuuCommonSiwakeInBean);

        exClassificationEquals(commonSiwakeOutBean.getDensysKbn(), C_DensysKbn.SKEI, "伝票用システム区分");
        exStringEquals(commonSiwakeOutBean.getHuridenatesakiCd(),"551", "振替伝票宛先部課コード");
        exClassificationEquals(commonSiwakeOutBean.getTantoCd(), C_TantouCdKbn.BLNK0, "担当コード");
        exDateEquals(commonSiwakeOutBean.getDenyMd(), BizDate.valueOf("20170110"), "伝票日付");
        exClassificationEquals(commonSiwakeOutBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(commonSiwakeOutBean.getHuridensksKbn(), null, "振替伝票作成区分");
        exClassificationEquals(commonSiwakeOutBean.getDenhnknhouKbn(), C_DenhnknhouKbn.BLNK, "伝票用返金方法区分");
        exClassificationEquals(commonSiwakeOutBean.getDenshrhouKbn(), null, "伝票用支払方法区分");
        exDateEquals(commonSiwakeOutBean.getSyoriYmd(), BizDate.valueOf("20170106"), "処理年月日");
        exStringEquals(commonSiwakeOutBean.getSyoriCd(), "RG86", "処理コード");

        List<BzSiwakeMeisaiBean> list = commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst();
        exNumericEquals(2, list.size(), "仕訳明細Beanリスト件数");
        int i = 0;
        for (BzSiwakeMeisaiBean bzSiwakeMeisaiBean : commonSiwakeOutBean.getBzSiwakeMeisaiBeanLst()) {
            i++;
            if(i==1){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(333), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額");

            }
            if(i==2){
                exClassificationEquals(bzSiwakeMeisaiBean.getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "（ＩＢ）貸借区分");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbKanjyoukmkcd(),
                    C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU, "（ＩＢ）勘定科目コード ");
                exStringEquals(bzSiwakeMeisaiBean.getIbSuitoubumoncd(), "551", "（ＩＢ）出納部門コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDengaikagk(), BizCurrency.valueOf(0), "（ＩＢ）伝票金額（外貨）");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbDenyenkagk(), BizCurrency.valueOf(334), "（ＩＢ）伝票金額（円）");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, "（ＩＢ）セグメント１コード");
                exClassificationEquals(bzSiwakeMeisaiBean.getIbSeg2cd(), C_Segcd.BLNK, "（ＩＢ）セグメント２コード");
                exBizCalcbleEquals(bzSiwakeMeisaiBean.getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "（ＩＢ）契約通貨金額"); }

        }
    }
}