
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店情報処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DairitenInfoSyoriKbn</td><td colspan="3">代理店情報処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ALL}</td><td>&quot;1&quot;</td><td>すべて</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CIFCD}</td><td>&quot;2&quot;</td><td>ＣＩＦコードのみ</td></tr>
 * </table>
 */
public class C_DairitenInfoSyoriKbn extends Classification<C_DairitenInfoSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DairitenInfoSyoriKbn ALL = new C_DairitenInfoSyoriKbn("1");

    public static final C_DairitenInfoSyoriKbn CIFCD = new C_DairitenInfoSyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ALL, "ALL", true);
        addPattern(PATTERN_DEFAULT, CIFCD, "CIFCD", false);


        lock(C_DairitenInfoSyoriKbn.class);
    }

    private C_DairitenInfoSyoriKbn(String value) {
        super(value);
    }

    public static C_DairitenInfoSyoriKbn valueOf(String value) {
        return valueOf(C_DairitenInfoSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DairitenInfoSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DairitenInfoSyoriKbn.class, patternId, value);
    }
}
