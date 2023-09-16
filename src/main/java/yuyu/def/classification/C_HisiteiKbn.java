
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 日指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HisiteiKbn</td><td colspan="3">日指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #JIDOU}</td><td>&quot;0&quot;</td><td>自動設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;1&quot;</td><td>指定</td></tr>
 * </table>
 */
public class C_HisiteiKbn extends Classification<C_HisiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HisiteiKbn JIDOU = new C_HisiteiKbn("0");

    public static final C_HisiteiKbn SITEI = new C_HisiteiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, JIDOU, "JIDOU", true);
        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);


        lock(C_HisiteiKbn.class);
    }

    private C_HisiteiKbn(String value) {
        super(value);
    }

    public static C_HisiteiKbn valueOf(String value) {
        return valueOf(C_HisiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HisiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HisiteiKbn.class, patternId, value);
    }
}
