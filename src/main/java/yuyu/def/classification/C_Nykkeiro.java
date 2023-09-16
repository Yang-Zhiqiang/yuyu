
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金経路 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nykkeiro</td><td colspan="3">入金経路</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHRK}</td><td>&quot;10&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;20&quot;</td><td>クレジット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENI}</td><td>&quot;30&quot;</td><td>コンビニ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANK}</td><td>&quot;40&quot;</td><td>銀行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUJYUUTOU}</td><td>&quot;60&quot;</td><td>前納充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKIN}</td><td>&quot;70&quot;</td><td>給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKIN}</td><td>&quot;75&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;80&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;90&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SELECT SELECT}<br />(案内収納利用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHRK}</td><td>&quot;10&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;20&quot;</td><td>クレジット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANK}</td><td>&quot;40&quot;</td><td>本社口座振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;90&quot;</td><td>機械作成</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DISP DISP}<br />(表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZHRK}</td><td>&quot;10&quot;</td><td>口座振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDIT}</td><td>&quot;20&quot;</td><td>クレジット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENI}</td><td>&quot;30&quot;</td><td>コンビニ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANK}</td><td>&quot;40&quot;</td><td>本社口座振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUJYUUTOU}</td><td>&quot;60&quot;</td><td>前納充当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKIN}</td><td>&quot;70&quot;</td><td>給付金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNKIN}</td><td>&quot;75&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;80&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;90&quot;</td><td>機械作成</td></tr>
 * </table>
 */
public class C_Nykkeiro extends Classification<C_Nykkeiro> {

    private static final long serialVersionUID = 1L;


    public static final C_Nykkeiro BLNK = new C_Nykkeiro("0");

    public static final C_Nykkeiro KZHRK = new C_Nykkeiro("10");

    public static final C_Nykkeiro CREDIT = new C_Nykkeiro("20");

    public static final C_Nykkeiro CONVENI = new C_Nykkeiro("30");

    public static final C_Nykkeiro BANK = new C_Nykkeiro("40");

    public static final C_Nykkeiro ZENNOUJYUUTOU = new C_Nykkeiro("60");

    public static final C_Nykkeiro KYHKIN = new C_Nykkeiro("70");

    public static final C_Nykkeiro HKNKIN = new C_Nykkeiro("75");

    public static final C_Nykkeiro SKEI = new C_Nykkeiro("80");

    public static final C_Nykkeiro OTHER = new C_Nykkeiro("90");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_DISP = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KZHRK, "KZHRK", false);
        addPattern(PATTERN_DEFAULT, CREDIT, "CREDIT", false);
        addPattern(PATTERN_DEFAULT, CONVENI, "CONVENI", false);
        addPattern(PATTERN_DEFAULT, BANK, "BANK", false);
        addPattern(PATTERN_DEFAULT, ZENNOUJYUUTOU, "ZENNOUJYUUTOU", false);
        addPattern(PATTERN_DEFAULT, KYHKIN, "KYHKIN", false);
        addPattern(PATTERN_DEFAULT, HKNKIN, "HKNKIN", false);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KZHRK, "KZHRK", false);
        addPattern(PATTERN_SELECT, CREDIT, "CREDIT", false);
        addPattern(PATTERN_SELECT, BANK, "BANK", false);
        addPattern(PATTERN_SELECT, OTHER, "OTHER", false);


        addPattern(PATTERN_DISP, BLNK, "BLNK", true);
        addPattern(PATTERN_DISP, KZHRK, "KZHRK", false);
        addPattern(PATTERN_DISP, CREDIT, "CREDIT", false);
        addPattern(PATTERN_DISP, CONVENI, "CONVENI", false);
        addPattern(PATTERN_DISP, BANK, "BANK", false);
        addPattern(PATTERN_DISP, ZENNOUJYUUTOU, "ZENNOUJYUUTOU", false);
        addPattern(PATTERN_DISP, KYHKIN, "KYHKIN", false);
        addPattern(PATTERN_DISP, HKNKIN, "HKNKIN", false);
        addPattern(PATTERN_DISP, SKEI, "SKEI", false);
        addPattern(PATTERN_DISP, OTHER, "OTHER", false);


        lock(C_Nykkeiro.class);
    }

    private C_Nykkeiro(String value) {
        super(value);
    }

    public static C_Nykkeiro valueOf(String value) {
        return valueOf(C_Nykkeiro.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nykkeiro.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nykkeiro.class, patternId, value);
    }
}
