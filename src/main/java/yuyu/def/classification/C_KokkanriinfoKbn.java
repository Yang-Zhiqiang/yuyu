
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 顧客管理情報区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KokkanriinfoKbn</td><td colspan="3">顧客管理情報区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SITEINASI}</td><td>&quot;0&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAYOSEKIHONINFO}</td><td>&quot;1&quot;</td><td>名寄せ基本情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKKYKKANRENINFO}</td><td>&quot;2&quot;</td><td>顧客契約関連情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTAKUINFO}</td><td>&quot;3&quot;</td><td>選択情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MRINFO}</td><td>&quot;4&quot;</td><td>モラルリスク情報</td></tr>
 * </table>
 */
public class C_KokkanriinfoKbn extends Classification<C_KokkanriinfoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KokkanriinfoKbn SITEINASI = new C_KokkanriinfoKbn("0");

    public static final C_KokkanriinfoKbn NAYOSEKIHONINFO = new C_KokkanriinfoKbn("1");

    public static final C_KokkanriinfoKbn KOKKYKKANRENINFO = new C_KokkanriinfoKbn("2");

    public static final C_KokkanriinfoKbn SENTAKUINFO = new C_KokkanriinfoKbn("3");

    public static final C_KokkanriinfoKbn MRINFO = new C_KokkanriinfoKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEINASI, "SITEINASI", true);
        addPattern(PATTERN_DEFAULT, NAYOSEKIHONINFO, "NAYOSEKIHONINFO", false);
        addPattern(PATTERN_DEFAULT, KOKKYKKANRENINFO, "KOKKYKKANRENINFO", false);
        addPattern(PATTERN_DEFAULT, SENTAKUINFO, "SENTAKUINFO", false);
        addPattern(PATTERN_DEFAULT, MRINFO, "MRINFO", false);


        lock(C_KokkanriinfoKbn.class);
    }

    private C_KokkanriinfoKbn(String value) {
        super(value);
    }

    public static C_KokkanriinfoKbn valueOf(String value) {
        return valueOf(C_KokkanriinfoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KokkanriinfoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KokkanriinfoKbn.class, patternId, value);
    }
}
