
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通知履歴対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TuutirirekiTaisyouKbn</td><td colspan="3">通知履歴対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SYOUKENNO}</td><td>&quot;11&quot;</td><td>証券番号</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKOKYAKUNO}</td><td>&quot;14&quot;</td><td>DS顧客番号</td></tr>
 * </table>
 */
public class C_TuutirirekiTaisyouKbn extends Classification<C_TuutirirekiTaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TuutirirekiTaisyouKbn SYOUKENNO = new C_TuutirirekiTaisyouKbn("11");

    public static final C_TuutirirekiTaisyouKbn DSKOKYAKUNO = new C_TuutirirekiTaisyouKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYOUKENNO, "SYOUKENNO", false);
        addPattern(PATTERN_DEFAULT, DSKOKYAKUNO, "DSKOKYAKUNO", false);


        lock(C_TuutirirekiTaisyouKbn.class);
    }

    private C_TuutirirekiTaisyouKbn(String value) {
        super(value);
    }

    public static C_TuutirirekiTaisyouKbn valueOf(String value) {
        return valueOf(C_TuutirirekiTaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TuutirirekiTaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TuutirirekiTaisyouKbn.class, patternId, value);
    }
}
