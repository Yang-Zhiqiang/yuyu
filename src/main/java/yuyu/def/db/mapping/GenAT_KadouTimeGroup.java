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
import yuyu.def.db.entity.AT_KadouTimeGroup;
import yuyu.def.db.id.PKAT_KadouTimeGroup;
import yuyu.def.db.meta.GenQAT_KadouTimeGroup;
import yuyu.def.db.meta.QAT_KadouTimeGroup;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 稼働時間グループテーブル テーブルのマッピング情報クラスで、 {@link AT_KadouTimeGroup} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KadouTimeGroup}</td><td colspan="3">稼働時間グループテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKadouTimeGroupCd kadouTimeGroupCd}</td><td>稼働時間グループコード</td><td align="center">{@link PKAT_KadouTimeGroup ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeGroupNm kadouTimeGroupNm}</td><td>稼働時間グループ名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKadouTimeGroupDescription kadouTimeGroupDescription}</td><td>稼働時間グループ備考</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHolidayGroupCd holidayGroupCd}</td><td>休日グループコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KadouTimeGroup
 * @see     PKAT_KadouTimeGroup
 * @see     QAT_KadouTimeGroup
 * @see     GenQAT_KadouTimeGroup
 */
@MappedSuperclass
@Table(name=GenAT_KadouTimeGroup.TABLE_NAME)
@IdClass(value=PKAT_KadouTimeGroup.class)
public abstract class GenAT_KadouTimeGroup extends AbstractExDBEntity<AT_KadouTimeGroup, PKAT_KadouTimeGroup> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_KadouTimeGroup";
    public static final String KADOUTIMEGROUPCD         = "kadouTimeGroupCd";
    public static final String KADOUTIMEGROUPNM         = "kadouTimeGroupNm";
    public static final String KADOUTIMEGROUPDESCRIPTION = "kadouTimeGroupDescription";
    public static final String HOLIDAYGROUPCD           = "holidayGroupCd";

    private final PKAT_KadouTimeGroup primaryKey;

    public GenAT_KadouTimeGroup() {
        primaryKey = new PKAT_KadouTimeGroup();
    }

    public GenAT_KadouTimeGroup(String pKadouTimeGroupCd) {
        primaryKey = new PKAT_KadouTimeGroup(pKadouTimeGroupCd);
    }

    @Transient
    @Override
    public PKAT_KadouTimeGroup getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_KadouTimeGroup> getMetaClass() {
        return QAT_KadouTimeGroup.class;
    }

    @Id
    @Column(name=GenAT_KadouTimeGroup.KADOUTIMEGROUPCD)
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

    private String kadouTimeGroupNm;

    @Column(name=GenAT_KadouTimeGroup.KADOUTIMEGROUPNM)
    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    public String getKadouTimeGroupNm() {
        return kadouTimeGroupNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKadouTimeGroupNm(String pKadouTimeGroupNm) {
        kadouTimeGroupNm = pKadouTimeGroupNm;
    }

    private String kadouTimeGroupDescription;

    @Column(name=GenAT_KadouTimeGroup.KADOUTIMEGROUPDESCRIPTION)
    @MaxLength(max=100)
    @InvalidCharacter
    public String getKadouTimeGroupDescription() {
        return kadouTimeGroupDescription;
    }

    @Trim("right")
    public void setKadouTimeGroupDescription(String pKadouTimeGroupDescription) {
        kadouTimeGroupDescription = pKadouTimeGroupDescription;
    }

    private String holidayGroupCd;

    @Column(name=GenAT_KadouTimeGroup.HOLIDAYGROUPCD)
    @MaxLength(max=20)
    @AlphaDigit
    public String getHolidayGroupCd() {
        return holidayGroupCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHolidayGroupCd(String pHolidayGroupCd) {
        holidayGroupCd = pHolidayGroupCd;
    }
}