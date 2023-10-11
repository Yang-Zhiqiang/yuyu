package yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke;

import static yuyu.app.hozen.khansyuu.khrinjiuriageseikyuuuketuke.GenKhRinjiUriageSeikyuuUketukeConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 臨時売上請求受付 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khrinjiuriageseikyuuuketuke/KhRinjiUriageSeikyuuUketuke.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khrinjiuriageseikyuuuketuke/kh_rinji_uriage_seikyuu_uketuke.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khrinjiuriageseikyuuuketuke/kh_rinji_uriage_seikyuu_uketuke.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khrinjiuriageseikyuuuketuke/kh_rinji_uriage_seikyuu_uketuke.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khrinjiuriageseikyuuuketuke/kh_rinji_uriage_seikyuu_uketuke.jsp"),
})
@Input("/hozen/khansyuu/khrinjiuriageseikyuuuketuke/kh_rinji_uriage_seikyuu_uketuke.jsp")
@UIBean(beanClass=KhRinjiUriageSeikyuuUketukeUiBean.class)
public class KhRinjiUriageSeikyuuUketukeAction {

    @Inject
    private KhRinjiUriageSeikyuuUketukeBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String nyuuryokubtnOnClick() {
        bizLogic.puhsNyuuryokuBL();
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

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
