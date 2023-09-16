
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 傷病状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoubyoujyoutaiKbn</td><td colspan="3">傷病状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANTI}</td><td>&quot;1&quot;</td><td>完治</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENSYOUTYUU}</td><td>&quot;2&quot;</td><td>現症中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKIDOKI}</td><td>&quot;3&quot;</td><td>時々</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUUNENMAE}</td><td>&quot;4&quot;</td><td>数年前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;5&quot;</td><td>不明</td></tr>
 * </table>
 */
public class C_SyoubyoujyoutaiKbn extends Classification<C_SyoubyoujyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoubyoujyoutaiKbn BLNK = new C_SyoubyoujyoutaiKbn("0");

    public static final C_SyoubyoujyoutaiKbn KANTI = new C_SyoubyoujyoutaiKbn("1");

    public static final C_SyoubyoujyoutaiKbn GENSYOUTYUU = new C_SyoubyoujyoutaiKbn("2");

    public static final C_SyoubyoujyoutaiKbn TOKIDOKI = new C_SyoubyoujyoutaiKbn("3");

    public static final C_SyoubyoujyoutaiKbn SUUNENMAE = new C_SyoubyoujyoutaiKbn("4");

    public static final C_SyoubyoujyoutaiKbn HUMEI = new C_SyoubyoujyoutaiKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANTI, "KANTI", false);
        addPattern(PATTERN_DEFAULT, GENSYOUTYUU, "GENSYOUTYUU", false);
        addPattern(PATTERN_DEFAULT, TOKIDOKI, "TOKIDOKI", false);
        addPattern(PATTERN_DEFAULT, SUUNENMAE, "SUUNENMAE", false);
        addPattern(PATTERN_DEFAULT, HUMEI, "HUMEI", false);


        lock(C_SyoubyoujyoutaiKbn.class);
    }

    private C_SyoubyoujyoutaiKbn(String value) {
        super(value);
    }

    public static C_SyoubyoujyoutaiKbn valueOf(String value) {
        return valueOf(C_SyoubyoujyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoubyoujyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoubyoujyoutaiKbn.class, patternId, value);
    }
}
