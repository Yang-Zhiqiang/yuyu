
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 診査場所区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsabaKbn</td><td colspan="3">診査場所区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINSAITAKU}</td><td>&quot;1&quot;</td><td>診査医宅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIHOKENSYATAKU}</td><td>&quot;2&quot;</td><td>被保険者宅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINMUSAKI}</td><td>&quot;3&quot;</td><td>勤務先</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUSYATENPO}</td><td>&quot;4&quot;</td><td>当社店舗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SinsabaKbn extends Classification<C_SinsabaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsabaKbn BLNK = new C_SinsabaKbn("0");

    public static final C_SinsabaKbn SINSAITAKU = new C_SinsabaKbn("1");

    public static final C_SinsabaKbn HIHOKENSYATAKU = new C_SinsabaKbn("2");

    public static final C_SinsabaKbn KINMUSAKI = new C_SinsabaKbn("3");

    public static final C_SinsabaKbn TOUSYATENPO = new C_SinsabaKbn("4");

    public static final C_SinsabaKbn SONOTA = new C_SinsabaKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINSAITAKU, "SINSAITAKU", false);
        addPattern(PATTERN_DEFAULT, HIHOKENSYATAKU, "HIHOKENSYATAKU", false);
        addPattern(PATTERN_DEFAULT, KINMUSAKI, "KINMUSAKI", false);
        addPattern(PATTERN_DEFAULT, TOUSYATENPO, "TOUSYATENPO", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SinsabaKbn.class);
    }

    private C_SinsabaKbn(String value) {
        super(value);
    }

    public static C_SinsabaKbn valueOf(String value) {
        return valueOf(C_SinsabaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsabaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsabaKbn.class, patternId, value);
    }
}
