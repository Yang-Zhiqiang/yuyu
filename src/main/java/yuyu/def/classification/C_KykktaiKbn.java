
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約形態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykktaiKbn</td><td colspan="3">契約形態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKO}</td><td>&quot;2&quot;</td><td>自己</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEI}</td><td>&quot;3&quot;</td><td>特定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSEIIN}</td><td>&quot;4&quot;</td><td>構成員</td></tr>
 * </table>
 */
public class C_KykktaiKbn extends Classification<C_KykktaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykktaiKbn BLNK = new C_KykktaiKbn("0");

    public static final C_KykktaiKbn TUUJYOU = new C_KykktaiKbn("1");

    public static final C_KykktaiKbn JIKO = new C_KykktaiKbn("2");

    public static final C_KykktaiKbn TOKUTEI = new C_KykktaiKbn("3");

    public static final C_KykktaiKbn KOUSEIIN = new C_KykktaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, JIKO, "JIKO", false);
        addPattern(PATTERN_DEFAULT, TOKUTEI, "TOKUTEI", false);
        addPattern(PATTERN_DEFAULT, KOUSEIIN, "KOUSEIIN", false);


        lock(C_KykktaiKbn.class);
    }

    private C_KykktaiKbn(String value) {
        super(value);
    }

    public static C_KykktaiKbn valueOf(String value) {
        return valueOf(C_KykktaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykktaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykktaiKbn.class, patternId, value);
    }
}
