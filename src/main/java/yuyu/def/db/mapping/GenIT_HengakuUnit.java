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
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UnitFundKbn;
import yuyu.def.db.entity.IT_HengakuUnit;
import yuyu.def.db.id.PKIT_HengakuUnit;
import yuyu.def.db.meta.GenQIT_HengakuUnit;
import yuyu.def.db.meta.QIT_HengakuUnit;
import yuyu.def.db.type.UserType_C_UnitFundKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 変額ユニットテーブル テーブルのマッピング情報クラスで、 {@link IT_HengakuUnit} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HengakuUnit}</td><td colspan="3">変額ユニットテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_HengakuUnit ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_HengakuUnit ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUnitfundkbn unitfundkbn}</td><td>ユニットファンド区分</td><td align="center">{@link PKIT_HengakuUnit ○}</td><td align="center">V</td><td>{@link C_UnitFundKbn}</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getUnitkouryokuhasseiymd unitkouryokuhasseiymd}</td><td>ユニット効力発生日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUnitkouryokuendymd unitkouryokuendymd}</td><td>ユニット効力終了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getUnitsuu unitsuu}</td><td>ユニット数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getFundhaibunwariai fundhaibunwariai}</td><td>ファンド配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HengakuUnit
 * @see     PKIT_HengakuUnit
 * @see     QIT_HengakuUnit
 * @see     GenQIT_HengakuUnit
 */
@MappedSuperclass
@Table(name=GenIT_HengakuUnit.TABLE_NAME)
@IdClass(value=PKIT_HengakuUnit.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_UnitFundKbn", typeClass=UserType_C_UnitFundKbn.class)
})
public abstract class GenIT_HengakuUnit extends AbstractExDBEntity<IT_HengakuUnit, PKIT_HengakuUnit> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_HengakuUnit";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String UNITFUNDKBN              = "unitfundkbn";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String UNITKOURYOKUHASSEIYMD    = "unitkouryokuhasseiymd";
    public static final String UNITKOURYOKUENDYMD       = "unitkouryokuendymd";
    public static final String UNITSUU                  = "unitsuu";
    public static final String FUNDHAIBUNWARIAI         = "fundhaibunwariai";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_HengakuUnit primaryKey;

    public GenIT_HengakuUnit() {
        primaryKey = new PKIT_HengakuUnit();
    }

    public GenIT_HengakuUnit(
        String pKbnkey,
        String pSyono,
        C_UnitFundKbn pUnitfundkbn
    ) {
        primaryKey = new PKIT_HengakuUnit(
            pKbnkey,
            pSyono,
            pUnitfundkbn
        );
    }

    @Transient
    @Override
    public PKIT_HengakuUnit getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_HengakuUnit> getMetaClass() {
        return QIT_HengakuUnit.class;
    }

    @Id
    @Column(name=GenIT_HengakuUnit.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_HengakuUnit.SYONO)
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
    @Type(type="UserType_C_UnitFundKbn")
    @Column(name=GenIT_HengakuUnit.UNITFUNDKBN)
    public C_UnitFundKbn getUnitfundkbn() {
        return getPrimaryKey().getUnitfundkbn();
    }

    public void setUnitfundkbn(C_UnitFundKbn pUnitfundkbn) {
        getPrimaryKey().setUnitfundkbn(pUnitfundkbn);
    }

    private String henkousikibetukey;

    @Column(name=GenIT_HengakuUnit.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

    private BizDate unitkouryokuhasseiymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HengakuUnit.UNITKOURYOKUHASSEIYMD)
    public BizDate getUnitkouryokuhasseiymd() {
        return unitkouryokuhasseiymd;
    }

    public void setUnitkouryokuhasseiymd(BizDate pUnitkouryokuhasseiymd) {
        unitkouryokuhasseiymd = pUnitkouryokuhasseiymd;
    }

    private BizDate unitkouryokuendymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_HengakuUnit.UNITKOURYOKUENDYMD)
    public BizDate getUnitkouryokuendymd() {
        return unitkouryokuendymd;
    }

    public void setUnitkouryokuendymd(BizDate pUnitkouryokuendymd) {
        unitkouryokuendymd = pUnitkouryokuendymd;
    }

    private BizNumber unitsuu;

    @Type(type="BizNumberType")
    @Column(name=GenIT_HengakuUnit.UNITSUU)
    public BizNumber getUnitsuu() {
        return unitsuu;
    }

    public void setUnitsuu(BizNumber pUnitsuu) {
        unitsuu = pUnitsuu;
    }

    private Integer fundhaibunwariai;

    @Column(name=GenIT_HengakuUnit.FUNDHAIBUNWARIAI)
    public Integer getFundhaibunwariai() {
        return fundhaibunwariai;
    }

    public void setFundhaibunwariai(Integer pFundhaibunwariai) {
        fundhaibunwariai = pFundhaibunwariai;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_HengakuUnit.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_HengakuUnit.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_HengakuUnit.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}