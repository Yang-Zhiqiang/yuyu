package yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku;

import static yuyu.app.sinkeiyaku.sknyuukin.skhurikomisakujyotouroku.SkHurikomiSakujyoTourokuConstants.*;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 振込入金削除データ登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/SkHurikomiSakujyoTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                  path="/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/sk_hurikomi_sakujyo_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/sk_hurikomi_sakujyo_touroku.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/skhurikomisakujyotouroku/sk_hurikomi_sakujyo_touroku.jsp")
@UIBean(beanClass=SkHurikomiSakujyoTourokuUiBean.class)
@Roles("skhurikomisakujyotouroku")
public class SkHurikomiSakujyoTourokuAction {

    @Inject
    private SkHurikomiSakujyoTourokuBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.kakuteiBtnOnClick();
        return FORWARDNAME_INIT;
    }

    @End
    public String sakujyoLinkOnClick() {
        bizLogic.sakujyoLinkOnClick();
        return FORWARDNAME_INIT;
    }

    public String sakujyoInfoListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public void callAjaxCommon() throws IOException {
        bizLogic.callAjaxCommonBL();
    }
}
