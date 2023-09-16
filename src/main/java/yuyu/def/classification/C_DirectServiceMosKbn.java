
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ダイレクトサービス申込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DirectServiceMosKbn</td><td colspan="3">ダイレクトサービス申込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NOENTRY}</td><td>&quot;0&quot;</td><td>申し込まない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTRY}</td><td>&quot;1&quot;</td><td>申し込む</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CHECK}</td><td>&quot;2&quot;</td><td>後続事務で確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_MOS MOS}<br />(申込書入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENTRY}</td><td>&quot;1&quot;</td><td>申し込む</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOENTRY}</td><td>&quot;0&quot;</td><td>申し込まない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CHECK}</td><td>&quot;2&quot;</td><td>後続事務で確認</td></tr>
 * </table>
 */
public class C_DirectServiceMosKbn extends Classification<C_DirectServiceMosKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DirectServiceMosKbn NOENTRY = new C_DirectServiceMosKbn("0");

    public static final C_DirectServiceMosKbn ENTRY = new C_DirectServiceMosKbn("1");

    public static final C_DirectServiceMosKbn CHECK = new C_DirectServiceMosKbn("2");

    public static final C_DirectServiceMosKbn BLNK = new C_DirectServiceMosKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MOS = "2";


    static {

        addPattern(PATTERN_DEFAULT, NOENTRY, "NOENTRY", true);
        addPattern(PATTERN_DEFAULT, ENTRY, "ENTRY", false);
        addPattern(PATTERN_DEFAULT, CHECK, "CHECK", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);


        addPattern(PATTERN_MOS, BLNK, "BLNK", true);
        addPattern(PATTERN_MOS, ENTRY, "ENTRY", false);
        addPattern(PATTERN_MOS, NOENTRY, "NOENTRY", false);
        addPattern(PATTERN_MOS, CHECK, "CHECK", false);


        lock(C_DirectServiceMosKbn.class);
    }

    private C_DirectServiceMosKbn(String value) {
        super(value);
    }

    public static C_DirectServiceMosKbn valueOf(String value) {
        return valueOf(C_DirectServiceMosKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DirectServiceMosKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DirectServiceMosKbn.class, patternId, value);
    }
}
