package yuyu.app.sinkeiyaku.sksonota.sktoujituseiritutorikesi;

import static yuyu.app.sinkeiyaku.sksonota.sktoujituseiritutorikesi.GenSkToujituSeirituTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.sinkeiyaku.skcommon.SkMessageGroupConstants;

/**
 * 当日成立取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/sksonota/sktoujituseiritutorikesi/SkToujituSeirituTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/sksonota/sktoujituseiritutorikesi/sk_toujitu_seiritu_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/sinkeiyaku/sksonota/sktoujituseiritutorikesi/sk_toujitu_seiritu_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/sinkeiyaku/sksonota/sktoujituseiritutorikesi/sk_toujitu_seiritu_torikesi.jsp"),
})
@Input("/sinkeiyaku/sksonota/sktoujituseiritutorikesi/sk_toujitu_seiritu_torikesi.jsp")
@UIBean(beanClass=SkToujituSeirituTorikesiUiBean.class)
public class SkToujituSeirituTorikesiAction {

    @Inject
    private SkToujituSeirituTorikesiBizLogic bizLogic;

    @Inject
    private MessageManager messageManager;

    public String init() {

        bizLogic.init();

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.unlockProcessBL();

        return null;
    }

    @Begin
    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modorubtnOnClick() {

        bizLogic.unlockProcessBL();

        messageManager.removeConversationMessage(SkMessageGroupConstants.GROUP_WARNING);

        return FORWARDNAME_INIT;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.continueLockProcessBL();

        bizLogic.pushKakuteiBL();

        bizLogic.unlockProcessBL();

        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        bizLogic.unlockProcessBL();

        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable pException) {

        bizLogic.unlockProcessBL();
    }
}
