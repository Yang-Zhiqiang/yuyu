package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * 保険金給付金支払 請求内容チェック 保険料払込猶予期間チェック
 */
public class ChkSubPHrkmYuuyokkn {

    @Inject
    private static Logger logger;

    public ChkSubPHrkmYuuyokkn() {
        super();
    }

    public void exec(BizDate pHanteiKijyunYmd, String pSyono, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 保険料払込猶予期間チェック 開始");

        if (pHanteiKijyunYmd != null && !BizUtil.isBlank(pSyono)) {

            CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);
            boolean hanteiKekka = checkYuuyokkngai.exec(pSyono, pHanteiKijyunYmd);

            if (!hanteiKekka) {
                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.PHRKYUYOKKN_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 保険料払込猶予期間チェック 終了");
    }
}
