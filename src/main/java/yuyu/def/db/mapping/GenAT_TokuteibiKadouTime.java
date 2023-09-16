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
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.TimeHM;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.db.entity.AT_TokuteibiKadouTime;
import yuyu.def.db.id.PKAT_TokuteibiKadouTime;
import yuyu.def.db.meta.GenQAT_TokuteibiKadouTime;
import yuyu.def.db.meta.QAT_TokuteibiKadouTime;
import yuyu.def.db.type.UserType_C_KadouTimeSiteiKbn;

/**
 * 特定日稼働時間テーブル テーブルのマッピング情報クラスで、 {@link AT_TokuteibiKadouTime} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TokuteibiKadouTime}</td><td colspan="3">特定日稼働時間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">{@link PKAT_TokuteibiKadouTime ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeSiteiYmd kadouTimeSiteiYmd}</td><td>稼働時間指定年月日</td><td align="center">{@link PKAT_TokuteibiKadouTime ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKadouTimeSiteiKbn kadouTimeSiteiKbn}</td><td>稼働時間指定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KadouTimeSiteiKbn}</td></tr>
 *  <tr><td>{@link #getKadouTimeFrom1 kadouTimeFrom1}</td><td>稼働時間１（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeTo1 kadouTimeTo1}</td><td>稼働時間１（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeFrom2 kadouTimeFrom2}</td><td>稼働時間２（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeTo2 kadouTimeTo2}</td><td>稼働時間２（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeFrom3 kadouTimeFrom3}</td><td>稼働時間３（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeTo3 kadouTimeTo3}</td><td>稼働時間３（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeFrom4 kadouTimeFrom4}</td><td>稼働時間４（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeTo4 kadouTimeTo4}</td><td>稼働時間４（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeFrom5 kadouTimeFrom5}</td><td>稼働時間５（自）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeTo5 kadouTimeTo5}</td><td>稼働時間５（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_TokuteibiKadouTime
 * @see     PKAT_TokuteibiKadouTime
 * @see     QAT_TokuteibiKadouTime
 * @see     GenQAT_TokuteibiKadouTime
 */
