package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import org.slf4j.Logger;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;

/**
 * 保険金給付金支払 請求内容チェック 反社チェック
 */
public class ChkSubHansya {

    @Inject
    private static Logger logger;

    public ChkSubHansya() {
        super();
    }

    public void exec(C_SeikyuuSyubetu pSeikyuuSyubetu, BzSakuinTsnSyoukaiKekkaBean pBzSakuinTsnSyoukaiKekkaBean,
        List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ 反社チェック 開始");

        if (C_SeikyuuSyubetu.SB.eq(pSeikyuuSyubetu)) {
            if (pBzSakuinTsnSyoukaiKekkaBean != null) {
                BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = pBzSakuinTsnSyoukaiKekkaBean;

                if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn())) {
                    ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
                    chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_HANSYA);
                    pChkKekkaBeanLst.add(chkKekkaBean);
                }
            }
        }

        logger.debug("△ 反社チェック 終了");
    }
}
