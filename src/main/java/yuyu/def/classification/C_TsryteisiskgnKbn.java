
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料停止削減区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsryteisiskgnKbn</td><td colspan="3">手数料停止削減区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISI}</td><td>&quot;1&quot;</td><td>停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUGEN}</td><td>&quot;2&quot;</td><td>削減</td></tr>
 * </table>
 */
public class C_TsryteisiskgnKbn extends Classification<C_TsryteisiskgnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsryteisiskgnKbn BLNK = new C_TsryteisiskgnKbn("0");

    public static final C_TsryteisiskgnKbn TEISI = new C_TsryteisiskgnKbn("1");

    public static final C_TsryteisiskgnKbn SAKUGEN = new C_TsryteisiskgnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TEISI, "TEISI", false);
        addPattern(PATTERN_DEFAULT, SAKUGEN, "SAKUGEN", false);


        lock(C_TsryteisiskgnKbn.class);
    }

    private C_TsryteisiskgnKbn(String value) {
        super(value);
    }

    public static C_TsryteisiskgnKbn valueOf(String value) {
        return valueOf(C_TsryteisiskgnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsryteisiskgnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsryteisiskgnKbn.class, patternId, value);
    }
}
