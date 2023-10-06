package yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai;

import static yuyu.app.workflow.processkanri.tantousyabetusyoritasksyoukai.GenTantousyabetuSyoriTaskSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 担当者別処理タスク照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/workflow/processkanri/tantousyabetusyoritasksyoukai/TantousyabetuSyoriTaskSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/workflow/processkanri/tantousyabetusyoritasksyoukai/tantousyabetu_syori_task_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/workflow/processkanri/tantousyabetusyoritasksyoukai/tantousyabetu_syori_task_syoukai.jsp"),
})
@Input("/workflow/processkanri/tantousyabetusyoritasksyoukai/tantousyabetu_syori_task_syoukai.jsp")
@UIBean(beanClass=TantousyabetuSyoriTaskSyoukaiUiBean.class)
@Roles("tantousyabetusyoritasksyoukai")
public class TantousyabetuSyoriTaskSyoukaiAction {

    @Inject
    private TantousyabetuSyoriTaskSyoukaiBizLogic bizLogic;

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

    public String taskserInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
