
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 口座種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouzasyuruiKbn</td><td colspan="3">口座種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENKOUZA}</td><td>&quot;1&quot;</td><td>円口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAKOUZA}</td><td>&quot;2&quot;</td><td>外貨口座</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SHKSTKZ SHKSTKZ}<br />(支払金指定口座)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENKOUZA}</td><td>&quot;1&quot;</td><td>円貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAKOUZA}</td><td>&quot;2&quot;</td><td>指定通貨</td></tr>
 * </table>
 */
public class C_KouzasyuruiKbn extends Classification<C_KouzasyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouzasyuruiKbn BLNK = new C_KouzasyuruiKbn("0");

    public static final C_KouzasyuruiKbn YENKOUZA = new C_KouzasyuruiKbn("1");

    public static final C_KouzasyuruiKbn GAIKAKOUZA = new C_KouzasyuruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SHKSTKZ = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENKOUZA, "YENKOUZA", false);
        addPattern(PATTERN_DEFAULT, GAIKAKOUZA, "GAIKAKOUZA", false);


        addPattern(PATTERN_SHKSTKZ, BLNK, "BLNK", true);
        addPattern(PATTERN_SHKSTKZ, YENKOUZA, "YENKOUZA", false);
        addPattern(PATTERN_SHKSTKZ, GAIKAKOUZA, "GAIKAKOUZA", false);


        lock(C_KouzasyuruiKbn.class);
    }

    private C_KouzasyuruiKbn(String value) {
        super(value);
    }

    public static C_KouzasyuruiKbn valueOf(String value) {
        return valueOf(C_KouzasyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouzasyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouzasyuruiKbn.class, patternId, value);
    }
}
