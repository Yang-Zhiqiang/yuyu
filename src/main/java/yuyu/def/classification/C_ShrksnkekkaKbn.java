
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払計算結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrksnkekkaKbn</td><td colspan="3">支払計算結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI_OK}</td><td>&quot;1&quot;</td><td>照会ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR_HRKE_OK}</td><td>&quot;2&quot;</td><td>支払・振替ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;9&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_ShrksnkekkaKbn extends Classification<C_ShrksnkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrksnkekkaKbn BLNK = new C_ShrksnkekkaKbn("0");

    public static final C_ShrksnkekkaKbn SYOUKAI_OK = new C_ShrksnkekkaKbn("1");

    public static final C_ShrksnkekkaKbn SHR_HRKE_OK = new C_ShrksnkekkaKbn("2");

    public static final C_ShrksnkekkaKbn ERROR = new C_ShrksnkekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKAI_OK, "SYOUKAI_OK", false);
        addPattern(PATTERN_DEFAULT, SHR_HRKE_OK, "SHR_HRKE_OK", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_ShrksnkekkaKbn.class);
    }

    private C_ShrksnkekkaKbn(String value) {
        super(value);
    }

    public static C_ShrksnkekkaKbn valueOf(String value) {
        return valueOf(C_ShrksnkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrksnkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrksnkekkaKbn.class, patternId, value);
    }
}
