
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｄ精算送付先編集区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DseisansouhusakihnsyuKbn</td><td colspan="3">Ｄ精算送付先編集区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENSYUUNASI}</td><td>&quot;1&quot;</td><td>編集なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJISOUHUSAKI}</td><td>&quot;2&quot;</td><td>消滅時の送付先</td></tr>
 * </table>
 */
public class C_DseisansouhusakihnsyuKbn extends Classification<C_DseisansouhusakihnsyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DseisansouhusakihnsyuKbn BLNK = new C_DseisansouhusakihnsyuKbn("0");

    public static final C_DseisansouhusakihnsyuKbn HENSYUUNASI = new C_DseisansouhusakihnsyuKbn("1");

    public static final C_DseisansouhusakihnsyuKbn SYOUMETUJISOUHUSAKI = new C_DseisansouhusakihnsyuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HENSYUUNASI, "HENSYUUNASI", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUJISOUHUSAKI, "SYOUMETUJISOUHUSAKI", false);


        lock(C_DseisansouhusakihnsyuKbn.class);
    }

    private C_DseisansouhusakihnsyuKbn(String value) {
        super(value);
    }

    public static C_DseisansouhusakihnsyuKbn valueOf(String value) {
        return valueOf(C_DseisansouhusakihnsyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DseisansouhusakihnsyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DseisansouhusakihnsyuKbn.class, patternId, value);
    }
}
