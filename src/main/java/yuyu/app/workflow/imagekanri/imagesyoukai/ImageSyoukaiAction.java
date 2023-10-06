package yuyu.app.workflow.imagekanri.imagesyoukai;

import static yuyu.app.workflow.imagekanri.imagesyoukai.GenImageSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * イメージ照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/workflow/imagekanri/imagesyoukai/ImageSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                            path="/workflow/imagekanri/imagesyoukai/image_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/workflow/imagekanri/imagesyoukai/image_syoukai.jsp"),
})
@Input("/workflow/imagekanri/imagesyoukai/image_syoukai.jsp")
@UIBean(beanClass=ImageSyoukaiUiBean.class)
@Roles("imagesyoukai")
public class ImageSyoukaiAction {

    @Inject
    private ImageSyoukaiBizLogic bizLogic;

    @Begin(renew = true)
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

    public String ankenListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
