package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import yuyu.common.sinkeiyaku.moschk.MosnaiCheckParam;

/**
 * {@link EditTblAtukaisya}のモッククラスです。<br />
 */
public class EditTblAtukaisyaMockForSinkeiyaku extends EditTblAtukaisya{

    public static Class<?> caller = null;

    public static String SYORIPTN = null;

    public static final String TESTPATTERN1 = "1";

    public static final String TESTPATTERN2 = "2";

    @Override
    public ArrayList<Map<String, String>> exec(MosnaiCheckParam pMP) {
        if (caller == EditPdfKykKakuninIraisyoTest_exec.class) {

            if (TESTPATTERN1.equals(SYORIPTN)) {
                ArrayList<Map<String, String>> atukaisyaLst = new ArrayList<>();
                Map<String, String> atukaisyaMap = new HashMap<>();
                atukaisyaMap.put(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGCD, "101");
                atukaisyaMap.put(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGNM, "取扱代理店名");
                atukaisyaLst.add(atukaisyaMap);
                return atukaisyaLst;
            }

            if (TESTPATTERN2.equals(SYORIPTN)) {
                ArrayList<Map<String, String>> atukaisyaLst = new ArrayList<>();
                Map<String, String> atukaisyaMap = new HashMap<>();
                atukaisyaMap.put(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGCD, "202");
                atukaisyaMap.put(EditTblAtukaisya.ATUKAISYAJHKEY_TRATKIAGNM, "取扱代理店名２");
                atukaisyaLst.add(atukaisyaMap);
                return atukaisyaLst;
            }

        }
        return super.exec(pMP);
    }
}
