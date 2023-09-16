
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 予定契約日設定方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YoteikyksetteiKbn</td><td colspan="3">予定契約日設定方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HANYOU}</td><td>&quot;0&quot;</td><td>汎用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKIBARAI}</td><td>&quot;1&quot;</td><td>月払い</td></tr>
 * </table>
 */
public class C_YoteikyksetteiKbn extends Classification<C_YoteikyksetteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YoteikyksetteiKbn HANYOU = new C_YoteikyksetteiKbn("0");

    public static final C_YoteikyksetteiKbn TUKIBARAI = new C_YoteikyksetteiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HANYOU, "HANYOU", true);
        addPattern(PATTERN_DEFAULT, TUKIBARAI, "TUKIBARAI", false);


        lock(C_YoteikyksetteiKbn.class);
    }

    private C_YoteikyksetteiKbn(String value) {
        super(value);
    }

    public static C_YoteikyksetteiKbn valueOf(String value) {
        return valueOf(C_YoteikyksetteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YoteikyksetteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YoteikyksetteiKbn.class, patternId, value);
    }
}
