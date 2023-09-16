
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 異動中判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IdoutyuuHanteiKekkaKbn</td><td colspan="3">異動中判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #IDOUNASHI}</td><td>&quot;0&quot;</td><td>異動なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDOUTYUU}</td><td>&quot;1&quot;</td><td>異動中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;2&quot;</td><td>照合エラー</td></tr>
 * </table>
 */
public class C_IdoutyuuHanteiKekkaKbn extends Classification<C_IdoutyuuHanteiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IdoutyuuHanteiKekkaKbn IDOUNASHI = new C_IdoutyuuHanteiKekkaKbn("0");

    public static final C_IdoutyuuHanteiKekkaKbn IDOUTYUU = new C_IdoutyuuHanteiKekkaKbn("1");

    public static final C_IdoutyuuHanteiKekkaKbn ERROR = new C_IdoutyuuHanteiKekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, IDOUNASHI, "IDOUNASHI", true);
        addPattern(PATTERN_DEFAULT, IDOUTYUU, "IDOUTYUU", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_IdoutyuuHanteiKekkaKbn.class);
    }

    private C_IdoutyuuHanteiKekkaKbn(String value) {
        super(value);
    }

    public static C_IdoutyuuHanteiKekkaKbn valueOf(String value) {
        return valueOf(C_IdoutyuuHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IdoutyuuHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IdoutyuuHanteiKekkaKbn.class, patternId, value);
    }
}
