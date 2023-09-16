
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * クロス特例区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CrosstkKbn</td><td colspan="3">クロス特例区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>クロス特例なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>クロス特例有</td></tr>
 * </table>
 */
public class C_CrosstkKbn extends Classification<C_CrosstkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CrosstkKbn NONE = new C_CrosstkKbn("0");

    public static final C_CrosstkKbn ARI = new C_CrosstkKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        lock(C_CrosstkKbn.class);
    }

    private C_CrosstkKbn(String value) {
        super(value);
    }

    public static C_CrosstkKbn valueOf(String value) {
        return valueOf(C_CrosstkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CrosstkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CrosstkKbn.class, patternId, value);
    }
}
