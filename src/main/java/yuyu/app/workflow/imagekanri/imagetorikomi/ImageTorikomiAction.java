package yuyu.app.workflow.imagekanri.imagetorikomi;

import static yuyu.app.workflow.imagekanri.imagetorikomi.GenImageTorikomiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * イメージ取込 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/workflow/imagekanri/imagetorikomi/ImageTorikomi.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                    path="/workflow/imagekanri/imagetorikomi/image_torikomi.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,     path="/workflow/imagekanri/imagetorikomi/image_torikomi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONDITION, page=PAGENO_INPUTCONDITION, path="/workflow/imagekanri/imagetorikomi/image_torikomi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,        path="/workflow/imagekanri/imagetorikomi/image_torikomi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,         path="/workflow/imagekanri/imagetorikomi/image_torikomi.jsp"),
})
@Input("/workflow/imagekanri/imagetorikomi/image_torikomi.jsp")
@UIBean(beanClass=ImageTorikomiUiBean.class)
@Roles("imagetorikomi")
public class ImageTorikomiAction {

    @Inject
    private ImageTorikomiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        return FORWARDNAME_SELECTDATA;
    }

    public String syousaiLinkOnClick() {
        return FORWARDNAME_INPUTCONDITION;
    }


    public String hyoujilinkOnClick() {
        return null;
    }

    public String torikomiLinkOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByInputConditionOnClick() {
        return FORWARDNAME_SELECTDATA;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONDITION;
    }

    public String kakuteiBtnOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String ankenListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
