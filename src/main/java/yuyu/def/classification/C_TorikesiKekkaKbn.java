
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取消結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TorikesiKekkaKbn</td><td colspan="3">取消結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESIOK}</td><td>&quot;1&quot;</td><td>取消ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERR_YOUKYUUNONONE}</td><td>&quot;2&quot;</td><td>エラー（要求通番なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERR_ATOSYORIARI}</td><td>&quot;3&quot;</td><td>エラー（後処理あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERR_TORIKESIZUMI}</td><td>&quot;4&quot;</td><td>エラー（取消済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERR_SONOTA}</td><td>&quot;8&quot;</td><td>エラー（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;9&quot;</td><td>不明</td></tr>
 * </table>
 */
public class C_TorikesiKekkaKbn extends Classification<C_TorikesiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TorikesiKekkaKbn BLNK = new C_TorikesiKekkaKbn("0");

    public static final C_TorikesiKekkaKbn TORIKESIOK = new C_TorikesiKekkaKbn("1");

    public static final C_TorikesiKekkaKbn ERR_YOUKYUUNONONE = new C_TorikesiKekkaKbn("2");

    public static final C_TorikesiKekkaKbn ERR_ATOSYORIARI = new C_TorikesiKekkaKbn("3");

    public static final C_TorikesiKekkaKbn ERR_TORIKESIZUMI = new C_TorikesiKekkaKbn("4");

    public static final C_TorikesiKekkaKbn ERR_SONOTA = new C_TorikesiKekkaKbn("8");

    public static final C_TorikesiKekkaKbn HUMEI = new C_TorikesiKekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TORIKESIOK, "TORIKESIOK", false);
        addPattern(PATTERN_DEFAULT, ERR_YOUKYUUNONONE, "ERR_YOUKYUUNONONE", false);
        addPattern(PATTERN_DEFAULT, ERR_ATOSYORIARI, "ERR_ATOSYORIARI", false);
        addPattern(PATTERN_DEFAULT, ERR_TORIKESIZUMI, "ERR_TORIKESIZUMI", false);
        addPattern(PATTERN_DEFAULT, ERR_SONOTA, "ERR_SONOTA", false);
        addPattern(PATTERN_DEFAULT, HUMEI, "HUMEI", false);


        lock(C_TorikesiKekkaKbn.class);
    }

    private C_TorikesiKekkaKbn(String value) {
        super(value);
    }

    public static C_TorikesiKekkaKbn valueOf(String value) {
        return valueOf(C_TorikesiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TorikesiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TorikesiKekkaKbn.class, patternId, value);
    }
}
