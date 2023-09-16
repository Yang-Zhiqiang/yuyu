
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗データ照会対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StydatasyoukaitaisyouKbn</td><td colspan="3">進捗データ照会対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DRTESOUHUZUMIDATA}</td><td>&quot;1&quot;</td><td>代理店送付済みデータ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPROADDATA}</td><td>&quot;2&quot;</td><td>アップロードデータ</td></tr>
 * </table>
 */
public class C_StydatasyoukaitaisyouKbn extends Classification<C_StydatasyoukaitaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StydatasyoukaitaisyouKbn DRTESOUHUZUMIDATA = new C_StydatasyoukaitaisyouKbn("1");

    public static final C_StydatasyoukaitaisyouKbn UPROADDATA = new C_StydatasyoukaitaisyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DRTESOUHUZUMIDATA, "DRTESOUHUZUMIDATA", true);
        addPattern(PATTERN_DEFAULT, UPROADDATA, "UPROADDATA", false);


        lock(C_StydatasyoukaitaisyouKbn.class);
    }

    private C_StydatasyoukaitaisyouKbn(String value) {
        super(value);
    }

    public static C_StydatasyoukaitaisyouKbn valueOf(String value) {
        return valueOf(C_StydatasyoukaitaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StydatasyoukaitaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StydatasyoukaitaisyouKbn.class, patternId, value);
    }
}
