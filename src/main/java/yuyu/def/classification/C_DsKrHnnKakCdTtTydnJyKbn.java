
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ仮本人確認コード通知中断事由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKrHnnKakCdTtTydnJyKbn</td><td colspan="3">ＤＳ仮本人確認コード通知中断事由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS}</td><td>&quot;1&quot;</td><td>名寄せ不可（住所相違）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_MGS}</td><td>&quot;2&quot;</td><td>名寄せ不可（住所相違、名義相違）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_MGS_JSHT}</td><td>&quot;3&quot;</td><td>名寄せ不可（住所相違、名義相違、住所変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_MGS_JSHT_MGHT}</td><td>&quot;4&quot;</td><td>名寄せ不可（住所相違、名義相違、住所変更中、名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_JSHT}</td><td>&quot;5&quot;</td><td>名寄せ不可（住所相違、住所変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_JSHT_MGHT}</td><td>&quot;6&quot;</td><td>名寄せ不可（住所相違、住所変更中、名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSS_MGHT}</td><td>&quot;7&quot;</td><td>名寄せ不可（住所相違、名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_MGS}</td><td>&quot;8&quot;</td><td>名寄せ不可（名義相違）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_MGS_JSHT}</td><td>&quot;9&quot;</td><td>名寄せ不可（名義相違、住所変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_MGS_JSHT_MGHT}</td><td>&quot;10&quot;</td><td>名寄せ不可（名義相違、住所変更中、名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSHT}</td><td>&quot;11&quot;</td><td>名寄せ不可（住所変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_JSHT_MGHT}</td><td>&quot;12&quot;</td><td>名寄せ不可（住所変更中、名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYSHK_MGHT}</td><td>&quot;13&quot;</td><td>名寄せ不可（名義変更中）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKKSBTY}</td><td>&quot;14&quot;</td><td>顧客整備による中断</td></tr>
 * </table>
 */
public class C_DsKrHnnKakCdTtTydnJyKbn extends Classification<C_DsKrHnnKakCdTtTydnJyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKrHnnKakCdTtTydnJyKbn BLNK = new C_DsKrHnnKakCdTtTydnJyKbn("0");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS = new C_DsKrHnnKakCdTtTydnJyKbn("1");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_MGS = new C_DsKrHnnKakCdTtTydnJyKbn("2");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_MGS_JSHT = new C_DsKrHnnKakCdTtTydnJyKbn("3");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_MGS_JSHT_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("4");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_JSHT = new C_DsKrHnnKakCdTtTydnJyKbn("5");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_JSHT_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("6");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSS_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("7");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_MGS = new C_DsKrHnnKakCdTtTydnJyKbn("8");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_MGS_JSHT = new C_DsKrHnnKakCdTtTydnJyKbn("9");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_MGS_JSHT_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("10");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSHT = new C_DsKrHnnKakCdTtTydnJyKbn("11");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_JSHT_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("12");

    public static final C_DsKrHnnKakCdTtTydnJyKbn NYSHK_MGHT = new C_DsKrHnnKakCdTtTydnJyKbn("13");

    public static final C_DsKrHnnKakCdTtTydnJyKbn KKKSBTY = new C_DsKrHnnKakCdTtTydnJyKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS, "NYSHK_JSS", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_MGS, "NYSHK_JSS_MGS", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_MGS_JSHT, "NYSHK_JSS_MGS_JSHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_MGS_JSHT_MGHT, "NYSHK_JSS_MGS_JSHT_MGHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_JSHT, "NYSHK_JSS_JSHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_JSHT_MGHT, "NYSHK_JSS_JSHT_MGHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSS_MGHT, "NYSHK_JSS_MGHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_MGS, "NYSHK_MGS", false);
        addPattern(PATTERN_DEFAULT, NYSHK_MGS_JSHT, "NYSHK_MGS_JSHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_MGS_JSHT_MGHT, "NYSHK_MGS_JSHT_MGHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSHT, "NYSHK_JSHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_JSHT_MGHT, "NYSHK_JSHT_MGHT", false);
        addPattern(PATTERN_DEFAULT, NYSHK_MGHT, "NYSHK_MGHT", false);
        addPattern(PATTERN_DEFAULT, KKKSBTY, "KKKSBTY", false);


        lock(C_DsKrHnnKakCdTtTydnJyKbn.class);
    }

    private C_DsKrHnnKakCdTtTydnJyKbn(String value) {
        super(value);
    }

    public static C_DsKrHnnKakCdTtTydnJyKbn valueOf(String value) {
        return valueOf(C_DsKrHnnKakCdTtTydnJyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKrHnnKakCdTtTydnJyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKrHnnKakCdTtTydnJyKbn.class, patternId, value);
    }
}
