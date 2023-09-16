
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 変額保険資格受験区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hngkhknskjkhknbn</td><td colspan="3">変額保険資格受験区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>設定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JK}</td><td>&quot;1&quot;</td><td>受験</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKANTOUGOU}</td><td>&quot;2&quot;</td><td>移管統合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYAYORI}</td><td>&quot;3&quot;</td><td>他社よりの移籍</td></tr>
 * </table>
 */
public class C_Hngkhknskjkhknbn extends Classification<C_Hngkhknskjkhknbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Hngkhknskjkhknbn NONE = new C_Hngkhknskjkhknbn("0");

    public static final C_Hngkhknskjkhknbn JK = new C_Hngkhknskjkhknbn("1");

    public static final C_Hngkhknskjkhknbn IKANTOUGOU = new C_Hngkhknskjkhknbn("2");

    public static final C_Hngkhknskjkhknbn TASYAYORI = new C_Hngkhknskjkhknbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, JK, "JK", false);
        addPattern(PATTERN_DEFAULT, IKANTOUGOU, "IKANTOUGOU", false);
        addPattern(PATTERN_DEFAULT, TASYAYORI, "TASYAYORI", false);


        lock(C_Hngkhknskjkhknbn.class);
    }

    private C_Hngkhknskjkhknbn(String value) {
        super(value);
    }

    public static C_Hngkhknskjkhknbn valueOf(String value) {
        return valueOf(C_Hngkhknskjkhknbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hngkhknskjkhknbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hngkhknskjkhknbn.class, patternId, value);
    }
}
