
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 暗号化区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_EncryptKbn</td><td colspan="3">暗号化区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SURU}</td><td>&quot;0&quot;</td><td>する</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINAI}</td><td>&quot;1&quot;</td><td>しない</td></tr>
 * </table>
 */
public class C_EncryptKbn extends Classification<C_EncryptKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_EncryptKbn SURU = new C_EncryptKbn("0");

    public static final C_EncryptKbn SINAI = new C_EncryptKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SURU, "SURU", true);
        addPattern(PATTERN_DEFAULT, SINAI, "SINAI", false);


        lock(C_EncryptKbn.class);
    }

    private C_EncryptKbn(String value) {
        super(value);
    }

    public static C_EncryptKbn valueOf(String value) {
        return valueOf(C_EncryptKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_EncryptKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_EncryptKbn.class, patternId, value);
    }
}
