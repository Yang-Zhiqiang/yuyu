package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.app.dsweb.dwhozeninfo.dwkyknaiyouosirase.DwKykNaiyouOsiraseTest_exec;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ErrorKbn;

/**
 * ご契約内容のお知らせ作成処理{@link KykNaiyouOsiraseiSks}のモッククラスです<br />
 */
public class KykNaiyouOsiraseiSksMockForDirect extends KykNaiyouOsiraseiSks {

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    public static final String TESTPATTERN3 = "3";

    @Override
    public C_ErrorKbn exec(String pSyono, int pYobidasimotoKbn, KhAddKoumokuSetteiBean pAddKoumokuSetteiBean) {

        if (caller == DwKykNaiyouOsiraseTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return C_ErrorKbn.ERROR;
            }
        }

        return super.exec(pSyono, pYobidasimotoKbn, pAddKoumokuSetteiBean);
    }

    @Override
    public String getErrorMsg() {

        if (caller == DwKykNaiyouOsiraseTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                return MessageUtil.getMessage(MessageId.EIA0085);
            }
        }
        return super.getErrorMsg();
    }

}
