
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｗｅｂ申込状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WebmosjtKbn</td><td colspan="3">Ｗｅｂ申込状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MOSTYUU}</td><td>&quot;0&quot;</td><td>申込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSKANRYOU}</td><td>&quot;1&quot;</td><td>申込完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIRENDOU}</td><td>&quot;2&quot;</td><td>新契約連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKSAKUSEIERROR}</td><td>&quot;3&quot;</td><td>告知書作成エラー</td></tr>
 * </table>
 */
public class C_WebmosjtKbn extends Classification<C_WebmosjtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WebmosjtKbn MOSTYUU = new C_WebmosjtKbn("0");

    public static final C_WebmosjtKbn MOSKANRYOU = new C_WebmosjtKbn("1");

    public static final C_WebmosjtKbn SINKEIRENDOU = new C_WebmosjtKbn("2");

    public static final C_WebmosjtKbn KOKSAKUSEIERROR = new C_WebmosjtKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MOSTYUU, "MOSTYUU", true);
        addPattern(PATTERN_DEFAULT, MOSKANRYOU, "MOSKANRYOU", false);
        addPattern(PATTERN_DEFAULT, SINKEIRENDOU, "SINKEIRENDOU", false);
        addPattern(PATTERN_DEFAULT, KOKSAKUSEIERROR, "KOKSAKUSEIERROR", false);


        lock(C_WebmosjtKbn.class);
    }

    private C_WebmosjtKbn(String value) {
        super(value);
    }

    public static C_WebmosjtKbn valueOf(String value) {
        return valueOf(C_WebmosjtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WebmosjtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WebmosjtKbn.class, patternId, value);
    }
}
