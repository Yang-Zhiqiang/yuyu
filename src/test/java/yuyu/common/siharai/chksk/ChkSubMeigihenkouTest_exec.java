package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.siharai.configuration.YuyuSiharaiConfig;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 名義変更チェックのメソッド{@link ChkSubMeigihenkou#exec(BizDate, C_SeikyuuSyubetu, C_UmuKbn, JT_SiKykKihon,
        List＜ChkKekkaBean＞)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubMeigihenkouTest_exec {
    @Inject
    private ChkSubMeigihenkou chkSubMeigihenkou;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100402"));
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.SB, C_YouhiKbn.HUYOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100401"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.SB,  C_YouhiKbn.HUYOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100331"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.SB,   C_YouhiKbn.HUYOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100502"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.SB,  C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(null);
        chkSubMeigihenkou.exec(BizDate.valueOf("20100401"), C_SeikyuuSyubetu.SB,  C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(null);
        chkSubMeigihenkou.exec(BizDate.valueOf("20100401"), C_SeikyuuSyubetu.SB,  C_YouhiKbn.HUYOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100502"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"),
            C_SeikyuuSyubetu.SB,  C_YouhiKbn.HUYOU, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(0);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100501"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"),
            C_SeikyuuSyubetu.SB,  C_YouhiKbn.HUYOU, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100401"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100602"), C_SeikyuuSyubetu.SB, C_YouhiKbn.HUYOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        YuyuSiharaiConfig.getInstance().setSoukiMhGoGessuu(1);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20100501"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.SB, C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(110)
    public void testExec_B1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastmeihenymd(BizDate.valueOf("20090201"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.KOUSG, C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KD,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "名義変更（H21. 2. 1）", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(120)
    public void testExec_B2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(null);
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.KOUSG, C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_B3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setLastsbukthenymd(BizDate.valueOf("20090201"));
        chkSubMeigihenkou.exec(BizDate.valueOf("20100501"), C_SeikyuuSyubetu.KYH, C_YouhiKbn.YOU, siKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }
}
