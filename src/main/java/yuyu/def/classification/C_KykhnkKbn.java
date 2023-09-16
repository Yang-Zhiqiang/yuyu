
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykhnkKbn</td><td colspan="3">契約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;1&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;2&quot;</td><td>減額</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOKAI NOKAI}<br />(解約なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;2&quot;</td><td>減額</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOGEN NOGEN}<br />(減額なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;1&quot;</td><td>解約</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_NOKAINOBLNK NOKAINOBLNK}<br />(ブランク解約なし)</td><td align="center">○</td><td>{@link #GENGAKU}</td><td>&quot;2&quot;</td><td>減額</td></tr>
 * </table>
 */
public class C_KykhnkKbn extends Classification<C_KykhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykhnkKbn BLNK = new C_KykhnkKbn("0");

    public static final C_KykhnkKbn KAIYAKU = new C_KykhnkKbn("1");

    public static final C_KykhnkKbn GENGAKU = new C_KykhnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOKAI = "2";

    public static final String PATTERN_NOGEN = "3";

    public static final String PATTERN_NOKAINOBLNK = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);


        addPattern(PATTERN_NOKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_NOKAI, GENGAKU, "GENGAKU", false);


        addPattern(PATTERN_NOGEN, BLNK, "BLNK", true);
        addPattern(PATTERN_NOGEN, KAIYAKU, "KAIYAKU", false);


        addPattern(PATTERN_NOKAINOBLNK, GENGAKU, "GENGAKU", true);


        lock(C_KykhnkKbn.class);
    }

    private C_KykhnkKbn(String value) {
        super(value);
    }

    public static C_KykhnkKbn valueOf(String value) {
        return valueOf(C_KykhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykhnkKbn.class, patternId, value);
    }
}
