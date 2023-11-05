package yuyu.common.biz.kengen;

import yuyu.app.biz.bizwebservice.bzkeiyakunaiyousyoukaiwebservice.BzKeiyakunaiyouSyoukaiWebServiceTest_exec;
import yuyu.def.classification.C_KengenHntiKbn;

/**
 * {@link BzSyanaiWebServiceKengenHantei}のモッククラスです。<br />
 */
public class BzSyanaiWebServiceKengenHanteiMockForBiz extends BzSyanaiWebServiceKengenHantei{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public C_KengenHntiKbn exec(String pOperatorId, String pOrgCode, String pKinouid) {

        if (caller == BzKeiyakunaiyouSyoukaiWebServiceTest_exec.class) {
            if (TESTPATTERN1.equals(SYORIPTN)){
                return C_KengenHntiKbn.TANMATUERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)){
                return C_KengenHntiKbn.SIYOSYAERROR;
            }
            else if (TESTPATTERN3.equals(SYORIPTN)){
                return C_KengenHntiKbn.OK;
            }
        }

        return super.exec(pOperatorId, pOrgCode, pKinouid);
    }
}