package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;

/**
 * 保険金給付金支払 請求内容チェック 受取方法チェック
 */
public class ChkSubUketoriHouhou {

    @Inject
    private static Logger logger;

    public ChkSubUketoriHouhou() {
        super();
    }

    public void exec(C_SUketoriHouhouKbn pSUketoriHouhouKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 受取方法チェック 開始");


        if (C_SUketoriHouhouKbn.BLNK.eq(pSUketoriHouhouKbn)) {

            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SUKETORIHOUHOU_MINYUCHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ 受取方法チェック 終了");
    }
}
