package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 円建変更日チェック
 */
public class ChkSubEndtHenkouYmd {

    @Inject
    private static Logger logger;

    public void exec(BizDate pHanteiKijyunYmd, BizDate pYenHenkoYmd,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 円建変更日チェック 開始");

        if(pHanteiKijyunYmd != null && pYenHenkoYmd != null){
            if(BizDateUtil.compareYmd(pHanteiKijyunYmd, pYenHenkoYmd) == BizDateUtil.COMPARE_LESSER){
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.ENDTHNKYMDCHECK_CHK);
                pChkKekkaBeanList.add(chkKekkaBean);
            }
        }

        logger.debug("△ 円建変更日チェック 終了");

    }
}
