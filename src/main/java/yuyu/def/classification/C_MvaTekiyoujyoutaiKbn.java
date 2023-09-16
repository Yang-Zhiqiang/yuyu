
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＶＡ適用状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MvaTekiyoujyoutaiKbn</td><td colspan="3">ＭＶＡ適用状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MVAARI}</td><td>&quot;1&quot;</td><td>ＭＶＡ適用あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MVAARINONE}</td><td>&quot;2&quot;</td><td>ＭＶＡ適用あり・なし混在</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MVANONE}</td><td>&quot;3&quot;</td><td>ＭＶＡ適用なし</td></tr>
 * </table>
 */
public class C_MvaTekiyoujyoutaiKbn extends Classification<C_MvaTekiyoujyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MvaTekiyoujyoutaiKbn BLNK = new C_MvaTekiyoujyoutaiKbn("0");

    public static final C_MvaTekiyoujyoutaiKbn MVAARI = new C_MvaTekiyoujyoutaiKbn("1");

    public static final C_MvaTekiyoujyoutaiKbn MVAARINONE = new C_MvaTekiyoujyoutaiKbn("2");

    public static final C_MvaTekiyoujyoutaiKbn MVANONE = new C_MvaTekiyoujyoutaiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MVAARI, "MVAARI", false);
        addPattern(PATTERN_DEFAULT, MVAARINONE, "MVAARINONE", false);
        addPattern(PATTERN_DEFAULT, MVANONE, "MVANONE", false);


        lock(C_MvaTekiyoujyoutaiKbn.class);
    }

    private C_MvaTekiyoujyoutaiKbn(String value) {
        super(value);
    }

    public static C_MvaTekiyoujyoutaiKbn valueOf(String value) {
        return valueOf(C_MvaTekiyoujyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MvaTekiyoujyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MvaTekiyoujyoutaiKbn.class, patternId, value);
    }
}
