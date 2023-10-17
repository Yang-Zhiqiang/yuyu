package yuyu.app.hozen.khansyuu.khtokusin;

import static yuyu.app.hozen.khansyuu.khtokusin.GenKhTokusinConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 特伸処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khtokusin/KhTokusin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khtokusin/kh_tokusin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khtokusin/kh_tokusin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khtokusin/kh_tokusin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khtokusin/kh_tokusin.jsp"),
})
@Input("/hozen/khansyuu/khtokusin/kh_tokusin.jsp")
@UIBean(beanClass=KhTokusinUiBean.class)
public class KhTokusinAction {

    @Inject
    private KhTokusinBizLogic bizLogic;

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

        bizLogic.pushInputBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode = Mode.DELETE)
    public String torikesiBtnOnClick() {

        bizLogic.pushTorikesiBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(mode = Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        String path = bizLogic.pushModoruBtnByConfirmBL();
        return path;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }
}
