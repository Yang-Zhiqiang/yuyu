package yuyu.app.siharai.simakefile.simakeseikyuuinfof;

import static yuyu.app.siharai.simakefile.simakeseikyuuinfof.GenSiMakeSeikyuuInfoFConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 請求情報ファイル作成 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/siharai/simakefile/simakeseikyuuinfof/SiMakeSeikyuuInfoF.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTCONDITIONS, page = PAGENO_INPUTCONDITIONS, path = "/siharai/simakefile/simakeseikyuuinfof/si_make_seikyuu_info_f.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/siharai/simakefile/simakeseikyuuinfof/si_make_seikyuu_info_f.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/siharai/simakefile/simakeseikyuuinfof/si_make_seikyuu_info_f.jsp"),
})
@Input("/siharai/simakefile/simakeseikyuuinfof/si_make_seikyuu_info_f.jsp")
@UIBean(beanClass = SiMakeSeikyuuInfoFUiBean.class)
@Roles("simakeseikyuuinfof")
public class SiMakeSeikyuuInfoFAction {

    @Inject
    private SiMakeSeikyuuInfoFBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTCONDITIONS;
    }

    @End
    public String tojiruBtnOnClick() {

        return null;
    }

    public String kakuninBtnOnClick() {

        String path = bizLogic.kakuninBtnOnClickBL();

        return path;
    }

    public String modorubtnOnClick() {

        String path = bizLogic.modoruBtnOnClickBL();

        return path;
    }

    @End
    public String kakuteiBtnOnClick() {

        String path = bizLogic.kakuteiBtnOnClickBL();

        return path;
    }

    public String syokigamenheBtnOnClick() {

        return FORWARDNAME_INIT;
    }
}
