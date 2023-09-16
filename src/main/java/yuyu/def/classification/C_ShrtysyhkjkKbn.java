
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払調書保険事故区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrtysyhkjkKbn</td><td colspan="3">支払調書保険事故区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;1&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;2&quot;</td><td>減額等</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;3&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;4&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;5&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;6&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETORININHNK}</td><td>&quot;7&quot;</td><td>受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUITJKN}</td><td>&quot;8&quot;</td><td>死亡一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAISYOKYHKN}</td><td>&quot;9&quot;</td><td>脱退諸給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;10&quot;</td><td>年金</td></tr>
 * </table>
 */
public class C_ShrtysyhkjkKbn extends Classification<C_ShrtysyhkjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrtysyhkjkKbn BLNK = new C_ShrtysyhkjkKbn("0");

    public static final C_ShrtysyhkjkKbn KAIYAKU = new C_ShrtysyhkjkKbn("1");

    public static final C_ShrtysyhkjkKbn GENGAKU = new C_ShrtysyhkjkKbn("2");

    public static final C_ShrtysyhkjkKbn KAIJYO = new C_ShrtysyhkjkKbn("3");

    public static final C_ShrtysyhkjkKbn MENSEKI = new C_ShrtysyhkjkKbn("4");

    public static final C_ShrtysyhkjkKbn SIBOU = new C_ShrtysyhkjkKbn("5");

    public static final C_ShrtysyhkjkKbn MANKI = new C_ShrtysyhkjkKbn("6");

    public static final C_ShrtysyhkjkKbn UKETORININHNK = new C_ShrtysyhkjkKbn("7");

    public static final C_ShrtysyhkjkKbn SIBOUITJKN = new C_ShrtysyhkjkKbn("8");

    public static final C_ShrtysyhkjkKbn DATTAISYOKYHKN = new C_ShrtysyhkjkKbn("9");

    public static final C_ShrtysyhkjkKbn NENKIN = new C_ShrtysyhkjkKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, UKETORININHNK, "UKETORININHNK", false);
        addPattern(PATTERN_DEFAULT, SIBOUITJKN, "SIBOUITJKN", false);
        addPattern(PATTERN_DEFAULT, DATTAISYOKYHKN, "DATTAISYOKYHKN", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);


        lock(C_ShrtysyhkjkKbn.class);
    }

    private C_ShrtysyhkjkKbn(String value) {
        super(value);
    }

    public static C_ShrtysyhkjkKbn valueOf(String value) {
        return valueOf(C_ShrtysyhkjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrtysyhkjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrtysyhkjkKbn.class, patternId, value);
    }
}
