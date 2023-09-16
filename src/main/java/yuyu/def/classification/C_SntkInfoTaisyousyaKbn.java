
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報対象者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkInfoTaisyousyaKbn</td><td colspan="3">選択情報対象者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSYA}</td><td>&quot;1&quot;</td><td>契約者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIHOKENSYA}</td><td>&quot;2&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETORININ}</td><td>&quot;3&quot;</td><td>受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSYADAIRININ}</td><td>&quot;4&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIHOKENSYADAIRININ}</td><td>&quot;5&quot;</td><td>被保険者代理人</td></tr>
 * </table>
 */
public class C_SntkInfoTaisyousyaKbn extends Classification<C_SntkInfoTaisyousyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkInfoTaisyousyaKbn BLNK = new C_SntkInfoTaisyousyaKbn("0");

    public static final C_SntkInfoTaisyousyaKbn KEIYAKUSYA = new C_SntkInfoTaisyousyaKbn("1");

    public static final C_SntkInfoTaisyousyaKbn HIHOKENSYA = new C_SntkInfoTaisyousyaKbn("2");

    public static final C_SntkInfoTaisyousyaKbn UKETORININ = new C_SntkInfoTaisyousyaKbn("3");

    public static final C_SntkInfoTaisyousyaKbn KEIYAKUSYADAIRININ = new C_SntkInfoTaisyousyaKbn("4");

    public static final C_SntkInfoTaisyousyaKbn HIHOKENSYADAIRININ = new C_SntkInfoTaisyousyaKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KEIYAKUSYA, "KEIYAKUSYA", false);
        addPattern(PATTERN_DEFAULT, HIHOKENSYA, "HIHOKENSYA", false);
        addPattern(PATTERN_DEFAULT, UKETORININ, "UKETORININ", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSYADAIRININ, "KEIYAKUSYADAIRININ", false);
        addPattern(PATTERN_DEFAULT, HIHOKENSYADAIRININ, "HIHOKENSYADAIRININ", false);


        lock(C_SntkInfoTaisyousyaKbn.class);
    }

    private C_SntkInfoTaisyousyaKbn(String value) {
        super(value);
    }

    public static C_SntkInfoTaisyousyaKbn valueOf(String value) {
        return valueOf(C_SntkInfoTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkInfoTaisyousyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkInfoTaisyousyaKbn.class, patternId, value);
    }
}
