
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 団体料率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DntryourituKbn</td><td colspan="3">団体料率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #A}</td><td>&quot;1&quot;</td><td>団体Ａ料率</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #B}</td><td>&quot;2&quot;</td><td>団体Ｂ料率</td></tr>
 * </table>
 */
public class C_DntryourituKbn extends Classification<C_DntryourituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DntryourituKbn BLNK = new C_DntryourituKbn("0");

    public static final C_DntryourituKbn A = new C_DntryourituKbn("1");

    public static final C_DntryourituKbn B = new C_DntryourituKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, A, "A", false);
        addPattern(PATTERN_DEFAULT, B, "B", false);


        lock(C_DntryourituKbn.class);
    }

    private C_DntryourituKbn(String value) {
        super(value);
    }

    public static C_DntryourituKbn valueOf(String value) {
        return valueOf(C_DntryourituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DntryourituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DntryourituKbn.class, patternId, value);
    }
}
