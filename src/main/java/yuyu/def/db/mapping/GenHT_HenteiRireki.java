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
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_HenteiRireki;
import yuyu.def.db.id.PKHT_HenteiRireki;
import yuyu.def.db.meta.GenQHT_HenteiRireki;
import yuyu.def.db.meta.QHT_HenteiRireki;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 変更訂正履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_HenteiRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_HenteiRireki}</td><td colspan="3">変更訂正履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_HenteiRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_HenteiRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHenteiymd henteiymd}</td><td>変更訂正日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_HenteiRireki
 * @see     PKHT_HenteiRireki
 * @see     QHT_HenteiRireki
 * @see     GenQHT_HenteiRireki
 */
@MappedSuperclass
@Table(name=GenHT_HenteiRireki.TABLE_NAME)
@IdClass(value=PKHT_HenteiRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenHT_HenteiRireki extends AbstractExDBEntity<HT_HenteiRireki, PKHT_HenteiRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_HenteiRireki";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String HENTEIYMD                = "henteiymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_HenteiRireki primaryKey;

    public GenHT_HenteiRireki() {
        primaryKey = new PKHT_HenteiRireki();
    }

    public GenHT_HenteiRireki(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_HenteiRireki(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_HenteiRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_HenteiRireki> getMetaClass() {
        return QHT_HenteiRireki.class;
    }

    @Id
    @Column(name=GenHT_HenteiRireki.MOSNO)
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
    @Column(name=GenHT_HenteiRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate henteiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_HenteiRireki.HENTEIYMD)
    @ValidDate
    public BizDate getHenteiymd() {
        return henteiymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHenteiymd(BizDate pHenteiymd) {
        henteiymd = pHenteiymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_HenteiRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_HenteiRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}