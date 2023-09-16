package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.TimeHM;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_EigyoubiKbn;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;
import yuyu.def.db.entity.AT_KadouTime;
import yuyu.def.db.id.PKAT_KadouTime;
import yuyu.def.db.meta.GenQAT_KadouTime;
import yuyu.def.db.meta.QAT_KadouTime;
import yuyu.def.db.type.UserType_C_EigyoubiKbn;
import yuyu.def.db.type.UserType_C_KadouTimeSiteiKbn;
import yuyu.def.db.type.UserType_C_KadouTimeYoubiKbn;

/**
 * 稼働時間テーブル テーブルのマッピング情報クラスで、 {@link AT_KadouTime} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KadouTime}</td><td colspan="3">稼働時間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">{@link PKAT_KadouTime ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeYoubiKbn kadouTimeYoubiKbn}</td><td>稼働時間曜日区分</td><td align="center">{@link PKAT_KadouTime ○}</td><td align="center">V</td><td>{@link C_KadouTimeYoubiKbn}</td></tr>
 *  <tr><td>{@link #getEigyoubiKbn eigyoubiKbn}</td><td>営業日区分</td><td align="center">{@link PKAT_KadouTime ○}</td><td align="center">V</td><td>{@link C_EigyoubiKbn}</td></tr>
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
 * @see     AT_KadouTime
 * @see     PKAT_KadouTime
 * @see     QAT_KadouTime
 * @see     GenQAT_KadouTime
 */
@MappedSuperclass
@Table(name=GenAT_KadouTime.TABLE_NAME)
@IdClass(value=PKAT_KadouTime.class)
@TypeDefs({
    @TypeDef(name="UserType_C_EigyoubiKbn", typeClass=UserType_C_EigyoubiKbn.class),
    @TypeDef(name="UserType_C_KadouTimeSiteiKbn", typeClass=UserType_C_KadouTimeSiteiKbn.class),
    @TypeDef(name="UserType_C_KadouTimeYoubiKbn", typeClass=UserType_C_KadouTimeYoubiKbn.class)
})
public abstract class GenAT_KadouTime extends AbstractExDBEntity<AT_KadouTime, PKAT_KadouTime> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_KadouTime";
    public static final String KADOUTIMEGROUPCD         = "kadouTimeGroupCd";
    public static final String KADOUTIMEYOUBIKBN        = "kadouTimeYoubiKbn";
    public static final String EIGYOUBIKBN              = "eigyoubiKbn";
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

    private final PKAT_KadouTime primaryKey;

    public GenAT_KadouTime() {
        primaryKey = new PKAT_KadouTime();
    }

    public GenAT_KadouTime(
        String pKadouTimeGroupCd,
        C_KadouTimeYoubiKbn pKadouTimeYoubiKbn,
        C_EigyoubiKbn pEigyoubiKbn
    ) {
        primaryKey = new PKAT_KadouTime(
            pKadouTimeGroupCd,
            pKadouTimeYoubiKbn,
            pEigyoubiKbn
        );
    }

    @Transient
    @Override
    public PKAT_KadouTime getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_KadouTime> getMetaClass() {
        return QAT_KadouTime.class;
    }

    @Id
    @Column(name=GenAT_KadouTime.KADOUTIMEGROUPCD)
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
    @Type(type="UserType_C_KadouTimeYoubiKbn")
    @Column(name=GenAT_KadouTime.KADOUTIMEYOUBIKBN)
    public C_KadouTimeYoubiKbn getKadouTimeYoubiKbn() {
        return getPrimaryKey().getKadouTimeYoubiKbn();
    }

    public void setKadouTimeYoubiKbn(C_KadouTimeYoubiKbn pKadouTimeYoubiKbn) {
        getPrimaryKey().setKadouTimeYoubiKbn(pKadouTimeYoubiKbn);
    }

    @Id
    @Type(type="UserType_C_EigyoubiKbn")
    @Column(name=GenAT_KadouTime.EIGYOUBIKBN)
    public C_EigyoubiKbn getEigyoubiKbn() {
        return getPrimaryKey().getEigyoubiKbn();
    }

    public void setEigyoubiKbn(C_EigyoubiKbn pEigyoubiKbn) {
        getPrimaryKey().setEigyoubiKbn(pEigyoubiKbn);
    }

    private C_KadouTimeSiteiKbn kadouTimeSiteiKbn;

    @Type(type="UserType_C_KadouTimeSiteiKbn")
    @Column(name=GenAT_KadouTime.KADOUTIMESITEIKBN)
    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn() {
        return kadouTimeSiteiKbn;
    }

    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {
        kadouTimeSiteiKbn = pKadouTimeSiteiKbn;
    }

    private String kadouTimeFrom1;

    @Column(name=GenAT_KadouTime.KADOUTIMEFROM1)
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

    @Column(name=GenAT_KadouTime.KADOUTIMETO1)
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

    @Column(name=GenAT_KadouTime.KADOUTIMEFROM2)
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

    @Column(name=GenAT_KadouTime.KADOUTIMETO2)
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

    @Column(name=GenAT_KadouTime.KADOUTIMEFROM3)
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

    @Column(name=GenAT_KadouTime.KADOUTIMETO3)
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

    @Column(name=GenAT_KadouTime.KADOUTIMEFROM4)
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

    @Column(name=GenAT_KadouTime.KADOUTIMETO4)
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

    @Column(name=GenAT_KadouTime.KADOUTIMEFROM5)
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

    @Column(name=GenAT_KadouTime.KADOUTIMETO5)
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
