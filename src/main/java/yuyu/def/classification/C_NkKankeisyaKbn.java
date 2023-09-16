
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払関係者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkKankeisyaKbn</td><td colspan="3">年金支払関係者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_NKUKTBETU}</td><td>&quot;01&quot;</td><td>被保険者（年金受取人別人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2HHKN_NKUKTBETU}</td><td>&quot;04&quot;</td><td>第２被保険者（年金受取人別人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;20&quot;</td><td>年金受取人</td></tr>
 * </table>
 */
public class C_NkKankeisyaKbn extends Classification<C_NkKankeisyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkKankeisyaKbn BLNK = new C_NkKankeisyaKbn("0");

    public static final C_NkKankeisyaKbn HHKN_NKUKTBETU = new C_NkKankeisyaKbn("01");

    public static final C_NkKankeisyaKbn DAI2HHKN_NKUKTBETU = new C_NkKankeisyaKbn("04");

    public static final C_NkKankeisyaKbn NKUKT = new C_NkKankeisyaKbn("20");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKN_NKUKTBETU, "HHKN_NKUKTBETU", false);
        addPattern(PATTERN_DEFAULT, DAI2HHKN_NKUKTBETU, "DAI2HHKN_NKUKTBETU", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);


        lock(C_NkKankeisyaKbn.class);
    }

    private C_NkKankeisyaKbn(String value) {
        super(value);
    }

    public static C_NkKankeisyaKbn valueOf(String value) {
        return valueOf(C_NkKankeisyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkKankeisyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkKankeisyaKbn.class, patternId, value);
    }
}
