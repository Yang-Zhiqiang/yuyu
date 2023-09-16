
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡率統計出力レコード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SibouToukeiSyuturyokuKbn</td><td colspan="3">死亡率統計出力レコード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KEIYAKUNAIYOUTEISEI}</td><td>&quot;1&quot;</td><td>契約内容訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHENDOU}</td><td>&quot;2&quot;</td><td>Ｓの変動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;3&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_SibouToukeiSyuturyokuKbn extends Classification<C_SibouToukeiSyuturyokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SibouToukeiSyuturyokuKbn KEIYAKUNAIYOUTEISEI = new C_SibouToukeiSyuturyokuKbn("1");

    public static final C_SibouToukeiSyuturyokuKbn SHENDOU = new C_SibouToukeiSyuturyokuKbn("2");

    public static final C_SibouToukeiSyuturyokuKbn SYOUMETU = new C_SibouToukeiSyuturyokuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KEIYAKUNAIYOUTEISEI, "KEIYAKUNAIYOUTEISEI", true);
        addPattern(PATTERN_DEFAULT, SHENDOU, "SHENDOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_SibouToukeiSyuturyokuKbn.class);
    }

    private C_SibouToukeiSyuturyokuKbn(String value) {
        super(value);
    }

    public static C_SibouToukeiSyuturyokuKbn valueOf(String value) {
        return valueOf(C_SibouToukeiSyuturyokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SibouToukeiSyuturyokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SibouToukeiSyuturyokuKbn.class, patternId, value);
    }
}
