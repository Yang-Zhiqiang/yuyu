package yuyu.app.biz.bztyouhyou.bztyouhyoukobetu;

import static yuyu.app.biz.bztyouhyou.bztyouhyoukobetu.GenBzTyouhyouKobetuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 帳票個別出力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,         page=PAGENO_INIT,         path="/biz/bztyouhyou/bztyouhyoukobetu/BzTyouhyouKobetu.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                path="/biz/bztyouhyou/bztyouhyoukobetu/bz_tyouhyou_kobetu.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY,     page=PAGENO_INPUTKEY,     path="/biz/bztyouhyou/bztyouhyoukobetu/bz_tyouhyou_kobetu.jsp"),
    @Forward(name=FORWARDNAME_SEARCHRESULT, page=PAGENO_SEARCHRESULT, path="/biz/bztyouhyou/bztyouhyoukobetu/bz_tyouhyou_kobetu.jsp"),
    @Forward(name=FORWARDNAME_EXERROR,      page=PAGENO_EXERROR,      path="/biz/bztyouhyou/bztyouhyoukobetu/bz_tyouhyou_kobetu.jsp"),
})
@Input("/biz/bztyouhyou/bztyouhyoukobetu/bz_tyouhyou_kobetu.jsp")
@UIBean(beanClass=BzTyouhyouKobetuUiBean.class)
@Roles("bztyouhyoukobetu")
public class BzTyouhyouKobetuAction {

    @Inject
    private BzTyouhyouKobetuBizLogic bizLogic;

    @Begin
    public String init() {

        String effSeniPath = bizLogic.init();
        return effSeniPath;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String tyouhyouSyuturyokuLinkOnClick() {
        bizLogic.pushOutBL();
        return FORWARDNAME_SEARCHRESULT;
    }

    public String searchBtnOnClick() {
        bizLogic.pushKensaku();
        return FORWARDNAME_SEARCHRESULT;
    }

    @End
    public String modorubtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kensakuKekkaItiranListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public void print() {
        bizLogic.print();
    }

}
