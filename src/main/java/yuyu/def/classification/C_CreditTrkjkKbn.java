
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカード登録状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditTrkjkKbn</td><td colspan="3">クレジットカード登録状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUTYUU}</td><td>&quot;1&quot;</td><td>登録中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;2&quot;</td><td>登録済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;3&quot;</td><td>登録ＮＧ</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOKANA NOKANA}<br />(送りかな無)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUTYUU}</td><td>&quot;1&quot;</td><td>登録中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;2&quot;</td><td>登録済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NG}</td><td>&quot;3&quot;</td><td>登録ＮＧ</td></tr>
 * </table>
 */
public class C_CreditTrkjkKbn extends Classification<C_CreditTrkjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditTrkjkKbn BLNK = new C_CreditTrkjkKbn("0");

    public static final C_CreditTrkjkKbn TOUROKUTYUU = new C_CreditTrkjkKbn("1");

    public static final C_CreditTrkjkKbn SUMI = new C_CreditTrkjkKbn("2");

    public static final C_CreditTrkjkKbn NG = new C_CreditTrkjkKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOKANA = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKUTYUU, "TOUROKUTYUU", false);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);
        addPattern(PATTERN_DEFAULT, NG, "NG", false);


        addPattern(PATTERN_NOKANA, BLNK, "BLNK", true);
        addPattern(PATTERN_NOKANA, TOUROKUTYUU, "TOUROKUTYUU", false);
        addPattern(PATTERN_NOKANA, SUMI, "SUMI", false);
        addPattern(PATTERN_NOKANA, NG, "NG", false);


        lock(C_CreditTrkjkKbn.class);
    }

    private C_CreditTrkjkKbn(String value) {
        super(value);
    }

    public static C_CreditTrkjkKbn valueOf(String value) {
        return valueOf(C_CreditTrkjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditTrkjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditTrkjkKbn.class, patternId, value);
    }
}
