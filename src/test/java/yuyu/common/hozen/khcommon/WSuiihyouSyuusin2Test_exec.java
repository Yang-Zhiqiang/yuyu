package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

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

import com.google.inject.AbstractModule;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 解約返戻金推移表作成（終身２）クラスのメソッド {@link WSuiihyouSyuusin2#exec(String, int, String, BizNumber,
 * C_Hrkkaisuu, C_HknkknsmnKbn, int, int, int, C_Hhknsei, BizCurrency, BizDate, BizDate, String, C_Tuukasyu, BizDateYM)}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WSuiihyouSyuusin2Test_exec {

    @Inject
    private WSuiihyouSyuusin2 WSuiihyouSyuusin2;

    @Inject
    private static Logger logger;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanW.class).to(KeisanWMock.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWMock.caller = WSuiihyouSyuusin2Test_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanWMock.caller = null;
        KeisanWMock.SYORIPTN = null;
    }

    private WSuiihyouParam makeWSuiihyouParam() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        keisanWExtBean.setTuukasyu(C_Tuukasyu.USD);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(keisanWExtBean.getTuukasyu());
        keisanWExtBean.setSyouhncd("ﾕﾋ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        keisanWExtBean.setYoteiriritu(BizNumber.valueOf(0.035));
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(99);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(30);
        keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(23943, currencyType));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(10000, currencyType));
        keisanWExtBean.setKykymd(BizDate.valueOf(20191216));
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.valueOf(0.0336));
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.valueOf(0.0336));
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.0275));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20191216));

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20191216));
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.ARI);
        wSuiihyouParam.setMvaTekiKkn(15);

        return wSuiihyouParam;
    }

    private WSuiihyouParam makeWSuiihyouParamForYen() {

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(keisanWExtBean.getTuukasyu());
        keisanWExtBean.setSyouhncd("ﾕF");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("L");
        keisanWExtBean.setYoteiriritu(BizNumber.ZERO);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHknkkn(99);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.BLNK);
        keisanWExtBean.setHrkkkn(0);
        keisanWExtBean.setHhknnen(30);
        keisanWExtBean.setHhknsei(C_Hhknsei.FEMALE);
        keisanWExtBean.setKihons(BizCurrency.valueOf(1000000, currencyType));
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(0, currencyType));
        keisanWExtBean.setKykymd(BizDate.valueOf(20191216));
        keisanWExtBean.setKyksjkkktyouseiriritu(BizNumber.ZERO);
        keisanWExtBean.setKaiyakusjkkktyouseiriritu(BizNumber.ZERO);
        keisanWExtBean.setTumitateriritu(BizNumber.valueOf(0.01));
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20191216));
        keisanWExtBean.setYendthnkymd(BizDate.valueOf(20201217));

        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20191216));
        wSuiihyouParam.setMvaTekiUmu(C_UmuKbn.NONE);
        wSuiihyouParam.setMvaTekiKkn(0);

        return wSuiihyouParam;
    }

    @Test
    @TestOrder(10)
    public void testExec_A01() {

        KeisanWMock.SYORIPTN = KeisanWMock.TESTPATTERN4;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20191216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin2.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testExec_A02() {

        KeisanWMock.SYORIPTN = KeisanWMock.TESTPATTERN5;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20191216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin2.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A03() {

        KeisanWMock.SYORIPTN = KeisanWMock.TESTPATTERN6;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);
        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20191216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        try {
            WSuiihyouSyuusin2.exec(wSuiihyouParam);

        } catch (Exception e) {

            exStringEquals(e.getMessage(),   "システム整合性エラーです。解約返戻金計算が実行できませんでした。" , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(110)
    public void testExec_B01() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20941216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 0, "推移表レコード件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_B02() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20191216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;
        WSuiihyouSyuusin2.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 76, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "10", "推移表種別");
            switch (cnt) {
                case 0:
                    check_keika0(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    check_keika1(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 2:
                    check_keika2(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 14:
                    check_keika14(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 15:
                    check_keika15(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }


    @Test
    @TestOrder(130)
    public void testExec_B03() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 74, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "01", "推移表種別");
            switch (cnt) {
                case 0:
                    check_keika2(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 12:
                    check_keika14(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 13:
                    check_keika15(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }


    @Test
    @TestOrder(140)
    public void testExec_B04() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20331216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.YOU;
        WSuiihyouSyuusin2.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 61, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "01", "推移表種別");
            switch (cnt) {
                case 0:
                    check_keika15(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(150)
    public void testExec_B05() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20191216));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType =henkanTuuka.henkanTuukaKbnToType(wSuiihyouParam.getKeisanWExtBean().getTuukasyu());

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;
        WSuiihyouSyuusin2.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 76, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "10", "推移表種別");
            switch (cnt) {
                case 0:
                    check_keika0(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 1:
                    check_keika1(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 2:
                    check_keika2(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 14:
                    check_keika14(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                case 15:
                    check_keika15(Suiihyou, currencyType, yenYouhiKbn);
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(160)
    public void testExec_B06() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();

        wSuiihyouParam.getKeisanWExtBean().setKykymd(BizDate.valueOf(20200229));
        wSuiihyouParam.getKeisanWExtBean().setFstpryosyuymd(BizDate.valueOf(20200229));

        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20200229));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20200229));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 76, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "10", "推移表種別");
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 0, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20200229"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202002"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20210301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202102"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20220301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202202"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 3, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20230301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202302"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 4:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20240301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202402"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 14:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 14, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20340301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203402"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 15:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 15, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20350301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203502"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                case 16:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 16, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20360301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203602"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                case 17:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 17, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20370301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203702"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(170)
    public void testExec_B07() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParam();

        wSuiihyouParam.getKeisanWExtBean().setKykymd(BizDate.valueOf(20200229));
        wSuiihyouParam.getKeisanWExtBean().setFstpryosyuymd(BizDate.valueOf(20200229));

        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20200520));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20200229));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 75, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "01", "推移表種別");
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 1, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20210301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202102"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20220301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202202"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 2:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 3, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20230301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202302"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 3:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 4, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20240301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202402"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 13:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 14, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20340301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203402"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");
                    break;
                case 14:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 15, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20350301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203502"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                case 15:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 16, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20360301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203602"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                case 16:
                    exNumericEquals(Suiihyou.getKeikanensuu(), 17, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20370301"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203702"), "計算基準年月");
                    exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
                    break;
                default:
                    break;
            }
        }
    }

    @Test
    @TestOrder(180)
    public void testExec_B08() {

        MockObjectManager.initialize();
        KeisanWMock.SYORIPTN = null;

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        wSuiihyouParam = makeWSuiihyouParamForYen();

        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20201217));
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        CurrencyType currencyType = BizCurrencyTypes.YEN;

        C_YouhiKbn yenYouhiKbn = C_YouhiKbn.HUYOU;
        WSuiihyouSyuusin2.setYenkansannYhKbn(yenYouhiKbn);

        List<IT_Suiihyou> wSuiihyouLst = WSuiihyouSyuusin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 74, "推移表レコード件数");

        for (int cnt = 0; cnt < wSuiihyouLst.size(); cnt++){
            IT_Suiihyou Suiihyou = wSuiihyouLst.get(cnt);

            BizCurrency wkTumitatekin = BizCurrency.valueOf(0, currencyType);
            displayContents(Suiihyou);
            exStringEquals(Suiihyou.getSuiihyousyubetu(), "04", "推移表種別");
            exClassificationEquals(Suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");
            check_mvanone(Suiihyou);
            check_common(Suiihyou, C_YouhiKbn.HUYOU);
            switch (cnt) {
                case 0:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20211216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202112"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1010000, currencyType);
                    break;
                case 1:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20221216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("202212"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1020100, currencyType);
                    break;
                case 12:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20331216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("203312"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1138100, currencyType);
                    break;
                case 23:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20441216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("204412"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1269747, currencyType);
                    break;
                case 34:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20551216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("205512"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1416623, currencyType);
                    break;
                case 45:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20661216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("206612"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1580487, currencyType);
                    break;
                case 56:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20771216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("207712"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1763304, currencyType);
                    break;
                case 67:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20881216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("208812"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(1967270, currencyType);
                    break;
                case 70:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20911216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("209112"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(2026882, currencyType);
                    break;
                case 73:
                    exNumericEquals(Suiihyou.getKeikanensuu(), cnt+2, "経過年数");
                    exDateEquals(Suiihyou.getCalckijyunymd(), BizDate.valueOf("20941216"), "計算基準日");
                    exDateYMEquals(Suiihyou.getCalcym(), BizDateYM.valueOf("209412"), "計算基準年月");
                    wkTumitatekin = BizCurrency.valueOf(2088300, currencyType);
                    break;
                default:
                    continue;
            }
            exBizCalcbleEquals(Suiihyou.getMvanonewsame(), wkTumitatekin, "ＭＶＡ適用外解約返戻金額");
            exBizCalcbleEquals(Suiihyou.getMvanoneptumitatekin(), wkTumitatekin, "ＭＶＡ適用外保険料積立金");
            exBizCalcbleEquals(Suiihyou.getMvanonewyensameyendaka(), wkTumitatekin, " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenkijyun(), wkTumitatekin, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(Suiihyou.getMvanonewyensameyenyasu(), wkTumitatekin, "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }
    }

    private void check_common(IT_Suiihyou pSuiihyou, C_YouhiKbn pYenkansannYhKbn ) {
        exClassificationEquals(pSuiihyou.getKyktuukasyu(), null , "契約通貨種類");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(113.41), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(123.41), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(133.41), "円換算適用為替レート（円安）");
        }else{
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
            exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        }
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), " 円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");

        exBizCalcbleEquals(pSuiihyou.getMkhyouyensysnikougk(), null, "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu1(), null, "積立金増加率１");
        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu2(), null, "積立金増加率２");
        exBizCalcbleEquals(pSuiihyou.getTmttknzoukaritu3(), null, "積立金増加率３");

        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup2(), null, "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame2(), null, "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown2(), null, "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup2(), null, "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown2(), null, "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka2(), null, "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun2(), null, "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu2(), null, "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka2(), null, "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu2(), null, "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwup2(), null, "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame2(), null, "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown2(), null, "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka2(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun2(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu2(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka2(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun2(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu2(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka2(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun2(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu2(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin2(), null, "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(pSuiihyou.getMvanonewsame2(), null, "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka2(), null, "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun2(), null, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu2(), null, "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin2(), null, "ＭＶＡ適用外保険料積立金２");

        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup3(), null, "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame3(), null, "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown3(), null, "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup3(), null, "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown3(), null, "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyendaka3(), null, "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenkijyun3(), null, "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrateyenyasu3(), null, "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyendaka3(), null, "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(pSuiihyou.getYenknsnkwsrategkyenyasu3(), null, "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwup3(), null, "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame3(), null, "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown3(), null, "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka3(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun3(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu3(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka3(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun3(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu3(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka3(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun3(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu3(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin3(), null, "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(pSuiihyou.getMvanonewsame3(), null, "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka3(), null, "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun3(), null, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu3(), null, "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin3(), null, "ＭＶＡ適用外保険料積立金３");

        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake11(), null, "積立金内訳（１）１");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake21(), null, "積立金内訳（２）１");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake12(), null, "積立金内訳（１）２");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake22(), null, "積立金内訳（２）２");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake13(), null, "積立金内訳（１）３");
        exBizCalcbleEquals(pSuiihyou.getTutmttknutiwake23(), null, "積立金内訳（２）３");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu1(), null, "指数上昇率１");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu2(), null, "指数上昇率２");
        exBizCalcbleEquals(pSuiihyou.getSisuuupritu3(), null, "指数上昇率３");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup1(), null, "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame1(), null, "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown1(), null, "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup2(), null, "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaeup3(), null, "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame2(), null, "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaesame3(), null, "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown2(), null, "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(pSuiihyou.getMvaaritmttkgkkykkjmaedown3(), null, "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exClassificationEquals(pSuiihyou.getHrkkknmnryumukbn(), null, "払込期間満了有無区分");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt1(), null, "予定利率計算基準利率１");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt2(), null, "予定利率計算基準利率２");
        exBizCalcbleEquals(pSuiihyou.getYtirrtcalckijyunrrt3(), null, "予定利率計算基準利率３");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen1(), null, "前納残高（円貨）１");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen2(), null, "前納残高（円貨）２");
        exBizCalcbleEquals(pSuiihyou.getZennouzndkyen3(), null, "前納残高（円貨）３");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen1(), null, "既払込保険料（円貨）１");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen2(), null, "既払込保険料（円貨）２");
        exBizCalcbleEquals(pSuiihyou.getKihrkmpyen3(), null, "既払込保険料（円貨）３");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp1(), null, "既払込保険料１");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp2(), null, "既払込保険料２");
        exBizCalcbleEquals(pSuiihyou.getKihrkmp3(), null, "既払込保険料３");

    }

    private void check_mvaari(IT_Suiihyou pSuiihyou) {
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0.0336), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0.0436), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0.0236), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0.01), "市場価格調整用利率変動幅（下）");

        exBizCalcbleEquals(pSuiihyou.getMvanonewsame(), null, "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka(), null, " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun(), null, "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu(), null, "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin(), null, "ＭＶＡ適用外保険料積立金");
    }

    private void check_mvanone(IT_Suiihyou pSuiihyou) {
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtsame(), null, "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtup(), null, "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrtdown(), null, "市場価格調整用利率（低下）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendoudown(), null, "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(pSuiihyou.getSjkkktusirrthendouup(), null, "市場価格調整用利率変動幅（下）");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), null, "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), null, "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), null, "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), null, "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), null, "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), null, "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), null, "ＭＶＡ適用保険料積立金");
    }

    private void check_keika0(IT_Suiihyou pSuiihyou, CurrencyType currencyType, C_YouhiKbn pYenkansannYhKbn) {
        exNumericEquals(pSuiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(pSuiihyou.getCalckijyunymd(), BizDate.valueOf("20191216"), "計算基準日");
        exDateYMEquals(pSuiihyou.getCalcym(), BizDateYM.valueOf("201912"), "計算基準年月");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), BizCurrency.valueOf(9214.19, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(10000.00, currencyType), "ＭＶＡ適用保険料積立金");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(1137124), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            check_mvaari_yenhuyo(pSuiihyou);
        }
        check_common(pSuiihyou, pYenkansannYhKbn);
        check_mvaari(pSuiihyou);
    }

    private void check_keika1(IT_Suiihyou pSuiihyou, CurrencyType currencyType, C_YouhiKbn pYenkansannYhKbn) {
        exNumericEquals(pSuiihyou.getKeikanensuu(), 1, "経過年数");
        exDateEquals(pSuiihyou.getCalckijyunymd(), BizDate.valueOf("20201216"), "計算基準日");
        exDateYMEquals(pSuiihyou.getCalcym(), BizDateYM.valueOf("202012"), "計算基準年月");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), BizCurrency.valueOf(4174.03, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), BizCurrency.valueOf(4839.94, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), BizCurrency.valueOf(5609.64, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(5435.06, currencyType), "ＭＶＡ適用保険料積立金");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(473377), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(515118), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(556858), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(548898), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(597297), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(645697), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(636190), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(692286), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(748383), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            check_mvaari_yenhuyo(pSuiihyou);
        }
        check_common(pSuiihyou, pYenkansannYhKbn);
        check_mvaari(pSuiihyou);
    }

    private void check_keika2(IT_Suiihyou pSuiihyou, CurrencyType currencyType, C_YouhiKbn pYenkansannYhKbn) {
        exNumericEquals(pSuiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(pSuiihyou.getCalckijyunymd(), BizDate.valueOf("20211216"), "計算基準日");
        exDateYMEquals(pSuiihyou.getCalcym(), BizDateYM.valueOf("202112"), "計算基準年月");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), BizCurrency.valueOf(4384.87, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), BizCurrency.valueOf(5021.58, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), BizCurrency.valueOf(5750.47, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(5559.56, currencyType), "ＭＶＡ適用保険料積立金");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(497289), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(541137), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(584986), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(569498), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(619714), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(669929), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(652161), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(709666), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(767171), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            check_mvaari_yenhuyo(pSuiihyou);
        }
        check_common(pSuiihyou, pYenkansannYhKbn);
        check_mvaari(pSuiihyou);
    }

    private void check_keika14(IT_Suiihyou pSuiihyou, CurrencyType currencyType, C_YouhiKbn pYenkansannYhKbn) {
        exNumericEquals(pSuiihyou.getKeikanensuu(), 14, "経過年数");
        exDateEquals(pSuiihyou.getCalckijyunymd(), BizDate.valueOf("20331216"), "計算基準日");
        exDateYMEquals(pSuiihyou.getCalcym(), BizDateYM.valueOf("203312"), "計算基準年月");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用状態区分");

        exBizCalcbleEquals(pSuiihyou.getMvaariwup(), BizCurrency.valueOf(7322.94, currencyType), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwsame(), BizCurrency.valueOf(7393.65, currencyType), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwdown(), BizCurrency.valueOf(7465.74, currencyType), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(pSuiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(7407.96, currencyType), "ＭＶＡ適用保険料積立金");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(830495), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(903725), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(976954), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(838514), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(912451), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(986387), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(846690), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(921347), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(996005), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        }else{
            check_mvaari_yenhuyo(pSuiihyou);
        }
        check_common(pSuiihyou, pYenkansannYhKbn);
        check_mvaari(pSuiihyou);
    }

    private void check_keika15(IT_Suiihyou pSuiihyou, CurrencyType currencyType, C_YouhiKbn pYenkansannYhKbn) {
        exNumericEquals(pSuiihyou.getKeikanensuu(), 15, "経過年数");
        exDateEquals(pSuiihyou.getCalckijyunymd(), BizDate.valueOf("20341216"), "計算基準日");
        exDateYMEquals(pSuiihyou.getCalcym(), BizDateYM.valueOf("203412"), "計算基準年月");
        exClassificationEquals(pSuiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用状態区分");

        exBizCalcbleEquals(pSuiihyou.getMvanonewsame(), BizCurrency.valueOf(7599.50, currencyType), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(pSuiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(7599.50, currencyType), "ＭＶＡ適用外保険料積立金");

        if(C_YouhiKbn.YOU.eq(pYenkansannYhKbn)){
            exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(861860), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
            exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(937855), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
            exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(1013850), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        }else{
            check_mvanone_yenhuyo(pSuiihyou);
        }
        check_common(pSuiihyou, pYenkansannYhKbn);
        check_mvanone(pSuiihyou);
    }

    private void check_mvaari_yenhuyo(IT_Suiihyou pSuiihyou) {
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
    }

    private void check_mvanone_yenhuyo(IT_Suiihyou pSuiihyou) {
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(0), " ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(pSuiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
    }

    private void displayContents(IT_Suiihyou pSuiihyou) {
        logger.debug("▼ 推移表TBLの設定値");
        logger.debug("│ ★共通：経過年数 = {}", pSuiihyou.getKeikanensuu());
        logger.debug("│ ★共通：計算基準日 = {}", pSuiihyou.getCalckijyunymd());
        logger.debug("│ ★共通：計算基準年月 = {}", pSuiihyou.getCalcym());
        logger.debug("│ ★共通：ＭＶＡ適用状態区分 = {}", pSuiihyou.getMvatekijyoutaikbn());
        logger.debug("│ ★共通：契約通貨種類 = {}", pSuiihyou.getKyktuukasyu());
        logger.debug("│ ★共通：推移表種別 = {}", pSuiihyou.getSuiihyousyubetu());
        logger.debug("│ ★共通：払込期間満了有無区分 = {}", pSuiihyou.getHrkkknmnryumukbn());
        logger.debug("│ ★①：市場価格調整用利率（上昇） = {}", pSuiihyou.getSjkkktusirrtup());
        logger.debug("│ ★①：市場価格調整用利率（同水準） = {}", pSuiihyou.getSjkkktusirrtsame());
        logger.debug("│ ★①：市場価格調整用利率（低下） = {}", pSuiihyou.getSjkkktusirrtdown());
        logger.debug("│ ★①：市場価格調整用利率変動幅（上） = {}", pSuiihyou.getSjkkktusirrthendouup());
        logger.debug("│ ★①：市場価格調整用利率変動幅（下） = {}", pSuiihyou.getSjkkktusirrthendoudown());
        logger.debug("│ ★②：市場価格調整用利率（上昇）２ = {}", pSuiihyou.getSjkkktusirrtup2());
        logger.debug("│ ★②：市場価格調整用利率（同水準）２ = {}", pSuiihyou.getSjkkktusirrtsame2());
        logger.debug("│ ★②：市場価格調整用利率（低下）２ = {}", pSuiihyou.getSjkkktusirrtdown2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（上）２ = {}", pSuiihyou.getSjkkktusirrthendouup2());
        logger.debug("│ ★②：市場価格調整用利率変動幅（下）２ = {}", pSuiihyou.getSjkkktusirrthendoudown2());
        logger.debug("│ ★③：市場価格調整用利率（上昇）３ = {}", pSuiihyou.getSjkkktusirrtup3());
        logger.debug("│ ★③：市場価格調整用利率（同水準）３ = {}", pSuiihyou.getSjkkktusirrtsame3());
        logger.debug("│ ★③：市場価格調整用利率（低下）３ = {}", pSuiihyou.getSjkkktusirrtdown3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（上）３ = {}", pSuiihyou.getSjkkktusirrthendouup3());
        logger.debug("│ ★③：市場価格調整用利率変動幅（下）３ = {}", pSuiihyou.getSjkkktusirrthendoudown3());
        logger.debug("│ ★①：円換算適用為替レート（円高） = {}", pSuiihyou.getYenknsnkwsrateyendaka());
        logger.debug("│ ★①：円換算適用為替レート（中央値） = {}", pSuiihyou.getYenknsnkwsrateyenkijyun());
        logger.debug("│ ★①：円換算適用為替レート（円安） = {}", pSuiihyou.getYenknsnkwsrateyenyasu());
        logger.debug("│ ★①：円換算適用為替レート変動額（円高） = {}", pSuiihyou.getYenknsnkwsrategkyendaka());
        logger.debug("│ ★①：円換算適用為替レート変動額（円安） = {}", pSuiihyou.getYenknsnkwsrategkyenyasu());
        logger.debug("│ ★②：円換算適用為替レート（円高）２ = {}", pSuiihyou.getYenknsnkwsrateyendaka2());
        logger.debug("│ ★②：円換算適用為替レート（中央値）２ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun2());
        logger.debug("│ ★②：円換算適用為替レート（円安）２ = {}", pSuiihyou.getYenknsnkwsrateyenyasu2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円高）２ = {}", pSuiihyou.getYenknsnkwsrategkyendaka2());
        logger.debug("│ ★②：円換算適用為替レート変動額（円安）２ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu2());
        logger.debug("│ ★③：円換算適用為替レート（円高）３ = {}", pSuiihyou.getYenknsnkwsrateyendaka3());
        logger.debug("│ ★③：円換算適用為替レート（中央値）３ = {}", pSuiihyou.getYenknsnkwsrateyenkijyun3());
        logger.debug("│ ★③：円換算適用為替レート（円安）３ = {}", pSuiihyou.getYenknsnkwsrateyenyasu3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円高）３ = {}", pSuiihyou.getYenknsnkwsrategkyendaka3());
        logger.debug("│ ★③：円換算適用為替レート変動額（円安）３ = {}", pSuiihyou.getYenknsnkwsrategkyenyasu3());
        logger.debug("│ ★①：指数上昇率１ = {}", pSuiihyou.getSisuuupritu1());
        logger.debug("│ ★①：積立金増加率１ = {}", pSuiihyou.getTmttknzoukaritu1());
        logger.debug("│ ★①：ＭＶＡ適用保険料積立金 = {}", pSuiihyou.getMvaariptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（上昇）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（同水準）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame1());
        logger.debug("│ ★①：ＭＶＡ適用積立金額（解約控除前）（低下）１ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown1());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（上昇） = {}", pSuiihyou.getMvaariwup());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（同水準） = {}", pSuiihyou.getMvaariwsame());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（低下） = {}", pSuiihyou.getMvaariwdown());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） = {}", pSuiihyou.getMvaariwyenupyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） = {}", pSuiihyou.getMvaariwyenupyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） = {}", pSuiihyou.getMvaariwyenupyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） = {}", pSuiihyou.getMvaariwyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） = {}", pSuiihyou.getMvaariwyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） = {}", pSuiihyou.getMvaariwyensameyenyasu());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） = {}", pSuiihyou.getMvaariwyendownyendaka());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） = {}", pSuiihyou.getMvaariwyendownyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） = {}", pSuiihyou.getMvaariwyendownyenyasu());
        logger.debug("│ ★①：積立金内訳（１）１ = {}", pSuiihyou.getTutmttknutiwake11());
        logger.debug("│ ★①：積立金内訳（２）１ = {}", pSuiihyou.getTutmttknutiwake21());
        logger.debug("│ ★②：指数上昇率２ = {}", pSuiihyou.getSisuuupritu2());
        logger.debug("│ ★②：積立金増加率２ = {}", pSuiihyou.getTmttknzoukaritu2());
        logger.debug("│ ★②：ＭＶＡ適用保険料積立金２ = {}", pSuiihyou.getMvaariptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（上昇）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（同水準）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame2());
        logger.debug("│ ★②：ＭＶＡ適用積立金額（解約控除前）（低下）２ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（上昇）２ = {}", pSuiihyou.getMvaariwup2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（同水準）２ = {}", pSuiihyou.getMvaariwsame2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（低下）２ = {}", pSuiihyou.getMvaariwdown2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ = {}", pSuiihyou.getMvaariwyenupyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ = {}", pSuiihyou.getMvaariwyenupyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ = {}", pSuiihyou.getMvaariwyenupyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ = {}", pSuiihyou.getMvaariwyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ = {}", pSuiihyou.getMvaariwyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ = {}", pSuiihyou.getMvaariwyensameyenyasu2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ = {}", pSuiihyou.getMvaariwyendownyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ = {}", pSuiihyou.getMvaariwyendownyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ = {}", pSuiihyou.getMvaariwyendownyenyasu2());
        logger.debug("│ ★②：積立金内訳（１）２ = {}", pSuiihyou.getTutmttknutiwake12());
        logger.debug("│ ★②：積立金内訳（２）２ = {}", pSuiihyou.getTutmttknutiwake22());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（上昇）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaeup3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（同水準）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaesame3());
        logger.debug("│ ★③：ＭＶＡ適用積立金額（解約控除前）（低下）３ = {}", pSuiihyou.getMvaaritmttkgkkykkjmaedown3());
        logger.debug("│ ★③：指数上昇率３ = {}", pSuiihyou.getSisuuupritu3());
        logger.debug("│ ★③：積立金増加率３ = {}", pSuiihyou.getTmttknzoukaritu3());
        logger.debug("│ ★③：ＭＶＡ適用保険料積立金３ = {}", pSuiihyou.getMvaariptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（上昇）３ = {}", pSuiihyou.getMvaariwup3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（同水準）３ = {}", pSuiihyou.getMvaariwsame3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（低下）３ = {}", pSuiihyou.getMvaariwdown3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ = {}", pSuiihyou.getMvaariwyenupyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ = {}", pSuiihyou.getMvaariwyenupyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ = {}", pSuiihyou.getMvaariwyenupyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ = {}", pSuiihyou.getMvaariwyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ = {}", pSuiihyou.getMvaariwyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ = {}", pSuiihyou.getMvaariwyensameyenyasu3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ = {}", pSuiihyou.getMvaariwyendownyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ = {}", pSuiihyou.getMvaariwyendownyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ = {}", pSuiihyou.getMvaariwyendownyenyasu3());
        logger.debug("│ ★③：積立金内訳（１）３ = {}", pSuiihyou.getTutmttknutiwake13());
        logger.debug("│ ★③：積立金内訳（２）３ = {}", pSuiihyou.getTutmttknutiwake23());
        logger.debug("│ ★①：ＭＶＡ適用外保険料積立金 = {}", pSuiihyou.getMvanoneptumitatekin());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額 = {}", pSuiihyou.getMvanonewsame());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円高） = {}", pSuiihyou.getMvanonewyensameyendaka());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（中央値） = {}", pSuiihyou.getMvanonewyensameyenkijyun());
        logger.debug("│ ★①：ＭＶＡ適用外解約返戻金額（円貨）（円安） = {}", pSuiihyou.getMvanonewyensameyenyasu());
        logger.debug("│ ★②：ＭＶＡ適用外保険料積立金２ = {}", pSuiihyou.getMvanoneptumitatekin2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額２ = {}", pSuiihyou.getMvanonewsame2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円高）２ = {}", pSuiihyou.getMvanonewyensameyendaka2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ = {}", pSuiihyou.getMvanonewyensameyenkijyun2());
        logger.debug("│ ★②：ＭＶＡ適用外解約返戻金額（円貨）（円安）２ = {}", pSuiihyou.getMvanonewyensameyenyasu2());
        logger.debug("│ ★③：ＭＶＡ適用外保険料積立金３ = {}", pSuiihyou.getMvanoneptumitatekin3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額３ = {}", pSuiihyou.getMvanonewsame3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円高）３ = {}", pSuiihyou.getMvanonewyensameyendaka3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ = {}", pSuiihyou.getMvanonewyensameyenkijyun3());
        logger.debug("│ ★③：ＭＶＡ適用外解約返戻金額（円貨）（円安）３ = {}", pSuiihyou.getMvanonewyensameyenyasu3());
        logger.debug("│ ★①：予定利率計算基準利率１ = {}", pSuiihyou.getYtirrtcalckijyunrrt1());
        logger.debug("│ ★②：予定利率計算基準利率２ = {}", pSuiihyou.getYtirrtcalckijyunrrt2());
        logger.debug("│ ★③：予定利率計算基準利率３ = {}", pSuiihyou.getYtirrtcalckijyunrrt3());
        logger.debug("│ ★①：前納残高（円貨）１ = {}", pSuiihyou.getZennouzndkyen1());
        logger.debug("│ ★②：前納残高（円貨）２ = {}", pSuiihyou.getZennouzndkyen2());
        logger.debug("│ ★③：前納残高（円貨）３ = {}", pSuiihyou.getZennouzndkyen3());
        logger.debug("│ ★①：既払込保険料（円貨）１ = {}", pSuiihyou.getKihrkmpyen1());
        logger.debug("│ ★②：既払込保険料（円貨）２ = {}", pSuiihyou.getKihrkmpyen2());
        logger.debug("│ ★③：既払込保険料（円貨）３ = {}", pSuiihyou.getKihrkmpyen3());
        logger.debug("│ ★①：既払込保険料１ = {}", pSuiihyou.getKihrkmp1());
        logger.debug("│ ★②：既払込保険料２ = {}", pSuiihyou.getKihrkmp2());
        logger.debug("│ ★③：既払込保険料３ = {}", pSuiihyou.getKihrkmp3());
        logger.debug("▲ 推移表TBLの設定値");
    }

}
