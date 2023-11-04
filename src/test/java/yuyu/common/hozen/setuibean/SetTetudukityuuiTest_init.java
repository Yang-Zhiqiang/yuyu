package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手続注意情報設定のメソッド {@link SetTetudukityuui#init(SetTetudukityuuiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTetudukityuuiTest_init {

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        SetTetudukityuuiExecUiBeanParamImpl setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.BLNK, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 0, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.BLNK, "（手続注意情報）質権設定区分");
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
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        SetTetudukityuuiExecUiBeanParamImpl setTetudukityuuiExecUiBeanParamImpl = SWAKInjector.getInstance(SetTetudukityuuiExecUiBeanParamImpl.class);

        setTetudukityuuiExecUiBeanParamImpl.setVtdktkktyuitakbn(C_KktyuitaKbn.DNGNMEMONASI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktttdktyuuinaiyou1("アイウエオ");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktttdktyuuinaiyou2("カキクケコ");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktttdktyuuinaiyou2("サシスセソ");

        List<TtdktyuuikbnInfoDataSourceBeanCommonParam> beanLst = new ArrayList<>();

        TtdktyuuikbnInfoDataSourceBeanCommonParamImpl ttdktyuuikbnInfoDataSourceBeanCommonParam = SWAKInjector.getInstance(TtdktyuuikbnInfoDataSourceBeanCommonParamImpl.class);

        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbn(C_TtdktyuuiKbn.HASANOYOBITOUSAN);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyikbnhsknaiyou("補足内容１");
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbnsetymd(BizDate.valueOf("20100101"));
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktsetsosikinm("設定組織名１１");
        beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbn(C_TtdktyuuiKbn.MINJISAISEI);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyikbnhsknaiyou("補足内容２");
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbnsetymd(BizDate.valueOf("20100202"));
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktsetsosikinm("設定組織名１２");
        beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbn(C_TtdktyuuiKbn.SYOUMETUJISEISAN);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyikbnhsknaiyou("補足内容３");
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbnsetymd(BizDate.valueOf("20100303"));
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktsetsosikinm("設定組織名１３");
        beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbn(C_TtdktyuuiKbn.PMENHIGAITOU);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyikbnhsknaiyou("補足内容４");
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbnsetymd(BizDate.valueOf("20100404"));
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktsetsosikinm("設定組織名１４");
        beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbn(C_TtdktyuuiKbn.ADRHUMEI);
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyikbnhsknaiyou("補足内容５");
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktttdktyuuikbnsetymd(BizDate.valueOf("20100505"));
        ttdktyuuikbnInfoDataSourceBeanCommonParam.setVtdktsetsosikinm("設定組織名１５");
        beanLst.add(ttdktyuuikbnInfoDataSourceBeanCommonParam);

        setTetudukityuuiExecUiBeanParamImpl.convertTtdktyuuikbnInfoForCommonParam(beanLst);

        setTetudukityuuiExecUiBeanParamImpl.setVtdktstknsetkbn(C_StknsetKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyoriymd1(BizDate.valueOf("20110101"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcasnsikbn1(C_FatcasnsiKbn.GAITOU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikkjnssinfokbn1(C_BikkjnssinfoKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcakekkbn1(C_FatcakekKbn.KAKUNINTYUU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcahankeiikbn1(C_FatcahankeiiKbn.MEIGIHNK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikknzsyno1("1224001");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyomeiymd1(BizDate.valueOf("20110202"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcatgkbn1(C_FatcatgKbn.KYK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkn1("氏名（カナ）１");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkj1("氏名（漢字）１");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispseiymd1(BizDate.valueOf("20110303"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsei1(C_Seibetu.MALE);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispkouryokuendymd1(BizDate.valueOf("20110404"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyoriymd2(BizDate.valueOf("20120101"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcasnsikbn2(C_FatcasnsiKbn.GAITOU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikkjnssinfokbn2(C_BikkjnssinfoKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcakekkbn2(C_FatcakekKbn.KAKUNINTYUU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcahankeiikbn2(C_FatcahankeiiKbn.MEIGIHNK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikknzsyno2("1224002");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyomeiymd2(BizDate.valueOf("20120202"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcatgkbn2(C_FatcatgKbn.KYK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkn2("氏名（カナ）２");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkj2("氏名（漢字）２");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispseiymd2(BizDate.valueOf("20120303"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsei2(C_Seibetu.MALE);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispkouryokuendymd2(BizDate.valueOf("20120404"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyoriymd3(BizDate.valueOf("20130101"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcasnsikbn3(C_FatcasnsiKbn.GAITOU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikkjnssinfokbn3(C_BikkjnssinfoKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcakekkbn3(C_FatcakekKbn.KAKUNINTYUU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcahankeiikbn3(C_FatcahankeiiKbn.MEIGIHNK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikknzsyno3("1224003");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyomeiymd3(BizDate.valueOf("20130202"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcatgkbn3(C_FatcatgKbn.KYK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkn3("氏名（カナ）３");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkj3("氏名（漢字）３");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispseiymd3(BizDate.valueOf("20130303"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsei3(C_Seibetu.MALE);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispkouryokuendymd3(BizDate.valueOf("20130404"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyoriymd4(BizDate.valueOf("20140101"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcasnsikbn4(C_FatcasnsiKbn.GAITOU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikkjnssinfokbn4(C_BikkjnssinfoKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcakekkbn4(C_FatcakekKbn.KAKUNINTYUU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcahankeiikbn4(C_FatcahankeiiKbn.MEIGIHNK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikknzsyno4("1224004");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyomeiymd4(BizDate.valueOf("20140202"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcatgkbn4(C_FatcatgKbn.KYK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkn4("氏名（カナ）４");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkj4("氏名（漢字）４");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispseiymd4(BizDate.valueOf("20140303"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsei4(C_Seibetu.MALE);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispkouryokuendymd4(BizDate.valueOf("20140404"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyoriymd5(BizDate.valueOf("20150101"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcasnsikbn5(C_FatcasnsiKbn.GAITOU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikkjnssinfokbn5(C_BikkjnssinfoKbn.ARI);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcakekkbn5(C_FatcakekKbn.KAKUNINTYUU);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcahankeiikbn5(C_FatcahankeiiKbn.MEIGIHNK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispbikknzsyno5("1224005");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsyomeiymd5(BizDate.valueOf("20150202"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispfatcatgkbn5(C_FatcatgKbn.KYK);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkn5("氏名（カナ）５");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispnmkj5("氏名（漢字）５");
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispseiymd5(BizDate.valueOf("20150303"));
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispsei5(C_Seibetu.MALE);
        setTetudukityuuiExecUiBeanParamImpl.setVtdktdispkouryokuendymd5(BizDate.valueOf("20150404"));

        SetTetudukityuui.init(setTetudukityuuiExecUiBeanParamImpl);

        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktkktyuitakbn(), C_KktyuitaKbn.BLNK, "（手続注意情報）契約管理注意取扱区分");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou1(), "", "（手続注意情報）手続注意内容１");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou2(), "", "（手続注意情報）手続注意内容２");
        exStringEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktttdktyuuinaiyou3(), "", "（手続注意情報）手続注意内容３");
        exNumericEquals(setTetudukityuuiExecUiBeanParamImpl.getTtdktyuuikbnInfoDataSourceBeanCommonParamLst().size(), 0, "手続注意区分内容 のデータソース");
        exClassificationEquals(setTetudukityuuiExecUiBeanParamImpl.getVtdktstknsetkbn(), C_StknsetKbn.BLNK, "（手続注意情報）質権設定区分");
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

        MockObjectManager.initialize();

    }
}
