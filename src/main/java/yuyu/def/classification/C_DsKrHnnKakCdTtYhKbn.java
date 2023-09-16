
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ仮本人確認コード通知要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKrHnnKakCdTtYhKbn</td><td colspan="3">ＤＳ仮本人確認コード通知要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUDAN}</td><td>&quot;2&quot;</td><td>中断</td></tr>
 * </table>
 */
public class C_DsKrHnnKakCdTtYhKbn extends Classification<C_DsKrHnnKakCdTtYhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKrHnnKakCdTtYhKbn BLNK = new C_DsKrHnnKakCdTtYhKbn("0");

    public static final C_DsKrHnnKakCdTtYhKbn YOU = new C_DsKrHnnKakCdTtYhKbn("1");

    public static final C_DsKrHnnKakCdTtYhKbn TYUUDAN = new C_DsKrHnnKakCdTtYhKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, TYUUDAN, "TYUUDAN", false);


        lock(C_DsKrHnnKakCdTtYhKbn.class);
    }

    private C_DsKrHnnKakCdTtYhKbn(String value) {
        super(value);
    }

    public static C_DsKrHnnKakCdTtYhKbn valueOf(String value) {
        return valueOf(C_DsKrHnnKakCdTtYhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKrHnnKakCdTtYhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKrHnnKakCdTtYhKbn.class, patternId, value);
    }
}
