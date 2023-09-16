
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取得対象その他特約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GetTaisyouSonotaTokuyakuKbn</td><td colspan="3">取得対象その他特約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYKSBYENSITIHSYUTKYK}</td><td>&quot;1&quot;</td><td>初期死亡時円換算最低保証特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETTOKUYAKU}</td><td>&quot;2&quot;</td><td>ターゲット特約</td></tr>
 * </table>
 */
public class C_GetTaisyouSonotaTokuyakuKbn extends Classification<C_GetTaisyouSonotaTokuyakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GetTaisyouSonotaTokuyakuKbn BLNK = new C_GetTaisyouSonotaTokuyakuKbn("0");

    public static final C_GetTaisyouSonotaTokuyakuKbn SYKSBYENSITIHSYUTKYK = new C_GetTaisyouSonotaTokuyakuKbn("1");

    public static final C_GetTaisyouSonotaTokuyakuKbn TARGETTOKUYAKU = new C_GetTaisyouSonotaTokuyakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYKSBYENSITIHSYUTKYK, "SYKSBYENSITIHSYUTKYK", false);
        addPattern(PATTERN_DEFAULT, TARGETTOKUYAKU, "TARGETTOKUYAKU", false);


        lock(C_GetTaisyouSonotaTokuyakuKbn.class);
    }

    private C_GetTaisyouSonotaTokuyakuKbn(String value) {
        super(value);
    }

    public static C_GetTaisyouSonotaTokuyakuKbn valueOf(String value) {
        return valueOf(C_GetTaisyouSonotaTokuyakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GetTaisyouSonotaTokuyakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GetTaisyouSonotaTokuyakuKbn.class, patternId, value);
    }
}
