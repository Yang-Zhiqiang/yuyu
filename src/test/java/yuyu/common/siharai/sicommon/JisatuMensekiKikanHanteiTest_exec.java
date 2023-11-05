package yuyu.common.siharai.sicommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 自殺免責期間判定クラスのメソッド {@link JisatuMensekiKikanHantei#exec(BizDate, BizDate, JT_SiKykSyouhn,
        JM_SiSyouhnZokusei)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class JisatuMensekiKikanHanteiTest_exec {

    @Inject
    private JisatuMensekiKikanHantei jisatuMensekiKikanHantei;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BizDate hanteiKijyunYmd = null;
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = null;
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160228));
        JM_SiSyouhnZokusei siSyouhnZokusei = null;

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160227));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160226));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120228);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120227));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120227);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120226));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160227);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120228);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120228);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120227);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120227));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160227);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120227);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120227);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20160228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120226);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120227));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(4);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170228);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20160229));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20130228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(180)
    public void testExec_A18() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20130228);
        BizDate hksknnkaisiymd = BizDate.valueOf(20120229);
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20120229));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }

    @Test
    @TestOrder(190)
    public void testExec_A19() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20170228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(0);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, false, "判定結果フラグ");

    }

    @Test
    @TestOrder(200)
    public void testExec_A20() {

        BizDate hanteiKijyunYmd = BizDate.valueOf(20170227);
        BizDate hksknnkaisiymd = null;
        JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();
        siKykSyouhn.setSknnkaisiymd(BizDate.valueOf(20170228));
        JM_SiSyouhnZokusei siSyouhnZokusei = new JM_SiSyouhnZokusei();
        siSyouhnZokusei.setJisatumensekinensuu(1);

        boolean hanteiKekkaFlag = jisatuMensekiKikanHantei.exec(hanteiKijyunYmd, hksknnkaisiymd, siKykSyouhn,
            siSyouhnZokusei);
        exBooleanEquals(hanteiKekkaFlag, true, "判定結果フラグ");

    }
}
