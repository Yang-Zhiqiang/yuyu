package yuyu.app.hozen.khozen.khtetudukityuui;

import static yuyu.app.hozen.khozen.khtetudukityuui.GenKhTetudukiTyuuiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 契約保全手続注意設定 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khtetudukityuui/KhTetudukiTyuui.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khtetudukityuui/kh_tetuduki_tyuui.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE, page = PAGENO_REFERENCE, path = "/hozen/khozen/khtetudukityuui/kh_tetuduki_tyuui.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khozen/khtetudukityuui/kh_tetuduki_tyuui.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khozen/khtetudukityuui/kh_tetuduki_tyuui.jsp"),
})
@Input("/hozen/khozen/khtetudukityuui/kh_tetuduki_tyuui.jsp")
@UIBean(beanClass = KhTetudukiTyuuiUiBean.class)
public class KhTetudukiTyuuiAction {

    @Inject
    private KhTetudukiTyuuiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String rtnUrl = bizLogic.pushFunctionNameOnClickBL();

        return rtnUrl;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End
    public String modorubtnbysyoukaiOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBtn();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushmodoruByConfirmBL();
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print() {

        bizLogic.printOut();
    }
}
