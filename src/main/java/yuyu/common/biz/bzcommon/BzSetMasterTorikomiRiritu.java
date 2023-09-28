package yuyu.common.biz.bzcommon;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.def.classification.C_RirituSyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 共通 マスタ取込利率設定
 */
public class BzSetMasterTorikomiRiritu {

    // private static final BizDate HATUBAIKAISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR = BizDate.valueOf(20180801);

    private static final BizDate BOSYUTEISIYMD_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR = BizDate.valueOf(20200401);

    private static final BizDate BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_GONEN = BizDate.valueOf(20201001);

    private static final BizDate BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_JYUUNEN = BizDate.valueOf(20201216);

    private static final BizDate BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_AUD_GONEN = BizDate.valueOf(20191101);

    private static final BizDate BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_AUD_GONEN = BizDate.valueOf(20210201);

    private static final BizDate KIJYUNFROMYMD = BizDate.valueOf(20210216);

    private static final BizDate KIJYUNTOYMD = BizDate.valueOf(20210228);

    private static final BizNumber USDYOTEIRIRITU = BizNumber.valueOf(0.0220);

    private static final BizNumber AUDYOTEIRIRITU = BizNumber.valueOf(0.0135);

    private static final BizNumber USDYOTEIRIRITU_GONEN = BizNumber.valueOf(0.0150);

    private static final BizNumber USDYOTEIRIRITU_JYUUNEN = BizNumber.valueOf(0.0150);

    private static final BizNumber AUDYOTEIRIRITU_GONEN = BizNumber.valueOf(0.0150);

    private static final BizNumber AUDYOTEIRIRITU_JYUUNEN = BizNumber.valueOf(0.0150);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU = BizNumber.valueOf(0.0234);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU = BizNumber.valueOf(0.0158);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU_GONEN = BizNumber.valueOf(0.0095);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU_JYUUNEN = BizNumber.valueOf(0.0190);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU_GONEN = BizNumber.valueOf(0.0058);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN = BizNumber.valueOf(0.0147);

    private static final BizNumber USDTMTTKNZOUKARITUJYGN_GONEN = BizNumber.valueOf(0.0060);

    private static final BizNumber USDTMTTKNZOUKARITUJYGN_JYUUNEN = BizNumber.valueOf(0.0060);

    private static final BizNumber AUDTMTTKNZOUKARITUJYGN_GONEN = BizNumber.valueOf(0.0060);

    private static final BizNumber AUDTMTTKNZOUKARITUJYGN_JYUUNEN = BizNumber.valueOf(0.0060);

    private static final BizNumber USDTUMITATERIRITU_GONEN = BizNumber.valueOf(0.0050);

    private static final BizNumber USDTUMITATERIRITU_JYUUNEN = BizNumber.valueOf(0.0050);

    private static final BizNumber AUDTUMITATERIRITU_GONEN = BizNumber.valueOf(0.0050);

    private static final BizNumber AUDTUMITATERIRITU_JYUUNEN = BizNumber.valueOf(0.0050);

    private static final BizNumber USDSETTEIBAIRITU_GONEN = BizNumber.valueOf(1.00);

    private static final BizNumber USDSETTEIBAIRITU_JYUUNEN = BizNumber.valueOf(1.00);

    private static final BizNumber AUDSETTEIBAIRITU_GONEN = BizNumber.valueOf(1.00);

    private static final BizNumber AUDSETTEIBAIRITU_JYUUNEN = BizNumber.valueOf(1.00);

    private static final BizDate KIJYUNFROMYMD_ONCEMONTH = BizDate.valueOf(20210301);

    private static final BizDate KIJYUNTOYMD_ONCEMONTH = BizDate.valueOf(20210301);

    private static final BizNumber USDKIJUNRIRITU = BizNumber.valueOf(0.0103);

    private static final BizNumber AUDKIJUNRIRITU = BizNumber.valueOf(0.0111);

    private static final BizNumber USDYOTEIRIRITU_JGKAITEI = BizNumber.valueOf(0.0185);

    private static final BizNumber AUDYOTEIRIRITU_JGKAITEI = BizNumber.valueOf(0.0135);

    private static final BizNumber USDTUMITATERIRITU_JGKAITEI = BizNumber.valueOf(0.0100);

    private static final BizNumber AUDTUMITATERIRITU_JGKAITEI = BizNumber.valueOf(0.0060);

    private static final BizNumber USDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI = BizNumber.valueOf(0.0120);

