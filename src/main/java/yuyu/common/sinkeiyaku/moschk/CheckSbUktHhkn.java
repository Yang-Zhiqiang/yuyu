package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Uketorinin;

/**
 * 新契約 申込内容チェック 死亡受取人≠被保険者チェック
 */
public class CheckSbUktHhkn {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckSbUktHhkn() {
        super();
    }

    public void exec(MosnaiCheckParam pMP, List<HT_Uketorinin> pUketorininLst) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 死亡保険金受取人≠被保険者チェック 開始");
        }
        HT_MosKihon mosKihon = pMP.getDataSyoriControl().getMosKihon();

        C_KykKbn kykKbn = mosKihon.getKykkbn();

        if (C_KykKbn.KEIHI_DOUITU.eq(kykKbn)) {
            for (HT_Uketorinin uketorinin : pUketorininLst) {

                if (C_UktKbn.KYK.eq(uketorinin.getUktkbn())) {
                    setHubiMsg.exec(C_KetsrhkosKbn.KETHORYU_HUBI, C_SpKeisanKahiKbn.SPKEISANKA,
                        C_HubisyubetusyousaiKbn.NONE,
                        MessageId.EHA1002 + " " + MessageUtil.getMessage(MessageId.EHA1002,
                            C_UktKbn.getContentByValue(C_UktKbn.PATTERN_SKSIBOUUKT, C_UktKbn.KYK.getValue())),
                            pMP, C_TknKbn.NONE, C_MsgKbn.ERROR);
                    break;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 死亡保険金受取人≠被保険者チェック 終了");
        }
    }
}
