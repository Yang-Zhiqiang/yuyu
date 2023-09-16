
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 50音索引区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_50onsakuin</td><td colspan="3">50音索引区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGYOU}</td><td>&quot;1&quot;</td><td>ア行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAGYOU}</td><td>&quot;2&quot;</td><td>カ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAGYOU}</td><td>&quot;3&quot;</td><td>サ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAGYOU}</td><td>&quot;4&quot;</td><td>タ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAGYOU}</td><td>&quot;5&quot;</td><td>ナ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAGYOU}</td><td>&quot;6&quot;</td><td>ハ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAGYOU}</td><td>&quot;7&quot;</td><td>マ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAGYOU}</td><td>&quot;8&quot;</td><td>ヤ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAGYOU}</td><td>&quot;9&quot;</td><td>ラ行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WAGYOU}</td><td>&quot;10&quot;</td><td>ワ行</td></tr>
 * </table>
 */
public class C_50onsakuin extends Classification<C_50onsakuin> {

    private static final long serialVersionUID = 1L;


    public static final C_50onsakuin NONE = new C_50onsakuin("0");

    public static final C_50onsakuin AGYOU = new C_50onsakuin("1");

    public static final C_50onsakuin KAGYOU = new C_50onsakuin("2");

    public static final C_50onsakuin SAGYOU = new C_50onsakuin("3");

    public static final C_50onsakuin TAGYOU = new C_50onsakuin("4");

    public static final C_50onsakuin NAGYOU = new C_50onsakuin("5");

    public static final C_50onsakuin HAGYOU = new C_50onsakuin("6");

    public static final C_50onsakuin MAGYOU = new C_50onsakuin("7");

    public static final C_50onsakuin YAGYOU = new C_50onsakuin("8");

    public static final C_50onsakuin RAGYOU = new C_50onsakuin("9");

    public static final C_50onsakuin WAGYOU = new C_50onsakuin("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, AGYOU, "AGYOU", false);
        addPattern(PATTERN_DEFAULT, KAGYOU, "KAGYOU", false);
        addPattern(PATTERN_DEFAULT, SAGYOU, "SAGYOU", false);
        addPattern(PATTERN_DEFAULT, TAGYOU, "TAGYOU", false);
        addPattern(PATTERN_DEFAULT, NAGYOU, "NAGYOU", false);
        addPattern(PATTERN_DEFAULT, HAGYOU, "HAGYOU", false);
        addPattern(PATTERN_DEFAULT, MAGYOU, "MAGYOU", false);
        addPattern(PATTERN_DEFAULT, YAGYOU, "YAGYOU", false);
        addPattern(PATTERN_DEFAULT, RAGYOU, "RAGYOU", false);
        addPattern(PATTERN_DEFAULT, WAGYOU, "WAGYOU", false);


        lock(C_50onsakuin.class);
    }

    private C_50onsakuin(String value) {
        super(value);
    }

    public static C_50onsakuin valueOf(String value) {
        return valueOf(C_50onsakuin.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_50onsakuin.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_50onsakuin.class, patternId, value);
    }
}
