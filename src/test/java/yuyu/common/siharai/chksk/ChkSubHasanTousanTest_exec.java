package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 破産および倒産チェックのメソッド{@link ChkSubHasanTousan#exec(JT_SiKykKihon,
        List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubHasanTousanTest_exec {

    @Inject
    private ChkSubHasanTousan chkSubHasanTousan;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SEIZENKYUUHUHIGAITOU);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HOZENSONOTA);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBeanLst.add(chkKekkaBean);
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.SEIZENKYUUHUHIGAITOU);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.PMENHIGAITOU);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.PMENHIGAITOU);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBeanLst.add(chkKekkaBean);
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.KAIGAITOKOU);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SHRTYOUSYOSKSTEISI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.ADRHUMEI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBeanLst.add(chkKekkaBean);
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.IKUEISIKINANNAITYUUI);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SYOUMETUGOOUTAITYUUI);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.HOZENSONOTA);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBeanLst.add(chkKekkaBean);
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_HASANTOUSAN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.HOZENSONOTA);
        siKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI);
        siKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SEIZENKYUUHUHIGAITOU);
        siKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        siKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubHasanTousan.exec(siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }
}
