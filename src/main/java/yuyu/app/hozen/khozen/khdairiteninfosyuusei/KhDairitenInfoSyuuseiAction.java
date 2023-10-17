package yuyu.app.hozen.khozen.khdairiteninfosyuusei;

import static yuyu.app.hozen.khozen.khdairiteninfosyuusei.GenKhDairitenInfoSyuuseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 代理店情報修正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,               page=PAGENO_INIT,               path="/hozen/khozen/khdairiteninfosyuusei/KhDairitenInfoSyuusei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,           page=PAGENO_INPUTKEY,           path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,      page=PAGENO_INPUTCONTENTS,      path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,            page=PAGENO_CONFIRM,            path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,             page=PAGENO_RESULT,             path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_CIFCDINPUTCONTENTS, page=PAGENO_CIFCDINPUTCONTENTS, path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_CIFCDCONFIRM,       page=PAGENO_CIFCDCONFIRM,       path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
    @Forward(name=FORWARDNAME_CIFCDRESULT,        page=PAGENO_CIFCDRESULT,        path="/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp"),
})
@Input("/hozen/khozen/khdairiteninfosyuusei/kh_dairiten_info_syuusei.jsp")
@UIBean(beanClass=KhDairitenInfoSyuuseiUiBean.class)
public class KhDairitenInfoSyuuseiAction {

    @Inject
    private KhDairitenInfoSyuuseiBizLogic bizLogic;

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
        return bizLogic.pushNyuuryokuBL();
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String henkouBtnOnClick() {
        return bizLogic.pushUpdBL();
    }

    public String modoruBtnByConfirmOnClick() {
        return bizLogic.pushmodoruBL();
    }

    @End
    public String kakuteiBtnOnClick() {
        return bizLogic.pushKakuteiBL();
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }

}
