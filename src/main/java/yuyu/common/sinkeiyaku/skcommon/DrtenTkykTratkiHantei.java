package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 新契約共通 代理店別特約取扱判定
 */
public class DrtenTkykTratkiHantei {

    @Inject
    private static Logger logger;

    public C_TkykTratkiKbn targettkTratkiHantei(C_TargetTkHukaKanouKbn pTargetTkHukaKanouKbn,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {
        logger.debug("▽ 代理店別特約取扱判定 開始");

        C_TkykTratkiKbn tkykTratkiKbn = C_TkykTratkiKbn.BLNK;

        if (C_TargetTkHukaKanouKbn.NONE.eq(pTargetTkHukaKanouKbn)) {
            tkykTratkiKbn = C_TkykTratkiKbn.BLNK;
        } else if (C_TargetTkHukaKanouKbn.YENSYUUSIN.eq(pTargetTkHukaKanouKbn)) {
            tkykTratkiKbn = yenSyuusinHantei(pSkeijimuKbn, pOyadrtencd);
        } else if (C_TargetTkHukaKanouKbn.YENNENKIN.eq(pTargetTkHukaKanouKbn)) {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAHISSU;
        }

        logger.debug("△ 代理店別特約取扱判定 終了");

        return tkykTratkiKbn;
    }

    public C_TkykTratkiKbn yennykntkTratkiHantei(String pSyouhncd, C_UmuKbn pPyennykntktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        logger.debug("▽ 代理店別特約取扱判定 開始");

        C_TkykTratkiKbn tkykTratkiKbn = C_TkykTratkiKbn.BLNK;

        if (C_UmuKbn.NONE.eq(pPyennykntktekiumu)) {
            tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;

            logger.debug("△ 代理店別特約取扱判定 終了");

            return tkykTratkiKbn;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);
        if (SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN == syohinHanteiKbn) {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAHISSU;

            logger.debug("△ 代理店別特約取扱判定 終了");

            return tkykTratkiKbn;
        }

        if(SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syohinHanteiKbn
            && (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(pOyadrtencd)
                || YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(pOyadrtencd))){

            tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
        }
        else {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAKANOU;
        }

        logger.debug("△ 代理店別特約取扱判定 終了");

        return tkykTratkiKbn;
    }

    public C_TkykTratkiKbn gaikanykntkTratkiHantei(String pSyouhncd, C_UmuKbn pGaikanyuukintktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        logger.debug("▽ 代理店別特約取扱判定 開始");

        C_TkykTratkiKbn tkykTratkiKbn = C_TkykTratkiKbn.BLNK;

        if (C_UmuKbn.NONE.eq(pGaikanyuukintktekiumu)) {
            tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
            return tkykTratkiKbn;
        }

        int syukeiyakuSyohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);

        if (syukeiyakuSyohinHanteiKbn == SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR) {
            if (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(pOyadrtencd) ||
                YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(pOyadrtencd)) {
                tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
            }
            else {
                tkykTratkiKbn = C_TkykTratkiKbn.HUKAKANOU;
            }
        }
        else {
            if (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(pOyadrtencd) ||
                YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(pOyadrtencd) ||
                YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken().equals(pOyadrtencd)) {
                tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
            }
            else {
                tkykTratkiKbn = C_TkykTratkiKbn.HUKAKANOU;
            }
        }

        logger.debug("△ 代理店別特約取扱判定 終了");

        return tkykTratkiKbn;
    }

    public C_TkykTratkiKbn initsbjiYenknsnshrgkSaiteihsytkTratkiHantei(String pSyouhncd, C_UmuKbn pSyksbyensitihsyutktekiumu,
        C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {

        logger.debug("▽ 代理店別特約取扱判定 開始");

        C_TkykTratkiKbn tkykTratkiKbn = C_TkykTratkiKbn.BLNK;

        int syukeiyakuSyohinHanteiKbn = SyouhinUtil.hantei(pSyouhncd);
        if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR == syukeiyakuSyohinHanteiKbn) {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAKANOU;
        }
        else if (SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 == syukeiyakuSyohinHanteiKbn) {
            tkykTratkiKbn = initsbjiYenknsnshrgkSaiteihsytkHantei(pSkeijimuKbn, pOyadrtencd);
        }else{
            tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
        }

        logger.debug("△ 代理店別特約取扱判定 終了");

        return tkykTratkiKbn;
    }

    private C_TkykTratkiKbn yenSyuusinHantei(C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {
        C_TkykTratkiKbn tkykTratkiKbn;

        if (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(pOyadrtencd)||
            YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken().equals(pOyadrtencd) ||
            YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(pOyadrtencd)) {
            tkykTratkiKbn = C_TkykTratkiKbn.TRATKINASI;
        } else {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAHISSU;
        }

        return tkykTratkiKbn;
    }

    private C_TkykTratkiKbn initsbjiYenknsnshrgkSaiteihsytkHantei(C_SkeijimuKbn pSkeijimuKbn, String pOyadrtencd) {
        C_TkykTratkiKbn tkykTratkiKbn = C_TkykTratkiKbn.HUKAKANOU;

        if (YuyuBizConfig.getInstance().getSmbcOyadrtencd().equals(pOyadrtencd) ||
            YuyuSinkeiyakuConfig.getInstance().getSmbcnikkousyouken().equals(pOyadrtencd) ||
            YuyuSinkeiyakuConfig.getInstance().getSmbcsintakubank().equals(pOyadrtencd)) {
            tkykTratkiKbn = C_TkykTratkiKbn.HUKAHISSU;
        }

        return tkykTratkiKbn;
    }

}
