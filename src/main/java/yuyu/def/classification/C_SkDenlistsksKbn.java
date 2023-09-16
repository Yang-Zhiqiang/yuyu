
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約伝票リスト作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkDenlistsksKbn</td><td colspan="3">新契約伝票リスト作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUMATUSIME}</td><td>&quot;1&quot;</td><td>月末〆</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DENPYOUSIME}</td><td>&quot;2&quot;</td><td>伝票〆</td></tr>
 * </table>
 */
public class C_SkDenlistsksKbn extends Classification<C_SkDenlistsksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkDenlistsksKbn BLNK = new C_SkDenlistsksKbn("0");

    public static final C_SkDenlistsksKbn GETUMATUSIME = new C_SkDenlistsksKbn("1");

    public static final C_SkDenlistsksKbn DENPYOUSIME = new C_SkDenlistsksKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GETUMATUSIME, "GETUMATUSIME", false);
        addPattern(PATTERN_DEFAULT, DENPYOUSIME, "DENPYOUSIME", false);


        lock(C_SkDenlistsksKbn.class);
    }

    private C_SkDenlistsksKbn(String value) {
        super(value);
    }

    public static C_SkDenlistsksKbn valueOf(String value) {
        return valueOf(C_SkDenlistsksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkDenlistsksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkDenlistsksKbn.class, patternId, value);
    }
}
