package yuyu.common.hozen.haitou;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当共通基礎クラスのメソッド {@link BaseDCommon}、<br />
 * {@link BaseDCommon} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class BaseDCommonTest extends BaseDCommon{

    protected static final String INFO1_NAME = "-大分類-";
    protected static final String INFO2_NAME = "-小分類-";
    protected static final String NO_ERROR_INFO = "NoError";
    protected static final String ERRORCODE001 = "001";
    protected static final String ERRORCODE002 = "002";

    ArrayList<String> errorCodes = new ArrayList<>();
    {
        errorCodes.add("011");
        errorCodes.add("012");
        errorCodes.add("021");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testRepeatedCode() throws Throwable {

        try {
            TestError testError = SWAKInjector.getInstance(TestError.class);
        } catch (Exception e) {
            exStringEquals(e.getCause().getMessage(), "システム整合性エラーです。", "エラーメッセージ");
            throw e.getCause();
        }
    }

    @Test
    @TestOrder(20)
    public void testSingleNormal() {

        TestA testA = SWAKInjector.getInstance(TestA.class);

        List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();

        exNumericEquals(haitouErrorInfoLst.size(), 1, "エラー情報リストのサイズ");

        checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, haitouErrorInfoLst.get(0));

        Set<Map.Entry<String, HaitouErrorInfo>> errorSet = testA.getAllErrorCode();
        assertEquals(3, errorSet.size());

        Iterator<Map.Entry<String, HaitouErrorInfo>> errorMap = errorSet.iterator();
        while (errorMap.hasNext()) {

            Entry<String, HaitouErrorInfo> error = errorMap.next();

            if ("011".equals(error.getKey())) {

                System.out.println("messageKey : " + error.getKey());
                checkErrorInfo(error.getValue().getKinouId(),
                    createErrorInfoFormateInfo1(error.getKey(), error.getValue().getKinouId(), INFO1_NAME),
                    createErrorInfoFormateInfo2(error.getKey(), error.getValue().getKinouId(), INFO2_NAME),
                    error.getValue());
            }
            else if ("012".equals(error.getKey())) {

                System.out.println("messageKey : " + error.getKey());
                checkErrorInfo(error.getValue().getKinouId(),
                    createErrorInfoFormateInfo1(error.getKey(), error.getValue().getKinouId(), INFO1_NAME),
                    createErrorInfoFormateInfo2(error.getKey(), error.getValue().getKinouId(), INFO2_NAME),
                    error.getValue());
            }
            else if ("021".equals(error.getKey())) {

                System.out.println("messageKey : " + error.getKey());
                checkErrorInfo(error.getValue().getKinouId(),
                    createErrorInfoFormateInfo1(error.getKey(), error.getValue().getKinouId(), INFO1_NAME),
                    createErrorInfoFormateInfo2(error.getKey(), error.getValue().getKinouId(), INFO2_NAME),
                    error.getValue());
            }
        }
    }

    @Test
    @TestOrder(30)
    public void testErrorCode() {

        TestD testD = SWAKInjector.getInstance(TestD.class);

        testD.execForFalseCausedByMe();

        List<HaitouErrorInfo> haitouErrorInfoLst = testD.getErrorInfo();
        exNumericEquals(haitouErrorInfoLst.size(), 1, "エラー情報のサイズ");

        checkErrorInfo("TestD", "エラーコード整合性不正", "002", haitouErrorInfoLst.get(0));
    }

    @Test
    @TestOrder(40)
    public void testSingleCalledError() {

        String kinouId;

        kinouId = "TestA";
        TestA testA = SWAKInjector.getInstance(TestA.class);
        for (String errorCode : errorCodes) {

            testA.execForFalseCausedByMe(errorCode);

            List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();
            exNumericEquals(haitouErrorInfoLst.size(), 1, "エラー情報のサイズ");

            for (HaitouErrorInfo info : haitouErrorInfoLst) {
                checkErrorInfo(kinouId,
                    createErrorInfoFormateInfo1(errorCode, kinouId, INFO1_NAME),
                    createErrorInfoFormateInfo2(errorCode, kinouId, INFO2_NAME),
                    info);

            }
        }

        kinouId = "TestB";
        TestB testB = SWAKInjector.getInstance(TestB.class);
        for (String errorCode : errorCodes) {

            testB.execForFalseCausedByMe(errorCode);

            List<HaitouErrorInfo> haitouErrorInfoLst = testB.getErrorInfo();
            exNumericEquals(haitouErrorInfoLst.size(), 1, "エラー情報のサイズ");

            for (HaitouErrorInfo info : haitouErrorInfoLst) {
                checkErrorInfo(kinouId,
                    createErrorInfoFormateInfo1(errorCode, kinouId, INFO1_NAME),
                    createErrorInfoFormateInfo2(errorCode, kinouId, INFO2_NAME),
                    info);
            }
        }

        kinouId = "TestA";
        List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();
        exNumericEquals(haitouErrorInfoLst.size(), 1, "エラー情報のサイズ");

        checkErrorInfo(kinouId,
            createErrorInfoFormateInfo1(errorCodes.get(errorCodes.size() - 1), kinouId, INFO1_NAME),
            createErrorInfoFormateInfo2(errorCodes.get(errorCodes.size() - 1), kinouId, INFO2_NAME),
            haitouErrorInfoLst.get(0));

        testA.execForTrue();
        List<HaitouErrorInfo> list = testA.getErrorInfo();

        exNumericEquals(list.size(), 1, "エラー情報のサイズ");

        checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, list.get(0));

    }

    @Test
    @TestOrder(50)
    public void testDoubleCalledError() {

        String kinouIdForCause;

        kinouIdForCause = "TestA";
        TestA testA = SWAKInjector.getInstance(TestA.class);
        for (String errorCode : errorCodes) {

            testA.execForFalseCausedByA(errorCode);

            List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();
            exNumericEquals(haitouErrorInfoLst.size(), 2, "エラー情報のサイズ");

            boolean checkF = true;
            for (HaitouErrorInfo info : haitouErrorInfoLst) {
                if (checkF) {
                    checkErrorInfo(kinouIdForCause,
                        createErrorInfoFormateInfo1(errorCode, kinouIdForCause, INFO1_NAME),
                        createErrorInfoFormateInfo2(errorCode, kinouIdForCause, INFO2_NAME),
                        info);
                    checkF = false;
                } else {
                    checkErrorInfo(kinouIdForCause, NO_ERROR_INFO, NO_ERROR_INFO, info);
                }
            }
        }

        kinouIdForCause = "TestB";
        for (String errorCode : errorCodes) {
            testA.execForFalseCausedByB(errorCode);

            List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();
            exNumericEquals(haitouErrorInfoLst.size(), 2, "エラー情報のサイズ");

            boolean checkF = true;
            for (HaitouErrorInfo info : haitouErrorInfoLst) {
                if (checkF) {
                    checkErrorInfo(kinouIdForCause,
                        createErrorInfoFormateInfo1(errorCode, kinouIdForCause, INFO1_NAME),
                        createErrorInfoFormateInfo2(errorCode, kinouIdForCause, INFO2_NAME),
                        info);
                    checkF = false;
                } else {
                    checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, info);
                }
            }
        }

        testA.execForTrue();
        List<HaitouErrorInfo> list = testA.getErrorInfo();
        checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, list.get(0));
    }

    @Test
    @TestOrder(60)
    public void testTripleCalledError() {

        String kinouIdForCause = "TestC";
        TestA testA = SWAKInjector.getInstance(TestA.class);
        for (String errorCode : errorCodes) {

            testA.execForFalseCausedByBC(errorCode);

            List<HaitouErrorInfo> haitouErrorInfoLst = testA.getErrorInfo();
            exNumericEquals(haitouErrorInfoLst.size(), 3, "エラー情報のサイズ");


            checkErrorInfo(kinouIdForCause,
                createErrorInfoFormateInfo1(errorCode, kinouIdForCause, INFO1_NAME),
                createErrorInfoFormateInfo2(errorCode, kinouIdForCause, INFO2_NAME),
                haitouErrorInfoLst.get(0));

            checkErrorInfo("TestB", NO_ERROR_INFO, NO_ERROR_INFO, haitouErrorInfoLst.get(1));
            checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, haitouErrorInfoLst.get(2));


        }

        testA.execForTrue();
        List<HaitouErrorInfo> list = testA.getErrorInfo();
        checkErrorInfo("TestA", NO_ERROR_INFO, NO_ERROR_INFO, list.get(0));
    }

    void checkErrorInfo(String kinouId, String errorInfo1, String errorInfo2, HaitouErrorInfo info) {
        exStringEquals(kinouId, info.getKinouId().substring(0, kinouId.length()),"");
        exStringEquals(errorInfo1, info.getErrorInfo1(),"");
        exStringEquals(errorInfo2, info.getErrorInfo2(),"");
    }

    String createErrorInfoFormateInfo1(String errorCode, String kinouId, String infoBase) {
        return kinouId.replaceAll("\\$\\$.*", "") + infoBase + errorCode.substring(1, 2);
    }

    String createErrorInfoFormateInfo2(String errorCode, String kinouId, String infoBase) {
        return kinouId.replaceAll("\\$\\$.*", "") + infoBase + errorCode.substring(2, 3);
    }

}

