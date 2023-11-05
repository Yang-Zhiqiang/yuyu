package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 採番業務共通{@link SaibanBiz}に含まれる、getNyukinTRRenban メソッドのテストです。
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getNyukinTRRenban {

	@Inject
    private SaibanBiz saibanBiz;

    @Inject
    ExDBEntityManager manager;

    private final String SHO_NO = "12345";

    @Test
    public void testNyukinTRRenban() {
        //        saibanBiz = new SaibanBiz();
        //        long result = saibanBiz.getNyukinTRRenban(SHO_NO);
        //
        //        PKAT_SequenceValue pSequenceValue = new PKAT_SequenceValue("9", SHO_NO);
        //        AT_SequenceValue sq = manager.findByPK(pSequenceValue);
        //        exNumericEquals(result, sq.getCurrentValue(), "結果");
    }


}
