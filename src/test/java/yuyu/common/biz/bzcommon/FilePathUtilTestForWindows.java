package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link FilePathUtil}クラスのテストです。（Windows用）
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class FilePathUtilTestForWindows {
    @Test
    @TestOrder(10)
    public void testGetBatchInDataPathA1(){
        String result = FilePathUtil.getBatchInDataPath();
        exStringEquals(result, "D:\\develop\\reps\\bazaar\\yuyuseiho-s\\temp\\product\\sources\\application/work/batch_in", "比較結果");
    }


    @Test
    @TestOrder(20)
    public void testGetBatchOutDataPathA1(){
        String result = FilePathUtil.getBatchOutDataPath();
        exStringEquals(result, "D:\\develop\\reps\\bazaar\\yuyuseiho-s\\temp\\product\\sources\\application/work/batch_out", "比較結果");
    }

}
