
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 月払一括入金額計算エラー理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn</td><td colspan="3">月払一括入金額計算エラー理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PARAM_ERROR}</td><td>&quot;1&quot;</td><td>パラメータ不正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAWASERATE_SYUTOKU_ERROR}</td><td>&quot;2&quot;</td><td>為替レート取得エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASTER_DATA_SYUTOKU_ERROR}</td><td>&quot;3&quot;</td><td>マスターデータ取得エラー</td></tr>
 * </table>
 */
public class C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn extends Classification<C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn BLNK = new C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn("0");

    public static final C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn PARAM_ERROR = new C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn("1");

    public static final C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn KAWASERATE_SYUTOKU_ERROR = new C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn("2");

    public static final C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn MASTER_DATA_SYUTOKU_ERROR = new C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PARAM_ERROR, "PARAM_ERROR", false);
        addPattern(PATTERN_DEFAULT, KAWASERATE_SYUTOKU_ERROR, "KAWASERATE_SYUTOKU_ERROR", false);
        addPattern(PATTERN_DEFAULT, MASTER_DATA_SYUTOKU_ERROR, "MASTER_DATA_SYUTOKU_ERROR", false);


        lock(C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.class);
    }

    private C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn(String value) {
        super(value);
    }

    public static C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn valueOf(String value) {
        return valueOf(C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeisanTukiIkkatuNyuukinGkErrorRiyuuKbn.class, patternId, value);
    }
}
