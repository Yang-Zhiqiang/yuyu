package yuyu.app.hozen.khozen.khkeiyakuhenkou;

import static yuyu.app.hozen.khozen.khkeiyakuhenkou.GenKhKeiyakuHenkouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 契約変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khkeiyakuhenkou/KhKeiyakuHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhKeiyakuHenkou", redirect=true),
})
@Input("/hozen/khozen/khkeiyakuhenkou/kh_keiyaku_henkou.jsp")
@UIBean(beanClass=KhKeiyakuHenkouUiBean.class)
@Roles("khkeiyakuhenkou")
public class KhKeiyakuHenkouAction {

    @Inject
    private KhKeiyakuHenkouBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String tojiruBtnOnClick() {
        return null;
    }

    public String hyoujilinkOnClick() {
        return null;
    }

    public String allhyoujibtnOnClick() {
        return null;
    }

    public String syoukainomibtnOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String sainyuuryokubtnOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuninbtnbyjyoubuOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String skssakuseibtnOnClick() {
        return FORWARDNAME_SKSCONFIRM;
    }

    public String nyuuryokubtnOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String syoukaibtnOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String kakuninbtnbykabuOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String kakuteibtnbyconfirmOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenhebtnbyresultOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnbysksconfirmOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String kakuteibtnbysksconfirmOnClick() {
        return FORWARDNAME_SKSRESULT;
    }

    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INPUTKEY;
    }
}
