
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 調書提出フラグ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tysyteisyutflg</td><td colspan="3">調書提出フラグ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TAISYOUGAI}</td><td>&quot;0&quot;</td><td>提出対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU}</td><td>&quot;1&quot;</td><td>提出対象</td></tr>
 * </table>
 */
public class C_Tysyteisyutflg extends Classification<C_Tysyteisyutflg> {

    private static final long serialVersionUID = 1L;


    public static final C_Tysyteisyutflg TAISYOUGAI = new C_Tysyteisyutflg("0");

    public static final C_Tysyteisyutflg TAISYOU = new C_Tysyteisyutflg("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", true);
        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", false);


        lock(C_Tysyteisyutflg.class);
    }

    private C_Tysyteisyutflg(String value) {
        super(value);
    }

    public static C_Tysyteisyutflg valueOf(String value) {
        return valueOf(C_Tysyteisyutflg.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tysyteisyutflg.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tysyteisyutflg.class, patternId, value);
    }
}
