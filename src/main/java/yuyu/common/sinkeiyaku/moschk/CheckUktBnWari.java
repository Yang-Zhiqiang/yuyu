package yuyu.common.sinkeiyaku.moschk;


import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 新契約 申込内容チェック 受取人分割割合チェック
 */
public class CheckUktBnWari {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckUktBnWari() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, List<HT_Uketorinin> pUketorininLst) {

        BizNumber sumUktBnWari = BizNumber.valueOf(0);
        C_UktsyuKbn uktSyuKbn = C_UktsyuKbn.BLNK;

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 受取人分割割合チェック 開始");
        }

        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        int sbUktnin = mosKihon.getSbuktnin();

        for (HT_Uketorinin uketorinin : pUketorininLst) {

            sumUktBnWari = uketorinin.getUktbnwari().add(sumUktBnWari);
            uktSyuKbn = uketorinin.getUktsyukbn();
        }

        if (sbUktnin < 5 && BizNumber.ZERO.compareTo(sumUktBnWari) != 0 &&
            BizNumber.valueOf(100).compareTo(sumUktBnWari) != 0) {

            setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, MessageId.EHC0008 + " " +
                MessageUtil.getMessage(MessageId.EHC0008, uktSyuKbn.getContent()), pMP);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 受取人分割割合チェック 終了");
        }
    }
}