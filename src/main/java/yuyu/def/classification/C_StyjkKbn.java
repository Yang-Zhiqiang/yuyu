
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StyjkKbn</td><td colspan="3">進捗状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;1&quot;</td><td>申込受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;2&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;3&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU}</td><td>&quot;4&quot;</td><td>不成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAKUHI}</td><td>&quot;5&quot;</td><td>査定結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTHRKMKNRY}</td><td>&quot;6&quot;</td><td>初回振替完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRTU_KNSHZM}</td><td>&quot;7&quot;</td><td>不成立・Re勧奨済み</td></tr>
 * </table>
 */
public class C_StyjkKbn extends Classification<C_StyjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StyjkKbn BLNK = new C_StyjkKbn("0");

    public static final C_StyjkKbn MOS = new C_StyjkKbn("1");

    public static final C_StyjkKbn HUBI = new C_StyjkKbn("2");

    public static final C_StyjkKbn SEIRITU = new C_StyjkKbn("3");

    public static final C_StyjkKbn HUSEIRITU = new C_StyjkKbn("4");

    public static final C_StyjkKbn DAKUHI = new C_StyjkKbn("5");

    public static final C_StyjkKbn FSTHRKMKNRY = new C_StyjkKbn("6");

    public static final C_StyjkKbn HUSEIRTU_KNSHZM = new C_StyjkKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, HUSEIRITU, "HUSEIRITU", false);
        addPattern(PATTERN_DEFAULT, DAKUHI, "DAKUHI", false);
        addPattern(PATTERN_DEFAULT, FSTHRKMKNRY, "FSTHRKMKNRY", false);
        addPattern(PATTERN_DEFAULT, HUSEIRTU_KNSHZM, "HUSEIRTU_KNSHZM", false);


        lock(C_StyjkKbn.class);
    }

    private C_StyjkKbn(String value) {
        super(value);
    }

    public static C_StyjkKbn valueOf(String value) {
        return valueOf(C_StyjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StyjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StyjkKbn.class, patternId, value);
    }
}
