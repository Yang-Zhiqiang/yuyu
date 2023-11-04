package yuyu.common.hozen.ascommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 年１回払年２回払領収金額計算クラスのメソッド {@link KeisanNenHalfyRsgaku#exec(KeisanNenHalfyRsgakuBean)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanNenHalfyRsgakuTest_exec1 {

    @Inject
    private KeisanNenHalfyRsgaku keisanNenHalfyRsgaku;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = null;

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(null);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(null);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.BLNK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(null);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.BLNK);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(null);
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(null);
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(null);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(null);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(null);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(null);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(null);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.BLNK);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(null);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd(null);
        keisanRsgakuSyouhinBean2.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean2.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean2);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(null);
        keisanRsgakuSyouhinBean2.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean2);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean2.setRyouritusdno(null);
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean2);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean2.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean2);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean3 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean3.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean3.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean3.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean3.setHokenryou(null);
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean3);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.SYOKAIP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "払込用為替レート基準日エラー入金経路不正", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 2, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E003", "エラーコード[0]");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(1), "E010", "エラーコード[1]");
    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.BANK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20151015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(201510));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.AUD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "保険料通貨換算計算エラー為替レート取得ミス", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 2, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E004", "エラーコード[0]");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(1), "E011", "エラーコード[1]");
    }

    @Test
    @TestOrder(210)
    public void testExec_A21() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.OTHER);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20171015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(201710));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(6);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.AUD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean2.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(111, BizCurrencyTypes.AU_DOLLAR));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean2);
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean3 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean3.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean3.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean3.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean3.setHokenryou(BizCurrency.valueOf(112, BizCurrencyTypes.AU_DOLLAR));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean3);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(1121.16, BizCurrencyTypes.AU_DOLLAR), "領収金額合計");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "一括割引料合計");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanLst.size(), 3, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyutoustartym(), BizDateYM.valueOf(201710), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRsgaku(), BizCurrency.valueOf(373.72, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20170929), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(1.3702), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanLst.get(1).getJyutoustartym(), BizDateYM.valueOf(201804), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(1).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(1).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(1).getRsgaku(), BizCurrency.valueOf(373.72, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanLst.get(1).getRyosyukwsratekjymd(), BizDate.valueOf(20170929), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(1).getRyosyukwsrate(), BizNumber.valueOf(1.3702), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanLst.get(1).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(1).getIktwaribikikgk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanLst.get(2).getJyutoustartym(), BizDateYM.valueOf(201810), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(2).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(2).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(2).getRsgaku(), BizCurrency.valueOf(373.72, BizCurrencyTypes.AU_DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanLst.get(2).getRyosyukwsratekjymd(), BizDate.valueOf(20170929), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(2).getRyosyukwsrate(), BizNumber.valueOf(1.3702), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanLst.get(2).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(2).getIktwaribikikgk(), BizCurrency.valueOf(0.00, BizCurrencyTypes.AU_DOLLAR), "一括割引料");
    }

    @Test
    @TestOrder(220)
    public void testExec_A22() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(230)
    public void testExec_A23() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(0);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(0);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.USD);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean1.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(110, BizCurrencyTypes.DOLLAR));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean1);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "領収金額合計");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0.00, BizCurrencyTypes.DOLLAR), "一括割引料合計");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(240)
    public void testExec_A24() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.optional());
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(250)
    public void testExec_A25() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(1);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), "払込回数不正", "エラー理由");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanNenHalfyRsgaku.getErrorCd().get(0), "E012", "エラーコード[0]");
    }

    @Test
    @TestOrder(260)
    public void testExec_A26() {

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

        keisanNenHalfyRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanNenHalfyRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanNenHalfyRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanNenHalfyRsgakuBean.setRsymd(BizDate.valueOf(20201015));
        keisanNenHalfyRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202010));
        keisanNenHalfyRsgakuBean.setJyuutounensuu(1);
        keisanNenHalfyRsgakuBean.setJyuutoutukisuu(0);
        keisanNenHalfyRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾇ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(121);
        keisanRsgakuSyouhinBean.setRyouritusdno("121314");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(110));
        keisanRsgakuSyouhinBeanLst.add(keisanRsgakuSyouhinBean);

        keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanLst);

        C_ErrorKbn errorKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanNenHalfyRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(110), "領収金額合計");
        exBizCalcbleEquals(keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanNenHalfyRsgaku.getErrorCd().size(), 0, "エラーコードの件数");

        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = keisanNenHalfyRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanLst.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyutoustartym(), BizDateYM.valueOf(202010), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutounensuu(), 1, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanLst.get(0).getJyuutoutukisuu(), 0, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRsgaku(), BizCurrency.valueOf(110), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getRyosyukwsrate(), BizNumber.valueOf(0), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktnyuukinnumu(), C_UmuKbn.NONE, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanLst.get(0).getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
    }
}
