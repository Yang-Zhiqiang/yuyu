
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮締本締区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KarijimehonjimeKbn</td><td colspan="3">仮締本締区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIJIME}</td><td>&quot;1&quot;</td><td>仮締め</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONJIME}</td><td>&quot;2&quot;</td><td>本締め</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;3&quot;</td><td>決算</td></tr>
 * </table>
 */
public class C_KarijimehonjimeKbn extends Classification<C_KarijimehonjimeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KarijimehonjimeKbn BLNK = new C_KarijimehonjimeKbn("0");

    public static final C_KarijimehonjimeKbn KARIJIME = new C_KarijimehonjimeKbn("1");

    public static final C_KarijimehonjimeKbn HONJIME = new C_KarijimehonjimeKbn("2");

    public static final C_KarijimehonjimeKbn KESSAN = new C_KarijimehonjimeKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KARIJIME, "KARIJIME", false);
        addPattern(PATTERN_DEFAULT, HONJIME, "HONJIME", false);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);


        lock(C_KarijimehonjimeKbn.class);
    }

    private C_KarijimehonjimeKbn(String value) {
        super(value);
    }

    public static C_KarijimehonjimeKbn valueOf(String value) {
        return valueOf(C_KarijimehonjimeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KarijimehonjimeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KarijimehonjimeKbn.class, patternId, value);
    }
}
