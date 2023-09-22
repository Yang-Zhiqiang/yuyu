package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;

/**
 * 新契約 新契約共通 年金商品項目編集ユーティリティ
 */
public class EditNenkinKoumokuUtil {

    private Integer nenkinSueokikikan = 0;

    private Integer nenkinSiharaiKaisiNenrei = 0;

    private BizCurrency nkgnsKijyunGk = BizCurrency.valueOf(0,BizCurrencyTypes.YEN);

    @Inject
    private static Logger logger;

    public EditNenkinKoumokuUtil() {
        super();
    }

    public Integer getNenkinSueokikikan() {
        return nenkinSueokikikan;
    }

    public Integer getNenkinSiharaiKaisiNenrei() {
        return nenkinSiharaiKaisiNenrei;
    }

    public BizCurrency getNkgnsKijyunGk() {
        return nkgnsKijyunGk;
    }

    public C_ErrorKbn editNenkinSueokikikan(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn,
        Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnKbn, Integer pHhknnen) {

        logger.debug("▽ 年金据置期間編集 開始");

        nenkinSueokikikan = 0;
        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;
        Integer hknkknNen = 0;
        Integer hrkkknNen = 0;

        if (pHknkkn == null) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }
        else if (pHknkknsmnKbn == null) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }
        else if (pHrkkkn == null) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }
        else if (pHrkkknsmnKbn == null) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }
        else if (pHhknnen == null) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }

        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

        if (C_ErrorKbn.OK.eq(convNenSaiManki.convHknkknNen(pHknkkn, pHknkknsmnKbn, pHhknnen))) {
            hknkknNen = convNenSaiManki.getHknkknNen();
        }
        else {

            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }

        if (pHrkkkn > 0) {

            if (C_ErrorKbn.OK.eq(convNenSaiManki.convHrkkknNen(pHrkkkn, pHrkkknsmnKbn, pHhknnen))) {
                hrkkknNen = convNenSaiManki.getHrkkknNen();
            }
            else {

                logger.debug("△ 年金据置期間編集 終了");

                return errorKbn;
            }
        }

        nenkinSueokikikan = hknkknNen - hrkkknNen;

        if (nenkinSueokikikan < 0) {
            logger.debug("△ 年金据置期間編集 終了");

            return errorKbn;
        }

        errorKbn = C_ErrorKbn.OK;

        logger.debug("△ 年金据置期間編集 終了");

        return errorKbn;
    }

    public C_ErrorKbn editNenkinSiharaiKaisiNenrei(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHhknnen) {

        logger.debug("▽ 年金支払開始年齢編集 開始");

        nenkinSiharaiKaisiNenrei = 0;
        C_ErrorKbn errorKbn = C_ErrorKbn.ERROR;

        if (pHknkkn == null) {
            logger.debug("△ 年金支払開始年齢編集 終了");

            return errorKbn;
        }
        else if (pHknkknsmnKbn == null) {
            logger.debug("△ 年金支払開始年齢編集 終了");

            return errorKbn;
        }
        else if (pHhknnen == null) {
            logger.debug("△ 年金支払開始年齢編集 終了");

            return errorKbn;
        }

        ConvNenSaiManki convNenSaiManki = SWAKInjector.getInstance(ConvNenSaiManki.class);

        if (C_ErrorKbn.OK.eq(convNenSaiManki.convHknkknSai(pHknkkn, pHknkknsmnKbn, pHhknnen))) {

            nenkinSiharaiKaisiNenrei = convNenSaiManki.getHknkknSai();

            errorKbn = C_ErrorKbn.OK;
        }
        else {

            logger.debug("△ 年金支払開始年齢編集 終了");

            return errorKbn;
        }

        logger.debug("△ 年金支払開始年齢編集 終了");

        return errorKbn;
    }

    public BizCurrency getSkNkgnsKijyunGk(BM_SyouhnZokusei pSyouhnZokusei, HT_MosKihon pMosKihon, HT_MosSyouhn pMosSyouhn) {

        logger.debug("▽ 新契約年金原資基準額取得 開始");

        BizCurrency skNkgensiKijyunGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        nkgnsKijyunGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        C_Tuukasyu nkGensiKijyunGkType = C_Tuukasyu.BLNK;

        if (pSyouhnZokusei == null) {
            logger.debug("△ 新契約年金原資基準額取得 終了");

            return skNkgensiKijyunGk;
        }
        else if (pMosKihon == null) {
            logger.debug("△ 新契約年金原資基準額取得 終了");

            return skNkgensiKijyunGk;
        }
        else if (pMosSyouhn == null) {
            logger.debug("△ 新契約年金原資基準額取得 終了");

            return skNkgensiKijyunGk;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(pSyouhnZokusei.getSyouhncd());

        if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
            syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20 ) {

            if (pMosSyouhn.getSeitoukihons() != null) {
                nkgnsKijyunGk = pMosSyouhn.getSeitoukihons();

            }else{
                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pMosKihon.getKyktuukasyu());
                nkgnsKijyunGk = BizCurrency.valueOf(0, currencyType);
            }

            if(pMosKihon.getHrktuukasyu().eq(C_Tuukasyu.JPY)){
                if(pMosKihon.getFstphrkgk() != null){
                    skNkgensiKijyunGk = pMosKihon.getFstphrkgk();

                    logger.debug("△ 新契約年金原資基準額取得 終了");

                    return skNkgensiKijyunGk;
                }
                nkGensiKijyunGkType = pMosKihon.getHrktuukasyu();
            }else{
                skNkgensiKijyunGk = nkgnsKijyunGk;

                logger.debug("△ 新契約年金原資基準額取得 終了");

                return skNkgensiKijyunGk;
            }
        }

        else if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {

            if (pMosKihon.getPharaikomisougaku() != null) {

                skNkgensiKijyunGk = pMosKihon.getPharaikomisougaku();
                nkgnsKijyunGk = pMosKihon.getPharaikomisougaku();

                logger.debug("△ 新契約年金原資基準額取得 終了");

                return skNkgensiKijyunGk;

            }

            nkGensiKijyunGkType = C_Tuukasyu.JPY;

        }

        else {

            nkGensiKijyunGkType = pMosKihon.getKyktuukasyu();
        }

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(nkGensiKijyunGkType);

        skNkgensiKijyunGk = BizCurrency.valueOf(0, currencyType);

        logger.debug("△ 新契約年金原資基準額取得 終了");

        return skNkgensiKijyunGk;
    }
}