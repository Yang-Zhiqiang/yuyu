
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 紹介代理店手数料支払区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SykDrtenTsryShrKbn</td><td colspan="3">紹介代理店手数料支払区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKIN}</td><td>&quot;1&quot;</td><td>入金時払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANKAGETU}</td><td>&quot;2&quot;</td><td>３ヵ月払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;3&quot;</td><td>一括払</td></tr>
 * </table>
 */
public class C_SykDrtenTsryShrKbn extends Classification<C_SykDrtenTsryShrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SykDrtenTsryShrKbn BLNK = new C_SykDrtenTsryShrKbn("0");

    public static final C_SykDrtenTsryShrKbn NYUUKIN = new C_SykDrtenTsryShrKbn("1");

    public static final C_SykDrtenTsryShrKbn SANKAGETU = new C_SykDrtenTsryShrKbn("2");

    public static final C_SykDrtenTsryShrKbn IKKATU = new C_SykDrtenTsryShrKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUUKIN, "NYUUKIN", false);
        addPattern(PATTERN_DEFAULT, SANKAGETU, "SANKAGETU", false);
        addPattern(PATTERN_DEFAULT, IKKATU, "IKKATU", false);


        lock(C_SykDrtenTsryShrKbn.class);
    }

    private C_SykDrtenTsryShrKbn(String value) {
        super(value);
    }

    public static C_SykDrtenTsryShrKbn valueOf(String value) {
        return valueOf(C_SykDrtenTsryShrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SykDrtenTsryShrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SykDrtenTsryShrKbn.class, patternId, value);
    }
}
