package yuyu.infr.sequence;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.sequence.RenbanUtil;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AS_Sequence;
import yuyu.def.db.entity.AT_SequenceValue;
import yuyu.testinfr.AbstractTest;

@RunWith(SWAKTestRunner.class)
public class SequenceTest extends AbstractTest {

    @Override
    protected void beforeAllTest() {
        setClearTargets(AS_Sequence.class, AT_SequenceValue.class);
    }

    @Test
    public void test_Case1() {


        long renban = RenbanUtil.getRenban(1, "テスト");
        exNumericEquals(renban, 1L, "連番");

        long[] renbans = RenbanUtil.getRenbans(5, 1, "テスト");
        exNumericEquals(renbans[0], 2L, "連番");
        exNumericEquals(renbans[1], 3L, "連番");
        exNumericEquals(renbans[2], 4L, "連番");
        exNumericEquals(renbans[3], 5L, "連番");
        exNumericEquals(renbans[4], 6L, "連番");
        exNumericEquals(renbans.length, 5L, "連番数");

        long renbanPrefix = RenbanUtil.getRenban(9L, 1, "テスト");
        exNumericEquals(renbanPrefix, 9000000007L, "連番");

        long[] renbansPrefix = RenbanUtil.getRenbans(9L, 5, 1, "テスト");
        exNumericEquals(renbansPrefix[0], 9000000008L, "連番");
        exNumericEquals(renbansPrefix[1], 9000000009L, "連番");
        exNumericEquals(renbansPrefix[2], 9000000010L, "連番");
        exNumericEquals(renbansPrefix[3], 9000000011L, "連番");
        exNumericEquals(renbansPrefix[4], 9000000012L, "連番");
        exNumericEquals(renbansPrefix.length, 5L, "連番数");

        String renbanStr = RenbanUtil.getRenbanAsString(1, "テスト");
        exStringEquals(renbanStr, "000000013", "連番");

        String[] renbansStr = RenbanUtil.getRenbansAsString(5, 1, "テスト");
        exStringEquals(renbansStr[0], "000000014", "連番");
        exStringEquals(renbansStr[1], "000000015", "連番");
        exStringEquals(renbansStr[2], "000000016", "連番");
        exStringEquals(renbansStr[3], "000000017", "連番");
        exStringEquals(renbansStr[4], "000000018", "連番");
        exNumericEquals(renbansStr.length, 5L, "連番数");

        String renbanStrPrefix = RenbanUtil.getRenbanAsString("SE", 1, "テスト");
        exStringEquals(renbanStrPrefix, "SE000000019", "連番");

        String[] renbansStrPrefix = RenbanUtil.getRenbansAsString("SE", 5, 1,"テスト");
        exStringEquals(renbansStrPrefix[0], "SE000000020", "連番");
        exStringEquals(renbansStrPrefix[1], "SE000000021", "連番");
        exStringEquals(renbansStrPrefix[2], "SE000000022", "連番");
        exStringEquals(renbansStrPrefix[3], "SE000000023", "連番");
        exStringEquals(renbansStrPrefix[4], "SE000000024", "連番");
        exNumericEquals(renbansStrPrefix.length, 5L, "連番数");

        String[] s = { "テスト1", "テスト2", "テスト3" };
        long renbanGroup = RenbanUtil.getRenban(1, s);
        exNumericEquals(renban, 1L, "連番");
    }

}
