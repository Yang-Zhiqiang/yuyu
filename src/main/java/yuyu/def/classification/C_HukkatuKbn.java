
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 復活区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HukkatuKbn</td><td colspan="3">復活区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;1&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI}</td><td>&quot;2&quot;</td><td>延期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;3&quot;</td><td>見合わせ</td></tr>
 * </table>
 */
public class C_HukkatuKbn extends Classification<C_HukkatuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HukkatuKbn BLNK = new C_HukkatuKbn("0");

    public static final C_HukkatuKbn HUKKATU = new C_HukkatuKbn("1");

    public static final C_HukkatuKbn ENKI = new C_HukkatuKbn("2");

    public static final C_HukkatuKbn MIAWASE = new C_HukkatuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, ENKI, "ENKI", false);
        addPattern(PATTERN_DEFAULT, MIAWASE, "MIAWASE", false);


        lock(C_HukkatuKbn.class);
    }

    private C_HukkatuKbn(String value) {
        super(value);
    }

    public static C_HukkatuKbn valueOf(String value) {
        return valueOf(C_HukkatuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HukkatuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HukkatuKbn.class, patternId, value);
    }
}
