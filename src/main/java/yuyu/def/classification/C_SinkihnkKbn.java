
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新規変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinkihnkKbn</td><td colspan="3">新規変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKIMOSNYUURYOKU}</td><td>&quot;1&quot;</td><td>新規申込書入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIINFOHENKOU}</td><td>&quot;2&quot;</td><td>名義情報変更</td></tr>
 * </table>
 */
public class C_SinkihnkKbn extends Classification<C_SinkihnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinkihnkKbn BLNK = new C_SinkihnkKbn("0");

    public static final C_SinkihnkKbn SINKIMOSNYUURYOKU = new C_SinkihnkKbn("1");

    public static final C_SinkihnkKbn MEIGIINFOHENKOU = new C_SinkihnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKIMOSNYUURYOKU, "SINKIMOSNYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, MEIGIINFOHENKOU, "MEIGIINFOHENKOU", false);


        lock(C_SinkihnkKbn.class);
    }

    private C_SinkihnkKbn(String value) {
        super(value);
    }

    public static C_SinkihnkKbn valueOf(String value) {
        return valueOf(C_SinkihnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinkihnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinkihnkKbn.class, patternId, value);
    }
}
