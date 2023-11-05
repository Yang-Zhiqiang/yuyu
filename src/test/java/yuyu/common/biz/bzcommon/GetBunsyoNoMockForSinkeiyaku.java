package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.date.BizDate;
import yuyu.common.sinkeiyaku.moschk.CheckYakkanJyuryouHouhouTest_exec;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;

/**
 * {@link GetBunsyoNo}のモッククラスです。<br />
 */
public class GetBunsyoNoMockForSinkeiyaku extends GetBunsyoNo{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public GetBunsyoNoOutBean execGetYakkanBunsyoNo(C_AisyoumeiKbn pAisyoumeiKbn, C_Channelcd pChannelcd, String pOyadrtenCd,
        BizDate pMosYmd) {

        if (caller == CheckYakkanJyuryouHouhouTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                GetBunsyoNoOutBean getBunsyoNoOutBean = new GetBunsyoNoOutBean();

                getBunsyoNoOutBean.setYakkanbunsyoNo("100000000001");
                getBunsyoNoOutBean.setSioriNo("111");

                return getBunsyoNoOutBean;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {

                return new GetBunsyoNoOutBean();
            }
        }

        return super.execGetYakkanBunsyoNo(pAisyoumeiKbn, pChannelcd, pOyadrtenCd, pMosYmd);
    }

}
