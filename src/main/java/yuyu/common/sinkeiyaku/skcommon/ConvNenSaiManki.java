package yuyu.common.sinkeiyaku.skcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 年歳満期変換処理
 */
public class ConvNenSaiManki {

    private final static int MINHRKKKN = 0;

    private final static int MAXHRKKKN = 99;

    private final static int MINHKNKKN = 0;

    private final static int MAXHKNKKN = 99;

    @Inject
    private static Logger logger;

    private Integer hrkkknNen = 0;

    private Integer hrkkknSai = 0;

    private Integer hknkknNen = 0;

    private Integer hknkknSai = 0;

    public ConvNenSaiManki() {
        super();
    }

    public Integer getHrkkknNen() {
        return hrkkknNen;
    }

    public Integer getHrkkknSai() {
        return hrkkknSai;
    }

    public Integer getHknkknNen() {
        return hknkknNen;
    }

    public Integer getHknkknSai() {
        return hknkknSai;
    }

    public C_ErrorKbn convHrkkknNen(Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, Integer pHhknnen) {

        logger.debug("▽ 年歳満期変換処理 開始");

        hrkkknNen = 0;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHrkkkn == null || pHrkkknsmnkbn == null || pHhknnen == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (pHrkkkn.intValue() == YuyuSinkeiyakuConfig.getInstance().getHrkkknItijibarai().intValue()) {

            hrkkknNen = pHrkkkn;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pHrkkknsmnkbn)) {

            hrkkknNen = pHrkkkn - pHhknnen;
        }
        else {

            hrkkknNen = pHrkkkn;
        }

        if (hrkkknNen < MINHRKKKN || hrkkknNen > MAXHRKKKN) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        logger.debug("△ 年歳満期変換処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn convHrkkknSai(Integer pHrkkkn, C_HrkkknsmnKbn pHrkkknsmnkbn, Integer pHhknnen) {

        logger.debug("▽ 年歳満期変換処理 開始");

        hrkkknSai = 0;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHrkkkn == null || pHrkkknsmnkbn == null || pHhknnen == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (pHrkkkn.intValue() == YuyuSinkeiyakuConfig.getInstance().getHrkkknItijibarai().intValue()) {

            hrkkknSai = pHrkkkn;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pHrkkknsmnkbn)) {

            hrkkknSai = pHrkkkn;
        }
        else {

            hrkkknSai = pHrkkkn + pHhknnen;
        }

        if (hrkkknSai < MINHRKKKN || hrkkknSai > MAXHRKKKN) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        logger.debug("△ 年歳満期変換処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn convHknkknNen(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHhknnen) {

        logger.debug("▽ 年歳満期変換処理 開始");

        hknkknNen = 0;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHknkkn == null || pHknkknsmnKbn == null || pHhknnen == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (pHknkkn.intValue() == YuyuSinkeiyakuConfig.getInstance().getHknkknSyuusin().intValue()) {

            hknkknNen = pHknkkn;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pHknkknsmnKbn)) {
            hknkknNen = pHknkkn - pHhknnen;
        }
        else {
            hknkknNen = pHknkkn;
        }

        if (hknkknNen < MINHKNKKN || hknkknNen > MAXHKNKKN) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        logger.debug("△ 年歳満期変換処理 終了");

        return errorKbn;
    }

    public C_ErrorKbn convHknkknSai(Integer pHknkkn, C_HknkknsmnKbn pHknkknsmnKbn, Integer pHhknnen) {

        logger.debug("▽ 年歳満期変換処理 開始");

        hknkknSai = 0;

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (pHknkkn == null || pHknkknsmnKbn == null || pHhknnen == null) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (pHknkkn.intValue() == YuyuSinkeiyakuConfig.getInstance().getHknkknSyuusin().intValue()) {

            hknkknSai = pHknkkn;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        if (C_HknkknsmnKbn.SAIMANKI.eq(pHknkknsmnKbn)) {

            hknkknSai = pHknkkn;
        }
        else {

            hknkknSai = pHknkkn + pHhknnen;
        }

        if (hknkknSai < MINHKNKKN || hknkknSai > MAXHKNKKN) {

            errorKbn = C_ErrorKbn.ERROR;

            logger.debug("△ 年歳満期変換処理 終了");

            return errorKbn;
        }

        logger.debug("△ 年歳満期変換処理 終了");

        return errorKbn;
    }
}
