package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 質権設定チェックのメソッド{@link ChkSubStknset#exec(JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubStknsetTest_exec {

    @Inject
    private ChkSubStknset chkSubStknset;

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();
        pSiKykKihon.setStknsetkbn(C_StknsetKbn.ARI);
        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        chkSubStknset.exec(pSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_STKNSET_UMU,
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
        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();
        pSiKykKihon.setStknsetkbn(C_StknsetKbn.ARI);
        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.SAIKENSYAKAIYAKUMOUSIDE);
        chkSubStknset.exec(pSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SATEICHK_STKNSET_UMU,
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
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon pSiKykKihon = new JT_SiKykKihon();
        pSiKykKihon.setStknsetkbn(C_StknsetKbn.NONE);
        pSiKykKihon.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
        pSiKykKihon.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
        pSiKykKihon.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
        pSiKykKihon.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
        pSiKykKihon.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
        chkSubStknset.exec(pSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");

        MockObjectManager.initialize();
    }
}
