
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 住所変更内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HenadrKbn</td><td colspan="3">住所変更内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRTEL}</td><td>&quot;1&quot;</td><td>住所・電話番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADR}</td><td>&quot;2&quot;</td><td>住所のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEL}</td><td>&quot;3&quot;</td><td>電話番号のみ</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #ADRTEL}</td><td>&quot;1&quot;</td><td>住所・電話番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADR}</td><td>&quot;2&quot;</td><td>住所のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEL}</td><td>&quot;3&quot;</td><td>電話番号のみ</td></tr>
 * </table>
 */
public class C_HenadrKbn extends Classification<C_HenadrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HenadrKbn BLNK = new C_HenadrKbn("0");

    public static final C_HenadrKbn ADRTEL = new C_HenadrKbn("1");

    public static final C_HenadrKbn ADR = new C_HenadrKbn("2");

    public static final C_HenadrKbn TEL = new C_HenadrKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ADRTEL, "ADRTEL", false);
        addPattern(PATTERN_DEFAULT, ADR, "ADR", false);
        addPattern(PATTERN_DEFAULT, TEL, "TEL", false);


        addPattern(PATTERN_NOBLNK, ADRTEL, "ADRTEL", false);
        addPattern(PATTERN_NOBLNK, ADR, "ADR", false);
        addPattern(PATTERN_NOBLNK, TEL, "TEL", false);


        lock(C_HenadrKbn.class);
    }

    private C_HenadrKbn(String value) {
        super(value);
    }

    public static C_HenadrKbn valueOf(String value) {
        return valueOf(C_HenadrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HenadrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HenadrKbn.class, patternId, value);
    }
}
