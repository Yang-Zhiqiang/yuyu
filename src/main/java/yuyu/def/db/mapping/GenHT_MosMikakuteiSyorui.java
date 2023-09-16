package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.id.PKHT_MosMikakuteiSyorui;
import yuyu.def.db.meta.GenQHT_MosMikakuteiSyorui;
import yuyu.def.db.meta.QHT_MosMikakuteiSyorui;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込未確定書類テーブル テーブルのマッピング情報クラスで、 {@link HT_MosMikakuteiSyorui} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MosMikakuteiSyorui}</td><td colspan="3">申込未確定書類テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDocumentid documentid}</td><td>ドキュメントＩＤ</td><td align="center">{@link PKHT_MosMikakuteiSyorui ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MosMikakuteiSyorui
 * @see     PKHT_MosMikakuteiSyorui
 * @see     QHT_MosMikakuteiSyorui
 * @see     GenQHT_MosMikakuteiSyorui
 */
@MappedSuperclass
@Table(name=GenHT_MosMikakuteiSyorui.TABLE_NAME)
@IdClass(value=PKHT_MosMikakuteiSyorui.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenHT_MosMikakuteiSyorui extends AbstractExDBEntity<HT_MosMikakuteiSyorui, PKHT_MosMikakuteiSyorui> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MosMikakuteiSyorui";
    public static final String DOCUMENTID               = "documentid";
    public static final String MOSNO                    = "mosno";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MosMikakuteiSyorui primaryKey;

    public GenHT_MosMikakuteiSyorui() {
        primaryKey = new PKHT_MosMikakuteiSyorui();
    }

    public GenHT_MosMikakuteiSyorui(String pDocumentid) {
        primaryKey = new PKHT_MosMikakuteiSyorui(pDocumentid);
    }

    @Transient
    @Override
    public PKHT_MosMikakuteiSyorui getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MosMikakuteiSyorui> getMetaClass() {
        return QHT_MosMikakuteiSyorui.class;
    }

    @Id
    @Column(name=GenHT_MosMikakuteiSyorui.DOCUMENTID)
    @MaxLength(max=24)
    @SingleByteStrings
    public String getDocumentid() {
        return getPrimaryKey().getDocumentid();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDocumentid(String pDocumentid) {
        getPrimaryKey().setDocumentid(pDocumentid);
    }

    private String mosno;

    @Column(name=GenHT_MosMikakuteiSyorui.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenHT_MosMikakuteiSyorui.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MosMikakuteiSyorui.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MosMikakuteiSyorui.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}