class TestA extends BaseDCommonTest {
    {
        String kinouIdTmp = "TestA";
        for (String errorCodeTmp : errorCodes) {
            regErrorInfo(errorCodeTmp, createErrorInfoFormateInfo1(errorCodeTmp, kinouIdTmp, INFO1_NAME),
                createErrorInfoFormateInfo2(errorCodeTmp, kinouIdTmp, INFO2_NAME));
        }
    }

    protected TestA() {
    }

    protected void execForTrue() {
        clear();
    }

    protected void execForFalseCausedByMe(String errorCode) {
        clear();
        setErrorInfo(errorCode);
    }

    protected void execForFalseCausedByA(String errorCode) {
        clear();
        TestA testA = SWAKInjector.getInstance(TestA.class);
        testA.execForFalseCausedByMe(errorCode);
        setErrorLink(testA);
    }

    protected void execForFalseCausedByB(String errorCode) {
        clear();
        TestB testB = SWAKInjector.getInstance(TestB.class);
        testB.execForFalseCausedByMe(errorCode);
        setErrorLink(testB);

    }

    protected void execForFalseCausedByBC(String errorCode) {
        clear();
        TestB testB = SWAKInjector.getInstance(TestB.class);
        testB.execForFalseCausedByBC(errorCode);
        setErrorLink(testB);
    }
}

