package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_UktkakKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 受取人人数整合性チェック
 */
public class CheckUktNinzuu {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckUktNinzuu() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 受取人人数整合性チェック 開始");
        }

        HT_MosKihon mosKihon = pMp.getDataSyoriControl().getMosKihon();
        HT_SyoriCTL syoriCtl = pMp.getDataSyoriControl();

        int sbuktNin = mosKihon.getSbuktnin();
        C_UktkakKbn uktKakKbn = syoriCtl.getUktkakkbn();

        if (sbuktNin >= 5 && C_UktkakKbn.BLNK.eq(uktKakKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    new StringBuffer(MessageId.EHC0184).append(" ").append(
                            MessageUtil.getMessage(MessageId.EHC0184)).toString(), pMp);
        }
        else if (sbuktNin < 5 && !C_UktkakKbn.BLNK.eq(uktKakKbn)) {
            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI,
                    new StringBuffer(MessageId.EHC0191).append(" ").append(
                            MessageUtil.getMessage(MessageId.EHC0191)).toString(), pMp);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 受取人人数整合性チェック 終了");
        }
    }
}