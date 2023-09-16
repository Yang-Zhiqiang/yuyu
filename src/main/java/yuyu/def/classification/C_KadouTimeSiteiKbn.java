
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 稼働時間指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KadouTimeSiteiKbn</td><td colspan="3">稼働時間指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUJUN}</td><td>&quot;1&quot;</td><td>標準と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>稼働時間指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_KA}</td><td>&quot;3&quot;</td><td>全日利用可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_HUKA}</td><td>&quot;4&quot;</td><td>全日利用不可</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TOKUTEIBI TOKUTEIBI}<br />(特定日稼働時間指定)</td><td align="center">○</td><td>{@link #ZENJITURIYOU_KA}</td><td>&quot;3&quot;</td><td>全日利用可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_HUKA}</td><td>&quot;4&quot;</td><td>全日利用不可</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_TOKUTEIBIADD TOKUTEIBIADD}<br />(特定日稼働時間登録)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>稼働時間指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_KA}</td><td>&quot;3&quot;</td><td>全日利用可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_HUKA}</td><td>&quot;4&quot;</td><td>全日利用不可</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_KADOUTIMEADD KADOUTIMEADD}<br />(稼動時間登録)</td><td align="center">&nbsp;</td><td>{@link #HYOUJUN}</td><td>&quot;1&quot;</td><td>標準と同じ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEI}</td><td>&quot;2&quot;</td><td>稼働時間指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_KA}</td><td>&quot;3&quot;</td><td>全日利用可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJITURIYOU_HUKA}</td><td>&quot;4&quot;</td><td>全日利用不可</td></tr>
 * </table>
 */
public class C_KadouTimeSiteiKbn extends Classification<C_KadouTimeSiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KadouTimeSiteiKbn BLNK = new C_KadouTimeSiteiKbn("0");

    public static final C_KadouTimeSiteiKbn HYOUJUN = new C_KadouTimeSiteiKbn("1");

    public static final C_KadouTimeSiteiKbn SITEI = new C_KadouTimeSiteiKbn("2");

    public static final C_KadouTimeSiteiKbn ZENJITURIYOU_KA = new C_KadouTimeSiteiKbn("3");

    public static final C_KadouTimeSiteiKbn ZENJITURIYOU_HUKA = new C_KadouTimeSiteiKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_TOKUTEIBI = "2";

    public static final String PATTERN_TOKUTEIBIADD = "3";

    public static final String PATTERN_KADOUTIMEADD = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HYOUJUN, "HYOUJUN", false);
        addPattern(PATTERN_DEFAULT, SITEI, "SITEI", false);
        addPattern(PATTERN_DEFAULT, ZENJITURIYOU_KA, "ZENJITURIYOU_KA", false);
        addPattern(PATTERN_DEFAULT, ZENJITURIYOU_HUKA, "ZENJITURIYOU_HUKA", false);


        addPattern(PATTERN_TOKUTEIBI, ZENJITURIYOU_KA, "ZENJITURIYOU_KA", true);
        addPattern(PATTERN_TOKUTEIBI, ZENJITURIYOU_HUKA, "ZENJITURIYOU_HUKA", false);


        addPattern(PATTERN_TOKUTEIBIADD, BLNK, "BLNK", true);
        addPattern(PATTERN_TOKUTEIBIADD, SITEI, "SITEI", false);
        addPattern(PATTERN_TOKUTEIBIADD, ZENJITURIYOU_KA, "ZENJITURIYOU_KA", false);
        addPattern(PATTERN_TOKUTEIBIADD, ZENJITURIYOU_HUKA, "ZENJITURIYOU_HUKA", false);


        addPattern(PATTERN_KADOUTIMEADD, HYOUJUN, "HYOUJUN", false);
        addPattern(PATTERN_KADOUTIMEADD, SITEI, "SITEI", false);
        addPattern(PATTERN_KADOUTIMEADD, ZENJITURIYOU_KA, "ZENJITURIYOU_KA", false);
        addPattern(PATTERN_KADOUTIMEADD, ZENJITURIYOU_HUKA, "ZENJITURIYOU_HUKA", false);


        lock(C_KadouTimeSiteiKbn.class);
    }

    private C_KadouTimeSiteiKbn(String value) {
        super(value);
    }

    public static C_KadouTimeSiteiKbn valueOf(String value) {
        return valueOf(C_KadouTimeSiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KadouTimeSiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KadouTimeSiteiKbn.class, patternId, value);
    }
}
