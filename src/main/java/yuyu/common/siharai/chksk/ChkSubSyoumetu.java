package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 消滅チェック
 */
public class ChkSubSyoumetu {

    @Inject
    private static Logger logger;

    public ChkSubSyoumetu() {
        super();
    }

    public void exec(C_SaisateiKbn pSaisateiKbn, JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 消滅チェック 開始");

        if (C_SaisateiKbn.BLNK.eq(pSaisateiKbn)) {

            if (C_YuukousyoumetuKbn.SYOUMETU.eq(pSiKykKihon.getYuukousyoumetukbn())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SYOUMETU_CHK);
                chkKekkaBean.setMsgHikisuu1(C_YuukousyoumetuKbn.SYOUMETU.getContent());
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 消滅チェック 終了");
    }
}
