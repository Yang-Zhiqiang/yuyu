
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備訂正書作成パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HubiteiseiPtnKbn</td><td colspan="3">不備訂正書作成パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QR_KARI_NONE}</td><td>&quot;1&quot;</td><td>ＱＲ・仮表示なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARI_ARI}</td><td>&quot;2&quot;</td><td>仮表示あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QR_ARI}</td><td>&quot;3&quot;</td><td>ＱＲあり</td></tr>
 * </table>
 */
public class C_HubiteiseiPtnKbn extends Classification<C_HubiteiseiPtnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HubiteiseiPtnKbn BLNK = new C_HubiteiseiPtnKbn("0");

    public static final C_HubiteiseiPtnKbn QR_KARI_NONE = new C_HubiteiseiPtnKbn("1");

    public static final C_HubiteiseiPtnKbn KARI_ARI = new C_HubiteiseiPtnKbn("2");

    public static final C_HubiteiseiPtnKbn QR_ARI = new C_HubiteiseiPtnKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, QR_KARI_NONE, "QR_KARI_NONE", false);
        addPattern(PATTERN_DEFAULT, KARI_ARI, "KARI_ARI", false);
        addPattern(PATTERN_DEFAULT, QR_ARI, "QR_ARI", false);


        lock(C_HubiteiseiPtnKbn.class);
    }

    private C_HubiteiseiPtnKbn(String value) {
        super(value);
    }

    public static C_HubiteiseiPtnKbn valueOf(String value) {
        return valueOf(C_HubiteiseiPtnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HubiteiseiPtnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HubiteiseiPtnKbn.class, patternId, value);
    }
}
