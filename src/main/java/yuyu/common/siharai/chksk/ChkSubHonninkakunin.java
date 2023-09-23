package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SiHonninKakninKekkaKbn;

/**
 * 保険金給付金支払 請求内容チェック 本人確認チェック
 */
public class ChkSubHonninkakunin {

    @Inject
    private static Logger logger;

    public ChkSubHonninkakunin() {
        super();
    }

    public void exec(C_SiHonninKakninKekkaKbn pSiHonninKakninKekkaKbn,
            C_SUketoriHouhouKbn pSUketoriHouhouKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 本人確認チェック 開始");

        if (C_SiHonninKakninKekkaKbn.KOUZA.eq(pSiHonninKakninKekkaKbn)) {
            chkHonninKakunin(pSUketoriHouhouKbn, pChkKekkaBeanLst);
        }

        logger.debug("△ 本人確認チェック 終了");
    }

    private void chkHonninKakunin(C_SUketoriHouhouKbn pSUketoriHouhouKbn,
            List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (C_SUketoriHouhouKbn.ZENGAKU_NENKIN.eq(pSUketoriHouhouKbn)
                || C_SUketoriHouhouKbn.ITIBU_NENKIN.eq(pSUketoriHouhouKbn)) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HONNINKAKNIN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }
}