
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取消請求理由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Trksseikyuuriyuu</td><td colspan="3">取消請求理由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKUMOUSIDE}</td><td>&quot;1&quot;</td><td>顧客申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUJYOU_HUSYOUDAKU}</td><td>&quot;2&quot;</td><td>特条不承諾</td></tr>
 * </table>
 */
public class C_Trksseikyuuriyuu extends Classification<C_Trksseikyuuriyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Trksseikyuuriyuu BLNK = new C_Trksseikyuuriyuu("0");

    public static final C_Trksseikyuuriyuu KOKYAKUMOUSIDE = new C_Trksseikyuuriyuu("1");

    public static final C_Trksseikyuuriyuu TOKUJYOU_HUSYOUDAKU = new C_Trksseikyuuriyuu("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOKYAKUMOUSIDE, "KOKYAKUMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, TOKUJYOU_HUSYOUDAKU, "TOKUJYOU_HUSYOUDAKU", false);


        lock(C_Trksseikyuuriyuu.class);
    }

    private C_Trksseikyuuriyuu(String value) {
        super(value);
    }

    public static C_Trksseikyuuriyuu valueOf(String value) {
        return valueOf(C_Trksseikyuuriyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Trksseikyuuriyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Trksseikyuuriyuu.class, patternId, value);
    }
}
