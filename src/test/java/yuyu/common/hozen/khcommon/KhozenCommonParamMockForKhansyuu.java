package yuyu.common.hozen.khcommon;

/**
 * {@link KhozenCommonParam}のモッククラスです。<br />
 */
public class KhozenCommonParamMockForKhansyuu extends KhozenCommonParam {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    @Override
    public String getFunctionId() {

        if(caller == EditMinyuuTuutiTest_editTBL.class){
            return "EditMinyuuTuuti";

        }
        if(caller == EditMinyuuTuutiTest_editTBL2.class){
            return "EditMinyuuTuuti";

        }
        if(caller == EditMinyuuTuutiTest_editTBL3.class){
            return "EditMinyuuTuuti";

        }
        return super.getFunctionId();
    }

    @Override
    public String getUserID() {

        if(caller == EditMinyuuTuutiTest_editTBL.class){
            return "testUser";

        }
        if(caller == EditMinyuuTuutiTest_editTBL2.class){
            return "testUser";

        }
        if(caller == EditMinyuuTuutiTest_editTBL3.class){
            return "testUser";

        }
        return super.getUserID();
    }
}
