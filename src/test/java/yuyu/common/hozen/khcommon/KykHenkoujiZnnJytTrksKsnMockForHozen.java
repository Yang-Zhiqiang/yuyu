package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;

/**
 * 契約変更時前納充当取消および更新{@link KykHenkoujiZnnJytTrksKsn}のモッククラスです<br />
 */
public class KykHenkoujiZnnJytTrksKsnMockForHozen extends KykHenkoujiZnnJytTrksKsn {
    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    @Override
    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, BizDate pSyoriYmd,
        BizDateYM pZennouseisankgkStartYmd, C_ZennouSeisanSyoriKbn pZennouSeisanSyoriKbn) {

        if (caller == EditKaiyakuTblUpdateTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return;
            }
        }

        super.exec(pKhozenCommonParam, pSyoNo, pSyoriYmd, pZennouseisankgkStartYmd, pZennouSeisanSyoriKbn);
    }
}
