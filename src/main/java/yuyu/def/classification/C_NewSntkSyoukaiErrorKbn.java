
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新選択情報照会エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NewSntkSyoukaiErrorKbn</td><td colspan="3">新選択情報照会エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIOK}</td><td>&quot;1&quot;</td><td>照会ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIERROR}</td><td>&quot;2&quot;</td><td>照会エラー</td></tr>
 * </table>
 */
public class C_NewSntkSyoukaiErrorKbn extends Classification<C_NewSntkSyoukaiErrorKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NewSntkSyoukaiErrorKbn BLNK = new C_NewSntkSyoukaiErrorKbn("0");

    public static final C_NewSntkSyoukaiErrorKbn SYOUKAIOK = new C_NewSntkSyoukaiErrorKbn("1");

    public static final C_NewSntkSyoukaiErrorKbn SYOUKAIERROR = new C_NewSntkSyoukaiErrorKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKAIOK, "SYOUKAIOK", false);
        addPattern(PATTERN_DEFAULT, SYOUKAIERROR, "SYOUKAIERROR", false);


        lock(C_NewSntkSyoukaiErrorKbn.class);
    }

    private C_NewSntkSyoukaiErrorKbn(String value) {
        super(value);
    }

    public static C_NewSntkSyoukaiErrorKbn valueOf(String value) {
        return valueOf(C_NewSntkSyoukaiErrorKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NewSntkSyoukaiErrorKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NewSntkSyoukaiErrorKbn.class, patternId, value);
    }
}
