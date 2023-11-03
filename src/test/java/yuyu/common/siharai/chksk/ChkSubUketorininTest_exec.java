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

import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 受取人チェックのメソッド{@link ChkSubUketorinin#exec(C_SeikyuusyaKbn, String, JT_SiKykKihon,
        List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubUketorininTest_exec {
    @Inject
    private ChkSubUketorinin chkSubUketorinin;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBean.setMsgHikisuu1("1");
        chkKekkaBean.setMsgHikisuu2("2");
        chkKekkaBean.setMsgHikisuu3("3");
        chkKekkaBean.setMsgHikisuu4("4");
        chkKekkaBean.setMsgHikisuu5("5");
        chkKekkaBeanLst.add(chkKekkaBean);
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.UKT_CHK,
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
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウエオ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウエオ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.UKT_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.STDRNIN);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.UKT_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_B1() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.UKT_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_B2() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.UKT_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_B3() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_B4() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_B5() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウエオ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_B6() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_B7() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_B8() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウエオ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_B9() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_B10() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.BLNK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.BLNK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_C1() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_C2() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_C3() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyanmkn = "アイウエオ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_C4() {
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyanmkn = "アイウ";
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyknmkn("アイウエオ");
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt1.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt2.setUktkbn(C_UktKbn.KYK);
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.BLNK);
        siUkt3.setUktkbn(C_UktKbn.KYK);
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubUketorinin.exec(seikyuusyaKbn,seikyuusyanmkn,siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

}
