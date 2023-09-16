
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不要データ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HuyoudataKbn</td><td colspan="3">不要データ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ITIJISIYOU}</td><td>&quot;1&quot;</td><td>一時使用不要データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKEIKA}</td><td>&quot;2&quot;</td><td>有効期間経過不要データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALL}</td><td>&quot;3&quot;</td><td>全て</td></tr>
 * </table>
 */
public class C_HuyoudataKbn extends Classification<C_HuyoudataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HuyoudataKbn ITIJISIYOU = new C_HuyoudataKbn("1");

    public static final C_HuyoudataKbn YUUKOUKKNKEIKA = new C_HuyoudataKbn("2");

    public static final C_HuyoudataKbn ALL = new C_HuyoudataKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ITIJISIYOU, "ITIJISIYOU", true);
        addPattern(PATTERN_DEFAULT, YUUKOUKKNKEIKA, "YUUKOUKKNKEIKA", false);
        addPattern(PATTERN_DEFAULT, ALL, "ALL", false);


        lock(C_HuyoudataKbn.class);
    }

    private C_HuyoudataKbn(String value) {
        super(value);
    }

    public static C_HuyoudataKbn valueOf(String value) {
        return valueOf(C_HuyoudataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HuyoudataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HuyoudataKbn.class, patternId, value);
    }
}
