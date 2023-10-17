package yuyu.common.workflowcore;

import yuyu.common.sinkeiyaku.syoruitoutyaku.SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo;
import yuyu.common.workflowcore.scan.impl.ScanReceiveInfoBean;

/**
 * {@link ScanReceiveInfoBean}のモッククラスです。<br />
 */
public class ScanReceiveInfoBeanMock extends ScanReceiveInfoBean{

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4 = "4";

    public static final String TESTPATTERN5 = "5";

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getDocumentId(){
        return super.getDocumentId();
    }

    @Override
    public String getDocumentURI(){
        return super.getDocumentURI();
    }

    @Override
    public String getUserId(){
        if (caller == SinkeiyakuGetSyoruitoutyakuInfoTest_getToutyakuYoteiInfo.class) {
            if (TESTPATTERN1.equals(SYORIPTN)) {
                return null;
            }
            else if (TESTPATTERN2.equals(SYORIPTN)) {
                return "";
            }
            else if (TESTPATTERN3.equals(SYORIPTN)) {
                return "12";
            }
            else if (TESTPATTERN4.equals(SYORIPTN)) {
                return "123";
            }
            else if (TESTPATTERN5.equals(SYORIPTN)) {
                return "1234";
            }

        }
        return super.getUserId();
    }

    @Override
    public int getPages(){
        return super.getPages();
    }
}
