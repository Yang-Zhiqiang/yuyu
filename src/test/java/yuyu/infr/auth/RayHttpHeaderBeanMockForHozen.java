package yuyu.infr.auth;

import yuyu.common.hozen.khcommon.EditSouhuannaiTblTest_editBean;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL1;
import yuyu.common.hozen.khcommon.EditTtdkKanryouTblTest_editTBL2;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblTest_exec;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtlTest_createTyouhyouTBL;

/**
 * 認証情報として使用する端末設置組織コード・名を保持するクラスです。
 */
public class RayHttpHeaderBeanMockForHozen extends RayHttpHeaderBean{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    private static final long serialVersionUID = 1L;

    public static final String TESTPATTERN1 = "1";

    @Override
    public String getTmSosikiCd() {
        if (caller == EditSouhuannaiTblTest_editBean.class) {
            return "test01";
        }
        if (caller == EditTtdkRirekiTblTest_exec.class) {
            return "0010001";
        }
        if (caller == KhozenTyouhyouCtlTest_createTyouhyouTBL.class) {
            return "7430000";
        }
        if (caller == EditTtdkKanryouTblTest_editTBL.class || caller == EditTtdkKanryouTblTest_editTBL1.class
            || caller == EditTtdkKanryouTblTest_editTBL2.class) {
            return "0010001";
        }
        return "test01";

    }
}
