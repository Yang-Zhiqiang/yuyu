package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;
import yuyu.def.db.entity.BT_IdouSkMeigi;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約当日異動内容編集クラスのメソッド {@link SkToujituIdounaiyouEdit#skIdounaiyouSakujyoFileEdit(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SkToujituIdounaiyouEditTest_skIdounaiyouSakujyoFileEdit{

    @Inject
    private SkToujituIdounaiyouEdit skToujituIdounaiyouEdit;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_新契約当日異動内容編集";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SkToujituIdounaiyouEditTest_skIdounaiyouSakujyoFileEdit.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
        } catch (TestDataMakerException e) {

            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTjtIdouNySk());
        MockObjectManager.initialize();
    }

    @Test
    @Transactional
    @TestOrder(10)
    public void testSkIdounaiyouSakujyoFileEdit_A1() {

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouSakujyoFileEdit("791112220");

        exStringEquals(tjtIdouNySk.getMosno(), "791112220", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 1, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 1, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), null, "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), null, "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), null, "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.BLNK, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), null, "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.NONE, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(0), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 0, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.BLNK, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), null, "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.BLNK, "申込消滅区分");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 0, "商品世代番号 ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouSakujyoFil", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112220", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), null, "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouSkMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouSkMeigi.getTsinyno(), "", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "", "通信先電話番号");
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

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112220", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 1, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

    @Test
    @Transactional
    @TestOrder(20)
    public void testSkIdounaiyouSakujyoFileEdit_A2() {

        BT_TjtIdouNySk tjtIdouNySk = skToujituIdounaiyouEdit.skIdounaiyouSakujyoFileEdit("791112238");

        exStringEquals(tjtIdouNySk.getMosno(), "791112238", "申込番号");
        exNumericEquals(tjtIdouNySk.getRenno3keta(), 3, "連番（３桁）");
        exNumericEquals(tjtIdouNySk.getRecordsakujyohyouji(), 1, "レコード削除表示");
        exStringEquals(tjtIdouNySk.getYoukyuuno(), "", "要求通番");
        exStringEquals(tjtIdouNySk.getSyouhncd(), "", "商品コード");
        exDateEquals(tjtIdouNySk.getMosymd(), null, "申込日");
        exDateEquals(tjtIdouNySk.getKykymd(), null, "契約日");
        exDateEquals(tjtIdouNySk.getSknnkaisiymd(), null, "責任開始日");
        exClassificationEquals(tjtIdouNySk.getSeiritukbn(), C_SeirituKbn.BLNK, "成立区分");
        exDateEquals(tjtIdouNySk.getSrsyoriymd(), null, "成立処理日");
        exClassificationEquals(tjtIdouNySk.getMfrenflg(), C_Mfrenflg.NONE, "ＭＦ連動済フラグ");
        exStringEquals(tjtIdouNySk.getSyono(), "", "証券番号");
        exClassificationEquals(tjtIdouNySk.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyousibous(), BizCurrency.valueOf(0), "通算用死亡Ｓ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyouitijip(), BizCurrency.valueOf(0), "通算用一時払Ｐ");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyounkgns(), BizCurrency.valueOf(0), "通算用年金原資");
        exNumericEquals(tjtIdouNySk.getHrkkkn(), 0, "払込期間");
        exClassificationEquals(tjtIdouNySk.getSntkhoukbn(), C_SntkhouKbn.BLNK, "選択方法区分");
        exDateYMEquals(tjtIdouNySk.getBosyuuym(), null, "募集年月");
        exNumericEquals(tjtIdouNySk.getKykhhkndouhyouji(), 0, "契約者被保険者同一表示");
        exClassificationEquals(tjtIdouNySk.getMossyoumetukbn(), C_MossyoumetuKbn.BLNK, "申込消滅区分");
        exNumericEquals(tjtIdouNySk.getSyouhnsdno(), 0, "商品世代番号 ");
        exClassificationEquals(tjtIdouNySk.getKaigomaehrtkykumukbn(), C_UmuKbn.NONE, "介護前払特約有無区分");
        exClassificationEquals(tjtIdouNySk.getPyennykntkykumukbn(), C_UmuKbn.NONE, "保険料円入金特約有無区分");
        exBizCalcbleEquals(tjtIdouNySk.getTsnyennyknkgk(), BizCurrency.valueOf(0), "通算用円入金額");
        exStringEquals(tjtIdouNySk.getGyoumuKousinKinou(), "SkToujituIdounaiyouEditTest_skIdounaiyouSakujyoFil", "業務用更新機能ＩＤ");
        exStringEquals(tjtIdouNySk.getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");

        BT_IdouSkMeigi idouSkMeigi = tjtIdouNySk.getIdouSkMeigi();
        exStringEquals(idouSkMeigi.getMosno(), "791112238", "申込番号");
        exNumericEquals(idouSkMeigi.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(idouSkMeigi.getHhknnmkn(), "", "被保険者名（カナ）");
        exStringEquals(idouSkMeigi.getHhknnmkj(), "", "被保険者名（漢字）");
        exDateEquals(idouSkMeigi.getHhknseiymd(), null, "被保険者生年月日");
        exClassificationEquals(idouSkMeigi.getHhknsei(), C_Hhknsei.BLNK, "被保険者性別");
        exStringEquals(idouSkMeigi.getHhknyno(), "", "被保険者郵便番号");
        exStringEquals(idouSkMeigi.getHhknadr1kj(), "", "被保険者住所１（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr2kj(), "", "被保険者住所２（漢字）");
        exStringEquals(idouSkMeigi.getHhknadr3kj(), "", "被保険者住所３（漢字）");
        exStringEquals(idouSkMeigi.getHhkntelno(), "", "被保険者電話番号");
        exStringEquals(idouSkMeigi.getHhknsykgycd(), "", "被保険者職業コード");
        exStringEquals(idouSkMeigi.getKyknmkn(), "", "契約者名（カナ）");
        exStringEquals(idouSkMeigi.getKyknmkj(), "", "契約者名（漢字）");
        exDateEquals(idouSkMeigi.getKykseiymd(), null, "契約者生年月日");
        exStringEquals(idouSkMeigi.getNenkinuktnmkana(), "", "年金受取人名（カナ）");
        exStringEquals(idouSkMeigi.getNenkinuktnmkanji(), "", "年金受取人名（漢字）");
        exDateEquals(idouSkMeigi.getNenkinuktseiymd(), null, "年金受取人生年月日");
        exStringEquals(idouSkMeigi.getTsinyno(), "", "通信先郵便番号");
        exStringEquals(idouSkMeigi.getTsinadr1kj(), "", "通信先住所１（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr2kj(), "", "通信先住所２（漢字）");
        exStringEquals(idouSkMeigi.getTsinadr3kj(), "", "通信先住所３（漢字）");
        exStringEquals(idouSkMeigi.getTsintelno(), "", "通信先電話番号");
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

        BT_IdouSkBosyuudr idouSkBosyuudr = tjtIdouNySk.getIdouSkBosyuudr();
        exStringEquals(idouSkBosyuudr.getMosno(), "791112238", "申込番号");
        exNumericEquals(idouSkBosyuudr.getRenno3keta(), 3, "連番（３桁）");
        exStringEquals(idouSkBosyuudr.getDairitencd1(), "", "代理店コード１");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari1(), BizNumber.valueOf(0), "分担割合１");
        exStringEquals(idouSkBosyuudr.getDairitencd2(), "", "代理店コード２");
        exBizCalcbleEquals(idouSkBosyuudr.getBunwari2(), BizNumber.valueOf(0), "分担割合２");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd1(), "", "管理組織コード１");
        exStringEquals(idouSkBosyuudr.getKanrisosikicd2(), "", "管理組織コード２");
    }

}
