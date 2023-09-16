
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 組織窓口用発送区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SskmdHassouKbn</td><td colspan="3">組織窓口用発送区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYUKINNASI}</td><td>&quot;0&quot;</td><td>地月集金無し支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLOCKONE}</td><td>&quot;1&quot;</td><td>ブロック１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLOCKTWO}</td><td>&quot;2&quot;</td><td>ブロック２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLOCKTHREE}</td><td>&quot;3&quot;</td><td>ブロック３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLOCKFOUR}</td><td>&quot;4&quot;</td><td>ブロック４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLOCKFIVE}</td><td>&quot;5&quot;</td><td>ブロック５</td></tr>
 * </table>
 */
public class C_SskmdHassouKbn extends Classification<C_SskmdHassouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SskmdHassouKbn SYUKINNASI = new C_SskmdHassouKbn("0");

    public static final C_SskmdHassouKbn BLOCKONE = new C_SskmdHassouKbn("1");

    public static final C_SskmdHassouKbn BLOCKTWO = new C_SskmdHassouKbn("2");

    public static final C_SskmdHassouKbn BLOCKTHREE = new C_SskmdHassouKbn("3");

    public static final C_SskmdHassouKbn BLOCKFOUR = new C_SskmdHassouKbn("4");

    public static final C_SskmdHassouKbn BLOCKFIVE = new C_SskmdHassouKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYUKINNASI, "SYUKINNASI", true);
        addPattern(PATTERN_DEFAULT, BLOCKONE, "BLOCKONE", false);
        addPattern(PATTERN_DEFAULT, BLOCKTWO, "BLOCKTWO", false);
        addPattern(PATTERN_DEFAULT, BLOCKTHREE, "BLOCKTHREE", false);
        addPattern(PATTERN_DEFAULT, BLOCKFOUR, "BLOCKFOUR", false);
        addPattern(PATTERN_DEFAULT, BLOCKFIVE, "BLOCKFIVE", false);


        lock(C_SskmdHassouKbn.class);
    }

    private C_SskmdHassouKbn(String value) {
        super(value);
    }

    public static C_SskmdHassouKbn valueOf(String value) {
        return valueOf(C_SskmdHassouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SskmdHassouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SskmdHassouKbn.class, patternId, value);
    }
}
