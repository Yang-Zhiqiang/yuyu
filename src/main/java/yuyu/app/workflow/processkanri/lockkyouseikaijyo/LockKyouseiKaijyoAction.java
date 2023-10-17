package yuyu.app.workflow.processkanri.lockkyouseikaijyo;

import static yuyu.app.workflow.processkanri.lockkyouseikaijyo.GenLockKyouseiKaijyoConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 工程ロック強制解除 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/workflow/processkanri/lockkyouseikaijyo/LockKyouseiKaijyo.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                            path="/workflow/processkanri/lockkyouseikaijyo/lock_kyousei_kaijyo.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/workflow/processkanri/lockkyouseikaijyo/lock_kyousei_kaijyo.jsp"),
})
@Input("/workflow/processkanri/lockkyouseikaijyo/lock_kyousei_kaijyo.jsp")
@UIBean(beanClass=LockKyouseiKaijyoUiBean.class)
@Roles("lockkyouseikaijyo")
public class LockKyouseiKaijyoAction {

    @Inject
    private LockKyouseiKaijyoBizLogic bizLogic;

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
        bizLogic.processSearch();
        return FORWARDNAME_SELECTDATA;
    }

    public String lockKaijyoLinkOnClick() {
        bizLogic.forceUnlock();
        return FORWARDNAME_SELECTDATA;
    }

    public String lockedTaskInfoListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
