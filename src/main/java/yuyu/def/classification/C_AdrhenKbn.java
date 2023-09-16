
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 住所変更対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AdrhenKbn</td><td colspan="3">住所変更対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHHKN}</td><td>&quot;1&quot;</td><td>契約者・被保険者の両方</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKNOMI}</td><td>&quot;2&quot;</td><td>契約者のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNNOMI}</td><td>&quot;3&quot;</td><td>被保険者のみ</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #KYKHHKN}</td><td>&quot;1&quot;</td><td>契約者・被保険者の両方</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKNOMI}</td><td>&quot;2&quot;</td><td>契約者のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNNOMI}</td><td>&quot;3&quot;</td><td>被保険者のみ</td></tr>
 * </table>
 */
public class C_AdrhenKbn extends Classification<C_AdrhenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AdrhenKbn BLNK = new C_AdrhenKbn("0");

    public static final C_AdrhenKbn KYKHHKN = new C_AdrhenKbn("1");

    public static final C_AdrhenKbn KYKNOMI = new C_AdrhenKbn("2");

    public static final C_AdrhenKbn HHKNNOMI = new C_AdrhenKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKHHKN, "KYKHHKN", false);
        addPattern(PATTERN_DEFAULT, KYKNOMI, "KYKNOMI", false);
        addPattern(PATTERN_DEFAULT, HHKNNOMI, "HHKNNOMI", false);


        addPattern(PATTERN_NOBLNK, KYKHHKN, "KYKHHKN", true);
        addPattern(PATTERN_NOBLNK, KYKNOMI, "KYKNOMI", false);
        addPattern(PATTERN_NOBLNK, HHKNNOMI, "HHKNNOMI", false);


        lock(C_AdrhenKbn.class);
    }

    private C_AdrhenKbn(String value) {
        super(value);
    }

    public static C_AdrhenKbn valueOf(String value) {
        return valueOf(C_AdrhenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AdrhenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AdrhenKbn.class, patternId, value);
    }
}
