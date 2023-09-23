package yuyu.common.hozen.khcommon;

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
import yuyu.common.hozen.khcommon.dba4keisanzennouseisangk.KeisanZennouSeisanGkDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_ZennouSeisanKbn;
import yuyu.def.db.entity.BM_ZennouRiritu;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 前納精算額計算
 */
public class KeisanZennouSeisanGk {

    private BizCurrency zennouSeisanGk;

    private BizDate zennouSeisanKijyunYmd;

    private String tkyTmttZndkHikakuKbn;

    private List<BizDate> zennouTmttrituHnkbiList;

    private BizDateYM lastPJyuutouYm;

    private List<KykOutoubiZennouZndkBean> kykOutoubiZennouZndkList;

    public static final String TKYTMMTTZNDKHIKAKBN_ZNNRIRITUZNDK = "1";

    public static final String TKYTMMTTZNDKHIKAKBN_ZNNTMIRIRITUZNDK = "2";

    public static final String TKYTMMTTZNDKHIKAKBN_DOUGAKU = "3";

    public static final String TKYTMMTTZNDKHIKAKBN_TAISYOUGAI = "9";

    public static final String ZENNOUPSEISANKBN_JINENDOP = "1";

    public static final String ZENNOUPSEISANKBN_SONOTA = "2";

    @Inject
    private KeisanZennouSeisanGkDao keisanZennouSeisanGkDao;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public KeisanZennouSeisanGk() {
        super();
    }

    public BizCurrency getZennouSeisanGk() {
        return zennouSeisanGk;
    }

    public BizDate getZennouSeisanKijyunYmd() {
        return zennouSeisanKijyunYmd;
    }

