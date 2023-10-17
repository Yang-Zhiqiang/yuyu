package yuyu.app.workflow.processkanri.kouteikaisitouroku;

import static yuyu.app.workflow.processkanri.kouteikaisitouroku.GenKouteiKaisiTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 工程開始登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/workflow/processkanri/kouteikaisitouroku/KouteiKaisiTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/workflow/processkanri/kouteikaisitouroku/koutei_kaisi_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/workflow/processkanri/kouteikaisitouroku/koutei_kaisi_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/workflow/processkanri/kouteikaisitouroku/koutei_kaisi_touroku.jsp"),
})
@Input("/workflow/processkanri/kouteikaisitouroku/koutei_kaisi_touroku.jsp")
@UIBean(beanClass=KouteiKaisiTourokuUiBean.class)
@Roles("kouteikaisitouroku")
public class KouteiKaisiTourokuAction {

    @Inject
    private KouteiKaisiTourokuBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String kakuninBtnOnClick() {
        bizLogic.kakuninBtnOnClick();
        return FORWARDNAME_CONFIRM;
    }

    public String kakuteiBtnOnClick() {
        bizLogic.kakuteiBtnOnClick();
        return FORWARDNAME_RESULT;
    }

    public String modorubtnOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
