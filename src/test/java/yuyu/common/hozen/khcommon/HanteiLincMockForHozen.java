package yuyu.common.hozen.khcommon;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;

/**
 * ＬＩＮＣ該当判定{@link HanteiLinc}のモッククラスです。<br />
 */
public class HanteiLincMockForHozen extends HanteiLinc {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private IT_KykKihon kykkihon;

    @Override
    public IT_KykKihon getKykkihon() {

        return kykkihon;
    }

    @Override
    public C_ErrorKbn exec(HanteiLincBean pHanteiLincBean, KhozenCommonParam pKhozenCommonParam) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {

                return C_ErrorKbn.ERROR;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {

                IT_KhLincSousinData khLincSousinData = pHanteiLincBean.getKykKihon().createKhLincSousinData();
                khLincSousinData.setSyoriYmd(pHanteiLincBean.getSyoriYmd());
                khLincSousinData.setRenno(1);

                BizPropertyInitializer.initialize(khLincSousinData);

                return C_ErrorKbn.OK;
            }
        }

        return super.exec(pHanteiLincBean, pKhozenCommonParam);
    }
}