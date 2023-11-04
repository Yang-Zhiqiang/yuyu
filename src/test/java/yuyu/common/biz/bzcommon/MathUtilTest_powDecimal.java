package yuyu.common.biz.bzcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.math.BigDecimal;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.TestOrder;

/**
 * {@link MathUtil}クラスに含まれる、{@link MathUtil#powDecimal(BizNumber, BizNumber, int, int)} メソッドのテストです。
 * <br />
 */

@RunWith(SWAKTestRunner.class)
public class MathUtilTest_powDecimal {

    private BizNumber _iBase;
    private BizNumber _iExponent;
    private int _iScale;
    private int _iRoundingMode;
    private BizNumber _oKekkaA;
    private BizNumber _oKekkaB;
    private BizNumber _result;


    @Before
    public void resetDefaultVal(){
        this._iBase = BizNumber.valueOf(new BigDecimal("1.5"));
        this._iExponent = BizNumber.valueOf(new BigDecimal("4"));
        this._iScale = 3;
        this._iRoundingMode = 2;
        this._oKekkaA  = BizNumber.valueOf(new BigDecimal("5.062"));
        this._oKekkaB  = BizNumber.valueOf(new BigDecimal("5.063"));
        this._result = null;
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testNormalParam(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, _iRoundingMode);
        exBizCalcbleEquals(_oKekkaB, _result, "(1)代表正常ケース");
    }


    @Test(expected = NullPointerException.class)
    @TestOrder(20)
    public void testIllegalParam1(){
        try{
            _result = MathUtil.powDecimal(null, _iExponent, _iScale, _iRoundingMode);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(30)
    public void testIllegalParam2(){
        try{
            _result = MathUtil.powDecimal(_iBase, null, _iScale, _iRoundingMode);
        }catch(NullPointerException npe){
            throw npe;
        }
    }

    @Test(expected = NullPointerException.class)
    @TestOrder(40)
    public void testIllegalParam3(){
        try{
            _result = MathUtil.powDecimal(null, null, _iScale, _iRoundingMode);
        }catch(NullPointerException npe){
            throw npe;
        }
    }


    @Test
    @TestOrder(50)
    public void testRoundingMode1(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 0);
        exBizCalcbleEquals(_oKekkaB, _result, "(1)丸めモード：0 (RoundingMode.UP)");
    }

    @Test
    @TestOrder(60)
    public void testRoundingMode2(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 1);
        exBizCalcbleEquals(_oKekkaA, _result, "(2)丸めモード：1 (RoundingMode.DOWN)");
    }

    @Test
    @TestOrder(70)
    public void testRoundingMode3(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 2);
        exBizCalcbleEquals(_oKekkaB, _result, "(3)丸めモード：2 (RoundingMode.CEILING)");
    }

    @Test
    @TestOrder(80)
    public void testRoundingMode4(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 3);
        exBizCalcbleEquals(_oKekkaA, _result, "(4)丸めモード：3 (RoundingMode.FLOOR)");
    }

    @Test
    @TestOrder(90)
    public void testRoundingMode5(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 4);
        exBizCalcbleEquals(_oKekkaB, _result, "(5)丸めモード：4 (RoundingMode.HALF_UP)");
    }

    @Test
    @TestOrder(100)
    public void testRoundingMode6(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 5);
        exBizCalcbleEquals(_oKekkaA, _result, "(6)丸めモード：5 (RoundingMode.HALF_DOWN)");
    }

    @Test
    @TestOrder(110)
    public void testRoundingMode7(){
        _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 6);
        exBizCalcbleEquals(_oKekkaA, _result, "(7)丸めモード：6 (RoundingMode.HALF_EVEN)");
    }

    @Test(expected = ArithmeticException.class)
    @TestOrder(120)
    public void testRoundingMode8(){
        try{
            _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 7);
        }catch(ArithmeticException ae){
            throw ae;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    @TestOrder(130)
    public void testRoundingMode9(){
        try{
            _result = MathUtil.powDecimal(_iBase, _iExponent, _iScale, 8);
            Assert.fail("例外が発生しない");
        }catch(IllegalArgumentException iae){
            throw iae;
        }
    }
}
