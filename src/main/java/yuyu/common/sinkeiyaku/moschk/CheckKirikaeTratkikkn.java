package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 商品切替取扱期間チェック
 */
public class CheckKirikaeTratkikkn {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckKirikaeTratkikkn() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 商品切替取扱期間チェック 開始");
        }

        BizDate mosYmd = pMp.getDataSyoriControl().getMosKihon().getMosymd();
        BizDate kikanFrom = YuyuSinkeiyakuConfig.getInstance().getSyouhnKrkeKknFrom();
        BizDate kikanTo = YuyuSinkeiyakuConfig.getInstance().getSyouhnKrkeKknTo();

        if (mosYmd.compareTo(kikanFrom) < 0 || kikanTo.compareTo(mosYmd) < 0) {
            String msg = MessageId.EHC0213 + " " + MessageUtil.getMessage(MessageId.EHC0213);
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, msg, pMp, C_TknKbn.NONE, C_MsgKbn.ERROR);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 商品切替取扱期間チェック 終了");
        }
    }
}