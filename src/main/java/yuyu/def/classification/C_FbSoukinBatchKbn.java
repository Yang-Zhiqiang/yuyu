
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＦＢ送金バッチ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_FbSoukinBatchKbn</td><td colspan="3">ＦＢ送金バッチ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>バッチ以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>バッチ</td></tr>
 * </table>
 */
public class C_FbSoukinBatchKbn extends Classification<C_FbSoukinBatchKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_FbSoukinBatchKbn NONE = new C_FbSoukinBatchKbn("0");

    public static final C_FbSoukinBatchKbn BATCH = new C_FbSoukinBatchKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);


        lock(C_FbSoukinBatchKbn.class);
    }

    private C_FbSoukinBatchKbn(String value) {
        super(value);
    }

    public static C_FbSoukinBatchKbn valueOf(String value) {
        return valueOf(C_FbSoukinBatchKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_FbSoukinBatchKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_FbSoukinBatchKbn.class, patternId, value);
    }
}
