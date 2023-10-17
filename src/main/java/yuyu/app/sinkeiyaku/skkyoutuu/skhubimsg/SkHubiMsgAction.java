package yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg;

import static yuyu.app.sinkeiyaku.skkyoutuu.skhubimsg.GenSkHubiMsgConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 不備メッセージ 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,    page=PAGENO_INIT,    path="/sinkeiyaku/skkyoutuu/skhubimsg/SkHubiMsg.do", redirect=true),
    @Forward(name=FORWARDNAME_HUBIMSG, page=PAGENO_HUBIMSG, path="/sinkeiyaku/skkyoutuu/skhubimsg/sk_hubi_msg.jsp"),
})
@Input("/sinkeiyaku/skkyoutuu/skhubimsg/sk_hubi_msg.jsp")
@UIBean(beanClass=SkHubiMsgUiBean.class)
@Roles("skhubimsg")
public class SkHubiMsgAction {

    @Inject
    private SkHubiMsgBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_HUBIMSG;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.removeObj();
        return null;
    }

    public String functionNameOnClick() {

        bizLogic.doOpen();
        return FORWARDNAME_HUBIMSG;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {

        bizLogic.doOpen();
        return FORWARDNAME_HUBIMSG;
    }
}
