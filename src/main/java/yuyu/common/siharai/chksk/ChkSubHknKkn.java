package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykSyouhn;

/**
 * 保険金給付金支払 請求内容チェック 保険期間チェック
 */
public class ChkSubHknKkn {

    @Inject
    private static Logger logger;

    public ChkSubHknKkn() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, JT_SiKykSyouhn pSiKykSyouhn, List<ChkKekkaBean> pChkKekkaBeanList) {

        logger.debug("▽ 保険期間チェック 開始");

        if (pHanteiKijyunYmd != null) {

            if (BizDateUtil.compareYmd(pSiKykSyouhn.getHknkknmanryouymd(), pHanteiKijyunYmd) == BizDateUtil.COMPARE_LESSER) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.HKNKKN_CHK);

                pChkKekkaBeanList.add(chkKekkaBean);
            }
        }

        logger.debug("△ 保険期間チェック 終了");

    }
}