package yuyu.common.hozen.ascommon;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.hozen.ascommon.dba4keisanzennouseisangk2.KeisanZennouSeisanGk2Dao;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.BM_ZennouRiritu2;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 案内収納共通 前納精算額計算２
 */
public class KeisanZennouSeisanGk2 {

    public static final String TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK = "1";

    public static final String TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK = "2";

    public static final String TKYTMMTTZNDKHIKAKBN_DOUGAKU = "3";

    public static final String TKYTMMTTZNDKHIKAKBN_TAISYOUGAI = "9";

    public static final String ZENNOUPSEISANKBN_JINENDOP = "1";

    public static final String ZENNOUPSEISANKBN_SONOTA = "2";

    private BizCurrency zennouSeisanGk;

    private BizCurrency zennouSeisanGkKnsnTk;

    private BizDate zennouSeisanKijyunYmd;

    private String tkyTmttZndkHikakuKbn;

    private List<BizDate> zennouTmttrituHnkbiList;

    private BizDateYM lastPJyuutouYm;

    private List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList;

    private List<KykOutoubiZennouZndkKnsnBean> kykOutoubiZennouZndkKnsnList;

    private BizNumber knsnKwsRate;

    @Inject
    private KeisanZennouSeisanGk2Dao keisanZennouSeisanGk2Dao;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanZennouSeisanGk2() {
        super();
    }

