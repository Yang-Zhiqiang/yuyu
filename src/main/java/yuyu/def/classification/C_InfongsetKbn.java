
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 情報系日額設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_InfongsetKbn</td><td colspan="3">情報系日額設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONS_DOUGAKU}</td><td>&quot;1&quot;</td><td>基本Ｓと同額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONS_KATAKBN_KEISAN}</td><td>&quot;2&quot;</td><td>基本Ｓと型区分で計算</td></tr>
 * </table>
 */
public class C_InfongsetKbn extends Classification<C_InfongsetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_InfongsetKbn NONE = new C_InfongsetKbn("0");

    public static final C_InfongsetKbn KIHONS_DOUGAKU = new C_InfongsetKbn("1");

    public static final C_InfongsetKbn KIHONS_KATAKBN_KEISAN = new C_InfongsetKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, KIHONS_DOUGAKU, "KIHONS_DOUGAKU", false);
        addPattern(PATTERN_DEFAULT, KIHONS_KATAKBN_KEISAN, "KIHONS_KATAKBN_KEISAN", false);


        lock(C_InfongsetKbn.class);
    }

    private C_InfongsetKbn(String value) {
        super(value);
    }

    public static C_InfongsetKbn valueOf(String value) {
        return valueOf(C_InfongsetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_InfongsetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_InfongsetKbn.class, patternId, value);
    }
}
