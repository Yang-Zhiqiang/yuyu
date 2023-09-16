
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 環境査定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KnkysateijyouKbn</td><td colspan="3">環境査定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIZUMI}</td><td>&quot;1&quot;</td><td>環境査定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_1}</td><td>&quot;2&quot;</td><td>査定待ち（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_2A}</td><td>&quot;3&quot;</td><td>査定待ち（２次Ａ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_2B}</td><td>&quot;4&quot;</td><td>査定待ち（２次Ｂ）</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIZUMI}</td><td>&quot;1&quot;</td><td>環境査定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_1}</td><td>&quot;2&quot;</td><td>１次待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_2A}</td><td>&quot;3&quot;</td><td>２次Ａ待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEIMATI_2B}</td><td>&quot;4&quot;</td><td>２次Ｂ待ち</td></tr>
 * </table>
 */
public class C_KnkysateijyouKbn extends Classification<C_KnkysateijyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KnkysateijyouKbn NONE = new C_KnkysateijyouKbn("0");

    public static final C_KnkysateijyouKbn SATEIZUMI = new C_KnkysateijyouKbn("1");

    public static final C_KnkysateijyouKbn SATEIMATI_1 = new C_KnkysateijyouKbn("2");

    public static final C_KnkysateijyouKbn SATEIMATI_2A = new C_KnkysateijyouKbn("3");

    public static final C_KnkysateijyouKbn SATEIMATI_2B = new C_KnkysateijyouKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RYAKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SATEIZUMI, "SATEIZUMI", false);
        addPattern(PATTERN_DEFAULT, SATEIMATI_1, "SATEIMATI_1", false);
        addPattern(PATTERN_DEFAULT, SATEIMATI_2A, "SATEIMATI_2A", false);
        addPattern(PATTERN_DEFAULT, SATEIMATI_2B, "SATEIMATI_2B", false);


        addPattern(PATTERN_RYAKU, NONE, "NONE", false);
        addPattern(PATTERN_RYAKU, SATEIZUMI, "SATEIZUMI", false);
        addPattern(PATTERN_RYAKU, SATEIMATI_1, "SATEIMATI_1", false);
        addPattern(PATTERN_RYAKU, SATEIMATI_2A, "SATEIMATI_2A", false);
        addPattern(PATTERN_RYAKU, SATEIMATI_2B, "SATEIMATI_2B", false);


        lock(C_KnkysateijyouKbn.class);
    }

    private C_KnkysateijyouKbn(String value) {
        super(value);
    }

    public static C_KnkysateijyouKbn valueOf(String value) {
        return valueOf(C_KnkysateijyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KnkysateijyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KnkysateijyouKbn.class, patternId, value);
    }
}
