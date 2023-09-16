
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳデータメンテナンス理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsDataMaintenanceRiyuuKbn</td><td colspan="3">ＤＳデータメンテナンス理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUJYUUTOUSYORITYUU}</td><td>&quot;1&quot;</td><td>前納充当処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMITATEKINMIHANEI}</td><td>&quot;2&quot;</td><td>積立金未反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOURYOKUHASSEIYMDMITOURAI}</td><td>&quot;3&quot;</td><td>効力発生日未到来</td></tr>
 * </table>
 */
public class C_DsDataMaintenanceRiyuuKbn extends Classification<C_DsDataMaintenanceRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsDataMaintenanceRiyuuKbn BLNK = new C_DsDataMaintenanceRiyuuKbn("0");

    public static final C_DsDataMaintenanceRiyuuKbn ZENNOUJYUUTOUSYORITYUU = new C_DsDataMaintenanceRiyuuKbn("1");

    public static final C_DsDataMaintenanceRiyuuKbn TUMITATEKINMIHANEI = new C_DsDataMaintenanceRiyuuKbn("2");

    public static final C_DsDataMaintenanceRiyuuKbn KOURYOKUHASSEIYMDMITOURAI = new C_DsDataMaintenanceRiyuuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENNOUJYUUTOUSYORITYUU, "ZENNOUJYUUTOUSYORITYUU", false);
        addPattern(PATTERN_DEFAULT, TUMITATEKINMIHANEI, "TUMITATEKINMIHANEI", false);
        addPattern(PATTERN_DEFAULT, KOURYOKUHASSEIYMDMITOURAI, "KOURYOKUHASSEIYMDMITOURAI", false);


        lock(C_DsDataMaintenanceRiyuuKbn.class);
    }

    private C_DsDataMaintenanceRiyuuKbn(String value) {
        super(value);
    }

    public static C_DsDataMaintenanceRiyuuKbn valueOf(String value) {
        return valueOf(C_DsDataMaintenanceRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsDataMaintenanceRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsDataMaintenanceRiyuuKbn.class, patternId, value);
    }
}
