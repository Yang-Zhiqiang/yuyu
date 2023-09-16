
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 関係者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KankeisyaKbn</td><td colspan="3">関係者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KYKBETU}</td><td>&quot;01&quot;</td><td>被保険者（契約者別人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;02&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KYKDOUITU}</td><td>&quot;03&quot;</td><td>被保険者（契約者同一）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2HHKN_KYKBETU}</td><td>&quot;04&quot;</td><td>第２被保険者（契約者別人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2HHKN_KYKDOUITU}</td><td>&quot;05&quot;</td><td>第２被保険者（契約者同一）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUEOKIUKT}</td><td>&quot;06&quot;</td><td>据置受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZKTEIKITKYKHHKN}</td><td>&quot;10&quot;</td><td>家族定期特約被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZKTKYKHHKN}</td><td>&quot;11&quot;</td><td>家族型特約被保険者</td></tr>
 * </table>
 */
public class C_KankeisyaKbn extends Classification<C_KankeisyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KankeisyaKbn BLNK = new C_KankeisyaKbn("0");

    public static final C_KankeisyaKbn HHKN_KYKBETU = new C_KankeisyaKbn("01");

    public static final C_KankeisyaKbn KYK = new C_KankeisyaKbn("02");

    public static final C_KankeisyaKbn HHKN_KYKDOUITU = new C_KankeisyaKbn("03");

    public static final C_KankeisyaKbn DAI2HHKN_KYKBETU = new C_KankeisyaKbn("04");

    public static final C_KankeisyaKbn DAI2HHKN_KYKDOUITU = new C_KankeisyaKbn("05");

    public static final C_KankeisyaKbn SUEOKIUKT = new C_KankeisyaKbn("06");

    public static final C_KankeisyaKbn KZKTEIKITKYKHHKN = new C_KankeisyaKbn("10");

    public static final C_KankeisyaKbn KZKTKYKHHKN = new C_KankeisyaKbn("11");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKN_KYKBETU, "HHKN_KYKBETU", false);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, HHKN_KYKDOUITU, "HHKN_KYKDOUITU", false);
        addPattern(PATTERN_DEFAULT, DAI2HHKN_KYKBETU, "DAI2HHKN_KYKBETU", false);
        addPattern(PATTERN_DEFAULT, DAI2HHKN_KYKDOUITU, "DAI2HHKN_KYKDOUITU", false);
        addPattern(PATTERN_DEFAULT, SUEOKIUKT, "SUEOKIUKT", false);
        addPattern(PATTERN_DEFAULT, KZKTEIKITKYKHHKN, "KZKTEIKITKYKHHKN", false);
        addPattern(PATTERN_DEFAULT, KZKTKYKHHKN, "KZKTKYKHHKN", false);


        lock(C_KankeisyaKbn.class);
    }

    private C_KankeisyaKbn(String value) {
        super(value);
    }

    public static C_KankeisyaKbn valueOf(String value) {
        return valueOf(C_KankeisyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KankeisyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KankeisyaKbn.class, patternId, value);
    }
}
