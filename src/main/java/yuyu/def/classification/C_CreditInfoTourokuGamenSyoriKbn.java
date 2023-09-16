
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クレジットカード情報登録画面処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CreditInfoTourokuGamenSyoriKbn</td><td colspan="3">クレジットカード情報登録画面処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #AUTHORIKAKYMDNYUURYOKU}</td><td>&quot;1&quot;</td><td>オーソリ確認日入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITKESSAIYOUNOSYUTOKU}</td><td>&quot;2&quot;</td><td>クレジットカード決済用番号取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITTOUROKUKANBI}</td><td>&quot;3&quot;</td><td>クレジットカード登録完備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITTOUROKUHANEISYORIQR}</td><td>&quot;4&quot;</td><td>クレジットカード登録反映処理（ＱＲ専用）</td></tr>
 * </table>
 */
public class C_CreditInfoTourokuGamenSyoriKbn extends Classification<C_CreditInfoTourokuGamenSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CreditInfoTourokuGamenSyoriKbn AUTHORIKAKYMDNYUURYOKU = new C_CreditInfoTourokuGamenSyoriKbn("1");

    public static final C_CreditInfoTourokuGamenSyoriKbn CREDITKESSAIYOUNOSYUTOKU = new C_CreditInfoTourokuGamenSyoriKbn("2");

    public static final C_CreditInfoTourokuGamenSyoriKbn CREDITTOUROKUKANBI = new C_CreditInfoTourokuGamenSyoriKbn("3");

    public static final C_CreditInfoTourokuGamenSyoriKbn CREDITTOUROKUHANEISYORIQR = new C_CreditInfoTourokuGamenSyoriKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, AUTHORIKAKYMDNYUURYOKU, "AUTHORIKAKYMDNYUURYOKU", true);
        addPattern(PATTERN_DEFAULT, CREDITKESSAIYOUNOSYUTOKU, "CREDITKESSAIYOUNOSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, CREDITTOUROKUKANBI, "CREDITTOUROKUKANBI", false);
        addPattern(PATTERN_DEFAULT, CREDITTOUROKUHANEISYORIQR, "CREDITTOUROKUHANEISYORIQR", false);


        lock(C_CreditInfoTourokuGamenSyoriKbn.class);
    }

    private C_CreditInfoTourokuGamenSyoriKbn(String value) {
        super(value);
    }

    public static C_CreditInfoTourokuGamenSyoriKbn valueOf(String value) {
        return valueOf(C_CreditInfoTourokuGamenSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CreditInfoTourokuGamenSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CreditInfoTourokuGamenSyoriKbn.class, patternId, value);
    }
}
