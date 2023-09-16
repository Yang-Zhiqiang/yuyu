
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替伝票ページ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HuridenpageKbn</td><td colspan="3">振替伝票ページ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OIKOMITYOUSEI}</td><td>&quot;10&quot;</td><td>追込契約集計表（調整伝票）</td></tr>
 * </table>
 */
public class C_HuridenpageKbn extends Classification<C_HuridenpageKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HuridenpageKbn BLNK = new C_HuridenpageKbn("0");

    public static final C_HuridenpageKbn OIKOMITYOUSEI = new C_HuridenpageKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OIKOMITYOUSEI, "OIKOMITYOUSEI", false);


        lock(C_HuridenpageKbn.class);
    }

    private C_HuridenpageKbn(String value) {
        super(value);
    }

    public static C_HuridenpageKbn valueOf(String value) {
        return valueOf(C_HuridenpageKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HuridenpageKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HuridenpageKbn.class, patternId, value);
    }
}
