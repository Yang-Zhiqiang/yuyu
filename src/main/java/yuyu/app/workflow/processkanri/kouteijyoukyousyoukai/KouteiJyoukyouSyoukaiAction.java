package yuyu.app.workflow.processkanri.kouteijyoukyousyoukai;

import static yuyu.app.workflow.processkanri.kouteijyoukyousyoukai.GenKouteiJyoukyouSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 工程状況照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/workflow/processkanri/kouteijyoukyousyoukai/KouteiJyoukyouSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/workflow/processkanri/kouteijyoukyousyoukai/koutei_jyoukyou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/workflow/processkanri/kouteijyoukyousyoukai/koutei_jyoukyou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/workflow/processkanri/kouteijyoukyousyoukai/koutei_jyoukyou_syoukai.jsp"),
})
@Input("/workflow/processkanri/kouteijyoukyousyoukai/koutei_jyoukyou_syoukai.jsp")
@UIBean(beanClass=KouteiJyoukyouSyoukaiUiBean.class)
@Roles("kouteijyoukyousyoukai")
public class KouteiJyoukyouSyoukaiAction {

    @Inject
    private KouteiJyoukyouSyoukaiBizLogic bizLogic;

    @Begin(renew = true)
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
        String transitionName = bizLogic.syousaiLinkOnClick();
        if (transitionName == null){
            return FORWARDNAME_CURRENT;
        }

        return FORWARDNAME_RESULT;
    }

    public String pagerOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String modoruBtnByResultOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String taskuserInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String resultInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
