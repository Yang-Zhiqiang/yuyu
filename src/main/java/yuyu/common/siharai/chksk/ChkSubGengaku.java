package yuyu.common.siharai.chksk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.DateFormatUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 保険金給付金支払 請求内容チェック 減額チェック
 */
public class ChkSubGengaku {

    @Inject
    private static Logger logger;

    public ChkSubGengaku() {
        super();
    }

    public void exec(JT_SiKykKihon pSiKykKihon, List<ChkKekkaBean> pChkKekkaBeanLst) {
        logger.debug("▽ 減額チェック 開始");
        if (pSiKykKihon.getSykyknyhenkouymd() != null) {
            ChkKekkaBean chkKekkaBean = SWAKInjector.getInstance(ChkKekkaBean.class);
            chkKekkaBean.setSKNaiyouChkKbn(C_SKNaiyouChkKbn.SATEICHK_GENGK);
            BizDate gengakuYmd = pSiKykKihon.getSykyknyhenkouymd();
            String warekiGengakuYmd = DateFormatUtil.dateDOTWareki(gengakuYmd);
            String gengaku = MessageUtil.getMessage(MessageId.IJW1006);
            chkKekkaBean.setMsgHikisuu1(gengaku + "（" + warekiGengakuYmd + "）");
            pChkKekkaBeanLst.add(chkKekkaBean);
        }
        logger.debug("△ 減額チェック 終了");
    }
}