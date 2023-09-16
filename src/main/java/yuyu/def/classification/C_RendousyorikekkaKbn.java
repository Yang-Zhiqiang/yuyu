
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連動処理結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RendousyorikekkaKbn</td><td colspan="3">連動処理結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJOU}</td><td>&quot;0&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIJIKKOU}</td><td>&quot;2&quot;</td><td>未実行</td></tr>
 * </table>
 */
public class C_RendousyorikekkaKbn extends Classification<C_RendousyorikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RendousyorikekkaKbn SEIJOU = new C_RendousyorikekkaKbn("0");

    public static final C_RendousyorikekkaKbn ERROR = new C_RendousyorikekkaKbn("1");

    public static final C_RendousyorikekkaKbn MIJIKKOU = new C_RendousyorikekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJOU, "SEIJOU", true);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, MIJIKKOU, "MIJIKKOU", false);


        lock(C_RendousyorikekkaKbn.class);
    }

    private C_RendousyorikekkaKbn(String value) {
        super(value);
    }

    public static C_RendousyorikekkaKbn valueOf(String value) {
        return valueOf(C_RendousyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RendousyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RendousyorikekkaKbn.class, patternId, value);
    }
}
