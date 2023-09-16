
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 協同組織金融機関適用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KydsskkinyuukntkyKbn</td><td colspan="3">協同組織金融機関適用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEKIYOU}</td><td>&quot;1&quot;</td><td>適用</td></tr>
 * </table>
 */
public class C_KydsskkinyuukntkyKbn extends Classification<C_KydsskkinyuukntkyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KydsskkinyuukntkyKbn BLNK = new C_KydsskkinyuukntkyKbn("0");

    public static final C_KydsskkinyuukntkyKbn TEKIYOU = new C_KydsskkinyuukntkyKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TEKIYOU, "TEKIYOU", false);


        lock(C_KydsskkinyuukntkyKbn.class);
    }

    private C_KydsskkinyuukntkyKbn(String value) {
        super(value);
    }

    public static C_KydsskkinyuukntkyKbn valueOf(String value) {
        return valueOf(C_KydsskkinyuukntkyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KydsskkinyuukntkyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KydsskkinyuukntkyKbn.class, patternId, value);
    }
}
