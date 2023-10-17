package yuyu.app.hozen.khozen.khnaiyoukakunin;

import static yuyu.app.hozen.khozen.khnaiyoukakunin.KhNaiyouKakuninConstants.*;

import javax.inject.Inject;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 契約保全内容確認 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khnaiyoukakunin/KhNaiyouKakunin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,    path="/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhNaiyouKakunin", redirect=true),
})
@Input("/hozen/khozen/khnaiyoukakunin/kh_naiyou_kakunin.jsp")
@UIBean(beanClass=KhNaiyouKakuninUiBean.class)
@Roles("khnaiyoukakunin")
public class KhNaiyouKakuninAction {

    @Inject
    private KhNaiyouKakuninBizLogic bizLogic;

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

    public String nyuuryokuLinkOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String hyoujilinkOnClick() {
        return null;
    }

    public String allhyoujibtnOnClick() {
        return null;
    }

    public String kakuteibtnbyinputkeyOnClick() {
        return null;
    }

    public String modorubtnbyitiransentakuOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuteibtnbyconfirmOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String kakuteibtnbyworkflowOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
