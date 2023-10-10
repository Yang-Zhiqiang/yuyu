package yuyu.app.hozen.khansyuu.khnyuukintorikesi;

import static yuyu.app.hozen.khansyuu.khnyuukintorikesi.GenKhNyuukinTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 入金取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/hozen/khansyuu/khnyuukintorikesi/KhNyuukinTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/hozen/khansyuu/khnyuukintorikesi/kh_nyuukin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/hozen/khansyuu/khnyuukintorikesi/kh_nyuukin_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/hozen/khansyuu/khnyuukintorikesi/kh_nyuukin_torikesi.jsp"),
})
@Input("/hozen/khansyuu/khnyuukintorikesi/kh_nyuukin_torikesi.jsp")
@UIBean(beanClass=KhNyuukinTorikesiUiBean.class)
public class KhNyuukinTorikesiAction {

    @Inject
    private KhNyuukinTorikesiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INIT;
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
    public void print () {
        bizLogic.printOut();
    }
}
