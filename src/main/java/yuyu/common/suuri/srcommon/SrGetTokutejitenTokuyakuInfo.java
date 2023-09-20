package yuyu.common.suuri.srcommon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.classification.C_GetTaisyouSonotaTokuyakuKbn;
import yuyu.def.classification.C_SonotaTkTokuteiJitenKbn;
import yuyu.def.classification.C_SuuriIdoKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetBefaAftNaiyouOriginalBean;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;

/**
 *  特定時点その他特約情報取得
 */
public class SrGetTokutejitenTokuyakuInfo {

    @Inject
    private static Logger logger;

    private static final String TARGETID_INITSBJIYENKASAITEIHSYGK = "initsbjiyenkasaiteihsygk";

    private static final String TARGETID_TARGETTKMOKUHYOUTI = "targettkmokuhyouti";

    private static final String TARGETID_TARGETTKYKKIJYUNGK = "targettkykkijyungk";

    private static final String TARGETID_STDRSKTKYHKUMU = "stdrsktkyhkumu";

    private static final String TARGETID_KYKDRTKYKHUKAUMU = "kykdrtkykhukaumu";

    private static final String TABLEID_IT_KYKSONOTATKYK = "IT_KykSonotaTkyk";

    @Inject
    private SrCommonKinouDao srCommonKinouDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public SrGetTokutejitenTokuyakuInfo() {
    }

    public SrGetTokutejitenTokuyakuInfoBean exec(
        C_GetTaisyouSonotaTokuyakuKbn pGetTaisyouSonotaTokuyakuKbn,
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn,
        BizDate pKijyunYmd,
        String pSyono,
        C_SuuriIdoKbn pSuuriIdoKbn,
        String pHenkousikibetukey,
        BizDate pKouryokuhasseiymd,
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst,
        BizDate pYendthnkymd,
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst,
        C_UmuKbn pInitsbjiyensitihsytkhukaumu,
        BizCurrency pInitsbjiyenkasaiteihsygk,
        C_UmuKbn pTargettkhkumu,
        Integer pTargettkmokuhyouti,
        BizCurrency pTargettkykkijyungk,
        BizDate pTargettkykkykhenkoymd) {

        logger.debug("▽ 特定時点その他特約情報取得 開始");

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);

        C_UmuKbn tkhkUmu = C_UmuKbn.NONE;

