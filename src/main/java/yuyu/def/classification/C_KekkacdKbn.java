
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理結果コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KekkacdKbn</td><td colspan="3">処理結果コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUMUERR}</td><td>&quot;1&quot;</td><td>業務エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NINSYOUERR}</td><td>&quot;2&quot;</td><td>認証エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KADOUJIKANGAI}</td><td>&quot;3&quot;</td><td>稼働時間外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEMERR}</td><td>&quot;9&quot;</td><td>その他システムエラー</td></tr>
 * </table>
 */
public class C_KekkacdKbn extends Classification<C_KekkacdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KekkacdKbn SEIJYOU = new C_KekkacdKbn("0");

    public static final C_KekkacdKbn GYOUMUERR = new C_KekkacdKbn("1");

    public static final C_KekkacdKbn NINSYOUERR = new C_KekkacdKbn("2");

    public static final C_KekkacdKbn KADOUJIKANGAI = new C_KekkacdKbn("3");

    public static final C_KekkacdKbn SYSTEMERR = new C_KekkacdKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, GYOUMUERR, "GYOUMUERR", false);
        addPattern(PATTERN_DEFAULT, NINSYOUERR, "NINSYOUERR", false);
        addPattern(PATTERN_DEFAULT, KADOUJIKANGAI, "KADOUJIKANGAI", false);
        addPattern(PATTERN_DEFAULT, SYSTEMERR, "SYSTEMERR", false);


        lock(C_KekkacdKbn.class);
    }

    private C_KekkacdKbn(String value) {
        super(value);
    }

    public static C_KekkacdKbn valueOf(String value) {
        return valueOf(C_KekkacdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KekkacdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KekkacdKbn.class, patternId, value);
    }
}
