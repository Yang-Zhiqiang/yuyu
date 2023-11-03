package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.file.fixedlength.BzFbsoukinHeaderRecordLayoutFile;
import yuyu.def.classification.C_IdCdKbn;
import yuyu.def.classification.C_SystemRenkeiFileSyubetuKbn;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 連携項目変換用ユーティリティクラスのメソッド <br />
 * {@link BzRenkeiHenkanUtil#convDouituBean(Object)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BzRenkeiHenkanUtilTest_convDouituBean {

    @Inject
    private BzRenkeiHenkanUtil<ConvClass1, ConvClass1> bzRenkeiHenkanUtil_A1;

    @Inject
    private BzRenkeiHenkanUtil<ConvClass6, ConvClass6> bzRenkeiHenkanUtil_A2;

    @Inject
    private BzRenkeiHenkanUtil<AM_IdCardYakusyoku, AM_IdCardYakusyoku> bzRenkeiHenkanUtil_A3;

    @Inject
    private BzRenkeiHenkanUtil<AM_IdCardYakusyoku, BzFbsoukinHeaderRecordLayoutFile> bzRenkeiHenkanUtil_A4;

    @Inject
    private BzRenkeiHenkanUtil<ConvClass14, ConvClass14> bzRenkeiHenkanUtil_A5;

    @Test
    @TestOrder(10)
    public void testConvDouituBean_A1() {

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
    public void testConvDouituBean_A2() {

        bzRenkeiHenkanUtil_A2.initialize(ConvClass6.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        ConvClass6 convClass6 = new ConvClass6();
        convClass6.setParamBeanClass("パラメータビーンクラス");

        ConvClass6 convClass6Out = bzRenkeiHenkanUtil_A2.convDouituBean(convClass6);

        exStringEquals(convClass6Out.getParamBeanClass(), "ﾊﾟﾗﾒｰﾀﾋﾞｰﾝｸﾗｽ", "パラメータビーンクラス");
    }


    @Test
    @TestOrder(30)
    public void testConvDouituBean_A3() {

        bzRenkeiHenkanUtil_A3.initialize(AM_IdCardYakusyoku.class
                , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

        AM_IdCardYakusyoku amIdCardYakusyoku = new AM_IdCardYakusyoku();
        amIdCardYakusyoku.setIdkbn(C_IdCdKbn.IDKBN_1.getValue());
        amIdCardYakusyoku.setIdcd("000000 ");
        amIdCardYakusyoku.setYakusyokuhatureiymd(BizDate.valueOf("20150102"));
        amIdCardYakusyoku.setYakusyokuhatureino("99 ");
        amIdCardYakusyoku.setYakusyokuhatureisosikicd("1234567 ");
        amIdCardYakusyoku.setYakusyokucd("987 ");

        BizPropertyInitializer.initialize(amIdCardYakusyoku);

        AM_IdCardYakusyoku amIdCardYakusyokuOut = bzRenkeiHenkanUtil_A3.convDouituBean(amIdCardYakusyoku);

        exStringEquals(amIdCardYakusyokuOut.getIdkbn(), C_IdCdKbn.IDKBN_1.getValue(), "ＩＤ区分");
        exStringEquals(amIdCardYakusyokuOut.getIdcd(), "000000", "ＩＤコード");
        exDateEquals(amIdCardYakusyokuOut.getYakusyokuhatureiymd(), BizDate.valueOf("20150102"), "役職発令年月日");
        exStringEquals(amIdCardYakusyokuOut.getYakusyokuhatureino(), "99", "役職発令番号");
        exStringEquals(amIdCardYakusyokuOut.getYakusyokuhatureisosikicd(), "1234567", "役職発令組織コード");
        exStringEquals(amIdCardYakusyokuOut.getYakusyokucd(), "987", "役職コード");
    }

    @Test
    @TestOrder(40)
    public void testConvDouituBean_A4() {

        bzRenkeiHenkanUtil_A4.initialize(BzFbsoukinHeaderRecordLayoutFile.class
                , C_SystemRenkeiSyoriHousikiKbn.FILE_RENKEI
                , C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER
                , C_SystemRenkeiFileSyubetuKbn.CSV_VARIABLELENGTH);

        BzFbsoukinHeaderRecordLayoutFile bzFbsoukinHeaderRecordLayoutFile = new BzFbsoukinHeaderRecordLayoutFile();

        bzFbsoukinHeaderRecordLayoutFile.setIffFbdatakbn("1");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsyubetucd("2");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbcdkbn("3");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmirainincd("4");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmiraininnm("5");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbhrkmmd("6");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbbankcd("7");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbbanknmkn("8");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsitencd("9");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbsitennmkn("10");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbyokinkbn("1");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbkouzano("12");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbdummy13("13");
        bzFbsoukinHeaderRecordLayoutFile.setIffFbgyoumucd("14");

        BzFbsoukinHeaderRecordLayoutFile bzFbsoukinHeaderRecordLayoutFileOut =
                bzRenkeiHenkanUtil_A4.convDouituBean(bzFbsoukinHeaderRecordLayoutFile);

        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbdatakbn(), "1", "（ＩＦｆ）（ＦＢ）データ区分");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbsyubetucd(), "2", "（ＩＦｆ）（ＦＢ）種別コード");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbcdkbn(), "3", "（ＩＦｆ）（ＦＢ）コード区分");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbhrkmirainincd()
                , "4", "（ＩＦｆ）（ＦＢ）振込依頼人コード");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbhrkmiraininnm()
                , "5", "（ＩＦｆ）（ＦＢ）振込依頼人名");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbhrkmmd(), "6", "（ＩＦｆ）（ＦＢ）振込日（月日）");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbbankcd(), "7", "（ＩＦｆ）（ＦＢ）銀行コード");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbbanknmkn(), "8", "（ＩＦｆ）（ＦＢ）銀行名（カナ）");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbsitencd(), "9", "（ＩＦｆ）（ＦＢ）支店コード");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbsitennmkn()
                , "10", "（ＩＦｆ）（ＦＢ）支店名（カナ）");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbyokinkbn(), "1", "（ＩＦｆ）（ＦＢ）預金種目区分");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbkouzano(), "12", "（ＩＦｆ）（ＦＢ）口座番号");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbdummy13()
                , "13", "（ＩＦｆ）（ＦＢ）ダミー（１３桁）");
        exStringEquals(bzFbsoukinHeaderRecordLayoutFileOut.getIffFbgyoumucd(), "14", "（ＩＦｆ）（ＦＢ）業務コード");

    }


    @Test
    @TestOrder(70)
    public void testConvDouituBean_A5() {

        try {

            bzRenkeiHenkanUtil_A5.initialize(ConvClass14.class
                    , C_SystemRenkeiSyoriHousikiKbn.KYOUYUU_DISC
                    , C_SystemRenkeiHenkanHoukouKbn.OTHER_TO_RAY);

            ConvClass14 convClass14 = new ConvClass14();
            convClass14.setZrnkojincd(null);

            bzRenkeiHenkanUtil_A5.convDouituBean(convClass14);

        } catch (BizAppException e) {

            exStringEquals(e.getMessage()
                    , "変換前データに null が設定されています。変換対象ＤＤ名：zrnkojincd"
                    , "エラーメッセージ");
        }
    }
}
