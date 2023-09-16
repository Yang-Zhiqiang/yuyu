
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＰＨ提携地銀区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LphteikeitiginKbn</td><td colspan="3">ＬＰＨ提携地銀区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>該当しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOU}</td><td>&quot;2&quot;</td><td>該当する</td></tr>
 * </table>
 */
public class C_LphteikeitiginKbn extends Classification<C_LphteikeitiginKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LphteikeitiginKbn BLNK = new C_LphteikeitiginKbn("0");

    public static final C_LphteikeitiginKbn NONE = new C_LphteikeitiginKbn("1");

    public static final C_LphteikeitiginKbn GAITOU = new C_LphteikeitiginKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, GAITOU, "GAITOU", false);


        lock(C_LphteikeitiginKbn.class);
    }

    private C_LphteikeitiginKbn(String value) {
        super(value);
    }

    public static C_LphteikeitiginKbn valueOf(String value) {
        return valueOf(C_LphteikeitiginKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LphteikeitiginKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LphteikeitiginKbn.class, patternId, value);
    }
}
