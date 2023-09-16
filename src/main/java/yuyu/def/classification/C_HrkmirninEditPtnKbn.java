
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振込依頼人編集パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkmirninEditPtnKbn</td><td colspan="3">振込依頼人編集パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUJYUN}</td><td>&quot;1&quot;</td><td>標準</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKMIRNINKETUGOU}</td><td>&quot;2&quot;</td><td>振込依頼人コード結合</td></tr>
 * </table>
 */
public class C_HrkmirninEditPtnKbn extends Classification<C_HrkmirninEditPtnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkmirninEditPtnKbn BLNK = new C_HrkmirninEditPtnKbn("0");

    public static final C_HrkmirninEditPtnKbn HYOUJYUN = new C_HrkmirninEditPtnKbn("1");

    public static final C_HrkmirninEditPtnKbn HRKMIRNINKETUGOU = new C_HrkmirninEditPtnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HYOUJYUN, "HYOUJYUN", false);
        addPattern(PATTERN_DEFAULT, HRKMIRNINKETUGOU, "HRKMIRNINKETUGOU", false);


        lock(C_HrkmirninEditPtnKbn.class);
    }

    private C_HrkmirninEditPtnKbn(String value) {
        super(value);
    }

    public static C_HrkmirninEditPtnKbn valueOf(String value) {
        return valueOf(C_HrkmirninEditPtnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkmirninEditPtnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkmirninEditPtnKbn.class, patternId, value);
    }
}
