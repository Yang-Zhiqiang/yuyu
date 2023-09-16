package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KesikomiSousinCreditTy;
import yuyu.def.db.mapping.GenZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.GenQZT_KesikomiSousinCreditTy;
import yuyu.def.db.meta.QZT_KesikomiSousinCreditTy;

/**
 * 消込送信Ｆ（クレ払）テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KesikomiSousinCreditTy}</td><td colspan="3">消込送信Ｆ（クレ払）テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykskmsousinrenno ztykskmsousinrenno}</td><td>（中継用）消込送信連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmkamokucd</td><td>（中継用）消込科目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuitoukbn</td><td>（中継用）出納区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuitousosikicd</td><td>（中継用）出納組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhasseidenymd</td><td>（中継用）発生伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykarikanjyono</td><td>（中継用）仮勘定番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkakusyounyuuryokuymd1</td><td>（中継用）入金確証入力年月日１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyiktannaidantaizaikeikbn</td><td>（中継用）一括案内団体財形区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfanniskcd</td><td>（中継用）（消込Ｆ）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaiannaijyuutouym1</td><td>（中継用）団体案内充当年月１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaino1</td><td>（中継用）案内番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybonusharaihyouji1</td><td>（中継用）ボーナス払表示１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfkzhurikaebankcd</td><td>（中継用）（消込Ｆ）口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfhurikaeymd</td><td>（中継用）（消込Ｆ）振替年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenuketukeno1</td><td>（中継用）代理店受付番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzaikeihrkkaisuukbn1</td><td>（中継用）財形払込回数区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynoukinhyouno</td><td>（中継用）納金票番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfcreditkaisyacd</td><td>（中継用）（消込Ｆ）クレジット会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykinyuukikankbn</td><td>（中継用）金融機関区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv18</td><td>（中継用）予備項目Ｖ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykskmfsyoriymd ztykskmfsyoriymd}</td><td>（中継用）（消込Ｆ）処理年月日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfdenymd</td><td>（中継用）（消込Ｆ）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenatesakicd</td><td>（中継用）伝票宛先部課コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmftaisyakukbn</td><td>（中継用）（消込Ｆ）貸借区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhutuuhokenkamokucd</td><td>（中継用）普通保険用科目コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydengk</td><td>（中継用）伝票金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytabakariknjykskmdatakbn</td><td>（中継用）束仮勘定消込項目データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfryousyuuymd</td><td>（中継用）（消込Ｆ）領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryousyuuhm</td><td>（中継用）領収時分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkakusyounyuuryokuymd2</td><td>（中継用）入金確証入力年月日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfsyono</td><td>（中継用）（消込Ｆ）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkhoukokuhyoutantouka</td><td>（中継用）入金報告票担当課</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkhoukokuhyoukihyouymd</td><td>（中継用）入金報告票起票年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkhoukokuhyoubunkaino</td><td>（中継用）入金報告票分解表番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkakusyounyuuryokuno</td><td>（中継用）入金確証入力番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfdantaicd</td><td>（中継用）（消込Ｆ）団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaiannaijyuutouym2</td><td>（中継用）団体案内充当年月２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybonusharaihyouji2</td><td>（中継用）ボーナス払表示２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaino2</td><td>（中継用）案内番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantaipkbn</td><td>（中継用）団体保険料区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydantainyuukinymd</td><td>（中継用）団体入金年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfjyuutouym</td><td>（中継用）（消込Ｆ）充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuitouymd</td><td>（中継用）出納年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyuuryokuhouhoukbn</td><td>（中継用）入力方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfnyknaiyoukbn</td><td>（中継用）（消込Ｆ）入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaekykhndnkhyouji</td><td>（中継用）口座振替契約ハンド入金表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfdairitencd</td><td>（中継用）（消込Ｆ）代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenuketukeno2</td><td>（中継用）代理店受付番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatudantaicd</td><td>（中継用）一括団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatuannaihikisariym</td><td>（中継用）一括案内引去年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyikkatuannaino</td><td>（中継用）一括案内番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzaikeihrkkaisuukbn2</td><td>（中継用）財形払込回数区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzaikeikyksyano</td><td>（中継用）財形契約者番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhasseisosikicd</td><td>（中継用）発生組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikeisakikaisyacd</td><td>（中継用）提携先会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmfbankcd</td><td>（中継用）（消込Ｆ）銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuitousyorisosikicd</td><td>（中継用）出納処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaitekanjyouyomikaekbn</td><td>（中継用）相手勘定読替区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditcardhrkskmkbn</td><td>（中継用）クレ払消込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylastteiseiymd</td><td>（中継用）最終訂正年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmkanryouymd</td><td>（中継用）消込完了年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmteiseino</td><td>（中継用）消込訂正番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykskmkanryousijihyouji</td><td>（中継用）消込完了指示表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuketuketencd</td><td>（中継用）受付店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycvscd</td><td>（中継用）ＣＶＳコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikomiyousinyuukinkbn</td><td>（中継用）振込用紙入金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikomiyousiokyksmno</td><td>（中継用）振込用紙お客さま番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikomiyousikakuninno</td><td>（中継用）振込用紙確認番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyegsyokuinhurikomiymd</td><td>（中継用）営業職員振込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvitkaiinno</td><td>（中継用）Ｖｉｔ会員番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv74</td><td>（中継用）予備項目Ｖ７４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KesikomiSousinCreditTy
 * @see     GenZT_KesikomiSousinCreditTy
 * @see     QZT_KesikomiSousinCreditTy
 * @see     GenQZT_KesikomiSousinCreditTy
 */
public class PKZT_KesikomiSousinCreditTy extends AbstractExDBPrimaryKey<ZT_KesikomiSousinCreditTy, PKZT_KesikomiSousinCreditTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KesikomiSousinCreditTy() {
    }

    public PKZT_KesikomiSousinCreditTy(String pZtykskmsousinrenno, String pZtykskmfsyoriymd) {
        ztykskmsousinrenno = pZtykskmsousinrenno;
        ztykskmfsyoriymd = pZtykskmfsyoriymd;
    }

    @Transient
    @Override
    public Class<ZT_KesikomiSousinCreditTy> getEntityClass() {
        return ZT_KesikomiSousinCreditTy.class;
    }

    private String ztykskmsousinrenno;

    public String getZtykskmsousinrenno() {
        return ztykskmsousinrenno;
    }

    public void setZtykskmsousinrenno(String pZtykskmsousinrenno) {
        ztykskmsousinrenno = pZtykskmsousinrenno;
    }
    private String ztykskmfsyoriymd;

    public String getZtykskmfsyoriymd() {
        return ztykskmfsyoriymd;
    }

    public void setZtykskmfsyoriymd(String pZtykskmfsyoriymd) {
        ztykskmfsyoriymd = pZtykskmfsyoriymd;
    }

}