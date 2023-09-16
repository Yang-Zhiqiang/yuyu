
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報用契約取消処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkInfoKykTorikesiKbn</td><td colspan="3">選択情報用契約取消処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;01&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;02&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;03&quot;</td><td>無効</td></tr>
 * </table>
 */
public class C_SntkInfoKykTorikesiKbn extends Classification<C_SntkInfoKykTorikesiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkInfoKykTorikesiKbn BLNK = new C_SntkInfoKykTorikesiKbn("0");

    public static final C_SntkInfoKykTorikesiKbn KAIJYO = new C_SntkInfoKykTorikesiKbn("01");

    public static final C_SntkInfoKykTorikesiKbn TORIKESI = new C_SntkInfoKykTorikesiKbn("02");

    public static final C_SntkInfoKykTorikesiKbn MUKOU = new C_SntkInfoKykTorikesiKbn("03");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);


        lock(C_SntkInfoKykTorikesiKbn.class);
    }

    private C_SntkInfoKykTorikesiKbn(String value) {
        super(value);
    }

    public static C_SntkInfoKykTorikesiKbn valueOf(String value) {
        return valueOf(C_SntkInfoKykTorikesiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkInfoKykTorikesiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkInfoKykTorikesiKbn.class, patternId, value);
    }
}
