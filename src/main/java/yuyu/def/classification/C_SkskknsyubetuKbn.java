
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 親権者後見人種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkskknsyubetuKbn</td><td colspan="3">親権者後見人種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKENSYA}</td><td>&quot;1&quot;</td><td>親権者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENKKN}</td><td>&quot;2&quot;</td><td>成年後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISEINENKKN}</td><td>&quot;3&quot;</td><td>未成年後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRIINN}</td><td>&quot;4&quot;</td><td>代理人</td></tr>
 * </table>
 */
public class C_SkskknsyubetuKbn extends Classification<C_SkskknsyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkskknsyubetuKbn BLNK = new C_SkskknsyubetuKbn("0");

    public static final C_SkskknsyubetuKbn SINKENSYA = new C_SkskknsyubetuKbn("1");

    public static final C_SkskknsyubetuKbn SEINENKKN = new C_SkskknsyubetuKbn("2");

    public static final C_SkskknsyubetuKbn MISEINENKKN = new C_SkskknsyubetuKbn("3");

    public static final C_SkskknsyubetuKbn DAIRIINN = new C_SkskknsyubetuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKENSYA, "SINKENSYA", false);
        addPattern(PATTERN_DEFAULT, SEINENKKN, "SEINENKKN", false);
        addPattern(PATTERN_DEFAULT, MISEINENKKN, "MISEINENKKN", false);
        addPattern(PATTERN_DEFAULT, DAIRIINN, "DAIRIINN", false);


        lock(C_SkskknsyubetuKbn.class);
    }

    private C_SkskknsyubetuKbn(String value) {
        super(value);
    }

    public static C_SkskknsyubetuKbn valueOf(String value) {
        return valueOf(C_SkskknsyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkskknsyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkskknsyubetuKbn.class, patternId, value);
    }
}
