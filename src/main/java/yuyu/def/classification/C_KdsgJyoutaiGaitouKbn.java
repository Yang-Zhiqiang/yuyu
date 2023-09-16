
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 高度障害状態該当区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KdsgJyoutaiGaitouKbn</td><td colspan="3">高度障害状態該当区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAITOU}</td><td>&quot;1&quot;</td><td>該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;2&quot;</td><td>不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;3&quot;</td><td>非該当</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #GAITOU}</td><td>&quot;1&quot;</td><td>該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;2&quot;</td><td>不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HG}</td><td>&quot;3&quot;</td><td>非該当</td></tr>
 * </table>
 */
public class C_KdsgJyoutaiGaitouKbn extends Classification<C_KdsgJyoutaiGaitouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KdsgJyoutaiGaitouKbn BLNK = new C_KdsgJyoutaiGaitouKbn("0");

    public static final C_KdsgJyoutaiGaitouKbn GAITOU = new C_KdsgJyoutaiGaitouKbn("1");

    public static final C_KdsgJyoutaiGaitouKbn HUMEI = new C_KdsgJyoutaiGaitouKbn("2");

    public static final C_KdsgJyoutaiGaitouKbn HG = new C_KdsgJyoutaiGaitouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAITOU, "GAITOU", false);
        addPattern(PATTERN_DEFAULT, HUMEI, "HUMEI", false);
        addPattern(PATTERN_DEFAULT, HG, "HG", false);


        addPattern(PATTERN_NOBLNK, GAITOU, "GAITOU", false);
        addPattern(PATTERN_NOBLNK, HUMEI, "HUMEI", false);
        addPattern(PATTERN_NOBLNK, HG, "HG", false);


        lock(C_KdsgJyoutaiGaitouKbn.class);
    }

    private C_KdsgJyoutaiGaitouKbn(String value) {
        super(value);
    }

    public static C_KdsgJyoutaiGaitouKbn valueOf(String value) {
        return valueOf(C_KdsgJyoutaiGaitouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KdsgJyoutaiGaitouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KdsgJyoutaiGaitouKbn.class, patternId, value);
    }
}
