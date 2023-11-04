package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
/**
 * 手続注意情報設定のメソッド {@link SetTetudukityuui#exec(KhozenCommonParam,SetTetudukityuuiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTetudukityuuiTest_exec {

    private SetTetudukityuuiExecUiBeanParamImpl setTetudukityuuiExecUiBeanParamImpl;

    private KhozenCommonParam khozenCommonParam;

    private final static String fileName = "UT-SP_単体テスト仕様書_手続注意情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetTetudukityuuiTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSosikis());
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        setTetudukityuuiExecUiBeanParamImpl.setSyono("12806345672");

        boolean result = SetTetudukityuui.exec(khozenCommonParam, setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.BLNK, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 0, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.ARI, "（手続注意情報）質権設定区分");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd1(), null, "（手続注意情報）（表示用）処理年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn1(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn1(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn1(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn1(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno1(), "", "（手続注意情報）（表示用）米国納税者番号１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd1(), null, "（手続注意情報）（表示用）署名日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn1(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn1(), "", "（手続注意情報）（表示用）氏名（カナ）１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj1(), "", "（手続注意情報）（表示用）氏名（漢字）１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd1(), null, "（手続注意情報）（表示用）生年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei1(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd1(), null, "（手続注意情報）（表示用）効力終了年月日１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd2(), null, "（手続注意情報）（表示用）処理年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn2(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn2(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn2(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn2(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno2(), "", "（手続注意情報）（表示用）米国納税者番号２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd2(), null, "（手続注意情報）（表示用）署名日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn2(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn2(), "", "（手続注意情報）（表示用）氏名（カナ）２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj2(), "", "（手続注意情報）（表示用）氏名（漢字）２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd2(), null, "（手続注意情報）（表示用）生年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei2(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd2(), null, "（手続注意情報）（表示用）効力終了年月日２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd3(), null, "（手続注意情報）（表示用）処理年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn3(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn3(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn3(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn3(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno3(), "", "（手続注意情報）（表示用）米国納税者番号３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd3(), null, "（手続注意情報）（表示用）署名日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn3(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn3(), "", "（手続注意情報）（表示用）氏名（カナ）３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj3(), "", "（手続注意情報）（表示用）氏名（漢字）３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd3(), null, "（手続注意情報）（表示用）生年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei3(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd3(), null, "（手続注意情報）（表示用）効力終了年月日３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd4(), null, "（手続注意情報）（表示用）処理年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn4(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn4(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn4(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn4(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno4(), "", "（手続注意情報）（表示用）米国納税者番号４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd4(), null, "（手続注意情報）（表示用）署名日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn4(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn4(), "", "（手続注意情報）（表示用）氏名（カナ）４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj4(), "", "（手続注意情報）（表示用）氏名（漢字）４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd4(), null, "（手続注意情報）（表示用）生年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei4(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd4(), null, "（手続注意情報）（表示用）効力終了年月日４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd5(), null, "（手続注意情報）（表示用）処理年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn5(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn5(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn5(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn5(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno5(), "", "（手続注意情報）（表示用）米国納税者番号５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd5(), null, "（手続注意情報）（表示用）署名日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn5(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn5(), "", "（手続注意情報）（表示用）氏名（カナ）５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj5(), "", "（手続注意情報）（表示用）氏名（漢字）５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd5(), null, "（手続注意情報）（表示用）生年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei5(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd5(), null, "（手続注意情報）（表示用）効力終了年月日５");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

        setTetudukityuuiExecUiBeanParamImpl.setSyono("12806345683");

        boolean result = SetTetudukityuui.exec(khozenCommonParam, setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.BLNK, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 0, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.BLNK, "（手続注意情報）質権設定区分");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd1(), BizDate.valueOf("20011010"), "（手続注意情報）（表示用）処理年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn1(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn1(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn1(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn1(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno1(), "9876001", "（手続注意情報）（表示用）米国納税者番号１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd1(), BizDate.valueOf("20011012"), "（手続注意情報）（表示用）署名日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn1(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn1(), "カナ１", "（手続注意情報）（表示用）氏名（カナ）１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj1(), "漢字１", "（手続注意情報）（表示用）氏名（漢字）１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd1(), BizDate.valueOf("20011014"), "（手続注意情報）（表示用）生年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei1(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd1(), BizDate.valueOf("20011016"), "（手続注意情報）（表示用）効力終了年月日１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd2(), BizDate.valueOf("20021010"), "（手続注意情報）（表示用）処理年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn2(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn2(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn2(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn2(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno2(), "9876002", "（手続注意情報）（表示用）米国納税者番号２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd2(), BizDate.valueOf("20021012"), "（手続注意情報）（表示用）署名日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn2(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn2(), "カナ２", "（手続注意情報）（表示用）氏名（カナ）２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj2(), "漢字２", "（手続注意情報）（表示用）氏名（漢字）２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd2(), BizDate.valueOf("20021014"), "（手続注意情報）（表示用）生年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei2(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd2(), BizDate.valueOf("20021016"), "（手続注意情報）（表示用）効力終了年月日２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd3(), BizDate.valueOf("20031010"), "（手続注意情報）（表示用）処理年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn3(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn3(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn3(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn3(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno3(), "9876003", "（手続注意情報）（表示用）米国納税者番号３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd3(), BizDate.valueOf("20031012"), "（手続注意情報）（表示用）署名日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn3(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn3(), "カナ３", "（手続注意情報）（表示用）氏名（カナ）３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj3(), "漢字３", "（手続注意情報）（表示用）氏名（漢字）３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd3(), BizDate.valueOf("20031014"), "（手続注意情報）（表示用）生年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei3(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd3(), BizDate.valueOf("20031016"), "（手続注意情報）（表示用）効力終了年月日３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd4(), BizDate.valueOf("20041010"), "（手続注意情報）（表示用）処理年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn4(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn4(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn4(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn4(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno4(), "9876004", "（手続注意情報）（表示用）米国納税者番号４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd4(), BizDate.valueOf("20041012"), "（手続注意情報）（表示用）署名日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn4(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn4(), "カナ４", "（手続注意情報）（表示用）氏名（カナ）４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj4(), "漢字４", "（手続注意情報）（表示用）氏名（漢字）４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd4(), BizDate.valueOf("20041014"), "（手続注意情報）（表示用）生年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei4(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd4(), BizDate.valueOf("20041016"), "（手続注意情報）（表示用）効力終了年月日４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd5(), null, "（手続注意情報）（表示用）処理年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn5(), C_FatcasnsiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn5(), C_BikkjnssinfoKbn.BLNK, "（手続注意情報）（表示用）米国人示唆情報区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn5(), C_FatcakekKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn5(), C_FatcahankeiiKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno5(), "", "（手続注意情報）（表示用）米国納税者番号５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd5(), null, "（手続注意情報）（表示用）署名日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn5(), C_FatcatgKbn.BLNK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn5(), "", "（手続注意情報）（表示用）氏名（カナ）５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj5(), "", "（手続注意情報）（表示用）氏名（漢字）５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd5(), null, "（手続注意情報）（表示用）生年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei5(), C_Seibetu.BLNK, "（手続注意情報）（表示用）性別５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd5(), null, "（手続注意情報）（表示用）効力終了年月日５");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

        setTetudukityuuiExecUiBeanParamImpl.setSyono("12806345694");

        boolean result = SetTetudukityuui.exec(khozenCommonParam, setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.DNGNMEMONASI, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "アアアアア", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "イイイイイ", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "ウウウウウ", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 5, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.KUJOUKEIIARI, "（手続注意情報）手続注意区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyikbnhsknaiyou(),"内容１", "（手続注意情報）手続注意区分補足内容１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980101"), "（手続注意情報）手続注意区分設定日１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktsetsosikinm(), "設定組織名１１", "（手続注意情報）設定組織名１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.HHKNSYAZOKUSEIKAKUNINJIKOU, "（手続注意情報）手続注意区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyikbnhsknaiyou(),"内容２", "（手続注意情報）手続注意区分補足内容２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980202"), "（手続注意情報）手続注意区分設定日２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktsetsosikinm(), "設定組織名１２", "（手続注意情報）設定組織名２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "（手続注意情報）手続注意区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyikbnhsknaiyou(),"内容３", "（手続注意情報）手続注意区分補足内容３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980303"), "（手続注意情報）手続注意区分設定日３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktsetsosikinm(), "設定組織名１３", "（手続注意情報）設定組織名３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "（手続注意情報）手続注意区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyikbnhsknaiyou(),"内容４", "（手続注意情報）手続注意区分補足内容４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980404"), "（手続注意情報）手続注意区分設定日４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktsetsosikinm(), "設定組織名１４", "（手続注意情報）設定組織名４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.HHKNSYAISINOURYOKUNASI, "（手続注意情報）手続注意区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyikbnhsknaiyou(),"内容５", "（手続注意情報）手続注意区分補足内容５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980505"), "（手続注意情報）手続注意区分設定日５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktsetsosikinm(), "設定組織名１５", "（手続注意情報）設定組織名５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.ARI, "（手続注意情報）質権設定区分");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd1(), BizDate.valueOf("20011010"), "（手続注意情報）（表示用）処理年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn1(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn1(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn1(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn1(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno1(), "9876001", "（手続注意情報）（表示用）米国納税者番号１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd1(), BizDate.valueOf("20011012"), "（手続注意情報）（表示用）署名日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn1(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn1(), "カナ１", "（手続注意情報）（表示用）氏名（カナ）１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj1(), "漢字１", "（手続注意情報）（表示用）氏名（漢字）１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd1(), BizDate.valueOf("20011014"), "（手続注意情報）（表示用）生年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei1(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd1(), BizDate.valueOf("20011016"), "（手続注意情報）（表示用）効力終了年月日１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd2(), BizDate.valueOf("20021010"), "（手続注意情報）（表示用）処理年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn2(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn2(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn2(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn2(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno2(), "9876002", "（手続注意情報）（表示用）米国納税者番号２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd2(), BizDate.valueOf("20021012"), "（手続注意情報）（表示用）署名日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn2(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn2(), "カナ２", "（手続注意情報）（表示用）氏名（カナ）２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj2(), "漢字２", "（手続注意情報）（表示用）氏名（漢字）２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd2(), BizDate.valueOf("20021014"), "（手続注意情報）（表示用）生年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei2(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd2(), BizDate.valueOf("20021016"), "（手続注意情報）（表示用）効力終了年月日２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd3(), BizDate.valueOf("20031010"), "（手続注意情報）（表示用）処理年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn3(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn3(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn3(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn3(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno3(), "9876003", "（手続注意情報）（表示用）米国納税者番号３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd3(), BizDate.valueOf("20031012"), "（手続注意情報）（表示用）署名日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn3(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn3(), "カナ３", "（手続注意情報）（表示用）氏名（カナ）３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj3(), "漢字３", "（手続注意情報）（表示用）氏名（漢字）３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd3(), BizDate.valueOf("20031014"), "（手続注意情報）（表示用）生年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei3(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd3(), BizDate.valueOf("20031016"), "（手続注意情報）（表示用）効力終了年月日３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd4(), BizDate.valueOf("20041010"), "（手続注意情報）（表示用）処理年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn4(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn4(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn4(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn4(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno4(), "9876004", "（手続注意情報）（表示用）米国納税者番号４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd4(), BizDate.valueOf("20041012"), "（手続注意情報）（表示用）署名日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn4(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn4(), "カナ４", "（手続注意情報）（表示用）氏名（カナ）４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj4(), "漢字４", "（手続注意情報）（表示用）氏名（漢字）４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd4(), BizDate.valueOf("20041014"), "（手続注意情報）（表示用）生年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei4(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd4(), BizDate.valueOf("20041016"), "（手続注意情報）（表示用）効力終了年月日４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd5(), BizDate.valueOf("20051010"), "（手続注意情報）（表示用）処理年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn5(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn5(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn5(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn5(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno5(), "9876005", "（手続注意情報）（表示用）米国納税者番号５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd5(), BizDate.valueOf("20051012"), "（手続注意情報）（表示用）署名日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn5(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn5(), "カナ５", "（手続注意情報）（表示用）氏名（カナ）５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj5(), "漢字５", "（手続注意情報）（表示用）氏名（漢字）５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd5(), BizDate.valueOf("20051014"), "（手続注意情報）（表示用）生年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei5(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd5(), BizDate.valueOf("20051016"), "（手続注意情報）（表示用）効力終了年月日５");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A4() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

        setTetudukityuuiExecUiBeanParamImpl.setSyono("12806345708");

        boolean result = SetTetudukityuui.exec(khozenCommonParam, setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.DNGNMEMONASI, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "アアアアア", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "イイイイイ", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "ウウウウウ", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 5, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.KUJOUKEIIARI, "（手続注意情報）手続注意区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyikbnhsknaiyou(),"内容１", "（手続注意情報）手続注意区分補足内容１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980101"), "（手続注意情報）手続注意区分設定日１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(0).getVtdktsetsosikinm(), "設定組織名２１", "（手続注意情報）設定組織名１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.HHKNSYAZOKUSEIKAKUNINJIKOU, "（手続注意情報）手続注意区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyikbnhsknaiyou(),"内容２", "（手続注意情報）手続注意区分補足内容２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980202"), "（手続注意情報）手続注意区分設定日２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(1).getVtdktsetsosikinm(), "設定組織名２２", "（手続注意情報）設定組織名２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.TTDKTYUUOUTAITYUUI, "（手続注意情報）手続注意区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyikbnhsknaiyou(),"内容３", "（手続注意情報）手続注意区分補足内容３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980303"), "（手続注意情報）手続注意区分設定日３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(2).getVtdktsetsosikinm(), "設定組織名２３", "（手続注意情報）設定組織名３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.KYKSYAYUKUEHUMEI, "（手続注意情報）手続注意区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyikbnhsknaiyou(),"内容４", "（手続注意情報）手続注意区分補足内容４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980404"), "（手続注意情報）手続注意区分設定日４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(3).getVtdktsetsosikinm(), "設定組織名２４", "（手続注意情報）設定組織名４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyuuikbn(), C_TtdktyuuiKbn.HHKNSYAISINOURYOKUNASI, "（手続注意情報）手続注意区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyikbnhsknaiyou(),"内容５", "（手続注意情報）手続注意区分補足内容５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktttdktyuuikbnsetymd(), BizDate.valueOf("19980505"), "（手続注意情報）手続注意区分設定日５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().get(4).getVtdktsetsosikinm(), "設定組織名２５", "（手続注意情報）設定組織名５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.BLNK, "（手続注意情報）質権設定区分");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd1(), BizDate.valueOf("20011010"), "（手続注意情報）（表示用）処理年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn1(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn1(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn1(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn1(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno1(), "9876001", "（手続注意情報）（表示用）米国納税者番号１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd1(), BizDate.valueOf("20011012"), "（手続注意情報）（表示用）署名日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn1(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn1(), "カナ１", "（手続注意情報）（表示用）氏名（カナ）１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj1(), "漢字１", "（手続注意情報）（表示用）氏名（漢字）１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd1(), BizDate.valueOf("20011014"), "（手続注意情報）（表示用）生年月日１");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei1(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd1(), BizDate.valueOf("20011016"), "（手続注意情報）（表示用）効力終了年月日１");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd2(), BizDate.valueOf("20021010"), "（手続注意情報）（表示用）処理年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn2(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn2(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn2(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn2(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno2(), "9876002", "（手続注意情報）（表示用）米国納税者番号２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd2(), BizDate.valueOf("20021012"), "（手続注意情報）（表示用）署名日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn2(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn2(), "カナ２", "（手続注意情報）（表示用）氏名（カナ）２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj2(), "漢字２", "（手続注意情報）（表示用）氏名（漢字）２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd2(), BizDate.valueOf("20021014"), "（手続注意情報）（表示用）生年月日２");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei2(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd2(), BizDate.valueOf("20021016"), "（手続注意情報）（表示用）効力終了年月日２");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd3(), BizDate.valueOf("20031010"), "（手続注意情報）（表示用）処理年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn3(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn3(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn3(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn3(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno3(), "9876003", "（手続注意情報）（表示用）米国納税者番号３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd3(), BizDate.valueOf("20031012"), "（手続注意情報）（表示用）署名日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn3(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn3(), "カナ３", "（手続注意情報）（表示用）氏名（カナ）３");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj3(), "漢字３", "（手続注意情報）（表示用）氏名（漢字）３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd3(), BizDate.valueOf("20031014"), "（手続注意情報）（表示用）生年月日３");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei3(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd3(), BizDate.valueOf("20031016"), "（手続注意情報）（表示用）効力終了年月日３");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd4(), BizDate.valueOf("20041010"), "（手続注意情報）（表示用）処理年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn4(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn4(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn4(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn4(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno4(), "9876004", "（手続注意情報）（表示用）米国納税者番号４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd4(), BizDate.valueOf("20041012"), "（手続注意情報）（表示用）署名日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn4(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn4(), "カナ４", "（手続注意情報）（表示用）氏名（カナ）４");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj4(), "漢字４", "（手続注意情報）（表示用）氏名（漢字）４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd4(), BizDate.valueOf("20041014"), "（手続注意情報）（表示用）生年月日４");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei4(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd4(), BizDate.valueOf("20041016"), "（手続注意情報）（表示用）効力終了年月日４");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyoriymd5(), BizDate.valueOf("20051010"), "（手続注意情報）（表示用）処理年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcasnsikbn5(), C_FatcasnsiKbn.GAITOU, "（手続注意情報）（表示用）ＦＡＴＣＡ宣誓区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikkjnssinfokbn5(), C_BikkjnssinfoKbn.ARI, "（手続注意情報）（表示用）米国人示唆情報区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcakekkbn5(), C_FatcakekKbn.KAKUNINTYUU, "（手続注意情報）（表示用）ＦＡＴＣＡ結果区分５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcahankeiikbn5(), C_FatcahankeiiKbn.MEIGIHNK, "（手続注意情報）（表示用）ＦＡＴＣＡ判明経緯区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispbikknzsyno5(), "9876005", "（手続注意情報）（表示用）米国納税者番号５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsyomeiymd5(), BizDate.valueOf("20051012"), "（手続注意情報）（表示用）署名日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispfatcatgkbn5(), C_FatcatgKbn.KYK, "（手続注意情報）（表示用）ＦＡＴＣＡ対象者区分５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkn5(), "カナ５", "（手続注意情報）（表示用）氏名（カナ）５");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispnmkj5(), "漢字５", "（手続注意情報）（表示用）氏名（漢字）５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispseiymd5(), BizDate.valueOf("20051014"), "（手続注意情報）（表示用）生年月日５");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispsei5(), C_Seibetu.MALE, "（手続注意情報）（表示用）性別５");
        exDateEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktdispkouryokuendymd5(), BizDate.valueOf("20051016"), "（手続注意情報）（表示用）効力終了年月日５");
        exBooleanEquals(result, true, "処理結果");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testExec_A5() {
        try {
            khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
            setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

            SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

            setTetudukityuuiExecUiBeanParamImpl.setSyono("12806345812");

            SetTetudukityuui.exec(khozenCommonParam, setTetudukityuuiExecUiBeanParamImpl);
        } catch (BizAppException e){
            exStringEquals(e.getMessage(), "システム整合性エラーです。契約基本TBL  証券番号 = 12806345812", "エラーメッセージ");
            throw e;
        }
    }
}
