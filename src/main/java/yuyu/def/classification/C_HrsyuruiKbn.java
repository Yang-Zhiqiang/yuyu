
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 返戻金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrsyuruiKbn</td><td colspan="3">返戻金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAU_HENREI}</td><td>&quot;1&quot;</td><td>解約返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_HENREI}</td><td>&quot;2&quot;</td><td>その他返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA_HENREI_PHENKIN}</td><td>&quot;3&quot;</td><td>その他返戻金（Ｐ返金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHENREI}</td><td>&quot;4&quot;</td><td>円建変更時返戻金</td></tr>
 * </table>
 */
public class C_HrsyuruiKbn extends Classification<C_HrsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrsyuruiKbn BLNK = new C_HrsyuruiKbn("0");

    public static final C_HrsyuruiKbn KAIYAU_HENREI = new C_HrsyuruiKbn("1");

    public static final C_HrsyuruiKbn SONOTA_HENREI = new C_HrsyuruiKbn("2");

    public static final C_HrsyuruiKbn SONOTA_HENREI_PHENKIN = new C_HrsyuruiKbn("3");

    public static final C_HrsyuruiKbn YENDTHNKHENREI = new C_HrsyuruiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAU_HENREI, "KAIYAU_HENREI", false);
        addPattern(PATTERN_DEFAULT, SONOTA_HENREI, "SONOTA_HENREI", false);
        addPattern(PATTERN_DEFAULT, SONOTA_HENREI_PHENKIN, "SONOTA_HENREI_PHENKIN", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHENREI, "YENDTHNKHENREI", false);


        lock(C_HrsyuruiKbn.class);
    }

    private C_HrsyuruiKbn(String value) {
        super(value);
    }

    public static C_HrsyuruiKbn valueOf(String value) {
        return valueOf(C_HrsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrsyuruiKbn.class, patternId, value);
    }
}
