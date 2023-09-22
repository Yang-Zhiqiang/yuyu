package yuyu.common.sinkeiyaku.skcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_Channelcd;
/**
 * 新契約 新契約共通 チャネルコード変換
 */
public class ConvertChannelcd {

    public ConvertChannelcd() {
        super();
    }

    public C_Channelcd exec(C_Channelcd pChannelCd, String pOyadrtenCd) {

        C_Channelcd kiteiChkChannelCd = C_Channelcd.TIGIN;

        if ((pChannelCd == null || C_Channelcd.BLNK.eq(pChannelCd)) &&
            BizUtil.isBlank(pOyadrtenCd)) {

        }
        else {

            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);

            getSkChannelInfo.exec(pChannelCd, pOyadrtenCd);

            kiteiChkChannelCd = getSkChannelInfo.getKiteichkchannelcd();

        }

        return kiteiChkChannelCd;
    }

}
