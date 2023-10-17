package yuyu.app.workflow.processkanri.syorikensuusyoukai;

import static yuyu.app.workflow.processkanri.syorikensuusyoukai.GenSyoriKensuuSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 処理件数照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/workflow/processkanri/syorikensuusyoukai/SyoriKensuuSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/workflow/processkanri/syorikensuusyoukai/syori_kensuu_syoukai.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/workflow/processkanri/syorikensuusyoukai/syori_kensuu_syoukai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/workflow/processkanri/syorikensuusyoukai/syori_kensuu_syoukai.jsp"),
})
@Input("/workflow/processkanri/syorikensuusyoukai/syori_kensuu_syoukai.jsp")
@UIBean(beanClass=SyoriKensuuSyoukaiUiBean.class)
@Roles("syorikensuusyoukai")
public class SyoriKensuuSyoukaiAction {

    @Inject
    private SyoriKensuuSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.searchBtnOnClick();
        return FORWARDNAME_INPUTKEY;
    }

    public String syousaiLinkOnClick() {
        bizLogic.syousaiLinkOnClick();
        return FORWARDNAME_CONFIRM;
    }

    public String syousaiLinkTaskOnClick() {
        bizLogic.syousaiLinkTaskOnClick();
        return FORWARDNAME_RESULT;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String modorubtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }
}
