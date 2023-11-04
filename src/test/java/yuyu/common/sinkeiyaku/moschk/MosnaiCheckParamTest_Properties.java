package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.def.MessageId;
import yuyu.def.classification.C_BosyuusysctrlKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_HandketsijiKbn;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KetsijisyoyhKbn;
import yuyu.def.classification.C_KetteiyouhiKbn;
import yuyu.def.classification.C_KktatkichkkekkaKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykkakiraisyoyhKbn;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_RiyousysKbn;
import yuyu.def.classification.C_SakuintsnKbn;
import yuyu.def.classification.C_SateikanKbn;
import yuyu.def.classification.C_SeihowebsousasyaKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SekmossakuseiKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_Tksytratkikjn;
import yuyu.def.classification.C_TsnchkptnKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteikykymdKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosnoKanri;
import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込内容チェック用パラメータクラスのメソッド {@link MosnaiCheckParam} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class  MosnaiCheckParamTest_Properties {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Test
    @TestOrder(10)
    public void testProperties_A1() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setCategoryID("moschk");
        String categoryID = mosnaiCheckParam.getCategoryID();

        exStringEquals(categoryID, "moschk", "カテゴリＩＤ");
    }

    @Test
    @TestOrder(20)
    public void testProperties_A2() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKinouID("MosnaiCheckParam");
        String kinouID = mosnaiCheckParam.getKinouID();

        exStringEquals(kinouID, "MosnaiCheckParam", "機能ＩＤ");
    }

    @Test
    @TestOrder(30)
    public void testProperties_A3() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        C_KetteiyouhiKbn ketteiYouhiKbn = mosnaiCheckParam.getKetteiYouhiKbn();

        exClassificationEquals(ketteiYouhiKbn, C_KetteiyouhiKbn.YOU, "決定要否区分");
    }

    @Test
    @TestOrder(40)
    public void testProperties_A4() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        C_SateikanKbn sateiKanryouKbn = mosnaiCheckParam.getSateiKanryouKbn();

        exClassificationEquals(sateiKanryouKbn, C_SateikanKbn.IMU, "査定完了区分");
    }

    @Test
    @TestOrder(50)
    public void testProperties_A5() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        C_SinkihnkKbn sinkiHnkKbn = mosnaiCheckParam.getSinkiHnkKbn();

        exClassificationEquals(sinkiHnkKbn, C_SinkihnkKbn.MEIGIINFOHENKOU, "新規変更区分");
    }

    @Test
    @TestOrder(60)
    public void testProperties_A6() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        C_KykKbn kykKbn_HnkMae = mosnaiCheckParam.getKykKbn_HnkMae();

        exClassificationEquals(kykKbn_HnkMae, C_KykKbn.KEIHI_BETU, "契約者区分（変更前）");
    }

    @Test
    @TestOrder(70)
    public void testProperties_A7() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        C_UmuKbn hhknTeisei = mosnaiCheckParam.getHhknTeisei();

        exClassificationEquals(hhknTeisei, C_UmuKbn.ARI, "被保険者訂正有無");

    }

    @Test
    @TestOrder(80)
    public void testProperties_A8() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        C_UmuKbn kykTeisei = mosnaiCheckParam.getKykTeisei();

        exClassificationEquals(kykTeisei, C_UmuKbn.ARI, "契約者訂正有無");
    }

    @Test
    @TestOrder(90)
    public void testProperties_A9() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.HIWEB_KANKYOUIMUSATEI);
        C_HandketsijiKbn ketteiSijiKbn = mosnaiCheckParam.getKetteiSijiKbn();

        exClassificationEquals(ketteiSijiKbn, C_HandketsijiKbn.HIWEB_KANKYOUIMUSATEI, "ハンド決定指示区分");
    }

    @Test
    @TestOrder(100)
    public void testProperties_A10() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykKakuninSyurui(C_Kykkaksyrui.KETHORYU);

        exClassificationEquals(mosnaiCheckParam.getKykKakuninSyurui(), C_Kykkaksyrui.KETHORYU, "契約確認種類");
    }

    @Test
    @TestOrder(110)
    public void testProperties_A11() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);

        exClassificationEquals(mosnaiCheckParam.getYoteiKykymdKbn(), C_YoteikykymdKbn.SITEI, "予定契約日区分");
    }

    @Test
    @TestOrder(120)
    public void testProperties_A12() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);

        exClassificationEquals(mosnaiCheckParam.getSysKbn(), C_SysKbn.SKEI, "システム区分");
    }

    @Test
    @TestOrder(130)
    public void testProperties_A13() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150606));

        exDateEquals(mosnaiCheckParam.getSysDate(), BizDate.valueOf(20150606), "システム処理日");
    }

    @Test
    @TestOrder(140)
    public void testProperties_A14() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setEshienRiyoumotoSysKbn(C_RiyousysKbn.BOSYUU);

        exClassificationEquals(mosnaiCheckParam.getEshienRiyoumotoSysKbn(), C_RiyousysKbn.BOSYUU, "システム区分");
    }

    @Test
    @TestOrder(150)
    public void testProperties_A15() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKosID("userid");

        exStringEquals(mosnaiCheckParam.getKosID(), "userid", "更新者ＩＤ");
    }

    @Test
    @TestOrder(160)
    public void testProperties_A16() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKosTime("20150529111400000");

        exStringEquals(mosnaiCheckParam.getKosTime(), "20150529111400000", "更新時間");
    }

    @Test
    @TestOrder(170)
    public void testProperties_A17() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKetteiSijisyoYouhiKbn(C_KetsijisyoyhKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getKetteiSijisyoYouhiKbn(), C_KetsijisyoyhKbn.HUYOU, "決定指示書要否区分");
    }

    @Test
    @TestOrder(190)
    public void testProperties_A19() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getKykKakuninIraisyoYouhiKbn(), C_KykkakiraisyoyhKbn.HUYOU, "契約確認依頼書要否区分");

    }

    @Test
    @TestOrder(220)
    public void testProperties_A22() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);

        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
    }

    @Test
    @TestOrder(230)
    public void testProperties_A23() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.ERROR);

        exClassificationEquals(mosnaiCheckParam.getChkKekkaKbn(), C_ChkkekkaKbn.ERROR, "チェック結果区分");
    }

    @Test
    @TestOrder(240)
    public void testProperties_A24() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.KKTJGSOV);

        exClassificationEquals(mosnaiCheckParam.getKokutiChkKekkaKbn(), C_KktatkichkkekkaKbn.KKTJGSOV, "告知扱チェック結果区分");
    }

    @Test
    @TestOrder(250)
    public void testProperties_A25() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKokutiChkHuyoUmu(), C_UmuKbn.ARI, "告知扱チェック不要有無");
    }

    @Test
    @TestOrder(260)
    public void testProperties_A26() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);

        exClassificationEquals(mosnaiCheckParam.getSakuinTsnKbn(), C_SakuintsnKbn.ERROR, "索引通算区分");
    }

    @Test
    @TestOrder(270)
    public void testProperties_A27() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "EAC0006";
        String msgId2 = "EAC0007";
        msgIdList.add(msgId);
        msgIdList.add(msgId2);

        mosnaiCheckParam.setListKetteiSijiMsgId(msgIdList);

        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(0), "EAC0006", "決定指示ＭＳＧＩＤ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsgId().get(1), "EAC0007", "決定指示ＭＳＧＩＤ");
    }

    @Test
    @TestOrder(280)
    public void testProperties_A28() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "決定指示ＭＳＧを指定してください。";
        String msgId2 = "抽出条件を設定してください。";
        msgIdList.add(msgId);
        msgIdList.add(msgId2);

        mosnaiCheckParam.setListKetteiSijiMsg(msgIdList);

        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(0), "決定指示ＭＳＧを指定してください。", "決定指示ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKetteiSijiMsg().get(1), "抽出条件を設定してください。", "決定指示ＭＳＧ");
    }

    @Test
    @TestOrder(290)
    public void testProperties_A29() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "決定指示ＭＳＧを指定してください。";
        String msgId2 = "抽出条件を設定してください。";
        msgIdList.add(msgId);
        msgIdList.add(msgId2);

        mosnaiCheckParam.setListKykKakuninMsg(msgIdList);

        exStringEquals(mosnaiCheckParam.getListKykKakuninMsg().get(0), "決定指示ＭＳＧを指定してください。", "契約確認ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKykKakuninMsg().get(1), "抽出条件を設定してください。", "契約確認ＭＳＧ");
    }

    @Test
    @TestOrder(300)
    public void testProperties_A30() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "決定指示ＭＳＧを指定してください。";
        String msgId2 = "抽出条件を設定してください。";
        msgIdList.add(msgId);
        msgIdList.add(msgId2);

        mosnaiCheckParam.setListKekkaGmnMsg(msgIdList);

        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(0), "決定指示ＭＳＧを指定してください。", "結果画面ＭＳＧ");
        exStringEquals(mosnaiCheckParam.getListKekkaGmnMsg().get(1), "抽出条件を設定してください。", "結果画面ＭＳＧ");
    }

    @Test
    @TestOrder(310)
    public void testProperties_A31() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("100000001");

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        exStringEquals(mosnaiCheckParam.getDataSyoriControl().getMosno(), "100000001", "申込番号");
    }

    @Test
    @TestOrder(360)
    public void testProperties_A36() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSetAiteSyuSyouhnCd("100001");

        exStringEquals(mosnaiCheckParam.getSetAiteSyuSyouhnCd(), "100001", "セット相手主契約商品コード");
    }

    @Test
    @TestOrder(370)
    public void testProperties_A37() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setTratkiAgCd("100001");

        exStringEquals(mosnaiCheckParam.getTratkiAgCd(), "100001", "取扱代理店コード");
    }

    @Test
    @TestOrder(380)
    public void testProperties_A38() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setTsnCheckPtnKbn(C_TsnchkptnKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getTsnCheckPtnKbn(), C_TsnchkptnKbn.HUYOU, "通算チェックパターン区分");
    }

    @Test
    @TestOrder(390)
    public void testProperties_A39() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMTB);

        exClassificationEquals(mosnaiCheckParam.getBosyuuSysCtrlKbn(), C_BosyuusysctrlKbn.SMTB, "募集システム制御区分");
    }

    @Test
    @TestOrder(400)
    public void testProperties_A40() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);

        exClassificationEquals(mosnaiCheckParam.getTksyTratkiKjn(), C_Tksytratkikjn.SAITEIP_KJNKANWA, "特殊取扱基準区分");
    }

    @Test
    @TestOrder(410)
    public void testProperties_A41() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKaiyakuDoujiSekUmu(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKaiyakuDoujiSekUmu(), C_UmuKbn.ARI, "解約同時申込設計有無");
    }

    @Test
    @TestOrder(460)
    public void testProperties_A46() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getFreeinsuranceUmu(), C_UmuKbn.ARI, "フリーインシュアランス該当有無");
    }

    @Test
    @TestOrder(470)
    public void testProperties_A47() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setCreditCardInfoTblChkErrUmu(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getCreditCardInfoTblChkErrUmu(), C_UmuKbn.ARI, "クレジットカード情報TBLチェックエラー有無");
    }

    @Test
    @TestOrder(480)
    public void testProperties_A48() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSaiteiPChkErrUmu(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getSaiteiPChkErrUmu(), C_UmuKbn.ARI, "最低保険料Lチェックエラー有無");
    }

    @Test
    @TestOrder(530)
    public void testProperties_A53() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSetAiteMosNo("104000001");
        String setAiteMosNo = mosnaiCheckParam.getSetAiteMosNo();

        exStringEquals(setAiteMosNo, "104000001", "セット相手申込番号");
    }

    @Test
    @TestOrder(540)
    public void testProperties_A54() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);

        exClassificationEquals(mosnaiCheckParam.getMosUketukeKbn(), C_MosUketukeKbn.MOSKIT, "申込受付区分");
    }

    @Test
    @TestOrder(550)
    public void testProperties_A55() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（MR）");
    }

    @Test
    @TestOrder(560)
    public void testProperties_A56() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
    }

    @Test
    @TestOrder(570)
    public void testProperties_A57() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（MR）");
    }

    @Test
    @TestOrder(580)
    public void testProperties_A58() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（シグナル）");
    }

    @Test
    @TestOrder(590)
    public void testProperties_A59() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
    }

    @Test
    @TestOrder(600)
    public void testProperties_A60() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（シグナル）");
    }

    @Test
    @TestOrder(610)
    public void testProperties_A61() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
    }

    @Test
    @TestOrder(620)
    public void testProperties_A62() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(630)
    public void testProperties_A63() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(640)
    public void testProperties_A64() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(650)
    public void testProperties_A65() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
    }

    @Test
    @TestOrder(660)
    public void testProperties_A66() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
    }

    @Test
    @TestOrder(670)
    public void testProperties_A67() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(680)
    public void testProperties_A68() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setListKkiykDoujiMosSyonoPal(null);

        exListEquals(mosnaiCheckParam.getListKkiykDoujiMosSyonoPal(), null, "既契約同時申込証券番号リスト（PAL）");
    }

    @Test
    @TestOrder(690)
    public void testProperties_A69() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setListSkDoujiMosMosnoPal(null);

        exListEquals(mosnaiCheckParam.getListSkDoujiMosMosnoPal(), null, "新契約同時申込申込番号リスト（PAL）");
    }

    @Test
    @TestOrder(710)
    public void testProperties_A71() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setFstnyknTyakkinYmd(BizDate.valueOf(20150706));

        exDateEquals(mosnaiCheckParam.getFstnyknTyakkinYmd(), BizDate.valueOf(20150706), "初回入金着金日");
    }


    @Test
    @TestOrder(720)
    public void testProperties_A72() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(123));

        exBizCalcbleEquals(mosnaiCheckParam.getNyuukinKawaseRate(), BizNumber.valueOf(123), "入金用為替レート");
    }

    @Test
    @TestOrder(730)
    public void testProperties_A73() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setGyoumuKouteiInfo(null);

        exBooleanEquals(mosnaiCheckParam.getGyoumuKouteiInfo() == null, true, "業務用工程情報テーブルエンティティ");
    }

    @Test
    @TestOrder(740)
    public void testProperties_A74() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setListHubiMsg(null);

        exListEquals(mosnaiCheckParam.getListHubiMsg(), null, "不備メッセージテーブルエンティティリスト");
    }

    @Test
    @TestOrder(750)
    public void testProperties_A75() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(123));

        exBizCalcbleEquals(mosnaiCheckParam.getNyuuryokuKawaseRate(), BizNumber.valueOf(123), "入力為替レート");
    }

    @Test
    @TestOrder(760)
    public void testProperties_A76() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);

        exBooleanEquals(mosnaiCheckParam.getNensyuTuusanSOverHanteiKekka(), true, "年収通算Ｓオーバー契約判定結果");
    }

    @Test
    @TestOrder(770)
    public void testProperties_A77() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(123));

        exBizCalcbleEquals(mosnaiCheckParam.getTsnketsibous(), BizCurrency.valueOf(123), "通算決定総死亡S");
    }

    @Test
    @TestOrder(780)
    public void testProperties_A78() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "EAC0006";
        msgIdList.add(msgId);
        mosnaiCheckParam.setListKetteiSijiMsgId(msgIdList);

        List<String> msgIdList2 = new ArrayList<>();
        String msgId2 = MessageId.EAC0007;
        msgIdList2.add(msgId2);
        mosnaiCheckParam.setListKetteiSijiMsg(msgIdList2);

        List<String> msgIdList3 = new ArrayList<>();
        String msgId3 = MessageId.EAC0008;
        msgIdList3.add(msgId3);
        mosnaiCheckParam.setListKykKakuninMsg(msgIdList3);

        List<String> msgIdList4 = new ArrayList<>();
        String msgId4 = MessageId.EAC0009;
        msgIdList4.add(msgId4);
        mosnaiCheckParam.setListKekkaGmnMsg(msgIdList4);

        List<String> kkiykDoujiMosSyonoPalList =  new ArrayList<>();
        kkiykDoujiMosSyonoPalList.add("10000000001");
        mosnaiCheckParam.setListKkiykDoujiMosSyonoPal(kkiykDoujiMosSyonoPalList);

        List<String> skDoujiMosMosnoPalList =  new ArrayList<>();
        skDoujiMosMosnoPalList.add("100000001");
        mosnaiCheckParam.setListSkDoujiMosMosnoPal(skDoujiMosMosnoPalList);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo.setKouteikanriid("10000000000000000001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg = new HT_HubiMsg();
        hubiMsg.setMosno("100000001");
        hubiMsgList.add(hubiMsg);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        HT_MosnoKanri mosnoKanri = new HT_MosnoKanri();
        mosnoKanri.setMosno8keta("10000001");
        mosnaiCheckParam.setMosnoKanri(mosnoKanri);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("100000001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("1000");
        syouhnZokuseiList.add(syouhnZokusei);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("8888");
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_SkDenpyoData> skDenpyoDataList = new ArrayList<>();
        HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
        skDenpyoData.setDenrenno("1000000001");
        skDenpyoDataList.add(skDenpyoData);
        mosnaiCheckParam.setListSkDenpyoData(skDenpyoDataList);

        mosnaiCheckParam.debug("プロパティ値ログ出力");
    }

    @Test
    @TestOrder(790)
    public void testProperties_A79() {
        mosnaiCheckParam.setCategoryID("moschk");
        mosnaiCheckParam.setKinouID("MosnaiCheckParam");
        mosnaiCheckParam.setKetteiYouhiKbn(C_KetteiyouhiKbn.YOU);
        mosnaiCheckParam.setSateiKanryouKbn(C_SateikanKbn.IMU);
        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKetteiSijiKbn(C_HandketsijiKbn.HIWEB_KANKYOUIMUSATEI);
        mosnaiCheckParam.setKykKakuninSyurui(C_Kykkaksyrui.KETHORYU);
        mosnaiCheckParam.setYoteiKykymdKbn(C_YoteikykymdKbn.SITEI);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20150606));
        mosnaiCheckParam.setEshienRiyoumotoSysKbn(C_RiyousysKbn.BOSYUU);
        mosnaiCheckParam.setKosID("userid");
        mosnaiCheckParam.setKosTime("20150529111400000");
        mosnaiCheckParam.setKetteiSijisyoYouhiKbn(C_KetsijisyoyhKbn.HUYOU);
        mosnaiCheckParam.setKykKakuninIraisyoYouhiKbn(C_KykkakiraisyoyhKbn.HUYOU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setChkKekkaKbn(C_ChkkekkaKbn.ERROR);
        mosnaiCheckParam.setKokutiChkKekkaKbn(C_KktatkichkkekkaKbn.KKTJGSOV);
        mosnaiCheckParam.setKokutiChkHuyoUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSakuinTsnKbn(C_SakuintsnKbn.ERROR);
        mosnaiCheckParam.setSetAiteSyuSyouhnCd("100002");
        mosnaiCheckParam.setTratkiAgCd("100003");
        mosnaiCheckParam.setTsnCheckPtnKbn(C_TsnchkptnKbn.HUYOU);
        mosnaiCheckParam.setBosyuuSysCtrlKbn(C_BosyuusysctrlKbn.SMTB);
        mosnaiCheckParam.setTksyTratkiKjn(C_Tksytratkikjn.SAITEIP_KJNKANWA);
        mosnaiCheckParam.setKaiyakuDoujiSekUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setFreeinsuranceUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setCreditCardInfoTblChkErrUmu(C_UmuKbn.ARI);
        mosnaiCheckParam.setSaiteiPChkErrUmu(C_UmuKbn.ARI);

        mosnaiCheckParam.setSetAiteMosNo("104000001");

        mosnaiCheckParam.setMosUketukeKbn(C_MosUketukeKbn.MOSKIT);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknItekisntkhndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setHhknTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setKykTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setUktTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setHhknKyhkinUktkAriItkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDoujiMosItekiHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setDoujiMosKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setFstnyknTyakkinYmd(BizDate.valueOf(20150706));

        mosnaiCheckParam.setNyuukinKawaseRate(BizNumber.valueOf(123));

        mosnaiCheckParam.setNyuuryokuKawaseRate(BizNumber.valueOf(123));

        mosnaiCheckParam.setNensyuTuusanSOverHanteiKekka(true);

        mosnaiCheckParam.setTsnketsibous(BizCurrency.valueOf(123));

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.SISAN);

        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);

        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(Integer.valueOf(2));

        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);

        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        mosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setPRate(BizNumber.valueOf(124));

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(125));

        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(126));

        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.GAMEN);

        mosnaiCheckParam.setSekmossakuseiErrmsg1("メッセージ１");

        mosnaiCheckParam.setSekmossakuseiErrmsg2("メッセージ２");

        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        mosnaiCheckParam.setSekmossakuseiOyaAgCd("7654321");

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANKA);

        mosnaiCheckParam.setSekmossakuseiNayoseHumeiKbn(C_UmuKbn.ARI);

        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        mosnaiCheckParam.debug("プロパティ値ログ出力");
    }

    @Test
    @TestOrder(800)
    public void testProperties_A80() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        List<String> msgIdList = new ArrayList<>();
        String msgId = "EAC0006";
        msgIdList.add(msgId);
        msgIdList.add(msgId);
        msgIdList.add(msgId);
        mosnaiCheckParam.setListKetteiSijiMsgId(msgIdList);

        List<String> msgIdList2 = new ArrayList<>();
        String msgId2 = MessageId.EAC0007;
        msgIdList2.add(msgId2);
        msgIdList2.add(msgId2);
        msgIdList2.add(msgId2);
        mosnaiCheckParam.setListKetteiSijiMsg(msgIdList2);

        List<String> msgIdList3 = new ArrayList<>();
        String msgId3 = MessageId.EAC0008;
        msgIdList3.add(msgId3);
        msgIdList3.add(msgId3);
        msgIdList3.add(msgId3);
        mosnaiCheckParam.setListKykKakuninMsg(msgIdList3);

        List<String> msgIdList4 = new ArrayList<>();
        String msgId4 = MessageId.EAC0009;
        msgIdList4.add(msgId4);
        msgIdList4.add(msgId4);
        msgIdList4.add(msgId4);
        mosnaiCheckParam.setListKekkaGmnMsg(msgIdList4);

        List<String> kkiykDoujiMosSyonoPalList =  new ArrayList<>();
        kkiykDoujiMosSyonoPalList.add("10000000001");
        kkiykDoujiMosSyonoPalList.add("10000000002");
        kkiykDoujiMosSyonoPalList.add("10000000003");
        mosnaiCheckParam.setListKkiykDoujiMosSyonoPal(kkiykDoujiMosSyonoPalList);

        List<String> skDoujiMosMosnoPalList =  new ArrayList<>();
        skDoujiMosMosnoPalList.add("100000001");
        skDoujiMosMosnoPalList.add("100000002");
        skDoujiMosMosnoPalList.add("100000003");
        mosnaiCheckParam.setListSkDoujiMosMosnoPal(skDoujiMosMosnoPalList);

        BT_GyoumuKouteiInfo gyoumuKouteiInfo = new BT_GyoumuKouteiInfo();
        gyoumuKouteiInfo.setKouteikanriid("10000000000000000001");
        mosnaiCheckParam.setGyoumuKouteiInfo(gyoumuKouteiInfo);

        List<HT_HubiMsg> hubiMsgList = new ArrayList<>();
        HT_HubiMsg hubiMsg = new HT_HubiMsg();
        hubiMsg.setMosno("100000001");
        HT_HubiMsg hubiMsg1 = new HT_HubiMsg();
        hubiMsg1.setMosno("100000002");
        HT_HubiMsg hubiMsg2 = new HT_HubiMsg();
        hubiMsg2.setMosno("100000003");
        hubiMsgList.add(hubiMsg);
        hubiMsgList.add(hubiMsg1);
        hubiMsgList.add(hubiMsg2);
        mosnaiCheckParam.setListHubiMsg(hubiMsgList);

        HT_MosnoKanri mosnoKanri = new HT_MosnoKanri();
        mosnoKanri.setMosno8keta("10000001");
        mosnaiCheckParam.setMosnoKanri(mosnoKanri);

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL();
        syoriCTL.setMosno("100000001");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        List<BM_SyouhnZokusei> syouhnZokuseiList = new ArrayList<>();
        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei2 = new BM_SyouhnZokusei();
        BM_SyouhnZokusei syouhnZokusei3 = new BM_SyouhnZokusei();
        syouhnZokusei.setSyouhncd("7777");
        syouhnZokusei2.setSyouhncd("8888");
        syouhnZokusei3.setSyouhncd("9999");
        syouhnZokuseiList.add(syouhnZokusei);
        syouhnZokuseiList.add(syouhnZokusei2);
        syouhnZokuseiList.add(syouhnZokusei3);
        mosnaiCheckParam.setListTkSyouhnZokusei(syouhnZokuseiList);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("6666");
        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        List<HT_SkDenpyoData> SkDenpyoDataList = new ArrayList<>();
        HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData();
        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData();
        skDenpyoData.setDenrenno("1000000001");
        skDenpyoData1.setDenrenno("1000000002");
        skDenpyoData2.setDenrenno("1000000003");
        SkDenpyoDataList.add(skDenpyoData);
        SkDenpyoDataList.add(skDenpyoData1);
        SkDenpyoDataList.add(skDenpyoData2);
        mosnaiCheckParam.setListSkDenpyoData(SkDenpyoDataList);

        mosnaiCheckParam.debug("プロパティ値ログ出力");
    }


    @Test
    @TestOrder(810)
    public void testProperties_A81() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiKbn(C_SekmossakuseiKbn.MOUSIKOMISYO);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiKbn(), C_SekmossakuseiKbn.MOUSIKOMISYO, "設計書申込書作成区分");
    }

    @Test
    @TestOrder(820)
    public void testProperties_A82() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiErroutKbn(C_SekmossakuseiErroutKbn.ERRORSHEET);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.ERRORSHEET, "設計書申込書作成エラー出力区分");
    }

    @Test
    @TestOrder(830)
    public void testProperties_A83() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiErrmsg1("エラーメッセージ１");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "エラーメッセージ１", "設計書申込書作成エラーメッセージ１");
    }

    @Test
    @TestOrder(840)
    public void testProperties_A84() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiErrmsg2("エラーメッセージ２");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "エラーメッセージ２", "設計書申込書作成エラーメッセージ２");
    }

    @Test
    @TestOrder(850)
    public void testProperties_A85() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiSousasyaKbn(C_SeihowebsousasyaKbn.SUPPORTDESK);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiSousasyaKbn(), C_SeihowebsousasyaKbn.SUPPORTDESK, "設計書申込書作成操作者区分");

        MockObjectManager.initialize();
    }

    @Test
    @TestOrder(860)
    public void testProperties_A86() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者選択情報反社有無区分（MR）");
    }

    @Test
    @TestOrder(870)
    public void testProperties_A87() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
    }

    @Test
    @TestOrder(880)
    public void testProperties_A88() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "受取人選択情報反社有無区分（MR）");
    }

    @Test
    @TestOrder(890)
    public void testProperties_A89() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者情報反社有無区分（シグナル）");
    }

    @Test
    @TestOrder(900)
    public void testProperties_A90() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
    }

    @Test
    @TestOrder(910)
    public void testProperties_A91() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "受取人情報反社有無区分（シグナル）");
    }

    @Test
    @TestOrder(920)
    public void testProperties_A92() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknSinsntkhnsyumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.ARI, "被保険者新選択情報反社有無区分");
    }

    @Test
    @TestOrder(930)
    public void testProperties_A93() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykSinsntkhnsyumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
    }

    @Test
    @TestOrder(940)
    public void testProperties_A94() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktSinsntkhnsyumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.ARI, "受取人新選択情報反社有無区分");
    }

    @Test
    @TestOrder(950)
    public void testProperties_A95() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktNayosehumeiuUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktNayosehumeiUmuKbn(), C_UmuKbn.ARI, "受取人名寄せ不明有無区分");
    }

    @Test
    @TestOrder(960)
    public void testProperties_A96() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        HT_MosnoKanri mosnoKanri = new HT_MosnoKanri();
        mosnoKanri.setMosno8keta("10000001");

        mosnaiCheckParam.setMosnoKanri(mosnoKanri);

        exStringEquals(mosnaiCheckParam.getMosnoKanri().getMosno8keta(), "10000001", "申込番号（８桁）");
    }

    @Test
    @TestOrder(970)
    public void testProperties_A97() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiOyaAgCd("1234567");

        exStringEquals(mosnaiCheckParam.getSekmossakuseiOyaAgCd(), "1234567", "設計書申込書作成親代理店コード");
    }

    @Test
    @TestOrder(980)
    public void testProperties_A98() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKthjiSpKeisanKahiKbn(C_SpKeisanKahiKbn.SPKEISANHUKA);

        exClassificationEquals(mosnaiCheckParam.getKthjiSpKeisanKahiKbn(), C_SpKeisanKahiKbn.SPKEISANHUKA, "決定保留時ＳＰ計算可否区分");
    }

    @Test
    @TestOrder(990)
    public void testProperties_A99() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiNayoseHumeiKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.ARI, "設計書申込書作成名寄せ不明区分");
    }

    @Test
    @TestOrder(1000)
    public void testProperties_A100() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        BM_SyouhnZokusei syuSyouhnZokusei = new BM_SyouhnZokusei();
        syuSyouhnZokusei.setSyouhncd("1001");

        mosnaiCheckParam.setSyuSyouhnZokusei(syuSyouhnZokusei);

        exStringEquals(mosnaiCheckParam.getSyuSyouhnZokusei().getSyouhncd(), "1001", "商品コード");
    }

    @Test
    @TestOrder(1010)
    public void testProperties_A101() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setListTkSyouhnZokusei(null);

        exListEquals(mosnaiCheckParam.getListTkSyouhnZokusei(), null, "特約商品属性マスタリスト");
    }


    @Test
    @TestOrder(1020)
    public void testProperties_A102() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKiteiCheckChannelCd(C_Channelcd.SMBC);

        exClassificationEquals(mosnaiCheckParam.getKiteiCheckChannelCd(), C_Channelcd.SMBC, "規定チェック用チャネルコード");
    }

    @Test
    @TestOrder(1030)
    public void testProperties_A103() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setBeforeCheckIkkatuyouptknKbn(C_IkkatuyouptknKbn.SYOURYAKU);

        exClassificationEquals(mosnaiCheckParam.getBeforeCheckIkkatuyouptknKbn(), C_IkkatuyouptknKbn.SYOURYAKU, "（チェック前）一括要Ｐ特認区分");
    }

    @Test
    @TestOrder(1040)
    public void testProperties_A104() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setBeforeCheckIkkatuyoupkaisuu(1);

        exBigDecimalEquals(BigDecimal.valueOf(mosnaiCheckParam.getBeforeCheckIkkatuyoupkaisuu()), BigDecimal.valueOf(1), "（チェック前）一括要Ｐ回数");
    }

    @Test
    @TestOrder(1050)
    public void testProperties_A105() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setSekmossakuseiHrksknnyrykUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiHrksknnyrykUmuKbn(), C_UmuKbn.ARI, "設計書申込書作成払込資金入力有無区分");
    }

    @Test
    @TestOrder(1060)
    public void testProperties_A106() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknGaikokupepsumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者外国ＰＥＰｓ有無区分");
    }

    @Test
    @TestOrder(1070)
    public void testProperties_A107() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykGaikokupepsumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者外国ＰＥＰｓ有無区分");
    }

    @Test
    @TestOrder(1080)
    public void testProperties_A108() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setUktGaikokupepsumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.ARI, "受取人外国ＰＥＰｓ有無区分");
    }

    @Test
    @TestOrder(1090)
    public void testProperties_A109() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setListSkDenpyoData(null);

        exListEquals(mosnaiCheckParam.getListSkDenpyoData(), null, "新契約伝票データテーブルエンティティリスト");
    }

    @Test
    @TestOrder(1100)
    public void testProperties_A110() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
    }

    @Test
    @TestOrder(1110)
    public void testProperties_A111() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
    }

    @Test
    @TestOrder(1120)
    public void testProperties_A112() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
    }

    @Test
    @TestOrder(1130)
    public void testProperties_A113() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiSntkinfohnsyUmuKbnMr(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
    }

    @Test
    @TestOrder(1140)
    public void testProperties_A114() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
    }

    @Test
    @TestOrder(1150)
    public void testProperties_A115() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiTratkityuiUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
    }

    @Test
    @TestOrder(1160)
    public void testProperties_A116() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
    }

    @Test
    @TestOrder(1170)
    public void testProperties_A117() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiInfohnsyUmuKbnSignal(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
    }

    @Test
    @TestOrder(1180)
    public void testProperties_A118() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiGaikokupepsumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
    }

    @Test
    @TestOrder(1190)
    public void testProperties_A119() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiGaikokupepsumukbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
    }

    @Test
    @TestOrder(1200)
    public void testProperties_A120() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
    }

    @Test
    @TestOrder(1210)
    public void testProperties_A121() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiSinsntkhnsyUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
    }

    @Test
    @TestOrder(1220)
    public void testProperties_A122() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(1230)
    public void testProperties_A123() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiTtdkTyuuiKnkHndktYhKbn(C_YouhiblnkKbn.HUYOU);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");
    }

    @Test
    @TestOrder(1240)
    public void testProperties_A124() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKykDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKykDairiNayosehumeiUmuKbn(), C_UmuKbn.ARI, "契約者代理人名寄せ不明有無区分");
    }

    @Test
    @TestOrder(1250)
    public void testProperties_A125() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknDairiNayosehumeiUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknDairiNayosehumeiUmuKbn(), C_UmuKbn.ARI, "被保険者代理人名寄せ不明有無区分");
    }

    @Test
    @TestOrder(1260)
    public void testProperties_A126() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.ARI, "被保険者名寄せ実施済有無区分（正常終了）");
    }

    @Test
    @TestOrder(1270)
    public void testProperties_A127() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getCheckspJissiUmuKbnSeijyou(), C_UmuKbn.ARI, "SPチェック実施済有無区分（正常終了）");
    }

    @Test
    @TestOrder(1280)
    public void testProperties_A128() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getNayoseKaihiUmuKbn(), C_UmuKbn.ARI, "名寄せ回避有無区分");
    }

    @Test
    @TestOrder(1290)
    public void testProperties_A129() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setPRate(BizNumber.valueOf(124));

        exBizCalcbleEquals(mosnaiCheckParam.getPRate(), BizNumber.valueOf(124), "Ｐレート");
    }

    @Test
    @TestOrder(1300)
    public void testProperties_A130() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setPdateSRate(BizNumber.valueOf(125));

        exBizCalcbleEquals(mosnaiCheckParam.getPdateSRate(), BizNumber.valueOf(125), "Ｐ建Ｓレート");
    }

    @Test
    @TestOrder(1310)
    public void testProperties_A131() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setHrbtJyousu(BizNumber.valueOf(126));

        exBizCalcbleEquals(mosnaiCheckParam.getHrbtJyousu(), BizNumber.valueOf(126), "払別乗数");
    }

    @Test
    @TestOrder(1320)
    public void testProperties_A132() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setTkrtkKinyuuknUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getTkrtkKinyuuknUmuKbn(), C_UmuKbn.ARI, "特例地域金融機関有無区分");
    }

    @Test
    @TestOrder(1330)
    public void testProperties_A133() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        mosnaiCheckParam.setKydsskKinyuuknUmuKbn(C_UmuKbn.ARI);

        exClassificationEquals(mosnaiCheckParam.getKydsskKinyuuknUmuKbn(), C_UmuKbn.ARI, "協同組織金融機関有無区分");
    }

    @Test
    @TestOrder(1340)
    public void testProperties_A134() {
        mosnaiCheckParam = SWAKInjector.getInstance(MosnaiCheckParam.class);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        if (mosnaiCheckParam.getTuusan() == null && tuusan == null) {
            return;
        }
        else if (mosnaiCheckParam.getTuusan() == null || tuusan == null) {
            fail("【" +"通算処理クラス" + "】[値の一方のみがNULL] 検証値：" + mosnaiCheckParam.getTuusan() + " 期待値：" + "通算処理クラス");
        }
        else if (!mosnaiCheckParam.getTuusan().equals(tuusan)) {
            fail("【" + "通算処理クラス" + "】[期待値違反] 検証値：" + mosnaiCheckParam.getTuusan() + " 期待値：" + "通算処理クラス");
        }
        assertEquals(mosnaiCheckParam.getTuusan(), tuusan);

    }
}