package yuyu.app.siharai.sisonota.simakesyorui;

import static yuyu.app.siharai.sisonota.simakesyorui.GenSiMakeSyoruiConstants.*;

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
 * 保険金給付金書類作成 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,        page=PAGENO_INIT,        path="/siharai/sisonota/simakesyorui/SiMakeSyorui.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA,  page=PAGENO_SELECTDATA,  path="/siharai/sisonota/simakesyorui/si_make_syorui.jsp"),
    @Forward(name=FORWARDNAME_INPUTSYORUI, page=PAGENO_INPUTSYORUI, path="/siharai/sisonota/simakesyorui/si_make_syorui.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,     page=PAGENO_CONFIRM,     path="/siharai/sisonota/simakesyorui/si_make_syorui.jsp"),
    @Forward(name=FORWARDNAME_RESULT,      page=PAGENO_RESULT,      path="/siharai/sisonota/simakesyorui/si_make_syorui.jsp"),
})
@Input("/siharai/sisonota/simakesyorui/si_make_syorui.jsp")
@UIBean(beanClass=SiMakeSyoruiUiBean.class)
@Roles("simakesyorui")
public class SiMakeSyoruiAction {

    @Inject
    private SiMakeSyoruiBizLogic bizLogic;

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
        bizLogic.searchBtnBL();
        return FORWARDNAME_SELECTDATA;
    }

    public String syoruisakuseilinkOnClick() {
        bizLogic.syoruisakuseilinkBL();
        return FORWARDNAME_INPUTSYORUI;
    }

    public String modorubtnbyinputsyoruiOnClick() {
        return FORWARDNAME_SELECTDATA;
    }

    @End(nested = true)
    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTSYORUI;
    }

    @Begin(nested = true)
    public String kakuninBtnOnClick() {
        bizLogic.kakuninBtnBL();
        return FORWARDNAME_CONFIRM;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.kakuteiBtnBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syoruisiteigamenhebtnOnClick() {
        bizLogic.syoruisiteigamenhebtnBL();
        return FORWARDNAME_INPUTSYORUI;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print(){
        bizLogic.printReport();
    }
}
