package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KouhuristatusKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.id.PKHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.GenQHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.meta.QHT_SkKouhuriUkTrkMihanei;
import yuyu.def.db.type.UserType_C_KouhuristatusKbn;
import yuyu.def.db.type.UserType_C_Syorizumiflg;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 新契約口振受付登録結果未反映テーブル テーブルのマッピング情報クラスで、 {@link HT_SkKouhuriUkTrkMihanei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkKouhuriUkTrkMihanei}</td><td colspan="3">新契約口振受付登録結果未反映テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukkncd syukkncd}</td><td>収納機関コード</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuucd8keta kinyuucd8keta}</td><td>金融機関コード（８桁）</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuukkntratkiymd kinyuukkntratkiymd}</td><td>金融機関取扱年月日</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKinyuukkntratkitime kinyuukkntratkitime}</td><td>金融機関取扱時刻</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinyuukkntratkino kinyuukkntratkino}</td><td>金融機関取扱番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouhuriukchannelkbn kouhuriukchannelkbn}</td><td>口振受付チャネル区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouhuriokyakusamano kouhuriokyakusamano}</td><td>口振お客様番号</td><td align="center">{@link PKHT_SkKouhuriUkTrkMihanei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNykmosno nykmosno}</td><td>入金用申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorizumiflg syorizumiflg}</td><td>処理済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syorizumiflg}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd5keta sitencd5keta}</td><td>支店コード（５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano8keta kouzano8keta}</td><td>口座番号（８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getItakusyacd itakusyacd}</td><td>委託者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukkntratkiymd syukkntratkiymd}</td><td>収納機関取扱年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyukkntratkitime syukkntratkitime}</td><td>収納機関取扱時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyukkntratkino syukkntratkino}</td><td>収納機関取扱番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouhuristatuskbn kouhuristatuskbn}</td><td>口振ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouhuristatusKbn}</td></tr>
 *  <tr><td>{@link #getKouhurikekkacd kouhurikekkacd}</td><td>口振処理結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouhurihonninkakkekka kouhurihonninkakkekka}</td><td>口振本人確認結果</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkKouhuriUkTrkMihanei
 * @see     PKHT_SkKouhuriUkTrkMihanei
 * @see     QHT_SkKouhuriUkTrkMihanei
 * @see     GenQHT_SkKouhuriUkTrkMihanei
 */
@MappedSuperclass
@Table(name=GenHT_SkKouhuriUkTrkMihanei.TABLE_NAME)
@IdClass(value=PKHT_SkKouhuriUkTrkMihanei.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KouhuristatusKbn", typeClass=UserType_C_KouhuristatusKbn.class),
    @TypeDef(name="UserType_C_Syorizumiflg", typeClass=UserType_C_Syorizumiflg.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_SkKouhuriUkTrkMihanei extends AbstractExDBEntity<HT_SkKouhuriUkTrkMihanei, PKHT_SkKouhuriUkTrkMihanei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkKouhuriUkTrkMihanei";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYUKKNCD                 = "syukkncd";
    public static final String KINYUUCD8KETA            = "kinyuucd8keta";
    public static final String KINYUUKKNTRATKIYMD       = "kinyuukkntratkiymd";
    public static final String KINYUUKKNTRATKITIME      = "kinyuukkntratkitime";
    public static final String KINYUUKKNTRATKINO        = "kinyuukkntratkino";
    public static final String KOUHURIUKCHANNELKBN      = "kouhuriukchannelkbn";
    public static final String KOUHURIOKYAKUSAMANO      = "kouhuriokyakusamano";
    public static final String NYKMOSNO                 = "nykmosno";
    public static final String SYORIZUMIFLG             = "syorizumiflg";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD5KETA             = "sitencd5keta";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO8KETA             = "kouzano8keta";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String ITAKUSYACD               = "itakusyacd";
    public static final String SYUKKNTRATKIYMD          = "syukkntratkiymd";
    public static final String SYUKKNTRATKITIME         = "syukkntratkitime";
    public static final String SYUKKNTRATKINO           = "syukkntratkino";
    public static final String KOUHURISTATUSKBN         = "kouhuristatuskbn";
    public static final String KOUHURIKEKKACD           = "kouhurikekkacd";
    public static final String KOUHURIHONNINKAKKEKKA    = "kouhurihonninkakkekka";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkKouhuriUkTrkMihanei primaryKey;

    public GenHT_SkKouhuriUkTrkMihanei() {
        primaryKey = new PKHT_SkKouhuriUkTrkMihanei();
    }

    public GenHT_SkKouhuriUkTrkMihanei(
        BizDate pSyoriYmd,
        String pSyukkncd,
        String pKinyuucd8keta,
        BizDate pKinyuukkntratkiymd,
        String pKinyuukkntratkitime,
        String pKouhuriokyakusamano
    ) {
        primaryKey = new PKHT_SkKouhuriUkTrkMihanei(
            pSyoriYmd,
            pSyukkncd,
            pKinyuucd8keta,
            pKinyuukkntratkiymd,
            pKinyuukkntratkitime,
            pKouhuriokyakusamano
        );
    }

    @Transient
    @Override
    public PKHT_SkKouhuriUkTrkMihanei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkKouhuriUkTrkMihanei> getMetaClass() {
        return QHT_SkKouhuriUkTrkMihanei.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYUKKNCD)
    public String getSyukkncd() {
        return getPrimaryKey().getSyukkncd();
    }

    public void setSyukkncd(String pSyukkncd) {
        getPrimaryKey().setSyukkncd(pSyukkncd);
    }

    @Id
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KINYUUCD8KETA)
    public String getKinyuucd8keta() {
        return getPrimaryKey().getKinyuucd8keta();
    }

    public void setKinyuucd8keta(String pKinyuucd8keta) {
        getPrimaryKey().setKinyuucd8keta(pKinyuucd8keta);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KINYUUKKNTRATKIYMD)
    public BizDate getKinyuukkntratkiymd() {
        return getPrimaryKey().getKinyuukkntratkiymd();
    }

    public void setKinyuukkntratkiymd(BizDate pKinyuukkntratkiymd) {
        getPrimaryKey().setKinyuukkntratkiymd(pKinyuukkntratkiymd);
    }

    @Id
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KINYUUKKNTRATKITIME)
    public String getKinyuukkntratkitime() {
        return getPrimaryKey().getKinyuukkntratkitime();
    }

    public void setKinyuukkntratkitime(String pKinyuukkntratkitime) {
        getPrimaryKey().setKinyuukkntratkitime(pKinyuukkntratkitime);
    }

    private String kinyuukkntratkino;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KINYUUKKNTRATKINO)
    public String getKinyuukkntratkino() {
        return kinyuukkntratkino;
    }

    public void setKinyuukkntratkino(String pKinyuukkntratkino) {
        kinyuukkntratkino = pKinyuukkntratkino;
    }

    private String kouhuriukchannelkbn;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUHURIUKCHANNELKBN)
    public String getKouhuriukchannelkbn() {
        return kouhuriukchannelkbn;
    }

    public void setKouhuriukchannelkbn(String pKouhuriukchannelkbn) {
        kouhuriukchannelkbn = pKouhuriukchannelkbn;
    }

    @Id
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUHURIOKYAKUSAMANO)
    public String getKouhuriokyakusamano() {
        return getPrimaryKey().getKouhuriokyakusamano();
    }

    public void setKouhuriokyakusamano(String pKouhuriokyakusamano) {
        getPrimaryKey().setKouhuriokyakusamano(pKouhuriokyakusamano);
    }

    private String nykmosno;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.NYKMOSNO)
    public String getNykmosno() {
        return nykmosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setNykmosno(String pNykmosno) {
        nykmosno = pNykmosno;
    }

    private C_Syorizumiflg syorizumiflg;

    @Type(type="UserType_C_Syorizumiflg")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYORIZUMIFLG)
    public C_Syorizumiflg getSyorizumiflg() {
        return syorizumiflg;
    }

    public void setSyorizumiflg(C_Syorizumiflg pSyorizumiflg) {
        syorizumiflg = pSyorizumiflg;
    }

    private String bankcd;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.BANKCD)
    @Length(length=4)
    @Digit
    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String sitencd5keta;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SITENCD5KETA)
    public String getSitencd5keta() {
        return sitencd5keta;
    }

    public void setSitencd5keta(String pSitencd5keta) {
        sitencd5keta = pSitencd5keta;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano8keta;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUZANO8KETA)
    public String getKouzano8keta() {
        return kouzano8keta;
    }

    public void setKouzano8keta(String pKouzano8keta) {
        kouzano8keta = pKouzano8keta;
    }

    private String kzmeiginmkn;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KZMEIGINMKN)
    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    @HostInvalidCharacter
    public String getKzmeiginmkn() {
        return kzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setKzmeiginmkn(String pKzmeiginmkn) {
        kzmeiginmkn = pKzmeiginmkn;
    }

    private String itakusyacd;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.ITAKUSYACD)
    public String getItakusyacd() {
        return itakusyacd;
    }

    public void setItakusyacd(String pItakusyacd) {
        itakusyacd = pItakusyacd;
    }

    private BizDate syukkntratkiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYUKKNTRATKIYMD)
    public BizDate getSyukkntratkiymd() {
        return syukkntratkiymd;
    }

    public void setSyukkntratkiymd(BizDate pSyukkntratkiymd) {
        syukkntratkiymd = pSyukkntratkiymd;
    }

    private String syukkntratkitime;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYUKKNTRATKITIME)
    public String getSyukkntratkitime() {
        return syukkntratkitime;
    }

    public void setSyukkntratkitime(String pSyukkntratkitime) {
        syukkntratkitime = pSyukkntratkitime;
    }

    private String syukkntratkino;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.SYUKKNTRATKINO)
    public String getSyukkntratkino() {
        return syukkntratkino;
    }

    public void setSyukkntratkino(String pSyukkntratkino) {
        syukkntratkino = pSyukkntratkino;
    }

    private C_KouhuristatusKbn kouhuristatuskbn;

    @Type(type="UserType_C_KouhuristatusKbn")
    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUHURISTATUSKBN)
    public C_KouhuristatusKbn getKouhuristatuskbn() {
        return kouhuristatuskbn;
    }

    public void setKouhuristatuskbn(C_KouhuristatusKbn pKouhuristatuskbn) {
        kouhuristatuskbn = pKouhuristatuskbn;
    }

    private String kouhurikekkacd;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUHURIKEKKACD)
    public String getKouhurikekkacd() {
        return kouhurikekkacd;
    }

    public void setKouhurikekkacd(String pKouhurikekkacd) {
        kouhurikekkacd = pKouhurikekkacd;
    }

    private String kouhurihonninkakkekka;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.KOUHURIHONNINKAKKEKKA)
    public String getKouhurihonninkakkekka() {
        return kouhurihonninkakkekka;
    }

    public void setKouhurihonninkakkekka(String pKouhurihonninkakkekka) {
        kouhurihonninkakkekka = pKouhurihonninkakkekka;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkKouhuriUkTrkMihanei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}