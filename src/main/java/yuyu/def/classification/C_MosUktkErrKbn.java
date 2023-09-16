
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込受付エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MosUktkErrKbn</td><td colspan="3">申込受付エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PPLESSUKTKERROR}</td><td>&quot;1&quot;</td><td>ペーパーレス受付エラー</td></tr>
 * </table>
 */
public class C_MosUktkErrKbn extends Classification<C_MosUktkErrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MosUktkErrKbn BLNK = new C_MosUktkErrKbn("0");

    public static final C_MosUktkErrKbn PPLESSUKTKERROR = new C_MosUktkErrKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PPLESSUKTKERROR, "PPLESSUKTKERROR", false);


        lock(C_MosUktkErrKbn.class);
    }

    private C_MosUktkErrKbn(String value) {
        super(value);
    }

    public static C_MosUktkErrKbn valueOf(String value) {
        return valueOf(C_MosUktkErrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MosUktkErrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MosUktkErrKbn.class, patternId, value);
    }
}
