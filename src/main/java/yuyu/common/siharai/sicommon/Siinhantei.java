package yuyu.common.siharai.sicommon;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_ByoumeiGaitouKbn2;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.siharai.detacher.JM_ByoumeiDetacher;
import yuyu.def.siharai.detacher.JM_SiinHanteiDetacher;
import yuyu.def.siharai.manager.SiharaiDomManager;

/**
 * 保険金給付金支払 保険金給付金支払共通 死因判定
 */
public class Siinhantei {
    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private static Logger logger;

    public Siinhantei() {
        super();
    }

    public C_SiinKbn hanteiGeninKbn(C_GeninKbn pGeninKbn) {

        logger.debug("▽ 死因判定 開始");

        C_SiinKbn siinKbn = C_SiinKbn.BLNK;


        if (pGeninKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (C_GeninKbn.SP.eq(pGeninKbn)) {
            siinKbn = C_SiinKbn.SP;
        }
        else if (C_GeninKbn.SG.eq(pGeninKbn)) {
            siinKbn = C_SiinKbn.SG;
        }
        else if (C_GeninKbn.JS.eq(pGeninKbn)) {
            siinKbn = C_SiinKbn.JS;
        }

        logger.debug("△ 死因判定 終了");
        return siinKbn;
    }

    public C_SiinKbn hanteiSkuke(C_GeninKbn pSibouKariuketukejiGeninKbn, C_GeninKbn pSeikyuuuketukejiGeninKbn,
        List<String> pByoumeiTourokuNoList, C_UmuKbn pSateikakSaigaiKanouseiKbn, C_UmuKbn pSateiKakHusyousiKbn) {

        logger.debug("▽ 死因判定 開始");

        C_SiinKbn siinKbn = C_SiinKbn.BLNK;


        if (pSibouKariuketukejiGeninKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (pSeikyuuuketukejiGeninKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (pByoumeiTourokuNoList == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (pSateikakSaigaiKanouseiKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (pSateiKakHusyousiKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        C_GeninKbn seikyuuuketukejiGeninKbn = setGeninKbn(pSeikyuuuketukejiGeninKbn);

        C_UmuKbn kansensyouUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn saigaikanouseiUmuKbn = C_UmuKbn.NONE;
        C_UmuKbn husyounosiUmuKbn = C_UmuKbn.NONE;

        for (String byoumeiTourokuNo : pByoumeiTourokuNoList) {
            JM_Byoumei byoumei = siharaiDomManager.getByoumei(byoumeiTourokuNo);

            if (byoumei != null) {
                byoumei = JM_ByoumeiDetacher.detachByoumeitouched(byoumei);

                if (C_ByoumeiGaitouKbn2.KANSENSYOU.eq(byoumei.getGaitoukbn2())) {
                    kansensyouUmuKbn = C_UmuKbn.ARI;
                }

                if (C_ByoumeiGaitouKbn2.SAIGAI.eq(byoumei.getGaitoukbn2())) {
                    saigaikanouseiUmuKbn = C_UmuKbn.ARI;
                }

                if (C_ByoumeiGaitouKbn2.HUSYOU.eq(byoumei.getGaitoukbn2())) {
                    husyounosiUmuKbn = C_UmuKbn.ARI;
                }
            }
        }

        siinKbn = setSiinKbn(pSibouKariuketukejiGeninKbn, seikyuuuketukejiGeninKbn, kansensyouUmuKbn,
            saigaikanouseiUmuKbn, husyounosiUmuKbn, pSateikakSaigaiKanouseiKbn, pSateiKakHusyousiKbn);

        logger.debug("△ 死因判定 終了");
        return siinKbn;
    }

    public C_SiinKbn hanteiSatei(C_SiinKbn pSiinKbn, C_SyorikekkaKbn pSyorikekkaKbn) {

        logger.debug("▽ 死因判定 開始");

        C_SiinKbn siinKbn = C_SiinKbn.BLNK;


        if (pSiinKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (pSyorikekkaKbn == null) {

            logger.debug("△ 死因判定 終了");

            return siinKbn;
        }

        if (C_SiinKbn.SP.eq(pSiinKbn)) {

            if (C_SyorikekkaKbn.SIHARAI.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SP;
            }
            else if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SP;
            }
            else {
                siinKbn = pSiinKbn;
            }
        }
        else if (C_SiinKbn.SG.eq(pSiinKbn)) {

            if (C_SyorikekkaKbn.SIHARAI.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SG;
            }
            else if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SP;
            }
            else {
                siinKbn = pSiinKbn;
            }
        }
        else if (C_SiinKbn.JS.eq(pSiinKbn)) {

            if (C_SyorikekkaKbn.SIHARAI.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SP;
            }
            else if (C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(pSyorikekkaKbn)) {
                siinKbn = C_SiinKbn.SP;
            }
            else {
                siinKbn = pSiinKbn;
            }
        }
        else {
            siinKbn = pSiinKbn;
        }

        logger.debug("△ 死因判定 終了");
        return siinKbn;
    }

    private C_SiinKbn setSiinKbn(C_GeninKbn pSibouKariuketukejiGeninKbn, C_GeninKbn pSeikyuuuketukejiGeninKbn,
        C_UmuKbn pKansensyouUmuKbn, C_UmuKbn pSaigaikanouseiUmuKbn, C_UmuKbn pHusyounosiUmuKbn,
        C_UmuKbn pSateikakSaigaiKanouseiKbn, C_UmuKbn pSateiKakHusyousiKbn) {

        JM_SiinHantei siinHantei = siharaiDomManager.getSiinHantei(pSibouKariuketukejiGeninKbn,
            pSeikyuuuketukejiGeninKbn, pKansensyouUmuKbn, pSaigaikanouseiUmuKbn, pHusyounosiUmuKbn,
            pSateikakSaigaiKanouseiKbn, pSateiKakHusyousiKbn);

        C_SiinKbn siinKbn = C_SiinKbn.BLNK;

        if (siinHantei != null) {
            siinHantei = JM_SiinHanteiDetacher.detachSiinHanteitouched(siinHantei);
            siinKbn = siinHantei.getSiinkbn();
        }
        return siinKbn;
    }

    private C_GeninKbn setGeninKbn(C_GeninKbn pGeninKbn) {

        C_GeninKbn geninKbn = C_GeninKbn.BLNK;

        if (C_GeninKbn.BSSS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SP;
        }
        else if (C_GeninKbn.KTJK.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.TENTOU.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.DKS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.KKOKS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.TSK.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.TDK.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.SONOTAFR.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.SG;
        }
        else if (C_GeninKbn.JS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.JS;
        }
        else if (C_GeninKbn.TST.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.FSS;
        }
        else if (C_GeninKbn.SONOTAFS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.FSS;
        }
        else if (C_GeninKbn.FSS.eq(pGeninKbn)) {
            geninKbn = C_GeninKbn.FSS;
        }

        return geninKbn;
    }
}
