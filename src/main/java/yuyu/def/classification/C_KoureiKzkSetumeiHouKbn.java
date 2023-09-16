
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 高齢者ご家族等説明方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoureiKzkSetumeiHouKbn</td><td colspan="3">高齢者ご家族等説明方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUDOUSEKI}</td><td>&quot;1&quot;</td><td>ご家族等同席</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUJIZENTAIMEN}</td><td>&quot;2&quot;</td><td>ご家族等事前説明（対面）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAZOKUJIZENYUUSOU}</td><td>&quot;3&quot;</td><td>ご家族等事前説明（郵送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JOUKIHUKA}</td><td>&quot;9&quot;</td><td>いずれも不可</td></tr>
 * </table>
 */
public class C_KoureiKzkSetumeiHouKbn extends Classification<C_KoureiKzkSetumeiHouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoureiKzkSetumeiHouKbn BLNK = new C_KoureiKzkSetumeiHouKbn("0");

    public static final C_KoureiKzkSetumeiHouKbn KAZOKUDOUSEKI = new C_KoureiKzkSetumeiHouKbn("1");

    public static final C_KoureiKzkSetumeiHouKbn KAZOKUJIZENTAIMEN = new C_KoureiKzkSetumeiHouKbn("2");

    public static final C_KoureiKzkSetumeiHouKbn KAZOKUJIZENYUUSOU = new C_KoureiKzkSetumeiHouKbn("3");

    public static final C_KoureiKzkSetumeiHouKbn JOUKIHUKA = new C_KoureiKzkSetumeiHouKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAZOKUDOUSEKI, "KAZOKUDOUSEKI", false);
        addPattern(PATTERN_DEFAULT, KAZOKUJIZENTAIMEN, "KAZOKUJIZENTAIMEN", false);
        addPattern(PATTERN_DEFAULT, KAZOKUJIZENYUUSOU, "KAZOKUJIZENYUUSOU", false);
        addPattern(PATTERN_DEFAULT, JOUKIHUKA, "JOUKIHUKA", false);


        lock(C_KoureiKzkSetumeiHouKbn.class);
    }

    private C_KoureiKzkSetumeiHouKbn(String value) {
        super(value);
    }

    public static C_KoureiKzkSetumeiHouKbn valueOf(String value) {
        return valueOf(C_KoureiKzkSetumeiHouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoureiKzkSetumeiHouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoureiKzkSetumeiHouKbn.class, patternId, value);
    }
}
