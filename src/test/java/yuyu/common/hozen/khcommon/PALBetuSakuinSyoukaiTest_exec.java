package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMock;
import yuyu.def.MessageId;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NkSyoumetuCd;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＰＡＬ別口索引照会クラスのメソッド {@link PALBetuSakuinSyoukai#exec(String,C_SakuintsnTaisyouKbn,C_SakuintaisyoukykKbn)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class PALBetuSakuinSyoukaiTest_exec {

    @Inject
    private PALBetuSakuinSyoukai palBetuSakuinSyoukai;

    @BeforeClass
    public static void testInit() {

        BzSakuinTsnSyoukaiMqMock.caller = PALBetuSakuinSyoukaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMock.caller = null;
        BzSakuinTsnSyoukaiMqMock.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "1";

        String syoNo = "20000000086";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykmfkensuu(), 0, "ＰＡＬ契約ＭＦ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getSueokifkensuu(), 0, "ＰＡＬ据置Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkfkensuu(), 0, "ＰＡＬ年金Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKkkensuu(), 0, "契約保全個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuu(), 0, "年金支払個別項目設定件数");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ契約ＭＦ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ据置Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ年金Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.NONE, "契約保全件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.NONE, "年金支払件数超過有無区分");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList() == null, true, "ＰＡＬ契約ＭＦ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList() == null, true, "ＰＡＬ保険金据置Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList() == null, true, "ＰＡＬ総合年金支払Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList() == null, true, "契約保全索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList() == null, true, "年金支払契約索引結果Bean");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WIA1004, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "2";

        String syoNo = "12801345677";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykmfkensuu(), 0, "ＰＡＬ契約ＭＦ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getSueokifkensuu(), 0, "ＰＡＬ据置Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkfkensuu(), 0, "ＰＡＬ年金Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKkkensuu(), 0, "契約保全個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuu(), 0, "年金支払個別項目設定件数");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ契約ＭＦ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ据置Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ年金Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.NONE, "契約保全件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.NONE, "年金支払件数超過有無区分");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList() == null, true, "ＰＡＬ契約ＭＦ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList() == null, true, "ＰＡＬ保険金据置Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList() == null, true, "ＰＡＬ総合年金支払Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList() == null, true, "契約保全索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList() == null, true, "年金支払契約索引結果Bean");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WIA1005, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "ＰＡＬあて照会不可のため別契約が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "3";

        String syoNo = "12802345670";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykmfkensuu(), 0, "ＰＡＬ契約ＭＦ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getSueokifkensuu(), 0, "ＰＡＬ据置Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkfkensuu(), 0, "ＰＡＬ年金Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKkkensuu(), 0, "契約保全個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuu(), 0, "年金支払個別項目設定件数");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ契約ＭＦ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ据置Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ年金Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.NONE, "契約保全件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.NONE, "年金支払件数超過有無区分");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList() == null, true, "ＰＡＬ契約ＭＦ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList() == null, true, "ＰＡＬ保険金据置Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList() == null, true, "ＰＡＬ総合年金支払Ｆ索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList() == null, true, "契約保全索引結果Bean");
        exBooleanEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList() == null, true, "年金支払契約索引結果Bean");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WIA1006, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "ＰＡＬでの索引照会不可のため別契約が確認できません。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "4";

        String syoNo = "12803345673";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykmfkensuu(), 1, "ＰＡＬ契約ＭＦ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getSueokifkensuu(), 1, "ＰＡＬ据置Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkfkensuu(), 1, "ＰＡＬ年金Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKkkensuu(), 1, "契約保全個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuu(), 1, "年金支払個別項目設定件数");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.ARI, "ＰＡＬ契約ＭＦ件数超過有無区分");

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().size(), 1, "ＰＡＬ契約ＭＦ索引結果Bean");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().get(0).getPalBtkykSyoNo(), "12803345673", "（契約ＭＦ）証券番号");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().get(0).getPalBtkykKykYMD(), BizDate.valueOf(20160322), "（契約ＭＦ）契約日");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().get(0).getPalBtkykSymtCd(), "0001", "（契約ＭＦ）消滅コード");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList().get(0).getPalBtkykSymtYMD(), BizDate.valueOf(20160323), "（契約ＭＦ）消滅日");

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList().size(), 1, "ＰＡＬ保険金据置Ｆ索引結果Bean");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList().get(0).getPalBtkykSosysyNo(), "12803345673", "（据置Ｆ）据置証書番号");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList().get(0).getPalBtkykSosYMD(), BizDate.valueOf(20160322), "（据置Ｆ）据置開始日");

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().size(), 1, "ＰＡＬ総合年金支払Ｆ索引結果Bean");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().get(0).getPalBtkykNkSysyNo(), "12803345673", "（総年Ｆ）年金証書番号");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().get(0).getPalBtkykNkShrYMD(), BizDate.valueOf(20160322), "（総年Ｆ）初回年金支払日");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().get(0).getPalBtkykNkSymtCd(), "10", "（総年Ｆ）年金消滅コード");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList().get(0).getPalBtkykNkSymtYMD(), BizDate.valueOf(20160323), "（総年Ｆ）消滅日");

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().size(), 1, "契約保全索引結果Bean");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykSyoNo(), "12803345673", "（契約保全）証券番号");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykYuukSumtKbn(), C_YuukousyoumetuKbn.YUUKOU, "（契約保全）有効消滅区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "（契約保全）契約状態");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykKykYMD(), BizDate.valueOf(20160322), "（契約保全）契約日");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykSumetuJiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "（契約保全）消滅事由");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKykSyoumetuYMD(), BizDate.valueOf(20160323), "（契約保全）消滅日");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKhSyouhnCd(), "MD11", "（契約保全）商品コード");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKhsyouhnsdno().toString(), "18", "（契約保全）商品世代番号");

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().size(), 1, "年金支払契約索引結果Bean");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().get(0).getKykNkSysyNo(), "12803345673", "（年金支払）年金証書番号");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().get(0).getKykNkShrsYMD(), BizDate.valueOf(20160322), "（年金支払）年金支払開始日");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().get(0).getKykNkSymtJiyuu(), C_NkSyoumetuCd.SYUURYOU, "（年金支払）年金消滅コード");
        exDateEquals(palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList().get(0).getKykNkSymtYMD(), BizDate.valueOf(20160323), "（年金支払）消滅日");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WBA0012, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "5";

        String syoNo = "12804345676";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.ARI, "ＰＡＬ据置Ｆ件数超過有無区分");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WBA0012, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "6";

        String syoNo = "12805345679";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.ARI, "ＰＡＬ年金Ｆ件数超過有無区分");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WBA0012, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "7";

        String syoNo = "12806345672";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.ARI, "契約保全件数超過有無区分");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WBA0012, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "8";

        String syoNo = "12807345675";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.ARI, "年金支払件数超過有無区分");

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), false, "ワーニング有無フラグ");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgIdList().get(0), MessageId.WBA0012, "ワーニングメッセージIDリスト");
        exStringEquals(palBetuSakuinSyoukai.getWarningMsgList().get(0), "別契約欄に表示できない契約があります。索引照会で確認してください。", "ワーニングメッセージリスト");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "9";

        String syoNo = "12808345678";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ契約ＭＦ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ据置Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ年金Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.NONE, "契約保全件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.NONE, "年金支払件数超過有無区分");

        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(100)
    public void testExec_B1() {

        BzSakuinTsnSyoukaiMqMock.SYORIPTN = "10";

        String syoNo = "22806123457";

        boolean result = palBetuSakuinSyoukai.exec(syoNo, C_SakuintsnTaisyouKbn.KYK, C_SakuintaisyoukykKbn.TAISYOU_KYK);

        exBooleanEquals(palBetuSakuinSyoukai.getWarningUmuFlg(), true, "ワーニング有無フラグ");
        exNumericEquals(palBetuSakuinSyoukai.getWarningMsgIdList().size(), 0, "ワーニングメッセージIDリスト のサイズ");
        exNumericEquals(palBetuSakuinSyoukai.getWarningMsgList().size(), 0, "ワーニングメッセージリスト のサイズ");


        PALBetuSakuinSyoukaiKekkaBean palBetuSakuinSyoukaiKekkaBean = palBetuSakuinSyoukai.getPALBetuSakuinSyoukaiKekkaBean();

        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKykmfkensuu(), 3, "ＰＡＬ契約ＭＦ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getSueokifkensuu(), 3, "ＰＡＬ据置Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkfkensuu(), 3, "ＰＡＬ年金Ｆ個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getKkkensuu(), 3, "契約保全個別項目設定件数");
        exNumericEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuu(), 3, "年金支払個別項目設定件数");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalkykmfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ契約ＭＦ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalsueokifkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ据置Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getPalnkfkensuutyoukaumu(), C_UmuKbn.NONE, "ＰＡＬ年金Ｆ件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getHozenkensuutyoukaumu(), C_UmuKbn.NONE, "契約保全件数超過有無区分");
        exClassificationEquals(palBetuSakuinSyoukaiKekkaBean.getNkkensuutyoukaumu(), C_UmuKbn.NONE, "年金支払件数超過有無区分");

        List<PALKykMFSakuinKekkaBean> palKykMFSakuinKekkaBeanLst = palBetuSakuinSyoukaiKekkaBean.getPalKykMFSakuinKekkaBeanList();
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(0).getPalBtkykSyoNo(), "22806123457", "（契約ＭＦ）証券番号");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(0).getPalBtkykKykYMD(), BizDate.valueOf(20160420), "（契約ＭＦ）契約日");
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(0).getPalBtkykSymtCd(), "0001", "（契約ＭＦ）消滅コード");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(0).getPalBtkykSymtYMD(), BizDate.valueOf(20160421), "（契約ＭＦ）消滅日");
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(1).getPalBtkykSyoNo(), "22806123457", "（契約ＭＦ）証券番号");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(1).getPalBtkykKykYMD(), BizDate.valueOf(20160422), "（契約ＭＦ）契約日");
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(1).getPalBtkykSymtCd(), "0002", "（契約ＭＦ）消滅コード");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(1).getPalBtkykSymtYMD(), BizDate.valueOf(20160423), "（契約ＭＦ）消滅日");
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(2).getPalBtkykSyoNo(), "22806123457", "（契約ＭＦ）証券番号");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(2).getPalBtkykKykYMD(), BizDate.valueOf(20160424), "（契約ＭＦ）契約日");
        exStringEquals(palKykMFSakuinKekkaBeanLst.get(2).getPalBtkykSymtCd(), "0003", "（契約ＭＦ）消滅コード");
        exDateEquals(palKykMFSakuinKekkaBeanLst.get(2).getPalBtkykSymtYMD(), BizDate.valueOf(20160425), "（契約ＭＦ）消滅日");

        List<PALSueokiFSakuinKekkaBean> palSueokiFSakuinKekkaBeanLst = palBetuSakuinSyoukaiKekkaBean.getPalSueokiFSakuinKekkaBeanList();
        exStringEquals(palSueokiFSakuinKekkaBeanLst.get(0).getPalBtkykSosysyNo(), "22806123457", "（据置Ｆ）据置証書番号");
        exDateEquals(palSueokiFSakuinKekkaBeanLst.get(0).getPalBtkykSosYMD(), BizDate.valueOf(20160420), "（据置Ｆ）据置開始日");
        exStringEquals(palSueokiFSakuinKekkaBeanLst.get(1).getPalBtkykSosysyNo(), "22806123457", "（据置Ｆ）据置証書番号");
        exDateEquals(palSueokiFSakuinKekkaBeanLst.get(1).getPalBtkykSosYMD(), BizDate.valueOf(20160421), "（据置Ｆ）据置開始日");
        exStringEquals(palSueokiFSakuinKekkaBeanLst.get(2).getPalBtkykSosysyNo(), "22806123457", "（据置Ｆ）据置証書番号");
        exDateEquals(palSueokiFSakuinKekkaBeanLst.get(2).getPalBtkykSosYMD(), BizDate.valueOf(20160422), "（据置Ｆ）据置開始日");

        List<PALSouNenkinFSakuinKekkaBean> palSouNenkinFSakuinKekkaBeanLst = palBetuSakuinSyoukaiKekkaBean.getPalSouNenkinFSakuinKekkaBeanList();
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(0).getPalBtkykNkSysyNo(), "22806123457", "（総年Ｆ）年金証書番号");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(0).getPalBtkykNkShrYMD(), BizDate.valueOf(20160420), "（総年Ｆ）初回年金支払日");
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(0).getPalBtkykNkSymtCd(), "10", "（総年Ｆ）年金消滅コード");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(0).getPalBtkykNkSymtYMD(), BizDate.valueOf(20160423), "（総年Ｆ）消滅日");
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(1).getPalBtkykNkSysyNo(), "22806123457", "（総年Ｆ）年金証書番号");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(1).getPalBtkykNkShrYMD(), BizDate.valueOf(20160421), "（総年Ｆ）初回年金支払日");
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(1).getPalBtkykNkSymtCd(), "10", "（総年Ｆ）年金消滅コード");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(1).getPalBtkykNkSymtYMD(), BizDate.valueOf(20160424), "（総年Ｆ）消滅日");
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(2).getPalBtkykNkSysyNo(), "22806123457", "（総年Ｆ）年金証書番号");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(2).getPalBtkykNkShrYMD(), BizDate.valueOf(20160422), "（総年Ｆ）初回年金支払日");
        exStringEquals(palSouNenkinFSakuinKekkaBeanLst.get(2).getPalBtkykNkSymtCd(), "10", "（総年Ｆ）年金消滅コード");
        exDateEquals(palSouNenkinFSakuinKekkaBeanLst.get(2).getPalBtkykNkSymtYMD(), BizDate.valueOf(20160425), "（総年Ｆ）消滅日");

        List<KykSakuinKekkaBean> kykSakuinKekkaBeanLst = palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList();
        exStringEquals(kykSakuinKekkaBeanLst.get(0).getKykSyoNo(), "22806123457", "（契約保全）証券番号");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(0).getKykYuukSumtKbn(), C_YuukousyoumetuKbn.YUUKOU, "（契約保全）有効消滅区分");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(0).getKykKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "（契約保全）契約状態");
        exDateEquals(kykSakuinKekkaBeanLst.get(0).getKykKykYMD(), BizDate.valueOf(20160420), "（契約保全）契約日");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(0).getKykSumetuJiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "（契約保全）消滅事由");
        exDateEquals(kykSakuinKekkaBeanLst.get(0).getKykSyoumetuYMD(), BizDate.valueOf(20160424), "（契約保全）消滅日");
        exStringEquals(kykSakuinKekkaBeanLst.get(0).getKhSyouhnCd(), "MD11", "（契約保全）商品コード");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(0).getKhsyouhnsdno().toString(),
            "21", "（契約保全）商品世代番号");

        exStringEquals(kykSakuinKekkaBeanLst.get(1).getKykSyoNo(), "22806123457", "（契約保全）証券番号");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(1).getKykYuukSumtKbn(), C_YuukousyoumetuKbn.YUUKOU, "（契約保全）有効消滅区分");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(1).getKykKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "（契約保全）契約状態");
        exDateEquals(kykSakuinKekkaBeanLst.get(1).getKykKykYMD(), BizDate.valueOf(20160421), "（契約保全）契約日");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(1).getKykSumetuJiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "（契約保全）消滅事由");
        exDateEquals(kykSakuinKekkaBeanLst.get(1).getKykSyoumetuYMD(), BizDate.valueOf(20160425), "（契約保全）消滅日");
        exStringEquals(kykSakuinKekkaBeanLst.get(1).getKhSyouhnCd(), "MD11", "（契約保全）商品コード");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(1).getKhsyouhnsdno().toString(),
            "22", "（契約保全）商品世代番号");

        exStringEquals(kykSakuinKekkaBeanLst.get(2).getKykSyoNo(), "22806123457", "（契約保全）証券番号");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(2).getKykYuukSumtKbn(), C_YuukousyoumetuKbn.YUUKOU, "（契約保全）有効消滅区分");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(2).getKykKykJyoutai(), C_Kykjyoutai.HRKMTYUU, "（契約保全）契約状態");
        exDateEquals(kykSakuinKekkaBeanLst.get(2).getKykKykYMD(), BizDate.valueOf(20160423), "（契約保全）契約日");
        exClassificationEquals(kykSakuinKekkaBeanLst.get(2).getKykSumetuJiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "（契約保全）消滅事由");
        exDateEquals(kykSakuinKekkaBeanLst.get(2).getKykSyoumetuYMD(), BizDate.valueOf(20160426), "（契約保全）消滅日");
        exStringEquals(kykSakuinKekkaBeanLst.get(2).getKhSyouhnCd(), "MD11", "（契約保全）商品コード");
        exStringEquals(palBetuSakuinSyoukaiKekkaBean.getKykSakuinKekkaBeanList().get(2).getKhsyouhnsdno().toString(),
            "23", "（契約保全）商品世代番号");

        List<NenkinSakuinKekkaBean> nenkinSakuinKekkaBeanLst = palBetuSakuinSyoukaiKekkaBean.getNenkinSakuinKekkaBeanList();
        exStringEquals(nenkinSakuinKekkaBeanLst.get(0).getKykNkSysyNo(), "22806123457", "（年金支払）年金証書番号");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(0).getKykNkShrsYMD(), BizDate.valueOf(20160420), "（年金支払）年金支払開始日");
        exClassificationEquals(nenkinSakuinKekkaBeanLst.get(0).getKykNkSymtJiyuu(), C_NkSyoumetuCd.SYUURYOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(0).getKykNkSymtYMD(), BizDate.valueOf(20160423), "（年金支払）消滅日");
        exStringEquals(nenkinSakuinKekkaBeanLst.get(1).getKykNkSysyNo(), "22806123457", "（年金支払）年金証書番号");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(1).getKykNkShrsYMD(), BizDate.valueOf(20160421), "（年金支払）年金支払開始日");
        exClassificationEquals(nenkinSakuinKekkaBeanLst.get(1).getKykNkSymtJiyuu(), C_NkSyoumetuCd.SYUURYOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(1).getKykNkSymtYMD(), BizDate.valueOf(20160424), "（年金支払）消滅日");
        exStringEquals(nenkinSakuinKekkaBeanLst.get(2).getKykNkSysyNo(), "22806123457", "（年金支払）年金証書番号");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(2).getKykNkShrsYMD(), BizDate.valueOf(20160422), "（年金支払）年金支払開始日");
        exClassificationEquals(nenkinSakuinKekkaBeanLst.get(2).getKykNkSymtJiyuu(), C_NkSyoumetuCd.SYUURYOU, "（年金支払）年金消滅コード");
        exDateEquals(nenkinSakuinKekkaBeanLst.get(2).getKykNkSymtYMD(), BizDate.valueOf(20160425), "（年金支払）消滅日");

        exBooleanEquals(result, true, "処理結果");
    }
}
