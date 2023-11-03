package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutaiMockForSiharai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 積立金状態チェックのメソッド{@link ChkSubTmttknJyoutai#exec(BizDate,
 * String, BizDate, BizDate, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubTmttknJyoutaiTest_exec {

    @Inject
    private ChkSubTmttknJyoutai chkSubTmttknJyoutai;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(HanteiKhSisuurendoTmttknJyoutai.class).to(HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.caller = ChkSubTmttknJyoutaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.caller = null;
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = null;

        MockObjectManager.initialize();
    }
    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        pChkKekkaBeanLst.add(chkKekkaBean);
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 3, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");

        exClassificationEquals(pChkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK,
            "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(pChkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK,
            "請求内容チェック区分");
        exStringEquals(pChkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(pChkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(pChkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(pChkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(pChkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");

        HanteiTmttknJyoutaiBean HanteiTmttknJyoutaiBean = (HanteiTmttknJyoutaiBean) MockObjectManager.
            getArgument(HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.class, "execChokuzenOutouymTmttknHantei", 0, 0);
        exStringEquals(HanteiTmttknJyoutaiBean.getSyono(), "17806000024", "証券番号");
        exDateEquals(HanteiTmttknJyoutaiBean.getHanteiKijyunymd(), BizDate.valueOf(20190501), "判定基準日");
        exDateEquals(HanteiTmttknJyoutaiBean.getKykymd(), BizDate.valueOf(20190402), "契約日");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = BizDate.valueOf(20190501);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = BizDate.valueOf(20190430);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK,
            "請求内容チェック区分");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN2;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = null;
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_MIHANEI_CHK,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190430);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = null;
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = null;
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = null;
        BizDate pKykymd = BizDate.valueOf(20190402);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = null;
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190501);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190501);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(pChkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TMTTKIN_ITENBI_CHK,
            "請求内容チェック区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {

        MockObjectManager.initialize();
        HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.SYORIPTN = HanteiKhSisuurendoTmttknJyoutaiMockForSiharai.TESTPATTERN1;

        List<ChkKekkaBean> pChkKekkaBeanLst = new ArrayList<>();
        BizDate pHanteikijyunymd = BizDate.valueOf(20190430);
        String pSyono = "17806000024";
        BizDate pKykymd = BizDate.valueOf(20190501);
        BizDate pTmttknitenymd = BizDate.valueOf(20190502);
        chkSubTmttknJyoutai.exec(pHanteikijyunymd, pSyono, pKykymd, pTmttknitenymd, pChkKekkaBeanLst);
        exNumericEquals(pChkKekkaBeanLst.size(), 0, "件数");
    }
}
