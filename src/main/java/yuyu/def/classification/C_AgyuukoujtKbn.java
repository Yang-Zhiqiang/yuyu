
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店有効状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AgyuukoujtKbn</td><td colspan="3">代理店有効状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;2&quot;</td><td>消滅</td></tr>
 * </table>
 */
public class C_AgyuukoujtKbn extends Classification<C_AgyuukoujtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AgyuukoujtKbn YUUKOU = new C_AgyuukoujtKbn("1");

    public static final C_AgyuukoujtKbn SYOUMETU = new C_AgyuukoujtKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", true);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);


        lock(C_AgyuukoujtKbn.class);
    }

    private C_AgyuukoujtKbn(String value) {
        super(value);
    }

    public static C_AgyuukoujtKbn valueOf(String value) {
        return valueOf(C_AgyuukoujtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AgyuukoujtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AgyuukoujtKbn.class, patternId, value);
    }
}
