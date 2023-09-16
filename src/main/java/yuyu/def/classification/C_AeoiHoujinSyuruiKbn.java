
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＥＯＩ法人種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AeoiHoujinSyuruiKbn</td><td colspan="3">ＡＥＯＩ法人種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JOUJOUHOUJIN}</td><td>&quot;1&quot;</td><td>上場法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JOUJOUHOUJINKANREN}</td><td>&quot;2&quot;</td><td>上場法人の関連法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUHOUKOKUKINYUKIKAN}</td><td>&quot;3&quot;</td><td>外国の報告金融機関等</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUNITIHOUKOUKYOUDANTAI}</td><td>&quot;4&quot;</td><td>国・地方公共団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIHOUJIN}</td><td>&quot;5&quot;</td><td>特定法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINCHUU}</td><td>&quot;6&quot;</td><td>法人区分確認中</td></tr>
 * </table>
 */
public class C_AeoiHoujinSyuruiKbn extends Classification<C_AeoiHoujinSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AeoiHoujinSyuruiKbn BLNK = new C_AeoiHoujinSyuruiKbn("0");

    public static final C_AeoiHoujinSyuruiKbn JOUJOUHOUJIN = new C_AeoiHoujinSyuruiKbn("1");

    public static final C_AeoiHoujinSyuruiKbn JOUJOUHOUJINKANREN = new C_AeoiHoujinSyuruiKbn("2");

    public static final C_AeoiHoujinSyuruiKbn GAIKOKUHOUKOKUKINYUKIKAN = new C_AeoiHoujinSyuruiKbn("3");

    public static final C_AeoiHoujinSyuruiKbn KUNITIHOUKOUKYOUDANTAI = new C_AeoiHoujinSyuruiKbn("4");

    public static final C_AeoiHoujinSyuruiKbn TOKUTEIHOUJIN = new C_AeoiHoujinSyuruiKbn("5");

    public static final C_AeoiHoujinSyuruiKbn KAKUNINCHUU = new C_AeoiHoujinSyuruiKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JOUJOUHOUJIN, "JOUJOUHOUJIN", false);
        addPattern(PATTERN_DEFAULT, JOUJOUHOUJINKANREN, "JOUJOUHOUJINKANREN", false);
        addPattern(PATTERN_DEFAULT, GAIKOKUHOUKOKUKINYUKIKAN, "GAIKOKUHOUKOKUKINYUKIKAN", false);
        addPattern(PATTERN_DEFAULT, KUNITIHOUKOUKYOUDANTAI, "KUNITIHOUKOUKYOUDANTAI", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIHOUJIN, "TOKUTEIHOUJIN", false);
        addPattern(PATTERN_DEFAULT, KAKUNINCHUU, "KAKUNINCHUU", false);


        lock(C_AeoiHoujinSyuruiKbn.class);
    }

    private C_AeoiHoujinSyuruiKbn(String value) {
        super(value);
    }

    public static C_AeoiHoujinSyuruiKbn valueOf(String value) {
        return valueOf(C_AeoiHoujinSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AeoiHoujinSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AeoiHoujinSyuruiKbn.class, patternId, value);
    }
}
