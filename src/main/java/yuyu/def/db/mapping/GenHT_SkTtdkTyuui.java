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
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;
import yuyu.def.db.id.PKHT_SkTtdkTyuui;
import yuyu.def.db.meta.GenQHT_SkTtdkTyuui;
import yuyu.def.db.meta.QHT_SkTtdkTyuui;
import yuyu.def.db.type.UserType_C_SkeittdkrenrakuKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 新契約手続注意テーブル テーブルのマッピング情報クラスで、 {@link HT_SkTtdkTyuui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SkTtdkTyuui}</td><td colspan="3">新契約手続注意テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_SkTtdkTyuui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSkeittdkrenrakukbn skeittdkrenrakukbn}</td><td>新契約手続連絡区分</td><td align="center">{@link PKHT_SkTtdkTyuui ○}</td><td align="center">V</td><td>{@link C_SkeittdkrenrakuKbn}</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKHT_SkTtdkTyuui ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSkeittdktyuuinaiyou skeittdktyuuinaiyou}</td><td>新契約手続注意内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkymd trkymd}</td><td>登録日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SkTtdkTyuui
 * @see     PKHT_SkTtdkTyuui
 * @see     QHT_SkTtdkTyuui
 * @see     GenQHT_SkTtdkTyuui
 */
@MappedSuperclass
@Table(name=GenHT_SkTtdkTyuui.TABLE_NAME)
@IdClass(value=PKHT_SkTtdkTyuui.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SkeittdkrenrakuKbn", typeClass=UserType_C_SkeittdkrenrakuKbn.class)
})
public abstract class GenHT_SkTtdkTyuui extends AbstractExDBEntity<HT_SkTtdkTyuui, PKHT_SkTtdkTyuui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SkTtdkTyuui";
    public static final String MOSNO                    = "mosno";
    public static final String SKEITTDKRENRAKUKBN       = "skeittdkrenrakukbn";
    public static final String DATARENNO                = "datarenno";
    public static final String SKEITTDKTYUUINAIYOU      = "skeittdktyuuinaiyou";
    public static final String TRKYMD                   = "trkymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SkTtdkTyuui primaryKey;

    public GenHT_SkTtdkTyuui() {
        primaryKey = new PKHT_SkTtdkTyuui();
    }

    public GenHT_SkTtdkTyuui(
        String pMosno,
        C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn,
        Integer pDatarenno
    ) {
        primaryKey = new PKHT_SkTtdkTyuui(
            pMosno,
            pSkeittdkrenrakukbn,
            pDatarenno
        );
    }

    @Transient
    @Override
    public PKHT_SkTtdkTyuui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SkTtdkTyuui> getMetaClass() {
        return QHT_SkTtdkTyuui.class;
    }

    @Id
    @Column(name=GenHT_SkTtdkTyuui.MOSNO)
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
    @Type(type="UserType_C_SkeittdkrenrakuKbn")
    @Column(name=GenHT_SkTtdkTyuui.SKEITTDKRENRAKUKBN)
    public C_SkeittdkrenrakuKbn getSkeittdkrenrakukbn() {
        return getPrimaryKey().getSkeittdkrenrakukbn();
    }

    public void setSkeittdkrenrakukbn(C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn) {
        getPrimaryKey().setSkeittdkrenrakukbn(pSkeittdkrenrakukbn);
    }

    @Id
    @Column(name=GenHT_SkTtdkTyuui.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private String skeittdktyuuinaiyou;

    @Column(name=GenHT_SkTtdkTyuui.SKEITTDKTYUUINAIYOU)
    @InvalidCharacter
    public String getSkeittdktyuuinaiyou() {
        return skeittdktyuuinaiyou;
    }

    @Trim("both")
    public void setSkeittdktyuuinaiyou(String pSkeittdktyuuinaiyou) {
        skeittdktyuuinaiyou = pSkeittdktyuuinaiyou;
    }

    private BizDate trkymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_SkTtdkTyuui.TRKYMD)
    @ValidDate
    public BizDate getTrkymd() {
        return trkymd;
    }

    @Trim("both")
    public void setTrkymd(BizDate pTrkymd) {
        trkymd = pTrkymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SkTtdkTyuui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SkTtdkTyuui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}