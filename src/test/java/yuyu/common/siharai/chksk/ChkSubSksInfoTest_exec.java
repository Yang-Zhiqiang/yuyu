package yuyu.common.siharai.chksk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.BzGetBankDataMock;
import yuyu.common.biz.bzcommon.CheckKouzaNoMock;
import yuyu.common.biz.kaikei.BzShiharaiDenpyouDateShutokuMock;
import yuyu.common.siharai.sicommon.SetteiShrhousiteiKbnMock;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_InputShrhousiteiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuusyaKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 送金先情報チェックのメソッド{@link ChkSubSksInfo#exec(C_InputShrhousiteiKbn, String,String, C_YokinKbn,
 *                  String, C_Kzdou, String, C_Tuukasyu, String, List<ChkKekkaBean>)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class ChkSubSksInfoTest_exec extends AbstractTest{

    @Inject
    private ChkSubSksInfo chkSubSksInfo;

    private static Integer YenkaKouzaKetasuu;
    private static Integer GaikaKouzaKetasuu;
    private static Integer KzmeigiKanaNmKyoyou;

    @BeforeClass
    public static void testInit() {
        BzGetBankDataMock.caller = ChkSubSksInfoTest_exec.class;
        SetteiShrhousiteiKbnMock.caller = ChkSubSksInfoTest_exec.class;
        BzShiharaiDenpyouDateShutokuMock.caller = ChkSubSksInfoTest_exec.class;
        CheckKouzaNoMock.caller = ChkSubSksInfoTest_exec.class;
        YenkaKouzaKetasuu = YuyuBizConfig.getInstance().getYenkaKouzaKetasuu();
        GaikaKouzaKetasuu = YuyuBizConfig.getInstance().getGaikaKouzaKetasuu();
        KzmeigiKanaNmKyoyou = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();

    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzGetBankDataMock.caller = null;
        BzGetBankDataMock.SYORIPTN = null;
        SetteiShrhousiteiKbnMock.caller = null;
        SetteiShrhousiteiKbnMock.SYORIPTN = null;
        BzShiharaiDenpyouDateShutokuMock.caller = null;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = null;
        CheckKouzaNoMock.caller = null;
        CheckKouzaNoMock.SYORIPTN = null;
        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(YenkaKouzaKetasuu);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(GaikaKouzaKetasuu);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(KzmeigiKanaNmKyoyou);

    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        chkSubSksInfo.exec(C_InputShrhousiteiKbn.BLNK, "", "", null, "", null, "", null, "", null, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.ISHRHOUSITEIKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(20)
    public void testExec_B1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();
        ChkKekkaBean chkKekkaBean = new ChkKekkaBean();
        chkKekkaBean.setMsgHikisuu1("");
        chkKekkaBean.setMsgHikisuu2("");
        chkKekkaBean.setMsgHikisuu3("");
        chkKekkaBean.setMsgHikisuu4("");
        chkKekkaBean.setMsgHikisuu5("");
        chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK);
        chkKekkaBeanLst.add(chkKekkaBean);

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_ARI, "B001", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(30)
    public void testExec_B2() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "Z01", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(40)
    public void testExec_B3() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.HUTUU, "", C_Kzdou.BLNK, "",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(50)
    public void testExec_B4() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.BLNK, "S00000000001",
            C_Kzdou.BLNK, "", null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(60)
    public void testExec_B5() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "スミス",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(70)
    public void testExec_B6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.BLNK, "", C_Kzdou.DOUITU, "",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KRKKEIJYO_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(80)
    public void testExec_B7() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "",
            null, "", C_SeikyuusyaKbn.BLNK, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }

    @Test
    @TestOrder(90)
    public void testExec_C1() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "", C_Tuukasyu.JPY, "",
            C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 5, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BANKCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SITENCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.YOKINSYUMOKU_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(4).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZDOUKBN_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(100)
    public void testExec_C2() {
        changeSystemDate(BizDate.valueOf("20160321"));

        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN1;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN1;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN1;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(10);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(3);

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "0123456789A",
            C_Kzdou.SITEI, "コウザー　メイギニン", C_Tuukasyu.JPY, "請求者名", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);

        exDateEquals((BizDate) MockObjectManager.getArgument(BzShiharaiDenpyouDateShutokuMock.class, "exec", 0, 0),
            BizDate.getSysDate(), "処理年月日");
        exClassificationEquals((C_ShrhousiteiKbn) MockObjectManager.getArgument(BzShiharaiDenpyouDateShutokuMock.class, "exec", 0, 1),
            C_ShrhousiteiKbn.FB_YOKUJITU, "支払方法指定区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(BzShiharaiDenpyouDateShutokuMock.class, "exec", 0, 2),
            C_Tuukasyu.JPY, "通貨種類");
        exStringEquals((String) MockObjectManager.getArgument(BzShiharaiDenpyouDateShutokuMock.class, "exec", 0, 3),
            "9900", "銀行コード");

        String pBankCd = (String) MockObjectManager.getArgument(BzGetBankDataMock.class, "exec", 0, 0);
        exStringEquals(pBankCd, "9900", "銀行コード");
        String pSitenCd = (String) MockObjectManager.getArgument(BzGetBankDataMock.class, "exec", 0, 1);
        exStringEquals(pSitenCd, "1001", "支店コード");
        BizDate pKijyunYmd = (BizDate) MockObjectManager.getArgument(BzGetBankDataMock.class, "exec", 0, 2);
        exDateEquals(pKijyunYmd, BizDate.getSysDate().addBusinessDays(1), "基準日");

        exStringEquals((String) MockObjectManager.getArgument(CheckKouzaNoMock.class, "isCheckOK", 0, 0),
            "0123456789A", "口座番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CheckKouzaNoMock.class,"isCheckOK",  0, 1),
            C_Tuukasyu.JPY, "通貨種類");
        exStringEquals((String) MockObjectManager.getArgument(CheckKouzaNoMock.class, "isKyoyouKeta", 0, 0),
            "0123456789A", "口座番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CheckKouzaNoMock.class,"isKyoyouKeta",  0, 1),
            C_Tuukasyu.JPY, "通貨種類");

        exNumericEquals(chkKekkaBeanLst.size(), 7, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.GINKOUMST_UMUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KINYUKKN_YKCHK_SEYMD,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KINYUKKN_YKCHK_NAIKOKU,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_KYOKAMOJICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(4).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_KETACHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(4).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(5).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_KYOKAMOJICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(5).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(5).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(5).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(5).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(5).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(6).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_KETACHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(6).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(6).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(6).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(6).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(6).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(110)
    public void testExec_C3() {
        MockObjectManager.initialize();
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(50);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(50);
        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.TOUZA, "0123456789",
            C_Kzdou.SITEI, "", C_Tuukasyu.JPY, "ｶｶｶｶｶｶ", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.YOKINSYUMOKU_YUUTYOCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

        MockObjectManager.assertArgumentPassed(SetteiShrhousiteiKbnMock.class, "exec", 0, C_InputShrhousiteiKbn.FBSOUKIN);
        MockObjectManager.assertArgumentPassed(SetteiShrhousiteiKbnMock.class, "exec", 1, C_Tuukasyu.JPY);


    }

    @Test
    @TestOrder(120)
    public void testExec_C4(){
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(50);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(3);
        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "1111", "1001", C_YokinKbn.TOUZA, "0123456789",
            C_Kzdou.DOUITU, "", C_Tuukasyu.JPY, "セイキュウー　シャ", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK ,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_KETACHK ,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");



    }

    @Test
    @TestOrder(130)
    public void testExec_C5() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(50);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(12);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(50);
        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "1111", "1001", C_YokinKbn.TOUZA, "0123456789",
            C_Kzdou.DOUITU, "ｷｷｷｷｷ", C_Tuukasyu.JPY, "ｶｶｶｶｶ", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_INPUTCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK ,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(140)
    public void testExec_C6() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK, "", C_Tuukasyu.USD, "",
            C_SeikyuusyaKbn.KYKHONNIN, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 4, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BANKCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SITENCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_MINYUCHK_GAIKA,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");

    }

    @Test
    @TestOrder(150)
    public void testExec_C7() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN3;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(5);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(50);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(50);
        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "1111", "1001", C_YokinKbn.TOUZA, "0123456789",
            C_Kzdou.DOUITU, "AAAAA+", C_Tuukasyu.USD, "BBBBB+", C_SeikyuusyaKbn.KYKHONNIN, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.YOKINSYUMOKU_INPUTCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }

    @Test
    @TestOrder(160)
    public void testExec_C8() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN4;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN2;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN3;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        YuyuBizConfig.getInstance().setYenkaKouzaKetasuu(5);
        YuyuBizConfig.getInstance().setGaikaKouzaKetasuu(50);
        YuyuBizConfig.getInstance().setKzmeigiKanaNmKyoyou(50);

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "1111", "1001", C_YokinKbn.TOUZA, "0123456789",
            C_Kzdou.DOUITU, "AAAAA#",  C_Tuukasyu.USD, "BBBBB#", C_SeikyuusyaKbn.KYKHONNIN, chkKekkaBeanLst);
        exNumericEquals(chkKekkaBeanLst.size(), 4, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KINYUKKN_YKCHK_GSENM,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KZMEIGINM_KYOKAMOJICHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SKSYAKANA_MEIGINMKNCHK ,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.YOKINSYUMOKU_INPUTCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(170)
    public void testExec_C9() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "123", C_Kzdou.DOUITU, "",
            C_Tuukasyu.JPY, "セイキユウ　カナ", C_SeikyuusyaKbn.KYKDAIRININ, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 1, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KYKDRKZDOUKBN_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
    }


    @Test
    @TestOrder(180)
    public void testExec_C10() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "", C_Kzdou.DOUITU, "",
            C_Tuukasyu.JPY, "セイキユウ　カナ", C_SeikyuusyaKbn.KYKDAIRININ, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 2, "件数");

        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");

        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KYKDRKZDOUKBN_CHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");

    }


    @Test
    @TestOrder(190)
    public void testExec_C11() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "123", C_Kzdou.SITEI,
            "コウザ　メイギ", C_Tuukasyu.JPY, "セイキユウ　カナ", C_SeikyuusyaKbn.KYKDAIRININ, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(200)
    public void testExec_C12() {
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.KARIUKE_RISOKU_NASI, "", "", C_YokinKbn.BLNK, "", C_Kzdou.BLNK,
            "", C_Tuukasyu.JPY, "", C_SeikyuusyaKbn.KYKDAIRININ, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(210)
    public void testExec_C13() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "123", C_Kzdou.DOUITU, "",
            C_Tuukasyu.JPY, "セイキユウ　カナ", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(220)
    public void testExec_C14() {
        BzGetBankDataMock.SYORIPTN = BzGetBankDataMock.TESTPATTERN2;
        SetteiShrhousiteiKbnMock.SYORIPTN = SetteiShrhousiteiKbnMock.TESTPATTERN1;
        BzShiharaiDenpyouDateShutokuMock.SYORIPTN = BzShiharaiDenpyouDateShutokuMock.TESTPATTERN2;
        CheckKouzaNoMock.SYORIPTN = CheckKouzaNoMock.TESTPATTERN2;
        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "9900", "1001", C_YokinKbn.HUTUU, "123", C_Kzdou.SITEI,
            "コウザ　メイギ", C_Tuukasyu.JPY, "セイキユウ　カナ", C_SeikyuusyaKbn.UKTHONNIN, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 0, "件数");

    }


    @Test
    @TestOrder(300)
    public void testExec_D1() {

        List<ChkKekkaBean> chkKekkaBeanLst = new ArrayList<>();

        chkSubSksInfo.exec(C_InputShrhousiteiKbn.FBSOUKIN, "", "", C_YokinKbn.BLNK, "",
            C_Kzdou.DOUITU, "",  C_Tuukasyu.JPY, "ヅデド-　ヅデド", C_SeikyuusyaKbn.KYKHONNIN, chkKekkaBeanLst);

        exNumericEquals(chkKekkaBeanLst.size(), 4, "件数");
        exClassificationEquals(chkKekkaBeanLst.get(0).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.BANKCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(0).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(1).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.SITENCD_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(1).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(2).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.YOKINSYUMOKU_MINYUCHK ,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(2).getMsgHikisuu5(), "", "メッセージ引数5");
        exClassificationEquals(chkKekkaBeanLst.get(3).getSKNaiyouChkKbn(), C_SKNaiyouChkKbn.KOUZANO_MINYUCHK,
            "請求内容チェック区分");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu1(), "", "メッセージ引数1");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu2(), "", "メッセージ引数2");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu3(), "", "メッセージ引数3");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu4(), "", "メッセージ引数4");
        exStringEquals(chkKekkaBeanLst.get(3).getMsgHikisuu5(), "", "メッセージ引数5");
    }
}