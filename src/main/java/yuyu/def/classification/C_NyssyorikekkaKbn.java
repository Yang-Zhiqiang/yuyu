
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ処理結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyssyorikekkaKbn</td><td colspan="3">名寄せ処理結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NYS_KAKUTEI_KIZON}</td><td>&quot;1&quot;</td><td>名寄せ確定（既存顧客）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYS_KAKUTEI_SINKI}</td><td>&quot;2&quot;</td><td>名寄せ確定（新規顧客）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYS_MIKAKUNIN}</td><td>&quot;3&quot;</td><td>名寄せ未確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYS_HUMEI}</td><td>&quot;4&quot;</td><td>名寄せ不明</td></tr>
 * </table>
 */
public class C_NyssyorikekkaKbn extends Classification<C_NyssyorikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyssyorikekkaKbn NYS_KAKUTEI_KIZON = new C_NyssyorikekkaKbn("1");

    public static final C_NyssyorikekkaKbn NYS_KAKUTEI_SINKI = new C_NyssyorikekkaKbn("2");

    public static final C_NyssyorikekkaKbn NYS_MIKAKUNIN = new C_NyssyorikekkaKbn("3");

    public static final C_NyssyorikekkaKbn NYS_HUMEI = new C_NyssyorikekkaKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NYS_KAKUTEI_KIZON, "NYS_KAKUTEI_KIZON", true);
        addPattern(PATTERN_DEFAULT, NYS_KAKUTEI_SINKI, "NYS_KAKUTEI_SINKI", false);
        addPattern(PATTERN_DEFAULT, NYS_MIKAKUNIN, "NYS_MIKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, NYS_HUMEI, "NYS_HUMEI", false);


        lock(C_NyssyorikekkaKbn.class);
    }

    private C_NyssyorikekkaKbn(String value) {
        super(value);
    }

    public static C_NyssyorikekkaKbn valueOf(String value) {
        return valueOf(C_NyssyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyssyorikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyssyorikekkaKbn.class, patternId, value);
    }
}
