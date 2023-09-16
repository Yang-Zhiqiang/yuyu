
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特伸区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TokusinKbn</td><td colspan="3">特伸区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HISAIGAI}</td><td>&quot;1&quot;</td><td>被災害特伸</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;2&quot;</td><td>その他（猶予期間延長）</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;2&quot;</td><td>その他（猶予期間延長）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HISAIGAI}</td><td>&quot;1&quot;</td><td>被災害特伸</td></tr>
 * </table>
 */
public class C_TokusinKbn extends Classification<C_TokusinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TokusinKbn BLNK = new C_TokusinKbn("0");

    public static final C_TokusinKbn HISAIGAI = new C_TokusinKbn("1");

    public static final C_TokusinKbn OTHER = new C_TokusinKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HISAIGAI, "HISAIGAI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        addPattern(PATTERN_SELECT, OTHER, "OTHER", true);
        addPattern(PATTERN_SELECT, HISAIGAI, "HISAIGAI", false);


        lock(C_TokusinKbn.class);
    }

    private C_TokusinKbn(String value) {
        super(value);
    }

    public static C_TokusinKbn valueOf(String value) {
        return valueOf(C_TokusinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TokusinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TokusinKbn.class, patternId, value);
    }
}
