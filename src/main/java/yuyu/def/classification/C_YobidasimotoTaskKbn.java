
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 呼出元タスク区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YobidasimotoTaskKbn</td><td colspan="3">呼出元タスク区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKUKE}</td><td>&quot;1&quot;</td><td>請求受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI}</td><td>&quot;2&quot;</td><td>査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKI_SYOUNIN}</td><td>&quot;3&quot;</td><td>手続・承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SESYOU_KAIKETU}</td><td>&quot;4&quot;</td><td>折衝・解決入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINDANSYORYOUSHR}</td><td>&quot;5&quot;</td><td>診断書料支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKARIUKETUKE}</td><td>&quot;6&quot;</td><td>死亡仮受付</td></tr>
 * </table>
 */
public class C_YobidasimotoTaskKbn extends Classification<C_YobidasimotoTaskKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YobidasimotoTaskKbn BLNK = new C_YobidasimotoTaskKbn("0");

    public static final C_YobidasimotoTaskKbn SKUKE = new C_YobidasimotoTaskKbn("1");

    public static final C_YobidasimotoTaskKbn SATEI = new C_YobidasimotoTaskKbn("2");

    public static final C_YobidasimotoTaskKbn TETUDUKI_SYOUNIN = new C_YobidasimotoTaskKbn("3");

    public static final C_YobidasimotoTaskKbn SESYOU_KAIKETU = new C_YobidasimotoTaskKbn("4");

    public static final C_YobidasimotoTaskKbn SINDANSYORYOUSHR = new C_YobidasimotoTaskKbn("5");

    public static final C_YobidasimotoTaskKbn SIBOUKARIUKETUKE = new C_YobidasimotoTaskKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKUKE, "SKUKE", false);
        addPattern(PATTERN_DEFAULT, SATEI, "SATEI", false);
        addPattern(PATTERN_DEFAULT, TETUDUKI_SYOUNIN, "TETUDUKI_SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, SESYOU_KAIKETU, "SESYOU_KAIKETU", false);
        addPattern(PATTERN_DEFAULT, SINDANSYORYOUSHR, "SINDANSYORYOUSHR", false);
        addPattern(PATTERN_DEFAULT, SIBOUKARIUKETUKE, "SIBOUKARIUKETUKE", false);


        lock(C_YobidasimotoTaskKbn.class);
    }

    private C_YobidasimotoTaskKbn(String value) {
        super(value);
    }

    public static C_YobidasimotoTaskKbn valueOf(String value) {
        return valueOf(C_YobidasimotoTaskKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YobidasimotoTaskKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YobidasimotoTaskKbn.class, patternId, value);
    }
}