    public C_ErrorKbn exec(
        BizDate pZennouseisankijyunymd,
        BizDate pKykymd,
        BizCurrency pZennoujihrkp,
        BizDate pZennouStartYmd,
        BizDate pRyosyuymd,
        BizCurrency pZennounyuukinkgk) {

        logger.debug("▽ 前納精算額計算（詳細指定） 開始");


        String tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_TAISYOUGAI;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate zennoukaisidy = pZennouStartYmd.addYears(-1).getRekijyou();

        lastPJyuutouYm = zennoukaisidy.getBizDateYM();

        tkyTmttZndkHikakuKbn = TKYTMMTTZNDKHIKAKBN_TAISYOUGAI;

        zennouTmttrituHnkbiList = new ArrayList<>();

        kykOutoubiZennouZndkList = new ArrayList<>();

        if (BizDateUtil.compareYmd(pRyosyuymd, pZennouStartYmd) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pRyosyuymd, pZennouStartYmd) == BizDateUtil.COMPARE_EQUAL) {

            logger.info("前納精算額計算エラー。領収日が前納開始年月日以降になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu keisannTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pZennoujihrkp.getType());

        BizCurrency zennoujihrkp = null;

        BizCurrency zennounyuukinkgk = null;

        if (C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennoujihrkp = pZennoujihrkp;

            zennounyuukinkgk = pZennounyuukinkgk;
        }
        else {

            zennoujihrkp = pZennoujihrkp.multiply(100);

            zennounyuukinkgk = pZennounyuukinkgk.multiply(100);
        }


        BizDate taisyouYmd = null;

        Integer keikaMon = 0;

        if (BizDateUtil.compareYmd(pZennouseisankijyunymd, pRyosyuymd) == BizDateUtil.COMPARE_LESSER) {

            zennouSeisanGk = pZennounyuukinkgk;

            zennouSeisanKijyunYmd = pZennouseisankijyunymd;

            return errorKbn;
        }

        if (BizDateUtil.compareYmd(pZennouseisankijyunymd, pZennouStartYmd) == BizDateUtil.COMPARE_LESSER) {

            taisyouYmd = pZennouseisankijyunymd;
        }
        else {

            taisyouYmd = pZennouStartYmd;
        }

        BizDateSpan dateSpan = BizDateUtil.calcDifference(pRyosyuymd, taisyouYmd);

        keikaMon = dateSpan.getYears() * 12 + dateSpan.getMonths();

        int keikaDay = dateSpan.getDays();

        if (keikaDay > 15) {

            keikaMon = keikaMon + 1;
        }

        if (keikaMon > 12) {

            logger.info("前納精算額計算エラー。経過月数が１３ヶ月以上となっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BM_ZennouRiritu2 zennouRiritu2 = keisanZennouSeisanGk2Dao.getZennouRiritu2(keisannTuukasyu, pRyosyuymd);

        if (zennouRiritu2 == null) {

            logger.info("前納精算額計算エラー。前納利率マスタにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BizNumber zennouRirituBn = zennouRiritu2.getZennouriritu();

        BizNumber zennouKeikaRirituBn = BizNumber.ONE.add(zennouRirituBn.multiply(keikaMon).divide(12, 10,
            RoundingMode.DOWN));

        BizNumber tempZennouRirituGk = BizNumber.valueOf(zennounyuukinkgk).multiply(zennouKeikaRirituBn, 0,
            RoundingMode.DOWN);

        BizCurrency zennouRirituGk = BizCurrency.valueOf(new BigDecimal(tempZennouRirituGk.toString()), zennounyuukinkgk.getType());

        GetZennouKikanRiritu2 getZennouKikanRiritu2 = SWAKInjector.getInstance(GetZennouKikanRiritu2.class);

        C_ErrorKbn getZennouKikanRiritu2ErrorKbn = getZennouKikanRiritu2.exec(keisannTuukasyu, pRyosyuymd, taisyouYmd,
            pKykymd);

        if (C_ErrorKbn.ERROR.eq(getZennouKikanRiritu2ErrorKbn)) {

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BizNumber zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();

        zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu2.getZennouTmttrituHnkbiList());

        BizNumber tempTumitateRirituGk = BizNumber.valueOf(zennounyuukinkgk).multiply(zennouKikanRiritu.add
            (BizNumber.ONE), 0, RoundingMode.DOWN);

        BizCurrency tumitateRirituGk = BizCurrency.valueOf(new BigDecimal(tempTumitateRirituGk.toString()), zennounyuukinkgk.getType());

        BizCurrency zennouSeisankGk = BizCurrency.valueOf(0);

        if (zennouRirituGk.compareTo(tumitateRirituGk) >= 0) {

            zennouSeisankGk = zennouRirituGk;

            if (zennouRirituGk.compareTo(tumitateRirituGk) > 0) {

                tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK;
            }
            else {

                tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_DOUGAKU;
            }
        }
        else {

            zennouSeisankGk = tumitateRirituGk;

            tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK;
        }

        if (BizDateUtil.compareYmd(pZennouseisankijyunymd, pZennouStartYmd) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pZennouseisankijyunymd, pZennouStartYmd) == BizDateUtil.COMPARE_EQUAL) {


            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

            BizDate zennouJyuutouEndYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKZEN,
                pKykymd, C_Hrkkaisuu.NEN, pZennouseisankijyunymd);

            int count = zennouJyuutouEndYmd.getYear() - pZennouStartYmd.getYear();

            BizCurrency zennouZndk = BizCurrency.valueOf(0);

            BizCurrency jyuutoumaeZennouZndk = BizCurrency.valueOf(0);

            BizCurrency znnurrttkyZnnuzndk = BizCurrency.valueOf(0);

            BizCurrency znnurrttkyjytmaeZnnuzndk = BizCurrency.valueOf(0);

            for (int n = 0; n < count; n++) {

                BizDate keiyakuoutoubi = BizDate.valueOf(pZennouStartYmd.getBizDateYM().addYears(n), pKykymd.getDay())
                    .getRekijyou();

                BizDate twokeiyakuoutoubi = BizDate
                    .valueOf(keiyakuoutoubi.getBizDateYM().addYears(1), pKykymd.getDay()).getRekijyou();

                lastPJyuutouYm = keiyakuoutoubi.getBizDateYM();

                zennouZndk = zennouSeisankGk.subtract(zennoujihrkp);

                jyuutoumaeZennouZndk = zennouSeisankGk;

                znnurrttkyZnnuzndk = zennouRirituGk.subtract(zennoujihrkp);

                znnurrttkyjytmaeZnnuzndk = zennouRirituGk;

                if (BizCurrency.valueOf(0, zennouZndk.getType()).compareTo(zennouZndk) > 0) {

                    zennouZndk = BizCurrency.valueOf(0, zennouZndk.getType());
                }

                if (BizCurrency.valueOf(0, jyuutoumaeZennouZndk.getType()).compareTo(jyuutoumaeZennouZndk) > 0) {

                    jyuutoumaeZennouZndk = BizCurrency.valueOf(0, jyuutoumaeZennouZndk.getType());
                }

                if (BizCurrency.valueOf(0, znnurrttkyZnnuzndk.getType()).compareTo(znnurrttkyZnnuzndk) > 0) {

                    znnurrttkyZnnuzndk = BizCurrency.valueOf(0, znnurrttkyZnnuzndk.getType());
                }

                if (BizCurrency.valueOf(0, znnurrttkyjytmaeZnnuzndk.getType()).compareTo(znnurrttkyjytmaeZnnuzndk) > 0) {

                    znnurrttkyjytmaeZnnuzndk = BizCurrency.valueOf(0, znnurrttkyjytmaeZnnuzndk.getType());
                }

                if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

                    zennouZndk = zennouZndk.divide(100);

                    jyuutoumaeZennouZndk = jyuutoumaeZennouZndk.divide(100);

                    znnurrttkyZnnuzndk = znnurrttkyZnnuzndk.divide(100);

                    znnurrttkyjytmaeZnnuzndk = znnurrttkyjytmaeZnnuzndk.divide(100);
                }

                KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);

                kykOutoubiZennouZndkBean.setKykOutoubi(keiyakuoutoubi);

                kykOutoubiZennouZndkBean.setZennouZndk(zennouZndk);

                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(jyuutoumaeZennouZndk);

                kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(znnurrttkyZnnuzndk);

                kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(znnurrttkyjytmaeZnnuzndk);

                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

                BizNumber tempZennouRirituGk2 =
                    BizNumber.valueOf(zennouRirituGk.subtract(zennoujihrkp)).multiply(
                        BizNumber.ONE.add(zennouRirituBn), 0, RoundingMode.DOWN);

                zennouRirituGk = BizCurrency.valueOf(new BigDecimal(tempZennouRirituGk2.toString()), zennouRirituGk.getType());

                getZennouKikanRiritu2 = SWAKInjector.getInstance(GetZennouKikanRiritu2.class);

                getZennouKikanRiritu2ErrorKbn = getZennouKikanRiritu2.exec(keisannTuukasyu, keiyakuoutoubi,
                    twokeiyakuoutoubi, pKykymd);

                if (C_ErrorKbn.ERROR.eq(getZennouKikanRiritu2ErrorKbn)) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }

                zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();

                zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu2.getZennouTmttrituHnkbiList());

                BizNumber tempTumitateRirituGk2 = BizNumber.valueOf(zennouSeisankGk.subtract(zennoujihrkp)).multiply(BizNumber.ONE.add(zennouKikanRiritu),
                    0, RoundingMode.DOWN);

                tumitateRirituGk = BizCurrency.valueOf(new BigDecimal(tempTumitateRirituGk2.toString()), tumitateRirituGk.getType());

                if (zennouRirituGk.compareTo(tumitateRirituGk) >= 0) {

                    zennouSeisankGk = zennouRirituGk;

                    if (zennouRirituGk.compareTo(tumitateRirituGk) > 0) {

                        tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK;
                    }
                    else {

                        tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_DOUGAKU;
                    }
                }
                else {

                    zennouSeisankGk = tumitateRirituGk;

                    tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK;
                }
            }


            zennouZndk = zennouSeisankGk.subtract(zennoujihrkp);

            jyuutoumaeZennouZndk = zennouSeisankGk;

            znnurrttkyZnnuzndk = zennouRirituGk.subtract(zennoujihrkp);

            znnurrttkyjytmaeZnnuzndk = zennouRirituGk;

            if (BizCurrency.valueOf(0, zennouZndk.getType()).compareTo(zennouZndk) > 0) {

                zennouZndk = BizCurrency.valueOf(0, zennouZndk.getType());
            }

            if (BizCurrency.valueOf(0, jyuutoumaeZennouZndk.getType()).compareTo(jyuutoumaeZennouZndk) > 0) {

                jyuutoumaeZennouZndk = BizCurrency.valueOf(0, jyuutoumaeZennouZndk.getType());
            }

            if (BizCurrency.valueOf(0, znnurrttkyZnnuzndk.getType()).compareTo(znnurrttkyZnnuzndk) > 0) {

                znnurrttkyZnnuzndk = BizCurrency.valueOf(0, znnurrttkyZnnuzndk.getType());
            }

            if (BizCurrency.valueOf(0, znnurrttkyjytmaeZnnuzndk.getType()).compareTo(znnurrttkyjytmaeZnnuzndk) > 0) {

                znnurrttkyjytmaeZnnuzndk = BizCurrency.valueOf(0, znnurrttkyjytmaeZnnuzndk.getType());
            }

            if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

                zennouZndk = zennouZndk.divide(100);

                jyuutoumaeZennouZndk = jyuutoumaeZennouZndk.divide(100);

                znnurrttkyZnnuzndk = znnurrttkyZnnuzndk.divide(100);

                znnurrttkyjytmaeZnnuzndk = znnurrttkyjytmaeZnnuzndk.divide(100);
            }

            KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);

            kykOutoubiZennouZndkBean.setKykOutoubi(zennouJyuutouEndYmd);

            kykOutoubiZennouZndkBean.setZennouZndk(zennouZndk);

            kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(jyuutoumaeZennouZndk);

            kykOutoubiZennouZndkBean.setZnnurrttkyZnnuzndk(znnurrttkyZnnuzndk);

            kykOutoubiZennouZndkBean.setZnnurrttkyjytmaeZnnuzndk(znnurrttkyjytmaeZnnuzndk);

            kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);

            zennouRirituGk = zennouRirituGk.subtract(zennoujihrkp);

            zennouSeisankGk = zennouSeisankGk.subtract(zennoujihrkp);

            lastPJyuutouYm = zennouJyuutouEndYmd.getBizDateYM();

            BizDateSpan dateSpanTemp = BizDateUtil.calcDifference(zennouJyuutouEndYmd, pZennouseisankijyunymd);

            int kasanKeikaTukisuu = dateSpanTemp.getYears() * 12 + dateSpanTemp.getMonths();

            int kasanKeikaNissuu = dateSpanTemp.getDays();

            if (kasanKeikaNissuu > 15) {

                kasanKeikaTukisuu = kasanKeikaTukisuu + 1;
            }

            if (kasanKeikaTukisuu > 0) {

                zennouKeikaRirituBn = BizNumber.ONE.add(zennouRirituBn.multiply(kasanKeikaTukisuu).divide(12, 10,
                    RoundingMode.DOWN));

                BizNumber tempZennouRirituGk3 = BizNumber.valueOf(zennouRirituGk).multiply(zennouKeikaRirituBn, 0, RoundingMode.DOWN);

                zennouRirituGk = BizCurrency.valueOf(new BigDecimal(tempZennouRirituGk3.toString()), zennouRirituGk.getType());

                getZennouKikanRiritu2 = SWAKInjector.getInstance(GetZennouKikanRiritu2.class);

                getZennouKikanRiritu2ErrorKbn = getZennouKikanRiritu2.exec(keisannTuukasyu, zennouJyuutouEndYmd,
                    pZennouseisankijyunymd, pKykymd);

                if (C_ErrorKbn.ERROR.eq(getZennouKikanRiritu2ErrorKbn)) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }

                zennouKikanRiritu = getZennouKikanRiritu2.getZennouKikanRiritu();

                zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu2.getZennouTmttrituHnkbiList());

                BizNumber tumitateRirituGk3 =
                    BizNumber.valueOf(zennouSeisankGk).multiply(BizNumber.ONE.add(zennouKikanRiritu), 0, RoundingMode.DOWN);

                tumitateRirituGk = BizCurrency.valueOf(new BigDecimal(tumitateRirituGk3.toString()), tumitateRirituGk.getType());

                if (zennouRirituGk.compareTo(tumitateRirituGk) >= 0) {

                    zennouSeisankGk = zennouRirituGk;

                    if (zennouRirituGk.compareTo(tumitateRirituGk) > 0) {

                        tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK;
                    }
                    else {

                        tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_DOUGAKU;
                    }
                }
                else {

                    zennouSeisankGk = tumitateRirituGk;

                    tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK;
                }
            }
        }


        if (BizCurrency.valueOf(0, zennouSeisankGk.getType()).compareTo(zennouSeisankGk) > 0) {

            zennouSeisankGk = BizCurrency.valueOf(0, zennouSeisankGk.getType());
        }

        if (!C_Tuukasyu.JPY.eq(keisannTuukasyu)) {

            zennouSeisankGk = zennouSeisankGk.divide(100);
        }

        zennouSeisanGk = zennouSeisankGk;

        zennouSeisanKijyunYmd = pZennouseisankijyunymd;

        tkyTmttZndkHikakuKbn = tkyTmttZndkHikakuKbnTemp;

        logger.debug("△ 前納精算額計算（詳細指定） 終了");

        return errorKbn;
    }

    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd, String pSyono) {

        logger.debug("▽ 前納精算額計算（前納精算基準日、証券番号指定） 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {

            logger.info("前納精算額計算エラー。契約基本テーブルにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        if (!C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

            if (C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {

                if (!C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(kykKihon.getTikiktbrisyuruikbn())) {

                    logger.info("前納精算額計算エラー。払込回数が年１回払、または月払の１２か月定期一括ではありません。");

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;
                }
            }
            else {

                logger.info("前納精算額計算エラー。払込回数が年１回払、または月払の１２か月定期一括ではありません。");

                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }
        }

        List<IT_KykSyouhn> kykSyouhnList = keisanZennouSeisanGk2Dao.getKykSyouhns(kykKihon);

        if (kykSyouhnList.size() == 0) {

            logger.info("前納精算額計算エラー。契約商品テーブルにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        IT_KykSyouhn kykSyouhn = kykSyouhnList.get(0);

        if (!C_Kykjyoutai.ZENNOU.eq(kykSyouhn.getKykjyoutai())) {

            logger.info("前納精算額計算エラー。契約状態が前納ではありません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;

        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

        if (ansyuKihon == null) {

            logger.info("前納精算額計算エラー。案内収納基本テーブルにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        BizDate jkipjytymd = BizDate.valueOf(ansyuKihon.getJkipjytym(), kykSyouhn.getKykymd().getDay()).getRekijyou();

        if (BizDateUtil.compareYmd(pZennouseisankijyunymd, jkipjytymd) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pZennouseisankijyunymd, jkipjytymd) == BizDateUtil.COMPARE_EQUAL) {

            logger.info("前納精算額計算エラー。前納精算基準日が次回Ｐ充当年月応当日以降になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        List<IT_Zennou> zennouList = keisanZennouSeisanGk2Dao.getZennous(ansyuKihon);

        if (zennouList.size() == 0) {

            logger.info("前納精算額計算エラー。前納テーブルにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        IT_Zennou zennou = zennouList.get(0);

        if (!C_ZennouSeisanKbn.MISEISAN.eq(zennou.getZennouseisankbn())) {

            logger.info("前納精算額計算エラー。対象の前納が精算済です。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        if (BizDateUtil.compareYmd(pZennouseisankijyunymd, (zennou.getZennoukaisiymd().addYears(
            Integer.valueOf(zennou.getZennoukikan())))) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pZennouseisankijyunymd, (zennou.getZennoukaisiymd().addYears(
                Integer.valueOf(zennou.getZennoukikan())))) == BizDateUtil.COMPARE_EQUAL) {

            logger.info("前納精算額計算エラー。前納精算基準日が前納満了日より未来になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }


        errorKbn = exec(pZennouseisankijyunymd, kykSyouhn.getKykymd(), zennou.getZennoujihrkp(),
            zennou.getZennoukaisiymd(), zennou.getRyosyuymd(), zennou.getZennounyuukinkgk());

        logger.debug("△ 前納精算額計算（前納精算基準日、証券番号指定） 終了");

        return errorKbn;
    }

    public C_ErrorKbn kansanZennouSeisanGk(
        BizCurrency pZennouSeisanGk,
        C_Tuukasyu pKnsnTuukasyu,
        BizDate pKnsnKwsratekjymd) {

        logger.debug("▽ 前納精算額換算処理 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        knsnKwsRate = null;

        zennouSeisanGkKnsnTk = null;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        C_Tuukasyu keisannTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pZennouSeisanGk.getType());

        if (keisannTuukasyu == pKnsnTuukasyu) {

            zennouSeisanGkKnsnTk = pZennouSeisanGk;
        }
        else {

            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

            C_ErrorKbn getKawaseRateErrorKbn = getKawaseRate.exec(pKnsnKwsratekjymd,
                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                keisannTuukasyu, pKnsnTuukasyu, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE,
                C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

            if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {

                errorKbn = C_ErrorKbn.ERROR;

                return errorKbn;
            }

            knsnKwsRate = getKawaseRate.getKawaserate();

            KeisanGaikakanzan keisanGaikakanzan  = SWAKInjector.getInstance(KeisanGaikakanzan.class);

            zennouSeisanGkKnsnTk = keisanGaikakanzan.exec(pKnsnTuukasyu, pZennouSeisanGk, knsnKwsRate,
                C_HasuusyoriKbn.SUTE);

        }

        logger.debug("△ 前納精算額換算処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn kansanKykOutoubiZennouZndkList(
        List<KykOutoubiZennouZndkBean> pKykOutoubiZennouZndkList,
        BizDate pSyoriYmd,
        C_Tuukasyu pKnsnTuukasyu,
        BizNumber pKnsnKwsRate) {

        logger.debug("▽ 契約応当日前納残高リスト換算処理 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        kykOutoubiZennouZndkKnsnList = new ArrayList<>();

        for (KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean: pKykOutoubiZennouZndkList) {

            KykOutoubiZennouZndkKnsnBean kykOutoubiZennouZndkKnsnBean = SWAKInjector
                .getInstance(KykOutoubiZennouZndkKnsnBean.class);
            kykOutoubiZennouZndkKnsnBean.setKykOutoubi(kykOutoubiZennouZndkBean.getKykOutoubi());
            kykOutoubiZennouZndkKnsnBean.setGetKawaseRateUmuKbn(C_UmuKbn.NONE);

            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
            C_Tuukasyu keisannTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(kykOutoubiZennouZndkBean.getZennouZndk().getType());

            if (keisannTuukasyu == pKnsnTuukasyu) {
                kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnTk(kykOutoubiZennouZndkBean.getZennouZndk());
                kykOutoubiZennouZndkKnsnBean.setJyuutoumaeZennouZndkKnsnTk(kykOutoubiZennouZndkBean.getJyuutoumaeZennouZndk());
                kykOutoubiZennouZndkKnsnBean.setZnnurrttkyZnnuzndkTuk(kykOutoubiZennouZndkBean.getZnnurrttkyZnnuzndk());
                kykOutoubiZennouZndkKnsnBean.setZnnurrttkyjytmaeZnnuzndkTuk(kykOutoubiZennouZndkBean.getZnnurrttkyjytmaeZnnuzndk());
                kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnKawaseRate(null);
            }
            else {

                if (BizDateUtil.compareYmd(kykOutoubiZennouZndkBean.getKykOutoubi(), pSyoriYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(kykOutoubiZennouZndkBean.getKykOutoubi(), pSyoriYmd) == BizDateUtil.COMPARE_EQUAL) {

                    GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);

                    C_ErrorKbn getKawaseRateErrorKbn = getKawaseRate.exec(kykOutoubiZennouZndkBean.getKykOutoubi(),
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE, keisannTuukasyu, pKnsnTuukasyu, C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.SYUKKINRATE, C_EigyoubiHoseiKbn.YOKUEIGYOUBI, C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(getKawaseRateErrorKbn)) {

                        if (BizDateUtil.compareYmd(kykOutoubiZennouZndkBean.getKykOutoubi(), pSyoriYmd) == BizDateUtil.COMPARE_LESSER) {

                            errorKbn = C_ErrorKbn.ERROR;

                            return errorKbn;
                        }

                        kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnKawaseRate(pKnsnKwsRate);
                    }
                    else {
                        kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnKawaseRate(getKawaseRate.getKawaserate());
                        kykOutoubiZennouZndkKnsnBean.setGetKawaseRateUmuKbn(C_UmuKbn.ARI);
                    }
                }
                else {

                    kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnKawaseRate(pKnsnKwsRate);
                }

                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                BizCurrency kanzanGaku1 = keisanGaikakanzan.exec(pKnsnTuukasyu,
                    kykOutoubiZennouZndkBean.getZennouZndk(),
                    kykOutoubiZennouZndkKnsnBean.getZennouZndkKnsnKawaseRate(), C_HasuusyoriKbn.SUTE);
                kykOutoubiZennouZndkKnsnBean.setZennouZndkKnsnTk(kanzanGaku1);

                BizCurrency kanzanGaku2 = keisanGaikakanzan.exec(pKnsnTuukasyu,
                    kykOutoubiZennouZndkBean.getJyuutoumaeZennouZndk(),
                    kykOutoubiZennouZndkKnsnBean.getZennouZndkKnsnKawaseRate(), C_HasuusyoriKbn.SUTE);
                kykOutoubiZennouZndkKnsnBean.setJyuutoumaeZennouZndkKnsnTk(kanzanGaku2);

                BizCurrency kanzanGaku3 = keisanGaikakanzan.exec(pKnsnTuukasyu,
                    kykOutoubiZennouZndkBean.getZnnurrttkyZnnuzndk(),
                    kykOutoubiZennouZndkKnsnBean.getZennouZndkKnsnKawaseRate(), C_HasuusyoriKbn.SUTE);
                kykOutoubiZennouZndkKnsnBean.setZnnurrttkyZnnuzndkTuk(kanzanGaku3);

                BizCurrency kanzanGaku4 = keisanGaikakanzan.exec(pKnsnTuukasyu,
                    kykOutoubiZennouZndkBean.getZnnurrttkyjytmaeZnnuzndk(),
                    kykOutoubiZennouZndkKnsnBean.getZennouZndkKnsnKawaseRate(), C_HasuusyoriKbn.SUTE);
                kykOutoubiZennouZndkKnsnBean.setZnnurrttkyjytmaeZnnuzndkTuk(kanzanGaku4);

            }

            kykOutoubiZennouZndkKnsnList.add(kykOutoubiZennouZndkKnsnBean);

        }

        logger.debug("△ 契約応当日前納残高リスト換算処理 終了");

        return errorKbn;
    }

    public BizCurrency getZennouSeisanGk() {
        return zennouSeisanGk;
    }

    public BizDate getZennouSeisanKijyunYmd() {
        return zennouSeisanKijyunYmd;
    }

    public String getTkyTmttZndkHikakuKbn() {
        return tkyTmttZndkHikakuKbn;
    }

    public String getZennouPSeisanKbn(BizDate pRyosyuymd, BizDate pDenYmd) {

        logger.debug("▽ 前納Ｐ精算区分取得 開始");

        BizDateY zenNyuJinendo = null;

        if (pRyosyuymd.getMonth() <= 3) {

            zenNyuJinendo = pRyosyuymd.getBizDateY().addYears(-1);
        }
        else {

            zenNyuJinendo = pRyosyuymd.getBizDateY();
        }

        BizDateY denHizJigNendo = null;

        if (pDenYmd.getMonth() <= 3) {

            denHizJigNendo = pDenYmd.getBizDateY().addYears(-1);
        }
        else {

            denHizJigNendo = pDenYmd.getBizDateY();
        }

        String zennouPSeisanKbn = "";

        if (zenNyuJinendo.compareTo(denHizJigNendo) >= 0) {

            zennouPSeisanKbn = ZENNOUPSEISANKBN_JINENDOP;
        }
        else {

            zennouPSeisanKbn = ZENNOUPSEISANKBN_SONOTA;
        }

        logger.debug("△ 前納Ｐ精算区分取得 終了");

        return zennouPSeisanKbn;
    }

    public List<BizDate> getZennouTmttrituHnkbiList() {
        return zennouTmttrituHnkbiList;
    }

    public BizDateYM getLastPJyuutouYm() {
        return lastPJyuutouYm;
    }

    public List<KykOutoubiZennouZndkBean> getKykOutoubiZennouZndkList() {
        return kykOutoubiZennouZndkList;
    }

    public BizCurrency getZennouSeisanGkKnsnTk() {
        return zennouSeisanGkKnsnTk;
    }

    public BizNumber getKnsnKwsRate() {
        return knsnKwsRate;
    }

    public List<KykOutoubiZennouZndkKnsnBean> getKykOutoubiZennouZndkKnsnList() {
        return kykOutoubiZennouZndkKnsnList;
    }
}
