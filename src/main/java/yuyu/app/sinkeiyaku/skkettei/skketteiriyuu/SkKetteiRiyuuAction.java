package yuyu.app.sinkeiyaku.skkettei.skketteiriyuu;

import static yuyu.app.sinkeiyaku.skkettei.skketteiriyuu.GenSkKetteiRiyuuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 決定理由一覧 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,              page=PAGENO_INIT,              path="/sinkeiyaku/skkettei/skketteiriyuu/SkKetteiRiyuu.do", redirect=true),
    @Forward(name=FORWARDNAME_KETTEIRIYUUITIRAN, page=PAGENO_KETTEIRIYUUITIRAN, path="/sinkeiyaku/skkettei/skketteiriyuu/sk_kettei_riyuu.jsp"),
})
@Input("/sinkeiyaku/skkettei/skketteiriyuu/sk_kettei_riyuu.jsp")
@UIBean(beanClass=SkKetteiRiyuuUiBean.class)
@Roles("skketteiriyuu")
public class SkKetteiRiyuuAction {

    @Inject
    private SkKetteiRiyuuBizLogic bizLogic;

    @Begin(renew = true)
    public String init() {

        bizLogic.init();
        return FORWARDNAME_KETTEIRIYUUITIRAN;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }
}
