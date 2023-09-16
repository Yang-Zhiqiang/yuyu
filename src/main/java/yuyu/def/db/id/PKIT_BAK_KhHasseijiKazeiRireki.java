package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.mapping.GenIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.GenQIT_BAK_KhHasseijiKazeiRireki;
import yuyu.def.db.meta.QIT_BAK_KhHasseijiKazeiRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全発生時課税履歴バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_KhHasseijiKazeiRireki}</td><td colspan="3">契約保全発生時課税履歴バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoriYmd</td><td>処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hasseijikazeisyorikbn</td><td>発生時課税処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasseijikazeisyoriKbn C_HasseijikazeisyoriKbn}</td></tr>
 *  <tr><td>torikesiflg</td><td>取消フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>torikesiymd</td><td>取消日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kouryokuhasseiymd</td><td>効力発生日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeitratkikbn</td><td>税取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ZeitratkiKbn C_ZeitratkiKbn}</td></tr>
 *  <tr><td>gsbunritaisyou</td><td>源泉分離課税対象</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>hasseijikngksyuruikbn</td><td>発生時金額種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasseijikngksyuruiKbn C_HasseijikngksyuruiKbn}</td></tr>
 *  <tr><td>hasseijikngk</td><td>発生時金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>hasseijigstszeigk</td><td>発生時源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansangkgoukei</td><td>円換算額合計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkansansyukngkgoukei</td><td>円換算主たる金額小計</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigk</td><td>円換算源泉徴収税額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigknationaltax</td><td>円換算源泉徴収税額（国税）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yengstszeigklocaltax</td><td>円換算源泉徴収税額（地方税）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>nztodouhukencd</td><td>納税先都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>htykeihi</td><td>必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kztgk</td><td>課税対象額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenhtykeihi</td><td>円換算必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>yenkztgk</td><td>円換算課税対象額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>zeimukwsratekjnymd</td><td>税務用為替レート基準日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>zeimukwsrate</td><td>税務用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>kyknmkn</td><td>契約者名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykyno</td><td>契約者郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykadr1kj</td><td>契約者住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykadr2kj</td><td>契約者住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykadr3kj</td><td>契約者住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykmnmeigibangou</td><td>契約者ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>uktmnmeigibangou</td><td>受取人ＭＮ名義番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shrtysysyuruikbn</td><td>支払調書種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HtsiryosyuKbn C_HtsiryosyuKbn}</td></tr>
 *  <tr><td>yenshrkykhtykeihi</td><td>円換算支払時契約者必要経費</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kykhnkkaisuu</td><td>契約者変更回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_KhHasseijiKazeiRireki
 * @see     GenIT_BAK_KhHasseijiKazeiRireki
 * @see     QIT_BAK_KhHasseijiKazeiRireki
 * @see     GenQIT_BAK_KhHasseijiKazeiRireki
 */
public class PKIT_BAK_KhHasseijiKazeiRireki extends AbstractExDBPrimaryKey<IT_BAK_KhHasseijiKazeiRireki, PKIT_BAK_KhHasseijiKazeiRireki> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_KhHasseijiKazeiRireki() {
    }

    public PKIT_BAK_KhHasseijiKazeiRireki(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_BAK_KhHasseijiKazeiRireki> getEntityClass() {
        return IT_BAK_KhHasseijiKazeiRireki.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}