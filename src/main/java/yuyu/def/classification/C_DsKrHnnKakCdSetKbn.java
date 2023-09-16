
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ仮本人確認コード設定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKrHnnKakCdSetKbn</td><td colspan="3">ＤＳ仮本人確認コード設定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI}</td><td>&quot;1&quot;</td><td>ＤＳ新規登録時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHAKKOU}</td><td>&quot;2&quot;</td><td>仮パスワードの再発行時</td></tr>
 * </table>
 */
public class C_DsKrHnnKakCdSetKbn extends Classification<C_DsKrHnnKakCdSetKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKrHnnKakCdSetKbn BLANK = new C_DsKrHnnKakCdSetKbn("0");

    public static final C_DsKrHnnKakCdSetKbn SINKI = new C_DsKrHnnKakCdSetKbn("1");

    public static final C_DsKrHnnKakCdSetKbn SAIHAKKOU = new C_DsKrHnnKakCdSetKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, SINKI, "SINKI", false);
        addPattern(PATTERN_DEFAULT, SAIHAKKOU, "SAIHAKKOU", false);


        lock(C_DsKrHnnKakCdSetKbn.class);
    }

    private C_DsKrHnnKakCdSetKbn(String value) {
        super(value);
    }

    public static C_DsKrHnnKakCdSetKbn valueOf(String value) {
        return valueOf(C_DsKrHnnKakCdSetKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKrHnnKakCdSetKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKrHnnKakCdSetKbn.class, patternId, value);
    }
}
