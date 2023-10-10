package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import static yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.GenSiTtzkRirekiSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 手続履歴照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                                    page=PAGENO_INIT,          path="/siharai/sisyoukai/sittzkrirekisyoukai/SiTtzkRirekiSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                                            path="/siharai/sisyoukai/sittzkrirekisyoukai/si_ttzk_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY,                                page=PAGENO_INPUTKEY,      path="/siharai/sisyoukai/sittzkrirekisyoukai/si_ttzk_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,                              page=PAGENO_SELECTDATA,    path="/siharai/sisyoukai/sittzkrirekisyoukai/si_ttzk_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SELECTTTZKRRK,                           page=PAGENO_SELECTTTZKRRK, path="/siharai/sisyoukai/sittzkrirekisyoukai/si_ttzk_rireki_syoukai.jsp"),
    @Forward(name=FORWARDNAME_GOTOSIBOUKARIUKETUKEKAKUNNINGAMEN,                                  path="/siharai/simouside/sisiboukariuketuke/SiSibouKariUketuke.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSIMOUSIDEUKETUKEKAKUNNINGAMEN,                                  path="/siharai/simouside/simousideuketuke/SiMousideUketuke.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSEIKYUUUKETUKESBKAKUNNINGAMEN,                                  path="/siharai/siskuke/siseikyuuuketukesb/SiSeikyuuUketukeSb.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISATEISBKAKUNNINGAMEN,                                         path="/siharai/sisatei/sisateisb/SiSateiSb.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISINDANSYORYOUSIHARAIKAKUNNINGAMEN,                            path="/siharai/sisatei/sisindansyoryousiharai/SiSindansyoryouSiharai.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
    @Forward(name=FORWARDNAME_GOTOSISYOUNINTORIKESIKAKUNNINGAMEN,                                 path="/siharai/sisatei/sisyounintorikesi/SiSyouninTorikesi.do?_eventHandler=fromSiTtzkRirekiSyoukai", redirect=true),
})
@Input("/siharai/sisyoukai/sittzkrirekisyoukai/si_ttzk_rireki_syoukai.jsp")
@UIBean(beanClass=SiTtzkRirekiSyoukaiUiBean.class)
@Roles("sittzkrirekisyoukai")
public class SiTtzkRirekiSyoukaiAction {

    @Inject
    private SiTtzkRirekiSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String dispsyonoOnClick() {
        bizLogic.pushSyoukenLink();
        return FORWARDNAME_SELECTTTZKRRK;
    }

    public String syousaiLinkOnClick() {
        return bizLogic.pushSyousaiBL();
    }

    public String searchBtnOnClick() {
        bizLogic.pushSearchBL();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String modorubtnbykensakuOnClick() {
        return FORWARDNAME_INIT;
    }

    public String modorubtnbyttdkrrklistOnClick() {
        return FORWARDNAME_SELECTDATA;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String ttzkRrkListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
