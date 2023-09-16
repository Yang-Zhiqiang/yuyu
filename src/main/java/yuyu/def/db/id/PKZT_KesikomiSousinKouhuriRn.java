package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.mapping.GenZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.GenQZT_KesikomiSousinKouhuriRn;
import yuyu.def.db.meta.QZT_KesikomiSousinKouhuriRn;

/**
 * 消込送信Ｆ（口振）テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KesikomiSousinKouhuriRn}</td><td colspan="3">消込送信Ｆ（口振）テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkskmsousinrenno zrnkskmsousinrenno}</td><td>（連携用）消込送信連番</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmkamokucd</td><td>（連携用）消込科目コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuitoukbn</td><td>（連携用）出納区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuitousosikicd</td><td>（連携用）出納組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhasseidenymd</td><td>（連携用）発生伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkarikanjyono</td><td>（連携用）仮勘定番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkakusyounyuuryokuymd1</td><td>（連携用）入金確証入力年月日１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrniktannaidantaizaikeikbn</td><td>（連携用）一括案内団体財形区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfanniskcd</td><td>（連携用）（消込Ｆ）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaiannaijyuutouym1</td><td>（連携用）団体案内充当年月１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaino1</td><td>（連携用）案内番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbonusharaihyouji1</td><td>（連携用）ボーナス払表示１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfkzhurikaebankcd</td><td>（連携用）（消込Ｆ）口座振替銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfhurikaeymd</td><td>（連携用）（消込Ｆ）振替年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenuketukeno1</td><td>（連携用）代理店受付番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzaikeihrkkaisuukbn1</td><td>（連携用）財形払込回数区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnoukinhyouno</td><td>（連携用）納金票番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfcreditkaisyacd</td><td>（連携用）（消込Ｆ）クレジット会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukikankbn</td><td>（連携用）金融機関区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv18</td><td>（連携用）予備項目Ｖ１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkskmfsyoriymd zrnkskmfsyoriymd}</td><td>（連携用）（消込Ｆ）処理年月日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfdenymd</td><td>（連携用）（消込Ｆ）伝票日付</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndenatesakicd</td><td>（連携用）伝票宛先部課コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmftaisyakukbn</td><td>（連携用）（消込Ｆ）貸借区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhutuuhokenkamokucd</td><td>（連携用）普通保険用科目コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndengk</td><td>（連携用）伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntabakariknjykskmdatakbn</td><td>（連携用）束仮勘定消込項目データ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfryousyuuymd</td><td>（連携用）（消込Ｆ）領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryousyuuhm</td><td>（連携用）領収時分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkakusyounyuuryokuymd2</td><td>（連携用）入金確証入力年月日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfsyono</td><td>（連携用）（消込Ｆ）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkhoukokuhyoutantouka</td><td>（連携用）入金報告票担当課</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkhoukokuhyoukihyouymd</td><td>（連携用）入金報告票起票年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkhoukokuhyoubunkaino</td><td>（連携用）入金報告票分解表番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkakusyounyuuryokuno</td><td>（連携用）入金確証入力番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfdantaicd</td><td>（連携用）（消込Ｆ）団体コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaiannaijyuutouym2</td><td>（連携用）団体案内充当年月２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbonusharaihyouji2</td><td>（連携用）ボーナス払表示２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaino2</td><td>（連携用）案内番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantaipkbn</td><td>（連携用）団体保険料区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndantainyuukinymd</td><td>（連携用）団体入金年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfjyuutouym</td><td>（連携用）（消込Ｆ）充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuitouymd</td><td>（連携用）出納年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyuuryokuhouhoukbn</td><td>（連携用）入力方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfnyknaiyoukbn</td><td>（連携用）（消込Ｆ）入金内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaekykhndnkhyouji</td><td>（連携用）口座振替契約ハンド入金表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfdairitencd</td><td>（連携用）（消込Ｆ）代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenuketukeno2</td><td>（連携用）代理店受付番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatudantaicd</td><td>（連携用）一括団体コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatuannaihikisariym</td><td>（連携用）一括案内引去年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnikkatuannaino</td><td>（連携用）一括案内番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzaikeihrkkaisuukbn2</td><td>（連携用）財形払込回数区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzaikeikyksyano</td><td>（連携用）財形契約者番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhasseisosikicd</td><td>（連携用）発生組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikeisakikaisyacd</td><td>（連携用）提携先会社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmfbankcd</td><td>（連携用）（消込Ｆ）銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuitousyorisosikicd</td><td>（連携用）出納処理組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaitekanjyouyomikaekbn</td><td>（連携用）相手勘定読替区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditcardhrkskmkbn</td><td>（連携用）クレ払消込区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlastteiseiymd</td><td>（連携用）最終訂正年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmkanryouymd</td><td>（連携用）消込完了年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmteiseino</td><td>（連携用）消込訂正番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkskmkanryousijihyouji</td><td>（連携用）消込完了指示表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuketuketencd</td><td>（連携用）受付店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncvscd</td><td>（連携用）ＣＶＳコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikomiyousinyuukinkbn</td><td>（連携用）振込用紙入金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikomiyousiokyksmno</td><td>（連携用）振込用紙お客さま番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikomiyousikakuninno</td><td>（連携用）振込用紙確認番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnegsyokuinhurikomiymd</td><td>（連携用）営業職員振込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvitkaiinno</td><td>（連携用）Ｖｉｔ会員番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv74</td><td>（連携用）予備項目Ｖ７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KesikomiSousinKouhuriRn
 * @see     GenZT_KesikomiSousinKouhuriRn
 * @see     QZT_KesikomiSousinKouhuriRn
 * @see     GenQZT_KesikomiSousinKouhuriRn
 */
public class PKZT_KesikomiSousinKouhuriRn extends AbstractExDBPrimaryKey<ZT_KesikomiSousinKouhuriRn, PKZT_KesikomiSousinKouhuriRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KesikomiSousinKouhuriRn() {
    }

    public PKZT_KesikomiSousinKouhuriRn(String pZrnkskmsousinrenno, String pZrnkskmfsyoriymd) {
        zrnkskmsousinrenno = pZrnkskmsousinrenno;
        zrnkskmfsyoriymd = pZrnkskmfsyoriymd;
    }

    @Transient
    @Override
    public Class<ZT_KesikomiSousinKouhuriRn> getEntityClass() {
        return ZT_KesikomiSousinKouhuriRn.class;
    }

    private String zrnkskmsousinrenno;

    public String getZrnkskmsousinrenno() {
        return zrnkskmsousinrenno;
    }

    public void setZrnkskmsousinrenno(String pZrnkskmsousinrenno) {
        zrnkskmsousinrenno = pZrnkskmsousinrenno;
    }
    private String zrnkskmfsyoriymd;

    public String getZrnkskmfsyoriymd() {
        return zrnkskmfsyoriymd;
    }

    public void setZrnkskmfsyoriymd(String pZrnkskmfsyoriymd) {
        zrnkskmfsyoriymd = pZrnkskmfsyoriymd;
    }

}