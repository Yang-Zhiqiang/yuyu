package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyun;
import yuyu.common.hozen.ascommon.GetHrkKawaseRateKijyunMockForKhansyuu;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsn;
import yuyu.common.hozen.ascommon.KeisanPRsTuukaKnsnMockForKhansyuu;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * KeisanIkkatuNyuukinGkクラスのメソッド {@link KeisanTukiIkkatuNyuukinGk#exec(String,BizDate,BizDateYM,Integer)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTukiIkkatuNyuukinGkTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_月払一括入金額計算";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanIkkatuWaribikiP.class).to(KeisanIkkatuWaribikiPMockForKhansyuu.class);
                bind(KeisanIkkatuWaribikiKikan.class).to(KeisanIkkatuWaribikiKikanMockForKhansyuu.class);
                bind(KeisanPRsTuukaKnsn.class).to(KeisanPRsTuukaKnsnMockForKhansyuu.class);
                bind(GetHrkKawaseRateKijyun.class).to(GetHrkKawaseRateKijyunMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = KeisanTukiIkkatuNyuukinGkTest_exec.class;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = KeisanTukiIkkatuNyuukinGkTest_exec.class;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = KeisanTukiIkkatuNyuukinGkTest_exec.class;
        GetHrkKawaseRateKijyunMockForKhansyuu.caller = KeisanTukiIkkatuNyuukinGkTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        KeisanIkkatuWaribikiPMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.caller = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = null;
        GetHrkKawaseRateKijyunMockForKhansyuu.caller = null;
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = null;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = null;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = null;

        MockObjectManager.initialize();
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanTukiIkkatuNyuukinGkTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
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
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(0);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(), C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }
    @Test
    @TestOrder(20)
    public void testExec_A2() {
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("001");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);
        boolean pIktwaribikifuyouFlg = true;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);

        String syouhnCd = (String)MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 0);
        exStringEquals(syouhnCd, "1003", "商品コード");

        String ryouritusdNo = (String) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 1);
        exStringEquals(ryouritusdNo, "003", "料率世代番号");

        BizNumber yoteiRiritu = (BizNumber) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 2);
        exBizCalcbleEquals(yoteiRiritu, BizNumber.valueOf(1200), "予定利率");

        int keikamon = (int) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 3);
        exNumericEquals(keikamon, 2, "一括月数");

        BizCurrency hokenryou = (BizCurrency) MockObjectManager.getArgument(KeisanIkkatuWaribikiPMockForKhansyuu.class, "exec", 0, 4);
        exBizCalcbleEquals(hokenryou, BizCurrency.valueOf(100), "割引前保険料");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.MASTER_DATA_SYUTOKU_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 2, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1004");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("004");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(6);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(600), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(600), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),6, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN3;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("3005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(7);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1400), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1400), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 7, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("202012"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 7, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(1400), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN5;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(11);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(2200), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(2200), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 11, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("202012"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 11, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(2200), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1007");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("007");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1000), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1000), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("202012"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 12, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(1000), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1008");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("008");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(13);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.MASTER_DATA_SYUTOKU_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 2, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);
        boolean pIktwaribikifuyouFlg = true;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(2400), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(2400), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),12, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN1;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 2, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN2;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(),  0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN3;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        MockObjectManager.initialize();
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN4;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);

        C_NyknaiyouKbn nyknaiyouKbn = (C_NyknaiyouKbn)MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(nyknaiyouKbn, C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");

        C_Nykkeiro nykkeiro = (C_Nykkeiro) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 1);
        exClassificationEquals(nykkeiro, C_Nykkeiro.BANK, "入金経路");

        BizDate rsymd = (BizDate) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 2);
        exDateEquals(rsymd, BizDate.valueOf("20201215"), "領収年月日");

        BizDateYM jyutoustartym = (BizDateYM) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 3);
        exDateYMEquals(jyutoustartym, BizDateYM.valueOf("202012"), "充当開始年月");

        int jyuutounensuu = (int) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 4);
        exNumericEquals(jyuutounensuu, 0, "充当年数");

        int jyuutoutukisuu = (int) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 5);
        exNumericEquals(jyuutoutukisuu, 12, "充当月数");

        C_Hrkkaisuu hrkkaisuu = (C_Hrkkaisuu) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 6);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.TUKI, "払込回数");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(150)
    public void testExec_A15() {
        MockObjectManager.initialize();
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN5;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        try {
            keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。一括入金額計算エラー。"
                + "払込用為替レート基準日取得で想定外のエラーが発生しました。エラー理由：為替レート取得ミス",
                "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        MockObjectManager.initialize();

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);

        C_NyknaiyouKbn nyknaiyouKbn = (C_NyknaiyouKbn)MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(nyknaiyouKbn, C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");

        C_Nykkeiro nykkeiro = (C_Nykkeiro) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 1);
        exClassificationEquals(nykkeiro, C_Nykkeiro.OTHER, "入金経路");

        BizDate rsymd = (BizDate) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 2);
        exDateEquals(rsymd, BizDate.valueOf("20201215"), "領収年月日");

        BizDateYM jyutoustartym = (BizDateYM) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 3);
        exDateYMEquals(jyutoustartym, BizDateYM.valueOf("202012"), "充当開始年月");

        int jyuutounensuu = (int) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 4);
        exNumericEquals(jyuutounensuu, 0, "充当年数");

        int jyuutoutukisuu = (int) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 5);
        exNumericEquals(jyuutoutukisuu, 12, "充当月数");

        C_Hrkkaisuu hrkkaisuu = (C_Hrkkaisuu) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 6);
        exClassificationEquals(hrkkaisuu, C_Hrkkaisuu.TUKI, "払込回数");

        BizDate kwsratekjymd = (BizDate)MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 0);
        exDateEquals(kwsratekjymd, BizDate.valueOf("20201215"), "為替レート基準日");

        BizCurrency hokenryou = (BizCurrency) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 1);
        exBizCalcbleEquals(hokenryou, BizCurrency.valueOf(100), "保険料");

        C_Tuukasyu knsnmotoTuukasyu = (C_Tuukasyu) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 2);
        exClassificationEquals(knsnmotoTuukasyu, C_Tuukasyu.JPY, "換算元通貨種類");

        C_Tuukasyu knsnsakiTuukasyu = (C_Tuukasyu) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 3);
        exClassificationEquals(knsnsakiTuukasyu, C_Tuukasyu.AUD, "換算先通貨種類");

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(), BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN3;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.KAWASERATE_SYUTOKU_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");


    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(180)
    public void testExec_A18() {
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN4;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        try {
            keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。一括入金額計算エラー。"
                + "保険料領収通貨換算計算で想定外のエラーが発生しました。エラー理由：払込回数不正",
                "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN1;

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1004");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("004");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(6);
        keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.BLNK);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.SKEI);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));
        boolean pIktwaribikifuyouFlg = false;

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,pIktwaribikifuyouFlg);
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),6, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(200)
    public void testExec_B1() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(0);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180101"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(210)
    public void testExec_B2() {

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("1001");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("0");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(0));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(13);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180101"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(220)
    public void testExec_B3() {

        MockObjectManager.initialize();
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2003");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("003");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201804"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 0), BizDate.valueOf("20180801"), "領収日");
        exDateYMEquals((BizDateYM)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 1), BizDateYM.valueOf(201804), "充当年月");
        exNumericEquals((Integer)MockObjectManager.getArgument(KeisanIkkatuWaribikiKikanMockForKhansyuu.class,
            "exec", 0, 2), 1, "充当月数");
    }

    @Test
    @TestOrder(230)
    public void testExec_B4() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2004");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("004");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(null);

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(100), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201805"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(100), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(240)
    public void testExec_B5() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN3;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(2);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), BizDate.valueOf(20201215), "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(100), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 1, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 2, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201805"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(1100, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getJyutoustartYm(), BizDateYM.valueOf("201806"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRskingaku(), BizCurrency.valueOf(100), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(250)
    public void testExec_B6() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(3);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(100), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(), BizCurrency.valueOf(100), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201805"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(100), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }

    @Test
    @TestOrder(260)
    public void testExec_B7() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN1;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2006");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("006");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(6);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201806"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.MASTER_DATA_SYUTOKU_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 6, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }

    @Test
    @TestOrder(270)
    public void testExec_B8() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN5;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN5;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2007");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("007");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(11);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201806"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1100), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), BizDate.valueOf(20201215), "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1100), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 11, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201806"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 11, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(1100), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1100), "一括割引料");
    }

    @Test
    @TestOrder(280)
    public void testExec_B9() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN4;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN6;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2008");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("008");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201807"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(1000), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), BizDate.valueOf(20201215), "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(1000), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 12, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),0, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 1, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201807"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 12, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(1000), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");
    }

    @Test
    @TestOrder(290)
    public void testExec_B10() {

        KeisanIkkatuWaribikiPMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiPMockForKhansyuu.TESTPATTERN6;
        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN7;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(1);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(2);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1100));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(3);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1000));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(4);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(900));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2009");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(5);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("009");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(800));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);

        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(12);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180901"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.BLNK, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(42004), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(804), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), BizDate.valueOf(20201215), "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(42004), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 10, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),2, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 3, "一括入金額計算結果内訳Beanリストの件数");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyutoustartYm(), BizDateYM.valueOf("201805"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRskingaku(), BizCurrency.valueOf(5500, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktnyuukinnUmu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getJyutoustartYm(), BizDateYM.valueOf("201806"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getJyuutoutuKisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRskingaku(), BizCurrency.valueOf(5500, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getIktnyuukinnUmu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getNyknaiyouKbn(), C_NyknaiyouKbn.ZENNOUP, "入金内容区分");
        exDateYMEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getJyutoustartYm(), BizDateYM.valueOf("201807"), "充当開始年月");
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getJyuutoutuKisuu(), 10, "充当月数");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getRskingaku(), BizCurrency.valueOf(42004), "領収金額");
        exDateEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getRyosyuKwsRateKjYmd(), BizDate.valueOf("20201215"), "領収為替レート基準日");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getRyosyuKwsRate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getIktnyuukinnUmu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.get(2).getIktwaribikikgk(), BizCurrency.valueOf(804), "一括割引料");
    }

    @Test
    @TestOrder(300)
    public void testExec_B11() {

        KeisanIkkatuWaribikiKikanMockForKhansyuu.SYORIPTN = KeisanIkkatuWaribikiKikanMockForKhansyuu.TESTPATTERN2;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN6;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;
        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = new KeisanIkkatuNyuukinGkBean();
        KeisanIkkatuNyuukinGkSyouhnBean keisanIkkatuNyuukinGkSyouhnBean = new KeisanIkkatuNyuukinGkSyouhnBean();

        List<KeisanIkkatuNyuukinGkSyouhnBean> pKeisanIkkatuNyuukinGkSyouhnBeanList = new ArrayList<>();

        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnCd("2005");
        keisanIkkatuNyuukinGkSyouhnBean.setSyouhnsdNo(3);
        keisanIkkatuNyuukinGkSyouhnBean.setRyouritusdNo("005");
        keisanIkkatuNyuukinGkSyouhnBean.setHokenryou(BizCurrency.valueOf(100));
        keisanIkkatuNyuukinGkSyouhnBean.setYoteiRiritu(BizNumber.valueOf(1200));
        pKeisanIkkatuNyuukinGkSyouhnBeanList.add(keisanIkkatuNyuukinGkSyouhnBean);
        keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(pKeisanIkkatuNyuukinGkSyouhnBeanList);
        keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(1);
        keisanIkkatuNyuukinGkBean.setRstuukasyu(C_Tuukasyu.AUD);
        keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(C_NyknaiyouKbn.ZENNOUP);
        keisanIkkatuNyuukinGkBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(BizDate.valueOf("20201215"));
        keisanIkkatuNyuukinGkBean.setJyutoustartYm(BizDateYM.valueOf("202012"));

        KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

        C_ErrorKbn errorKbn =  keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean,BizDate.valueOf("20180801"),BizDateYM.valueOf("201805"));
        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exClassificationEquals(keisanTukiIkkatuNyuukinGk.getErrorRiyuuKbn(),
            C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.PARAM_ERROR, "エラー理由");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktnyknkgk(), BizCurrency.valueOf(0), "一括入金額");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exDateEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate(), BizNumber.valueOf(0), "領収為替レート");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokknp(), BizCurrency.valueOf(0), "割引適用期間保険料");
        exBizCalcbleEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngip(),BizCurrency.valueOf(0), "割引適用期間外保険料");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyokkntksu(), 0, "割引適用期間月数");
        exNumericEquals(keisanTukiIkkatuNyuukinGk.getWrbktkyukkngitksu(),1, "割引適用期間外月数");
        List<KeisanTukiIkkatuNyuukinGkUtiwakeBean> keisanIkkatuNyuukinGkUtiwakeBeanList =
            keisanTukiIkkatuNyuukinGk.getKeisanIkkatuNyuukinGkUtiwakeBeanList();
        exNumericEquals(keisanIkkatuNyuukinGkUtiwakeBeanList.size(), 0, "一括入金額計算結果内訳Beanリストの件数");
    }
}