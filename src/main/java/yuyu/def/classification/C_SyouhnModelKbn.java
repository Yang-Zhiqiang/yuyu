
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 商品モデル区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouhnModelKbn</td><td colspan="3">商品モデル区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJIHSY}</td><td>&quot;1&quot;</td><td>即時保障型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKUBLEND}</td><td>&quot;2&quot;</td><td>変額ブレンド型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAITOSIUKTR}</td><td>&quot;3&quot;</td><td>毎年受取型</td></tr>
 * </table>
 */
public class C_SyouhnModelKbn extends Classification<C_SyouhnModelKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouhnModelKbn BLNK = new C_SyouhnModelKbn("0");

    public static final C_SyouhnModelKbn SOKUJIHSY = new C_SyouhnModelKbn("1");

    public static final C_SyouhnModelKbn HENGAKUBLEND = new C_SyouhnModelKbn("2");

    public static final C_SyouhnModelKbn MAITOSIUKTR = new C_SyouhnModelKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOKUJIHSY, "SOKUJIHSY", false);
        addPattern(PATTERN_DEFAULT, HENGAKUBLEND, "HENGAKUBLEND", false);
        addPattern(PATTERN_DEFAULT, MAITOSIUKTR, "MAITOSIUKTR", false);


        lock(C_SyouhnModelKbn.class);
    }

    private C_SyouhnModelKbn(String value) {
        super(value);
    }

    public static C_SyouhnModelKbn valueOf(String value) {
        return valueOf(C_SyouhnModelKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouhnModelKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouhnModelKbn.class, patternId, value);
    }
}
