package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;


/**
 * {@link CommonSiwakeUtil}のモッククラスです。<br />
 */
public class CommonSiwakeUtilMock extends CommonSiwakeUtil {

    public static Class<?> caller = null;

    private BizCurrency taisyouGkSonotahenreikin = BizCurrency.valueOf(100);

    private BizCurrency taisyouGkSyonendo2kaimeikoup = BizCurrency.valueOf(150);

    private BizCurrency taisyouGkJinendoikoup = BizCurrency.valueOf(200);

    @Override
    public void execPKanjokamokuHantei(
        BizDate pDenYmd,
        BizDate pKykYmd,
        BizCurrency pZennouSeisankin,
        BizDate pRyosyuYmd,
        BizDateYM pJkipjytYm,
        BizCurrency pMkkp,
        BizDateYM pMikeikapjyutouYm,
        MiKeikaPBean[] pMiKeikaPBeans,
        String pKinouId,
        C_SyoriKbn pSyoriKbn,
        C_Hrkkaisuu pHrkkaisuu,
        C_TkiktbrisyuruiKbn pTikiktbrisyuruikbn) {
        taisyouGkSonotahenreikin = BizCurrency.valueOf(2000);
    }

    @Override
    public List<BzSiwakeMeisaiBean> execTaisyakuTyousei(C_Tuukasyu pTuukasyu, List<BzSiwakeMeisaiBean> pBzSiwakeMeisaiBeanLst) {
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<BzSiwakeMeisaiBean>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = new BzSiwakeMeisaiBean();


        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean);

        return pBzSiwakeMeisaiBeanLst;
    }

    @Override
    public BizCurrency getTaisyouGkSonotahenreikin() {
        return taisyouGkSonotahenreikin;
    }

    @Override
    public BizCurrency getTaisyouGkSyonendo2kaimeikoup() {
        return taisyouGkSyonendo2kaimeikoup;
    }

    @Override
    public BizCurrency getTaisyouGkJinendoikoup() {
        return taisyouGkJinendoikoup;
    }
}
