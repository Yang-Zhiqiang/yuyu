
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新旧区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NewOldKbn</td><td colspan="3">新旧区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NEWDATA}</td><td>&quot;1&quot;</td><td>新データ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDDATA}</td><td>&quot;2&quot;</td><td>旧データ</td></tr>
 * </table>
 */
public class C_NewOldKbn extends Classification<C_NewOldKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NewOldKbn NEWDATA = new C_NewOldKbn("1");

    public static final C_NewOldKbn OLDDATA = new C_NewOldKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NEWDATA, "NEWDATA", true);
        addPattern(PATTERN_DEFAULT, OLDDATA, "OLDDATA", false);


        lock(C_NewOldKbn.class);
    }

    private C_NewOldKbn(String value) {
        super(value);
    }

    public static C_NewOldKbn valueOf(String value) {
        return valueOf(C_NewOldKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NewOldKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NewOldKbn.class, patternId, value);
    }
}
