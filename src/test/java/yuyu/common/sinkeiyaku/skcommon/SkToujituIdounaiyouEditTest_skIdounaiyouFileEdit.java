package yuyu.common.sinkeiyaku.skcommon;

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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.base.BaseUserInfo;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#skIdounaiyouFileEdit(HT_SyoriCTL)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit {

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約当日異動内容編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        bizDomManager.delete(bizDomManager.getAllKijyungkHanteiKawaseRate());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSequences());

        MockObjectManager.initialize();

    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSkIdounaiyouFileEdit_A1() {

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(null);

        assertNull(tjtIdouNySk);
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSkIdounaiyouFileEdit_A2() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112238");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);

        assertNull(tjtIdouNySk);
    }

    @Test
    @Transactional
    @TestOrder(30)
    public void testSkIdounaiyouFileEdit_A3() {

        baseUserInfo.getUser().setUserId("JUnit");

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112246");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112246", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 3, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｺ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.SEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111141", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(0), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 1, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.MIKAKUTEI, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.ARI, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.ARI, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112246", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "カナナ", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "漢字字", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "カナナナ", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "漢字字字", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "カナナナナ", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "漢字字字字", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "カナナナナナ", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "漢字字字字字", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "カナナナナナナ", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "漢字字字字字字", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "カナ１", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "漢字１", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "カナ２", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "漢字２", "家族登録名（漢字）２");


        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112246", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "D001", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(1), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "DK01", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "D002", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(2), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "DK02", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(40)
    public void testSkIdounaiyouFileEdit_A4() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112253");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112253", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｺ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111152", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500, BizCurrencyTypes.DOLLAR), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.MIAWASE, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");


        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112253", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112253", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(50)
    public void testSkIdounaiyouFileEdit_A5() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112261");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112261", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｺ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111174", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.AUD, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500, BizCurrencyTypes.AU_DOLLAR), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(0, BizCurrencyTypes.AU_DOLLAR), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.ENKI, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112261", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112261", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(60)
    public void testSkIdounaiyouFileEdit_A6() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112279");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112279", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｾ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111185", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(400), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(400), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.ENKI, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112279", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112279", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(70)
    public void testSkIdounaiyouFileEdit_A7() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112287");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112287", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｾ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111196", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(400), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(400), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.MOSTRKS, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112287", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112287", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(80)
    public void testSkIdounaiyouFileEdit_A8() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112295");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112295", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｾ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111200", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(400), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(400), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.YUUKOUKIKANKEIKA, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112295", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112295", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(90)
    public void testSkIdounaiyouFileEdit_A9() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112303");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112303", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｾ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111211", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(400), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(400), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.MIKAKUTEI, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112303", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112303", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(100)
    public void testSkIdounaiyouFileEdit_A10() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112311");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112311", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 0, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "ﾕｾ", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), BizDate.valueOf("20160402"), "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), BizDate.valueOf("20160403"), "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), BizDate.valueOf("20160404"), "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.HUSEIRITU, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), BizDate.valueOf("20160401"), "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.SUMI, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "11807111222", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.JPY, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(400), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(500), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(400), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 1, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.HJY, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), BizDateYM.valueOf("201604"), "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.MIKAKUTEI, "申込消滅区分");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouFileEdit", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 1, "商品世代番号");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112311", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "カナ", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "漢字", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), BizDate.valueOf("20160405"), "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.FEMALE, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "1234567", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "被保険者住所１", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "被保険者住所２", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "被保険者住所３", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "023-4560-7890", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "通信先住所１", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "通信先住所２", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "通信先住所３", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsinyno(), "7654321", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "060", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "カナカナ", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "漢字漢字", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), BizDate.valueOf("20160406"), "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "087-6540-3210", "通信先電話番号");
        exStringEquals(idouSkMeigi.getSbuktnmkn1(), "", "死亡受取人名（カナ）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkn2(), "", "死亡受取人名（カナ）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkn3(), "", "死亡受取人名（カナ）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkn4(), "", "死亡受取人名（カナ）４");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkn(), "", "指定代理請求人名（カナ）");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkn(), "", "契約者代理人名（カナ）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkn1(), "", "家族登録名（カナ）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkn2(), "", "家族登録名（カナ）２");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112311", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(110)
    public void testSkIdounaiyouFileEdit_A11() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112329");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112329", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112329", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "", "被保険者名（漢字）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "", "契約者名（漢字）");
        exStringEquals(idouSkMeigi.getSbuktnmkj1(), "", "死亡受取人名（漢字）１");
        exStringEquals(idouSkMeigi.getSbuktnmkj2(), "", "死亡受取人名（漢字）２");
        exStringEquals(idouSkMeigi.getSbuktnmkj3(), "", "死亡受取人名（漢字）３");
        exStringEquals(idouSkMeigi.getSbuktnmkj4(), "", "死亡受取人名（漢字）４");
        exStringEquals(idouSkMeigi.getStdrsknmkj(), "", "指定代理請求人名（漢字）");
        exStringEquals(idouSkMeigi.getKykdairinmkj(), "", "契約者代理人名（漢字）");
        exStringEquals(idouSkMeigi.getKzktourokunmkj1(), "", "家族登録名（漢字）１");
        exStringEquals(idouSkMeigi.getKzktourokunmkj2(), "", "家族登録名（漢字）２");

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112329", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(120)
    public void testSkIdounaiyouFileEdit_A12() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112337");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112337", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112337", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(130)
    public void testSkIdounaiyouFileEdit_A13() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112345");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112345", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.DANTAI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.JPY, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112345", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(140)
    public void testSkIdounaiyouFileEdit_A14() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112352");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112352", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.USD, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112352", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.BLNK, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.BLNK, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(150)
    public void testSkIdounaiyouFileEdit_A15() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112360");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112360", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.AUD, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112360", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "1001", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "101", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.HUTUU, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "123451000010", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "ヒホケンメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(160)
    public void testSkIdounaiyouFileEdit_A16() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112378");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112378", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.EUR, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112378", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "1002", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "102", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.TOUZA, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "123451000011", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "ケイヤクメイカナ１", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.DOUITU, "口座名義契約者同一区分");
    }

    @Test
    @Transactional
    @TestOrder(170)
    public void testSkIdounaiyouFileEdit_A17() {

        HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL("791112386");

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouFileEdit(syoriCTL);
        exStringEquals(tjtIdouNySk.getMosno(), "791112386", "申込番号");
        exClassificationEquals(tjtIdouNySk.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exClassificationEquals(tjtIdouNySk.getTsntuukasyu(), C_Tuukasyu.AUD, "通算用通貨種類");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112386", "申込番号");
        exStringEquals(idouSkMeigi.getBankcd(), "1003", "銀行コード");
        exStringEquals(idouSkMeigi.getSitencd(), "103", "支店コード");
        exClassificationEquals(idouSkMeigi.getYokinkbn(), C_YokinKbn.TTYOKIN, "預金種目区分");
        exStringEquals(idouSkMeigi.getKouzano(), "123451000012", "口座番号");
        exStringEquals(idouSkMeigi.getKzmeiginmkn(), "コウザメイギニンシメイカナ３", "口座名義人氏名（カナ）");
        exClassificationEquals(idouSkMeigi.getKzkykdoukbn(), C_KzkykdouKbn.SITEI, "口座名義契約者同一区分");
    }
}
