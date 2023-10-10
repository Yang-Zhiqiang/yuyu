package yuyu.app.direct.dssyoukai.dssousarirekisyoukai;

import static yuyu.app.direct.dssyoukai.dssousarirekisyoukai.GenDsSousaRirekiSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 操作履歴照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,           path="/direct/dssyoukai/dssousarirekisyoukai/DsSousaRirekiSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                    path="/direct/dssyoukai/dssousarirekisyoukai/ds_sousa_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_TAISYOUSENTAKU, page=PAGENO_TAISYOUSENTAKU, path="/direct/dssyoukai/dssousarirekisyoukai/ds_sousa_rireki_syoukai.jsp"),
})
@Input("/direct/dssyoukai/dssousarirekisyoukai/ds_sousa_rireki_syoukai.jsp")
@UIBean(beanClass=DsSousaRirekiSyoukaiUiBean.class)
public class DsSousaRirekiSyoukaiAction {

    @Inject
    private DsSousaRirekiSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_TAISYOUSENTAKU;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchbtnbyinputkeyselectOnClick() {
        bizLogic.pushSearchBtnBL();
        return FORWARDNAME_TAISYOUSENTAKU;
    }

    public String clearbtnbyinputkeyselectOnClick() {
        bizLogic.pushClearBtnBL();
        return FORWARDNAME_TAISYOUSENTAKU;
    }

    public String syousaiLinkOnClick() {
        bizLogic.pushSyoukaiLinkBL();
        return FORWARDNAME_TAISYOUSENTAKU;
    }

    public String kensakukekkaPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
