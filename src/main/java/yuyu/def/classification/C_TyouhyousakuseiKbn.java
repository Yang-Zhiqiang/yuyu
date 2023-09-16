
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyouhyousakuseiKbn</td><td colspan="3">帳票作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUU}</td><td>&quot;1&quot;</td><td>請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKYOU}</td><td>&quot;2&quot;</td><td>現況届</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUUGENKYOU}</td><td>&quot;3&quot;</td><td>請求書兼現況届</td></tr>
 * </table>
 */
public class C_TyouhyousakuseiKbn extends Classification<C_TyouhyousakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyouhyousakuseiKbn BLNK = new C_TyouhyousakuseiKbn("0");

    public static final C_TyouhyousakuseiKbn SEIKYUU = new C_TyouhyousakuseiKbn("1");

    public static final C_TyouhyousakuseiKbn GENKYOU = new C_TyouhyousakuseiKbn("2");

    public static final C_TyouhyousakuseiKbn SEIKYUUGENKYOU = new C_TyouhyousakuseiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIKYUU, "SEIKYUU", false);
        addPattern(PATTERN_DEFAULT, GENKYOU, "GENKYOU", false);
        addPattern(PATTERN_DEFAULT, SEIKYUUGENKYOU, "SEIKYUUGENKYOU", false);


        lock(C_TyouhyousakuseiKbn.class);
    }

    private C_TyouhyousakuseiKbn(String value) {
        super(value);
    }

    public static C_TyouhyousakuseiKbn valueOf(String value) {
        return valueOf(C_TyouhyousakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyouhyousakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyouhyousakuseiKbn.class, patternId, value);
    }
}
