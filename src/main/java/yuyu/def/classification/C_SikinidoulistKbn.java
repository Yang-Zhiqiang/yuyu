
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動リスト区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidoulistKbn</td><td colspan="3">資金移動リスト区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUJI}</td><td>&quot;10&quot;</td><td>資金移動リスト（即時移動）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYAKKINYMD}</td><td>&quot;20&quot;</td><td>資金移動リスト（着金日移動）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNK}</td><td>&quot;30&quot;</td><td>資金移動リスト（円建変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKTRK}</td><td>&quot;31&quot;</td><td>資金移動リスト（円建変更）円建変更取消分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIJYNBRNYK}</td><td>&quot;40&quot;</td><td>資金移動リスト（即時移動：平準払入金分）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIJYNBRNYKTRK}</td><td>&quot;41&quot;</td><td>資金移動リスト（即時移動：平準払入金分）入金取消分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKIN}</td><td>&quot;50&quot;</td><td>資金移動リスト（配当金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRKKZHUITTI}</td><td>&quot;60&quot;</td><td>資金移動リスト（振込口座不一致分）</td></tr>
 * </table>
 */
public class C_SikinidoulistKbn extends Classification<C_SikinidoulistKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidoulistKbn BLNK = new C_SikinidoulistKbn("00");

    public static final C_SikinidoulistKbn SOKUJI = new C_SikinidoulistKbn("10");

    public static final C_SikinidoulistKbn TYAKKINYMD = new C_SikinidoulistKbn("20");

    public static final C_SikinidoulistKbn YENDTHNK = new C_SikinidoulistKbn("30");

    public static final C_SikinidoulistKbn YENDTHNKTRK = new C_SikinidoulistKbn("31");

    public static final C_SikinidoulistKbn HIJYNBRNYK = new C_SikinidoulistKbn("40");

    public static final C_SikinidoulistKbn HIJYNBRNYKTRK = new C_SikinidoulistKbn("41");

    public static final C_SikinidoulistKbn HAITOUKIN = new C_SikinidoulistKbn("50");

    public static final C_SikinidoulistKbn HRKKZHUITTI = new C_SikinidoulistKbn("60");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SOKUJI, "SOKUJI", false);
        addPattern(PATTERN_DEFAULT, TYAKKINYMD, "TYAKKINYMD", false);
        addPattern(PATTERN_DEFAULT, YENDTHNK, "YENDTHNK", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKTRK, "YENDTHNKTRK", false);
        addPattern(PATTERN_DEFAULT, HIJYNBRNYK, "HIJYNBRNYK", false);
        addPattern(PATTERN_DEFAULT, HIJYNBRNYKTRK, "HIJYNBRNYKTRK", false);
        addPattern(PATTERN_DEFAULT, HAITOUKIN, "HAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, HRKKZHUITTI, "HRKKZHUITTI", false);


        lock(C_SikinidoulistKbn.class);
    }

    private C_SikinidoulistKbn(String value) {
        super(value);
    }

    public static C_SikinidoulistKbn valueOf(String value) {
        return valueOf(C_SikinidoulistKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidoulistKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidoulistKbn.class, patternId, value);
    }
}