    public C_ErrorKbn exec(BizDate pZennouseisankijyunymd,
        BizDate pKykymd, BizCurrency pZennoujihrkp,
        BizDate pZennouStartYmd, BizDate pRyosyuymd,
        BizCurrency pZennounyuukinkgk) {

        logger.debug("▽ 前納精算額計算（前納精算基準日、契約日、前納時払込保険料、前納開始年月日、領収日、前納入金額指定） 開始");


        String tkyTmttZndkHikakuKbnTemp = TKYTMMTTZNDKHIKAKBN_TAISYOUGAI;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        BizDate zennoukaisidy = pZennouStartYmd.addYears(-1).getRekijyou();

        lastPJyuutouYm = zennoukaisidy.getBizDateYM();

        zennouTmttrituHnkbiList = new ArrayList<>();

        kykOutoubiZennouZndkList = new ArrayList<>();

        tkyTmttZndkHikakuKbn = TKYTMMTTZNDKHIKAKBN_TAISYOUGAI;

        if (BizDateUtil.compareYmd(pRyosyuymd, pZennouStartYmd) == BizDateUtil.COMPARE_GREATER ||
            BizDateUtil.compareYmd(pRyosyuymd, pZennouStartYmd) == BizDateUtil.COMPARE_EQUAL) {

            logger.info("前納精算額計算エラー。領収日が前納開始年月日以降になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
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

        BM_ZennouRiritu zennouRiritu = keisanZennouSeisanGkDao.getZennouRiritu(pRyosyuymd);
        if (zennouRiritu == null) {

            logger.info("前納精算額計算エラー。前納利率マスタにデータが存在しません。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }
        BizNumber zennouRirituBn = zennouRiritu.getZennouriritu();
        BizNumber zennouKeikaRirituBn = BizNumber.ONE.add(zennouRirituBn.multiply(keikaMon).divide(12, 10,
            RoundingMode.DOWN));
        BizCurrency zennouRirituGk = pZennounyuukinkgk.multiply(zennouKeikaRirituBn, 0, RoundingMode.DOWN);

        GetZennouKikanRiritu getZennouKikanRiritu = SWAKInjector.getInstance(GetZennouKikanRiritu.class);

        C_ErrorKbn errorKbn1 = getZennouKikanRiritu.exec(pRyosyuymd, taisyouYmd, pKykymd);

        if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;

        }

        zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu.getZennouTmttrituHnkbiList());

        BizNumber zennouKikanRiritu = getZennouKikanRiritu.getZennouKikanRiritu();

        BizCurrency tumitateRirituGk = pZennounyuukinkgk.multiply(zennouKikanRiritu.add(BizNumber.ONE), 0,
            RoundingMode.DOWN);

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
            for (int n = 0; n < count; n++) {

                BizDate keiyakuoutoubi = BizDate.valueOf(pZennouStartYmd.getBizDateYM().addYears(n), pKykymd.getDay())
                    .getRekijyou();

                BizDate twokeiyakuoutoubi = BizDate
                    .valueOf(keiyakuoutoubi.getBizDateYM().addYears(1), pKykymd.getDay()).getRekijyou();

                lastPJyuutouYm = keiyakuoutoubi.getBizDateYM();

                KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
                BizCurrency zennouZndk = zennouSeisankGk.subtract(pZennoujihrkp);
                BizCurrency jyuutoumaeZennouZndk = zennouSeisankGk;

                if (BizCurrency.valueOf(0).compareTo(zennouZndk) > 0) {
                    zennouZndk = BizCurrency.valueOf(0);
                }
                if (BizCurrency.valueOf(0).compareTo(jyuutoumaeZennouZndk) > 0) {
                    jyuutoumaeZennouZndk = BizCurrency.valueOf(0);
                }

                kykOutoubiZennouZndkBean.setKykOutoubi(keiyakuoutoubi);
                kykOutoubiZennouZndkBean.setZennouZndk(zennouZndk);
                kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(jyuutoumaeZennouZndk);
                kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);
                
                zennouRirituGk = zennouRirituGk.subtract(pZennoujihrkp).multiply(zennouRirituBn.add(BizNumber.ONE), 0,
                    RoundingMode.DOWN);

                errorKbn1 = getZennouKikanRiritu.exec(keiyakuoutoubi, twokeiyakuoutoubi, pKykymd);

                if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;

                }

                zennouKikanRiritu = getZennouKikanRiritu.getZennouKikanRiritu();

                zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu.getZennouTmttrituHnkbiList());

                tumitateRirituGk = zennouSeisankGk.subtract(pZennoujihrkp).multiply(
                    BizNumber.ONE.add(zennouKikanRiritu), 0, RoundingMode.DOWN);

                
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

            KykOutoubiZennouZndkBean kykOutoubiZennouZndkBean = SWAKInjector.getInstance(KykOutoubiZennouZndkBean.class);
            BizCurrency zennouZndk = zennouSeisankGk.subtract(pZennoujihrkp);
            BizCurrency jyuutoumaeZennouZndk = zennouSeisankGk;

            if (BizCurrency.valueOf(0).compareTo(zennouZndk) > 0) {
                zennouZndk = BizCurrency.valueOf(0);
            }
            if (BizCurrency.valueOf(0).compareTo(jyuutoumaeZennouZndk) > 0) {
                jyuutoumaeZennouZndk = BizCurrency.valueOf(0);
            }

            kykOutoubiZennouZndkBean.setKykOutoubi(zennouJyuutouEndYmd);
            kykOutoubiZennouZndkBean.setZennouZndk(zennouZndk);
            kykOutoubiZennouZndkBean.setJyuutoumaeZennouZndk(jyuutoumaeZennouZndk);
            kykOutoubiZennouZndkList.add(kykOutoubiZennouZndkBean);
            
            zennouRirituGk = zennouRirituGk.subtract(pZennoujihrkp);

            zennouSeisankGk = zennouSeisankGk.subtract(pZennoujihrkp);

            lastPJyuutouYm = zennouJyuutouEndYmd.getBizDateYM();


            BizDateSpan dateSpanTemp =  BizDateUtil.calcDifference(zennouJyuutouEndYmd, pZennouseisankijyunymd);
            int kasanKeikaTukisuu = dateSpanTemp.getYears() * 12 + dateSpanTemp.getMonths();

            int kasanKeikaNissuu = dateSpanTemp.getDays();

            if (kasanKeikaNissuu > 15){
                kasanKeikaTukisuu = kasanKeikaTukisuu + 1;
            }

            if (kasanKeikaTukisuu > 0) {

                zennouKeikaRirituBn = BizNumber.ONE.add(zennouRirituBn.multiply(kasanKeikaTukisuu).divide(12, 10,
                    RoundingMode.DOWN));

                zennouRirituGk = zennouRirituGk.multiply(zennouKeikaRirituBn, 0, RoundingMode.DOWN);

                errorKbn1 = getZennouKikanRiritu.exec(zennouJyuutouEndYmd, pZennouseisankijyunymd, pKykymd);

                if (C_ErrorKbn.ERROR.eq(errorKbn1)) {

                    errorKbn = C_ErrorKbn.ERROR;

                    return errorKbn;

                }

                zennouKikanRiritu = getZennouKikanRiritu.getZennouKikanRiritu();

                zennouTmttrituHnkbiList.addAll(getZennouKikanRiritu.getZennouTmttrituHnkbiList());

                tumitateRirituGk = zennouSeisankGk.multiply(BizNumber.ONE.add(zennouKikanRiritu), 0, RoundingMode.DOWN);

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

        if (BizCurrency.valueOf(0).compareTo(zennouSeisankGk) > 0) {
            zennouSeisankGk = BizCurrency.valueOf(0);
        }

        zennouSeisanGk = zennouSeisankGk;
        zennouSeisanKijyunYmd = pZennouseisankijyunymd;
        tkyTmttZndkHikakuKbn = tkyTmttZndkHikakuKbnTemp;

        logger.debug("△ 前納精算額計算（前納精算基準日、契約日、前納時払込保険料、前納開始年月日、領収日、前納入金額指定） 終了");

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

        List<IT_KykSyouhn> kykSyouhnList = keisanZennouSeisanGkDao.getKykSyouhns(kykKihon);

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

        List<IT_Zennou> zennouList = keisanZennouSeisanGkDao.getZennous(ansyuKihon);

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
            Integer.valueOf(zennou.getZennoukikan())))) == BizDateUtil.COMPARE_GREATER
            || BizDateUtil.compareYmd(pZennouseisankijyunymd, (zennou.getZennoukaisiymd().addYears(
                Integer.valueOf(zennou.getZennoukikan())))) == BizDateUtil.COMPARE_EQUAL) {

            logger.info("前納精算額計算エラー。前納精算基準日が前納満了日より未来になっています。");

            errorKbn = C_ErrorKbn.ERROR;

            return errorKbn;
        }

        errorKbn = exec(pZennouseisankijyunymd, kykSyouhn.getKykymd(), zennou.getZennoujihrkp(),
            zennou.getZennoukaisiymd(),
            zennou.getRyosyuymd(), zennou.getZennounyuukinkgk());

        logger.debug("△ 前納精算額計算（前納精算基準日、証券番号指定） 終了");

        return errorKbn;
    }

    public String getTkyTmttZndkHikakuKbn() {
        return tkyTmttZndkHikakuKbn;
    }

    public String getZennouPSeisanKbn(BizDate pRyosyuymd, BizDate pDenYmd) {

        logger.debug("▽ 前納Ｐ精算区分取得 開始");

        BizDateY zenNyuJinendo;
        if (pRyosyuymd.getMonth() <= 3) {
            zenNyuJinendo = pRyosyuymd.getBizDateY().addYears(-1);
        }
        else {
            zenNyuJinendo = pRyosyuymd.getBizDateY();
        }
        BizDateY denHizJigNendo;
        if (pDenYmd.getMonth() <= 3) {
            denHizJigNendo = pDenYmd.getBizDateY().addYears(-1);
        }
        else {
            denHizJigNendo = pDenYmd.getBizDateY();
        }
        String zennouPSeisanKbn;
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
}
