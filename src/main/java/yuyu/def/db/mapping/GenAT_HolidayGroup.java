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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SysSiyouKbn;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.id.PKAT_HolidayGroup;
import yuyu.def.db.meta.GenQAT_HolidayGroup;
import yuyu.def.db.meta.QAT_HolidayGroup;
import yuyu.def.db.type.UserType_C_SysSiyouKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 休日グループテーブル テーブルのマッピング情報クラスで、 {@link AT_HolidayGroup} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_HolidayGroup}</td><td colspan="3">休日グループテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHolidayGroupCd holidayGroupCd}</td><td>休日グループコード</td><td align="center">{@link PKAT_HolidayGroup ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayGroupNm holidayGroupNm}</td><td>休日グループ名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayGroupDescription holidayGroupDescription}</td><td>休日グループ備考</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSysSiyouKbn sysSiyouKbn}</td><td>システム使用区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SysSiyouKbn}</td></tr>
 * </table>
 * @see     AT_HolidayGroup
 * @see     PKAT_HolidayGroup
 * @see     QAT_HolidayGroup
 * @see     GenQAT_HolidayGroup
 */
@MappedSuperclass
@Table(name=GenAT_HolidayGroup.TABLE_NAME)
@IdClass(value=PKAT_HolidayGroup.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SysSiyouKbn", typeClass=UserType_C_SysSiyouKbn.class)
})
public abstract class GenAT_HolidayGroup extends AbstractExDBEntity<AT_HolidayGroup, PKAT_HolidayGroup> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_HolidayGroup";
    public static final String HOLIDAYGROUPCD           = "holidayGroupCd";
    public static final String HOLIDAYGROUPNM           = "holidayGroupNm";
    public static final String HOLIDAYGROUPDESCRIPTION  = "holidayGroupDescription";
    public static final String SYSSIYOUKBN              = "sysSiyouKbn";

    private final PKAT_HolidayGroup primaryKey;

    public GenAT_HolidayGroup() {
        primaryKey = new PKAT_HolidayGroup();
    }

    public GenAT_HolidayGroup(String pHolidayGroupCd) {
        primaryKey = new PKAT_HolidayGroup(pHolidayGroupCd);
    }

    @Transient
    @Override
    public PKAT_HolidayGroup getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_HolidayGroup> getMetaClass() {
        return QAT_HolidayGroup.class;
    }

    @Id
    @Column(name=GenAT_HolidayGroup.HOLIDAYGROUPCD)
    @MaxLength(max=20)
    @AlphaDigit
    public String getHolidayGroupCd() {
        return getPrimaryKey().getHolidayGroupCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayGroupCd(String pHolidayGroupCd) {
        getPrimaryKey().setHolidayGroupCd(pHolidayGroupCd);
    }

    private String holidayGroupNm;

    @Column(name=GenAT_HolidayGroup.HOLIDAYGROUPNM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getHolidayGroupNm() {
        return holidayGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setHolidayGroupNm(String pHolidayGroupNm) {
        holidayGroupNm = pHolidayGroupNm;
    }

    private String holidayGroupDescription;

    @Column(name=GenAT_HolidayGroup.HOLIDAYGROUPDESCRIPTION)
    @MaxLength(max=100)
    @InvalidCharacter
    public String getHolidayGroupDescription() {
        return holidayGroupDescription;
    }

    @Trim("right")
    public void setHolidayGroupDescription(String pHolidayGroupDescription) {
        holidayGroupDescription = pHolidayGroupDescription;
    }

    private C_SysSiyouKbn sysSiyouKbn;

    @Type(type="UserType_C_SysSiyouKbn")
    @Column(name=GenAT_HolidayGroup.SYSSIYOUKBN)
    public C_SysSiyouKbn getSysSiyouKbn() {
        return sysSiyouKbn;
    }

    public void setSysSiyouKbn(C_SysSiyouKbn pSysSiyouKbn) {
        sysSiyouKbn = pSysSiyouKbn;
    }
}