
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LincjkKbn</td><td colspan="3">ＬＩＮＣ状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIHANTEI}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAITAISYOUGAI}</td><td>&quot;1&quot;</td><td>ＬＩＮＣ照会対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIMATI}</td><td>&quot;2&quot;</td><td>ＬＩＮＣ照会送信待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;3&quot;</td><td>ＬＩＮＣ照会中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANEIMATI}</td><td>&quot;6&quot;</td><td>ＬＩＮＣ回答反映待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOARI_TASYANASI}</td><td>&quot;4&quot;</td><td>ＬＩＮＣ回答あり（他社加入なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOARI_TASYAARI}</td><td>&quot;5&quot;</td><td>ＬＩＮＣ回答あり（他社加入あり）</td></tr>
 * </table>
 */
public class C_LincjkKbn extends Classification<C_LincjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LincjkKbn MIHANTEI = new C_LincjkKbn("0");

    public static final C_LincjkKbn SYOUKAITAISYOUGAI = new C_LincjkKbn("1");

    public static final C_LincjkKbn SYOUKAIMATI = new C_LincjkKbn("2");

    public static final C_LincjkKbn SYOUKAI = new C_LincjkKbn("3");

    public static final C_LincjkKbn HANEIMATI = new C_LincjkKbn("6");

    public static final C_LincjkKbn KAITOARI_TASYANASI = new C_LincjkKbn("4");

    public static final C_LincjkKbn KAITOARI_TASYAARI = new C_LincjkKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIHANTEI, "MIHANTEI", true);
        addPattern(PATTERN_DEFAULT, SYOUKAITAISYOUGAI, "SYOUKAITAISYOUGAI", false);
        addPattern(PATTERN_DEFAULT, SYOUKAIMATI, "SYOUKAIMATI", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HANEIMATI, "HANEIMATI", false);
        addPattern(PATTERN_DEFAULT, KAITOARI_TASYANASI, "KAITOARI_TASYANASI", false);
        addPattern(PATTERN_DEFAULT, KAITOARI_TASYAARI, "KAITOARI_TASYAARI", false);


        lock(C_LincjkKbn.class);
    }

    private C_LincjkKbn(String value) {
        super(value);
    }

    public static C_LincjkKbn valueOf(String value) {
        return valueOf(C_LincjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LincjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LincjkKbn.class, patternId, value);
    }
}
