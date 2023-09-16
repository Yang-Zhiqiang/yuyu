
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分割方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BunkatuHouhouKbn</td><td colspan="3">分割方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI}</td><td>&quot;1&quot;</td><td>割合指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINTOUWARI}</td><td>&quot;2&quot;</td><td>均等割</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #WARIAI}</td><td>&quot;1&quot;</td><td>割合指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINTOUWARI}</td><td>&quot;2&quot;</td><td>均等割</td></tr>
 * </table>
 */
public class C_BunkatuHouhouKbn extends Classification<C_BunkatuHouhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BunkatuHouhouKbn BLNK = new C_BunkatuHouhouKbn("0");

    public static final C_BunkatuHouhouKbn WARIAI = new C_BunkatuHouhouKbn("1");

    public static final C_BunkatuHouhouKbn KINTOUWARI = new C_BunkatuHouhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WARIAI, "WARIAI", false);
        addPattern(PATTERN_DEFAULT, KINTOUWARI, "KINTOUWARI", false);


        addPattern(PATTERN_NOBLNK, WARIAI, "WARIAI", true);
        addPattern(PATTERN_NOBLNK, KINTOUWARI, "KINTOUWARI", false);


        lock(C_BunkatuHouhouKbn.class);
    }

    private C_BunkatuHouhouKbn(String value) {
        super(value);
    }

    public static C_BunkatuHouhouKbn valueOf(String value) {
        return valueOf(C_BunkatuHouhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BunkatuHouhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BunkatuHouhouKbn.class, patternId, value);
    }
}
