package yuyu.app.biz.bzmaster.bzginkoutouroku;

import static yuyu.app.biz.bzmaster.bzginkoutouroku.GenBzGinkouTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 銀行登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/biz/bzmaster/bzginkoutouroku/BzGinkouTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,       path="/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS1, page=PAGENO_INPUTCONTENTS1, path="/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS2, page=PAGENO_INPUTCONTENTS2, path="/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,        path="/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,         path="/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp"),
})
@Input("/biz/bzmaster/bzginkoutouroku/bz_ginkou_touroku.jsp")
@UIBean(beanClass=BzGinkouTourokuUiBean.class)
@Roles("bzginkoutouroku")
public class BzGinkouTourokuAction {

    @Inject
    private BzGinkouTourokuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String tojiruBtnOnClick() {
        return null;
    }

    public String tourokuBtnOnClick() {
        return null;
    }

    public String henkouBtnOnClick() {
        return null;
    }

    public String sakujyoBtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return null;
    }

    public String kakuteiBtnOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
