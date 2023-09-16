
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特条承諾書区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkjysydksyoKbn</td><td colspan="3">特条承諾書区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HENSOUYOU}</td><td>&quot;0&quot;</td><td>返送用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAHIKAE}</td><td>&quot;1&quot;</td><td>お客様控え</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUJIYOU}</td><td>&quot;2&quot;</td><td>表示用</td></tr>
 * </table>
 */
public class C_TkjysydksyoKbn extends Classification<C_TkjysydksyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkjysydksyoKbn HENSOUYOU = new C_TkjysydksyoKbn("0");

    public static final C_TkjysydksyoKbn OKYAKUSAMAHIKAE = new C_TkjysydksyoKbn("1");

    public static final C_TkjysydksyoKbn HYOUJIYOU = new C_TkjysydksyoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HENSOUYOU, "HENSOUYOU", true);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAHIKAE, "OKYAKUSAMAHIKAE", false);
        addPattern(PATTERN_DEFAULT, HYOUJIYOU, "HYOUJIYOU", false);


        lock(C_TkjysydksyoKbn.class);
    }

    private C_TkjysydksyoKbn(String value) {
        super(value);
    }

    public static C_TkjysydksyoKbn valueOf(String value) {
        return valueOf(C_TkjysydksyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkjysydksyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkjysydksyoKbn.class, patternId, value);
    }
}
