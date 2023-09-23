package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック ＭＲ情報チェック
 */
public class ChkSubMrInfo {

    @Inject
    private static Logger logger;

    public ChkSubMrInfo() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {

        logger.debug("▽ ＭＲ情報チェック 開始");

        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);
        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector
                .getInstance(BzSakuinTsnSyoukaiYokenBean.class);

        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pSiKykKihon.getSyono());
        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);
        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);

        BzSakuinTsnSyoukaiKekkaBean bzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq
                .exec(bzSakuinTsnSyoukaiYokenBean);

        if (C_BlnktkumuKbn.ARI.eq(bzSakuinTsnSyoukaiKekkaBean.getSntkinfohnsyumukbn())) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_MRINFO);
            pChkKekkaBeanLst.add(chkKekkaBean);
        }

        logger.debug("△ ＭＲ情報チェック 終了");
    }
}
