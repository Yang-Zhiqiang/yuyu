
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ターゲット特約付加可能区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TargetTkHukaKanouKbn</td><td colspan="3">ターゲット特約付加可能区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ターゲット特約無し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENSYUUSIN}</td><td>&quot;1&quot;</td><td>目標到達時円建終身保険変更特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENNENKIN}</td><td>&quot;2&quot;</td><td>目標到達時円建年金保険変更特約</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKMOSSYOUKAI SKMOSSYOUKAI}<br />(申込状況照会)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENSYUUSIN}</td><td>&quot;1&quot;</td><td>目標到達時円建<br/>終身保険変更特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENNENKIN}</td><td>&quot;2&quot;</td><td>目標到達時円建<br/>年金保険変更特約</td></tr>
 * </table>
 */
public class C_TargetTkHukaKanouKbn extends Classification<C_TargetTkHukaKanouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TargetTkHukaKanouKbn NONE = new C_TargetTkHukaKanouKbn("0");

    public static final C_TargetTkHukaKanouKbn YENSYUUSIN = new C_TargetTkHukaKanouKbn("1");

    public static final C_TargetTkHukaKanouKbn YENNENKIN = new C_TargetTkHukaKanouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKMOSSYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, YENSYUUSIN, "YENSYUUSIN", false);
        addPattern(PATTERN_DEFAULT, YENNENKIN, "YENNENKIN", false);


        addPattern(PATTERN_SKMOSSYOUKAI, NONE, "NONE", true);
        addPattern(PATTERN_SKMOSSYOUKAI, YENSYUUSIN, "YENSYUUSIN", false);
        addPattern(PATTERN_SKMOSSYOUKAI, YENNENKIN, "YENNENKIN", false);


        lock(C_TargetTkHukaKanouKbn.class);
    }

    private C_TargetTkHukaKanouKbn(String value) {
        super(value);
    }

    public static C_TargetTkHukaKanouKbn valueOf(String value) {
        return valueOf(C_TargetTkHukaKanouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TargetTkHukaKanouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TargetTkHukaKanouKbn.class, patternId, value);
    }
}
