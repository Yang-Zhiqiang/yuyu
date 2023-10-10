package yuyu.app.hozen.khozen.khonlinekensuusyoukai;

import static yuyu.app.hozen.khozen.khonlinekensuusyoukai.GenKhOnlineKensuuSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 契約保全オンライン処理件数照会 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khonlinekensuusyoukai/KhOnlineKensuuSyoukai.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khonlinekensuusyoukai/kh_online_kensuu_syoukai.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE, page = PAGENO_REFERENCE, path = "/hozen/khozen/khonlinekensuusyoukai/kh_online_kensuu_syoukai.jsp"),
})
@Input("/hozen/khozen/khonlinekensuusyoukai/kh_online_kensuu_syoukai.jsp")
@UIBean(beanClass = KhOnlineKensuuSyoukaiUiBean.class)
@Roles("khonlinekensuusyoukai")
public class KhOnlineKensuuSyoukaiAction {

    @Inject
    private KhOnlineKensuuSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        return FORWARDNAME_INIT;
    }
}
