
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 設計書申込書作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SekmossakuseiKbn</td><td colspan="3">設計書申込書作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISAN}</td><td>&quot;1&quot;</td><td>試算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIKOMISYO}</td><td>&quot;2&quot;</td><td>申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEKKEISYO}</td><td>&quot;3&quot;</td><td>設計書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEKKEISYO_MOUSIKOMISYO}</td><td>&quot;4&quot;</td><td>設計書・申込書</td></tr>
 * </table>
 */
public class C_SekmossakuseiKbn extends Classification<C_SekmossakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SekmossakuseiKbn NONE = new C_SekmossakuseiKbn("0");

    public static final C_SekmossakuseiKbn SISAN = new C_SekmossakuseiKbn("1");

    public static final C_SekmossakuseiKbn MOUSIKOMISYO = new C_SekmossakuseiKbn("2");

    public static final C_SekmossakuseiKbn SEKKEISYO = new C_SekmossakuseiKbn("3");

    public static final C_SekmossakuseiKbn SEKKEISYO_MOUSIKOMISYO = new C_SekmossakuseiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SISAN, "SISAN", false);
        addPattern(PATTERN_DEFAULT, MOUSIKOMISYO, "MOUSIKOMISYO", false);
        addPattern(PATTERN_DEFAULT, SEKKEISYO, "SEKKEISYO", false);
        addPattern(PATTERN_DEFAULT, SEKKEISYO_MOUSIKOMISYO, "SEKKEISYO_MOUSIKOMISYO", false);


        lock(C_SekmossakuseiKbn.class);
    }

    private C_SekmossakuseiKbn(String value) {
        super(value);
    }

    public static C_SekmossakuseiKbn valueOf(String value) {
        return valueOf(C_SekmossakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SekmossakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SekmossakuseiKbn.class, patternId, value);
    }
}