        if (C_GetTaisyouSonotaTokuyakuKbn.SYKSBYENSITIHSYUTKYK.eq(pGetTaisyouSonotaTokuyakuKbn)) {

            if (pYendthnkymd != null) {

                tkhkUmu = pIT_KykSyouhnHnkmaeLst.get(0).getInitsbjiyensitihsytkhukaumu();
            }
            else {

                tkhkUmu = pInitsbjiyensitihsytkhukaumu;
            }

            if (C_UmuKbn.NONE.eq(tkhkUmu)) {

                srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(BizCurrency.valueOf(0));

                srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(BizCurrency.valueOf(0));
            }
            else {

                if (C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

                    BizCurrency kijyunYmdJitenKekka = getKijyunYmdJiten(
                        TARGETID_INITSBJIYENKASAITEIHSYGK,
                        pSonotaTkTokuteiJitenKbn,
                        pKijyunYmd,
                        pSyono,
                        null,
                        pSV_KiykSyuhnDataLst,
                        pIT_KykSyouhnHnkmaeLst,
                        pInitsbjiyenkasaiteihsygk);

                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(kijyunYmdJitenKekka);

                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(kijyunYmdJitenKekka);
                }
                else if (C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

                    if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITEN.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pSuuriIdoKbn)) {

                        BizCurrency kijyunYmdJitenKekka = getKijyunYmdJiten(
                            TARGETID_INITSBJIYENKASAITEIHSYGK,
                            pSonotaTkTokuteiJitenKbn,
                            pKouryokuhasseiymd,
                            pSyono,
                            pHenkousikibetukey,
                            pSV_KiykSyuhnDataLst,
                            pIT_KykSyouhnHnkmaeLst,
                            pInitsbjiyenkasaiteihsygk);

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(kijyunYmdJitenKekka);

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(kijyunYmdJitenKekka);
                    }
                    else if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn)) {

                        SrGetIdouZengoBean idoZengoKekka = getIdozengo(
                            TARGETID_INITSBJIYENKASAITEIHSYGK,
                            pSyono,
                            pHenkousikibetukey,
                            pInitsbjiyenkasaiteihsygk,
                            null,
                            null);

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(
                            BizCurrency.valueOf(new BigDecimal(idoZengoKekka.getIdouZengoGetKekkaMae())));

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(
                            BizCurrency.valueOf(new BigDecimal(idoZengoKekka.getIdouZengoGetKekkaAto())));
                    }
                    else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

                        SrGetTokutejitenTokuyakuInfoBean yendtHnkZengoKekka = getYendthnkzengo(
                            pSuuriIdoKbn,
                            pHenkousikibetukey,
                            pIT_KykSyouhnHnkmaeLst,
                            pInitsbjiyenkasaiteihsygk,
                            null,
                            null);

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(
                            yendtHnkZengoKekka.getInitsbjiyenkasaiteihsygkMae());

                        srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(
                            yendtHnkZengoKekka.getInitsbjiyenkasaiteihsygkAto());
                    }
                }
            }
        }
        else if (C_GetTaisyouSonotaTokuyakuKbn.TARGETTOKUYAKU.eq(pGetTaisyouSonotaTokuyakuKbn)) {

            if (pYendthnkymd != null) {

                tkhkUmu = pIT_KykSyouhnHnkmaeLst.get(0).getTargettkhkumu();
            }
            else {

                tkhkUmu = pTargettkhkumu;
            }

            if (C_UmuKbn.NONE.eq(tkhkUmu)) {

                srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(SrCommonConstants.DEFAULT_INT_ZERO);

                srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(SrCommonConstants.DEFAULT_INT_ZERO);

                srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(BizCurrency.valueOf(0));

                srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(BizCurrency.valueOf(0));
            }
            else {

                if (C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

                    Integer kijyunYmdJitenTargetKekka = getKijyunYmdJitenTarget(
                        TARGETID_TARGETTKMOKUHYOUTI,
                        pSonotaTkTokuteiJitenKbn,
                        pKijyunYmd,
                        pSyono,
                        null,
                        pSV_KiykSyuhnDataLst,
                        pIT_KykSyouhnHnkmaeLst,
                        pYendthnkymd,
                        pTargettkmokuhyouti,
                        pTargettkykkykhenkoymd);

                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(kijyunYmdJitenTargetKekka);

                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(kijyunYmdJitenTargetKekka);

                    BizCurrency kijyunYmdJitenKekka = getKijyunYmdJiten(
                        TARGETID_TARGETTKYKKIJYUNGK,
                        pSonotaTkTokuteiJitenKbn,
                        pKijyunYmd,
                        pSyono,
                        null,
                        pSV_KiykSyuhnDataLst,
                        pIT_KykSyouhnHnkmaeLst,
                        pTargettkykkijyungk);

                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(kijyunYmdJitenKekka);

                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(kijyunYmdJitenKekka);
                }
                else if (C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

                    if (C_SuuriIdoKbn.SINENGAPPISEITEISEI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASI.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.SISUUTUMIMASITRKS.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITEN.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.TEIRITUITENTRKS.eq(pSuuriIdoKbn)) {

                        Integer kijyunYmdJitenTargetKekka = getKijyunYmdJitenTarget(
                            TARGETID_TARGETTKMOKUHYOUTI,
                            pSonotaTkTokuteiJitenKbn,
                            pKouryokuhasseiymd,
                            pSyono,
                            pHenkousikibetukey,
                            pSV_KiykSyuhnDataLst,
                            pIT_KykSyouhnHnkmaeLst,
                            pYendthnkymd,
                            pTargettkmokuhyouti,
                            pTargettkykkykhenkoymd);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(kijyunYmdJitenTargetKekka);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(kijyunYmdJitenTargetKekka);

                        BizCurrency kijyunYmdJitenKekka = getKijyunYmdJiten(
                            TARGETID_TARGETTKYKKIJYUNGK,
                            pSonotaTkTokuteiJitenKbn,
                            pKouryokuhasseiymd,
                            pSyono,
                            pHenkousikibetukey,
                            pSV_KiykSyuhnDataLst,
                            pIT_KykSyouhnHnkmaeLst,
                            pTargettkykkijyungk);

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(kijyunYmdJitenKekka);

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(kijyunYmdJitenKekka);
                    }
                    else if (C_SuuriIdoKbn.GENGAKU.eq(pSuuriIdoKbn)) {

                        Integer kijyunYmdJitenTargetKekka = getKijyunYmdJitenTarget(
                            TARGETID_TARGETTKMOKUHYOUTI,
                            pSonotaTkTokuteiJitenKbn,
                            pKouryokuhasseiymd,
                            pSyono,
                            pHenkousikibetukey,
                            pSV_KiykSyuhnDataLst,
                            pIT_KykSyouhnHnkmaeLst,
                            pYendthnkymd,
                            pTargettkmokuhyouti,
                            pTargettkykkykhenkoymd);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(kijyunYmdJitenTargetKekka);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(kijyunYmdJitenTargetKekka);

                        SrGetIdouZengoBean idoZengoKekka = getIdozengo(
                            TARGETID_TARGETTKYKKIJYUNGK,
                            pSyono,
                            pHenkousikibetukey,
                            null,
                            null,
                            pTargettkykkijyungk);

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(
                            BizCurrency.valueOf(new BigDecimal(idoZengoKekka.getIdouZengoGetKekkaMae())));

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(
                            BizCurrency.valueOf(new BigDecimal(idoZengoKekka.getIdouZengoGetKekkaAto())));
                    }
                    else if (C_SuuriIdoKbn.MOKUHYOURITUHENKOU.eq(pSuuriIdoKbn)) {

                        SrGetIdouZengoBean idoZengoKekka = getIdozengo(
                            TARGETID_TARGETTKMOKUHYOUTI,
                            pSyono,
                            pHenkousikibetukey,
                            null,
                            pTargettkmokuhyouti,
                            null);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(
                            Integer.parseInt(idoZengoKekka.getIdouZengoGetKekkaMae()));

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(
                            Integer.parseInt(idoZengoKekka.getIdouZengoGetKekkaAto()));

                        BizCurrency kijyunYmdJitenKekka = getKijyunYmdJiten(
                            TARGETID_TARGETTKYKKIJYUNGK,
                            pSonotaTkTokuteiJitenKbn,
                            pKouryokuhasseiymd,
                            pSyono,
                            pHenkousikibetukey,
                            pSV_KiykSyuhnDataLst,
                            pIT_KykSyouhnHnkmaeLst,
                            pTargettkykkijyungk);

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(kijyunYmdJitenKekka);

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(kijyunYmdJitenKekka);
                    }
                    else if (C_SuuriIdoKbn.YENDTHENKOU.eq(pSuuriIdoKbn) ||
                        C_SuuriIdoKbn.YENDTHENKOUTRKS.eq(pSuuriIdoKbn)) {

                        SrGetTokutejitenTokuyakuInfoBean yendtHnkZengoKekka = getYendthnkzengo(
                            pSuuriIdoKbn,
                            pHenkousikibetukey,
                            pIT_KykSyouhnHnkmaeLst,
                            null,
                            pTargettkmokuhyouti,
                            pTargettkykkijyungk);

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(
                            yendtHnkZengoKekka.getTargettkmokuhyoutiMae());

                        srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(
                            yendtHnkZengoKekka.getTargettkmokuhyoutiAto());

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(
                            yendtHnkZengoKekka.getTargettkykkijyungkMae());

                        srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(
                            yendtHnkZengoKekka.getTargettkykkijyungkAto());
                    }
                }
            }

        }

        logger.debug("△ 特定時点その他特約情報取得 終了");

        return srgettokuteijitentokuyakuinfobean;
    }

    public String execHhkDirTkyk(
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn,
        BizDate pKijyunYmd,
        String pSyono,
        String pHenkousikibetukey,
        BizDate pKouryokuhasseiymd,
        C_UmuKbn pStdrsktkyhkumu,
        BizDate pStdrsktkyhkymd) {

        logger.debug("▽ 被保険者代理特約有表示取得 開始");

        String hhkdrtkykariHyj = null;

        if (C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

            if (C_UmuKbn.NONE.eq(pStdrsktkyhkumu)) {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
            }
            else if (BizDateUtil.compareYmd(pStdrsktkyhkymd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pStdrsktkyhkymd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }
            else if (BizDateUtil.compareYmd(pStdrsktkyhkymd, pKijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> beanList =
                        srCommonKinouDao.getKhHenkouBfRirekis(pSyono, TABLEID_IT_KYKSONOTATKYK, TARGETID_STDRSKTKYHKUMU);

                if(beanList.size() == 0){
                    hhkdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
                }
                else {
                    hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                }
            }
        }
        else if (C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

            if (C_UmuKbn.NONE.eq(pStdrsktkyhkumu)) {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
            }
            else if (BizDateUtil.compareYmd(pStdrsktkyhkymd, pKouryokuhasseiymd) == BizDateUtil.COMPARE_LESSER) {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }
            else if (BizDateUtil.compareYmd(pStdrsktkyhkymd, pKouryokuhasseiymd) == BizDateUtil.COMPARE_GREATER) {
                hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
            }
            else {
                hhkdrtkykariHyj = getDoujiidomaeTkykHukaJk(pSyono, pHenkousikibetukey, TARGETID_STDRSKTKYHKUMU);

                if(hhkdrtkykariHyj == null || "".equals(hhkdrtkykariHyj)){
                    if(C_UmuKbn.NONE.eq(pStdrsktkyhkumu)){
                        hhkdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                    }
                    else {
                        hhkdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
                    }
                }
            }
        }

        logger.debug("△ 被保険者代理特約有表示取得 終了");

        return  hhkdrtkykariHyj ;
    }

    public String execKykDirTkyk(
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn,
        BizDate pKijyunYmd,
        String pSyono,
        String pHenkousikibetukey,
        BizDate pKouryokuhasseiymd,
        C_UmuKbn pKykdrtkykhukaumu,
        BizDate pKykdrtkykhukaymd,
        BizDate pKykdrtkykkaiyakuymd) {

        logger.debug("▽ 契約者代理特約有表示取得 開始");

        String kykdrtkykariHyj = null;

        if (C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {
            if (C_UmuKbn.NONE.eq(pKykdrtkykhukaumu)) {

                if (pKykdrtkykkaiyakuymd == null) {
                    kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                }
                else if (BizDateUtil.compareYmd(pKykdrtkykkaiyakuymd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYmd(pKykdrtkykkaiyakuymd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
                    kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                }
            }
            else if (BizDateUtil.compareYmd(pKykdrtkykhukaymd, pKijyunYmd) == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(pKykdrtkykhukaymd, pKijyunYmd) == BizDateUtil.COMPARE_EQUAL) {
                kykdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }

            if (kykdrtkykariHyj == null) {
                kykdrtkykariHyj = getKijyunymdJitenKykdrTkykHukaJk(pSyono, pKijyunYmd);

                if(kykdrtkykariHyj == null || "".equals(kykdrtkykariHyj)){
                    if(C_UmuKbn.NONE.eq(pKykdrtkykhukaumu)){
                        kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                    }
                    else {
                        kykdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
                    }
                }
            }
        }
        else if (C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET.eq(pSonotaTkTokuteiJitenKbn)) {

            if (C_UmuKbn.NONE.eq(pKykdrtkykhukaumu)) {

                if (pKykdrtkykkaiyakuymd == null) {
                    kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                }
                else if (BizDateUtil.compareYmd(pKykdrtkykkaiyakuymd, pKouryokuhasseiymd) == BizDateUtil.COMPARE_LESSER) {
                    kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                }
            }
            else if (BizDateUtil.compareYmd(pKykdrtkykhukaymd, pKouryokuhasseiymd) == BizDateUtil.COMPARE_LESSER) {
                kykdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
            }

            if (kykdrtkykariHyj == null) {
                kykdrtkykariHyj = getIdomaeKykdrTkykHukaJk(pSyono, pKouryokuhasseiymd, pHenkousikibetukey);

                if(kykdrtkykariHyj == null || "".equals(kykdrtkykariHyj)){
                    if (C_UmuKbn.NONE.eq(pKykdrtkykhukaumu)) {
                        kykdrtkykariHyj = SrCommonConstants.HYOUJI_NASI;
                    }
                    else {
                        kykdrtkykariHyj = SrCommonConstants.HYOUJI_ARI;
                    }
                }
            }
        }

        logger.debug("△ 契約者代理特約有表示取得 終了");

        return kykdrtkykariHyj ;
    }

    private BizCurrency getKijyunYmdJiten(
        String pTagertID,
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn,
        BizDate pSyutokuKijyunYmd,
        String pSyono,
        String pHenkousikibetukey,
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst,
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst,
        BizCurrency pTargetsaisinkingaku) {

        C_SuuriIdoKbn targetidoKbn = C_SuuriIdoKbn.BLNK;
        String targethenkousikibetukey = "";
        BizDate targetymd = null;
        boolean targetumuflg = false;

        BizCurrency kijyunymdjitenKekka = pTargetsaisinkingaku;

        for(SV_KiykSyuhnData kiyksyuhnentity : pSV_KiykSyuhnDataLst) {

            C_SuuriIdoKbn targetkouhoidoKbn = C_SuuriIdoKbn.BLNK;
            BizDate targetkouhoymd = null;

            if(kiyksyuhnentity.getGyoumuKousinKinou().equals(IKhozenCommonConstants.KINOUID_GENGAKU)){
                targetkouhoidoKbn = C_SuuriIdoKbn.GENGAKU;
                targetkouhoymd = kiyksyuhnentity.getKouryokuhasseiymd();
            }else if(kiyksyuhnentity.getGyoumuKousinKinou().equals(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK)){
                targetkouhoidoKbn = C_SuuriIdoKbn.YENDTHENKOU;
                targetkouhoymd = kiyksyuhnentity.getKouryokuhasseiymd();
            }else if(kiyksyuhnentity.getGyoumuKousinKinou().equals(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) &&
                kiyksyuhnentity.getSyorikbn().equals(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI)){
                targetkouhoidoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
                targetkouhoymd = kiyksyuhnentity.getSyoriYmd();
            }else{
                continue;
            }

            if(pSyutokuKijyunYmd.compareTo(targetkouhoymd) < 0 &&
                (targetymd == null || targetkouhoymd.compareTo(targetymd) <= 0)){
                targetidoKbn = targetkouhoidoKbn;
                targethenkousikibetukey = kiyksyuhnentity.getHenkousikibetukey();
                targetymd = targetkouhoymd;
                targetumuflg = true;

            }else if(pSyutokuKijyunYmd.compareTo(targetkouhoymd) == 0){
                if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET)){
                    break;

                }else if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET)){
                    if(Integer.parseInt(pHenkousikibetukey) < Integer.parseInt(kiyksyuhnentity.getHenkousikibetukey())){

                        targetidoKbn = targetkouhoidoKbn;
                        targethenkousikibetukey = kiyksyuhnentity.getHenkousikibetukey();
                        targetumuflg = true;
                    }else{
                        break;
                    }

                }
            }else{
                break;

            }
        }

        if(targetumuflg){
            if(targetidoKbn.eq(C_SuuriIdoKbn.GENGAKU)){
                List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> targetLst =
                    srCommonKinouDao.getKhHenkouRirekis(
                        pSyono, targethenkousikibetukey, TABLEID_IT_KYKSONOTATKYK ,pTagertID);

                if(targetLst.size() > 0){
                    kijyunymdjitenKekka = BizCurrency.valueOf(new BigDecimal(
                        targetLst.get(0).getBfrnaiyouoriginal()));
                }

            }else if(targetidoKbn.eq(C_SuuriIdoKbn.YENDTHENKOU)){
                for(int i = 0 ; i < pIT_KykSyouhnHnkmaeLst.size(); i++){
                    if(Integer.parseInt(targethenkousikibetukey) > Integer.parseInt(
                        pIT_KykSyouhnHnkmaeLst.get(i).getHenkousikibetukey())){
                        if(pTagertID.equals(TARGETID_INITSBJIYENKASAITEIHSYGK)){
                            kijyunymdjitenKekka = pIT_KykSyouhnHnkmaeLst.get(i).getInitsbjiyenkasaiteihsygk();
                        }else if(pTagertID.equals(TARGETID_TARGETTKYKKIJYUNGK)){
                            kijyunymdjitenKekka = pIT_KykSyouhnHnkmaeLst.get(i).getTargettkykkijyungk();
                        }
                        break;
                    }
                }

            }else if(targetidoKbn.eq(C_SuuriIdoKbn.YENDTHENKOUTRKS)){
                kijyunymdjitenKekka = BizCurrency.valueOf(0);

            }
        }
        return kijyunymdjitenKekka;

    }

    private Integer getKijyunYmdJitenTarget(
        String pTagertID,
        C_SonotaTkTokuteiJitenKbn pSonotaTkTokuteiJitenKbn,
        BizDate pSyutokuKijyunYmd,
        String pSyono,
        String pHenkousikibetukey,
        List<SV_KiykSyuhnData> pSV_KiykSyuhnDataLst,
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst,
        BizDate pYendthnkymd,
        Integer pTargettkmokuhyouti,
        BizDate pTargettkykkykhenkoymd) {

        Integer mokuhyouritsuChgTargettkmokuhyouti = 0;
        String mokuhyouritsuChgHenkousikibetukey = "";
        Boolean mokuhyouritsuChgUmuflg = false;

        Integer endtChgTargettkmokuhyouti = 0;
        C_SuuriIdoKbn endtChgIdokbn = C_SuuriIdoKbn.BLNK;
        String endtChgHenkousikibetukey = "";
        Boolean endtChgUmuflg = false;

        String kjnymdmaemokuhyouritsuChgHenkousikibetukey = "";

        Integer kijyunymdjitenMokuhyouti = pTargettkmokuhyouti;

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> targetBean =
            new ArrayList<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean>();


        targetBean = srCommonKinouDao.getTargetTokuyakuBefaAftMokuhyoutiDescList(pSyono);

        for(int i = 0 ; i < targetBean.size() ; i++){
            List<KhHenkouRirekiTargetBefaAftNaiyouOriginalBean> targetZengoLst =
                hozenDomManager.getTargetTokuyakuBefaAftKykhenkoYmdList(pSyono, targetBean.get(i).getHenkousikibetukey());

            if(pSyutokuKijyunYmd.compareTo(BizDate.valueOf(targetZengoLst.get(0).getNewnaiyouoriginal())) < 0){
                mokuhyouritsuChgTargettkmokuhyouti = Integer.valueOf(targetBean.get(i).getBfrnaiyouoriginal());
                mokuhyouritsuChgHenkousikibetukey = targetBean.get(i).getHenkousikibetukey();
                mokuhyouritsuChgUmuflg = true;

            }else if(pSyutokuKijyunYmd.compareTo(BizDate.valueOf(targetZengoLst.get(0).getNewnaiyouoriginal())) == 0){
                if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET)){
                    kjnymdmaemokuhyouritsuChgHenkousikibetukey = targetBean.get(i).getHenkousikibetukey();
                    break;
                }else if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET)){
                    if(Integer.parseInt(pHenkousikibetukey) < Integer.parseInt(targetBean.get(i).getHenkousikibetukey())){
                        mokuhyouritsuChgTargettkmokuhyouti = Integer.valueOf(targetBean.get(i).getBfrnaiyouoriginal());
                        mokuhyouritsuChgHenkousikibetukey = targetBean.get(i).getHenkousikibetukey();
                        mokuhyouritsuChgUmuflg = true;
                    }else{
                        break;
                    }
                }
                break;
            }
            else {
                if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET)){
                    kjnymdmaemokuhyouritsuChgHenkousikibetukey = targetBean.get(i).getHenkousikibetukey();
                    break;

                }
                else if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET)){
                    break;
                }
            }
        }

        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
            C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO, "",
            pSyutokuKijyunYmd, "", pSV_KiykSyuhnDataLst);

        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean =
            tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

        for(SV_KiykSyuhnData kiyksyuhnentity : pSV_KiykSyuhnDataLst) {

            C_SuuriIdoKbn targetkouhoidoKbn = C_SuuriIdoKbn.BLNK;
            BizDate targetkouhoymd = null;

            if(kiyksyuhnentity.getGyoumuKousinKinou().equals(IKhozenCommonConstants.KINOUID_KHMKHGKTTTYENDTHNK)){
                targetkouhoidoKbn = C_SuuriIdoKbn.YENDTHENKOU;
                targetkouhoymd = kiyksyuhnentity.getKouryokuhasseiymd();
            }else if(kiyksyuhnentity.getGyoumuKousinKinou().equals(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI) &&
                kiyksyuhnentity.getSyorikbn().equals(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI)){

                if (tkJitenKeiyakuSyouhinKijyunBean.getYendthnkymd() != null) {
                    targetkouhoidoKbn = C_SuuriIdoKbn.YENDTHENKOUTRKS;
                    targetkouhoymd = kiyksyuhnentity.getSyoriYmd();
                }
                else {
                    continue;
                }

            }else{
                continue;
            }

            if(pSyutokuKijyunYmd.compareTo(targetkouhoymd) < 0){
                if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET)){
                    if (kjnymdmaemokuhyouritsuChgHenkousikibetukey == "" ||
                        Integer.parseInt(kiyksyuhnentity.getHenkousikibetukey()) > Integer.parseInt(
                            kjnymdmaemokuhyouritsuChgHenkousikibetukey)) {
                        endtChgIdokbn = targetkouhoidoKbn;
                        endtChgHenkousikibetukey = kiyksyuhnentity.getHenkousikibetukey();
                        endtChgUmuflg = true;

                    }
                    else {
                        break;
                    }
                }
                else if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET)){
                    endtChgIdokbn = targetkouhoidoKbn;
                    endtChgHenkousikibetukey = kiyksyuhnentity.getHenkousikibetukey();
                    endtChgUmuflg = true;
                }
            }else if(pSyutokuKijyunYmd.compareTo(targetkouhoymd) == 0){
                if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.KIJYUNYMDSONOTATKINFOGET)){
                    break;

                }else if(pSonotaTkTokuteiJitenKbn.eq(C_SonotaTkTokuteiJitenKbn.IDOUBETUSONOTATKINFOGET)){
                    if(Integer.parseInt(pHenkousikibetukey) < Integer.parseInt(kiyksyuhnentity.getHenkousikibetukey())){
                        endtChgIdokbn = targetkouhoidoKbn;
                        endtChgHenkousikibetukey = kiyksyuhnentity.getHenkousikibetukey();
                        endtChgUmuflg = true;

                    }else{
                        break;
                    }
                }
            }else{
                break;

            }
        }

        if(endtChgUmuflg){
            if(endtChgIdokbn.eq(C_SuuriIdoKbn.YENDTHENKOU)){
                for(int i = 0 ; i < pIT_KykSyouhnHnkmaeLst.size(); i++){
                    if(Integer.parseInt(endtChgHenkousikibetukey) > Integer.parseInt(
                        pIT_KykSyouhnHnkmaeLst.get(i).getHenkousikibetukey())){
                        endtChgTargettkmokuhyouti = pIT_KykSyouhnHnkmaeLst.get(i).getTargettkmokuhyouti();
                        break;
                    }
                }

            }else if(endtChgIdokbn.eq(C_SuuriIdoKbn.YENDTHENKOUTRKS)){
                endtChgTargettkmokuhyouti = 0;

            }
        }

        if (mokuhyouritsuChgUmuflg && endtChgUmuflg) {

            if (Integer.parseInt(mokuhyouritsuChgHenkousikibetukey) < Integer.parseInt(endtChgHenkousikibetukey)) {

                kijyunymdjitenMokuhyouti = mokuhyouritsuChgTargettkmokuhyouti;
            }
            else {

                kijyunymdjitenMokuhyouti = endtChgTargettkmokuhyouti;
            }
        }
        else if (mokuhyouritsuChgUmuflg && !endtChgUmuflg){

            kijyunymdjitenMokuhyouti = mokuhyouritsuChgTargettkmokuhyouti;
        }
        else if (!mokuhyouritsuChgUmuflg && endtChgUmuflg){

            kijyunymdjitenMokuhyouti = endtChgTargettkmokuhyouti;
        }

        return kijyunymdjitenMokuhyouti;
    }


    private  SrGetIdouZengoBean getIdozengo(
        String pTagertID,
        String pSyono,
        String pHenkousikibetukey,
        BizCurrency pInitsbjiyenkasaiteihsygk,
        Integer pTargettkmokuhyouti,
        BizCurrency pTargettkykkijyungk
        ) {

        SrGetIdouZengoBean srgetidouzengobean =
            SWAKInjector.getInstance(SrGetIdouZengoBean.class);

        if(pTagertID.equals(TARGETID_INITSBJIYENKASAITEIHSYGK)){
            srgetidouzengobean.setIdouZengoGetKekkaMae(pInitsbjiyenkasaiteihsygk.toString());
            srgetidouzengobean.setIdouZengoGetKekkaAto(pInitsbjiyenkasaiteihsygk.toString());

        }else if(pTagertID.equals(TARGETID_TARGETTKMOKUHYOUTI)){
            srgetidouzengobean.setIdouZengoGetKekkaMae(pTargettkmokuhyouti.toString());
            srgetidouzengobean.setIdouZengoGetKekkaAto(pTargettkmokuhyouti.toString());

        }else if(pTagertID.equals(TARGETID_TARGETTKYKKIJYUNGK)){
            srgetidouzengobean.setIdouZengoGetKekkaMae(pTargettkykkijyungk.toString());
            srgetidouzengobean.setIdouZengoGetKekkaAto(pTargettkykkijyungk.toString());

        }

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> targetBean =
            srCommonKinouDao.getKhHenkouRirekis(
                pSyono, pHenkousikibetukey, TABLEID_IT_KYKSONOTATKYK ,pTagertID);

        if(targetBean.size() > 0){
            srgetidouzengobean.setIdouZengoGetKekkaMae(targetBean.get(0).getBfrnaiyouoriginal());
            srgetidouzengobean.setIdouZengoGetKekkaAto(targetBean.get(0).getNewnaiyouoriginal());

        }

        return srgetidouzengobean;

    }

    private SrGetTokutejitenTokuyakuInfoBean getYendthnkzengo(
        C_SuuriIdoKbn pSuuriIdoKbn,
        String pHenkousikibetukey,
        List<IT_KykSyouhnHnkmae> pIT_KykSyouhnHnkmaeLst,
        BizCurrency pInitsbjiyenkasaiteihsygk,
        Integer pTargettkmokuhyouti,
        BizCurrency pTargettkykkijyungk) {

        SrGetTokutejitenTokuyakuInfoBean srgettokuteijitentokuyakuinfobean =
            SWAKInjector.getInstance(SrGetTokutejitenTokuyakuInfoBean.class);


        if(pSuuriIdoKbn == C_SuuriIdoKbn.YENDTHENKOU){
            srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(pInitsbjiyenkasaiteihsygk);
            srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(BizCurrency.valueOf(0));
            srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(pTargettkmokuhyouti);
            srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(0);
            srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(pTargettkykkijyungk);
            srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(BizCurrency.valueOf(0));


        }else if(pSuuriIdoKbn == C_SuuriIdoKbn.YENDTHENKOUTRKS){
            srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(BizCurrency.valueOf(0));
            srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(pInitsbjiyenkasaiteihsygk);
            srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(0);
            srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(pTargettkmokuhyouti);
            srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(BizCurrency.valueOf(0));
            srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(pTargettkykkijyungk);

        }

        for(IT_KykSyouhnHnkmae entity : pIT_KykSyouhnHnkmaeLst){
            if(pHenkousikibetukey.compareTo(entity.getHenkousikibetukey()) > 0){
                if(pSuuriIdoKbn == C_SuuriIdoKbn.YENDTHENKOU){
                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(entity.getInitsbjiyenkasaiteihsygk());
                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(BizCurrency.valueOf(0));
                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(entity.getTargettkmokuhyouti());
                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(entity.getTargettkmokuhyouti());
                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(entity.getTargettkykkijyungk());
                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(BizCurrency.valueOf(0));

                }else if(pSuuriIdoKbn == C_SuuriIdoKbn.YENDTHENKOUTRKS){
                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkMae(BizCurrency.valueOf(0));
                    srgettokuteijitentokuyakuinfobean.setInitsbjiyenkasaiteihsygkAto(entity.getInitsbjiyenkasaiteihsygk());
                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiMae(entity.getTargettkmokuhyouti());
                    srgettokuteijitentokuyakuinfobean.setTargettkmokuhyoutiAto(entity.getTargettkmokuhyouti());
                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkMae(BizCurrency.valueOf(0));
                    srgettokuteijitentokuyakuinfobean.setTargettkykkijyungkAto(entity.getTargettkykkijyungk());

                }
                break;

            }
        }
        return srgettokuteijitentokuyakuinfobean;

    }

    private String getKijyunymdJitenKykdrTkykHukaJk(String pSyono, BizDate pKijyunYmd) {

        String kykdrtkykariHyj = "";
        String henkousikibetukey = "";

        List<IT_KhHenkouRireki> khHenkouRirekiLst = srCommonKinouDao.getKykdrTkykHenkouRirekis(pSyono);

        for (IT_KhHenkouRireki khHenkouRireki : khHenkouRirekiLst) {

            if (!BizUtil.isBlank(khHenkouRireki.getNewnaiyouoriginal())) {

                if (BizDateUtil.compareYmd(BizDate.valueOf(khHenkouRireki.getNewnaiyouoriginal()), pKijyunYmd) ==
                    BizDateUtil.COMPARE_GREATER) {
                    henkousikibetukey = khHenkouRireki.getHenkousikibetukey();
                }
                else {
                    break;
                }
            }
        }

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> beanList =
            srCommonKinouDao.getKhHenkouRirekis(pSyono, henkousikibetukey, TABLEID_IT_KYKSONOTATKYK, TARGETID_KYKDRTKYKHUKAUMU);

        if (beanList.size() > 0) {
            kykdrtkykariHyj = beanList.get(0).getBfrnaiyouoriginal();
        }

        return kykdrtkykariHyj;
    }

    private String getIdomaeKykdrTkykHukaJk(String pSyono, BizDate pKouryokuhasseiymd, String pHenkousikibetukey) {

        String kykdrtkykariHyj = "";
        Boolean doujituFlg = false;
        String henkousikibetukey = "";

        List<IT_KhHenkouRireki> khHenkouRirekiLst = srCommonKinouDao.getKykdrTkykHenkouRirekis(pSyono);

        for (IT_KhHenkouRireki khHenkouRireki : khHenkouRirekiLst) {

            if (!BizUtil.isBlank(khHenkouRireki.getNewnaiyouoriginal())) {

                if (BizDateUtil.compareYmd(BizDate.valueOf(khHenkouRireki.getNewnaiyouoriginal()), pKouryokuhasseiymd) ==
                    BizDateUtil.COMPARE_GREATER) {

                    henkousikibetukey = khHenkouRireki.getHenkousikibetukey();
                }
                else if (BizDateUtil.compareYmd(BizDate.valueOf(khHenkouRireki.getNewnaiyouoriginal()),
                    pKouryokuhasseiymd) == BizDateUtil.COMPARE_EQUAL) {
                    doujituFlg = true;
                    break;
                }
                else {
                    break;
                }
            }
        }

        if (!doujituFlg) {

            List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> beanList =
                srCommonKinouDao.getKhHenkouRirekis(pSyono, henkousikibetukey, TABLEID_IT_KYKSONOTATKYK,
                    TARGETID_KYKDRTKYKHUKAUMU);

            if (beanList.size() > 0) {

                kykdrtkykariHyj = beanList.get(0).getBfrnaiyouoriginal();
            }
        }
        else {
            kykdrtkykariHyj = getDoujiidomaeTkykHukaJk(pSyono, pHenkousikibetukey, TARGETID_KYKDRTKYKHUKAUMU);
        }

        return kykdrtkykariHyj;
    }

    private String getDoujiidomaeTkykHukaJk(
        String pSyono,
        String pHenkousikibetukey,
        String pTargetid) {

        String tkykarihyj = null;

        List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> beanList =
            srCommonKinouDao.getKhHenkouBfRirekis(pSyono, TABLEID_IT_KYKSONOTATKYK, pTargetid);

        for (int n = 0; n < beanList.size(); n++) {

            if (n == 0) {
                tkykarihyj = beanList.get(n).getNewnaiyouoriginal();
            }

            if (Integer.parseInt(pHenkousikibetukey) > Integer.parseInt(beanList.get(n).getHenkousikibetukey())) {
                break;
            }

            tkykarihyj = beanList.get(n).getBfrnaiyouoriginal();

        }

        return tkykarihyj;
    }
}
