
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 第三分野Ｓ計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_3rdsecsksnKbn</td><td colspan="3">第三分野Ｓ計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>計算しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONS_DOUGAKU}</td><td>&quot;1&quot;</td><td>基本Ｓと同額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNSHRGNDGK}</td><td>&quot;11&quot;</td><td>通算支払限度額（基本Ｓと異なる）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NICHIGAKU}</td><td>&quot;21&quot;</td><td>日額（基本Ｓと型区分で計算）</td></tr>
 * </table>
 */
public class C_3rdsecsksnKbn extends Classification<C_3rdsecsksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_3rdsecsksnKbn BLNK = new C_3rdsecsksnKbn("0");

    public static final C_3rdsecsksnKbn KIHONS_DOUGAKU = new C_3rdsecsksnKbn("1");

    public static final C_3rdsecsksnKbn TSNSHRGNDGK = new C_3rdsecsksnKbn("11");

    public static final C_3rdsecsksnKbn NICHIGAKU = new C_3rdsecsksnKbn("21");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KIHONS_DOUGAKU, "KIHONS_DOUGAKU", false);
        addPattern(PATTERN_DEFAULT, TSNSHRGNDGK, "TSNSHRGNDGK", false);
        addPattern(PATTERN_DEFAULT, NICHIGAKU, "NICHIGAKU", false);


        lock(C_3rdsecsksnKbn.class);
    }

    private C_3rdsecsksnKbn(String value) {
        super(value);
    }

    public static C_3rdsecsksnKbn valueOf(String value) {
        return valueOf(C_3rdsecsksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_3rdsecsksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_3rdsecsksnKbn.class, patternId, value);
    }
}
