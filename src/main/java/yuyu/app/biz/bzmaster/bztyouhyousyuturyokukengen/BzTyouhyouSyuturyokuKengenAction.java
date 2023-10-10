package yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen;

import static yuyu.app.biz.bzmaster.bztyouhyousyuturyokukengen.GenBzTyouhyouSyuturyokuKengenConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 帳票出力権限登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/biz/bzmaster/bztyouhyousyuturyokukengen/BzTyouhyouSyuturyokuKengen.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/biz/bzmaster/bztyouhyousyuturyokukengen/bz_tyouhyou_syuturyoku_kengen.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/biz/bzmaster/bztyouhyousyuturyokukengen/bz_tyouhyou_syuturyoku_kengen.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/biz/bzmaster/bztyouhyousyuturyokukengen/bz_tyouhyou_syuturyoku_kengen.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/biz/bzmaster/bztyouhyousyuturyokukengen/bz_tyouhyou_syuturyoku_kengen.jsp"),
})
@Input("/biz/bzmaster/bztyouhyousyuturyokukengen/bz_tyouhyou_syuturyoku_kengen.jsp")
@UIBean(beanClass=BzTyouhyouSyuturyokuKengenUiBean.class)
@Roles("bztyouhyousyuturyokukengen")
public class BzTyouhyouSyuturyokuKengenAction {

    @Inject
    private BzTyouhyouSyuturyokuKengenBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        bizLogic.getSubSystemId();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String kousinBtnOnClick() {

        bizLogic.checkRelation();
        bizLogic.pushUpdBL();
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
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
