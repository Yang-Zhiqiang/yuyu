
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷモード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GwmodeKbn</td><td colspan="3">ＧＷモード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEST}</td><td>&quot;9&quot;</td><td>テスト</td></tr>
 * </table>
 */
public class C_GwmodeKbn extends Classification<C_GwmodeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GwmodeKbn BLNK = new C_GwmodeKbn("0");

    public static final C_GwmodeKbn TUUJYOU = new C_GwmodeKbn("1");

    public static final C_GwmodeKbn TEST = new C_GwmodeKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, TEST, "TEST", false);


        lock(C_GwmodeKbn.class);
    }

    private C_GwmodeKbn(String value) {
        super(value);
    }

    public static C_GwmodeKbn valueOf(String value) {
        return valueOf(C_GwmodeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GwmodeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GwmodeKbn.class, patternId, value);
    }
}
