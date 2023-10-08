package yuyu.app.hozen.khansyuu.khnyuukinsyoukai;

import static yuyu.app.hozen.khansyuu.khnyuukinsyoukai.GenKhNyuukinSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 入金照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khnyuukinsyoukai/KhNyuukinSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khnyuukinsyoukai/kh_nyuukin_syoukai.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khnyuukinsyoukai/kh_nyuukin_syoukai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khnyuukinsyoukai/kh_nyuukin_syoukai.jsp"),
})
@Input("/hozen/khansyuu/khnyuukinsyoukai/kh_nyuukin_syoukai.jsp")
@UIBean(beanClass=KhNyuukinSyoukaiUiBean.class)
public class KhNyuukinSyoukaiAction {

    @Inject
    private KhNyuukinSyoukaiBizLogic bizLogic;

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
        bizLogic.nyuuryokuBtnSyori();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String syoukaibtnOnClick() {
        bizLogic.syoukaiBtnSyori();

        return FORWARDNAME_RESULT;
    }

    public String modorubtnbysyoukaiOnClick() {
        bizLogic.pushModorubtnbysyoukaiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }
}
