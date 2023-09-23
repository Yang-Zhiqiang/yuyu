package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SasimodosisakiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 契約保全 契約保全共通 契約保全工程結果入力チェック
 */
public class CheckProcessKekka {

    @Inject
    private static Logger logger;

    private static final String MESSAGE_RESULT = "結果";

    private static final String MESSAGE_SASIMODOSISAKI = "差戻し先";

    public CheckProcessKekka() {
        super();
    }

    public boolean exec(C_SyorikekkaKbn pSyorikekkakbn, String pComment, C_SasimodosisakiKbn pSasimodosisakikbn) {

        logger.debug("▽ 契約保全工程結果入力チェック 開始");

        if (C_SyorikekkaKbn.BLNK.eq(pSyorikekkakbn)) {
            throw new BizLogicException(MessageId.EBF1005, MESSAGE_RESULT);
        }

        if ((C_SyorikekkaKbn.TORIKESI.eq(pSyorikekkakbn) || C_SyorikekkaKbn.SASIMODOSI.eq(pSyorikekkakbn)) &&
            BizUtil.isBlank(pComment)) {
            throw new BizLogicException(MessageId.EIA1003, C_SyorikekkaKbn.getContentByValue(pSyorikekkakbn.getValue()));
        }

        if (C_SyorikekkaKbn.HUSYOUNIN.eq(pSyorikekkakbn)) {
            if (BizUtil.isBlank(pComment)) {
                throw new BizLogicException(MessageId.EIA1003, C_SyorikekkaKbn.getContentByValue(pSyorikekkakbn.getValue()));
            }

            if (C_SasimodosisakiKbn.BLNK.eq(pSasimodosisakikbn)) {
                throw new BizLogicException(MessageId.EBF1005, MESSAGE_SASIMODOSISAKI);
            }
        } else {
            if (!C_SasimodosisakiKbn.BLNK.eq(pSasimodosisakikbn)) {
                throw new BizLogicException(MessageId.EIA1004);
            }
        }
        if (C_SyorikekkaKbn.HUBI.eq(pSyorikekkakbn) && BizUtil.isBlank(pComment)) {
            throw new BizLogicException(MessageId.EIA1003, C_SyorikekkaKbn.getContentByValue(pSyorikekkakbn.getValue()));
        }

        logger.debug("△ 契約保全工程結果入力チェック 終了");

        return true;
    }
}
