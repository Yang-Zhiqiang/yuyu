
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 共同扱区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyoudouatukaiKbn</td><td colspan="3">共同扱区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BNTN_NASI}</td><td>&quot;0&quot;</td><td>分担なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRTEN}</td><td>&quot;1&quot;</td><td>Ａ代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BDRTEN}</td><td>&quot;2&quot;</td><td>Ｂ代理店</td></tr>
 * </table>
 */
public class C_KyoudouatukaiKbn extends Classification<C_KyoudouatukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyoudouatukaiKbn BNTN_NASI = new C_KyoudouatukaiKbn("0");

    public static final C_KyoudouatukaiKbn ADRTEN = new C_KyoudouatukaiKbn("1");

    public static final C_KyoudouatukaiKbn BDRTEN = new C_KyoudouatukaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BNTN_NASI, "BNTN_NASI", true);
        addPattern(PATTERN_DEFAULT, ADRTEN, "ADRTEN", false);
        addPattern(PATTERN_DEFAULT, BDRTEN, "BDRTEN", false);


        lock(C_KyoudouatukaiKbn.class);
    }

    private C_KyoudouatukaiKbn(String value) {
        super(value);
    }

    public static C_KyoudouatukaiKbn valueOf(String value) {
        return valueOf(C_KyoudouatukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyoudouatukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyoudouatukaiKbn.class, patternId, value);
    }
}
