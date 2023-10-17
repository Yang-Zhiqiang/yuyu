package yuyu.app.hozen.khansyuu.khonlinenyuukin;

import static yuyu.app.hozen.khansyuu.khonlinenyuukin.GenKhOnlineNyuukinConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * オンライン入金処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khonlinenyuukin/KhOnlineNyuukin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khonlinenyuukin/kh_online_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khonlinenyuukin/kh_online_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khonlinenyuukin/kh_online_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khonlinenyuukin/kh_online_nyuukin.jsp"),
})
@Input("/hozen/khansyuu/khonlinenyuukin/kh_online_nyuukin.jsp")
@UIBean(beanClass=KhOnlineNyuukinUiBean.class)
public class KhOnlineNyuukinAction {

    @Inject
    private KhOnlineNyuukinBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String nyuuryokubtnOnClick() {

        bizLogic.pushInput();
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
        bizLogic.pushModoruByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
