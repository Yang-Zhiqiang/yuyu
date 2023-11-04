package yuyu.common.hozen.ascommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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

import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGkMockForKhansyuu;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
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
 * 領収金額計算 {@link KeisanRsgaku#exec(KeisanRsgakuBean)}テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanRsgakuTest_exec1 {

    @Inject
    KeisanRsgaku keisanRsgaku;

    @Inject
    KeisanRsgakuBean keisanRsgakuBean;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanNenHalfyRsgaku.class).to(KeisanNenHalfyRsgakuMockForKhansyuu.class);
                bind(KeisanTukiIkkatuNyuukinGk.class).to(KeisanTukiIkkatuNyuukinGkMockForKhansyuu.class);
                bind(KeisanTukiRsgaku.class).to(KeisanTukiRsgakuMockForKhansyuu.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanNenHalfyRsgakuMockForKhansyuu.caller = KeisanRsgakuTest_exec1.class;
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.caller = KeisanRsgakuTest_exec1.class;
        KeisanTukiRsgakuMockForKhansyuu.caller = KeisanRsgakuTest_exec1.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        KeisanNenHalfyRsgakuMockForKhansyuu.caller = null;
        KeisanNenHalfyRsgakuMockForKhansyuu.SYORIPTN = null;
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.caller = null;
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.SYORIPTN = null;
        KeisanTukiRsgakuMockForKhansyuu.caller = null;
        KeisanTukiRsgakuMockForKhansyuu.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        C_ErrorKbn errorKbn = keisanRsgaku.exec(null);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testExec_A2() {

        keisanRsgakuBean.setHrkkaisuu(null);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testExec_A3() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.BLNK);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testExec_A4() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(null);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testExec_A5() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.BLNK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testExec_A6() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(null);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(70)
    @Transactional
    public void testExec_A7() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.BLNK);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(80)
    @Transactional
    public void testExec_A8() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(null);
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(90)
    @Transactional
    public void testExec_A9() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(null);
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(100)
    @Transactional
    public void testExec_A10() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(null);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void testExec_A11() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(null);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(120)
    @Transactional
    public void testExec_A12() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.BLNK);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(130)
    @Transactional
    public void testExec_A13() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutoutukisuu(2);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(null);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");
    }

    @Test
    @TestOrder(140)
    @Transactional
    public void testExec_A14() {

        MockObjectManager.initialize();
        KeisanNenHalfyRsgakuMockForKhansyuu.SYORIPTN = KeisanNenHalfyRsgakuMockForKhansyuu.TESTPATTERN1;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.HALFY);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(1000), "領収金額合計");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(5000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20200814), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");

        KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = (KeisanNenHalfyRsgakuBean)MockObjectManager.getArgument(
            KeisanNenHalfyRsgakuMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(keisanNenHalfyRsgakuBean.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払込回数");
        exClassificationEquals(keisanNenHalfyRsgakuBean.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(keisanNenHalfyRsgakuBean.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateEquals(keisanNenHalfyRsgakuBean.getRsymd(), BizDate.valueOf(20200801), "領収年月日");
        exDateYMEquals(keisanNenHalfyRsgakuBean.getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanNenHalfyRsgakuBean.getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanNenHalfyRsgakuBean.getJyuutoutukisuu(), 6, "充当月数");
        exClassificationEquals(keisanNenHalfyRsgakuBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = keisanNenHalfyRsgakuBean.getKeisanRsgakuSyouhinBeanLst();
        exNumericEquals(keisanRsgakuSyouhinBeanLst.size(), 1, "件数");
        exStringEquals(keisanRsgakuSyouhinBeanLst.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(keisanRsgakuSyouhinBeanLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanRsgakuSyouhinBeanLst.get(0).getRyouritusdno(), "J", "料率世代番号");
        exBizCalcbleEquals(keisanRsgakuSyouhinBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(1000), "保険料");
    }

    @Test
    @TestOrder(150)
    @Transactional
    public void testExec_A15() {

        MockObjectManager.initialize();
        KeisanNenHalfyRsgakuMockForKhansyuu.SYORIPTN = KeisanNenHalfyRsgakuMockForKhansyuu.TESTPATTERN2;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.NEN);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(1);
        keisanRsgakuBean.setJyuutoutukisuu(0);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "年１回払払込用為替レート基準日エラー", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E003", "エラーコード[0]");
    }

    @Test
    @TestOrder(160)
    @Transactional
    public void testExec_A16() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForKhansyuu.TESTPATTERN2;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(12);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "一括入金額計算エラー", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E005", "エラーコード[0]");

    }

    @Test
    @TestOrder(170)
    @Transactional
    public void testExec_A17() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForKhansyuu.TESTPATTERN1;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(12);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(5000), "領収金額合計");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(1000), "一括割引料合計");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 12, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(5000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20201221), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(102), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1000), "一括割引料");

        KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean = (KeisanIkkatuNyuukinGkBean)MockObjectManager.getArgument(
            KeisanTukiIkkatuNyuukinGkMockForKhansyuu.class, "exec", 0, 0);
        List<KeisanIkkatuNyuukinGkSyouhnBean> keisanIkkatuNyuukinGkSyouhnBeanList =
            keisanIkkatuNyuukinGkBean.getKeisanIkkatuNyuukinGkSyouhnBeanLst();
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanList.size(), 1, "件数");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanList.get(0).getSyouhnCd(), "ﾕﾁ", "商品コード");
        exNumericEquals(keisanIkkatuNyuukinGkSyouhnBeanList.get(0).getSyouhnsdNo(), 1, "商品世代番号");
        exStringEquals(keisanIkkatuNyuukinGkSyouhnBeanList.get(0).getRyouritusdNo(), "J", "料率世代番号");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanList.get(0).getHokenryou(), BizCurrency.valueOf(1000), "保険料");
        exBizCalcbleEquals(keisanIkkatuNyuukinGkSyouhnBeanList.get(0).getYoteiRiritu(), BizNumber.valueOf(1200), "予定利率");
        exNumericEquals(keisanIkkatuNyuukinGkBean.getJyuutoutuKisuu(), 12, "充当月数");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exDateEquals(keisanIkkatuNyuukinGkBean.getSyokaiprsYmd(), BizDate.valueOf(20200801), "領収年月日");
        exDateYMEquals(keisanIkkatuNyuukinGkBean.getJyutoustartYm(), BizDateYM.valueOf(202009), "充当開始年月");
        exClassificationEquals(keisanIkkatuNyuukinGkBean.getTkiktbrisyuruiKbn(),
            C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "定期一括払種類区分");
        exBooleanEquals((boolean)MockObjectManager.getArgument(KeisanTukiIkkatuNyuukinGkMockForKhansyuu.class,
            "exec", 0, 1), false, "一括割引不要フラグ");
    }

    @Test
    @TestOrder(180)
    @Transactional
    public void testExec_A18() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd(null);
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(190)
    @Transactional
    public void testExec_A19() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(null);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(200)
    @Transactional
    public void testExec_A20() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno(null);
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }
    @Test
    @TestOrder(210)
    @Transactional
    public void testExec_A21() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(null);
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(220)
    @Transactional
    public void testExec_A22() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForKhansyuu.TESTPATTERN4;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(12);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();

        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean1 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean1.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean1.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean1.setRyouritusdno("J");
        keisanRsgakuSyouhinBean1.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean1.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean1);

        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean2 = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean2.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean2.setSyouhnsdno(2);
        keisanRsgakuSyouhinBean2.setRyouritusdno("J");
        keisanRsgakuSyouhinBean2.setHokenryou(BizCurrency.valueOf(2000));
        keisanRsgakuSyouhinBean2.setYoteiRiritu(BizNumber.valueOf(1300));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean2);

        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "領収金額合計");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(2000, BizCurrencyTypes.DOLLAR), "一括割引料合計");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 2, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), null, "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "一括割引料");

        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(1).getJyutoustartym(), BizDateYM.valueOf(202103), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(1).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRsgaku(), BizCurrency.valueOf(5000, BizCurrencyTypes.DOLLAR), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsratekjymd(), null, "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getRyosyukwsrate(), null, "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(1).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(1).getIktwaribikikgk(), BizCurrency.valueOf(1000, BizCurrencyTypes.DOLLAR), "一括割引料");

    }

    @Test
    @TestOrder(230)
    @Transactional
    public void testExec_A23() {

        MockObjectManager.initialize();
        KeisanTukiRsgakuMockForKhansyuu.SYORIPTN = KeisanTukiRsgakuMockForKhansyuu.TESTPATTERN1;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(1000), "領収金額合計");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 1, "件数");
        exDateYMEquals(keisanRsgkUtiwakeBeanList.get(0).getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutounensuu(), 0, "充当年数");
        exNumericEquals(keisanRsgkUtiwakeBeanList.get(0).getJyuutoutukisuu(), 6, "充当月数");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRsgaku(), BizCurrency.valueOf(5000), "領収金額");
        exDateEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsratekjymd(), BizDate.valueOf(20200814), "領収為替レート基準日");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getRyosyukwsrate(), BizNumber.valueOf(2), "領収為替レート");
        exClassificationEquals(keisanRsgkUtiwakeBeanList.get(0).getIktnyuukinnumu(), C_UmuKbn.ARI, "一括入金有無");
        exBizCalcbleEquals(keisanRsgkUtiwakeBeanList.get(0).getIktwaribikikgk(), BizCurrency.valueOf(100), "一括割引料");

        KeisanTukiRsgakuBean keisanTukiRsgakuBean = (KeisanTukiRsgakuBean)MockObjectManager.getArgument(
            KeisanTukiRsgakuMockForKhansyuu.class, "exec", 0, 0);
        exClassificationEquals(keisanTukiRsgakuBean.getNykkeiro(), C_Nykkeiro.KZHRK, "入金経路");
        exClassificationEquals(keisanTukiRsgakuBean.getNyknaiyoukbn(), C_NyknaiyouKbn.KEIZOKUP, "入金内容区分");
        exDateEquals(keisanTukiRsgakuBean.getRsymd(), BizDate.valueOf(20200801), "領収年月日");
        exDateYMEquals(keisanTukiRsgakuBean.getJyutoustartym(), BizDateYM.valueOf(202009), "充当開始年月");
        exNumericEquals(keisanTukiRsgakuBean.getJyuutoutukisuu(), 6, "充当月数");
        exClassificationEquals(keisanTukiRsgakuBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanLst = keisanTukiRsgakuBean.getKeisanRsgakuSyouhinBeanLst();
        exNumericEquals(keisanRsgakuSyouhinBeanLst.size(), 1, "件数");
        exStringEquals(keisanRsgakuSyouhinBeanLst.get(0).getSyouhncd(), "ﾕﾁ", "商品コード");
        exNumericEquals(keisanRsgakuSyouhinBeanLst.get(0).getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanRsgakuSyouhinBeanLst.get(0).getRyouritusdno(), "J", "料率世代番号");
        exBizCalcbleEquals(keisanRsgakuSyouhinBeanLst.get(0).getHokenryou(), BizCurrency.valueOf(1000), "保険料");

    }

    @Test
    @TestOrder(240)
    @Transactional
    public void testExec_A24() {

        MockObjectManager.initialize();
        KeisanTukiRsgakuMockForKhansyuu.SYORIPTN = KeisanTukiRsgakuMockForKhansyuu.TESTPATTERN2;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(null);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "月払割引適用あり", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E002", "エラーコード[0]");

    }

    @Test
    @TestOrder(250)
    @Transactional
    public void testExec_A25() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.NONE);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        assertNull(keisanRsgaku.getKeisanRsgkOutBean());
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
    }

    @Test
    @TestOrder(260)
    @Transactional
    public void testExec_A26() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.optional());
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(270)
    @Transactional
    public void testExec_A27() {

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(6);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.ERROR, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), "必須項目未入力", "エラー理由");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 1, "エラーコードの件数");
        exStringEquals(keisanRsgaku.getErrorCd().get(0), "E001", "エラーコード[0]");

    }

    @Test
    @TestOrder(280)
    @Transactional
    public void testExec_A28() {

        MockObjectManager.initialize();
        KeisanTukiIkkatuNyuukinGkMockForKhansyuu.SYORIPTN = KeisanTukiIkkatuNyuukinGkMockForKhansyuu.TESTPATTERN1;

        keisanRsgakuBean.setHrkkaisuu(C_Hrkkaisuu.TUKI);
        keisanRsgakuBean.setNykkeiro(C_Nykkeiro.KZHRK);
        keisanRsgakuBean.setNyknaiyoukbn(C_NyknaiyouKbn.KEIZOKUP);
        keisanRsgakuBean.setRsymd(BizDate.valueOf(20200801));
        keisanRsgakuBean.setJyutoustartym(BizDateYM.valueOf(202009));
        keisanRsgakuBean.setJyuutounensuu(0);
        keisanRsgakuBean.setJyuutoutukisuu(0);
        keisanRsgakuBean.setRstuukasyu(C_Tuukasyu.JPY);
        keisanRsgakuBean.setTikiktbrisyuruikbn(C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        List<KeisanRsgakuSyouhinBean> keisanRsgakuSyouhinBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();
        KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);
        keisanRsgakuSyouhinBean.setSyouhncd("ﾕﾁ");
        keisanRsgakuSyouhinBean.setSyouhnsdno(1);
        keisanRsgakuSyouhinBean.setRyouritusdno("J");
        keisanRsgakuSyouhinBean.setHokenryou(BizCurrency.valueOf(1000));
        keisanRsgakuSyouhinBean.setYoteiRiritu(BizNumber.valueOf(1200));
        keisanRsgakuSyouhinBeanList.add(keisanRsgakuSyouhinBean);
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanRsgakuSyouhinBeanList);

        C_ErrorKbn errorKbn = keisanRsgaku.exec(keisanRsgakuBean);

        exClassificationEquals(errorKbn, C_ErrorKbn.OK, "結果区分");
        exStringEquals(keisanRsgaku.getErrorRiyuu(), null, "エラー理由");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getRsgakuGoukei(), BizCurrency.valueOf(0), "領収金額合計");
        exBizCalcbleEquals(keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei(), BizCurrency.valueOf(0), "一括割引料合計");
        exNumericEquals(keisanRsgaku.getErrorCd().size(), 0, "エラーコードの件数");
        List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanList = keisanRsgaku.getKeisanRsgkOutBean().getKeisanRsgkUtiwakeBeanLst();
        exNumericEquals(keisanRsgkUtiwakeBeanList.size(), 0, "件数");
    }
}
