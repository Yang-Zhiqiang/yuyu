
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ汎用顧客宛通知区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsHanyouKokyakuateTuutiKbn</td><td colspan="3">ＤＳ汎用顧客宛通知区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EMAILSOUSINERRORTUUTI}</td><td>&quot;100&quot;</td><td>Ｅメール送信エラー通知</td></tr>
 * </table>
 */
public class C_DsHanyouKokyakuateTuutiKbn extends Classification<C_DsHanyouKokyakuateTuutiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsHanyouKokyakuateTuutiKbn BLNK = new C_DsHanyouKokyakuateTuutiKbn("0");

    public static final C_DsHanyouKokyakuateTuutiKbn EMAILSOUSINERRORTUUTI = new C_DsHanyouKokyakuateTuutiKbn("100");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, EMAILSOUSINERRORTUUTI, "EMAILSOUSINERRORTUUTI", false);


        lock(C_DsHanyouKokyakuateTuutiKbn.class);
    }

    private C_DsHanyouKokyakuateTuutiKbn(String value) {
        super(value);
    }

    public static C_DsHanyouKokyakuateTuutiKbn valueOf(String value) {
        return valueOf(C_DsHanyouKokyakuateTuutiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsHanyouKokyakuateTuutiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsHanyouKokyakuateTuutiKbn.class, patternId, value);
    }
}
