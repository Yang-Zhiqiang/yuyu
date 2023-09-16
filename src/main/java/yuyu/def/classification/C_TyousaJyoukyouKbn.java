
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 調査状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyousaJyoukyouKbn</td><td colspan="3">調査状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUSA}</td><td>&quot;1&quot;</td><td>調査中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOU}</td><td>&quot;2&quot;</td><td>回答済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;3&quot;</td><td>不備中</td></tr>
 * </table>
 */
public class C_TyousaJyoukyouKbn extends Classification<C_TyousaJyoukyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyousaJyoukyouKbn BLNK = new C_TyousaJyoukyouKbn("0");

    public static final C_TyousaJyoukyouKbn TYOUSA = new C_TyousaJyoukyouKbn("1");

    public static final C_TyousaJyoukyouKbn KAITOU = new C_TyousaJyoukyouKbn("2");

    public static final C_TyousaJyoukyouKbn HUBI = new C_TyousaJyoukyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYOUSA, "TYOUSA", false);
        addPattern(PATTERN_DEFAULT, KAITOU, "KAITOU", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);


        lock(C_TyousaJyoukyouKbn.class);
    }

    private C_TyousaJyoukyouKbn(String value) {
        super(value);
    }

    public static C_TyousaJyoukyouKbn valueOf(String value) {
        return valueOf(C_TyousaJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyousaJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyousaJyoukyouKbn.class, patternId, value);
    }
}