@MappedSuperclass
@Table(name=GenAT_TokuteibiKadouTime.TABLE_NAME)
@IdClass(value=PKAT_TokuteibiKadouTime.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_KadouTimeSiteiKbn", typeClass=UserType_C_KadouTimeSiteiKbn.class)
})
public abstract class GenAT_TokuteibiKadouTime extends AbstractExDBEntity<AT_TokuteibiKadouTime, PKAT_TokuteibiKadouTime> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_TokuteibiKadouTime";
    public static final String KADOUTIMEGROUPCD         = "kadouTimeGroupCd";
    public static final String KADOUTIMESITEIYMD        = "kadouTimeSiteiYmd";
    public static final String KADOUTIMESITEIKBN        = "kadouTimeSiteiKbn";
    public static final String KADOUTIMEFROM1           = "kadouTimeFrom1";
    public static final String KADOUTIMETO1             = "kadouTimeTo1";
    public static final String KADOUTIMEFROM2           = "kadouTimeFrom2";
    public static final String KADOUTIMETO2             = "kadouTimeTo2";
    public static final String KADOUTIMEFROM3           = "kadouTimeFrom3";
    public static final String KADOUTIMETO3             = "kadouTimeTo3";
    public static final String KADOUTIMEFROM4           = "kadouTimeFrom4";
    public static final String KADOUTIMETO4             = "kadouTimeTo4";
    public static final String KADOUTIMEFROM5           = "kadouTimeFrom5";
    public static final String KADOUTIMETO5             = "kadouTimeTo5";

    private final PKAT_TokuteibiKadouTime primaryKey;

    public GenAT_TokuteibiKadouTime() {
        primaryKey = new PKAT_TokuteibiKadouTime();
    }

    public GenAT_TokuteibiKadouTime(String pKadouTimeGroupCd, BizDate pKadouTimeSiteiYmd) {
        primaryKey = new PKAT_TokuteibiKadouTime(pKadouTimeGroupCd, pKadouTimeSiteiYmd);
    }

    @Transient
    @Override
    public PKAT_TokuteibiKadouTime getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_TokuteibiKadouTime> getMetaClass() {
        return QAT_TokuteibiKadouTime.class;
    }

    @Id
    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEGROUPCD)
    @MaxLength(max=20)
    @AlphaDigit
    public String getKadouTimeGroupCd() {
        return getPrimaryKey().getKadouTimeGroupCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeGroupCd(String pKadouTimeGroupCd) {
        getPrimaryKey().setKadouTimeGroupCd(pKadouTimeGroupCd);
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMESITEIYMD)
    @ValidDate
    public BizDate getKadouTimeSiteiYmd() {
        return getPrimaryKey().getKadouTimeSiteiYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeSiteiYmd(BizDate pKadouTimeSiteiYmd) {
        getPrimaryKey().setKadouTimeSiteiYmd(pKadouTimeSiteiYmd);
    }

    private C_KadouTimeSiteiKbn kadouTimeSiteiKbn;

    @Type(type="UserType_C_KadouTimeSiteiKbn")
    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMESITEIKBN)
    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn() {
        return kadouTimeSiteiKbn;
    }

    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {
        kadouTimeSiteiKbn = pKadouTimeSiteiKbn;
    }

    private String kadouTimeFrom1;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEFROM1)
    @TimeHM
    public String getKadouTimeFrom1() {
        return kadouTimeFrom1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeFrom1(String pKadouTimeFrom1) {
        kadouTimeFrom1 = pKadouTimeFrom1;
    }

    private String kadouTimeTo1;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMETO1)
    @TimeHM
    public String getKadouTimeTo1() {
        return kadouTimeTo1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeTo1(String pKadouTimeTo1) {
        kadouTimeTo1 = pKadouTimeTo1;
    }

    private String kadouTimeFrom2;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEFROM2)
    @TimeHM
    public String getKadouTimeFrom2() {
        return kadouTimeFrom2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeFrom2(String pKadouTimeFrom2) {
        kadouTimeFrom2 = pKadouTimeFrom2;
    }

    private String kadouTimeTo2;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMETO2)
    @TimeHM
    public String getKadouTimeTo2() {
        return kadouTimeTo2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeTo2(String pKadouTimeTo2) {
        kadouTimeTo2 = pKadouTimeTo2;
    }

    private String kadouTimeFrom3;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEFROM3)
    @TimeHM
    public String getKadouTimeFrom3() {
        return kadouTimeFrom3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeFrom3(String pKadouTimeFrom3) {
        kadouTimeFrom3 = pKadouTimeFrom3;
    }

    private String kadouTimeTo3;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMETO3)
    @TimeHM
    public String getKadouTimeTo3() {
        return kadouTimeTo3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeTo3(String pKadouTimeTo3) {
        kadouTimeTo3 = pKadouTimeTo3;
    }

    private String kadouTimeFrom4;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEFROM4)
    @TimeHM
    public String getKadouTimeFrom4() {
        return kadouTimeFrom4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeFrom4(String pKadouTimeFrom4) {
        kadouTimeFrom4 = pKadouTimeFrom4;
    }

    private String kadouTimeTo4;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMETO4)
    @TimeHM
    public String getKadouTimeTo4() {
        return kadouTimeTo4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeTo4(String pKadouTimeTo4) {
        kadouTimeTo4 = pKadouTimeTo4;
    }

    private String kadouTimeFrom5;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMEFROM5)
    @TimeHM
    public String getKadouTimeFrom5() {
        return kadouTimeFrom5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeFrom5(String pKadouTimeFrom5) {
        kadouTimeFrom5 = pKadouTimeFrom5;
    }

    private String kadouTimeTo5;

    @Column(name=GenAT_TokuteibiKadouTime.KADOUTIMETO5)
    @TimeHM
    public String getKadouTimeTo5() {
        return kadouTimeTo5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKadouTimeTo5(String pKadouTimeTo5) {
        kadouTimeTo5 = pKadouTimeTo5;
    }
}
