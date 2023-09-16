
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 未収未経過計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MsymkeipksnKbn</td><td colspan="3">未収未経過計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEI}</td><td>&quot;1&quot;</td><td>控除証明</td></tr>
 * </table>
 */
public class C_MsymkeipksnKbn extends Classification<C_MsymkeipksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MsymkeipksnKbn BLNK = new C_MsymkeipksnKbn("0");

    public static final C_MsymkeipksnKbn KOUJYOSYOUMEI = new C_MsymkeipksnKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEI, "KOUJYOSYOUMEI", false);


        lock(C_MsymkeipksnKbn.class);
    }

    private C_MsymkeipksnKbn(String value) {
        super(value);
    }

    public static C_MsymkeipksnKbn valueOf(String value) {
        return valueOf(C_MsymkeipksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MsymkeipksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MsymkeipksnKbn.class, patternId, value);
    }
}
