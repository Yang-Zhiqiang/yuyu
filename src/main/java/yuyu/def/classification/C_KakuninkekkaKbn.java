
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内容確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KakuninkekkaKbn</td><td colspan="3">内容確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #END}</td><td>&quot;10&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENDKIJIARI}</td><td>&quot;11&quot;</td><td>完了（告知記事あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENDKIJINASI}</td><td>&quot;12&quot;</td><td>完了（告知記事なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;20&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;90&quot;</td><td>不備</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #END}</td><td>&quot;10&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;20&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;90&quot;</td><td>不備</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_HUKKATU HUKKATU}<br />(復活)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENDKIJIARI}</td><td>&quot;11&quot;</td><td>完了（告知記事あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENDKIJINASI}</td><td>&quot;12&quot;</td><td>完了（告知記事なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;20&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELBLNK SELBLNK}<br />(画面用（ブランク）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #END}</td><td>&quot;10&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;20&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_KakuninkekkaKbn extends Classification<C_KakuninkekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KakuninkekkaKbn BLNK = new C_KakuninkekkaKbn("0");

    public static final C_KakuninkekkaKbn END = new C_KakuninkekkaKbn("10");

    public static final C_KakuninkekkaKbn ENDKIJIARI = new C_KakuninkekkaKbn("11");

    public static final C_KakuninkekkaKbn ENDKIJINASI = new C_KakuninkekkaKbn("12");

    public static final C_KakuninkekkaKbn HORYUU = new C_KakuninkekkaKbn("20");

    public static final C_KakuninkekkaKbn HUBI = new C_KakuninkekkaKbn("90");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_HUKKATU = "3";

    public static final String PATTERN_SELBLNK = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, END, "END", false);
        addPattern(PATTERN_DEFAULT, ENDKIJIARI, "ENDKIJIARI", false);
        addPattern(PATTERN_DEFAULT, ENDKIJINASI, "ENDKIJINASI", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);


        addPattern(PATTERN_SELECT, END, "END", true);
        addPattern(PATTERN_SELECT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_SELECT, HUBI, "HUBI", false);


        addPattern(PATTERN_HUKKATU, BLNK, "BLNK", true);
        addPattern(PATTERN_HUKKATU, ENDKIJIARI, "ENDKIJIARI", false);
        addPattern(PATTERN_HUKKATU, ENDKIJINASI, "ENDKIJINASI", false);
        addPattern(PATTERN_HUKKATU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SELBLNK, BLNK, "BLNK", true);
        addPattern(PATTERN_SELBLNK, END, "END", false);
        addPattern(PATTERN_SELBLNK, HORYUU, "HORYUU", false);


        lock(C_KakuninkekkaKbn.class);
    }

    private C_KakuninkekkaKbn(String value) {
        super(value);
    }

    public static C_KakuninkekkaKbn valueOf(String value) {
        return valueOf(C_KakuninkekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KakuninkekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KakuninkekkaKbn.class, patternId, value);
    }
}
