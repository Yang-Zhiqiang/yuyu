
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全請求書作成事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Khskssakuseijiyuu</td><td colspan="3">契約保全請求書作成事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAMOUSIDE}</td><td>&quot;1&quot;</td><td>お客さま申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOBETUKANSYOU}</td><td>&quot;2&quot;</td><td>個別勧奨</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #OKYAKUSAMAMOUSIDE}</td><td>&quot;1&quot;</td><td>お客さま申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOBETUKANSYOU}</td><td>&quot;2&quot;</td><td>個別勧奨</td></tr>
 * </table>
 */
public class C_Khskssakuseijiyuu extends Classification<C_Khskssakuseijiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Khskssakuseijiyuu BLNK = new C_Khskssakuseijiyuu("0");

    public static final C_Khskssakuseijiyuu OKYAKUSAMAMOUSIDE = new C_Khskssakuseijiyuu("1");

    public static final C_Khskssakuseijiyuu KOBETUKANSYOU = new C_Khskssakuseijiyuu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAMOUSIDE, "OKYAKUSAMAMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, KOBETUKANSYOU, "KOBETUKANSYOU", false);


        addPattern(PATTERN_SELECT, OKYAKUSAMAMOUSIDE, "OKYAKUSAMAMOUSIDE", true);
        addPattern(PATTERN_SELECT, KOBETUKANSYOU, "KOBETUKANSYOU", false);


        lock(C_Khskssakuseijiyuu.class);
    }

    private C_Khskssakuseijiyuu(String value) {
        super(value);
    }

    public static C_Khskssakuseijiyuu valueOf(String value) {
        return valueOf(C_Khskssakuseijiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Khskssakuseijiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Khskssakuseijiyuu.class, patternId, value);
    }
}
