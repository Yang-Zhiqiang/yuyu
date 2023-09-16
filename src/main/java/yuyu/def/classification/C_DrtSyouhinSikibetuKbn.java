
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店商品識別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtSyouhinSikibetuKbn</td><td colspan="3">代理店商品識別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #GONENRISAHAITOUSITEITUUKASYSNITIJI}</td><td>&quot;64&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GONENRISAHAITOUSITEITUUKASYSNITIJI19}</td><td>&quot;65&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GONENRISAHAITOUSITEITUUKAKJNNKITIJI}</td><td>&quot;36&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK}</td><td>&quot;37&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GONENRISAHAITOUSITEITUUKAKJNNKITIJI20}</td><td>&quot;38&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKYKHRKNGONENRISAHAITOUSNTKTUUKATKBTSYSN}</td><td>&quot;66&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 * </table>
 */
public class C_DrtSyouhinSikibetuKbn extends Classification<C_DrtSyouhinSikibetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtSyouhinSikibetuKbn GONENRISAHAITOUSITEITUUKASYSNITIJI = new C_DrtSyouhinSikibetuKbn("64");

    public static final C_DrtSyouhinSikibetuKbn GONENRISAHAITOUSITEITUUKASYSNITIJI19 = new C_DrtSyouhinSikibetuKbn("65");

    public static final C_DrtSyouhinSikibetuKbn GONENRISAHAITOUSITEITUUKAKJNNKITIJI = new C_DrtSyouhinSikibetuKbn("36");

    public static final C_DrtSyouhinSikibetuKbn YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK = new C_DrtSyouhinSikibetuKbn("37");

    public static final C_DrtSyouhinSikibetuKbn GONENRISAHAITOUSITEITUUKAKJNNKITIJI20 = new C_DrtSyouhinSikibetuKbn("38");

    public static final C_DrtSyouhinSikibetuKbn TEIKYKHRKNGONENRISAHAITOUSNTKTUUKATKBTSYSN = new C_DrtSyouhinSikibetuKbn("66");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, GONENRISAHAITOUSITEITUUKASYSNITIJI, "GONENRISAHAITOUSITEITUUKASYSNITIJI", true);
        addPattern(PATTERN_DEFAULT, GONENRISAHAITOUSITEITUUKASYSNITIJI19, "GONENRISAHAITOUSITEITUUKASYSNITIJI19", false);
        addPattern(PATTERN_DEFAULT, GONENRISAHAITOUSITEITUUKAKJNNKITIJI, "GONENRISAHAITOUSITEITUUKAKJNNKITIJI", false);
        addPattern(PATTERN_DEFAULT, YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK, "YTIRRTHENDOUGATAGONENRISAHAITOUSITEITUUKAKJNNK", false);
        addPattern(PATTERN_DEFAULT, GONENRISAHAITOUSITEITUUKAKJNNKITIJI20, "GONENRISAHAITOUSITEITUUKAKJNNKITIJI20", false);
        addPattern(PATTERN_DEFAULT, TEIKYKHRKNGONENRISAHAITOUSNTKTUUKATKBTSYSN, "TEIKYKHRKNGONENRISAHAITOUSNTKTUUKATKBTSYSN", false);


        lock(C_DrtSyouhinSikibetuKbn.class);
    }

    private C_DrtSyouhinSikibetuKbn(String value) {
        super(value);
    }

    public static C_DrtSyouhinSikibetuKbn valueOf(String value) {
        return valueOf(C_DrtSyouhinSikibetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtSyouhinSikibetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtSyouhinSikibetuKbn.class, patternId, value);
    }
}
