package yuyu.common.sinkeiyaku.skcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特定関係法人チェックのメソッド {@link CheckTkhjn#crtCheckTaisyouLst(String)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class CheckTkhjnTest_crtCheckTaisyouLst {

    @Inject
    private CheckTkhjn checkTkhjn;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testCrtCheckTaisyouLst_A1() {
        String siteiMojiretu = " ｱｲ　ｳaリース";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＡ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエイ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウエー", "チェック対象");
    }

    @Test
    @TestOrder(20)
    public void testCrtCheckTaisyouLst_A2() {
        String siteiMojiretu = "ｱｲｳｂビジネス";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＢ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウビー", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウビィ", "チェック対象");
    }

    @Test
    @TestOrder(30)
    public void testCrtCheckTaisyouLst_A3() {
        String siteiMojiretu = "株式Ｃシステム";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "株式Ｃ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "株式シー", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "株式シィ", "チェック対象");
    }

    @Test
    @TestOrder(40)
    public void testCrtCheckTaisyouLst_A4() {
        String siteiMojiretu = "ｱｲｳdサービス";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＤ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウディー", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウデー", "チェック対象");
    }

    @Test
    @TestOrder(50)
    public void testCrtCheckTaisyouLst_A5() {
        String siteiMojiretu = "ｱｲｳeファイナンス";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＥ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウイー", "チェック対象");
    }

    @Test
    @TestOrder(60)
    public void testCrtCheckTaisyouLst_A6() {
        String siteiMojiretu = "ｱｲｳf生命保険";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＦ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエフ", "チェック対象");
    }

    @Test
    @TestOrder(70)
    public void testCrtCheckTaisyouLst_A7() {
        String siteiMojiretu = "ｱｲｳg損害保険";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＧ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウジー", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウジィ", "チェック対象");
    }

    @Test
    @TestOrder(80)
    public void testCrtCheckTaisyouLst_A8() {
        String siteiMojiretu = "ｱｲｳh火災保険";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＨ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエイチ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウエッチ", "チェック対象");
    }

    @Test
    @TestOrder(90)
    public void testCrtCheckTaisyouLst_A9() {
        String siteiMojiretu = "ｱｲｳi信用金庫";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＩ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウアイ", "チェック対象");
    }

    @Test
    @TestOrder(100)
    public void testCrtCheckTaisyouLst_A10() {
        String siteiMojiretu = "ｱｲｳjセンター";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＪ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウジェイ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウジェー", "チェック対象");
    }

    @Test
    @TestOrder(110)
    public void testCrtCheckTaisyouLst_A11() {
        String siteiMojiretu = "ｱｲｳkホールディングス";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＫ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウケー", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウケィ", "チェック対象");
    }

    @Test
    @TestOrder(120)
    public void testCrtCheckTaisyouLst_A12() {
        String siteiMojiretu = "ｱｲｳlコンサルティング";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＬ", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエル", "チェック対象");
    }

    @Test
    @TestOrder(130)
    public void testCrtCheckTaisyouLst_A13() {
        String siteiMojiretu = "ｱｲｳm関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＭ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエム関係法人", "チェック対象");
    }

    @Test
    @TestOrder(140)
    public void testCrtCheckTaisyouLst_A14() {
        String siteiMojiretu = "ｱｲｳn関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＮ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエヌ関係法人", "チェック対象");
    }

    @Test
    @TestOrder(150)
    public void testCrtCheckTaisyouLst_A15() {
        String siteiMojiretu = "ｱｲｳo関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＯ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウオー関係法人", "チェック対象");
    }

    @Test
    @TestOrder(160)
    public void testCrtCheckTaisyouLst_A16() {
        String siteiMojiretu = "ｱｲｳp関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＰ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウピー関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウピィ関係法人", "チェック対象");
    }

    @Test
    @TestOrder(170)
    public void testCrtCheckTaisyouLst_A17() {
        String siteiMojiretu = "ｱｲｳq関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＱ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウキュー関係法人", "チェック対象");
    }

    @Test
    @TestOrder(180)
    public void testCrtCheckTaisyouLst_A18() {
        String siteiMojiretu = "ｱｲｳr関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＲ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウアール関係法人", "チェック対象");
    }

    @Test
    @TestOrder(190)
    public void testCrtCheckTaisyouLst_A19() {
        String siteiMojiretu = "ｱｲｳs関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＳ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエス関係法人", "チェック対象");
    }

    @Test
    @TestOrder(200)
    public void testCrtCheckTaisyouLst_A20() {
        String siteiMojiretu = "ｱｲｳt関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 3, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＴ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウティー関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(2), "アイウテー関係法人", "チェック対象");
    }

    @Test
    @TestOrder(210)
    public void testCrtCheckTaisyouLst_A21() {
        String siteiMojiretu = "ｱｲｳu関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＵ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウユー関係法人", "チェック対象");
    }

    @Test
    @TestOrder(220)
    public void testCrtCheckTaisyouLst_A22() {
        String siteiMojiretu = "ｱｲｳv関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＶ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウブイ関係法人", "チェック対象");
    }

    @Test
    @TestOrder(230)
    public void testCrtCheckTaisyouLst_A23() {
        String siteiMojiretu = "ｱｲｳw関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＷ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウダブリュー関係法人", "チェック対象");
    }

    @Test
    @TestOrder(240)
    public void testCrtCheckTaisyouLst_A24() {
        String siteiMojiretu = "ｱｲｳx関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＸ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウエックス関係法人", "チェック対象");
    }

    @Test
    @TestOrder(250)
    public void testCrtCheckTaisyouLst_A25() {
        String siteiMojiretu = "ｱｲｳy関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＹ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウワイ関係法人", "チェック対象");
    }

    @Test
    @TestOrder(260)
    public void testCrtCheckTaisyouLst_A26() {
        String siteiMojiretu = "ｱｲｳz関係法人";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 2, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "アイウＺ関係法人", "チェック対象");
        exStringEquals(checkTaisyouLst.get(1), "アイウゼット関係法人", "チェック対象");
    }

    @Test
    @TestOrder(270)
    public void testCrtCheckTaisyouLst_A27() {
        String siteiMojiretu = "リースシステム";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 0, "チェック対象リストの件数");
    }

    @Test
    @TestOrder(280)
    public void testCrtCheckTaisyouLst_A28() {
        String siteiMojiretu = "特定関係法人チェック";
        List<String> checkTaisyouLst = checkTkhjn.crtCheckTaisyouLst(siteiMojiretu);

        exNumericEquals(checkTaisyouLst.size(), 1, "チェック対象リストの件数");
        exStringEquals(checkTaisyouLst.get(0), "特定関係法人チェック", "チェック対象");
    }
}
