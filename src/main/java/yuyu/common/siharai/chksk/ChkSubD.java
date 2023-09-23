package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.haitou.CheckDShrSibou;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 保険金給付金支払 請求内容チェック 配当金チェック
 */
public class ChkSubD {

    @Inject
    private static Logger logger;

    ChkSubD() {
        super();
    }

    public void exec(BizDate pHanteikijyunymd, String pSyono, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 配当金チェック 開始");

        if (pHanteikijyunymd != null && !BizUtil.isBlank(pSyono)) {

            CheckDShrSibou checkDShrSibou =  SWAKInjector.getInstance(CheckDShrSibou.class);

            if (C_ErrorKbn.ERROR.eq(checkDShrSibou.checkDShr(pSyono, pHanteikijyunymd, BizDate.getSysDate()))) {

                throw new BizAppException(MessageId.EJA1027);

            }

            if (C_UmuKbn.ARI.eq(checkDShrSibou.getDHuseigouUmu())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.D_SEIGOUSEI_CHK);

                pChkKekkaBeanLst.add(chkKekkaBean);
            }
            if (C_UmuKbn.ARI.eq(checkDShrSibou.getMihaneiDUmu())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.D_MIHANEI_CHK);

                pChkKekkaBeanLst.add(chkKekkaBean);
            }
            if (C_UmuKbn.ARI.eq(checkDShrSibou.getDShrYmdUmu())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);

                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.D_SHRYMDUMU_CHK);

                pChkKekkaBeanLst.add(chkKekkaBean);
            }
        }

        logger.debug("△ 配当金チェック 終了");
    }
}
