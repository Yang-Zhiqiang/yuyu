
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 店舗区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TenpoKbn</td><td colspan="3">店舗区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="18">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HONTEN}</td><td>&quot;00&quot;</td><td>本店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONTENEIGYOUBU}</td><td>&quot;01&quot;</td><td>本店営業部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONJYO}</td><td>&quot;02&quot;</td><td>本所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONBU}</td><td>&quot;03&quot;</td><td>本部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONTENEIGYOUKA}</td><td>&quot;04&quot;</td><td>本店営業課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONTENGYOUMUKA}</td><td>&quot;05&quot;</td><td>本店業務課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONTENGYOUMUBU}</td><td>&quot;06&quot;</td><td>本店業務部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUBU}</td><td>&quot;07&quot;</td><td>営業部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEN}</td><td>&quot;10&quot;</td><td>支店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYO}</td><td>&quot;11&quot;</td><td>支所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTYOUSYO}</td><td>&quot;15&quot;</td><td>出張所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUSYUTYOUSYO}</td><td>&quot;20&quot;</td><td>特別出張所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDOUSYUTYOSHO}</td><td>&quot;25&quot;</td><td>移動出張所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN}</td><td>&quot;30&quot;</td><td>代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CENTER}</td><td>&quot;40&quot;</td><td>センター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUMUBU}</td><td>&quot;90&quot;</td><td>公務部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUSYO}</td><td>&quot;91&quot;</td><td>事務所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;95&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_TenpoKbn extends Classification<C_TenpoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TenpoKbn HONTEN = new C_TenpoKbn("00");

    public static final C_TenpoKbn HONTENEIGYOUBU = new C_TenpoKbn("01");

    public static final C_TenpoKbn HONJYO = new C_TenpoKbn("02");

    public static final C_TenpoKbn HONBU = new C_TenpoKbn("03");

    public static final C_TenpoKbn HONTENEIGYOUKA = new C_TenpoKbn("04");

    public static final C_TenpoKbn HONTENGYOUMUKA = new C_TenpoKbn("05");

    public static final C_TenpoKbn HONTENGYOUMUBU = new C_TenpoKbn("06");

    public static final C_TenpoKbn EIGYOUBU = new C_TenpoKbn("07");

    public static final C_TenpoKbn SITEN = new C_TenpoKbn("10");

    public static final C_TenpoKbn SISYO = new C_TenpoKbn("11");

    public static final C_TenpoKbn SYUTYOUSYO = new C_TenpoKbn("15");

    public static final C_TenpoKbn TOKUSYUTYOUSYO = new C_TenpoKbn("20");

    public static final C_TenpoKbn IDOUSYUTYOSHO = new C_TenpoKbn("25");

    public static final C_TenpoKbn DAIRITEN = new C_TenpoKbn("30");

    public static final C_TenpoKbn CENTER = new C_TenpoKbn("40");

    public static final C_TenpoKbn KOUMUBU = new C_TenpoKbn("90");

    public static final C_TenpoKbn JIMUSYO = new C_TenpoKbn("91");

    public static final C_TenpoKbn SONOTA = new C_TenpoKbn("95");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HONTEN, "HONTEN", true);
        addPattern(PATTERN_DEFAULT, HONTENEIGYOUBU, "HONTENEIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, HONJYO, "HONJYO", false);
        addPattern(PATTERN_DEFAULT, HONBU, "HONBU", false);
        addPattern(PATTERN_DEFAULT, HONTENEIGYOUKA, "HONTENEIGYOUKA", false);
        addPattern(PATTERN_DEFAULT, HONTENGYOUMUKA, "HONTENGYOUMUKA", false);
        addPattern(PATTERN_DEFAULT, HONTENGYOUMUBU, "HONTENGYOUMUBU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUBU, "EIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, SITEN, "SITEN", false);
        addPattern(PATTERN_DEFAULT, SISYO, "SISYO", false);
        addPattern(PATTERN_DEFAULT, SYUTYOUSYO, "SYUTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, TOKUSYUTYOUSYO, "TOKUSYUTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, IDOUSYUTYOSHO, "IDOUSYUTYOSHO", false);
        addPattern(PATTERN_DEFAULT, DAIRITEN, "DAIRITEN", false);
        addPattern(PATTERN_DEFAULT, CENTER, "CENTER", false);
        addPattern(PATTERN_DEFAULT, KOUMUBU, "KOUMUBU", false);
        addPattern(PATTERN_DEFAULT, JIMUSYO, "JIMUSYO", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_TenpoKbn.class);
    }

    private C_TenpoKbn(String value) {
        super(value);
    }

    public static C_TenpoKbn valueOf(String value) {
        return valueOf(C_TenpoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TenpoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TenpoKbn.class, patternId, value);
    }
}
