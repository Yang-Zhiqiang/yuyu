package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求者情報チェックのメソッド{@link ChkSubSksyaInfo#exec(C_SeikyuusyaKbn, String, String,
            BizDate, C_Seibetu, C_SeikyuuSyubetu, JT_SiKykKihon, List<ChkKekkaBean>) } テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubSksyaInfoTest_exec extends AbstractTest{

    @Inject
    private ChkSubSksyaInfo chkSubSksyaInfo;

    private static Integer KanaNmKyoyou;

    @BeforeClass
    public static void testInit() {
        KanaNmKyoyou = YuyuBizConfig.getInstance().getKanaNmKyoyou();

    }

    @AfterClass
    public static void testClear() {
        YuyuBizConfig.getInstance().setKanaNmKyoyou(KanaNmKyoyou);

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        changeSystemDate(BizDate.valueOf(20170905));
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
        chkKekkaBean.setMsgHikisuu1("メッセージ引数1");
        chkKekkaBean.setMsgHikisuu2("メッセージ引数2");
        chkKekkaBean.setMsgHikisuu3("メッセージ引数3");
        chkKekkaBean.setMsgHikisuu4("メッセージ引数4");
        chkKekkaBean.setMsgHikisuu5("メッセージ引数5");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.BLNK;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "メッセージ引数1", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "メッセージ引数2", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "メッセージ引数3", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "メッセージ引数4", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "メッセージ引数5", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(0);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "受取人本人", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_B3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_B4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_B5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.NONE);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_B6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.ARI);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_B7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "受取人本人", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_B8() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("カナ");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_HONNIN,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "受取人本人", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_B9() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(0);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(110)
    public void testExec_B10() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(120)
    public void testExec_B11() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(130)
    public void testExec_B12() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(0);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(135)
    public void testExec_B20() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(140)
    public void testExec_B13() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.BLNK;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("カナ");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYASEIBETU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(150)
    public void testExec_B14() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.KYFKUKT);
        siUkt1.setUktnmkn("カナ");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(160)
    public void testExec_B15() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(170)
    public void testExec_B16() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ　ホケンキン１");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt2.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(180)
    public void testExec_B17() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(3);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ　ホケンキン１");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktnmkn("カナ　ホケンキン２");
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        siUkt3.setUktnmkn("カナ");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(190)
    public void testExec_B18() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(4);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ　ホケンキン１");
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt2.setUktnmkn("カナ　ホケンキン２");
        JT_SiUkt siUkt3 = siKykKihon.createSiUkt();
        siUkt3.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt3.setUktnmkn("カナ　ホケンキン３");
        JT_SiUkt siUkt4 = siKykKihon.createSiUkt();
        siUkt4.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt4.setUktnmkn("カナ　ホケンキン４");
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(200)
    public void testExec_B19() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(5);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYA_HUKUSUUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(201)
    public void testExec_B21() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.FEMALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.HHKN);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(202)
    public void testExec_B22() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.MALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(203)
    public void testExec_B23() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.FEMALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(204)
    public void testExec_B24() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.FEMALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.MALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(205)
    public void testExec_B25() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.FEMALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.FEMALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(206)
    public void testExec_B26() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.HJN;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.MALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYASEIBETU_KYKCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(207)
    public void testExec_B27() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.HJN;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.HJNKYK);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(208)
    public void testExec_B28() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTHONNIN;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.HUMEI;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setKyksei(C_Kyksei.MALE);
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt1.setUktnmkn("カナ");
        siUkt1.setUktkbn(C_UktKbn.KYK);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(210)
    public void testExec_C1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.STDR;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.NONE);
        siKykKihon.setSiteidruktnmkn("カナ");
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAINFO_UMUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(220)
    public void testExec_C2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.STDR;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KOUSG;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.ARI);
        siKykKihon.setSiteidruktnmkn("カナ");
        siKykKihon.setSbuktnin(1);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(230)
    public void testExec_C3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.STDR;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.ARI);
        siKykKihon.setSiteidruktnmkn("");
        siKykKihon.setSbuktnin(2);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_UMUCHK_SITEIDR,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "指定代理人", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(240)
    public void testExec_C4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.STDR;
        String seikyuusyaNmkn = "セイキュウシャ";
        String seikyuusyaNmkj = "請求者";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setStdrsktkyhkumu(C_UmuKbn.ARI);
        siKykKihon.setSiteidruktnmkn("カナ");
        siKykKihon.setSbuktnin(2);
        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(250)
    public void testExec_D1() {

        changeSystemDate(BizDate.valueOf(20170905));
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(10);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(260)
    public void testExec_D2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(270)
    public void testExec_D3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKJ_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(280)
    public void testExec_D4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(290)
    public void testExec_D5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(300)
    public void testExec_D6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, false, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(310)
    public void testExec_D7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "ンン";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(30);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, false, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(311)
    public void testExec_D7_1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "せいきゆうしや　かな";
        String seikyuusyaNmkj = "請求者カナ";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(18);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, false, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(312)
    public void testExec_D7_2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウしヤ　カナ";
        String seikyuusyaNmkj = "請求者カナ";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(18);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYANMKNMEIGI_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, false, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(320)
    public void testExec_D8() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = null;
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(10);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIYMD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(330)
    public void testExec_D9() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(340)
    public void testExec_D10() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.BLNK;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIBETU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(350)
    public void testExec_D11() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20151113);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.KYH;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(360)
    public void testExec_D12() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.SONOTA;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(22220101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        YuyuBizConfig.getInstance().setKanaNmKyoyou(10);
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SEIYMD_SAKICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(370)
    public void testExec_D13() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.getSysDate();
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(380)
    public void testExec_D14() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.UKTDAIHYOU;
        String seikyuusyaNmkn = "セイキユウ　カナ";
        String seikyuusyaNmkj = "漢字";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(19990101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(2);
        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(410)
    public void testExec_E1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyaNmkn = "ケイヤクシャダイリ";
        String seikyuusyaNmkj = "契約者代理";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);

        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(420)
    public void testExec_E2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyaNmkn = "ケイヤクシャダイリ";
        String seikyuusyaNmkj = "契約者代理";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.NONE);
        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);

        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KYKDRTKYKHUKA_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(430)
    public void testExec_E3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyaNmkn = "ケイヤクシャダイリ";
        String seikyuusyaNmkj = "契約者代理";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.KYK);

        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

    @Test
    @TestOrder(440)
    public void testExec_E4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        C_SeikyuusyaKbn seikyuusyaKbn = C_SeikyuusyaKbn.KYKDAIRININ;
        String seikyuusyaNmkn = "ケイヤクシャダイリ";
        String seikyuusyaNmkj = "契約者代理";
        BizDate seikyuusyaSeiYmd = BizDate.valueOf(20150101);
        C_Seibetu seikyuusyaSei = C_Seibetu.MALE;
        C_SeikyuuSyubetu seikyuuSyubetu = C_SeikyuuSyubetu.SB;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSbuktnin(1);
        siKykKihon.setKykdrtkykhukaumu(C_UmuKbn.ARI);
        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);
        siUkt.setUktkbn(C_UktKbn.SBUK);

        boolean isCheckMeigininNmKana = chkSubSksyaInfo.exec(seikyuusyaKbn, seikyuusyaNmkn, seikyuusyaNmkj, seikyuusyaSeiYmd, seikyuusyaSei,
            seikyuuSyubetu, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KEIUKEDOU_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exBooleanEquals(isCheckMeigininNmKana, true, "カナ名義人チェック結果");
    }

}