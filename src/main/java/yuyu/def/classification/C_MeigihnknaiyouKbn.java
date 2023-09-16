
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名義変更内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MeigihnknaiyouKbn</td><td colspan="3">名義変更内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENARI}</td><td>&quot;1&quot;</td><td>契約者の変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENNASI}</td><td>&quot;2&quot;</td><td>契約者の変更はなし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEI}</td><td>&quot;3&quot;</td><td>契約者の改姓・改名</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_HYOUJI HYOUJI}<br />(表示用)</td><td align="center">○</td><td>{@link #HENARI}</td><td>&quot;1&quot;</td><td>契約者の変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEI}</td><td>&quot;3&quot;</td><td>契約者の改姓・改名</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENNASI}</td><td>&quot;2&quot;</td><td>左記以外（契約者の変更はなし）</td></tr>
 * </table>
 */
public class C_MeigihnknaiyouKbn extends Classification<C_MeigihnknaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MeigihnknaiyouKbn BLNK = new C_MeigihnknaiyouKbn("0");

    public static final C_MeigihnknaiyouKbn HENARI = new C_MeigihnknaiyouKbn("1");

    public static final C_MeigihnknaiyouKbn HENNASI = new C_MeigihnknaiyouKbn("2");

    public static final C_MeigihnknaiyouKbn KAISEI = new C_MeigihnknaiyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HENARI, "HENARI", false);
        addPattern(PATTERN_DEFAULT, HENNASI, "HENNASI", false);
        addPattern(PATTERN_DEFAULT, KAISEI, "KAISEI", false);


        addPattern(PATTERN_HYOUJI, HENARI, "HENARI", true);
        addPattern(PATTERN_HYOUJI, KAISEI, "KAISEI", false);
        addPattern(PATTERN_HYOUJI, HENNASI, "HENNASI", false);


        lock(C_MeigihnknaiyouKbn.class);
    }

    private C_MeigihnknaiyouKbn(String value) {
        super(value);
    }

    public static C_MeigihnknaiyouKbn valueOf(String value) {
        return valueOf(C_MeigihnknaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MeigihnknaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MeigihnknaiyouKbn.class, patternId, value);
    }
}
