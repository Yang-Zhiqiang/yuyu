package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 契約日チェック
 */
public class ChkSubKykYmd {

    @Inject
    private static Logger logger;

    public void exec(BizDate pHanteiKijyunYmd, BizDate pkykYmd,
        List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 契約日チェック 開始");

        if(pHanteiKijyunYmd != null && pkykYmd != null){
            if(BizDateUtil.compareYmd(pHanteiKijyunYmd, pkykYmd) == BizDateUtil.COMPARE_LESSER){
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.KYKYMDCHECK_CHK);
                pChkKekkaBeanList.add(chkKekkaBean);
            }
        }

        logger.debug("△ 契約日チェック 終了");

    }
}
