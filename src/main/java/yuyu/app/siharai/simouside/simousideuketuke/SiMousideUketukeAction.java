package yuyu.app.siharai.simouside.simousideuketuke;

import static yuyu.app.siharai.simouside.simousideuketuke.GenSiMousideUketukeConstants.*;

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
 * 申出受付 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/simouside/simousideuketuke/SiMousideUketuke.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/simouside/simousideuketuke/si_mouside_uketuke.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/simouside/simousideuketuke/si_mouside_uketuke.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/simouside/simousideuketuke/si_mouside_uketuke.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/simouside/simousideuketuke/si_mouside_uketuke.jsp"),
})
@Input("/siharai/simouside/simousideuketuke/si_mouside_uketuke.jsp")
@UIBean(beanClass=SiMousideUketukeUiBean.class)
@Roles("simousideuketuke")
public class SiMousideUketukeAction {

    @Inject
    private SiMousideUketukeBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String ttdkannaisyoukaibtnOnClick() {
        bizLogic.pushTtdkAnnaiSkiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String hokenkinmousidebtnOnClick() {
        bizLogic.pushHknkMosUkeBL();
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
        bizLogic.pushmodoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
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
        bizLogic.printReport();
    }

    @Roles("sittzkrirekisyoukai")
    public String fromSiTtzkRirekiSyoukai() {
        String sForwardName = bizLogic.fromSiTtzkRirekiSyoukaiBL();
        return sForwardName;
    }
}
