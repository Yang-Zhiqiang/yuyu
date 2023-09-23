package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;

/**
 * 保険金給付金支払 請求内容チェック 再査定チェック
 */
public class ChkSubSaisatei {

    @Inject
    private static Logger logger;

    public ChkSubSaisatei() {
        super();
    }

    public void exec(C_SaisateiKbn pSaisateiKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 再査定チェック 開始");

        if (C_SaisateiKbn.SAISATEI.eq(pSaisateiKbn)) {

            ChkKekkaBean chkKekkaBean1 = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean1.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAISATEI_CHK1);
            pChkKekkaBeanLst.add(chkKekkaBean1);

            ChkKekkaBean chkKekkaBean2 = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean2.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SAISATEI_CHK2);
            pChkKekkaBeanLst.add(chkKekkaBean2);
        }

        logger.debug("△ 再査定チェック 終了");
    }

}