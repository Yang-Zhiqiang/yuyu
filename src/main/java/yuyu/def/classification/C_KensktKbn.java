
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 検証工程区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KensktKbn</td><td colspan="3">検証工程区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KS1J}</td><td>&quot;1&quot;</td><td>検証１次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KS2J}</td><td>&quot;2&quot;</td><td>検証２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KS3J}</td><td>&quot;3&quot;</td><td>検証３次</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #KS1J}</td><td>&quot;1&quot;</td><td>検証１次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KS2J}</td><td>&quot;2&quot;</td><td>検証２次</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KS3J}</td><td>&quot;3&quot;</td><td>検証３次</td></tr>
 * </table>
 */
public class C_KensktKbn extends Classification<C_KensktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KensktKbn BLNK = new C_KensktKbn("0");

    public static final C_KensktKbn KS1J = new C_KensktKbn("1");

    public static final C_KensktKbn KS2J = new C_KensktKbn("2");

    public static final C_KensktKbn KS3J = new C_KensktKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KS1J, "KS1J", false);
        addPattern(PATTERN_DEFAULT, KS2J, "KS2J", false);
        addPattern(PATTERN_DEFAULT, KS3J, "KS3J", false);


        addPattern(PATTERN_SELECT, KS1J, "KS1J", true);
        addPattern(PATTERN_SELECT, KS2J, "KS2J", false);
        addPattern(PATTERN_SELECT, KS3J, "KS3J", false);


        lock(C_KensktKbn.class);
    }

    private C_KensktKbn(String value) {
        super(value);
    }

    public static C_KensktKbn valueOf(String value) {
        return valueOf(C_KensktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KensktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KensktKbn.class, patternId, value);
    }
}
