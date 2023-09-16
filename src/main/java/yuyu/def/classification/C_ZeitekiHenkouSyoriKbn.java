
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 税適特約変更処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZeitekiHenkouSyoriKbn</td><td colspan="3">税適特約変更処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HUKA}</td><td>&quot;1&quot;</td><td>付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_ZeitekiHenkouSyoriKbn extends Classification<C_ZeitekiHenkouSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZeitekiHenkouSyoriKbn HUKA = new C_ZeitekiHenkouSyoriKbn("1");

    public static final C_ZeitekiHenkouSyoriKbn SYOUMETU = new C_ZeitekiHenkouSyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", true);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_ZeitekiHenkouSyoriKbn.class);
    }

    private C_ZeitekiHenkouSyoriKbn(String value) {
        super(value);
    }

    public static C_ZeitekiHenkouSyoriKbn valueOf(String value) {
        return valueOf(C_ZeitekiHenkouSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZeitekiHenkouSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZeitekiHenkouSyoriKbn.class, patternId, value);
    }
}
