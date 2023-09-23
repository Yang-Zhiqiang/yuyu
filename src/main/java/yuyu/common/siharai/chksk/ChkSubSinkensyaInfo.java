package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;

/**
 * 保険金給付金支払 請求内容チェック 親権者情報チェック
 */
public class ChkSubSinkensyaInfo {

    @Inject
    private static Logger logger;

    public ChkSubSinkensyaInfo() {
        super();
    }

    public void exec(String pSkskknnmKn, String pSkskknnmKj, C_SkskknsyubetuKbn pSksKknSyubetuKbn,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 親権者情報チェック 開始");

        chkSinkensyaInfo(pSkskknnmKn, pSkskknnmKj, pSksKknSyubetuKbn, pChkKekkaBeanLst);

        logger.debug("△ 親権者情報チェック 終了");
    }

    private void chkSinkensyaInfo(String pSkskknnmKn, String pSkskknnmKj,
        C_SkskknsyubetuKbn pSksKknSyubetuKbn, List<ChkKekkaBean> pChkKekkaBeanLst) {

        if (BizUtil.isBlank(pSkskknnmKj) && BizUtil.isBlank(pSkskknnmKn)
            && C_SkskknsyubetuKbn.BLNK.eq(pSksKknSyubetuKbn)) {
        }
        else if (!BizUtil.isBlank(pSkskknnmKj) && !BizUtil.isBlank(pSkskknnmKn)
            && !C_SkskknsyubetuKbn.BLNK.eq(pSksKknSyubetuKbn)) {
        }
        else {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSKINFO_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        Boolean resultKn = CheckMeigininNmKana.isCheckOK(pSkskknnmKn, C_Kojinhjn.KOJIN);

        if (!resultKn) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SKSKKNNMKNMEIGI_CHK);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

    }
}