    private static final BizNumber AUDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI = BizNumber.valueOf(0.0070);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU_JGKAITEI = BizNumber.valueOf(0.0234);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU_JGKAITEI = BizNumber.valueOf(0.0158);

    private static final BizNumber USDYOTEIRIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0060);

    private static final BizNumber USDYOTEIRIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0170);

    private static final BizNumber AUDYOTEIRIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0060);

    private static final BizNumber AUDYOTEIRIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0135);

    private static final BizNumber USDTUMITATERIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0010);

    private static final BizNumber USDTUMITATERIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0070);

    private static final BizNumber AUDTUMITATERIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0010);

    private static final BizNumber AUDTUMITATERIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0035);

    private static final BizNumber USDRENDOURITU_GONEN_GAUDEI = BizNumber.valueOf(0.0455);

    private static final BizNumber USDRENDOURITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.3155);

    private static final BizNumber AUDRENDOURITU_GONEN_GAUDEI = BizNumber.valueOf(0.0455);

    private static final BizNumber AUDRENDOURITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.1600);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0095);

    private static final BizNumber USDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0190);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI = BizNumber.valueOf(0.0058);

    private static final BizNumber AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI = BizNumber.valueOf(0.0147);


    private static final String[] SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR =
    {"ﾕｱ", "ﾕｲ", "ﾕｳ", "ﾕｴ", "ﾕｵ", "ﾕｶ", "ﾕｷ", "ﾕｸ"};

    private static final String[] SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR =
    {"ﾕｹ", "ﾕｺ", "ﾕｻ", "ﾕｼ", "ﾕｽ", "ﾕｾ", "ﾕｿ", "ﾕﾀ"};

    private static final String[] SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN =
    {"ﾕﾁ", "ﾕﾂ", "ﾕﾃ", "ﾕﾄ", "ﾕﾅ", "ﾕﾆ", "ﾕﾇ", "ﾕﾈ"};

    private static final String[] SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 =
    { "ﾕﾉ", "ﾕﾊ", "ﾕﾋ", "ﾕﾌ" };

    private static final String[] SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 =
    { "ﾕﾍ","ﾕﾎ","ﾕﾏ","ﾕﾐ","ﾕﾕ","ﾕﾖ","ﾕﾗ","ﾕﾘ" };

    private static final C_Tuukasyu[] TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR =
    {C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.USD, C_Tuukasyu.AUD};

    private static final C_Tuukasyu[] TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR =
    {C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD};

    private static final C_Tuukasyu[] TUUKASYUARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN =
    {C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD};

    private static final C_Tuukasyu[] TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 =
    { C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.USD, C_Tuukasyu.AUD };

    private static final C_Tuukasyu[] TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 =
    {C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.USD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD, C_Tuukasyu.AUD};

    public static final String BLANK = "";

    public static final String SUEOKIKKN_GONEN = "5";

    public static final String SUEOKIKKN_JYUUNEN = "10";

    @Inject
    private static Logger logger;

    @Inject
    private BatchLogger batchLogger;

    public BzSetMasterTorikomiRiritu() {
        super();
    }

    public BzSetMasterTorikomiRirituBean exec(C_RirituSyuruiKbn pRirituSyuruiKbn){

        logger.debug("▽ マスタ取込利率設定 開始");

        BzSetMasterTorikomiRirituBean bzSetMastaTorikomiRirituBean = new BzSetMasterTorikomiRirituBean();

        DecimalFormat rirituFormat = new DecimalFormat("0.0000");
        DecimalFormat bairituFormat = new DecimalFormat("0.00");

        if(C_RirituSyuruiKbn.YOTEIRIRITU.eq(pRirituSyuruiKbn)) {

            batchLogger.info("マスタ取込利率設定値　基準日自＝" + KIJYUNFROMYMD.toString());
            batchLogger.info("マスタ取込利率設定値　基準日至＝" + KIJYUNTOYMD.toString());

            // batchLogger.info("マスタ取込利率設定値　豪ドル予定利率（１０年）＝" + AUDYOTEIRIRITU_JYUUNEN.toString(rirituFormat));
            // batchLogger.info("マスタ取込利率設定値　豪ドル積立金増加率上限（１０年）＝" + AUDTMTTKNZOUKARITUJYGN_JYUUNEN.toString(rirituFormat));
            // batchLogger.info("マスタ取込利率設定値　豪ドル積立利率（１０年）＝" + AUDTUMITATERIRITU_JYUUNEN.toString(rirituFormat));
            // batchLogger.info("マスタ取込利率設定値　豪ドル設定倍率（１０年）＝" + AUDSETTEIBAIRITU_JYUUNEN.toString(bairituFormat));

            batchLogger.info("マスタ取込利率設定値　基準日自_月1回＝" + KIJYUNFROMYMD_ONCEMONTH.toString());
            batchLogger.info("マスタ取込利率設定値　基準日至_月1回＝" + KIJYUNTOYMD_ONCEMONTH.toString());
            batchLogger.info("マスタ取込利率設定値　米ドル基準利率＝" + USDKIJUNRIRITU.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル基準利率＝" + AUDKIJUNRIRITU.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル予定利率（ＪＧ改定）＝" + USDYOTEIRIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル予定利率（ＪＧ改定）＝" + AUDYOTEIRIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル積立利率（ＪＧ改定）＝" + USDTUMITATERIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル積立利率（ＪＧ改定）＝" + AUDTUMITATERIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドルローディング変更後積立利率（ＪＧ改定）＝" + USDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドルローディング変更後積立利率（ＪＧ改定）＝" + AUDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル予定利率（５年）（ガウディ）＝" + USDYOTEIRIRITU_GONEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル予定利率（１０年）（ガウディ）＝" + USDYOTEIRIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル予定利率（１０年）（ガウディ）＝" + AUDYOTEIRIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル積立利率（５年）（ガウディ）＝" + USDTUMITATERIRITU_GONEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル積立利率（１０年）（ガウディ）＝" + USDTUMITATERIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル積立利率（１０年）（ガウディ）＝" + AUDTUMITATERIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル連動率（５年）（ガウディ）＝" + USDRENDOURITU_GONEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル連動率（１０年）（ガウディ）＝" + USDRENDOURITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル連動率（１０年）（ガウディ）＝" + AUDRENDOURITU_JYUUNEN_GAUDEI.toString(rirituFormat));

            if(BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR,KIJYUNFROMYMD) == BizDateUtil.COMPARE_GREATER) {
                batchLogger.info("マスタ取込利率設定値　米ドル予定利率＝" + USDYOTEIRIRITU.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル予定利率＝" + AUDYOTEIRIRITU.toString(rirituFormat));
            }

            if(BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_GREATER) {
                batchLogger.info("マスタ取込利率設定値　米ドル予定利率（５年）＝" + USDYOTEIRIRITU_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル積立金増加率上限（５年）＝" + USDTMTTKNZOUKARITUJYGN_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル積立利率（５年）＝" + USDTUMITATERIRITU_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル設定倍率（５年）＝" + USDSETTEIBAIRITU_GONEN.toString(bairituFormat));
            }

            if(BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_GREATER) {
                batchLogger.info("マスタ取込利率設定値　豪ドル予定利率（５年）＝" + AUDYOTEIRIRITU_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル積立金増加率上限（５年）＝" + AUDTMTTKNZOUKARITUJYGN_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル積立利率（５年）＝" + AUDTUMITATERIRITU_GONEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル設定倍率（５年）＝" + AUDSETTEIBAIRITU_GONEN.toString(bairituFormat));
            }

            if(BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_JYUUNEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_GREATER) {
                batchLogger.info("マスタ取込利率設定値　米ドル予定利率（１０年）＝" + USDYOTEIRIRITU_JYUUNEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル積立金増加率上限（１０年）＝" + USDTMTTKNZOUKARITUJYGN_JYUUNEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル積立利率（１０年）＝" + USDTUMITATERIRITU_JYUUNEN.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　米ドル設定倍率（１０年）＝" + USDSETTEIBAIRITU_JYUUNEN.toString(bairituFormat));
            }

            if(BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_GREATER) {
                batchLogger.info("マスタ取込利率設定値　豪ドル予定利率（５年）（ガウディ）＝" + AUDYOTEIRIRITU_GONEN_GAUDEI.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル積立利率（５年）（ガウディ）＝" + AUDTUMITATERIRITU_GONEN_GAUDEI.toString(rirituFormat));
                batchLogger.info("マスタ取込利率設定値　豪ドル連動率（５年）（ガウディ）＝" + AUDRENDOURITU_GONEN_GAUDEI.toString(rirituFormat));
            }

            List<BM_YoteiRiritu3> yoteiRirituList = new ArrayList<>();

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR.length; i++) {

                BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[i],
                    TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[i],
                    BLANK);

                yoteiRirituList.add(yoteiRiritu);
            }

            //            if (HATUBAIKAISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR.compareTo(KIJYUNFROMYMD) <= 0) {
            //
            //                for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR.length; i++) {
            //
            //                    BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
            //                        SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        SUEOKIKKN_GONEN);
            //
            //                    yoteiRirituList.add(yoteiRiritu);
            //
            //                    BM_YoteiRiritu3 yoteiRiritu2 = setYoteiRirituEntity(
            //                        SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        SUEOKIKKN_JYUUNEN);
            //
            //                    yoteiRirituList.add(yoteiRiritu2);
            //                }
            //
            //                for(int i = 0; i < SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN.length; i++) {
            //
            //                    BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
            //                        SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN[i],
            //                        TUUKASYUARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN[i],
            //                        BLANK);
            //
            //                    yoteiRirituList.add(yoteiRiritu);
            //                }
            //
            //            }


            // 2021/2/16以降カスケードがすべて募集停止となるため、カスケードの予定利率設定処理全体をコメントアウト
            //            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR.length; i++) {
            //
            //                if(((BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_EQUAL ||
            //                    BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_LESSER) &&
            //                    C_Tuukasyu.AUD.eq(TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i])) ||
            //                    ((BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_EQUAL ||
            //                    BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_LESSER) &&
            //                    C_Tuukasyu.USD.eq(TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i]))) {
            //
            //
            //                }
            //                else {
            //                    BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
            //                        SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        SUEOKIKKN_GONEN);
            //
            //                    yoteiRirituList.add(yoteiRiritu);
            //                }
            //
            //
            //                if(((BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_JYUUNEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_EQUAL ||
            //                    BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_USD_JYUUNEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_LESSER) &&
            //                    C_Tuukasyu.USD.eq(TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i]))) {
            //
            //
            //                }
            //                else {
            //                    BM_YoteiRiritu3 yoteiRiritu2 = setYoteiRirituEntity(
            //                        SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
            //                        SUEOKIKKN_JYUUNEN);
            //
            //                    yoteiRirituList.add(yoteiRiritu2);
            //                }
            //
            //            }

            for(int i = 0; i < SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN.length; i++) {

                BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
                    SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN[i],
                    TUUKASYUARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN[i],
                    BLANK);

                yoteiRirituList.add(yoteiRiritu);
            }

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19.length; i++) {

                BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[i],
                    TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[i],
                    BLANK);

                yoteiRirituList.add(yoteiRiritu);
            }

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20.length; i++) {

                if(((BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_EQUAL ||
                    BizDateUtil.compareYmd(BOSYUTEISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20_AUD_GONEN,KIJYUNFROMYMD) == BizDateUtil.COMPARE_LESSER) &&
                    C_Tuukasyu.AUD.eq(TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i])) ) {

                }
                else {

                    BM_YoteiRiritu3 yoteiRiritu = setYoteiRirituEntity(
                        SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                        TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                        SUEOKIKKN_GONEN);

                    yoteiRirituList.add(yoteiRiritu);
                }

                BM_YoteiRiritu3 yoteiRiritu2 = setYoteiRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    SUEOKIKKN_JYUUNEN);

                yoteiRirituList.add(yoteiRiritu2);

            }

            bzSetMastaTorikomiRirituBean.setYoteiRirituList(yoteiRirituList);
        }

        else if (C_RirituSyuruiKbn.SJKKKTYOUSEIYOURIRITU.eq(pRirituSyuruiKbn)){

            batchLogger.info("マスタ取込利率設定値　基準日自＝" + KIJYUNFROMYMD.toString());
            batchLogger.info("マスタ取込利率設定値　基準日至＝" + KIJYUNTOYMD.toString());
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率＝" + USDSJKKKTYOUSEIYOURIRITU.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率（５年）＝" + USDSJKKKTYOUSEIYOURIRITU_GONEN.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率（１０年）＝" + USDSJKKKTYOUSEIYOURIRITU_JYUUNEN.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率（ＪＧ改定）＝" + USDSJKKKTYOUSEIYOURIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率（５年）（ガウディ）＝" + USDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　米ドル市場価格調整用利率（１０年）（ガウディ）＝" + USDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率＝" + AUDSJKKKTYOUSEIYOURIRITU.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率（５年）＝" + AUDSJKKKTYOUSEIYOURIRITU_GONEN.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率（１０年）＝" + AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率（ＪＧ改定）＝" + AUDSJKKKTYOUSEIYOURIRITU_JGKAITEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率（５年）（ガウディ）＝" + AUDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI.toString(rirituFormat));
            batchLogger.info("マスタ取込利率設定値　豪ドル市場価格調整用利率（１０年）（ガウディ）＝" + AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI.toString(rirituFormat));

            List<BM_SjkkkTyouseiyouRiritu2> sjkkkTyouseiyouRirituList = new ArrayList<>();

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR.length; i++) {

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[i],
                    TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR[i],
                    BLANK);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu);
            }

            //            if (HATUBAIKAISIYMD_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR.compareTo(KIJYUNFROMYMD) <= 0) {

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR.length; i++) {

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
                    TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
                    SUEOKIKKN_GONEN);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu);

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu2 = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
                    TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR[i],
                    SUEOKIKKN_JYUUNEN);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu2);
            }
            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19.length; i++) {

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[i],
                    TUUKASYUARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19[i],
                    BLANK);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu);
            }

            for(int i = 0; i < SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20.length; i++) {

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    SUEOKIKKN_GONEN);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu);

                BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu2 = setSjkkkTyouseiyouRirituEntity(
                    SHOUHINCDARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    TUUKASYUARRAY_GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20[i],
                    SUEOKIKKN_JYUUNEN);

                sjkkkTyouseiyouRirituList.add(sjkkkTyouseiyouRiritu2);
            }

            bzSetMastaTorikomiRirituBean.setSjkkkTyouseiyouRirituList(sjkkkTyouseiyouRirituList);

        }

        logger.debug("△ マスタ取込利率設定 終了");

        return bzSetMastaTorikomiRirituBean;

    }

    private BM_YoteiRiritu3 setYoteiRirituEntity(String pSyouhncd, C_Tuukasyu pTuukasyu, String pYoteiriritutkybr1){

        BM_YoteiRiritu3 yoteiRiritu = new BM_YoteiRiritu3();

        yoteiRiritu.setSyouhncd(pSyouhncd);
        yoteiRiritu.setTuukasyu(pTuukasyu);
        yoteiRiritu.setYoteiriritutkybr1(pYoteiriritutkybr1);
        yoteiRiritu.setYoteiriritutkybr2(BLANK);

        if (Arrays.asList(SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN).contains(pSyouhncd)){
            yoteiRiritu.setKijyunfromymd(KIJYUNFROMYMD_ONCEMONTH);
            yoteiRiritu.setKijyuntoymd(KIJYUNTOYMD_ONCEMONTH);
        } else {
            yoteiRiritu.setKijyunfromymd(KIJYUNFROMYMD);
            yoteiRiritu.setKijyuntoymd(KIJYUNTOYMD);
        }

        if (C_Tuukasyu.USD.eq(pTuukasyu)) {

            if (pYoteiriritutkybr1.equals(BLANK)) {

                if (Arrays.asList(SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN).contains(pSyouhncd)){
                    yoteiRiritu.setYoteiriritu(USDKIJUNRIRITU);

                }
                else if (Arrays.asList(SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19).contains(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU_JGKAITEI);
                    yoteiRiritu.setTumitateriritu(USDTUMITATERIRITU_JGKAITEI);
                    yoteiRiritu.setLoadinghnkgtumitateriritu(USDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI);

                } else {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU);
                }

            } else if (pYoteiriritutkybr1.equals(SUEOKIKKN_GONEN)) {
                if ("ﾕｹ".equals(pSyouhncd) || "ﾕｺ".equals(pSyouhncd) || "ﾕｻ".equals(pSyouhncd) || "ﾕｼ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU_GONEN);
                    yoteiRiritu.setTumitateriritu(USDTUMITATERIRITU_GONEN);
                    yoteiRiritu.setTmttknzoukaritujygn(USDTMTTKNZOUKARITUJYGN_GONEN);
                    yoteiRiritu.setSetteibairitu(USDSETTEIBAIRITU_GONEN);
                }

                else if ("ﾕﾍ".equals(pSyouhncd) || "ﾕﾎ".equals(pSyouhncd) || "ﾕﾏ".equals(pSyouhncd) || "ﾕﾐ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU_GONEN_GAUDEI);
                    yoteiRiritu.setTumitateriritu(USDTUMITATERIRITU_GONEN_GAUDEI);
                    yoteiRiritu.setRendouritu(USDRENDOURITU_GONEN_GAUDEI);
                }

            } else if (pYoteiriritutkybr1.equals(SUEOKIKKN_JYUUNEN)) {
                if ("ﾕｹ".equals(pSyouhncd) || "ﾕｺ".equals(pSyouhncd) || "ﾕｻ".equals(pSyouhncd) || "ﾕｼ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU_JYUUNEN);
                    yoteiRiritu.setTumitateriritu(USDTUMITATERIRITU_JYUUNEN);
                    yoteiRiritu.setTmttknzoukaritujygn(USDTMTTKNZOUKARITUJYGN_JYUUNEN);
                    yoteiRiritu.setSetteibairitu(USDSETTEIBAIRITU_JYUUNEN);
                }
                else if ("ﾕﾍ".equals(pSyouhncd) || "ﾕﾎ".equals(pSyouhncd) || "ﾕﾏ".equals(pSyouhncd) || "ﾕﾐ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(USDYOTEIRIRITU_JYUUNEN_GAUDEI);
                    yoteiRiritu.setTumitateriritu(USDTUMITATERIRITU_JYUUNEN_GAUDEI);
                    yoteiRiritu.setRendouritu(USDRENDOURITU_JYUUNEN_GAUDEI);
                }
            }
        }
        else if(C_Tuukasyu.AUD.eq(pTuukasyu)){

            if (pYoteiriritutkybr1.equals(BLANK)) {
                yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU);

                if (Arrays.asList(SHOUHINCDARRAY_YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN).contains(pSyouhncd)){
                    yoteiRiritu.setYoteiriritu(AUDKIJUNRIRITU);
                }
                else if (Arrays.asList(SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19).contains(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU_JGKAITEI);
                    yoteiRiritu.setTumitateriritu(AUDTUMITATERIRITU_JGKAITEI);
                    yoteiRiritu.setLoadinghnkgtumitateriritu(AUDLOADINGHENKOUGOTUMITATERIRITU_JGKAITEI);

                } else {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU);
                }

            } else if (pYoteiriritutkybr1.equals(SUEOKIKKN_GONEN)) {
                if ("ﾕｽ".equals(pSyouhncd) || "ﾕｾ".equals(pSyouhncd) || "ﾕｿ".equals(pSyouhncd) || "ﾕﾀ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU_GONEN);
                    yoteiRiritu.setTumitateriritu(AUDTUMITATERIRITU_GONEN);
                    yoteiRiritu.setTmttknzoukaritujygn(AUDTMTTKNZOUKARITUJYGN_GONEN);
                    yoteiRiritu.setSetteibairitu(AUDSETTEIBAIRITU_GONEN);
                }
                else if ("ﾕﾕ".equals(pSyouhncd) || "ﾕﾖ".equals(pSyouhncd) || "ﾕﾗ".equals(pSyouhncd) || "ﾕﾘ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU_GONEN_GAUDEI);
                    yoteiRiritu.setTumitateriritu(AUDTUMITATERIRITU_GONEN_GAUDEI);
                    yoteiRiritu.setRendouritu(AUDRENDOURITU_GONEN_GAUDEI);
                }

            } else if (pYoteiriritutkybr1.equals(SUEOKIKKN_JYUUNEN)) {
                if ("ﾕｽ".equals(pSyouhncd) || "ﾕｾ".equals(pSyouhncd) || "ﾕｿ".equals(pSyouhncd) || "ﾕﾀ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU_JYUUNEN);
                    yoteiRiritu.setTumitateriritu(AUDTUMITATERIRITU_JYUUNEN);
                    yoteiRiritu.setTmttknzoukaritujygn(AUDTMTTKNZOUKARITUJYGN_JYUUNEN);
                    yoteiRiritu.setSetteibairitu(AUDSETTEIBAIRITU_JYUUNEN);
                }
                else if ("ﾕﾕ".equals(pSyouhncd) || "ﾕﾖ".equals(pSyouhncd) || "ﾕﾗ".equals(pSyouhncd) || "ﾕﾘ".equals(pSyouhncd)) {
                    yoteiRiritu.setYoteiriritu(AUDYOTEIRIRITU_JYUUNEN_GAUDEI);
                    yoteiRiritu.setTumitateriritu(AUDTUMITATERIRITU_JYUUNEN_GAUDEI);
                    yoteiRiritu.setRendouritu(AUDRENDOURITU_JYUUNEN_GAUDEI);
                }
            }

        }

        BizPropertyInitializer.initialize(yoteiRiritu);

        return yoteiRiritu;
    }

    private BM_SjkkkTyouseiyouRiritu2 setSjkkkTyouseiyouRirituEntity(String pSyouhncd, C_Tuukasyu pTuukasyu, String pSjkkktyouseiriritutkybr1){

        BM_SjkkkTyouseiyouRiritu2 sjkkkTyouseiyouRiritu = new BM_SjkkkTyouseiyouRiritu2();

        sjkkkTyouseiyouRiritu.setSyouhncd(pSyouhncd);
        sjkkkTyouseiyouRiritu.setSjkkktyouseiriritutkybr1(pSjkkktyouseiriritutkybr1);
        sjkkkTyouseiyouRiritu.setSjkkktyouseiriritutkybr2(BLANK);
        sjkkkTyouseiyouRiritu.setKijyunfromymd(KIJYUNFROMYMD);
        sjkkkTyouseiyouRiritu.setKijyuntoymd(KIJYUNTOYMD);
        sjkkkTyouseiyouRiritu.setTuukasyu(pTuukasyu);

        if(C_Tuukasyu.USD.eq(pTuukasyu)){

            if (pSjkkktyouseiriritutkybr1.equals(BLANK)) {

                if (Arrays.asList(SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19).contains(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU_JGKAITEI);
                }
                else {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU);
                }
            } else if (pSjkkktyouseiriritutkybr1.equals(SUEOKIKKN_GONEN)) {
                if ("ﾕｹ".equals(pSyouhncd) || "ﾕｺ".equals(pSyouhncd) || "ﾕｻ".equals(pSyouhncd) || "ﾕｼ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU_GONEN);
                }

                else if ("ﾕﾍ".equals(pSyouhncd) || "ﾕﾎ".equals(pSyouhncd) || "ﾕﾏ".equals(pSyouhncd) || "ﾕﾐ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI);
                }

            } else if (pSjkkktyouseiriritutkybr1.equals(SUEOKIKKN_JYUUNEN)) {
                if ("ﾕｹ".equals(pSyouhncd) || "ﾕｺ".equals(pSyouhncd) || "ﾕｻ".equals(pSyouhncd) || "ﾕｼ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU_JYUUNEN);
                }
                else if ("ﾕﾍ".equals(pSyouhncd) || "ﾕﾎ".equals(pSyouhncd) || "ﾕﾏ".equals(pSyouhncd) || "ﾕﾐ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(USDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI);
                }
            }
        }
        else if(C_Tuukasyu.AUD.eq(pTuukasyu)){

            if (pSjkkktyouseiriritutkybr1.equals(BLANK)) {

                if (Arrays.asList(SHOUHINCDARRAY_GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19).contains(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU_JGKAITEI);
                }
                else {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU);
                }
            } else if (pSjkkktyouseiriritutkybr1.equals(SUEOKIKKN_GONEN)) {
                if ("ﾕｽ".equals(pSyouhncd) || "ﾕｾ".equals(pSyouhncd) || "ﾕｿ".equals(pSyouhncd) || "ﾕﾀ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU_GONEN);
                }
                else if ("ﾕﾕ".equals(pSyouhncd) || "ﾕﾖ".equals(pSyouhncd) || "ﾕﾗ".equals(pSyouhncd) || "ﾕﾘ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU_GONEN_GAUDEI);
                }
            }
            else if (pSjkkktyouseiriritutkybr1.equals(SUEOKIKKN_JYUUNEN)) {
                if ("ﾕｽ".equals(pSyouhncd) || "ﾕｾ".equals(pSyouhncd) || "ﾕｿ".equals(pSyouhncd) || "ﾕﾀ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN);
                }
                else if ("ﾕﾕ".equals(pSyouhncd) || "ﾕﾖ".equals(pSyouhncd) || "ﾕﾗ".equals(pSyouhncd) || "ﾕﾘ".equals(pSyouhncd)) {
                    sjkkkTyouseiyouRiritu.setSjkkktyouseiyouriritu(AUDSJKKKTYOUSEIYOURIRITU_JYUUNEN_GAUDEI);
                }
            }
        }

        BizPropertyInitializer.initialize(sjkkkTyouseiyouRiritu);

        return sjkkkTyouseiyouRiritu;
    }
}