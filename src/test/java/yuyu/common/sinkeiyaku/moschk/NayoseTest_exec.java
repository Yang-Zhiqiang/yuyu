package yuyu.common.sinkeiyaku.moschk;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMqMockForSinkeiyaku;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.direct.dscommon.DsNayose;
import yuyu.common.direct.dscommon.DsNayoseMockForSinkeiyaku;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KouzokujkKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_NayoseJissiKekkaKbn;
import yuyu.def.classification.C_NayoseJyoutaiKbn;
import yuyu.def.classification.C_SakuintaisyoukykKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_SekmossakuseiErroutKbn;
import yuyu.def.classification.C_SinkihnkKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SntkinfoKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_HubiMsg;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_NayoseKekka;
import yuyu.def.db.entity.HT_SentakuJyouhou;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tuusan;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 名寄せ処理{@link Nayose#exec(MosnaiCheckParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class NayoseTest_exec {

    @Inject
    private MosnaiCheckParam mosnaiCheckParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private final static String fileName = "UT_SP_単体テスト仕様書_名寄せ処理";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(BzSakuinTsnSyoukaiMq.class).to(BzSakuinTsnSyoukaiMqMockForSinkeiyaku.class);
                bind(CheckDoujiMos.class).to(CheckDoujiMosMockForSinkeiyaku.class);
                bind(SetHubiMsg.class).to(SetHubiMsgMockForSinkeiyaku.class);
                bind(DsNayose.class).to(DsNayoseMockForSinkeiyaku.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(NayoseTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public static void testInit() {
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.caller = NayoseTest_exec.class;
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = null;
        CheckDoujiMosMockForSinkeiyaku.caller = NayoseTest_exec.class;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = null;
        SetHubiMsgMockForSinkeiyaku.caller = NayoseTest_exec.class;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
        DsNayoseMockForSinkeiyaku.caller = NayoseTest_exec.class;
        DsNayoseMockForSinkeiyaku.SYORIPTN = null;
    }

    @AfterClass
    public static void testClear() {
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.caller = null;
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = null;
        CheckDoujiMosMockForSinkeiyaku.caller = null;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = null;
        SetHubiMsgMockForSinkeiyaku.caller = null;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = null;
        DsNayoseMockForSinkeiyaku.caller = null;
        DsNayoseMockForSinkeiyaku.SYORIPTN = null;
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testExec_A1() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN1;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112220");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "メッセージ処理停止中", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.ARI, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.NONE, "設計書申込書作成名寄せ不明区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.ARI, "受取人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.NONE, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "カナ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "漢字", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), BizDate.valueOf("20150606"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "1140001", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "カナナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "漢字字", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "カナナナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "漢字字字", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "カナカナ", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "漢字漢字", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsintelno(), null, "通信先電話番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHrkkeiro(), null, "払込経路");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getBankcd(), "", "銀行番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getShitencd(), "", "支店番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKouzano(), "", "口座番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kykno(), "", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.YOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyounmkn(), "ナカ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyounmkj(), "字漢", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyouseiymd(), BizDate.valueOf("20150607"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "漢字", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "カナナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "漢字字", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "カナナナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "漢字字字", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "カナカナ", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "漢字漢字", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsghuho2kykno(), "", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTsntsghuho2kykno(), "", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getDrtentsntsghuho2kykno(), "", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean3 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyounmkn(), "カナ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyounmkj(), "漢字", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyouseiymd(), BizDate.valueOf("20150606"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn3(), "カナナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj3(), "漢字字", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn4(), "カナナナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj4(), "漢字字字", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn5(), "カナカナ", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj5(), "漢字漢字", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkininfosyoukaiyhkbn(), C_YouhiKbn.HUYOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.BLNK, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsghuho2kykno(), "", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getSkinkijyunymd(), null, "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.MOS_SAKUSEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTsntsghuho2kykno(), "", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getDrtentsntsghuho2kykno(), "", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EGA1036 メッセージ処理停止中", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112220", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn, C_TknKbn.NONE, "特認区分");

    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testExec_A2() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN2;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "メッセージ処理停止中", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.NONE, "設計書申込書作成名寄せ不明区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.NONE, "受取人外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");

    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testExec_A3() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "メッセージ処理停止中", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.NONE, "設計書申込書作成名寄せ不明区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        assertNull(tuusan);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testExec_A4() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN4;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.NONE, "設計書申込書作成名寄せ不明区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.NONE, "受取人外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testExec_A5() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN5;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.ARI, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.ARI, "設計書申込書作成名寄せ不明区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.NONE, "受取人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiNayosehumeiUmuKbn(), C_UmuKbn.NONE, "被保険者代理人名寄せ不明有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testExec_A6() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN3;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.ARI, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.ARI, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktNayosehumeiUmuKbn(), C_UmuKbn.ARI, "受取人名寄せ不明有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.ARI, "受取人外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112279", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "7894561230", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112279", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "7894561230", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "791112279", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.UKETORININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(2).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(2).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(2).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 3, "選択情報テーブル");
        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "791112279", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "791112279", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(1).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(2).getMosno(), "791112279", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.UKETORININ, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(2).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(2).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(2).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(2).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(22) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(23) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(24) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(999) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.ARI ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(25),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 4, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1020", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1020", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(2).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(2).getRenno(), 3, "連番");
        exStringEquals(hubiMsg.get(2).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(2).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(2).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(3).getMosno(), "791112279", "申込番号");
        exNumericEquals(hubiMsg.get(3).getRenno(), 4, "連番");
        exStringEquals(hubiMsg.get(3).getHubimsg(), "契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(3).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(3).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(3).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(3).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112279", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EHC1020 被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn1 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn1, C_TknKbn.NONE, "特認区分");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exStringEquals(hubiMsg2, "EHC1020 契約者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exStringEquals( mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp2.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp2.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp2.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 3);
        exClassificationEquals(tknKbn2, C_TknKbn.NONE, "特認区分");

        C_KetsrhkosKbn ketsrhkosKbn3 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 0);
        exClassificationEquals(ketsrhkosKbn3, C_KetsrhkosKbn.KETHORYU_HUBI, "ハンド決定要否照会要否区分");
        C_SpKeisanKahiKbn spkeisankahiKbn3 = (C_SpKeisanKahiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 1);
        exClassificationEquals(spkeisankahiKbn3, C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn3 = (C_HubisyubetusyousaiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 2);
        exClassificationEquals(hubisyubetusyousaiKbn3, C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        String hubiMsg3 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 3);
        exStringEquals(hubiMsg3, "EHC1018 被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp3 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 4);
        exStringEquals( mosnaiCheckParamtemp3.getDataSyoriControl().getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp3.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp3.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp3.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp3.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn3 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 5);
        exClassificationEquals(tknKbn3, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn3 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 2, 6);
        exClassificationEquals(msgKbn3, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn4 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 0);
        exClassificationEquals(ketsrhkosKbn4, C_KetsrhkosKbn.KETHORYU_HUBI, "ハンド決定要否照会要否区分");
        C_SpKeisanKahiKbn spkeisankahiKbn4 = (C_SpKeisanKahiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 1);
        exClassificationEquals(spkeisankahiKbn4, C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn4 = (C_HubisyubetusyousaiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 2);
        exClassificationEquals(hubisyubetusyousaiKbn4, C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        String hubiMsg4 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 3);
        exStringEquals(hubiMsg4, "EHC1018 契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp4 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 4);
        exStringEquals( mosnaiCheckParamtemp4.getDataSyoriControl().getMosno(), "791112279", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp4.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp4.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp4.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp4.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn4 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 5);
        exClassificationEquals(tknKbn4, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn4 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 3, 6);
        exClassificationEquals(msgKbn4, C_MsgKbn.ERROR, "メッセージ区分");

        MockObjectManager.assertArgumentPassed(DsNayoseMockForSinkeiyaku.class, "exec", 0, "ナカ");
        MockObjectManager.assertArgumentPassed(DsNayoseMockForSinkeiyaku.class, "exec", 1, "字漢");
        MockObjectManager.assertArgumentPassed(DsNayoseMockForSinkeiyaku.class, "exec", 2, BizDate.valueOf("20150606"));
        MockObjectManager.assertArgumentPassed(DsNayoseMockForSinkeiyaku.class, "exec", 3, "1234567");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "カナ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), BizDate.valueOf("20150606"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "1140001", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "カナカナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "カナカナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "791112279", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.SKEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "791112279", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kykno(), "", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd1(), "", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd2(), "", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyounmkn(), "ナカ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyounmkj(), "", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyouseiymd(), BizDate.valueOf("20150606"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナカナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "カナカナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getSkintsghuho2kykno(), "791112279", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.SKEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getTsntsghuho2kykno(), "", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.YOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getDrtentsntsghuho2kykno(), "791112279", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean2.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getDairitencd1(), "0061", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getDairitencd2(), "0063", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean2.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean3 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.MEIGISYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getHuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHuho2kykno(), "", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.BLNK, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyounmkn(), "カナカナ", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyounmkj(), "", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyouseiymd(), BizDate.valueOf("20150606"), "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTaisyouyno(), "1234567", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHhknyno(), "1140001", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn3(), "カナカナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn4(), "カナカナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getSkintsghuho2kykno(), "791112279", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.SKEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getTsngksyoukaiyhkbn(), C_YouhiKbn.HUYOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getTsntsghuho2kykno(), "", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.HUYOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.BLNK, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getDrtentsntsghuho2kykno(), "", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean3.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getDairitencd1(), "", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getDairitencd2(), "", "代理店コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean3.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");



    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testExec_A7() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN7;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN4;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.NONE, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 1, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112287", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "7894561230", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 1, "選択情報テーブル");
        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "791112287", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 2, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1019", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112287", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd1(), "0061", "代理店コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDairitencd2(), "", "代理店コード２");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112287", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EHC1019 別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112287", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4);
        exClassificationEquals(msgKbn, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.KETHORYU_HUBI, "ハンド決定要否照会要否区分");
        C_SpKeisanKahiKbn spkeisankahiKbn2 = (C_SpKeisanKahiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exClassificationEquals(spkeisankahiKbn2, C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn2 = (C_HubisyubetusyousaiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exClassificationEquals(hubisyubetusyousaiKbn2, C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        String hubiMsg2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 3);
        exStringEquals(hubiMsg2, "EHC1018 契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4);
        exStringEquals( mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "791112287", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp2.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp2.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp2.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 5);
        exClassificationEquals(tknKbn2, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn2 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 6);
        exClassificationEquals(msgKbn2, C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testExec_A8() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN8;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN5;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.ARI, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.ARI, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 1, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112295", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 3, "選択情報テーブル");
        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "791112295", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "1", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "791112295", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(1).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.ARI, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(2).getMosno(), "791112295", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(2).getSntkinfono(), "3", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(2).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(2).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(2).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(2).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 2, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112295", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1016", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "791112295", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112295", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EHC1016 別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "791112295", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn1 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn1, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn1 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 4);
        exClassificationEquals(msgKbn1, C_MsgKbn.ERROR, "メッセージ区分");

        C_KetsrhkosKbn ketsrhkosKbn2 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 0);
        exClassificationEquals(ketsrhkosKbn2, C_KetsrhkosKbn.KETHORYU_HUBI, "ハンド決定要否照会要否区分");
        C_SpKeisanKahiKbn spkeisankahiKbn2 = (C_SpKeisanKahiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 1);
        exClassificationEquals(spkeisankahiKbn2, C_SpKeisanKahiKbn.SPKEISANKA, "決定保留時ＳＰ計算可否区分");
        C_HubisyubetusyousaiKbn hubisyubetusyousaiKbn2 = (C_HubisyubetusyousaiKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 2);
        exClassificationEquals(hubisyubetusyousaiKbn2, C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        String hubiMsg2 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 3);
        exStringEquals(hubiMsg2, "EHC1018 被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp2 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 4);
        exStringEquals( mosnaiCheckParamtemp2.getDataSyoriControl().getMosno(), "791112295", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp2.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp2.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp2.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp2.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn2 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 5);
        exClassificationEquals(tknKbn2, C_TknKbn.NONE, "特認区分");
        C_MsgKbn msgKbn2 = (C_MsgKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 1, 6);
        exClassificationEquals(msgKbn2, C_MsgKbn.ERROR, "メッセージ区分");

    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testExec_A9() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN9;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN6;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.NONE, "受取人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.NONE, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112303", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分 ");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112303", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "791112303", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.UKETORININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(2).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(2).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(2).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112303", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1020", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112303", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "ds0001", "ＤＳ顧客番号");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "791112303", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp.getKosTime(), "20150604162000000", "更新時間");
        List<String> skDjmosNoLstRay = (List<String>)MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(skDjmosNoLstRay.get(0), "791112287", "新契約同時申込申込番号リスト（RAY）");
        List<String> skDjmosNoLstPal = (List<String>)MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals(skDjmosNoLstPal.get(0), "791112303", "新契約同時申込申込番号リスト（PAL）");

    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testExec_A10() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN10;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN7;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112311", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112311", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "791112311", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsnsyoukaikbn(), C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI, "索引通算照会区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHuho2kykno(), "791112311", "普保Ⅱ契約番号");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsntaisyoukbn(), C_SakuintsnTaisyouKbn.HHKN, "索引通算対象者区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkn(), "", "対象者氏名（カナ）");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyounmkj(), "", "対象者氏名（漢字）");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouseiymd(), null, "対象者生年月日");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTaisyouyno(), "", "対象者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKanrisosikicd2(), "", "管理組織コード２");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkininfosyoukaiyhkbn(), C_YouhiKbn.YOU, "索引情報照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintaisyoukykkbn(), C_SakuintaisyoukykKbn.TAISYOU_KYK_HHKN, " 索引対象契約区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, " 索引対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getSkintsghuho2kykno(), "791112311", " 索引対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getSkinkijyunymd(), BizDate.valueOf("20151118"), "索引基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalsyoukaiyhkbn(), C_YouhiKbn.YOU, " ＭＲシグナル照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMrsignalhanteigyoumukbn(), C_MrsignalhanteigyoumuKbn.SKEI, " ＭＲシグナル判定業務区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsngksyoukaiyhkbn(), C_YouhiKbn.YOU, "通算金額照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getTsntsghuho2kykno(), "791112311", " 通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getTsnkijyunymd(), null, "通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnsssyoukaiyhkbn(), C_YouhiKbn.YOU, "契約者同一代理店通算Ｓ照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kyknokbn(), C_Huho2kyknoKbn.MOSNO, "代理店通算対象外普保Ⅱ契約番号区分");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getDrtentsntsghuho2kykno(), "791112311", "代理店通算対象外普保Ⅱ契約番号");
        exDateEquals(bzSakuinTsnSyoukaiYokenBean.getKykdrtentsnkijyunymd(), null, "契約者同一代理店通算基準日");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getMossakuseikahisyoukaiyhkbn(), C_YouhiKbn.HUYOU, "申込書作成可否照会要否区分");
        exClassificationEquals(bzSakuinTsnSyoukaiYokenBean.getHndketyhsyoukaiyhkbn(), C_YouhiKbn.YOU, "ハンド決定要否照会要否区分");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112311", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testExec_A11() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN11;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN8;


        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.NONE, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 1, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112329", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");


        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 2, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112329", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＭＱ処理結果エラー）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1016", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exStringEquals(hubiMsg.get(1).getMosno(), "791112329", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "契約者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112329", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testExec_A12() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN12;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN10;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112337", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112337", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKU, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112337", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testExec_A13() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN13;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN9;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112345", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112345", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112345", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112345", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testExec_A14() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN14;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN10;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        assertNull(tuusan);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112352", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");

    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testExec_A15() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN14;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN10;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        assertNull(tuusan);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112360", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "", "ＤＳ顧客番号");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testExec_A16() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN5;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN2;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.NONE, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.ARI, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.ARI, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.ARI, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.ARI, "設計書申込書作成名寄せ不明区分");
        exClassificationEquals(mosnaiCheckParam.getHhknGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktGaikokupepsumukbn(), C_UmuKbn.ARI, "受取人外国ＰＥＰｓ有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testExec_A17() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN9;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN2;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN11;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "791112386", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分 ");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "791112386", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "791112386", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.UKETORININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(2).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.DOUITUARI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.MIRYOU, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(2).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(2).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(10) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(11) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(12) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(13) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(14) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(15) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(16) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(17) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(18) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(19) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(20) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(21) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(), C_UmuKbn.NONE ,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(), BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "791112386", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者が名寄せ不明です。ＰＡＬの照会機能にて確認を行なってください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1020", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "791112386", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "ds0001", "ＤＳ顧客番号");

        MosnaiCheckParam mosnaiCheckParamtemp = (MosnaiCheckParam) MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 0);
        exStringEquals( mosnaiCheckParamtemp.getDataSyoriControl().getMosno(), "791112386", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exStringEquals(mosnaiCheckParamtemp.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp.getKosTime(), "20150604162000000", "更新時間");

        List<String> skDjmosNoLstRay = (List<String>)MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(skDjmosNoLstRay.get(0), "791112287", "新契約同時申込申込番号リスト（RAY）");
        List<String> skDjmosNoLstPal = (List<String>)MockObjectManager.getArgument(CheckDoujiMosMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals(skDjmosNoLstPal.get(0), "791112303", "新契約同時申込申込番号リスト（PAL）");
    }

    @Test
    @Transactional
    @TestOrder(180)
    public void testExec_A18() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110005");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110005", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "7894561230", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110005", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "7894561230", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110005", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(2).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(2).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(2).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110005", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110005", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyscdkbn(), C_SysCdKbn.RAY, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(1).getMrumukbn(), C_BlnktkumuKbn.NONE, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getDecumukbn(), C_BlnktkumuKbn.NONE, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.NONE, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.NONE, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.NONE, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.NONE, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.NONE, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.NONE, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.NONE, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.NONE, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.ARI, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110005", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

    }

    @Test
    @Transactional
    @TestOrder(190)
    public void testExec_A19() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110013");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(),C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 4, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110013", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110013", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110013", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(3).getMosno(), "861110013", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(3).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 3, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110013", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110013", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");
        exStringEquals(sentakuJyouhouLst.get(2).getMosno(), "861110013", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110013", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean1 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj1(), "漢字", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn2(), "", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(200)
    public void testExec_A20() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110021");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110021", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110021", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110021", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110021", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110021", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110021", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(210)
    public void testExec_A21() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110039");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110039", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110039", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110039", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110039", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110039", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110039", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(220)
    public void testExec_A22() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110047");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110047", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110047", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110047", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(230)
    public void testExec_A23() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN1;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110054");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(240)
    public void testExec_A24() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110062");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110062", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110062", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110062", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110062", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110062", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");


        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110062", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(250)
    public void testExec_A25() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110070");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110070", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110070", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110070", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110070", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110070", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110070", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(260)
    public void testExec_A26() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110088");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110088", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110088", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110088", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110088", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110088", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110088", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(270)
    public void testExec_A27() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110096");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110096", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110096", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110096", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110096", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110096", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110096", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(280)
    public void testExec_A28() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN24;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110047");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getKykDairiNayosehumeiUmuKbn(), C_UmuKbn.ARI, "契約者代理人名寄せ不明有無区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiNayosehumeiUmuKbn(), C_UmuKbn.NONE, "被保険者代理人名寄せ不明有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 3, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKUIGAI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110047", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(2).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(2).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.BLNK, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.NAYOSEZUMI, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfomrumukbn(), C_BlnktkumuKbn.NONE, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalsetteiumukbn(), C_BlnktkumuKbn.NONE, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.NONE, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.NONE, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(2).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(2).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(2).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(2).getGaikokupepsumukbn(), C_BlnktkumuKbn.NONE, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 2, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "861110047", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(hubiMsg.get(1).getMosno(), "861110047", "申込番号");
        exNumericEquals(hubiMsg.get(1).getRenno(), 2, "連番");
        exStringEquals(hubiMsg.get(1).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(1).getHubisyubetukbn(), C_HubisyubetuKbn.KETHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(1).getMessageId(), "EHC1018", "メッセージＩＤ");

        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        HT_MosKihon mosKihon = syoriCTL.getMosKihon();
        exStringEquals(mosKihon.getMosno(), "861110047", "申込番号");
        exStringEquals(mosKihon.getDskokno(), "ds0001", "ＤＳ顧客番号");

    }

    @Test
    @Transactional
    @TestOrder(290)
    public void testExec_A29() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknItekisntkhndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者医的選択情報ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknKyhkinUktkAriItkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosItekiHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getDoujiMosKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "受取人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "受取人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiErroutKbn(), C_SekmossakuseiErroutKbn.GAMEN, "設計書申込書作成エラー出力区分");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg1(), "", "設計書申込書作成エラーメッセージ１");
        exStringEquals(mosnaiCheckParam.getSekmossakuseiErrmsg2(), "メッセージ処理停止中", "設計書申込書作成エラーメッセージ２");
        exClassificationEquals(mosnaiCheckParam.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exClassificationEquals(mosnaiCheckParam.getHhknSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknSinsntkhnsyumukbn(), C_UmuKbn.NONE, "被保険者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykSinsntkhnsyumukbn(), C_UmuKbn.NONE, "契約者新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getUktSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "受取人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getUktInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "受取人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getUktSinsntkhnsyumukbn(), C_UmuKbn.NONE, "受取人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getSekmossakuseiNayoseHumeiKbn(), C_UmuKbn.NONE, "設計書申込書作成名寄せ不明区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        assertNull(tuusan);

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(300)
    public void testExec_A30() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110104");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "トウロクカゾクカナ８", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "登録家族漢字８", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "トウロクカゾクカナ９", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "登録家族漢字９", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(310)
    public void testExec_A31() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110112");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "カナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "漢字", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "カナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "漢字", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(320)
    public void testExec_A32() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN1;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110120");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110120", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKU, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110120", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110120", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110120", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(1).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean1 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj1(), "漢字", "関係者氏名（漢字）１");

        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn2(), "トウロクカゾクカナ１", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj2(), "", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean1.getKankeinmkj5(), "", "関係者氏名（漢字）５");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");

    }


    @Test
    @Transactional
    @TestOrder(330)
    public void testExec_A33() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN1;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110138");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110138", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(0).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.YOU, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.YOU, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.YOU, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(0).getSirajikykkbn(), C_SirajiKykKbn.SIRAJIKEIYAKU, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(0).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(0).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110138", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(nayoseKekkaLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(nayoseKekkaLst.get(1).getSakuinnmno(), "", "索引名番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjissikekkakbn(), C_NayoseJissiKekkaKbn.NAYOSEHUMEI, "名寄せ実施結果区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getNysjyoutaikbn(), C_NayoseJyoutaiKbn.BLNK, "名寄せ状態区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSakuininfosyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "索引情報照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMrsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ＭＲ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "シグナル照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsysyoukaierrkbn(), C_MQSyoukaiErrorKbn.BLNK, "新選択情報反社照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTsngksyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "通算金額照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKykdrtentsnssyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "契約者同一代理店通算Ｓ照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getMossakuseikahisyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "申込書作成可否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getHndketyhsyoukaierrkbn(), C_MQSyoukaiErrorKbn.SYOUKAIERROR, "ハンド決定要否照会エラー区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfomrumukbn(), C_BlnktkumuKbn.ARI, "選択情報ＭＲ有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalsetteiumukbn(), C_BlnktkumuKbn.ARI, "シグナル設定有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSignalinfohnsyumukbn(), C_BlnktkumuKbn.ARI, "シグナル情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSinsntkhnsyumukbn(), C_BlnktkumuKbn.ARI, "新選択情報反社有無区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getItekisntkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "医的選択情報ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getTtdktyuuiknkhndktyhkbn(), C_YouhiblnkKbn.YOU, "手続注意環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getKyhkinuktkariitkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "給付金受付有医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimositekihndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込医的ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getDoujimosknkhndktyhkbn(), C_YouhiblnkKbn.BLNK, "同時申込環境ハンド決定要否区分");
        exClassificationEquals(nayoseKekkaLst.get(1).getSirajikykkbn(), C_SirajiKykKbn.HUMEI, "白地契約区分");
        exDateEquals(nayoseKekkaLst.get(1).getKikykinfoseiymd(), null, "既契約情報生年月日");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(nayoseKekkaLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");
        exClassificationEquals(nayoseKekkaLst.get(1).getGaikokupepsumukbn(), C_BlnktkumuKbn.ARI, "外国ＰＥＰｓ有無区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110138", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(0).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(0).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(0).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(0).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(0).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110138", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYADAIRININ, "選択情報対象者区分");
        exNumericEquals(sentakuJyouhouLst.get(1).getEdano(), 1, "枝番号");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfono(), "2", "選択情報番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyscdkbn(), C_SysCdKbn.PAL, "システムコード区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokankeisyakbn(), C_KankeisyaKbn.KYK, "選択情報関係者区分");
        exStringEquals(sentakuJyouhouLst.get(1).getSntkinfofkojinkbn(), "12", "選択情報Ｆ個人区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfokbn(), C_SntkinfoKbn.SEIRITU, "選択情報区分");
        exDateEquals(sentakuJyouhouLst.get(1).getSntkinfosakuseiymd(), BizDate.valueOf("20160509"), "選択情報作成日");
        exClassificationEquals(sentakuJyouhouLst.get(1).getMrumukbn(), C_BlnktkumuKbn.ARI, "ＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getDecumukbn(), C_BlnktkumuKbn.ARI, "ＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getInfokoukanumukbn(), C_BlnktkumuKbn.ARI, "情報交換有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getNyuuinkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "入院給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyujyutukyhkshrumukbn(), C_BlnktkumuKbn.ARI, "手術給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSyougaikyhkshrumukbn(), C_BlnktkumuKbn.ARI, "障害給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKoudosyougaiumukbn(), C_BlnktkumuKbn.ARI, "高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getPmenumukbn(), C_BlnktkumuKbn.ARI, "Ｐ免有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getTorikaijoumukbn(), C_BlnktkumuKbn.ARI, "取消解除有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSoukikeakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "早期ケア給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSonotakyhkshrumukbn(), C_BlnktkumuKbn.ARI, "その他給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getKghsjjtkyhkshrumukbn(), C_BlnktkumuKbn.ARI, "介護保障充実給付金支払有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2mrumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＭＲ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2decumukbn(), C_BlnktkumuKbn.NONE, "普保ⅡＤＥＣ有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2kdumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ高度障害有無区分");
        exClassificationEquals(sentakuJyouhouLst.get(1).getHuho2torikaijoumukbn(), C_BlnktkumuKbn.NONE, "普保Ⅱ取消解除有無区分");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(sentakuJyouhouLst.get(1).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

    }

    @Test
    @Transactional
    @TestOrder(340)
    public void testExec_A34() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110146");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "カナ", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "登録家族漢字８", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "カナ", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "登録家族漢字９", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(350)
    public void testExec_A35() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN3;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110153");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_DOUITU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.JIKKOU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 0, "名寄せ結果テーブル");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 0, "選択情報テーブル");

        HT_Tuusan tuusan = syoriCTL.getTuusan();
        exBizCalcbleEquals(tuusan.getTsnsibous(), BizCurrency.valueOf(0) ,"通算総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikas(), BizCurrency.valueOf(0) ,"通算２年未経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikas(), BizCurrency.valueOf(0) ,"通算２年経過総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenmikeikahtnkns(), BizCurrency.valueOf(0) ,"通算２年未経過被転換死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnninenkeikadfp(), BizCurrency.valueOf(0) ,"通算２年経過ＤＦＰ");
        exBizCalcbleEquals(tuusan.getTsnketsibous(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnketsibous2(), BizCurrency.valueOf(0) ,"通算決定総死亡Ｓ２");
        exBizCalcbleEquals(tuusan.getTsnsoukktjituhsgk(), BizCurrency.valueOf(0) ,"通算総告知書実保障額");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk1(), BizCurrency.valueOf(0) ,"通算告知書実保障額１");
        exBizCalcbleEquals(tuusan.getTsnkktjituhsgk2(), BizCurrency.valueOf(0) ,"通算告知書実保障額２");
        exBizCalcbleEquals(tuusan.getTsnkktitijibrsysnjs(), BizCurrency.valueOf(0) ,"通算告知書一時払終身等除Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnkgns(), BizCurrency.valueOf(0) ,"通算年金原資");
        exBizCalcbleEquals(tuusan.getTsnmsnynenbtsousbus(), BizCurrency.valueOf(0) ,"通算未成年用年齢別総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnnenbtitijibrssbs(), BizCurrency.valueOf(0) ,"通算年齢別一時払総死亡Ｓ");
        exBizCalcbleEquals(tuusan.getTsnitijibrsysnp(), BizCurrency.valueOf(0) ,"通算一時払終身Ｐ");
        exBizCalcbleEquals(tuusan.getTsnsntktuukahijynsysns(), BizCurrency.valueOf(0) ,"通算選択通貨建平準払終身Ｓ");
        exClassificationEquals(tuusan.getTsnkaigomehrtkumukbn(),C_UmuKbn.NONE,"通算介護前払特約有無区分");
        exBizCalcbleEquals(tuusan.getKykdrtentsns(),BizCurrency.valueOf(0),"契約者同一代理店通算Ｓ");
        exStringEquals(tuusan.getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(tuusan.getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 0, "件数");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "トウロクカゾクカナ８", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "漢字", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "トウロクカゾクカナ９", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "漢字", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(360)
    public void testExec_A36() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110161");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiNayosehumeiUmuKbn(), C_UmuKbn.NONE, "契約者代理人名寄せ不明有無区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.ARI, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.ARI, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.ARI, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.ARI, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.YOU, "被保険者代理人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiNayosehumeiUmuKbn(), C_UmuKbn.ARI, "被保険者代理人名寄せ不明有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 4, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110161", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110161", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(2).getMosno(), "861110161", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(3).getMosno(), "861110161", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(3).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 4, "選択情報テーブル");
        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110161", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110161", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(2).getMosno(), "861110161", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(2).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(3).getMosno(), "861110161", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(3).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYADAIRININ, "選択情報対象者区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "トウロクカゾクカナ８１", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "登録家族漢字８１", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "トウロクカゾクカナ８２", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "登録家族漢字８２", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "ウケトリニンメイカナ６１", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "受取人名漢字６１", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "漢字", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "トウロクカゾクカナ８１", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "登録家族漢字８１", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "トウロクカゾクカナ８２", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "登録家族漢字８２", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "ウケトリニンメイカナ６１", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "受取人名漢字６１", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean3 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 2, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn2(), "カナ", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj2(), "漢字", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn3(), "トウロクカゾクカナ８１", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj3(), "登録家族漢字８１", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn4(), "トウロクカゾクカナ８２", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj4(), "登録家族漢字８２", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean3.getKankeinmkj5(), "", "関係者氏名（漢字）５");

    }

    @Test
    @Transactional
    @TestOrder(370)
    public void testExec_A37() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110179");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.MEIGIINFOHENKOU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.ARI);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiNayosehumeiUmuKbn(), C_UmuKbn.NONE, "契約者代理人名寄せ不明有無区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiNayosehumeiUmuKbn(), C_UmuKbn.NONE, "被保険者代理人名寄せ不明有無区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110179", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110179", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 2, "選択情報テーブル");
        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110179", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(sentakuJyouhouLst.get(1).getMosno(), "861110179", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 0, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn1(), "ナカ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj1(), "字漢", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn2(), "トウロクカゾクカナ９１", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj2(), "登録家族漢字９１", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn3(), "トウロクカゾクカナ９２", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj3(), "登録家族漢字９２", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean.getKankeinmkj5(), "", "関係者氏名（漢字）５");

        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean2 = (BzSakuinTsnSyoukaiYokenBean) MockObjectManager.getArgument(BzSakuinTsnSyoukaiMqMock1ForSinkeiyaku.class, "exec", 1, 0);

        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn1(), "カナ", "関係者氏名（カナ）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj1(), "漢字", "関係者氏名（漢字）１");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn2(), "トウロクカゾクカナ９１", "関係者氏名（カナ）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj2(), "登録家族漢字９１", "関係者氏名（漢字）２");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn3(), "トウロクカゾクカナ９２", "関係者氏名（カナ）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj3(), "登録家族漢字９２", "関係者氏名（漢字）３");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn4(), "", "関係者氏名（カナ）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj4(), "", "関係者氏名（漢字）４");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkn5(), "", "関係者氏名（カナ）５");
        exStringEquals(bzSakuinTsnSyoukaiYokenBean2.getKankeinmkj5(), "", "関係者氏名（漢字）５");
    }

    @Test
    @Transactional
    @TestOrder(380)
    public void testExec_A38() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110187");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110187", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110187", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");


        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 1, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110187", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110187", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(390)
    public void testExec_A39() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110195");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110195", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110195", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 1, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110195", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110195", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(400)
    public void testExec_A40() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110203");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");

        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110203", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110203", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 1, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110203", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110203", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(410)
    public void testExec_A41() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN6;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("861110211");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "契約者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "契約者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getKykDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "契約者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "契約者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getKykDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "契約者代理人手続注意環境ハンド決定要否区分");

        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSntkinfohnsyUmuKbnMr(), C_UmuKbn.NONE, "被保険者代理人選択情報反社有無区分（MR）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTratkityuiUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人取扱注意情報有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiInfohnsyUmuKbnSignal(), C_UmuKbn.NONE, "被保険者代理人情報反社有無区分（シグナル）");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiGaikokupepsumukbn(), C_UmuKbn.NONE, "被保険者代理人外国ＰＥＰｓ有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiSinsntkhnsyUmuKbn(), C_UmuKbn.NONE, "被保険者代理人新選択情報反社有無区分");
        exClassificationEquals(mosnaiCheckParam.getHhknDairiTtdkTyuuiKnkHndktYhKbn(), C_YouhiblnkKbn.HUYOU, "被保険者代理人手続注意環境ハンド決定要否区分");

        List<HT_NayoseKekka> nayoseKekkaLst = syoriCTL.getNayoseKekkas();
        exNumericEquals(nayoseKekkaLst.size(), 2, "名寄せ結果テーブル");
        exStringEquals(nayoseKekkaLst.get(0).getMosno(), "861110211", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");
        exStringEquals(nayoseKekkaLst.get(1).getMosno(), "861110211", "申込番号");
        exClassificationEquals(nayoseKekkaLst.get(1).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.KEIYAKUSYA, "選択情報対象者区分");

        List<HT_SentakuJyouhou> sentakuJyouhouLst = syoriCTL.getSentakuJyouhous();
        exNumericEquals(sentakuJyouhouLst.size(), 1, "選択情報テーブル");

        exStringEquals(sentakuJyouhouLst.get(0).getMosno(), "861110211", "申込番号");
        exClassificationEquals(sentakuJyouhouLst.get(0).getSntkinfotaisyousyakbn(), C_SntkInfoTaisyousyaKbn.HIHOKENSYA, "選択情報対象者区分");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");

        exStringEquals(hubiMsg.get(0).getMosno(), "861110211", "申込番号");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "被保険者生年月日が索引結果と一致しません。入力内容に誤りがないかご確認ください。", "不備メッセージ");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1018", "メッセージＩＤ");

    }

    @Test
    @Transactional
    @TestOrder(420)
    public void testExec_A42() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000017");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.SINKIMOSNYUURYOKU);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setNayoseKaihiUmuKbn(C_UmuKbn.ARI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

    }

    @Test
    @Transactional
    @TestOrder(430)
    public void testExec_A43() {
        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN7;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        DsNayoseMockForSinkeiyaku.SYORIPTN = DsNayoseMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN12;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000025");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.SKEI);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setHhknTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKykTeisei(C_UmuKbn.NONE);
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.ARI, "被保険者名寄せ実施済有無区分（正常終了）");

        List<HT_HubiMsg> hubiMsg = syoriCTL.getHubiMsgs();
        exNumericEquals(hubiMsg.size(), 1, "件数");
        exStringEquals(hubiMsg.get(0).getMosno(), "860000025", "申込番号");
        exNumericEquals(hubiMsg.get(0).getRenno(), 1, "連番");
        exStringEquals(hubiMsg.get(0).getHubimsg(), "別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）", "不備メッセージ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetukbn(), C_HubisyubetuKbn.SRHORYU_HUBI, "不備種別区分");
        exStringEquals(hubiMsg.get(0).getMessageId(), "EHC1019", "メッセージＩＤ");
        exClassificationEquals(hubiMsg.get(0).getHubisyubetusyousaikbn(), C_HubisyubetusyousaiKbn.NONE, "不備種別詳細区分");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinsyaId(), "user001", "業務用更新者ＩＤ");
        exStringEquals(hubiMsg.get(0).getGyoumuKousinTime(), "20150604162000000", "業務用更新時間");

        C_KetsrhkosKbn ketsrhkosKbn1 = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn1, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EHC1019 別契約が確認できません。ＰＡＬの索引照会で確認してください。（ＰＡＬあて照会実施なし）", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000025", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.SKEI, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.JIKKOU, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn1 = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn1, C_TknKbn.NONE, "特認区分");
    }

    @Test
    @Transactional
    @TestOrder(440)
    public void testExec_A44() {

        Nayose nayose = SWAKInjector.getInstance(Nayose.class);
        MockObjectManager.initialize();
        BzSakuinTsnSyoukaiMqMockForSinkeiyaku.SYORIPTN = BzSakuinTsnSyoukaiMqMockForSinkeiyaku.TESTPATTERN2;
        CheckDoujiMosMockForSinkeiyaku.SYORIPTN = CheckDoujiMosMockForSinkeiyaku.TESTPATTERN1;
        SetHubiMsgMockForSinkeiyaku.SYORIPTN = SetHubiMsgMockForSinkeiyaku.TESTPATTERN1;

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("860000033");
        mosnaiCheckParam.setDataSyoriControl(syoriCTL);
        List<HT_HubiMsg> hubMsgLst = syoriCTL.getHubiMsgs();
        mosnaiCheckParam.setListHubiMsg(hubMsgLst);

        mosnaiCheckParam.setSinkiHnkKbn(C_SinkihnkKbn.BLNK);
        mosnaiCheckParam.setSysKbn(C_SysKbn.ESHIEN);
        mosnaiCheckParam.setKykKbn_HnkMae(C_KykKbn.KEIHI_BETU);
        mosnaiCheckParam.setKouzokuSyoriJikkouKbn(C_KouzokujkKbn.NONE);
        mosnaiCheckParam.setKosID("user001");
        mosnaiCheckParam.setSysDate(BizDate.valueOf("20151118"));
        mosnaiCheckParam.setKosTime("20150604162000000");
        nayose.exec(mosnaiCheckParam);

        exClassificationEquals(mosnaiCheckParam.getHhknNayosejissiUmuKbnSeijyou(), C_UmuKbn.ARI, "被保険者名寄せ実施済有無区分（正常終了）");

        C_KetsrhkosKbn ketsrhkosKbn = (C_KetsrhkosKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 0);
        exClassificationEquals(ketsrhkosKbn, C_KetsrhkosKbn.SRHORYU_HUBI, "ハンド決定要否照会要否区分");
        String hubiMsg1 = (String) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 1);
        exStringEquals(hubiMsg1, "EGA1036 メッセージ処理停止中", "メッセージ文言");
        MosnaiCheckParam mosnaiCheckParamtemp1 = (MosnaiCheckParam) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 2);
        exStringEquals( mosnaiCheckParamtemp1.getDataSyoriControl().getMosno(), "860000033", "申込番号");
        exClassificationEquals(mosnaiCheckParamtemp1.getSysKbn(), C_SysKbn.ESHIEN, "システム区分");
        exClassificationEquals(mosnaiCheckParamtemp1.getKouzokuSyoriJikkouKbn(), C_KouzokujkKbn.NONE, "後続処理実行区分");
        exStringEquals(mosnaiCheckParamtemp1.getKosID(), "user001", "更新者ＩＤ");
        exStringEquals(mosnaiCheckParamtemp1.getKosTime(), "20150604162000000", "更新時間");
        C_TknKbn tknKbn = (C_TknKbn) MockObjectManager.getArgument(SetHubiMsgMockForSinkeiyaku.class, "exec", 0, 3);
        exClassificationEquals(tknKbn, C_TknKbn.NONE, "特認区分");

    }
}
