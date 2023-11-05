package yuyu.common.direct.dscommon;

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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForDirect;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForDirect;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ契約詳細取得クラスのメソッド {@link DsGetKeiyakuSyousai#exec(String pSyoNo} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuSyousaiTest2_exec extends AbstractTest{

    @Inject
    private DsGetKeiyakuSyousai dsGetKeiyakuSyousai;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ契約詳細取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForDirect.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        CalcHkShrKngkMockForDirect.caller = DsGetKeiyakuSyousaiTest_exec.class;
        KeisanGaikakanzanMockForDirect.caller = DsGetKeiyakuSyousaiTest_exec.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        CalcHkShrKngkMockForDirect.caller = null;
        CalcHkShrKngkMockForDirect.SYORIPTN = null;
        KeisanGaikakanzanMockForDirect.caller = null;
        KeisanGaikakanzanMockForDirect.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuSyousaiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(220)
    public void testExec_B1() {
        changeSystemDate(BizDate.valueOf(2016, 11, 18));
        CalcHkShrKngkMockForDirect.SYORIPTN = CalcHkShrKngkMockForDirect.TESTPATTERN5;
        KeisanGaikakanzanMockForDirect.SYORIPTN = KeisanGaikakanzanMockForDirect.TESTPATTERN1;
        String syoNo = "11807111233";

        DsKeiyakuSyousaiBean dsKeiyakuSyousaiBean = dsGetKeiyakuSyousai.exec(syoNo);

        exStringEquals(dsKeiyakuSyousaiBean.getSyono(), "11807111233", "証券番号");
        exStringEquals(dsKeiyakuSyousaiBean.getSyouhnnm(), "証券用商品名", "商品名");
        exStringEquals(dsKeiyakuSyousaiBean.getHhknnmkn(), "アイ", "被保険者名（カナ）");
        exDateEquals(dsKeiyakuSyousaiBean.getHhknseiYmd(), BizDate.valueOf("19811010"), "被保険者生年月日");
        exDateEquals(dsKeiyakuSyousaiBean.getKykymd(), BizDate.valueOf("20160229"), "契約日");
        exClassificationEquals(dsKeiyakuSyousaiBean.getTutakinUmukbn(), C_UmuKbn.ARI, "積立金有無区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getSbhsyUmukbn(), C_UmuKbn.ARI, "死亡保障有無区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKghsyUmukbn(), C_UmuKbn.NONE, "介護保障有無区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getIryhsyUmukbn(), C_UmuKbn.NONE, "医療保障有無区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getRougohsyUmukbn(), C_UmuKbn.NONE, "老後保障有無区分");
        exDateEquals(dsKeiyakuSyousaiBean.getSakuseiKijyunymd(), BizDate.valueOf("20161118"), "作成基準日");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getSksiKijyunymdKawaseRate(), BizNumber.valueOf(1.3), "作成基準日為替レート");
        exDateEquals(dsKeiyakuSyousaiBean.getKwsrateKijyunymdSakusei(), BizDate.valueOf(20161118), "為替レート基準日（作成基準日）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getPtumitaTekinYen(), BizCurrency.valueOf(102), "保険料積立金（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getPtumitaTekinKyktuuka(), BizCurrency.valueOf(101.9), "保険料積立金（契約通貨）");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exClassificationEquals(dsKeiyakuSyousaiBean.getRstuukasyu(), C_Tuukasyu.JPY, "領収通貨種類");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getKaiyakuHrkeiYen(), BizCurrency.valueOf(202), "解約返戻金額（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getKaiyakuHrkeiKyktuuka(), BizCurrency.valueOf(201.9), "解約返戻金額（契約通貨）");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKaiyakuhrsuiiUmukbn(), C_UmuKbn.NONE, "解約返戻金推移有無区分");
        exStringEquals(dsKeiyakuSyousaiBean.getAisyoumei(), "笑顔の約束", "愛称名");
        exStringEquals(dsKeiyakuSyousaiBean.getKyknmkn(), "ホホ", "契約者名（カナ）");
        exStringEquals(dsKeiyakuSyousaiBean.getKyknmkj(), "契約者名", "契約者名（漢字）");
        exDateEquals(dsKeiyakuSyousaiBean.getKykseiymd(), BizDate.valueOf("19821111"), "契約者生年月日");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKyksei(), C_Kyksei.MALE, "契約者性別");
        exNumericEquals(dsKeiyakuSyousaiBean.getSbuktnin(), 1, "死亡受取人人数");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn1(), C_UktsyuKbn.STDRSK, "受取人見出し区分１");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn1(), C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI, "受取人区分１");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm1(), "ホホ", "受取人名１");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn2(), C_UktsyuKbn.STDRSK, "受取人見出し区分２");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn2(), C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI, "受取人区分２");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm2(), "", "受取人名２");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn3(), C_UktsyuKbn.STDRSK, "受取人見出し区分３");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn3(), C_GkdtKoktuutiUktKbn.NASI, "受取人区分３");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm3(), "", "受取人名３");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn4(), C_UktsyuKbn.STDRSK, "受取人見出し区分４");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn4(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分４");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm4(), "", "受取人名４");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn5(), C_UktsyuKbn.BLNK, "受取人見出し区分５");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn5(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分５");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm5(), "", "受取人名５");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn6(), C_UktsyuKbn.BLNK, "受取人見出し区分６");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn6(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分６");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm6(), "", "受取人名６");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn7(), C_UktsyuKbn.BLNK, "受取人見出し区分７");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn7(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分７");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm7(), "", "受取人名７");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn8(), C_UktsyuKbn.BLNK, "受取人見出し区分８");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn8(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分８");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm8(), "", "受取人名８");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn9(), C_UktsyuKbn.BLNK, "受取人見出し区分９");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn9(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分９");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm9(), "", "受取人名９");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktmidasikbn10(), C_UktsyuKbn.BLNK, "受取人見出し区分１０");
        exClassificationEquals(dsKeiyakuSyousaiBean.getUktkbn10(), C_GkdtKoktuutiUktKbn.BLNK, "受取人区分１０");
        exStringEquals(dsKeiyakuSyousaiBean.getUktnm10(), "", "受取人名１０");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknKaisiymd1(), BizDate.valueOf("20160229"), "第１保険期間開始日");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknManryouymd1(), BizDate.valueOf("20210228"), "第１保険期間満了日");
        exNumericEquals(dsKeiyakuSyousaiBean.getDai1Hknkkn(), 5, "第１保険期間");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknKaisiymd2(), BizDate.valueOf("20210301"), "第２保険期間開始日");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknManryouymd2(), BizDate.valueOf("99991231"), "第２保険期間満了日");
        exNumericEquals(dsKeiyakuSyousaiBean.getDai2Hknkkn(), 0, "第２保険期間");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknKaisiymd3(), null, "第３保険期間開始日");
        exDateEquals(dsKeiyakuSyousaiBean.getHknkknManryouymd3(), BizDate.valueOf("99991231"), "第３保険期間満了日");
        exClassificationEquals(dsKeiyakuSyousaiBean.getStdrsktkyhkUmu(), C_UmuKbn.ARI, "指定代理請求特約付加有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getYennykntkhkUmu(), C_UmuKbn.ARI, "円入金特約付加有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getGaikanykntkhkUmu(), C_UmuKbn.ARI, "外貨入金特約付加有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getTargettkhkUmu(), C_UmuKbn.ARI, "ターゲット特約付加有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getInitsbjiyenSitihsytkhukaUmu(), C_UmuKbn.NONE, "初期死亡時円換算最低保証特約付加有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getJyudkaigomeharaiTkhukaUmu(), C_UmuKbn.NONE, "重度介護前払特約付加有無");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getRyymdJitenkwsRate(), null, "領収日時点為替レート");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getRyymdJitenkwsRateStigi(), BizNumber.valueOf(99.0006), "領収日時点為替レート（指定外通貨）");
        exDateEquals(dsKeiyakuSyousaiBean.getKwsrateKijyunymdRy(), BizDate.valueOf(20160812), "為替レート基準日（領収日）");
        exDateEquals(dsKeiyakuSyousaiBean.getKwsrateKijyunymdRyStigi(), BizDate.valueOf("20161121"), "為替レート基準日（領収日）（指定外通貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getRsgakuYen(), BizCurrency.valueOf(1005), "領収金額（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getRsgakuStigi(), BizCurrency.valueOf(1005), "領収金額（指定外通貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getKijyunKingaku(), BizCurrency.valueOf(402), "基準金額");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getItijibrpRsYen(), BizCurrency.valueOf(99), "一時払保険料（領収日）（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getItijibrpKyktuuka(), BizCurrency.valueOf(99), "一時払保険料（契約通貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getItijibrpRsKyktuuka(), BizCurrency.valueOf(20000), "一時払保険料（領収日）（契約通貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getKihonHokenkngk(), BizCurrency.valueOf(500), "基本保険金額");
        exNumericEquals(dsKeiyakuSyousaiBean.getMkhgkWari(), 105, "目標額割合");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getSibohknkngkYen(), BizCurrency.valueOf(302), "死亡保険金額（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getSibohknkngkKyktuuka(), BizCurrency.valueOf(301.9), "死亡保険金額（契約通貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getSgsbhknkngkYen(), BizCurrency.valueOf(402), "災害死亡保険金額（円貨）");
        exBizCalcbleEquals(dsKeiyakuSyousaiBean.getSgsbhknkngkKyktuuka(), BizCurrency.valueOf(401.9), "災害死亡保険金額（契約通貨）");
        exClassificationEquals(dsKeiyakuSyousaiBean.getSgsbhknkngkhyoujiUmu(), C_UmuKbn.ARI, "災害死亡保険金額表示有無");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKjsmsaihakkouKahikbn(), C_KahiKbn.KA, "控除証明書再発行処理可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKykmeigihnkKahikbn(), C_KahiKbn.KA, "名義変更処理可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getSyoukensaihkKahikbn(), C_KahiKbn.KA, "証券再発行処理可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getStdrsktkytthkKahikbn(), C_KahiKbn.HUKA, "指定代理請求特約中途付加処理可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getTargettkhkKahikbn(), C_KahiKbn.HUKA, "ターゲット特約変更可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getHokenkngkksnkekkaKbn(), C_ErrorKbn.OK, "保険金額計算結果区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getKykniyusyoukaiKahikbn(), C_KahiKbn.KA, "契約内容照会可否区分");
        exClassificationEquals(dsKeiyakuSyousaiBean.getTumitatekinitenKahikbn(), C_KahiKbn.HUKA, "積立金移転可否区分");
    }

}
