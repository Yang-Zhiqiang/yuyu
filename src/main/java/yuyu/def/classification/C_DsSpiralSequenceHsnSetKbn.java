
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳＳＰＩＲＡＬシークエンス配信設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSpiralSequenceHsnSetKbn</td><td colspan="3">ＤＳＳＰＩＲＡＬシークエンス配信設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;0&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINZUMI}</td><td>&quot;1&quot;</td><td>確認済み</td></tr>
 * </table>
 */
public class C_DsSpiralSequenceHsnSetKbn extends Classification<C_DsSpiralSequenceHsnSetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSpiralSequenceHsnSetKbn DEFAULT = new C_DsSpiralSequenceHsnSetKbn("0");

    public static final C_DsSpiralSequenceHsnSetKbn KAKUNINZUMI = new C_DsSpiralSequenceHsnSetKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, KAKUNINZUMI, "KAKUNINZUMI", false);


        lock(C_DsSpiralSequenceHsnSetKbn.class);
    }

    private C_DsSpiralSequenceHsnSetKbn(String value) {
        super(value);
    }

    public static C_DsSpiralSequenceHsnSetKbn valueOf(String value) {
        return valueOf(C_DsSpiralSequenceHsnSetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSpiralSequenceHsnSetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSpiralSequenceHsnSetKbn.class, patternId, value);
    }
}
