package yuyu.common.biz.bzcommon;

import java.util.List;

import javax.transaction.Transactional;

import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_execForBatch;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_1;
import yuyu.common.sinkeiyaku.koutei.SkProcessUpdateTest_exec_2;


/**
 * {@link BzProcessUpdateForBatchMock}のモッククラスです。<br />
 */
public class BzProcessUpdateForBatchMock extends BzProcessUpdateForBatch {

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    @Transactional
    public BzProcessUpdateForBatchOutputBean exec(List<BzProcessUpdateForBatchInputBean> pBzProcessUpdateForBatchInputBeanLst) {
        BzProcessUpdateForBatchOutputBean bzProcessUpdateForBatchOutputBean = new BzProcessUpdateForBatchOutputBean();
        if (caller == SkProcessUpdateTest_execForBatch.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzProcessUpdateForBatchOutputBean.setKekkaStatus("1");
                bzProcessUpdateForBatchOutputBean.setSyousaiMsgCd("IWF9999");
                bzProcessUpdateForBatchOutputBean.setSyousaiMsg("異常終了");
                bzProcessUpdateForBatchOutputBean.setErrKouteiKanriId("1113");
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                bzProcessUpdateForBatchOutputBean.setKekkaStatus("0");
            }

            return bzProcessUpdateForBatchOutputBean;

        }
        else if (caller == SkProcessUpdateTest_exec_1.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzProcessUpdateForBatchOutputBean.setKekkaStatus("0");
            }

            return bzProcessUpdateForBatchOutputBean;
        }
        else if (caller == SkProcessUpdateTest_exec_2.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                bzProcessUpdateForBatchOutputBean.setKekkaStatus("0");
            }

            return bzProcessUpdateForBatchOutputBean;
        }

        return super.exec(pBzProcessUpdateForBatchInputBeanLst);

    }
}