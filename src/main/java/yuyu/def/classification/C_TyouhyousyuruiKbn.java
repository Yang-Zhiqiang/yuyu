
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyouhyousyuruiKbn</td><td colspan="3">帳票種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="25">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSYOUSYO}</td><td>&quot;1&quot;</td><td>年金証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUHUANNAI}</td><td>&quot;2&quot;</td><td>送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSEIKYUU}</td><td>&quot;3&quot;</td><td>年金請求書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKYOU}</td><td>&quot;4&quot;</td><td>現況届出書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;5&quot;</td><td>支払明細書・手続完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEKKA}</td><td>&quot;6&quot;</td><td>支払明細書・手続結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKNSYKN}</td><td>&quot;7&quot;</td><td>保険証券</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;21&quot;</td><td>手続結果・一括支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBITIJI}</td><td>&quot;22&quot;</td><td>手続結果・死亡一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTRN}</td><td>&quot;23&quot;</td><td>手続結果・受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGI}</td><td>&quot;24&quot;</td><td>手続結果・名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA}</td><td>&quot;25&quot;</td><td>手続結果・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNSHRKAISUU}</td><td>&quot;26&quot;</td><td>手続結果・分割回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHAKKOU}</td><td>&quot;27&quot;</td><td>手続結果・再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSYLIST}</td><td>&quot;51&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSHRTYOUSYO}</td><td>&quot;52&quot;</td><td>年金支払調書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKSHRTYOUSYOKEI}</td><td>&quot;53&quot;</td><td>年金支払調書合計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJSHRTYOUSYO}</td><td>&quot;54&quot;</td><td>一時金支払調書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJSHRTYOUSYOKEI}</td><td>&quot;55&quot;</td><td>一時金支払調書合計表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIMISSLIST}</td><td>&quot;91&quot;</td><td>年金情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSHRMISSLIST}</td><td>&quot;92&quot;</td><td>自動支払ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ANNAIMISSLIST}</td><td>&quot;93&quot;</td><td>年金案内ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAINFOMISSLIST}</td><td>&quot;94&quot;</td><td>口座情報マスタチェックミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEINFOMISSLIST}</td><td>&quot;95&quot;</td><td>オンラインチェックリスト</td></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_BLANK BLANK}<br />(ブランクあり)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;21&quot;</td><td>手続結果・一括支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBITIJI}</td><td>&quot;22&quot;</td><td>手続結果・死亡一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTRN}</td><td>&quot;23&quot;</td><td>手続結果・受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGI}</td><td>&quot;24&quot;</td><td>手続結果・名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA}</td><td>&quot;25&quot;</td><td>手続結果・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNSHRKAISUU}</td><td>&quot;26&quot;</td><td>手続結果・分割回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHAKKOU}</td><td>&quot;27&quot;</td><td>手続結果・再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSYLIST}</td><td>&quot;51&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIMISSLIST}</td><td>&quot;91&quot;</td><td>年金情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSHRMISSLIST}</td><td>&quot;92&quot;</td><td>自動支払ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAINFOMISSLIST}</td><td>&quot;94&quot;</td><td>口座情報マスタチェックミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEINFOMISSLIST}</td><td>&quot;95&quot;</td><td>オンラインチェックリスト</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #IKKATU}</td><td>&quot;21&quot;</td><td>手続結果・一括支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBITIJI}</td><td>&quot;22&quot;</td><td>手続結果・死亡一時金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTRN}</td><td>&quot;23&quot;</td><td>手続結果・受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGI}</td><td>&quot;24&quot;</td><td>手続結果・名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA}</td><td>&quot;25&quot;</td><td>手続結果・口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNSHRKAISUU}</td><td>&quot;26&quot;</td><td>手続結果・分割回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHAKKOU}</td><td>&quot;27&quot;</td><td>手続結果・再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GSTYSYLIST}</td><td>&quot;51&quot;</td><td>源泉徴収リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIMISSLIST}</td><td>&quot;91&quot;</td><td>年金情報取込ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSHRMISSLIST}</td><td>&quot;92&quot;</td><td>自動支払ミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAINFOMISSLIST}</td><td>&quot;94&quot;</td><td>口座情報マスタチェックミスリスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEINFOMISSLIST}</td><td>&quot;95&quot;</td><td>オンラインチェックリスト</td></tr>
 * </table>
 */
