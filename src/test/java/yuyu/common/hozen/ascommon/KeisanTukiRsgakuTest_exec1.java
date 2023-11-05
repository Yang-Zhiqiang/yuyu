package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

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

import com.google.inject.AbstractModule;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 月払領収金額計算のメソッド {@link KeisanTukiRsgaku#exec(KeisanTukiRsgakuBean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanTukiRsgakuTest_exec1 {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetHrkKawaseRateKijyun.class).to(GetHrkKawaseRateKijyunMockForKhansyuu.class);
                bind(KeisanPRsTuukaKnsn.class).to(KeisanPRsTuukaKnsnMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        GetHrkKawaseRateKijyunMockForKhansyuu.caller = KeisanTukiRsgakuTest_exec1.class;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = KeisanTukiRsgakuTest_exec1.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        GetHrkKawaseRateKijyunMockForKhansyuu.caller = null;
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.caller = null;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(null);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);


        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.BLNK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(null);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.BLNK);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(null);
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(null);
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(null);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(null);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.BLNK);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(null);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(0);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);


        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd(null);
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(null);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno(null);
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(null);
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "割引適用あり", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E002", "エラーコード[0]");
    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(4);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "割引適用あり", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E002", "エラーコード[0]");
    }

    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {
        MockObjectManager.initialize();
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN1;

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.SYOKAIP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202008));
        keisanTukiRsgakuBean.setJyuutoutukisuu(2);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "払込用為替レート基準日エラー入金経路不正", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 2, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E003", "エラーコード[0]");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(1), "E010", "エラーコード[1]");
    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {
        MockObjectManager.initialize();
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN2;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN1;

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202008));
        keisanTukiRsgakuBean.setJyuutoutukisuu(2);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "保険料通貨換算計算エラー為替レート取得ミス", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 2, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E004", "エラーコード[0]");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(1), "E011", "エラーコード[1]");
    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {
        MockObjectManager.initialize();
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN2;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(1);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(1100.00, BizCurrencyTypes.DOLLAR), "領収金額合計");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "一括割引料合計");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanTukiRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202007), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(1100.00, BizCurrencyTypes.DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20200826), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(1200), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "一括割引料");

        exClassificationEquals((C_NyknaiyouKbn) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 0), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals((C_Nykkeiro) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 1), C_Nykkeiro.KZHRK, "入金経路");
        exDateEquals((BizDate) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 2), BizDate.valueOf(20200825), "領収年月日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 3), BizDateYM.valueOf(202007), "充当開始年月");
        exNumericEquals((Integer) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 4), 0, "充当年数");
        exNumericEquals((Integer) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 5), 1, "充当月数");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(GetHrkKawaseRateKijyunMockForKhansyuu.class, "exec", 0, 6), C_Hrkkaisuu.TUKI, "払込回数");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 0), BizDate.valueOf(20200826), "為替レート基準日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 1), BizCurrency.valueOf(1000, BizCurrencyTypes.YEN), "保険料");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 2), C_Tuukasyu.JPY, "換算元通貨種類");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanPRsTuukaKnsnMockForKhansyuu.class, "exec", 0, 3), C_Tuukasyu.USD, "換算先通貨種類");

    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {
        MockObjectManager.initialize();

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202008));
        keisanTukiRsgakuBean.setJyuutoutukisuu(2);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(2);
        keisanRsgakuSyouhinBean2.setRyouritusdno("1");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(2000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean2);


        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(6000), "領収金額合計");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanTukiRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 2, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202008), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(3000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(1).getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutoutukisuu(), 1, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRsgaku(), BizCurrency.valueOf(3000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");

    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(3);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.optional());
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanTukiRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {
        MockObjectManager.initialize();
        GetHrkKawaseRateKijyunMockForKhansyuu.SYORIPTN = GetHrkKawaseRateKijyunMockForKhansyuu.TESTPATTERN2;
        KeisanPRsTuukaKnsnMockForKhansyuu.SYORIPTN = KeisanPRsTuukaKnsnMockForKhansyuu.TESTPATTERN2;

        KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);
        KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);
        keisanTukiRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanTukiRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanTukiRsgakuBean.setRsymd(BizDate.valueOf(20200825));
        keisanTukiRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202007));
        keisanTukiRsgakuBean.setJyuutoutukisuu(0);
        keisanTukiRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("1");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000, BizCurrencyTypes.YEN));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);

        keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanTukiRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "領収金額合計");
        exBizCalcbleEquals(keisanTukiRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "一括割引料合計");
        exNumericEquals(keisanTukiRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanTukiRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 0, "件数");
    }
}
