package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.file.csv.BzIkkatuinsatuKzhuriMinyuTuutiLayoutFile;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiRn;
import yuyu.def.db.entity.ZT_DsKariPasswordTuutiTy;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaRn;
import yuyu.def.db.entity.ZT_SntkInfoHaneiKekkaTr;
import yuyu.def.sinkeiyaku.file.csv.SkHubibunsekiLayoutFile;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convLayout(Object)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convBean {

    @Inject
    private BzRenkeiHenkanUtil<BzIkkatuinsatuKzhuriMinyuTuutiLayoutFile, ConvClass1> bzRenkeiHenkanUtil_A1;

    @Inject
    private BzRenkeiHenkanUtil<ZT_DsKariPasswordTuutiTy, ConvClass4> bzRenkeiHenkanUtil_A2;

    @Inject
    private BzRenkeiHenkanUtil<ZT_DsKariPasswordTuutiTy, SkHubibunsekiLayoutFile> bzRenkeiHenkanUtil_A3;

    @Inject
    private BzRenkeiHenkanUtil<ZT_DsKariPasswordTuutiTy, ZT_DsKariPasswordTuutiRn> bzRenkeiHenkanUtil_A4;

    @Inject
    private BzRenkeiHenkanUtil<ZT_SntkInfoHaneiKekkaRn, ZT_SntkInfoHaneiKekkaTr> bzRenkeiHenkanUtil_A5;

    @Inject
    private BzRenkeiHenkanUtil<ConvClass12_beforeNoGet, ConvClass12_after> bzRenkeiHenkanUtil_A6;

    @Test
    @TestOrder(10)
    public void testConvBean_A1() {

        try {
            bzRenkeiHenkanUtil_A1.initialize(ConvClass1.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変更後レイアウトのレイアウト情報（クラス名：ConvClass1）が存在しません。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(20)
    public void testConvBean_A2() {

        bzRenkeiHenkanUtil_A2.initialize(ZT_DsKariPasswordTuutiTy.class
                , ConvClass4.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        ZT_DsKariPasswordTuutiTy ztDsKariPasswordTuutiTy = new ZT_DsKariPasswordTuutiTy();
        ztDsKariPasswordTuutiTy.setZtyatesakiyno("123456");

        ConvClass4 ConvClass4 = bzRenkeiHenkanUtil_A2.convBean(ztDsKariPasswordTuutiTy);

        exStringEquals(ConvClass4.getZrnatesakiyno(), "１２３４５６００", "（連携用）宛先郵便番号");
    }

    @Test(expected = BizAppException.class)
    @TestOrder(30)
    public void testConvBean_A3() {

        bzRenkeiHenkanUtil_A3.initialize(ZT_DsKariPasswordTuutiTy.class
                , SkHubibunsekiLayoutFile.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        ZT_DsKariPasswordTuutiTy ztDsKariPasswordTuutiTy = new ZT_DsKariPasswordTuutiTy();
        ztDsKariPasswordTuutiTy.setZtyatesakiyno("1234567890");

        try {
            bzRenkeiHenkanUtil_A3.convBean(ztDsKariPasswordTuutiTy);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変換対象外の項目ＩＤが指定されています。項目ＩＤ：ifcTrkymd"
                    , "エラーメッセージ");

            throw e;
        }

    }

    @Test
    @TestOrder(40)
    public void testConvBean_A4() {

        bzRenkeiHenkanUtil_A4.initialize(ZT_DsKariPasswordTuutiTy.class
                , ZT_DsKariPasswordTuutiRn.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

        ZT_DsKariPasswordTuutiTy ztDsKariPasswordTuutiTy = new ZT_DsKariPasswordTuutiTy();
        ztDsKariPasswordTuutiTy.setZtykrpasswordtuutikey("01");
        ztDsKariPasswordTuutiTy.setZtydskokno("A2");
        ztDsKariPasswordTuutiTy.setZtyatesakiyno("１００－０００１");
        ztDsKariPasswordTuutiTy.setZtyatesakiynobarcode("357");
        ztDsKariPasswordTuutiTy.setZtysakuseimd("1231");
        ztDsKariPasswordTuutiTy.setZtysclakadskokno("A2");
        ztDsKariPasswordTuutiTy.setZtyreigaisyorihyj("3");
        ztDsKariPasswordTuutiTy.setZtyyuubinbutukanpusakiyno("１２３４５６７８");
        ztDsKariPasswordTuutiTy.setZtyyuubinbutukanpusakiadr("郵便物還付先住所");
        ztDsKariPasswordTuutiTy.setZtyatesakiadr1("宛先住所１");
        ztDsKariPasswordTuutiTy.setZtyatesakiadr2("宛先住所２");
        ztDsKariPasswordTuutiTy.setZtyatesakiadr3("宛先住所３");
        ztDsKariPasswordTuutiTy.setZtyatena1("宛名１");
        ztDsKariPasswordTuutiTy.setZtyatena2("宛名２");
        ztDsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea1("第１照会先フリーエリア１");
        ztDsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea2("第１照会先フリーエリア２");
        ztDsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea3("第１照会先フリーエリア３");
        ztDsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea4("第１照会先フリーエリア４");
        ztDsKariPasswordTuutiTy.setZtydai1syoukaisakifreearea5("第１照会先フリーエリア５");
        ztDsKariPasswordTuutiTy.setZtysakuseino("No");
        ztDsKariPasswordTuutiTy.setZtyokyakusamanm("お客様氏名");
        ztDsKariPasswordTuutiTy.setZtyhkymd("20161231");
        ztDsKariPasswordTuutiTy.setZtydskrhnnkakcdyoken("１２３４");
        ztDsKariPasswordTuutiTy.setZtykrpasswordyuukouymd("20160201");
        ztDsKariPasswordTuutiTy.setZtyfreearea1("フリーエリア１");
        ztDsKariPasswordTuutiTy.setZtyfreearea2("フリーエリア２");
        ztDsKariPasswordTuutiTy.setZtyfreearea3("フリーエリア３");
        ztDsKariPasswordTuutiTy.setZtyfreearea4("フリーエリア４");
        ztDsKariPasswordTuutiTy.setZtyfreearea5("フリーエリア５");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou1("注意事項欄１");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou2("注意事項欄２");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou3("注意事項欄３");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou4("注意事項欄４");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou5("注意事項欄５");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou6("注意事項欄６");
        ztDsKariPasswordTuutiTy.setZtytyuuijikou7("注意事項欄７");

        ZT_DsKariPasswordTuutiRn ztDsKariPasswordTuutiRn = bzRenkeiHenkanUtil_A4.convBean(ztDsKariPasswordTuutiTy);

        exStringEquals(ztDsKariPasswordTuutiRn.getZrnkrpasswordtuutikey()
                , "01             "
                , "（連携用）仮パスワード通知キー");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndskokno(), "A2        ", "（連携用）お客様番号");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatesakiyno(), "１００－０００１", "（連携用）宛先郵便番号");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatesakiynobarcode()
                , "357                    "
                , "（連携用）宛先郵便番号バーコード");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnsakuseimd(), "1231", "（連携用）作成月日");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnsclakadskokno(), "A2        ", "（連携用）お客様番号");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnreigaisyorihyj(), "3", "（連携用）例外処理表示");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnyuubinbutukanpusakiyno()
                , "１２３４５６７８"
                , "（連携用）郵便物還付先郵便番号");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnyuubinbutukanpusakiadr()
                , "郵便物還付先住所　　　　　　　"
                , "（連携用）郵便物還付先住所");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatesakiadr1()
                , "宛先住所１　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）宛先住所１");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatesakiadr2()
                , "宛先住所２　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）宛先住所２");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatesakiadr3()
                , "宛先住所３　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）宛先住所３");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatena1()
                , "宛名１　　　　　　　　　　　　　　　　"
                , "（連携用）宛名１");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnatena2()
                , "宛名２　　　　　　　　　　　　　　　　"
                , "（連携用）宛名２");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndai1syoukaisakifreearea1()
                , "第１照会先フリーエリア１　　　　　　　　"
                , "（連携用）第１照会先フリーエリア１");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndai1syoukaisakifreearea2()
                , "第１照会先フリーエリア２　　　　　　　　"
                , "（連携用）第１照会先フリーエリア２");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndai1syoukaisakifreearea3()
                , "第１照会先フリーエリア３　　　　　　　　"
                , "（連携用）第１照会先フリーエリア３");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndai1syoukaisakifreearea4()
                , "第１照会先フリーエリア４　　　　　　　　"
                , "（連携用）第１照会先フリーエリア４");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndai1syoukaisakifreearea5()
                , "第１照会先フリーエリア５　　　　　　　　"
                , "（連携用）第１照会先フリーエリア５");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnsakuseino(), "No     ", "（連携用）作成No");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnokyakusamanm()
                , "お客様氏名　　　　　　　　　　　　"
                , "（連携用）お客様氏名");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnhkymd(), "２０１６１２３１　　　", "（連携用）発行日");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrndskrhnnkakcdyoken()
                , "1234"
                , "（連携用）ＤＳ仮本人確認コード与件");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnkrpasswordyuukouymd()
                , "２０１６０２０１　　　"
                , "（連携用）仮パスワード有効年月日");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnfreearea1()
                , "フリーエリア１　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）フリーエリア１");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnfreearea2()
                , "フリーエリア２　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）フリーエリア２");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnfreearea3()
                , "フリーエリア３　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）フリーエリア３");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnfreearea4()
                , "フリーエリア４　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）フリーエリア４");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrnfreearea5()
                , "フリーエリア５　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）フリーエリア５");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou1()
                , "注意事項欄１　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄１");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou2()
                , "注意事項欄２　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄２");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou3()
                , "注意事項欄３　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄３");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou4()
                , "注意事項欄４　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄４");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou5()
                , "注意事項欄５　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄５");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou6()
                , "注意事項欄６　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄６");
        exStringEquals(ztDsKariPasswordTuutiRn.getZrntyuuijikou7()
                , "注意事項欄７　　　　　　　　　　　　　　　　　　　　　　　　　　　　　"
                , "（連携用）注意事項欄７");
    }

    @Test
    @TestOrder(50)
    public void testConvBean_A5() {

        bzRenkeiHenkanUtil_A5.initialize(ZT_SntkInfoHaneiKekkaRn.class
                , ZT_SntkInfoHaneiKekkaTr.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        ZT_SntkInfoHaneiKekkaRn ztSntkInfoHaneiKekkaRn = new ZT_SntkInfoHaneiKekkaRn();
        ztSntkInfoHaneiKekkaRn.setZrnsntkinfono("sntkinfono");
        ztSntkInfoHaneiKekkaRn.setZrnrenno("1");
        ztSntkInfoHaneiKekkaRn.setZrnsntkinfotourokusyskbn("2");
        ztSntkInfoHaneiKekkaRn.setZrnhuho2kyknokbn("3");
        ztSntkInfoHaneiKekkaRn.setZrnhuho2kykno("huho2kykno");
        ztSntkInfoHaneiKekkaRn.setZrnsntkinfofsegkbn("13");
        ztSntkInfoHaneiKekkaRn.setZrnsntkinfofkojinkbn("12");
        ztSntkInfoHaneiKekkaRn.setZrndakuhiketnaiyouarihyj("4");
        ztSntkInfoHaneiKekkaRn.setZrnkktnaiyouarihyj("5");
        ztSntkInfoHaneiKekkaRn.setZrnkijinaiyouarihyj("6");
        ztSntkInfoHaneiKekkaRn.setZrnmrarihyj("7");
        ztSntkInfoHaneiKekkaRn.setZrnkoudosyougaiarihyj("8");
        ztSntkInfoHaneiKekkaRn.setZrntorikaijoarihyj("9");
        ztSntkInfoHaneiKekkaRn.setZrnsntkinjotourokuerrkbn("a");
        ztSntkInfoHaneiKekkaRn.setZrnnayosehumeihyj("b");
        ztSntkInfoHaneiKekkaRn.setZrnsntkinjohaneikekkayobi01("sntkinjohaneikekkayobi");

        ZT_SntkInfoHaneiKekkaTr ztSntkInfoHaneiKekkaTr = bzRenkeiHenkanUtil_A5.convBean(ztSntkInfoHaneiKekkaRn);

        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinfono(), "sntkinfono", "（取込用）選択情報番号");
        exNumericEquals(ztSntkInfoHaneiKekkaTr.getZtrrenno(), 1, "（取込用）連番");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinfotourokusyskbn(), "2", "（取込用）選択情報登録システム区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrhuho2kyknokbn(), "3", "（取込用）普保Ⅱ契約番号区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrhuho2kykno(), "huho2kykno", "（取込用）普保Ⅱ契約番号区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinfofsegkbn(), "13", "（取込用）選択情報ＦＳＥＧ区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinfofkojinkbn(), "12", "（取込用）選択情報Ｆ個人区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrdakuhiketnaiyouarihyj(), "4", "（取込用）諾否決定内容有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrkktnaiyouarihyj(), "5", "（取込用）告知内容有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrkijinaiyouarihyj(), "6", "（取込用）記事内容有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrmrarihyj(), "7", "（取込用）ＭＲ有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrkoudosyougaiarihyj(), "8", "（取込用）高度障害有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrtorikaijoarihyj(), "9", "（取込用）取消解除有表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinjotourokuerrkbn(), "a", "（取込用）選択情報登録エラー区分");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrnayosehumeihyj(), "b", "（取込用）名寄せ不明表示");
        exStringEquals(ztSntkInfoHaneiKekkaTr.getZtrsntkinjohaneikekkayobi01()
                , "sntkinjohaneikekkayobi"
                , "（取込用）選択情報反映結果予備０１");

    }

    @Test
    @TestOrder(60)
    public void testConvBean_A6() {

        try {
            bzRenkeiHenkanUtil_A6.initialize(ConvClass12_beforeNoGet.class
                    , ConvClass12_after.class
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);

            ConvClass12_beforeNoGet convClass12 = new ConvClass12_beforeNoGet();
            convClass12.ztykojincd = "1234";

            bzRenkeiHenkanUtil_A6.convBean(convClass12);
        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "想定外のエラーにより、バッチ処理が中断しました。"
                    , "エラーメッセージ");
        }
    }

    @Test
    @TestOrder(70)
    public void testConvBean_A7() {

        try {

            bzRenkeiHenkanUtil_A2.initialize(ZT_DsKariPasswordTuutiTy.class
                    , ConvClass4.class
                    , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                    , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY
                    , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

            ZT_DsKariPasswordTuutiTy ztDsKariPasswordTuutiTy = new ZT_DsKariPasswordTuutiTy();
            ztDsKariPasswordTuutiTy.setZtyatesakiyno(null);

            bzRenkeiHenkanUtil_A2.convBean(ztDsKariPasswordTuutiTy);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変換前データに null が設定されています。変換対象ＤＤ名：zrnatesakiyno"
                    , "エラーメッセージ");
        }
    }
}
