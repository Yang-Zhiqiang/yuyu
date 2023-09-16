
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替口座区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HurikzKbn</td><td colspan="3">振替口座区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJIN}</td><td>&quot;1&quot;</td><td>個人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;2&quot;</td><td>団体</td></tr>
 * </table>
 */
public class C_HurikzKbn extends Classification<C_HurikzKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HurikzKbn BLNK = new C_HurikzKbn("0");

    public static final C_HurikzKbn KOJIN = new C_HurikzKbn("1");

    public static final C_HurikzKbn DANTAI = new C_HurikzKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOJIN, "KOJIN", false);
        addPattern(PATTERN_DEFAULT, DANTAI, "DANTAI", false);


        lock(C_HurikzKbn.class);
    }

    private C_HurikzKbn(String value) {
        super(value);
    }

    public static C_HurikzKbn valueOf(String value) {
        return valueOf(C_HurikzKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HurikzKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HurikzKbn.class, patternId, value);
    }
}
