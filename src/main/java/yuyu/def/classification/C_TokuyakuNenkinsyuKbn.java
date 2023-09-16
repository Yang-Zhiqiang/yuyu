
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払特約年金種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TokuyakuNenkinsyuKbn</td><td colspan="3">年金支払特約年金種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEINENKIN}</td><td>&quot;1&quot;</td><td>確定年金</td></tr>
 * </table>
 */
public class C_TokuyakuNenkinsyuKbn extends Classification<C_TokuyakuNenkinsyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TokuyakuNenkinsyuKbn BLNK = new C_TokuyakuNenkinsyuKbn("0");

    public static final C_TokuyakuNenkinsyuKbn KAKUTEINENKIN = new C_TokuyakuNenkinsyuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUTEINENKIN, "KAKUTEINENKIN", false);


        lock(C_TokuyakuNenkinsyuKbn.class);
    }

    private C_TokuyakuNenkinsyuKbn(String value) {
        super(value);
    }

    public static C_TokuyakuNenkinsyuKbn valueOf(String value) {
        return valueOf(C_TokuyakuNenkinsyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TokuyakuNenkinsyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TokuyakuNenkinsyuKbn.class, patternId, value);
    }
}
