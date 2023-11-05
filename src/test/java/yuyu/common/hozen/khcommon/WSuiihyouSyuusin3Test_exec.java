package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.common.siharai.sicommon.SiCalcKihrkmpstgk;
import yuyu.common.siharai.sicommon.SiCalcKihrkmpstgkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
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
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約返戻金推移表作成（終身３）クラスのメソッド {@link WSuiihyouSyuusin3#exec(WSuiihyouParam)}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WSuiihyouSyuusin3Test_exec {

    @Inject
    private WSuiihyouSyuusin3 WSuiihyouSyuusin3;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_解約返戻金推移表作成（終身３）";

    private final static String sheetName = "INデータ";

    @Inject
    private static Logger logger;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanWItijiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
    }

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForHozen.class);
                bind(SiCalcKihrkmpstgk.class).to(SiCalcKihrkmpstgkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWMockForHozen.caller = WSuiihyouSyuusin3Test_exec.class;
        KeisanZennouSeisanGk2MockForHozen.caller = WSuiihyouSyuusin3Test_exec.class;
        SiCalcKihrkmpstgkMockForHozen.caller = WSuiihyouSyuusin3Test_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.caller = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.caller = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;
    }

    private WSuiihyouParam makeWSuiihyouParam(C_UmuKbn pZennouUmuKbn, BizDate pKykYMD, C_Tuukasyu pTuukasyu) {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        keisanWExtBean.setTuukasyu(pTuukasyu);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(keisanWExtBean.getTuukasyu());
        keisanWExtBean.setSyouhncd("ﾆｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        if(C_Tuukasyu.JPY.eq(pTuukasyu)){
            keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.003));
        }
        else{
            keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.01));
        }
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanWExtBean.setHhknnen(15);
        keisanWExtBean.setDai1hknkkn(5);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkkn(keisanWExtBean.getHhknnen() + keisanWExtBean.getDai1hknkkn());
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(99);
        keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(1000000, currencyType));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(120000, currencyType));
        keisanWExtBean.setKykymd(pKykYMD);
        keisanWExtBean.setKykJyoutai(C_Kykjyoutai.HRKMTYUU);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);

        wSuiihyouParam.setKwsratekjymd(keisanWExtBean.getKykymd());
        wSuiihyouParam.setZennouUmuKbn(pZennouUmuKbn);
        if(C_UmuKbn.ARI.eq(pZennouUmuKbn)){
            keisanWExtBean.setKykJyoutai(C_Kykjyoutai.ZENNOU);
            wSuiihyouParam.setZennouNyuukingk(keisanWExtBean.getHokenryou().multiply(4));
            wSuiihyouParam.setZennoujiHrkP(keisanWExtBean.getHokenryou());
            wSuiihyouParam.setZennouKaisiYmd(keisanWExtBean.getKykymd().addYears(1));
            wSuiihyouParam.setRyosyuYmd(keisanWExtBean.getKykymd());
        }
        wSuiihyouParam.setSdpd(C_Sdpd.SD);
        wSuiihyouParam.setHrkkeiro(C_Hrkkeiro.KOUHURI);

        return wSuiihyouParam;
    }

    @Test
    @TestOrder(10)
    public void testExec_A01() {
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        BizDate kykYmd = BizDate.valueOf(20210510);
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.ARI, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(kykYmd);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A02() {

        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        BizDate kykYmd = BizDate.valueOf(20210510);
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.ARI, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(kykYmd);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。前納精算額計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A03() {

        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = SiCalcKihrkmpstgkMockForHozen.TESTPATTERN2;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        BizDate kykYmd = BizDate.valueOf(20210510);
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.ARI, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(kykYmd);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin3.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。保険金額計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_B01() {
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        BizDate kykYmd = BizDate.valueOf(20210510);
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(tuukasyu);
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.ARI, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(kykYmd);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin3.exec(wSuiihyouParam);
        List<SibouSBean> sibouSBeanLst = WSuiihyouSyuusin3.getSibouSBeanList();

        exNumericEquals(wSuiihyouLst.size(), 91, "推移表レコード件数");
        exNumericEquals(sibouSBeanLst.size(), 6, "死亡ＳBean件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            displayContents(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou, wSuiihyouParam.getZennouUmuKbn());
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "23", "推移表種別");
            exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_Gaika_Keika0(Suiihyou, currencyType);
                    break;
                case 1:
                    checkWSuiihyou_Gaika_Keika1(Suiihyou, currencyType);
                    break;
                case 4:
                    checkWSuiihyou_Gaika_Keika4(Suiihyou, currencyType);
                    break;
                case 5:
                    checkWSuiihyou_Gaika_Keika5(Suiihyou, currencyType);
                    break;
                case 6:
                    checkWSuiihyou_Gaika_Keika6(Suiihyou, currencyType);
                    break;
                case 9:
                    checkWSuiihyou_Gaika_Keika9(Suiihyou, currencyType, wSuiihyouParam.getZennouUmuKbn());
                    break;
                case 90:
                    checkWSuiihyou_Gaika_Keika90(Suiihyou, currencyType, wSuiihyouParam.getZennouUmuKbn());
                    break;
                default:
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanLst.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanLst.get(cnt);
            displayContents(sibouSBean);
            switch (cnt) {
                case 0:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20220509), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(126216, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(480720, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(606936, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(68832611, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(74901971, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(80971331, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                case 1:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20230509), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(252432, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(361261.08, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(613693.08, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(69598932, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(75735863, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(81872793, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                case 2:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20240509), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(378648, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(241622.97, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(620270.97, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(70344930, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(76547640, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(82750350, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                case 3:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250509), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(504864, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(121805.4, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(626669.4, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(71070576, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(77337270, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(83603964, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                case 4:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20260509), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(631080, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(1808.1, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(632888.1, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(71775839, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(78104720, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(84433601, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                case 5:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20260510), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(1000000, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(0, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(1000000, currencyType), "死亡時受取額");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(113410000, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円高）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(123410000, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（中央値）");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(133410000, BizCurrencyTypes.YEN), "死亡時受取額（円貨）（円安）");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(120)
    public void testExec_B02() {
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        BizDate kykYmd = BizDate.valueOf(20210510);
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(tuukasyu);
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.NONE, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20291201));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin3.exec(wSuiihyouParam);
        List<SibouSBean> sibouSBeanLst = WSuiihyouSyuusin3.getSibouSBeanList();

        exNumericEquals(wSuiihyouLst.size(), 82, "推移表レコード件数");
        exNumericEquals(sibouSBeanLst.size(), 0, "死亡ＳBean件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            displayContents(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_KawaseRate(Suiihyou, wSuiihyouParam.getZennouUmuKbn());
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "22", "推移表種別");
            exBizCalcbleEquals(Suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(Suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(0), "既払込保険料（円貨）１");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_Gaika_Keika9(Suiihyou, currencyType, wSuiihyouParam.getZennouUmuKbn());
                    break;
                case 81:
                    checkWSuiihyou_Gaika_Keika90(Suiihyou, currencyType, wSuiihyouParam.getZennouUmuKbn());
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(130)
    public void testExec_B03() {
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        BizDate kykYmd = BizDate.valueOf(20200229);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(tuukasyu);
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.ARI, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20200302));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20210510));

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;

        WSuiihyouSyuusin3.setYenkansannYhKbn(yenYouhiKbn);
        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin3.exec(wSuiihyouParam);
        List<SibouSBean> sibouSBeanLst = WSuiihyouSyuusin3.getSibouSBeanList();

        exNumericEquals(wSuiihyouLst.size(), 91, "推移表レコード件数");
        exNumericEquals(sibouSBeanLst.size(), 6, "死亡ＳBean件数");
        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            displayContents(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_YenNone(Suiihyou);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "21", "推移表種別");
            exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0), "前納残高１");
            exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_Yen_Keika0(Suiihyou, true);
                    break;
                case 1:
                    checkWSuiihyou_Yen_Keika1(Suiihyou, true);
                    break;
                case 4:
                    checkWSuiihyou_Yen_Keika4(Suiihyou, true);
                    break;
                case 5:
                    checkWSuiihyou_Yen_Keika5(Suiihyou);
                    break;
                case 6:
                    checkWSuiihyou_Yen_Keika6(Suiihyou);
                    break;
                case 55:
                    checkWSuiihyou_Yen_Keika55(Suiihyou);
                    break;
                case 90:
                    checkWSuiihyou_Yen_Keika90(Suiihyou);
                    break;
                default:
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanLst.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanLst.get(cnt);
            displayContents(sibouSBean);
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円高）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（中央値）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円安）");
            switch (cnt) {
                case 0:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20210227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(193200, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(480288, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(673488, currencyType), "死亡時受取額");
                    break;
                case 1:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20220227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(386400, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(360504, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(746904, currencyType), "死亡時受取額");
                    break;
                case 2:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20230227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(579600, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(240648, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(820248, currencyType), "死亡時受取額");
                    break;
                case 3:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20240228), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(772800, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(120720, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(893520, currencyType), "死亡時受取額");
                    break;
                case 4:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(966000, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(720, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(966720, currencyType), "死亡時受取額");
                    break;
                case 5:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250301), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(1000000, currencyType), "死亡保険金額");
                    exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(0, currencyType), "前納残高");
                    exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), BizCurrency.valueOf(1000000, currencyType), "死亡時受取額");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(140)
    public void testExec_B04() {
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        SiCalcKihrkmpstgkMockForHozen.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        BizDate kykYmd = BizDate.valueOf(20200229);
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(tuukasyu);
        wSuiihyouParam = makeWSuiihyouParam(C_UmuKbn.NONE, kykYmd, tuukasyu);
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20210228));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20210510));

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;

        WSuiihyouSyuusin3.setYenkansannYhKbn(yenYouhiKbn);
        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin3.exec(wSuiihyouParam);
        List<SibouSBean> sibouSBeanLst = WSuiihyouSyuusin3.getSibouSBeanList();

        exNumericEquals(wSuiihyouLst.size(), 90, "推移表レコード件数");
        exNumericEquals(sibouSBeanLst.size(), 6, "死亡ＳBean件数");
        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            displayContents(Suiihyou);
            checkWSuiihyouOther_Default(Suiihyou);
            checkWSuiihyou1_YenNone(Suiihyou);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "20", "推移表種別");
            exBizCalcbleEquals(Suiihyou.getZennouzndk1(), BizCurrency.valueOf(0), "前納残高１");
            exBizCalcbleEquals(Suiihyou.getKihrkmp1(), BizCurrency.valueOf(0), "既払込保険料１");
            switch (cnt) {
                case 0:
                    checkWSuiihyou_Yen_Keika1(Suiihyou, false);
                    break;
                case 3:
                    checkWSuiihyou_Yen_Keika4(Suiihyou, false);
                    break;
                case 4:
                    checkWSuiihyou_Yen_Keika5(Suiihyou);
                    break;
                case 5:
                    checkWSuiihyou_Yen_Keika6(Suiihyou);
                    break;
                case 54:
                    checkWSuiihyou_Yen_Keika55(Suiihyou);
                    break;
                case 89:
                    checkWSuiihyou_Yen_Keika90(Suiihyou);
                    break;
                default:
                    break;
            }
        }
        for (int cnt = 0; cnt < sibouSBeanLst.size(); cnt++){
            SibouSBean sibouSBean = sibouSBeanLst.get(cnt);
            displayContents(sibouSBean);
            exBizCalcbleEquals(sibouSBean.getZennouZndk(), BizCurrency.valueOf(0, BizCurrencyTypes.YEN), "前納残高");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgk(), sibouSBean.getSibouS(), "死亡時受取額");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYendaka(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円高）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYen(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（中央値）");
            exBizCalcbleEquals(sibouSBean.getSibouUktrgkYenyasu(), BizCurrency.valueOf(0), "死亡時受取額（円貨）（円安）");
            switch (cnt) {
                case 0:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20210227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(193200, currencyType), "死亡保険金額");
                    break;
                case 1:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20220227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(386400, currencyType), "死亡保険金額");
                    break;
                case 2:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20230227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(579600, currencyType), "死亡保険金額");
                    break;
                case 3:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20240228), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(772800, currencyType), "死亡保険金額");
                    break;
                case 4:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250227), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(966000, currencyType), "死亡保険金額");
                    break;
                case 5:
                    exDateEquals(sibouSBean.getCalcKijyunYmd(), BizDate.valueOf(20250301), "計算基準日");
                    exBizCalcbleEquals(sibouSBean.getSibouS(), BizCurrency.valueOf(1000000, currencyType), "死亡保険金額");
                    break;
                default:
                    break;
            }
        }
    }


    private void checkWSuiihyouOther_Default(IT_Suiihyou suiihyou){
        exStringEquals(suiihyou.getKbnkey(), null, "区分キー");
        exStringEquals(suiihyou.getSyono(), null, "証券番号");
        exDateEquals(suiihyou.getTyouhyouymd(), null, "帳票作成日");
        exClassificationEquals(suiihyou.getKyktuukasyu(), C_Tuukasyu.BLNK , "契約通貨種類");

        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.ZERO, "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.ZERO, "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.ZERO, "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(0), "予定利率計算基準利率１");
        checkWSuiihyou2_Default(suiihyou);
        checkWSuiihyou3_Default(suiihyou);
    }

    private void checkWSuiihyou2_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.ZERO, "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.ZERO, "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.ZERO, "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
    }

    private void checkWSuiihyou3_Default(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
    }

    private void checkWSuiihyou1_YenNone(IT_Suiihyou suiihyou){
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(0), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(0), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou1_KawaseRate(IT_Suiihyou suiihyou, C_UmuKbn zennouUmuKbn){
        if (C_UmuKbn.ARI.eq(zennouUmuKbn)){
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(113.41), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(123.41), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(133.41), "円換算適用為替レート（円安）");
        }else{
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(113.42), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(123.42), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(133.42), "円換算適用為替レート（円安）");
        }
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika0(IT_Suiihyou suiihyou, CurrencyType pCurrencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20220509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202205), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(120000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(480720, pCurrencyType), "前納残高１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(83500, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(564220, pCurrencyType), "解約時受取額");

        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(9469735), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(10304735), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(11139735), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(63988190), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(69630390), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(75272590), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika1(IT_Suiihyou suiihyou, CurrencyType pCurrencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20230509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202305), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(240000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(361261.08, pCurrencyType), "前納残高１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(173200, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(534461.08, pCurrencyType), "解約時受取額");

        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(19642612), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(21374612), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(23106612), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(60613231), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(65957841), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(71302452), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika4(IT_Suiihyou suiihyou, CurrencyType pCurrencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 4, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20260509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202605), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(600000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(1808.1, pCurrencyType), "前納残高１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(443000, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(444808.1, pCurrencyType), "解約時受取額");

        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(50240630), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(54670630), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(59100630), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), BizCurrency.valueOf(50445686), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), BizCurrency.valueOf(54893767), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), BizCurrency.valueOf(59341848), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika5(IT_Suiihyou suiihyou, CurrencyType pCurrencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 5, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20260510), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202605), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(600000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, pCurrencyType), "前納残高１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(632900, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");

        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(71777189), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(78106189), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(84435189), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika6(IT_Suiihyou suiihyou, CurrencyType pCurrencyType){
        exNumericEquals(suiihyou.getKeikanensuu(), 6, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20270509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202705), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(600000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, pCurrencyType), "前納残高１");

        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(637200, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(72264852), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(78636852), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(85008852), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");

        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika9(IT_Suiihyou suiihyou, CurrencyType pCurrencyType, C_UmuKbn zennouUmuKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 9, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20300509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(203005), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(600000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, pCurrencyType), "前納残高１");

        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(650200, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        if (C_UmuKbn.ARI.eq(zennouUmuKbn)){
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(73739182), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(80241182), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(86743182), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }else{
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(73745684), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(80247684), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(86749684), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Gaika_Keika90(IT_Suiihyou suiihyou, CurrencyType pCurrencyType, C_UmuKbn zennouUmuKbn){
        exNumericEquals(suiihyou.getKeikanensuu(), 90, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(21110509), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(211105), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(600000, pCurrencyType), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getZennouzndk1(), BizCurrency.valueOf(0, pCurrencyType), "前納残高１");

        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(989400, pCurrencyType), "ＭＶＡ適用外解約返戻金額");
        if (C_UmuKbn.ARI.eq(zennouUmuKbn)){
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(112207854), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(122101854), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(131995854), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }else{
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(112217748), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(122111748), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(132005748), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyendaka(), suiihyou.getMvanonewyensameyendaka(), "解約時受取額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenkijyun(), suiihyou.getMvanonewyensameyenkijyun(), "解約時受取額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgkyenyasu(), suiihyou.getMvanonewyensameyenyasu(), "解約時受取額（円貨）（円安）");
    }

    private void checkWSuiihyou_Yen_Keika0(IT_Suiihyou suiihyou, boolean zennnou){
        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20210227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202102), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(120000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(131600), "ＭＶＡ適用外解約返戻金額");
        if(zennnou){
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(480288), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(611888), "解約時受取額");
        }else{
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        }
    }

    private void checkWSuiihyou_Yen_Keika1(IT_Suiihyou suiihyou, boolean zennnou){
        exNumericEquals(suiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20220227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202202), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(240000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(267900), "ＭＶＡ適用外解約返戻金額");
        if(zennnou){
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(360504), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(628404), "解約時受取額");
        }else{
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        }
    }

    private void checkWSuiihyou_Yen_Keika4(IT_Suiihyou suiihyou,boolean zennnou){
        exNumericEquals(suiihyou.getKeikanensuu(), 4, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20250227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202502), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(676900), "ＭＶＡ適用外解約返戻金額");
        if(zennnou){
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(720), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), BizCurrency.valueOf(677620), "解約時受取額");
        }else{
            exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
            exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
        }
    }

    private void checkWSuiihyou_Yen_Keika5(IT_Suiihyou suiihyou){
        exNumericEquals(suiihyou.getKeikanensuu(), 5, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20250301), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202502), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(967000), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
    }

    private void checkWSuiihyou_Yen_Keika6(IT_Suiihyou suiihyou){
        exNumericEquals(suiihyou.getKeikanensuu(), 6, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20260227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202602), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(967500), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
    }

    private void checkWSuiihyou_Yen_Keika55(IT_Suiihyou suiihyou){
        exNumericEquals(suiihyou.getKeikanensuu(), 55, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20750227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(207502), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(990100), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
    }

    private void checkWSuiihyou_Yen_Keika90(IT_Suiihyou suiihyou){
        exNumericEquals(suiihyou.getKeikanensuu(), 90, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(21100227), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(211002), "計算年日");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(600000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(999200), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getKaiyakujuktrgk(), suiihyou.getMvanonewsame(), "解約時受取額");
    }

    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算年月 = {}", pSuiihyou.getCalcym());
        //        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        //        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        //        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        //        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        //        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        //        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        //        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        //        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        //        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        //        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        //        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        //        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        //        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        //        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        //        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        //        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        //        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        //        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        //        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        //        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        //        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        //        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        //        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        //        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        //        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        //        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        //        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        //        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        //        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        //        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        //        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        //        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        //        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        //        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        //        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        //        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        //        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        //        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        //        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        //        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        //        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        //        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        //        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        //        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        //        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        //        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        //        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        //        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        //        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        //        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        //        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        //        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        //        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        //        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        //        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        //        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        //        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        //        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        //        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("│ ★①：前納残高１ = {}", pSuiihyou.getZennouzndk1());
        logger.debug("│ ★①：解約時受取額 = {}", pSuiihyou.getKaiyakujuktrgk());
        logger.debug("│ ★①：解約時受取額（円貨）（円高） = {}", pSuiihyou.getKaiyakujuktrgkyendaka());
        logger.debug("│ ★①：解約時受取額（円貨）（中央値） = {}", pSuiihyou.getKaiyakujuktrgkyenkijyun());
        logger.debug("│ ★①：解約時受取額（円貨）（円安） = {}", pSuiihyou.getKaiyakujuktrgkyenyasu());
        logger.debug("▲ 推移表TBLの設定値");
    }

    private void displayContents(SibouSBean pSibouSBean) {
        logger.debug("▼ 死亡ＳBeanの設定値");
        logger.debug("│ ★計算基準日 = {}", pSibouSBean.getCalcKijyunYmd());
        logger.debug("│ ★死亡保険金額 = {}", pSibouSBean.getSibouS());
        logger.debug("│ ★前納残高 = {}", pSibouSBean.getZennouZndk());
        logger.debug("│ ★死亡時受取額 = {}", pSibouSBean.getSibouUktrgk());
        logger.debug("│ ★死亡時受取額（円貨）（円高） = {}", pSibouSBean.getSibouUktrgkYendaka());
        logger.debug("│ ★死亡時受取額（円貨）（中央値） = {}", pSibouSBean.getSibouUktrgkYen());
        logger.debug("│ ★死亡時受取額（円貨）（円安） = {}", pSibouSBean.getSibouUktrgkYenyasu());
        logger.debug("▲ 死亡ＳBeanの設定値");
    }
}
