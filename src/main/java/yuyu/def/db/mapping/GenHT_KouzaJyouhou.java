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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SinkeizkKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.HT_KouzaJyouhou;
import yuyu.def.db.id.PKHT_KouzaJyouhou;
import yuyu.def.db.meta.GenQHT_KouzaJyouhou;
import yuyu.def.db.meta.QHT_KouzaJyouhou;
import yuyu.def.db.type.UserType_C_KzhuritourokuhouKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SinkeizkKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 口座情報テーブル テーブルのマッピング情報クラスで、 {@link HT_KouzaJyouhou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_KouzaJyouhou}</td><td colspan="3">口座情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_KouzaJyouhou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkykdoukbn kzkykdoukbn}</td><td>口座名義契約者同一人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkykdouKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSinkeizkkbn sinkeizkkbn}</td><td>新規継続区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SinkeizkKbn}</td></tr>
 *  <tr><td>{@link #getHbcmnt hbcmnt}</td><td>不備コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyuudaikocd syuudaikocd}</td><td>収納代行社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Syuudaikocd}</td></tr>
 *  <tr><td>{@link #getKouzakakuniniraikbn kouzakakuniniraikbn}</td><td>口座確認依頼区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getKouzakakuniniraiymd kouzakakuniniraiymd}</td><td>口座確認依頼日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKouzajyouhounyuuryokuymd kouzajyouhounyuuryokuymd}</td><td>口座情報入力日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKzhuritourokuhoukbn kzhuritourokuhoukbn}</td><td>口座振替登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzhuritourokuhouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_KouzaJyouhou
 * @see     PKHT_KouzaJyouhou
 * @see     QHT_KouzaJyouhou
 * @see     GenQHT_KouzaJyouhou
 */
@MappedSuperclass
@Table(name=GenHT_KouzaJyouhou.TABLE_NAME)
@IdClass(value=PKHT_KouzaJyouhou.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KzhuritourokuhouKbn", typeClass=UserType_C_KzhuritourokuhouKbn.class),
    @TypeDef(name="UserType_C_KzkykdouKbn", typeClass=UserType_C_KzkykdouKbn.class),
    @TypeDef(name="UserType_C_SinkeizkKbn", typeClass=UserType_C_SinkeizkKbn.class),
    @TypeDef(name="UserType_C_Syuudaikocd", typeClass=UserType_C_Syuudaikocd.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class),
    @TypeDef(name="UserType_C_YouhiblnkKbn", typeClass=UserType_C_YouhiblnkKbn.class)
})
public abstract class GenHT_KouzaJyouhou extends AbstractExDBEntity<HT_KouzaJyouhou, PKHT_KouzaJyouhou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_KouzaJyouhou";
    public static final String MOSNO                    = "mosno";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String KZKYKDOUKBN              = "kzkykdoukbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String SINKEIZKKBN              = "sinkeizkkbn";
    public static final String HBCMNT                   = "hbcmnt";
    public static final String SYUUDAIKOCD              = "syuudaikocd";
    public static final String KOUZAKAKUNINIRAIKBN      = "kouzakakuniniraikbn";
    public static final String KOUZAKAKUNINIRAIYMD      = "kouzakakuniniraiymd";
    public static final String KOUZAJYOUHOUNYUURYOKUYMD = "kouzajyouhounyuuryokuymd";
    public static final String KZHURITOUROKUHOUKBN      = "kzhuritourokuhoukbn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_KouzaJyouhou primaryKey;

    public GenHT_KouzaJyouhou() {
        primaryKey = new PKHT_KouzaJyouhou();
    }

    public GenHT_KouzaJyouhou(String pMosno) {
        primaryKey = new PKHT_KouzaJyouhou(pMosno);
    }

    @Transient
    @Override
    public PKHT_KouzaJyouhou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_KouzaJyouhou> getMetaClass() {
        return QHT_KouzaJyouhou.class;
    }

    @Id
    @Column(name=GenHT_KouzaJyouhou.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    private String kzmeiginmkn;

    @Column(name=GenHT_KouzaJyouhou.KZMEIGINMKN)
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

    private C_KzkykdouKbn kzkykdoukbn;

    @Type(type="UserType_C_KzkykdouKbn")
    @Column(name=GenHT_KouzaJyouhou.KZKYKDOUKBN)
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    private String bankcd;

    @Column(name=GenHT_KouzaJyouhou.BANKCD)
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

    private String sitencd;

    @Column(name=GenHT_KouzaJyouhou.SITENCD)
    @Length(length=3)
    @Digit
    public String getSitencd() {
        return sitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }

    private C_YokinKbn yokinkbn;

    @Type(type="UserType_C_YokinKbn")
    @Column(name=GenHT_KouzaJyouhou.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_KouzaJyouhou.KOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getKouzano() {
        return kouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }

    private C_SinkeizkKbn sinkeizkkbn;

    @Type(type="UserType_C_SinkeizkKbn")
    @Column(name=GenHT_KouzaJyouhou.SINKEIZKKBN)
    public C_SinkeizkKbn getSinkeizkkbn() {
        return sinkeizkkbn;
    }

    public void setSinkeizkkbn(C_SinkeizkKbn pSinkeizkkbn) {
        sinkeizkkbn = pSinkeizkkbn;
    }

    private String hbcmnt;

    @Column(name=GenHT_KouzaJyouhou.HBCMNT)
    public String getHbcmnt() {
        return hbcmnt;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHbcmnt(String pHbcmnt) {
        hbcmnt = pHbcmnt;
    }

    private C_Syuudaikocd syuudaikocd;

    @Type(type="UserType_C_Syuudaikocd")
    @Column(name=GenHT_KouzaJyouhou.SYUUDAIKOCD)
    public C_Syuudaikocd getSyuudaikocd() {
        return syuudaikocd;
    }

    public void setSyuudaikocd(C_Syuudaikocd pSyuudaikocd) {
        syuudaikocd = pSyuudaikocd;
    }

    private C_YouhiblnkKbn kouzakakuniniraikbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenHT_KouzaJyouhou.KOUZAKAKUNINIRAIKBN)
    public C_YouhiblnkKbn getKouzakakuniniraikbn() {
        return kouzakakuniniraikbn;
    }

    public void setKouzakakuniniraikbn(C_YouhiblnkKbn pKouzakakuniniraikbn) {
        kouzakakuniniraikbn = pKouzakakuniniraikbn;
    }

    private BizDate kouzakakuniniraiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KouzaJyouhou.KOUZAKAKUNINIRAIYMD)
    public BizDate getKouzakakuniniraiymd() {
        return kouzakakuniniraiymd;
    }

    public void setKouzakakuniniraiymd(BizDate pKouzakakuniniraiymd) {
        kouzakakuniniraiymd = pKouzakakuniniraiymd;
    }

    private BizDate kouzajyouhounyuuryokuymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_KouzaJyouhou.KOUZAJYOUHOUNYUURYOKUYMD)
    public BizDate getKouzajyouhounyuuryokuymd() {
        return kouzajyouhounyuuryokuymd;
    }

    public void setKouzajyouhounyuuryokuymd(BizDate pKouzajyouhounyuuryokuymd) {
        kouzajyouhounyuuryokuymd = pKouzajyouhounyuuryokuymd;
    }

    private C_KzhuritourokuhouKbn kzhuritourokuhoukbn;

    @Type(type="UserType_C_KzhuritourokuhouKbn")
    @Column(name=GenHT_KouzaJyouhou.KZHURITOUROKUHOUKBN)
    public C_KzhuritourokuhouKbn getKzhuritourokuhoukbn() {
        return kzhuritourokuhoukbn;
    }

    public void setKzhuritourokuhoukbn(C_KzhuritourokuhouKbn pKzhuritourokuhoukbn) {
        kzhuritourokuhoukbn = pKzhuritourokuhoukbn;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_KouzaJyouhou.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_KouzaJyouhou.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}