package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Bnshrkaisuu;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;
import yuyu.def.classification.C_Nstknsyu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金請求チェックのメソッド{@link ChkSubNenkinSk#exec(BizDate, C_SUketoriHouhouKbn, C_Tkhukaumu, C_Nstknsyu, Integer, C_Bnshrkaisuu, BizCurrency, C_NkHaitoukinuketorihouKbn, BizDate, C_SeikyuuSyubetu, JT_SiKykKihon, List<ChkKekkaBean>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubNenkinSkTest_exec {
    @Inject
    private ChkSubNenkinSk chkSubNenkinSk;

    @Test
    @TestOrder(20)
    public void testExec_B1() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(100.005),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 5, "件数");
        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSYU_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SHRKKN_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(2);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BNSHRKAISUU_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(3);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKKKN_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(4);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HAITOUUKTR_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(30)
    public void testExec_B2() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(40)
    public void testExec_B3() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(100.005),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKKKN_CHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(50)
    public void testExec_B4() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.NONE, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 5, "件数");
        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSYU_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SHRKKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(2);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BNSHRKAISUU_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(3);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HAITOUUKTR_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(4);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_NASICHK_ZNITIIGAI, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(60)
    public void testExec_B5() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ITIBU_NENKIN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(100.005),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_B6() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ITIBU_NENKIN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, null, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 5, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSYU_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SHRKKN_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(2);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BNSHRKAISUU_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(3);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKKKN_CHK_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(4);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HAITOUUKTR_MINYUCHK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(80)
    public void testExec_C1() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.NONE, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_NASICHK_ZNITIIGAI , "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(90)
    public void testExec_C2() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(100)
    public void testExec_C3() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.NONE, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 4, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSYU_CHK , "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SHRKKN_CHK , "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(2);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BNSHRKAISUU_CHK , "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(3);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.HAITOUUKTR_CHK , "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(110)
    public void testExec_C5() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_ZNITII, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(120)
    public void testExec_C6() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ITIBU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(10),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(120)
    public void testExec_C7() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.BLNK, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, C_SeikyuuSyubetu.BLNK, siKykKihon,
            chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(130)
    public void testExec_D1() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);

        JT_SiUkt siUkt2 = siKykKihon.createSiUkt();
        siUkt2.setHkuktsyu(C_Hkuktsyu.KDSGHKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, BizDate.valueOf("20150228"), C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_UKTHUKUSUU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(140)
    public void testExec_D2() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_UKTHUKUSUU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(150)
    public void testExec_D3() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_UKTHUKUSUU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(160)
    public void testExec_D4() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ITIBU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(100),
            C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141116"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(170)
    public void testExec_D5() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(170)
    public void testExec_D6() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.BLNK, 0,
            C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_ZNITII, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(180)
    public void testExec_D7() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        JT_SiUkt siUkt1 = siKykKihon.createSiUkt();
        siUkt1.setHkuktsyu(C_Hkuktsyu.SBHKKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.NONE, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_NASICHK_ZNITIIGAI, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(190)
    public void testExec_D8() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

        siKykKihon.setNstkhkumu(C_UmuKbn.NONE);

        JT_SiUkt siUkt = siKykKihon.createSiUkt();
        siUkt.setHkuktsyu(C_Hkuktsyu.SBKYFKUKT);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN,
            C_Tkhukaumu.HUKA, C_Nstknsyu.KAKUTEINENKIN, 1,
            C_Bnshrkaisuu.NEN12KAI, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.KAIMASI, null, C_SeikyuuSyubetu.SB,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(200)
    public void testExec_E1() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN, null,
            C_Nstknsyu.BLNK, 0, C_Bnshrkaisuu.BLNK, BizCurrency.valueOf(0),
            C_NkHaitoukinuketorihouKbn.NONE, BizDate.valueOf("20141116"),
            C_SeikyuuSyubetu.KOUSG, siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NSTK_CHK_NKSYS, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(210)
    public void testExec_E2() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(null, C_SUketoriHouhouKbn.ZENGAKU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(0), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141116"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(220)
    public void testExec_E4() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151116"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(230)
    public void testExec_E5() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151115"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(240)
    public void testExec_E6() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151116"),
            C_SUketoriHouhouKbn.ZENGAKU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(0), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(250)
    public void testExec_E7() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20130228"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20120229"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(260)
    public void testExec_E8() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151115"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141116"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(270)
    public void testExec_E9() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(1);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20160229"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 1, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20150228"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(280)
    public void testExec_E10() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(12);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151116"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 10, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(290)
    public void testExec_E11() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(10);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151116"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 10, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(300)
    public void testExec_E12() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(3);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151116"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 2, C_Bnshrkaisuu.NEN1KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
        result = chkKekkaBeanLst.get(1);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_HENKOU, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(310)
    public void testExec_E13() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(12);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151115"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 10, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141115"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(320)
    public void testExec_E14() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(12);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151117"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 12, C_Bnshrkaisuu.NEN1KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141116"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");

        ChkKekkaBean result = chkKekkaBeanLst.get(0);
        exClassificationEquals(result.getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.NKSHR_KAISIGO_CHK_ITINK, "請求内容チェック区分");
        exStringEquals(result.getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(result.getMsgHikisuu2(), "一部年金", "メッセージ引数2");
        exStringEquals(result.getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(result.getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(result.getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(330)
    public void testExec_E15() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(12);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20151115"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 10, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20141116"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");
    }

    @Test
    @TestOrder(340)
    public void testExec_E16() {
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setNstkhkumu(C_UmuKbn.ARI);
        siKykKihon.setNkshrtkyknksyukkn(12);

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubNenkinSk.exec(BizDate.valueOf("20160228"),
            C_SUketoriHouhouKbn.ITIBU_NENKIN, null,
            C_Nstknsyu.KAKUTEINENKIN, 10, C_Bnshrkaisuu.NEN12KAI,
            BizCurrency.valueOf(10), C_NkHaitoukinuketorihouKbn.KAIMASI,
            BizDate.valueOf("20150228"), C_SeikyuuSyubetu.KOUSG,
            siKykKihon, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

        MockObjectManager.initialize();
    }
}
