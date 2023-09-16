
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyksyuruiKbn</td><td colspan="3">入金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPANZENNENDOMAE}</td><td>&quot;1&quot;</td><td>一般前年度以前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPANTOUNENDO}</td><td>&quot;2&quot;</td><td>一般当年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPANYOKUNENDO}</td><td>&quot;3&quot;</td><td>一般翌年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;4&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENBARAI}</td><td>&quot;5&quot;</td><td>年払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANNENBARAI}</td><td>&quot;6&quot;</td><td>半年払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUBARAI}</td><td>&quot;7&quot;</td><td>一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIBARAI}</td><td>&quot;9&quot;</td><td>一時払</td></tr>
 * </table>
 */
public class C_NyksyuruiKbn extends Classification<C_NyksyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyksyuruiKbn BLNK = new C_NyksyuruiKbn("0");

    public static final C_NyksyuruiKbn IPPANZENNENDOMAE = new C_NyksyuruiKbn("1");

    public static final C_NyksyuruiKbn IPPANTOUNENDO = new C_NyksyuruiKbn("2");

    public static final C_NyksyuruiKbn IPPANYOKUNENDO = new C_NyksyuruiKbn("3");

    public static final C_NyksyuruiKbn HUKKATU = new C_NyksyuruiKbn("4");

    public static final C_NyksyuruiKbn NENBARAI = new C_NyksyuruiKbn("5");

    public static final C_NyksyuruiKbn HANNENBARAI = new C_NyksyuruiKbn("6");

    public static final C_NyksyuruiKbn IKKATUBARAI = new C_NyksyuruiKbn("7");

    public static final C_NyksyuruiKbn ITIJIBARAI = new C_NyksyuruiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, IPPANZENNENDOMAE, "IPPANZENNENDOMAE", false);
        addPattern(PATTERN_DEFAULT, IPPANTOUNENDO, "IPPANTOUNENDO", false);
        addPattern(PATTERN_DEFAULT, IPPANYOKUNENDO, "IPPANYOKUNENDO", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, NENBARAI, "NENBARAI", false);
        addPattern(PATTERN_DEFAULT, HANNENBARAI, "HANNENBARAI", false);
        addPattern(PATTERN_DEFAULT, IKKATUBARAI, "IKKATUBARAI", false);
        addPattern(PATTERN_DEFAULT, ITIJIBARAI, "ITIJIBARAI", false);


        lock(C_NyksyuruiKbn.class);
    }

    private C_NyksyuruiKbn(String value) {
        super(value);
    }

    public static C_NyksyuruiKbn valueOf(String value) {
        return valueOf(C_NyksyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyksyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyksyuruiKbn.class, patternId, value);
    }
}
