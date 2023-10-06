package yuyu.app.workflow.imagekanri.imagesakujyo;

import static yuyu.app.workflow.imagekanri.imagesakujyo.ImageSakujyoConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * イメージ削除 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/workflow/imagekanri/imagesakujyo/ImageSakujyo.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                            path="/workflow/imagekanri/imagesakujyo/image_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/workflow/imagekanri/imagesakujyo/image_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,    page=PAGENO_CONFIRM,    path="/workflow/imagekanri/imagesakujyo/image_sakujyo.jsp"),
    @Forward(name=FORWARDNAME_RESULT,     page=PAGENO_RESULT,     path="/workflow/imagekanri/imagesakujyo/image_sakujyo.jsp"),
})
@Input("/workflow/imagekanri/imagesakujyo/image_sakujyo.jsp")
@UIBean(beanClass=ImageSakujyoUiBean.class)
@Roles("imagesakujyo")
public class ImageSakujyoAction {

    @Inject
    private ImageSakujyoBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {

        bizLogic.searchBtnOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String hyoujilinkOnClick() {
        return null;
    }

    public String tyouhyouSyuturyokuLinkOnClick() {

        bizLogic.hyoujilinkOnClick();
        return null;
    }

    public String sakujyoLinkOnClick() {

        bizLogic.sakujyoLinkOnClick();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_SELECTDATA;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.kakuteiBtnOnClick();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String ankenListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
