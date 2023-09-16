package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.mapping.GenHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.QHT_SkKouhuriUkTrkMihanei;

/**
 * 新契約口振受付登録結果未反映テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkKouhuriUkTrkMihanei}</td><td colspan="3">新契約口振受付登録結果未反映テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyukkncd syukkncd}</td><td>収納機関コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinyuucd8keta kinyuucd8keta}</td><td>金融機関コード（８桁）</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinyuukkntratkiymd kinyuukkntratkiymd}</td><td>金融機関取扱年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinyuukkntratkitime kinyuukkntratkitime}</td><td>金融機関取扱時刻</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinyuukkntratkino</td><td>金融機関取扱番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouhuriukchannelkbn</td><td>口振受付チャネル区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouhuriokyakusamano kouhuriokyakusamano}</td><td>口振お客様番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nykmosno</td><td>入金用申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syorizumiflg</td><td>処理済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Syorizumiflg C_Syorizumiflg}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd5keta</td><td>支店コード（５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano8keta</td><td>口座番号（８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>itakusyacd</td><td>委託者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukkntratkiymd</td><td>収納機関取扱年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syukkntratkitime</td><td>収納機関取扱時刻</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syukkntratkino</td><td>収納機関取扱番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouhuristatuskbn</td><td>口振ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouhuristatusKbn C_KouhuristatusKbn}</td></tr>
 *  <tr><td>kouhurikekkacd</td><td>口振処理結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouhurihonninkakkekka</td><td>口振本人確認結果</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkKouhuriUkTrkMihanei
 * @see     GenHT_SkKouhuriUkTrkMihanei
 * @see     QHT_SkKouhuriUkTrkMihanei
 * @see     GenQHT_SkKouhuriUkTrkMihanei
 */
public class PKHT_SkKouhuriUkTrkMihanei extends AbstractExDBPrimaryKey<HT_SkKouhuriUkTrkMihanei, PKHT_SkKouhuriUkTrkMihanei> {

    private static final long serialVersionUID = 1L;

    public PKHT_SkKouhuriUkTrkMihanei() {
    }

    public PKHT_SkKouhuriUkTrkMihanei(
        BizDate pSyoriYmd,
        String pSyukkncd,
        String pKinyuucd8keta,
        BizDate pKinyuukkntratkiymd,
        String pKinyuukkntratkitime,
        String pKouhuriokyakusamano
    ) {
        syoriYmd = pSyoriYmd;
        syukkncd = pSyukkncd;
        kinyuucd8keta = pKinyuucd8keta;
        kinyuukkntratkiymd = pKinyuukkntratkiymd;
        kinyuukkntratkitime = pKinyuukkntratkitime;
        kouhuriokyakusamano = pKouhuriokyakusamano;
    }

    @Transient
    @Override
    public Class<HT_SkKouhuriUkTrkMihanei> getEntityClass() {
        return HT_SkKouhuriUkTrkMihanei.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String syukkncd;

    public String getSyukkncd() {
        return syukkncd;
    }

    public void setSyukkncd(String pSyukkncd) {
        syukkncd = pSyukkncd;
    }
    private String kinyuucd8keta;

    public String getKinyuucd8keta() {
        return kinyuucd8keta;
    }

    public void setKinyuucd8keta(String pKinyuucd8keta) {
        kinyuucd8keta = pKinyuucd8keta;
    }
    private BizDate kinyuukkntratkiymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKinyuukkntratkiymd() {
        return kinyuukkntratkiymd;
    }

    public void setKinyuukkntratkiymd(BizDate pKinyuukkntratkiymd) {
        kinyuukkntratkiymd = pKinyuukkntratkiymd;
    }
    private String kinyuukkntratkitime;

    public String getKinyuukkntratkitime() {
        return kinyuukkntratkitime;
    }

    public void setKinyuukkntratkitime(String pKinyuukkntratkitime) {
        kinyuukkntratkitime = pKinyuukkntratkitime;
    }
    private String kouhuriokyakusamano;

    public String getKouhuriokyakusamano() {
        return kouhuriokyakusamano;
    }

    public void setKouhuriokyakusamano(String pKouhuriokyakusamano) {
        kouhuriokyakusamano = pKouhuriokyakusamano;
    }

}