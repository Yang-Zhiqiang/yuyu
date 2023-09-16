
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 普保Ⅱ契約番号区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Huho2kyknoKbn</td><td colspan="3">普保Ⅱ契約番号区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNO}</td><td>&quot;1&quot;</td><td>申込番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONO}</td><td>&quot;2&quot;</td><td>証券番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSYSYNO}</td><td>&quot;3&quot;</td><td>年金証書番号</td></tr>
 * </table>
 */
public class C_Huho2kyknoKbn extends Classification<C_Huho2kyknoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Huho2kyknoKbn BLNK = new C_Huho2kyknoKbn("0");

    public static final C_Huho2kyknoKbn MOSNO = new C_Huho2kyknoKbn("1");

    public static final C_Huho2kyknoKbn SYONO = new C_Huho2kyknoKbn("2");

    public static final C_Huho2kyknoKbn NKSYSYNO = new C_Huho2kyknoKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOSNO, "MOSNO", false);
        addPattern(PATTERN_DEFAULT, SYONO, "SYONO", false);
        addPattern(PATTERN_DEFAULT, NKSYSYNO, "NKSYSYNO", false);


        lock(C_Huho2kyknoKbn.class);
    }

    private C_Huho2kyknoKbn(String value) {
        super(value);
    }

    public static C_Huho2kyknoKbn valueOf(String value) {
        return valueOf(C_Huho2kyknoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Huho2kyknoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Huho2kyknoKbn.class, patternId, value);
    }
}