public class C_TyouhyousyuruiKbn extends Classification<C_TyouhyousyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyouhyousyuruiKbn BLNK = new C_TyouhyousyuruiKbn("0");

    public static final C_TyouhyousyuruiKbn NKSYOUSYO = new C_TyouhyousyuruiKbn("1");

    public static final C_TyouhyousyuruiKbn SOUHUANNAI = new C_TyouhyousyuruiKbn("2");

    public static final C_TyouhyousyuruiKbn NKSEIKYUU = new C_TyouhyousyuruiKbn("3");

    public static final C_TyouhyousyuruiKbn GENKYOU = new C_TyouhyousyuruiKbn("4");

    public static final C_TyouhyousyuruiKbn KANRYOU = new C_TyouhyousyuruiKbn("5");

    public static final C_TyouhyousyuruiKbn KEKKA = new C_TyouhyousyuruiKbn("6");

    public static final C_TyouhyousyuruiKbn HKNSYKN = new C_TyouhyousyuruiKbn("7");

    public static final C_TyouhyousyuruiKbn IKKATU = new C_TyouhyousyuruiKbn("21");

    public static final C_TyouhyousyuruiKbn SBITIJI = new C_TyouhyousyuruiKbn("22");

    public static final C_TyouhyousyuruiKbn UKTRN = new C_TyouhyousyuruiKbn("23");

    public static final C_TyouhyousyuruiKbn MEIGI = new C_TyouhyousyuruiKbn("24");

    public static final C_TyouhyousyuruiKbn KOUZA = new C_TyouhyousyuruiKbn("25");

    public static final C_TyouhyousyuruiKbn BNSHRKAISUU = new C_TyouhyousyuruiKbn("26");

    public static final C_TyouhyousyuruiKbn SAIHAKKOU = new C_TyouhyousyuruiKbn("27");

    public static final C_TyouhyousyuruiKbn GSTYSYLIST = new C_TyouhyousyuruiKbn("51");

    public static final C_TyouhyousyuruiKbn NKSHRTYOUSYO = new C_TyouhyousyuruiKbn("52");

    public static final C_TyouhyousyuruiKbn NKSHRTYOUSYOKEI = new C_TyouhyousyuruiKbn("53");

    public static final C_TyouhyousyuruiKbn ITJSHRTYOUSYO = new C_TyouhyousyuruiKbn("54");

    public static final C_TyouhyousyuruiKbn ITJSHRTYOUSYOKEI = new C_TyouhyousyuruiKbn("55");

    public static final C_TyouhyousyuruiKbn TORIKOMIMISSLIST = new C_TyouhyousyuruiKbn("91");

    public static final C_TyouhyousyuruiKbn JIDOUSHRMISSLIST = new C_TyouhyousyuruiKbn("92");

    public static final C_TyouhyousyuruiKbn ANNAIMISSLIST = new C_TyouhyousyuruiKbn("93");

    public static final C_TyouhyousyuruiKbn KOUZAINFOMISSLIST = new C_TyouhyousyuruiKbn("94");

    public static final C_TyouhyousyuruiKbn ONLINEINFOMISSLIST = new C_TyouhyousyuruiKbn("95");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_BLANK = "2";

    public static final String PATTERN_NOBLNK = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NKSYOUSYO, "NKSYOUSYO", false);
        addPattern(PATTERN_DEFAULT, SOUHUANNAI, "SOUHUANNAI", false);
        addPattern(PATTERN_DEFAULT, NKSEIKYUU, "NKSEIKYUU", false);
        addPattern(PATTERN_DEFAULT, GENKYOU, "GENKYOU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, KEKKA, "KEKKA", false);
        addPattern(PATTERN_DEFAULT, HKNSYKN, "HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, IKKATU, "IKKATU", false);
        addPattern(PATTERN_DEFAULT, SBITIJI, "SBITIJI", false);
        addPattern(PATTERN_DEFAULT, UKTRN, "UKTRN", false);
        addPattern(PATTERN_DEFAULT, MEIGI, "MEIGI", false);
        addPattern(PATTERN_DEFAULT, KOUZA, "KOUZA", false);
        addPattern(PATTERN_DEFAULT, BNSHRKAISUU, "BNSHRKAISUU", false);
        addPattern(PATTERN_DEFAULT, SAIHAKKOU, "SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, GSTYSYLIST, "GSTYSYLIST", false);
        addPattern(PATTERN_DEFAULT, NKSHRTYOUSYO, "NKSHRTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, NKSHRTYOUSYOKEI, "NKSHRTYOUSYOKEI", false);
        addPattern(PATTERN_DEFAULT, ITJSHRTYOUSYO, "ITJSHRTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, ITJSHRTYOUSYOKEI, "ITJSHRTYOUSYOKEI", false);
        addPattern(PATTERN_DEFAULT, TORIKOMIMISSLIST, "TORIKOMIMISSLIST", false);
        addPattern(PATTERN_DEFAULT, JIDOUSHRMISSLIST, "JIDOUSHRMISSLIST", false);
        addPattern(PATTERN_DEFAULT, ANNAIMISSLIST, "ANNAIMISSLIST", false);
        addPattern(PATTERN_DEFAULT, KOUZAINFOMISSLIST, "KOUZAINFOMISSLIST", false);
        addPattern(PATTERN_DEFAULT, ONLINEINFOMISSLIST, "ONLINEINFOMISSLIST", false);


        addPattern(PATTERN_BLANK, BLNK, "BLNK", false);
        addPattern(PATTERN_BLANK, IKKATU, "IKKATU", false);
        addPattern(PATTERN_BLANK, SBITIJI, "SBITIJI", false);
        addPattern(PATTERN_BLANK, UKTRN, "UKTRN", false);
        addPattern(PATTERN_BLANK, MEIGI, "MEIGI", false);
        addPattern(PATTERN_BLANK, KOUZA, "KOUZA", false);
        addPattern(PATTERN_BLANK, BNSHRKAISUU, "BNSHRKAISUU", false);
        addPattern(PATTERN_BLANK, SAIHAKKOU, "SAIHAKKOU", false);
        addPattern(PATTERN_BLANK, GSTYSYLIST, "GSTYSYLIST", false);
        addPattern(PATTERN_BLANK, TORIKOMIMISSLIST, "TORIKOMIMISSLIST", false);
        addPattern(PATTERN_BLANK, JIDOUSHRMISSLIST, "JIDOUSHRMISSLIST", false);
        addPattern(PATTERN_BLANK, KOUZAINFOMISSLIST, "KOUZAINFOMISSLIST", false);
        addPattern(PATTERN_BLANK, ONLINEINFOMISSLIST, "ONLINEINFOMISSLIST", false);


        addPattern(PATTERN_NOBLNK, IKKATU, "IKKATU", false);
        addPattern(PATTERN_NOBLNK, SBITIJI, "SBITIJI", false);
        addPattern(PATTERN_NOBLNK, UKTRN, "UKTRN", false);
        addPattern(PATTERN_NOBLNK, MEIGI, "MEIGI", false);
        addPattern(PATTERN_NOBLNK, KOUZA, "KOUZA", false);
        addPattern(PATTERN_NOBLNK, BNSHRKAISUU, "BNSHRKAISUU", false);
        addPattern(PATTERN_NOBLNK, SAIHAKKOU, "SAIHAKKOU", false);
        addPattern(PATTERN_NOBLNK, GSTYSYLIST, "GSTYSYLIST", false);
        addPattern(PATTERN_NOBLNK, TORIKOMIMISSLIST, "TORIKOMIMISSLIST", false);
        addPattern(PATTERN_NOBLNK, JIDOUSHRMISSLIST, "JIDOUSHRMISSLIST", false);
        addPattern(PATTERN_NOBLNK, KOUZAINFOMISSLIST, "KOUZAINFOMISSLIST", false);
        addPattern(PATTERN_NOBLNK, ONLINEINFOMISSLIST, "ONLINEINFOMISSLIST", false);


        lock(C_TyouhyousyuruiKbn.class);
    }

    private C_TyouhyousyuruiKbn(String value) {
        super(value);
    }

    public static C_TyouhyousyuruiKbn valueOf(String value) {
        return valueOf(C_TyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyouhyousyuruiKbn.class, patternId, value);
    }
}