class TestB extends BaseDCommonTest {

    {
        String kinouIdTmp = "TestB";
        for (String errorCodeTmp : errorCodes) {
            regErrorInfo(errorCodeTmp, createErrorInfoFormateInfo1(errorCodeTmp, kinouIdTmp, INFO1_NAME),
                createErrorInfoFormateInfo2(errorCodeTmp, kinouIdTmp, INFO2_NAME));
        }
    }

    protected TestB() {
    }

    protected void execForFalseCausedByMe(String errorCode) {
        clear();
        setErrorInfo(errorCode);
    }

    protected void execForFalseCausedByBC(String errorCode) {
        clear();
        TestC testC = SWAKInjector.getInstance(TestC.class);
        testC.execForFalseCausedByMe(errorCode);
        setErrorLink(testC);
    }
}

class TestC extends BaseDCommonTest {

    {
        String kinouIdTmp = "TestC";
        for (String errorCodeTmp : errorCodes) {
            regErrorInfo(errorCodeTmp, createErrorInfoFormateInfo1(errorCodeTmp, kinouIdTmp, INFO1_NAME),
                createErrorInfoFormateInfo2(errorCodeTmp, kinouIdTmp, INFO2_NAME));
        }
    }

    protected TestC() {
    }

    protected void execForFalseCausedByMe(String errorCode) {
        clear();
        setErrorInfo(errorCode);
    }
}

class TestD extends BaseDCommonTest {

    {
        regErrorInfo(ERRORCODE001, "TestD" + INFO1_NAME + "1", "TestD" + INFO2_NAME + "1");
    }

    protected TestD() {
    }

    protected void execForFalseCausedByMe() {
        clear();
        setErrorInfo(ERRORCODE002);
    }
}

class TestError extends BaseDCommonTest {

    {
        regErrorInfo(ERRORCODE001, "TestError" + INFO1_NAME + "1", "TestError" + INFO2_NAME + "1");
        regErrorInfo(ERRORCODE002, "TestError" + INFO1_NAME + "1", "TestError" + INFO2_NAME + "2");
        regErrorInfo(ERRORCODE001, "TestError" + INFO1_NAME + "1", "TestError" + INFO2_NAME + "3");
    }

    protected TestError() {
    }
}
