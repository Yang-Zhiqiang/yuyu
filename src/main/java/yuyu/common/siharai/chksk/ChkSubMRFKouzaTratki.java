package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzdairiten.BzHanteiAgUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック ＭＲＦ口座取扱チェック
 */
public class ChkSubMRFKouzaTratki {

    @Inject
    private static Logger logger;

    public ChkSubMRFKouzaTratki() {
        super();
    }

    public void exec(String pOyadrtenCd, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ ＭＲＦ口座取扱チェック 開始");

        if (BzHanteiAgUtil.isAgMrfkouzatoriatukaiKeyOyadrten(pOyadrtenCd) == true) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.MRFKOUZATRATKI_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ ＭＲＦ口座取扱チェック 終了");
    }

}
