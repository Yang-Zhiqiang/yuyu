package yuyu.common.siharai.sicommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.common.siharai.renkei.SiGetSyanaiWebKeiyakuInfo;
import yuyu.def.biz.bean.webservice.IwssnSyanaiSiharaiInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;

/**
 * {@link SiGetSyanaiWebKeiyakuInfo}のモッククラスです。<br />
 */
public class SiGetSyanaiWebKeiyakuInfoMockForBiz extends SiGetSyanaiWebKeiyakuInfo{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    private IwssnSyanaiSiharaiInfoOutputBean iwssnSyanaiSiharaiInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiSiharaiInfoOutputBean.class);

    @Override
    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.SONOTAHENSYUU_ERROR;
            }
            else if (TESTPATTERN4.equals(SYORIPTN)){
                return C_IwssnKykSyoukaiKekkaKbn.NORMAL;
            }
        }

        return super.exec(pSyono);
    }

    @Override
    public IwssnSyanaiSiharaiInfoOutputBean getIwssnSyanaiSiharaiInfoOutputBean() {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {

            iwssnSyanaiSiharaiInfoOutputBean.setIwssnSiboushryymd("20221001");

            if (TESTPATTERN4.equals(SYORIPTN)) {
                return null;
            }

            return iwssnSyanaiSiharaiInfoOutputBean;
        }
        return super.getIwssnSyanaiSiharaiInfoOutputBean();
    }

}
