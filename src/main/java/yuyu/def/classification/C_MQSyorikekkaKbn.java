
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱ処理結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MQSyorikekkaKbn</td><td colspan="3">ＭＱ処理結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_MQSyorikekkaKbn extends Classification<C_MQSyorikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MQSyorikekkaKbn SEIJYOU = new C_MQSyorikekkaKbn("0");

    public static final C_MQSyorikekkaKbn ERROR = new C_MQSyorikekkaKbn("1");

    public static final C_MQSyorikekkaKbn BLNK = new C_MQSyorikekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_MQSyorikekkaKbn.class);
    }

    private C_MQSyorikekkaKbn(String value) {
        super(value);
    }

    public static C_MQSyorikekkaKbn valueOf(String value) {
        return valueOf(C_MQSyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MQSyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MQSyorikekkaKbn.class, patternId, value);
    }
}
