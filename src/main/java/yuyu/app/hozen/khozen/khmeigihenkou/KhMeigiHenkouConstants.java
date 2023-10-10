package yuyu.app.hozen.khozen.khmeigihenkou;

import jp.co.slcs.swak.date.BizDate;

/**
 * 名義変更／契約者等生年月日訂正 の定数定義クラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
public class KhMeigiHenkouConstants extends GenKhMeigiHenkouConstants {

    public static final String TABLE_NAME  = "契約者テーブル";

    public static final int WEBMSCMKYKHNC_KAISEIKAIMEI    = 1;

    public static final int WEBMSCMKYKHNC_NEWKYKNMSETTEI = 2;

    public static final String ZENNKAKUSPACE = "　";

    public static final String ASTERISK = "＊＊＊";

    public static final int ZERO_RENNO = 0;

    public static final int MAX_RENNO = 99;

    public static final String PERCENT = " ％";

    public static final String NINSUU = " 人";

    public static final String DISP_S_SHSNMKJ = "請求書送付先氏名（漢字）";

    public static final String DISP_S_SHSYNO = "請求書送付先郵便番号";

    public static final String DISP_S_SHSADR1KJ = "請求書送付先住所（漢字）";

    public static final String DISP_S_NEW_KYKNMKJ = "契約者氏名（漢字）";

    public static final String DISP_S_NEW_KYKSEIYMD = "契約者生年月日";

    public static final String DISP_S_NEW_KYKNMKN = "契約者氏名（カナ）";

    public static final String DISP_S_NEW_HHKNNMKN = "被保険者氏名（カナ）";

    public static final String DISP_S_NEW_HHKNNMKJ = "被保険者氏名（漢字）";

    public static final String DISP_N_NEW_KYKNMKJKHUKAKBN = "契約者名漢字化不可区分";

    public static final String DISP_N_NEW_HHKNNMKJKHUKAKBN = "被保険者名漢字化不可区分";

    public static final String DISP_N_NEW_KYKSEI = "契約者性別";

    public static final String DISP_N_NEW_HJNDAIYKKBN = "法人代表者役職区分";

    public static final String DISP_S_NEW_HJNDAIYKNM = "法人代表者役職名";

    public static final String DISP_S_NEW_HJNDAINMKN = "法人代表者名（カナ）";

    public static final String DISP_S_NEW_HJNDAINMKJ = "法人代表者名（漢字）";

    public static final String DISP_S_NEW_NKUKTNMKN = "年金受取人氏名（カナ）";

    public static final String DISP_S_NEW_NKUKTNMKJ = "年金受取人氏名（漢字）";

    public static final String DISP_S_NEW_NKUKTSEIYMD = "年金受取人生年月日";

    public static final String DISP_N_NEW_NKUKTTDK = "年金受取人続柄";

    public static final String DISP_S_NEW_KZUKTNMKN = "継続年金受取人氏名（カナ）";

    public static final String DISP_S_NEW_KZUKTNMKJ = "継続年金受取人氏名（漢字）";

    public static final String DISP_S_NEW_KZUKTSEIYMD = "継続年金受取人生年月日";

    public static final String DISP_N_NEW_KZUKTTDK = "継続年金受取人続柄";

    public static final String DISP_S_NEW_SBHENKANUKTNMKN = "死亡返還金受取人氏名（カナ）";

    public static final String DISP_S_NEW_SBHENKANUKTNMKJ = "死亡返還金受取人氏名（漢字）";

    public static final String DISP_S_NEW_SBHENKANUKTSEIYMD = "死亡返還金受取人生年月日";

    public static final String DISP_N_NEW_SBHENKANUKTTDK = "死亡返還金受取人続柄";

    public static final String DISP_N_NEW_STDRSKKBN = "指定代理請求人指定区分";

    public static final String DISP_S_NEW_STDRSKNMKN = "被保険者代理人氏名（カナ）";

    public static final String DISP_S_NEW_STDRSKNMKJ = "被保険者代理人氏名（漢字）";

    public static final String DISP_S_NEW_STDRSKSEIYMD = "被保険者代理人生年月日";

    public static final String DISP_N_NEW_STDRSKTTDK = "指定代理請求人続柄";

    public static final String DISP_S_NEW_SBUKTNMKN1 = "死亡保険金受取人氏名（カナ）１";

    public static final String DISP_S_NEW_SBUKTNMKN2 = "死亡保険金受取人氏名（カナ）２";

    public static final String DISP_S_NEW_SBUKTNMKN3 = "死亡保険金受取人氏名（カナ）３";

    public static final String DISP_S_NEW_SBUKTNMKN4 = "死亡保険金受取人氏名（カナ）４";

    public static final String DISP_S_NEW_SBUKTNMKN5 = "死亡保険金受取人氏名（カナ）５";

    public static final String DISP_S_NEW_SBUKTNMKJ1 = "死亡保険金受取人氏名（漢字）１";

    public static final String DISP_S_NEW_SBUKTNMKJ2 = "死亡保険金受取人氏名（漢字）２";

    public static final String DISP_S_NEW_SBUKTNMKJ3 = "死亡保険金受取人氏名（漢字）３";

    public static final String DISP_S_NEW_SBUKTNMKJ4 = "死亡保険金受取人氏名（漢字）４";

    public static final String DISP_N_TYHYSAKUSEIYHKBN = "帳票作成要否";

    public static final String DISP_N_SBUKTKBN = "死亡受取人区分";

    public static final String DISP_S_SBUKTNMKN = "死亡受取人氏名（カナ）";

    public static final String DISP_S_SBUKTNMKJ = "死亡受取人氏名（漢字）";

    public static final String DISP_S_SBUKTSEIYMD = "死亡受取人生年月日";

    public static final String DISP_S_SBUKTBNWARI = "死亡受取人分割割合";

    public static final String DISP_N_SBUKTNMKJHUKAKBN = "死亡受取人名漢字化不可区分";

    public static final String SBUKTNIN = "死亡受取人";

    public static final String DISP_N_STDRSKKBN = "被保険者代理人区分";

    public static final String DISP_N_STDRSKNMKJHUKAKBN = "被保険者代理人漢字化不可区分";

    public static final String DISP_N_HONNINKAKNINKEKKAKBN = "本人確認結果区分";

    public static final String DISP_N_HASSOUKBN = "発送区分";

    public static final String DISP_S_SHSKADRKJ = "送付先住所（漢字）";

    public static final String DISP_NEW_SBUKTNMKN = "死亡保険金受取人氏名（カナ）";

    public static final String DISP_NEW_SBUKTNMKJ = "死亡保険金受取人氏名（漢字）";

    public static final String DISP_NEW_SBUKTSEIYMD = "死亡保険金受取人生年月日";

    public static final String DISP_NEW_SBUKTTDK = "死亡保険金受取人続柄";

    public static final String DISP_NEW_SBUKTBNWARI = "死亡保険金受取人分割割合";

    public static final String DISP_TSINYNO = "郵便番号";

    public static final String DISP_TSINADRKJ = "住所（漢字）";

    public static final String DISP_TSINTELNO = "電話番号";

    public static final String DISP_DAI2TSINTELNO = "第２電話番号";

    public static final String NAIYO = "内容";

    public static final String DISP_OLDKYKSIBOUYMD = "契約者死亡日";

    public static final String DISP_SYORUIUKEYMD = "書類受付日";

    public static final String SYORIBI = "処理日";

    public static final BizDate HANTEI_DATE = BizDate.valueOf("20180101");

    public static final String KEIYAKUSYAJOUHOU = "契約者情報";

    public static final String TRKKZK1 = "登録家族（１人目）";

    public static final String TRKKZK2 = "登録家族（２人目）";

    public static final String HHKNDAIRI = "被保険者代理人";

    public static final String NENKINUKT = "年金受取人";
}
