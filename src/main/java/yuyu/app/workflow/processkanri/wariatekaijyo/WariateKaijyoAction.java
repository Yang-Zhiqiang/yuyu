package yuyu.app.workflow.processkanri.wariatekaijyo;

import static yuyu.app.workflow.processkanri.wariatekaijyo.GenWariateKaijyoConstants.*;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 担当者割当解除 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/workflow/processkanri/wariatekaijyo/WariateKaijyo.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                            path="/workflow/processkanri/wariatekaijyo/wariate_kaijyo.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/workflow/processkanri/wariatekaijyo/wariate_kaijyo.jsp"),
})
@Input("/workflow/processkanri/wariatekaijyo/wariate_kaijyo.jsp")
@UIBean(beanClass=WariateKaijyoUiBean.class)
@Roles("wariatekaijyo")
public class WariateKaijyoAction {

    @Inject
    private WariateKaijyoBizLogic bizLogic;

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
        bizLogic.searchBtnOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String wariateKaijyoLinkOnClick() {
        bizLogic.wariateKaijyoLinkOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String callAjaxCreateTantoSelect() throws IOException {

        bizLogic.callAjaxCreateTantoSelect();
        return FORWARDNAME_SELECTDATA;
    }


    public String taskserInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    @BizAppTerminate
    private void BizAppTerminate() {
        bizLogic.pushUnlockProcessBL();
    }

}
