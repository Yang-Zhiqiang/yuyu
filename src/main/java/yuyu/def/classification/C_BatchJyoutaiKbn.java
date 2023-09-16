
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchJyoutaiKbn</td><td colspan="3">バッチ状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #TAIKI}</td><td>&quot;1&quot;</td><td>待機中</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SYORI}</td><td>&quot;2&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU_TYU}</td><td>&quot;3&quot;</td><td>終了中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;4&quot;</td><td>終了</td></tr>
 * </table>
 */
public class C_BatchJyoutaiKbn extends Classification<C_BatchJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchJyoutaiKbn TAIKI = new C_BatchJyoutaiKbn("1");

    public static final C_BatchJyoutaiKbn SYORI = new C_BatchJyoutaiKbn("2");

    public static final C_BatchJyoutaiKbn SYUURYOU_TYU = new C_BatchJyoutaiKbn("3");

    public static final C_BatchJyoutaiKbn SYUURYOU = new C_BatchJyoutaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TAIKI, "TAIKI", false);
        addPattern(PATTERN_DEFAULT, SYORI, "SYORI", true);
        addPattern(PATTERN_DEFAULT, SYUURYOU_TYU, "SYUURYOU_TYU", false);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);


        lock(C_BatchJyoutaiKbn.class);
    }

    private C_BatchJyoutaiKbn(String value) {
        super(value);
    }

    public static C_BatchJyoutaiKbn valueOf(String value) {
        return valueOf(C_BatchJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchJyoutaiKbn.class, patternId, value);
    }
}
