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
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_UketoriKouza;
import yuyu.def.db.id.PKIT_UketoriKouza;
import yuyu.def.db.meta.GenQIT_UketoriKouza;
import yuyu.def.db.meta.QIT_UketoriKouza;
import yuyu.def.db.type.UserType_C_KouzasyuruiKbn;
import yuyu.def.db.type.UserType_C_UktsyuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 受取口座テーブル テーブルのマッピング情報クラスで、 {@link IT_UketoriKouza} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_UketoriKouza}</td><td colspan="3">受取口座テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_UketoriKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_UketoriKouza ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUktsyukbn uktsyukbn}</td><td>受取人種類区分</td><td align="center">{@link PKIT_UketoriKouza ○}</td><td align="center">V</td><td>{@link C_UktsyuKbn}</td></tr>
 *  <tr><td>{@link #getUktsyurenno uktsyurenno}</td><td>受取人種類別連番</td><td align="center">{@link PKIT_UketoriKouza ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKzsyuruikbn kzsyuruikbn}</td><td>口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getYokinkbn yokinkbn}</td><td>預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YokinKbn}</td></tr>
 *  <tr><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKzmeiginmkn kzmeiginmkn}</td><td>口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_UketoriKouza
 * @see     PKIT_UketoriKouza
 * @see     QIT_UketoriKouza
 * @see     GenQIT_UketoriKouza
 */
@MappedSuperclass
@Table(name=GenIT_UketoriKouza.TABLE_NAME)
@IdClass(value=PKIT_UketoriKouza.class)
@TypeDefs({
    @TypeDef(name="UserType_C_KouzasyuruiKbn", typeClass=UserType_C_KouzasyuruiKbn.class),
    @TypeDef(name="UserType_C_UktsyuKbn", typeClass=UserType_C_UktsyuKbn.class),
    @TypeDef(name="UserType_C_YokinKbn", typeClass=UserType_C_YokinKbn.class)
})
public abstract class GenIT_UketoriKouza extends AbstractExDBEntity<IT_UketoriKouza, PKIT_UketoriKouza> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_UketoriKouza";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String UKTSYUKBN                = "uktsyukbn";
    public static final String UKTSYURENNO              = "uktsyurenno";
    public static final String KZSYURUIKBN              = "kzsyuruikbn";
    public static final String BANKCD                   = "bankcd";
    public static final String SITENCD                  = "sitencd";
    public static final String YOKINKBN                 = "yokinkbn";
    public static final String KOUZANO                  = "kouzano";
    public static final String KZMEIGINMKN              = "kzmeiginmkn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_UketoriKouza primaryKey;

    public GenIT_UketoriKouza() {
        primaryKey = new PKIT_UketoriKouza();
    }

    public GenIT_UketoriKouza(
        String pKbnkey,
        String pSyono,
        C_UktsyuKbn pUktsyukbn,
        Integer pUktsyurenno
    ) {
        primaryKey = new PKIT_UketoriKouza(
            pKbnkey,
            pSyono,
            pUktsyukbn,
            pUktsyurenno
        );
    }

    @Transient
    @Override
    public PKIT_UketoriKouza getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_UketoriKouza> getMetaClass() {
        return QIT_UketoriKouza.class;
    }

    @Id
    @Column(name=GenIT_UketoriKouza.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_UketoriKouza.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Type(type="UserType_C_UktsyuKbn")
    @Column(name=GenIT_UketoriKouza.UKTSYUKBN)
    public C_UktsyuKbn getUktsyukbn() {
        return getPrimaryKey().getUktsyukbn();
    }

    public void setUktsyukbn(C_UktsyuKbn pUktsyukbn) {
        getPrimaryKey().setUktsyukbn(pUktsyukbn);
    }

    @Id
    @Column(name=GenIT_UketoriKouza.UKTSYURENNO)
    public Integer getUktsyurenno() {
        return getPrimaryKey().getUktsyurenno();
    }

    public void setUktsyurenno(Integer pUktsyurenno) {
        getPrimaryKey().setUktsyurenno(pUktsyurenno);
    }

    private C_KouzasyuruiKbn kzsyuruikbn;

    @Type(type="UserType_C_KouzasyuruiKbn")
    @Column(name=GenIT_UketoriKouza.KZSYURUIKBN)
    public C_KouzasyuruiKbn getKzsyuruikbn() {
        return kzsyuruikbn;
    }

    public void setKzsyuruikbn(C_KouzasyuruiKbn pKzsyuruikbn) {
        kzsyuruikbn = pKzsyuruikbn;
    }

    private String bankcd;

    @Column(name=GenIT_UketoriKouza.BANKCD)
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

    @Column(name=GenIT_UketoriKouza.SITENCD)
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
    @Column(name=GenIT_UketoriKouza.YOKINKBN)
    public C_YokinKbn getYokinkbn() {
        return yokinkbn;
    }

    public void setYokinkbn(C_YokinKbn pYokinkbn) {
        yokinkbn = pYokinkbn;
    }

    private String kouzano;

    @Column(name=GenIT_UketoriKouza.KOUZANO)
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

    private String kzmeiginmkn;

    @Column(name=GenIT_UketoriKouza.KZMEIGINMKN)
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

    private String gyoumuKousinKinou;

    @Column(name=GenIT_UketoriKouza.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_UketoriKouza.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_UketoriKouza.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}