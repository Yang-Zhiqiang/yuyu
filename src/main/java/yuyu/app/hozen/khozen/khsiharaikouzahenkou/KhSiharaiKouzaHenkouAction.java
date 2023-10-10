package yuyu.app.hozen.khozen.khsiharaikouzahenkou;

import static yuyu.app.hozen.khozen.khsiharaikouzahenkou.KhSiharaiKouzaHenkouConstants.*;

import javax.inject.Inject;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 支払口座情報変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,       path="/hozen/khozen/khsiharaikouzahenkou/KhSiharaiKouzaHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,   path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,  path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,    path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,     path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM, path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,  path="/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                         path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhSiharaiKouzaHenkou", redirect=true),
})
@Input("/hozen/khozen/khsiharaikouzahenkou/kh_siharai_kouza_henkou.jsp")
@UIBean(beanClass=KhSiharaiKouzaHenkouUiBean.class)
@Roles("khsiharaikouzahenkou")
public class KhSiharaiKouzaHenkouAction {

    @Inject
    private KhSiharaiKouzaHenkouBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromHozenWorkList() {
        return init();
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

    public String skssakuseibtnOnClick() {
        return FORWARDNAME_SKSCONFIRM;
    }

    public String syoukaibtnOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_REFERENCE;
    }

    public String kakuteiBtnOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
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
