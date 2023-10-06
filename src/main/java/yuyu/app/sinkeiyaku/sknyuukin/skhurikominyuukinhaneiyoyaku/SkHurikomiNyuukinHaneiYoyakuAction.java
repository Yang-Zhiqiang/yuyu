package yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku;

import static yuyu.app.sinkeiyaku.sknyuukin.skhurikominyuukinhaneiyoyaku.GenSkHurikomiNyuukinHaneiYoyakuConstants.*;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 振込入金反映予約 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/SkHurikomiNyuukinHaneiYoyaku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/sk_hurikomi_nyuukin_hanei_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/sk_hurikomi_nyuukin_hanei_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/sk_hurikomi_nyuukin_hanei_yoyaku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/sk_hurikomi_nyuukin_hanei_yoyaku.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/skhurikominyuukinhaneiyoyaku/sk_hurikomi_nyuukin_hanei_yoyaku.jsp")
@UIBean(beanClass=SkHurikomiNyuukinHaneiYoyakuUiBean.class)
public class SkHurikomiNyuukinHaneiYoyakuAction {

    @Inject
    private SkHurikomiNyuukinHaneiYoyakuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {

        bizLogic.pushTourokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();

        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public void callAjaxCommon() throws IOException {
        bizLogic.callAjaxCommonBL();
    }
}
