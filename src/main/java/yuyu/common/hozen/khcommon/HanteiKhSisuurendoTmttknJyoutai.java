package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.hozen.khcommon.dba4hanteikhsisuurendotmttknjyoutai.HanteiKhSisuurendoTmttknJyoutaiDao;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_TykzentykgoKbn;

/**
 * 契約保全 契約保全共通 指数連動積増型年金積立金状態判定
 */
public class HanteiKhSisuurendoTmttknJyoutai {

    @Inject
    private static Logger logger;

    @Inject
    private HanteiKhSisuurendoTmttknJyoutaiDao hanteiKhSisuurendoTmttknJyoutaiDao;

    public HanteiKhSisuurendoTmttknJyoutai() {
        super();
    }

    public boolean execChokuzenOutouymTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        logger.debug("▽ 直前応当年月積立金判定 開始");

        boolean result;

        BizDate outouymd = null;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        outouymd = setOutoubi.exec(
            C_TykzentykgoKbn.TYKZEN,
            pHanteiTmttknJyoutaiBean.getKykymd(),
            C_Hrkkaisuu.NEN,
            pHanteiTmttknJyoutaiBean.getHanteiKijyunymd());

        long kensuu = hanteiKhSisuurendoTmttknJyoutaiDao.getSisuurendoTmttknCountBySyonoTmttkntaisyouym(
            pHanteiTmttknJyoutaiBean.getSyono(), outouymd.getBizDateYM());

        if (kensuu >= 1) {
            result = true;
        }
        else {
            result = false;
        }

        logger.debug("△ 直前応当年月積立金判定 終了");

        return result;
    }

    public boolean execKijunymdgoTmttknHantei(HanteiTmttknJyoutaiBean pHanteiTmttknJyoutaiBean) {

        logger.debug("▽ 基準日後積立金判定 開始");

        boolean result;

        long kensuu = hanteiKhSisuurendoTmttknJyoutaiDao.getSisuurendoTmttknCountBySyonoTmttknkouryokukaisiymd(
            pHanteiTmttknJyoutaiBean.getSyono(), pHanteiTmttknJyoutaiBean.getHanteiKijyunymd());

        if (kensuu >= 1) {
            result = true;
        }
        else {
            result = false;
        }

        logger.debug("△ 基準日後積立金判定 終了");

        return result;
    }
}


