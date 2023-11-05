package yuyu.common.sinkeiyaku.moschk;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.EditSecurityKm;
import yuyu.common.biz.bzcommon.Tuusan;
import yuyu.def.classification.C_AnkenJyoutaiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KnkysateijyouKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykSyubetuKbn;
import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;
import yuyu.def.classification.C_LinchhknseiKbn;
import yuyu.def.classification.C_LincjkKbn;
import yuyu.def.classification.C_LinckknnjkKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＬＩＮＣ受信結果判定クラスのメソッド {@link ＬＩＮＣ受信結果判定#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class HanteiLINCjyusinkekkaTest_exec {

    private final static String mosNo1 = "860000041";
    private final static String mosNo2 = "860000058";
    private final static String mosNo3 = "860000066";
    private final static String mosNo4 = "860000074";
    private final static String mosNo5 = "860000090";
    private final static String mosNo6 = "860000116";
    private final static String mosNo7 = "860000033";
    private final static String mosNo8 = "860000017";
    private final static String mosNo9 = "860000082";
    private final static String mosNo10 = "860000108";
    private final static String mosNo11 = "860000025";
    private final static String mosNo12 = "860000124";
    private final static String mosNo13 = "860000181";
    private final static String mosNo14 = "860000199";
    private final static String mosNo15 = "860000207";
    private final static String mosNo16 = "860000215";
    private final static String mosNo17 = "860000223";
    private final static String mosNo18 = "860000231";
    private final static String mosNo19 = "860000249";
    private final static String mosNo20 = "860000256";
    private final static String mosNo21 = "860000264";
    private final static String mosNo22 = "860000272";
    private final static String mosNo23 = "860000280";
    private final static String mosNo24 = "860000298";
    private final static String mosNo25 = "860000306";
    private final static String mosNo26 = "860000413";
    private final static String mosNo27 = "860000421";
    private final static String mosNo28 = "860000439";
    private final static String mosNo29 = "860000447";
    private final static String mosNo30 = "860000454";
    private final static String mosNo31 = "860000462";
    private final static String mosNo32 = "860000470";
    private final static String mosNo33 = "860000488";
    private final static String mosNo34 = "860000496";
    private final static String mosNo35 = "860000504";
    private final static String mosNo36 = "860000512";
    private final static String mosNo37 = "860000520";
    private final static String mosNo38 = "860000538";
    private final static String mosNo39 = "860000546";
    private final static String mosNo40 = "860000553";
    private final static String mosNo41 = "860000561";
    private final static String mosNo42 = "860000579";
    private final static String mosNo43 = "860000587";

    private final static String KANKYOUSATEICOMMENT = "ＬＩＮＣ照会結果が他社加入ありのため環境査定（２次Ａ）が必要です。";

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＬＩＮＣ受信結果判定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(HanteiLINCTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1()throws Exception {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo1);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() throws Exception {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo2);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        String className = "";

        try {
            HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
            hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。新契約ＬＩＮＣ受信データ（申込回答）異常 申込番号：860000058", "メッセージ内容");

    }
    @Test
    @TestOrder(30)
    public void testExec_A3() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo3);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);
        exStringEquals(syoriCTL.getMosno(), "860000066", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYANASI, "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINHUYOU, "ＬＩＮＣ確認状況区分");
    }
    @Test
    @TestOrder(40)
    public void testExec_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(mosNo4);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        String className = "";

        try {
            HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
            hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。新契約ＬＩＮＣ受信データ（名寄せ）異常 申込番号：860000074", "メッセージ内容");

    }
    @Test
    @TestOrder(50)
    public void testExec_A5() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo5);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000090", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateirrkumu(), C_UmuKbn.ARI, "環境査定履歴有無");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");
        exNumericEquals(syoriCTL.getKnksateiRirekis().get(1).getRenno() , 2, "連番");
        exDateEquals(syoriCTL.getKnksateiRirekis().get(1).getSyoriYmd() , BizDate.valueOf("20201221"), "処理年月日");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getSateiketsyorinmkbn() , C_SateiketsyorinmKbn.LINCKKA , "査定・決定処理名区分");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKnksateikekkakbn() , C_SyorikekkaKbn.TENSOU_KANKYOU_2A , "環境査定結果区分");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getTnsketsyacd() , "" , "転送先決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getKetsyacd() , "" , "決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getPalketsyacd() , "" , "ＰＡＬ決定者コード");
        exStringEquals(EditSecurityKm.getDecodeData(syoriCTL.getMosno(), syoriCTL.getKnksateiRirekis().get(1).getKnksateicomment()), KANKYOUSATEICOMMENT , "環境査定コメント");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetkekkacd() , C_Ketkekkacd.BLNK , "決定結果コード");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd1() , C_Ketriyuucd.BLNK , "決定理由コード１");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd2() , C_Ketriyuucd.BLNK , "決定理由コード2");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd3() , C_Ketriyuucd.BLNK , "決定理由コード3");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd4() , C_Ketriyuucd.BLNK , "決定理由コード4");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getTorikesisyousairiyuucd() , C_TorikesisyousairiyuuCd.BLNK , "取消詳細理由コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000090", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "24", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "ナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.SYUSSEIMAE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000104"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200104"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(103), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(203), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(303), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(403), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(503), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(603), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456792", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(60)
    public void testExec_A6() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo6);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.NONE);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

    }
    @Test
    @TestOrder(70)
    public void testExec_A7() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo7);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000033", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000033", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "27", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.MALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000106"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200106"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(105), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(205), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(305), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(405), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(505), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(605), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456794", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000033", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "27", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE , "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20000106"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200106"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(105), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(205), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(305), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(405), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(505), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(605), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456794", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getMosno() , "860000033", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getRenno() , 3, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsousinmotokaisya()  , "27", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinchhknseikbn() , C_LinchhknseiKbn.BLNK , "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKeiyakuymd() , BizDate.valueOf("20000106"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getTrkmousideymd() , BizDate.valueOf("20200106"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgnyung() , BizCurrency.valueOf(105), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSipnyung() , BizCurrency.valueOf(205), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSjnyung() , BizCurrency.valueOf(305), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSonotanyuinng(), BizCurrency.valueOf(405), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHutuusb(), BizCurrency.valueOf(505), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgsbksns(), BizCurrency.valueOf(605), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinckykkanrino() , "123456794", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

    }
    @Test
    @TestOrder(80)
    public void testExec_A8() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo8);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.NONE);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

    }
    @Test
    @TestOrder(90)
    public void testExec_A9() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo9);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);
    }
    @Test
    @TestOrder(100)
    public void testExec_A10() {
        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo10);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

    }
    @Test
    @TestOrder(110)
    public void testExec_A11() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo11);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000025", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateirrkumu(), C_UmuKbn.ARI, "環境査定履歴有無");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");
        exNumericEquals(syoriCTL.getKnksateiRirekis().get(0).getRenno() , 1, "連番");
        exDateEquals(syoriCTL.getKnksateiRirekis().get(0).getSyoriYmd() , BizDate.valueOf("20201221"), "処理年月日");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getSateiketsyorinmkbn() , C_SateiketsyorinmKbn.LINCKKA , "査定・決定処理名区分");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKnksateikekkakbn() , C_SyorikekkaKbn.TENSOU_KANKYOU_2A , "環境査定結果区分");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(0).getTnsketsyacd() , "" , "転送先決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(0).getKetsyacd() , "" , "決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(0).getPalketsyacd() , "" , "ＰＡＬ決定者コード");
        exStringEquals(EditSecurityKm.getDecodeData(syoriCTL.getMosno(), syoriCTL.getKnksateiRirekis().get(0).getKnksateicomment()), KANKYOUSATEICOMMENT , "環境査定コメント");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKetkekkacd() , C_Ketkekkacd.BLNK , "決定結果コード");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKetriyuucd1() , C_Ketriyuucd.BLNK , "決定理由コード１");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKetriyuucd2() , C_Ketriyuucd.BLNK , "決定理由コード2");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKetriyuucd3() , C_Ketriyuucd.BLNK , "決定理由コード3");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getKetriyuucd4() , C_Ketriyuucd.BLNK , "決定理由コード4");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(0).getTorikesisyousairiyuucd() , C_TorikesisyousairiyuuCd.BLNK , "取消詳細理由コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(0).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(0).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000025", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "31", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.SYUSSEIMAE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000110"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200110"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(109), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(209), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(309), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(409), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(509), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(609), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456798", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000025", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "31", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20000110"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200110"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(109), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(209), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(309), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(409), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(509), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(609), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456798", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

    }
    @Test
    @TestOrder(120)
    public void testExec_A12() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo12);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000124", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateijyoukbn(), C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateirrkumu(), C_UmuKbn.ARI, "環境査定履歴有無");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");
        exNumericEquals(syoriCTL.getKnksateiRirekis().get(1).getRenno() , 2, "連番");
        exDateEquals(syoriCTL.getKnksateiRirekis().get(1).getSyoriYmd() , BizDate.valueOf("20201221"), "処理年月日");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getSateiketsyorinmkbn() , C_SateiketsyorinmKbn.LINCKKA , "査定・決定処理名区分");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKnksateikekkakbn() , C_SyorikekkaKbn.TENSOU_KANKYOU_2A , "環境査定結果区分");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getTnsketsyacd() , "" , "転送先決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getKetsyacd() , "" , "決定者コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getPalketsyacd() , "" , "ＰＡＬ決定者コード");
        exStringEquals(EditSecurityKm.getDecodeData(syoriCTL.getMosno(), syoriCTL.getKnksateiRirekis().get(1).getKnksateicomment()), KANKYOUSATEICOMMENT , "環境査定コメント");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetkekkacd() , C_Ketkekkacd.BLNK , "決定結果コード");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd1() , C_Ketriyuucd.BLNK , "決定理由コード１");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd2() , C_Ketriyuucd.BLNK , "決定理由コード2");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd3() , C_Ketriyuucd.BLNK , "決定理由コード3");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getKetriyuucd4() , C_Ketriyuucd.BLNK , "決定理由コード4");
        exClassificationEquals(syoriCTL.getKnksateiRirekis().get(1).getTorikesisyousairiyuucd() , C_TorikesisyousairiyuuCd.BLNK , "取消詳細理由コード");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getKnksateiRirekis().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000124", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "32", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000111"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200111"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(110), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(210), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(310), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(410), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(510), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(610), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456799", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(130)
    public void testExec_A13() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo13);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000181", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000181", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

    }
    @Test
    @TestOrder(140)
    public void testExec_A14() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo14);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000199", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000199", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

    }
    @Test
    @TestOrder(150)
    public void testExec_A15() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo15);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000207", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000207", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(160)
    public void testExec_A16() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo16);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000215", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000215", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(170)
    public void testExec_A17() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo17);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000223", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000223", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(180)
    public void testExec_A18() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo18);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000231", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");
        exClassificationEquals(syoriCTL.getKnkysateijyoukbn() , C_KnkysateijyouKbn.SATEIMATI_2A, "環境査定状態区分");
        exClassificationEquals(syoriCTL.getKnkysateirrkumu(), C_UmuKbn.ARI, "環境査定履歴有無");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000231", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(190)
    public void testExec_A19() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo19);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000249", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000249", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(200)
    public void testExec_A20() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo20);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000256", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000256", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20000101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(210)
    public void testExec_A21() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo21);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000264", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000264", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201201"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201218"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(8000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(1000000), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000264", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "22", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20200101"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(1000000), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(220)
    public void testExec_A22() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo22);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000272", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000272", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(8999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(1000000), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");

    }
    @Test
    @TestOrder(230)
    public void testExec_A23() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo23);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000280", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000280", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() ,null, "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200527"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000280", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "21", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20200527"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200527"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getMosno() , "860000280", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getRenno() , 3, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsousinmotokaisya()  , "22", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKeiyakuymd() , BizDate.valueOf("20200527"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getTrkmousideymd() , BizDate.valueOf("20200527"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getMosno() , "860000280", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getRenno() , 4, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getLincsousinmotokaisya()  , "23", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(4).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(240)
    public void testExec_A24() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo24);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000298", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000298", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "25", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() ,BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000298", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200101"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getMosno() , "860000298", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getRenno() , 3, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsousinmotokaisya()  , "27", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getTrkmousideymd() , BizDate.valueOf("20200527"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(250)
    public void testExec_A25() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo25);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000306", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000306", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() ,BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(10000001), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(260)
    public void testExec_A26() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo26);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000413", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000413", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() ,BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(9999999), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(270)
    public void testExec_A27() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo27);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000421", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI , "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000421", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(10000000), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(280)
    public void testExec_A28() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo28);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000439", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000439", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(74999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(290)
    public void testExec_A29() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo29);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000447", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000447", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(75000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(300)
    public void testExec_A30() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo30);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000454", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000454", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(75000001), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(310)
    public void testExec_A31() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo31);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000462", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000462", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(124999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(320)
    public void testExec_A32() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo32);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000470", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000470", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(125000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(330)
    public void testExec_A33() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo33);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000488", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000488", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(125000001), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }

    @Test
    @TestOrder(340)
    public void testExec_A34() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo34);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000496", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000496", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(174999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(350)
    public void testExec_A35() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo35);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000504", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000504", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(175000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(360)
    public void testExec_A36() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo36);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000512", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000512", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(175000001), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(370)
    public void testExec_A37() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo37);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000520", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000520", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(249999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(380)
    public void testExec_A38() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo38);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000538", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000538", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(250000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(390)
    public void testExec_A39() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo39);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000546", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000546", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(250000001), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }

    @Test
    @TestOrder(400)
    public void testExec_A40() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo40);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000553", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINKANRYOUJIDOUKAIJO, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000553", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(249999999), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(410)
    public void testExec_A41() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo41);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000561", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000561", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(250000000), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(420)
    public void testExec_A42() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo42);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);
        Tuusan tuusan = SWAKInjector.getInstance(Tuusan.class);
        mosnaiCheckParam.setTuusan(tuusan);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000579", "申込番号");
        exClassificationEquals(syoriCTL.getKetteikbn(), C_KetteiKbn.NONE, "決定状態区分");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000579", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() , BizDate.valueOf("20201218"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20201201"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(250000001), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }
    @Test
    @TestOrder(430)
    public void testExec_A43() {

        HT_SyoriCTL syoriCTL =  sinkeiyakuDomManager.getSyoriCTL(mosNo43);

        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        mosnaiCheckParam.setHhknNayosejissiUmuKbnSeijyou(C_UmuKbn.ARI);
        mosnaiCheckParam.setSysDate(BizDate.valueOf(20201221));
        mosnaiCheckParam.setKosID("56510301");
        mosnaiCheckParam.setKosTime("20201127094946490");
        mosnaiCheckParam.setCheckspJissiUmuKbnSeijyou(C_UmuKbn.ARI);

        HanteiLINCjyusinkekka hanteiLINCjyusinkekka = SWAKInjector.getInstance(HanteiLINCjyusinkekka.class);
        hanteiLINCjyusinkekka.exec(mosnaiCheckParam);

        exStringEquals(syoriCTL.getMosno(), "860000587", "申込番号");
        exClassificationEquals(syoriCTL.getLincjkkbn(), C_LincjkKbn.KAITOARI_TASYAARI , "ＬＩＮＣ状況区分");
        exClassificationEquals(syoriCTL.getLinckknnjkkbn(), C_LinckknnjkKbn.KAKUNINMATI, "ＬＩＮＣ確認状況区分");

        exNumericEquals(syoriCTL.getSkLincTourokuInfo().getKanyuusyano() , Long.valueOf(12345678901L), "加入者番号");

        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getMosno() , "860000587", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getRenno() , 1, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsousinmotokaisya()  , "25", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKeiyakuymd() ,BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getTrkmousideymd() , BizDate.valueOf("20200526"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(1).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getMosno() , "860000587", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getRenno() , 2, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsousinmotokaisya()  , "26", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getTrkmousideymd() , BizDate.valueOf("20200528"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(2).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getMosno() , "860000587", "申込番号");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getRenno() , 3, "連番");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getAnkenjyoutai() , C_AnkenJyoutaiKbn.BLNK , "案件状態");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyksyubetu() , C_KykSyubetuKbn.BLNK , "契約種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsousinmotokaisya()  , "27", "ＬＩＮＣ＿送信元会社");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKykkbn() , C_KykKbn.BLNK , "契約者区分");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckn()  , "カナ", "契約者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKyknmlinckj()  , "漢字", "契約者名（ＬＩＮＣ用漢字）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckn()  , "カ", "被保険者名（ＬＩＮＣ用カナ）");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknnmlinckj()  , "漢", "被保険者名（ＬＩＮＣ用漢字）");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinchhknseikbn() , C_LinchhknseiKbn.FEMALE, "ＬＩＮＣ用被保険者性別区分");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknseiymd() , BizDate.valueOf("19960101"), "被保険者生年月日");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHhknadrlinckn30()  , "あ", "被保険者住所（ＬＩＮＣ用カナ）");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKeiyakuymd() , BizDate.valueOf("20200102"), "契約年月日");
        exDateEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getTrkmousideymd() , BizDate.valueOf("20200527"), "登録申出年月日");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgnyung() , BizCurrency.valueOf(100), "災害入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSipnyung() , BizCurrency.valueOf(200), "疾病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSjnyung() , BizCurrency.valueOf(300), "成人病入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSonotanyuinng(), BizCurrency.valueOf(400), "その他入院給付金日額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getHutuusb(), BizCurrency.valueOf(500), "普通死亡保険金額");
        exBizCalcbleEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getSgsbksns(), BizCurrency.valueOf(600), "災害死亡時加算保険金額");
        exNumericEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getKanyuusyano() , 12345678901L, "加入者番号");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLinckykkanrino() , "123456789", "ＬＩＮＣ＿契約管理番号");
        exClassificationEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getLincsyoukaisyubetu() , C_LincSyoukaiSyubetuKbn.HOKENKIN , "ＬＩＮＣ照会種別");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinsyaId() , "56510301" , "業務用更新者ＩＤ");
        exStringEquals(syoriCTL.getSkLincSyoukaikekkas().get(3).getGyoumuKousinTime(), "20201127094946490" , "業務用更新時間");
    }

}