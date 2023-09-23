package yuyu.common.hozen.setuibean;

import javax.inject.Inject;

import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * 契約保全 UiBean設定 取扱注意設定
 */
public class SetToriatukaiTyuui {

    @Inject
    private MessageManager messageManager;

    public SetToriatukaiTyuui() {
        super();
    }

    public boolean exec(KhozenCommonParam pKhCParm, SetToriatukaiTyuuiExecUiBeanParam pUiBean) {

        IT_KykKihon kykKihon = pKhCParm.getKeiyakuKihon(pUiBean.getSyono());

        if (C_UmuKbn.ARI.eq(kykKihon.getTratkityuiumu())) {
            messageManager.addConversationMessageId(
                    KhMessageGroupConstants.GROUP_TORIATUKAITYUUI,
                    BizUtil.getGeneralMessageId(MessageId.KIA0001),
                    kykKihon.getTratkityuiuny());
        }

        return true;
    }

    public void init(SetToriatukaiTyuuiExecUiBeanParam pUiBean) {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_TORIATUKAITYUUI);
    }
}
