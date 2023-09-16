
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡仮受付情報作成起動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SiMakeSbKariUktkKidouKbn</td><td colspan="3">死亡仮受付情報作成起動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETTYUU}</td><td>&quot;1&quot;</td><td>15日起動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUMATU}</td><td>&quot;2&quot;</td><td>月末起動</td></tr>
 * </table>
 */
public class C_SiMakeSbKariUktkKidouKbn extends Classification<C_SiMakeSbKariUktkKidouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SiMakeSbKariUktkKidouKbn BLNK = new C_SiMakeSbKariUktkKidouKbn("0");

    public static final C_SiMakeSbKariUktkKidouKbn GETTYUU = new C_SiMakeSbKariUktkKidouKbn("1");

    public static final C_SiMakeSbKariUktkKidouKbn GETUMATU = new C_SiMakeSbKariUktkKidouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GETTYUU, "GETTYUU", false);
        addPattern(PATTERN_DEFAULT, GETUMATU, "GETUMATU", false);


        lock(C_SiMakeSbKariUktkKidouKbn.class);
    }

    private C_SiMakeSbKariUktkKidouKbn(String value) {
        super(value);
    }

    public static C_SiMakeSbKariUktkKidouKbn valueOf(String value) {
        return valueOf(C_SiMakeSbKariUktkKidouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SiMakeSbKariUktkKidouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SiMakeSbKariUktkKidouKbn.class, patternId, value);
    }
}
