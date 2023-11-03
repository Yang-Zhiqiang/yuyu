package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 差押チェックのメソッド{@link ChkSubSasiosae#exec(JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubSasiosaeTest_exec {
    @Inject
    private ChkSubSasiosae chkSubSasiosae;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. KYKSYASOUSASYOUKAI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.DAIRININTTDKHUKA);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SASIOSAE,
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
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HHKNSYAISINOURYOKUNASI);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. HOKENKEIYAKUSASIOSAE);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HOZENSONOTA);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(),C_SKNaiyouChkKbn.SATEICHK_SASIOSAE,
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
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. MINJISAISEI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SASIOSAE,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.MINJISAISEI);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. MINJISAISEI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SASIOSAE,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }
    @Test
    @TestOrder(50)
    public void testExec_A5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.PMENHIGAITOU);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. PMENHIGAITOU);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.MINJISAISEI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HOKENKEIYAKUSASIOSAE);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_SASIOSAE,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }
    @Test
    @TestOrder(60)
    public void testExec_A6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn. TTDKTYUUOUTAITYUUI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.MINJISAISEI);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HHKNSYASOUSASYOUKAI);
        chkSubSasiosae.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }
}
