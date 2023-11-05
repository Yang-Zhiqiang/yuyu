package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.common.biz.bzcommon.BzChkAdrKetasuu;
import yuyu.common.biz.bzcommon.BzChkAdrKetasuuMockForHozen;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * CheckKhMeigiAddrクラスのメソッド {@link CheckKhMeigiAddr#check(List<MeigiAddrBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CheckKhMeigiAddrTest_exec {

    @Inject
    private CheckKhMeigiAddr checkKhMeigiAddr;

    @Before
    public void Before () {
        MockModuleBinder.bind(new AbstractModule() {
            @Override
            protected void configure() {
                bind(BzChkAdrKetasuu.class).to(BzChkAdrKetasuuMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        BzChkAdrKetasuuMockForHozen.caller = CheckKhMeigiAddrTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        BzChkAdrKetasuuMockForHozen.caller = null;
        BzChkAdrKetasuuMockForHozen.SYORIPTN = null;
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(10)
    public void testExec_A1() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setNmKnFieldNm("氏名（カナ）項目名");
            meigiAddrBean.setNmKn("ユヒメイ　イチア@%");

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "氏名（カナ）項目名が正しくありません。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(20)
    public void testExec_A2() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setNmKnFieldNm("氏名（カナ）項目名");
            meigiAddrBean.setNmKn("ｻﾄｳ　ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀ");

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "氏名（カナ）項目名 半角カナでの入力桁数が超過しています。（18文字以下）", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setNmKnFieldNm("氏名（カナ）項目名");
        meigiAddrBean.setNmKn("");

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getNmKnFieldNm(), "氏名（カナ）項目名", "氏名（カナ）項目名");
        exStringEquals(meigiAddrBean.getNmKn(), "", "氏名（カナ）");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(40)
    public void testExec_A4() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setNmKjFieldNm("氏名（漢字）項目名");
            meigiAddrBean.setNmKj("氏名（漢字）");

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "氏名（漢字）項目名が正しくありません。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(50)
    public void testExec_A5() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setNmKjFieldNm("氏名（漢字）項目名");
            meigiAddrBean.setNmKj("");
            meigiAddrBean.setNmKjhukaKbn(C_KjkhukaKbn.KJKHUKA);

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "氏名（漢字）項目名が未入力です。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setNmKjFieldNm("氏名（漢字）項目名");
        meigiAddrBean.setNmKj("氏名　漢字");
        meigiAddrBean.setNmKjhukaKbn(C_KjkhukaKbn.KJKHUKA);

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getNmKjFieldNm(), "氏名（漢字）項目名", "氏名（漢字）項目名");
        exStringEquals(meigiAddrBean.getNmKj(), "氏名　漢字", "氏名（漢字）");
        exClassificationEquals(meigiAddrBean.getNmKjhukaKbn(), C_KjkhukaKbn.KJKHUKA, "氏名漢字化不可区分");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setNmKjFieldNm("氏名（漢字）項目名");
        meigiAddrBean.setNmKj("");
        meigiAddrBean.setNmKjhukaKbn(C_KjkhukaKbn.BLNK);

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getNmKjFieldNm(), "氏名（漢字）項目名", "氏名（漢字）項目名");
        exStringEquals(meigiAddrBean.getNmKj(), "", "氏名（漢字）");
        exClassificationEquals(meigiAddrBean.getNmKjhukaKbn(), C_KjkhukaKbn.BLNK, "氏名漢字化不可区分");

    }

    @Test(expected = BizLogicException.class)
    @TestOrder(80)
    public void testExec_A8() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setSeiYmdFieldNm("生年月日");
            meigiAddrBean.setSeiYmd(BizDate.valueOf("20191225"));
            meigiAddrBean.setSyoriYmd(BizDate.valueOf("20191224"));

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "生年月日 が先日付のため処理できません。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setSeiYmdFieldNm("生年月日");
        meigiAddrBean.setSeiYmd(BizDate.valueOf("20191224"));
        meigiAddrBean.setSyoriYmd(BizDate.valueOf("20191224"));

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getSeiYmdFieldNm(), "生年月日", "生年月日項目名");
        exDateEquals(meigiAddrBean.getSeiYmd(), BizDate.valueOf("20191224"), "生年月日");
        exDateEquals(meigiAddrBean.getSyoriYmd(), BizDate.valueOf("20191224"), "処理日");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setSeiYmdFieldNm("生年月日");
        meigiAddrBean.setSeiYmd(BizDate.valueOf("20191224"));
        meigiAddrBean.setSyoriYmd(BizDate.valueOf("20191225"));

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getSeiYmdFieldNm(), "生年月日", "生年月日項目名");
        exDateEquals(meigiAddrBean.getSeiYmd(), BizDate.valueOf("20191224"), "生年月日");
        exDateEquals(meigiAddrBean.getSyoriYmd(), BizDate.valueOf("20191225"), "処理日");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        BzChkAdrKetasuuMockForHozen.SYORIPTN = BzChkAdrKetasuuMockForHozen.TESTPATTERN1;

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setAdrkjFieldNm("住所（漢字）");

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "住所（漢字）の合計入力文字数が1文字になっています。2文字以内で入力してください。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        MockObjectManager.initialize();
        BzChkAdrKetasuuMockForHozen.SYORIPTN = BzChkAdrKetasuuMockForHozen.TESTPATTERN2;

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setAdrkjFieldNm("住所（漢字）");

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getAdrkjFieldNm(), "住所（漢字）", "住所（漢字）項目名");
    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setNmKnFieldNm(null);
        meigiAddrBean.setNmKjFieldNm(null);
        meigiAddrBean.setSeiYmdFieldNm(null);
        meigiAddrBean.setAdrkjFieldNm(null);

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getNmKnFieldNm(), null, "氏名（カナ）項目名");
        exStringEquals(meigiAddrBean.getNmKjFieldNm(), null, "氏名（漢字）項目名");
        exStringEquals(meigiAddrBean.getSeiYmdFieldNm(), null, "生年月日項目名");
        exStringEquals(meigiAddrBean.getAdrkjFieldNm(), null, "住所（漢字）項目名");
    }

    @Test(expected = BizLogicException.class)
    @TestOrder(140)
    public void testExec_A14() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        try {
            MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
            meigiAddrBean.setNmKjFieldNm("氏名（漢字）項目名");
            meigiAddrBean.setNmKj(null);
            meigiAddrBean.setNmKjhukaKbn(C_KjkhukaKbn.KJKHUKA);

            pMeigiAddrBeanLst.add(meigiAddrBean);

            checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "氏名（漢字）項目名が未入力です。", "エラーメッセージ(BizLogicException)");
            throw e;
        }
    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        List<MeigiAddrBean> pMeigiAddrBeanLst = new ArrayList<MeigiAddrBean>();

        MeigiAddrBean meigiAddrBean = new MeigiAddrBean();
        meigiAddrBean.setNmKnFieldNm("");
        meigiAddrBean.setNmKjFieldNm("");
        meigiAddrBean.setSeiYmdFieldNm("");
        meigiAddrBean.setAdrkjFieldNm("");

        pMeigiAddrBeanLst.add(meigiAddrBean);

        checkKhMeigiAddr.exec(pMeigiAddrBeanLst);

        exStringEquals(meigiAddrBean.getNmKnFieldNm(), "", "氏名（カナ）項目名");
        exStringEquals(meigiAddrBean.getNmKjFieldNm(), "", "氏名（漢字）項目名");
        exStringEquals(meigiAddrBean.getSeiYmdFieldNm(), "", "生年月日項目名");
        exStringEquals(meigiAddrBean.getAdrkjFieldNm(), "", "住所（漢字）項目名");
    }

}
