
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykkakkekKbn</td><td colspan="3">契約確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUJIKOU_NONE}</td><td>&quot;1&quot;</td><td>報告事項なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUJIKOU_ARI}</td><td>&quot;2&quot;</td><td>報告事項あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAK_TYUUSI}</td><td>&quot;3&quot;</td><td>確認中止</td></tr>
 * </table>
 */
public class C_KykkakkekKbn extends Classification<C_KykkakkekKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykkakkekKbn BLNK = new C_KykkakkekKbn("0");

    public static final C_KykkakkekKbn HOUKOKUJIKOU_NONE = new C_KykkakkekKbn("1");

    public static final C_KykkakkekKbn HOUKOKUJIKOU_ARI = new C_KykkakkekKbn("2");

    public static final C_KykkakkekKbn KAK_TYUUSI = new C_KykkakkekKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOUKOKUJIKOU_NONE, "HOUKOKUJIKOU_NONE", false);
        addPattern(PATTERN_DEFAULT, HOUKOKUJIKOU_ARI, "HOUKOKUJIKOU_ARI", false);
        addPattern(PATTERN_DEFAULT, KAK_TYUUSI, "KAK_TYUUSI", false);


        lock(C_KykkakkekKbn.class);
    }

    private C_KykkakkekKbn(String value) {
        super(value);
    }

    public static C_KykkakkekKbn valueOf(String value) {
        return valueOf(C_KykkakkekKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykkakkekKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykkakkekKbn.class, patternId, value);
    }
}
