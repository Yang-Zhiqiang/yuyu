package yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku;

import static yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku.GenSkMosQRSksYoyakuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 申込書類用QR作成予約 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/skmousikomi/skmosqrsksyoyaku/SkMosQRSksYoyaku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skmousikomi/skmosqrsksyoyaku/sk_mos_q_r_sks_yoyaku.jsp"),
})
@Input("/sinkeiyaku/skmousikomi/skmosqrsksyoyaku/sk_mos_q_r_sks_yoyaku.jsp")
@UIBean(beanClass=SkMosQRSksYoyakuUiBean.class)
@Roles("skmosqrsksyoyaku")
public class SkMosQRSksYoyakuAction {

    @Inject
    private SkMosQRSksYoyakuBizLogic bizLogic;

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
}
