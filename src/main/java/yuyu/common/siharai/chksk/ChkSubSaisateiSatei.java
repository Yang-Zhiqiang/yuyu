package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;

/**
 * 保険金給付金支払 請求内容チェック 査定項目＿再査定チェック
 */
public class ChkSubSaisateiSatei {

    @Inject
    private static Logger logger;

    public ChkSubSaisateiSatei() {
        super();
    }

    public void exec(C_SaisateiKbn pSaisateiKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 査定項目＿再査定チェック 開始");

        if (C_SaisateiKbn.SAISATEI.eq(pSaisateiKbn)) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_SAISATEI);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 査定項目＿再査定チェック 終了");
    }

}