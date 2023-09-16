package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IM_IktSyuunouRate;
import yuyu.def.db.id.PKIM_IktSyuunouRate;
import yuyu.def.db.meta.GenQIM_IktSyuunouRate;
import yuyu.def.db.meta.QIM_IktSyuunouRate;

/**
 * 一括収納率マスタ テーブルのマッピング情報クラスで、 {@link IM_IktSyuunouRate} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_IktSyuunouRate}</td><td colspan="3">一括収納率マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKIM_IktSyuunouRate ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKIM_IktSyuunouRate ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIktkaisuu iktkaisuu}</td><td>一括回数</td><td align="center">{@link PKIM_IktSyuunouRate ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getIktsyunoritu iktsyunoritu}</td><td>一括収納率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_IktSyuunouRate
 * @see     PKIM_IktSyuunouRate
 * @see     QIM_IktSyuunouRate
 * @see     GenQIM_IktSyuunouRate
 */
@MappedSuperclass
@Table(name=GenIM_IktSyuunouRate.TABLE_NAME)
@IdClass(value=PKIM_IktSyuunouRate.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenIM_IktSyuunouRate extends AbstractExDBEntity<IM_IktSyuunouRate, PKIM_IktSyuunouRate> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IM_IktSyuunouRate";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String IKTKAISUU                = "iktkaisuu";
    public static final String IKTSYUNORITU             = "iktsyunoritu";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIM_IktSyuunouRate primaryKey;

    public GenIM_IktSyuunouRate() {
        primaryKey = new PKIM_IktSyuunouRate();
    }

    public GenIM_IktSyuunouRate(
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pIktkaisuu
    ) {
        primaryKey = new PKIM_IktSyuunouRate(
            pSyouhncd,
            pSyouhnsdno,
            pIktkaisuu
        );
    }

    @Transient
    @Override
    public PKIM_IktSyuunouRate getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIM_IktSyuunouRate> getMetaClass() {
        return QIM_IktSyuunouRate.class;
    }

    @Id
    @Column(name=GenIM_IktSyuunouRate.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenIM_IktSyuunouRate.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenIM_IktSyuunouRate.IKTKAISUU)
    public Integer getIktkaisuu() {
        return getPrimaryKey().getIktkaisuu();
    }

    public void setIktkaisuu(Integer pIktkaisuu) {
        getPrimaryKey().setIktkaisuu(pIktkaisuu);
    }

    private BizNumber iktsyunoritu;

    @Type(type="BizNumberType")
    @Column(name=GenIM_IktSyuunouRate.IKTSYUNORITU)
    public BizNumber getIktsyunoritu() {
        return iktsyunoritu;
    }

    public void setIktsyunoritu(BizNumber pIktsyunoritu) {
        iktsyunoritu = pIktsyunoritu;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIM_IktSyuunouRate.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIM_IktSyuunouRate.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIM_IktSyuunouRate.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
