package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_UktkJyoutaiKbn;
import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouUktkBean;

/**
 * 保険金給付金支払 請求内容チェック DS解約処理中チェック
 */
public class ChkSubDsKaiykSyori {

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public ChkSubDsKaiykSyori() {
        super();
    }

    public void exec(String pSyoNo, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ ＤＳ解約処理中チェック 開始");

        C_UktkJyoutaiKbn[] uktkJyoutaiKbns = new C_UktkJyoutaiKbn[] { C_UktkJyoutaiKbn.MISYORI, C_UktkJyoutaiKbn.ERROR };

        List<KhHenkouUktkBean> khHenkouUktkBeanLst = hozenDomManager.getKhHenkouUktkBySyonoUktkjyoutaiKbn(pSyoNo,
            uktkJyoutaiKbns);

        for (KhHenkouUktkBean khHenkouUktkBean : khHenkouUktkBeanLst) {
            if (C_UktkSyoriKbn.KAIYAKU.eq(khHenkouUktkBean.getUktkSyoriKbn())) {

                ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.DSKAIYAKUSYORI_CHK);
                pChkKekkaBeanLst.add(chkKekkaBean);

                logger.debug("△ ＤＳ解約処理中チェック 終了");

                return;
            }

        }

        logger.debug("△ ＤＳ解約処理中チェック 終了");

    }
}
