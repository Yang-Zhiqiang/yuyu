
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 掲示板情報種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjbnsyubetuKbn</td><td colspan="3">掲示板情報種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HANINFO}</td><td>&quot;1&quot;</td><td>販売支援情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JMINFO}</td><td>&quot;2&quot;</td><td>事務支援情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COMPINFO}</td><td>&quot;3&quot;</td><td>コンプライアンス情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #QAITIRAN}</td><td>&quot;4&quot;</td><td>ＱＡ一覧</td></tr>
 * </table>
 */
public class C_KjbnsyubetuKbn extends Classification<C_KjbnsyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjbnsyubetuKbn HANINFO = new C_KjbnsyubetuKbn("1");

    public static final C_KjbnsyubetuKbn JMINFO = new C_KjbnsyubetuKbn("2");

    public static final C_KjbnsyubetuKbn COMPINFO = new C_KjbnsyubetuKbn("3");

    public static final C_KjbnsyubetuKbn QAITIRAN = new C_KjbnsyubetuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HANINFO, "HANINFO", true);
        addPattern(PATTERN_DEFAULT, JMINFO, "JMINFO", false);
        addPattern(PATTERN_DEFAULT, COMPINFO, "COMPINFO", false);
        addPattern(PATTERN_DEFAULT, QAITIRAN, "QAITIRAN", false);


        lock(C_KjbnsyubetuKbn.class);
    }

    private C_KjbnsyubetuKbn(String value) {
        super(value);
    }

    public static C_KjbnsyubetuKbn valueOf(String value) {
        return valueOf(C_KjbnsyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjbnsyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjbnsyubetuKbn.class, patternId, value);
    }
}
