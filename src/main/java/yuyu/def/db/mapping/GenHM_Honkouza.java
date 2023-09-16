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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_Honkouza;
import yuyu.def.db.id.PKHM_Honkouza;
import yuyu.def.db.meta.GenQHM_Honkouza;
import yuyu.def.db.meta.QHM_Honkouza;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 本口座マスタ テーブルのマッピング情報クラスで、 {@link HM_Honkouza} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_Honkouza}</td><td colspan="3">本口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHonkouzacd honkouzacd}</td><td>本口座コード</td><td align="center">{@link PKHM_Honkouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSikinidousakibankcd sikinidousakibankcd}</td><td>資金移動先銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSikinidousakisitencd sikinidousakisitencd}</td><td>資金移動先支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSikinidousakikouzano sikinidousakikouzano}</td><td>資金移動先口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr><td>{@link #getHyoujijyun hyoujijyun}</td><td>表示順</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     HM_Honkouza
 * @see     PKHM_Honkouza
 * @see     QHM_Honkouza
 * @see     GenQHM_Honkouza
 */
@MappedSuperclass
@Table(name=GenHM_Honkouza.TABLE_NAME)
@IdClass(value=PKHM_Honkouza.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Tuukasyu", typeClass=UserType_C_Tuukasyu.class)
})
public abstract class GenHM_Honkouza extends AbstractExDBEntity<HM_Honkouza, PKHM_Honkouza> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HM_Honkouza";
    public static final String HONKOUZACD               = "honkouzacd";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String KOUZANO                  = "kouzano";
    public static final String SIKINIDOUSAKIBANKCD      = "sikinidousakibankcd";
    public static final String SIKINIDOUSAKISITENCD     = "sikinidousakisitencd";
    public static final String SIKINIDOUSAKIKOUZANO     = "sikinidousakikouzano";
    public static final String TUUKASYU                 = "tuukasyu";
    public static final String HYOUJIJYUN               = "hyoujijyun";

    private final PKHM_Honkouza primaryKey;

    public GenHM_Honkouza() {
        primaryKey = new PKHM_Honkouza();
    }

    public GenHM_Honkouza(String pHonkouzacd) {
        primaryKey = new PKHM_Honkouza(pHonkouzacd);
    }

    @Transient
    @Override
    public PKHM_Honkouza getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHM_Honkouza> getMetaClass() {
        return QHM_Honkouza.class;
    }

    @Id
    @Column(name=GenHM_Honkouza.HONKOUZACD)
    public String getHonkouzacd() {
        return getPrimaryKey().getHonkouzacd();
    }

    public void setHonkouzacd(String pHonkouzacd) {
        getPrimaryKey().setHonkouzacd(pHonkouzacd);
    }

    private String bankcd;

    @Column(name=GenHM_Honkouza.BANKCD)
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

    @Column(name=GenHM_Honkouza.SITENCD)
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

    private String kouzano;

    @Column(name=GenHM_Honkouza.KOUZANO)
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

    private String sikinidousakibankcd;

    @Column(name=GenHM_Honkouza.SIKINIDOUSAKIBANKCD)
    @Length(length=4)
    @Digit
    public String getSikinidousakibankcd() {
        return sikinidousakibankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSikinidousakibankcd(String pSikinidousakibankcd) {
        sikinidousakibankcd = pSikinidousakibankcd;
    }

    private String sikinidousakisitencd;

    @Column(name=GenHM_Honkouza.SIKINIDOUSAKISITENCD)
    @Length(length=3)
    @Digit
    public String getSikinidousakisitencd() {
        return sikinidousakisitencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSikinidousakisitencd(String pSikinidousakisitencd) {
        sikinidousakisitencd = pSikinidousakisitencd;
    }

    private String sikinidousakikouzano;

    @Column(name=GenHM_Honkouza.SIKINIDOUSAKIKOUZANO)
    @MaxLength(max=12)
    @HostInvalidCharacter
    public String getSikinidousakikouzano() {
        return sikinidousakikouzano;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSikinidousakikouzano(String pSikinidousakikouzano) {
        sikinidousakikouzano = pSikinidousakikouzano;
    }

    private C_Tuukasyu tuukasyu;

    @Type(type="UserType_C_Tuukasyu")
    @Column(name=GenHM_Honkouza.TUUKASYU)
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }

    private Integer hyoujijyun;

    @Column(name=GenHM_Honkouza.HYOUJIJYUN)
    public Integer getHyoujijyun() {
        return hyoujijyun;
    }

    public void setHyoujijyun(Integer pHyoujijyun) {
        hyoujijyun = pHyoujijyun;
    }
}