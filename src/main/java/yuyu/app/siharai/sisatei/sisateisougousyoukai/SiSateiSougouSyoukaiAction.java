package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import static yuyu.app.siharai.sisatei.sisateisougousyoukai.SiSateiSougouSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 査定総合照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sisatei/sisateisougousyoukai/SiSateiSougouSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_SKINFO1,       page=PAGENO_SKINFO1,       path="/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SKINFO2,       page=PAGENO_SKINFO2,       path="/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_KEIYAKUINFO,   page=PAGENO_KEIYAKUINFO,   path="/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_NAYOSEINFO,    page=PAGENO_NAYOSEINFO,    path="/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp"),
    @Forward(name=FORWARDNAME_TTDKTYUUIINFO, page=PAGENO_TTDKTYUUIINFO, path="/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp"),
})
@Input("/siharai/sisatei/sisateisougousyoukai/si_satei_sougou_syoukai.jsp")
@UIBean(beanClass=SiSateiSougouSyoukaiUiBean.class)
public class SiSateiSougouSyoukaiAction {

    @Inject
    private SiSateiSougouSyoukaiBizLogic bizLogic;

    public String init() {

        return FORWARDNAME_SKINFO1;
    }

    @Begin(renew=true, mode = Mode.A)
    public String syoukaibtnOnClick(){
        bizLogic.nkronriChkAndjyouhoSyutoku();
        return FORWARDNAME_SKINFO1;
    }

    @Begin(renew=true, mode = Mode.A)
    public String syoukaibtnhihyoujiOnClick(){
        bizLogic.nkronriChkAndjyouhoSyutokuAndImage();
        return FORWARDNAME_SKINFO1;
    }

    @Begin(renew=true, mode = Mode.A)
    public String fromSiSeikyuuUketukeSb() {
        bizLogic.requestToUiBean();
        bizLogic.nkronriChkAndjyouhoSyutoku();
        return FORWARDNAME_SKINFO1;
    }

    @End(mode = Mode.A)
    public String tojiruBtnOnClick() {
        return null;
    }

    public String kouteijkbtnOnClick() {
        return null;
    }

    public String siharairirekisyoukaibtnOnClick() {
        return null;
    }

    public String imagesyoukaibtnOnClick() {
        return null;
    }

    public String mosjksyoukaibtnOnClick() {
        return null;
    }

    public String kyknaiyousyoukaibtnOnClick() {
        return null;
    }

    public String skinfo2btnbysk1OnClick() {
        return FORWARDNAME_SKINFO2;
    }

    public String kykinfobtnbysk1OnClick() {
        return FORWARDNAME_KEIYAKUINFO;
    }

    public String nayoseinfobtnbysk1OnClick() {
        return FORWARDNAME_NAYOSEINFO;
    }

    public String ttdktyuuiinfobtnbysk1OnClick() {
        return FORWARDNAME_TTDKTYUUIINFO;
    }

    public String skinfo1btnbysk2OnClick() {
        return FORWARDNAME_SKINFO1;
    }

    public String kykinfobtnbysk2OnClick() {
        return FORWARDNAME_KEIYAKUINFO;
    }

    public String nayoseinfobtnbysk2OnClick() {
        return FORWARDNAME_NAYOSEINFO;
    }

    public String ttdktyuuiinfobtnbysk2OnClick() {
        return FORWARDNAME_TTDKTYUUIINFO;
    }

    public String skinfo1btnbykykOnClick() {
        return FORWARDNAME_SKINFO1;
    }

    public String skinfo2btnbykykOnClick() {
        return FORWARDNAME_SKINFO2;
    }

    public String nayoseinfobtnbykykOnClick() {
        return FORWARDNAME_NAYOSEINFO;
    }

    public String ttdktyuuiinfobtnbykykOnClick() {
        return FORWARDNAME_TTDKTYUUIINFO;
    }

    public String skinfo1btnbynayoseOnClick() {
        return FORWARDNAME_SKINFO1;
    }

    public String skinfo2btnbynayoseOnClick() {
        return FORWARDNAME_SKINFO2;
    }

    public String kykinfobtnbynayoseOnClick() {
        return FORWARDNAME_KEIYAKUINFO;
    }

    public String ttdktyuuiinfobtnbynayoseOnClick() {
        return FORWARDNAME_TTDKTYUUIINFO;
    }

    public String skinfo1btnbyttdkOnClick() {
        return FORWARDNAME_SKINFO1;
    }

    public String skinfo2btnbyttdkOnClick() {
        return FORWARDNAME_SKINFO2;
    }

    public String kykinfobtnbyttdkOnClick() {
        return FORWARDNAME_KEIYAKUINFO;
    }

    public String nayoseinfobtnbyttdkOnClick() {
        return FORWARDNAME_NAYOSEINFO;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }
}
