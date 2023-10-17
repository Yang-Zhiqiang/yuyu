package yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai;

import static yuyu.app.sinkeiyaku.skkyoutuu.sknyuuryokusaisyoukai.GenSkNyuuryokuSaiSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 入力差異照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,               page=PAGENO_INIT,               path="/sinkeiyaku/skkyoutuu/sknyuuryokusaisyoukai/SkNyuuryokuSaiSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_NYURYOKUSAISYOUKAI, page=PAGENO_NYURYOKUSAISYOUKAI, path="/sinkeiyaku/skkyoutuu/sknyuuryokusaisyoukai/sk_nyuuryoku_sai_syoukai.jsp"),
})
@Input("/sinkeiyaku/skkyoutuu/sknyuuryokusaisyoukai/sk_nyuuryoku_sai_syoukai.jsp")
@UIBean(beanClass=SkNyuuryokuSaiSyoukaiUiBean.class)
@Roles("sknyuuryokusaisyoukai")
public class SkNyuuryokuSaiSyoukaiAction {

    @Inject
    private SkNyuuryokuSaiSyoukaiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_NYURYOKUSAISYOUKAI;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.removeObj();
        return null;
    }

    public String functionNameOnClick() {

        bizLogic.doOpen();
        return FORWARDNAME_NYURYOKUSAISYOUKAI;
    }

    @Begin(renew = true)
    public String fromOtherFunctions() {

        bizLogic.doOpen();
        return FORWARDNAME_NYURYOKUSAISYOUKAI;
    }
}
