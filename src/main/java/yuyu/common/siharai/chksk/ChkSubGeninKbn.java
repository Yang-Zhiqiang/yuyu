package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 原因区分チェック
 */
public class ChkSubGeninKbn {

    @Inject
    private static Logger logger;

    public ChkSubGeninKbn() {
        super();
    }

    public void exec(C_GeninKbn pGeninKbn, List<String> pByoumeiTourokuNoLst,
            List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 原因区分チェック 開始");

        if (C_GeninKbn.BSSS.eq(pGeninKbn)) {
            chkGeninKbn(pByoumeiTourokuNoLst, pChkKekkaBeanLst);
        }

        logger.debug("△ 原因区分チェック 終了");
    }

    private void chkGeninKbn(List<String> pByoumeiTourokuNoLst, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (pByoumeiTourokuNoLst == null || pByoumeiTourokuNoLst.size() == 0) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.GENINKBN_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
    }
}