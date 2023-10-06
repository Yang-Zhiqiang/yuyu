package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

import static yuyu.app.workflow.imagekanri.torikomihyousisakusei.GenTorikomiHyousiSakuseiConstants.*;

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
 * 取込用表紙作成 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/workflow/imagekanri/torikomihyousisakusei/TorikomiHyousiSakusei.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                    path="/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,     page=PAGENO_SELECTDATA,     path="/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONDITION, page=PAGENO_INPUTCONDITION, path="/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,        path="/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,         path="/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp"),
})
@Input("/workflow/imagekanri/torikomihyousisakusei/torikomi_hyousi_sakusei.jsp")
@UIBean(beanClass=TorikomiHyousiSakuseiUiBean.class)
@Roles("torikomihyousisakusei")
public class TorikomiHyousiSakuseiAction {

    @Inject
    private TorikomiHyousiSakuseiBizLogic bizLogic;

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

        bizLogic.getTorikomiyouHyousiList();
        return FORWARDNAME_SELECTDATA;
    }

    public String sakuseiLinkOnClick() {

        bizLogic.getTrikomiShoruiSelect();
        return FORWARDNAME_INPUTCONDITION;
    }

    public String modoruBtnByInputConditionOnClick() {

        bizLogic.selectMdrBtnClick();
        return FORWARDNAME_SELECTDATA;
    }

    @End(nested=true)
    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONDITION;
    }

    @Begin(nested=true)
    public String kakuninBtnOnClick() {

        bizLogic.setteiKakuninMsg();
        return FORWARDNAME_CONFIRM;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.createTorikomiHyousi();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String jyoukensiteigamenheBtnOnClick() {
        return FORWARDNAME_INPUTCONDITION;
    }

    public String ankenListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    @MultiPostConstraints
    public void print(){
        bizLogic.printReport();
    }

}
