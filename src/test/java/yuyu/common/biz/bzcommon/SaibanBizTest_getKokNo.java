package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.def.db.id.PKAT_SequenceValue;

/**
 * 採番業務共通{@link SaibanBiz}に含まれる、getKokNo メソッドのテストです。
 */
@RunWith(SWAKTestRunner.class)
public class SaibanBizTest_getKokNo {
    @Inject
    private SaibanBiz saibanBiz;

    @Inject
    ExDBEntityManager manager;

    private String DEFAULT_KEY = "_DEFAULT_";

    @Test
    public void testKokNo() {
        saibanBiz = new SaibanBiz();
        Long result = Long.parseLong(saibanBiz.getKokNo());

        PKAT_SequenceValue pSequenceValue = new PKAT_SequenceValue("1", DEFAULT_KEY);
        AT_SequenceValue sq = manager.findByPK(pSequenceValue);

        exNumericEquals(result, sq.getCurrentValue(), "結果");
    }

}
