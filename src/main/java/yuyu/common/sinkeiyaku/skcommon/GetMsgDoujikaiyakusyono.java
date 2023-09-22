package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;


/**
 * 新契約 新契約共通 同時解約証券番号ＭＳＧ取得
 */
public class GetMsgDoujikaiyakusyono {

    public static final int KEKKAKBN_NONE = 0;

    public static final int KEKKAKBN_ARI  = 1;

    private String gmMsg = "";

    private String gmMsgId = "";

    public GetMsgDoujikaiyakusyono() {
        super();
    }

    public String getS_gmmsg() {
        return gmMsg;
    }

    public String getS_gmmsgid() {
        return gmMsgId;
    }

    public int exec(C_UmuKbn pMosnrkNmu, String pDoujiKaiyakuSyono) {

        if (C_UmuKbn.ARI.eq(pMosnrkNmu) && !BizUtil.isBlank(pDoujiKaiyakuSyono)) {

            gmMsgId = MessageId.WHC0081;

            gmMsg = MessageUtil.getMessage(gmMsgId, pDoujiKaiyakuSyono);

            return KEKKAKBN_ARI;
        }

        return KEKKAKBN_NONE;
    }

}