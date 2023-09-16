
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納精算処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennouSeisanSyoriKbn</td><td colspan="3">前納精算処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;1&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_ZennouSeisanSyoriKbn extends Classification<C_ZennouSeisanSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennouSeisanSyoriKbn BLNK = new C_ZennouSeisanSyoriKbn("0");

    public static final C_ZennouSeisanSyoriKbn GENGAKU = new C_ZennouSeisanSyoriKbn("1");

    public static final C_ZennouSeisanSyoriKbn SYOUMETU = new C_ZennouSeisanSyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_ZennouSeisanSyoriKbn.class);
    }

    private C_ZennouSeisanSyoriKbn(String value) {
        super(value);
    }

    public static C_ZennouSeisanSyoriKbn valueOf(String value) {
        return valueOf(C_ZennouSeisanSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennouSeisanSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennouSeisanSyoriKbn.class, patternId, value);
    }
}
