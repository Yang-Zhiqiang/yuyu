
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ベリファイ状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_VrfjkKbn</td><td colspan="3">ベリファイ状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TSHN_MIJISSI}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINRKMATI}</td><td>&quot;1&quot;</td><td>２次入力待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANJINRKMATI}</td><td>&quot;2&quot;</td><td>３次入力待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;3&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_VrfjkKbn extends Classification<C_VrfjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_VrfjkKbn TSHN_MIJISSI = new C_VrfjkKbn("0");

    public static final C_VrfjkKbn NIJINRKMATI = new C_VrfjkKbn("1");

    public static final C_VrfjkKbn SANJINRKMATI = new C_VrfjkKbn("2");

    public static final C_VrfjkKbn KANRYOU = new C_VrfjkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TSHN_MIJISSI, "TSHN_MIJISSI", true);
        addPattern(PATTERN_DEFAULT, NIJINRKMATI, "NIJINRKMATI", false);
        addPattern(PATTERN_DEFAULT, SANJINRKMATI, "SANJINRKMATI", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_VrfjkKbn.class);
    }

    private C_VrfjkKbn(String value) {
        super(value);
    }

    public static C_VrfjkKbn valueOf(String value) {
        return valueOf(C_VrfjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_VrfjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_VrfjkKbn.class, patternId, value);
    }
}
