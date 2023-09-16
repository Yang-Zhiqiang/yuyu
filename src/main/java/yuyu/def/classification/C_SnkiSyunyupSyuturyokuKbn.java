
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約収入Ｐ出力対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SnkiSyunyupSyuturyokuKbn</td><td colspan="3">新契約収入Ｐ出力対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #REIGETU}</td><td>&quot;1&quot;</td><td>例月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;2&quot;</td><td>決算</td></tr>
 * </table>
 */
public class C_SnkiSyunyupSyuturyokuKbn extends Classification<C_SnkiSyunyupSyuturyokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SnkiSyunyupSyuturyokuKbn REIGETU = new C_SnkiSyunyupSyuturyokuKbn("1");

    public static final C_SnkiSyunyupSyuturyokuKbn KESSAN = new C_SnkiSyunyupSyuturyokuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, REIGETU, "REIGETU", true);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);


        lock(C_SnkiSyunyupSyuturyokuKbn.class);
    }

    private C_SnkiSyunyupSyuturyokuKbn(String value) {
        super(value);
    }

    public static C_SnkiSyunyupSyuturyokuKbn valueOf(String value) {
        return valueOf(C_SnkiSyunyupSyuturyokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SnkiSyunyupSyuturyokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SnkiSyunyupSyuturyokuKbn.class, patternId, value);
    }
}
