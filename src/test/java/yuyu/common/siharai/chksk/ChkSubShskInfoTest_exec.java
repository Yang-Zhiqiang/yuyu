package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 送付先情報チェックのメソッド{@link ChkSubShskInfo#exec(C_SouhusakiKbn, String, String, String, String, String, JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubShskInfoTest_exec {

    @Inject
    private ChkSubShskInfo chkSubShskInfo;

    private static Integer JyuusyoNyuuryokuJyougenCnt;

    @BeforeClass
    public static void testInit() {
        JyuusyoNyuuryokuJyougenCnt = YuyuBizConfig.getInstance().getJyuusyoNyuuryokuJyougenCnt();
    }
    @AfterClass
    public static void testRiset() {
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(JyuusyoNyuuryokuJyougenCnt);

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
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("");
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADD, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TDKDADR_UMUCHK,
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
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADD, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(30)
    public void testExec_B1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "", "御御御", "御御御御", "御御御御御", "081-1888-8654", jTSiKykKihon,
            chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.POSTALCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(40)
    public void testExec_B2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(50)
    public void testExec_B3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.ADRKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(60)
    public void testExec_B4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(70)
    public void testExec_B5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TELNO_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(80)
    public void testExec_B6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(90)
    public void testExec_B7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御御御御御御御御御御御御御御",
            "御御御御御御御御御御御御御御御御御", "御御御御御御御御御御御御御御御御御御",
            "081-1888-8654", jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.ADRKJ_KETACHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "51", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "12", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(100)
    public void testExec_B8() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(110)
    public void testExec_B9() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "9123456",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.TELNO_YUUKOUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(120)
    public void testExec_B10() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setTsinyno("1234567");
        YuyuBizConfig.getInstance().setJyuusyoNyuuryokuJyougenCnt(12);
        chkSubShskInfo.exec(C_SouhusakiKbn.TDADDIGAI, "1234567", "御御御", "御御御御", "御御御御御", "081-1888-8654",
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

        MockObjectManager.initialize();

    }

}
