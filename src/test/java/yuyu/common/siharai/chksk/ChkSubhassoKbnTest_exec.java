package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 発送区分チェックのメソッド{@link ChkSubhassoKbn#exec(C_Tkhukaumu, C_KanryotuutioutKbn, C_HassouKbn ,
        JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br/>
 */
@RunWith(OrderedRunner.class)
public class ChkSubhassoKbnTest_exec {

    @Inject
    private ChkSubhassoKbn chkSubhassoKbn;


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
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.BLNK, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIBETU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAKUSEIKBN_MINYUCHK,
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
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.BLNK, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAKUSEI_HASSOU_SKCHK,
            "請求内容チェック区分");
    }


    @Test
    @TestOrder(30)
    public void testExec_A3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.BLNK, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(50)
    public void testExec_A5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.SAISATEI, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.BLNK, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(60)
    public void testExec_B1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.HUKA, C_KanryotuutioutKbn.PDF, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_HASSOU_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(70)
    public void testExec_B2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.HUKA, C_KanryotuutioutKbn.PDF, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_HASSOU_SKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(80)
    public void testExec_B3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.NONE, C_KanryotuutioutKbn.PDF, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(90)
    public void testExec_B4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(100)
    public void testExec_B5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(110)
    public void testExec_B6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        chkSubhassoKbn.exec(C_SaisateiKbn.SAISATEI, "", "", "",
            C_Tkhukaumu.HUKA, C_KanryotuutioutKbn.PDF, C_HassouKbn.TYOKUSOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(120)
    public void testExec_C1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "債権者", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIBETU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SAIKEN_SAKUSEIKBN_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(130)
    public void testExec_C2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "債権者", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(140)
    public void testExec_C3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "債権者", "1600023", "",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(150)
    public void testExec_C4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "債権者", "", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(160)
    public void testExec_C5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(170)
    public void testExec_C6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.SAISATEI, "債権者", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.BLNK,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(180)
    public void testExec_D1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.FBSOUKIN,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(190)
    public void testExec_D2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(200)
    public void testExec_D3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.PDF, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(210)
    public void testExec_D4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.FBSOUKIN,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }


    @Test
    @TestOrder(220)
    public void testExec_D5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SEIBETU_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIBETU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYOU_SAKUSEIKBN_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(230)
    public void testExec_D6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.BLNK, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYOU_SAKUSEIKBN_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(240)
    public void testExec_D7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        JT_SiKykKihon jTSiKykKihon = new JT_SiKykKihon();
        jTSiKykKihon.setNstkhkumu(C_UmuKbn.NONE);
        chkSubhassoKbn.exec(C_SaisateiKbn.SAISATEI, "", "1600023", "住所",
            C_Tkhukaumu.BLNK, C_KanryotuutioutKbn.GAIBU, C_HassouKbn.HONSYAKAISOU, C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI,
            jTSiKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

        MockObjectManager.initialize();
    }


}
