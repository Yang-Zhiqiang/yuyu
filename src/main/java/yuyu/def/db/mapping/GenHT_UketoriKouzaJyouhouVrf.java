package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.id.PKHT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.meta.GenQHT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.meta.QHT_UketoriKouzaJyouhouVrf;
import yuyu.def.db.type.UserType_C_KouzaInfoInputHoryuuKbn;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_UketorikouzasyubetuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 受取口座情報ベリファイテーブル テーブルのマッピング情報クラスで、 {@link HT_UketoriKouzaJyouhouVrf} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_UketoriKouzaJyouhouVrf}</td><td colspan="3">受取口座情報ベリファイテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_UketoriKouzaJyouhouVrf ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktkzsyubetukbn uktkzsyubetukbn}</td><td>受取口座種別区分</td><td align="center">{@link PKHT_UketoriKouzaJyouhouVrf ○}</td><td align="center">V</td><td>{@link C_UketorikouzasyubetuKbn}</td></tr>
 *  <tr><td>{@link #getKouzainfoinputhoryuukbn kouzainfoinputhoryuukbn}</td><td>口座情報入力保留区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzaInfoInputHoryuuKbn}</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzkykdoukbn kzkykdoukbn}</td><td>口座名義契約者同一人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KzkykdouKbn}</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_UketoriKouzaJyouhouVrf
 * @see     PKHT_UketoriKouzaJyouhouVrf
 * @see     QHT_UketoriKouzaJyouhouVrf
 * @see     GenQHT_UketoriKouzaJyouhouVrf
 */
@MappedSuperclass
@Table(name=GenHT_UketoriKouzaJyouhouVrf.TABLE_NAME)
@IdClass(value=PKHT_UketoriKouzaJyouhouVrf.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KouzaInfoInputHoryuuKbn", typeClass=UserType_C_KouzaInfoInputHoryuuKbn.class),
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_KzkykdouKbn", typeClass=UserType_C_KzkykdouKbn.class),
    @TypeDef(name="UserType_C_UketorikouzasyubetuKbn", typeClass=UserType_C_UketorikouzasyubetuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenHT_UketoriKouzaJyouhouVrf extends AbstractExDBEntity<HT_UketoriKouzaJyouhouVrf, PKHT_UketoriKouzaJyouhouVrf> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_UketoriKouzaJyouhouVrf";
    public static final String MOSNO                    = "mosno";
    public static final String UKTKZSYUBETUKBN          = "uktkzsyubetukbn";
    public static final String KOUZAINFOINPUTHORYUUKBN  = "kouzainfoinputhoryuukbn";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZKYKDOUKBN              = "kzkykdoukbn";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_UketoriKouzaJyouhouVrf primaryKey;

    public GenHT_UketoriKouzaJyouhouVrf() {
        primaryKey = new PKHT_UketoriKouzaJyouhouVrf();
    }

    public GenHT_UketoriKouzaJyouhouVrf(String pMosno, C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        primaryKey = new PKHT_UketoriKouzaJyouhouVrf(pMosno, pUktkzsyubetukbn);
    }

    @Transient
    @Override
    public PKHT_UketoriKouzaJyouhouVrf getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_UketoriKouzaJyouhouVrf> getMetaClass() {
        return QHT_UketoriKouzaJyouhouVrf.class;
    }

    @Id
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="UserType_C_UketorikouzasyubetuKbn")
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.UKTKZSYUBETUKBN)
    public C_UketorikouzasyubetuKbn getUktkzsyubetukbn() {
        return getPrimaryKey().getUktkzsyubetukbn();
    }

    public void setUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        getPrimaryKey().setUktkzsyubetukbn(pUktkzsyubetukbn);
    }

    private C_KouzaInfoInputHoryuuKbn kouzainfoinputhoryuukbn;

    @Type(type="UserType_C_KouzaInfoInputHoryuuKbn")
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.KOUZAINFOINPUTHORYUUKBN)
    public C_KouzaInfoInputHoryuuKbn getKouzainfoinputhoryuukbn() {
        return kouzainfoinputhoryuukbn;
    }

    public void setKouzainfoinputhoryuukbn(C_KouzaInfoInputHoryuuKbn pKouzainfoinputhoryuukbn) {
        kouzainfoinputhoryuukbn = pKouzainfoinputhoryuukbn;
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String bankcd;

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.BANKCD)
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

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.SITENCD)
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
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.KOUZANO)
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

    private C_KzkykdouKbn kzkykdoukbn;

    @Type(type="UserType_C_KzkykdouKbn")
    @Column(name=GenHT_UketoriKouzaJyouhouVrf.KZKYKDOUKBN)
    public C_KzkykdouKbn getKzkykdoukbn() {
        return kzkykdoukbn;
    }

    public void setKzkykdoukbn(C_KzkykdouKbn pKzkykdoukbn) {
        kzkykdoukbn = pKzkykdoukbn;
    }

    private String kzmeiginmkn;

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.KZMEIGINMKN)
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

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_UketoriKouzaJyouhouVrf.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}