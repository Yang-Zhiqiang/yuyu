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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsSyoriNaiyouKbn;
import yuyu.def.db.entity.MT_SousaRirekiSyousai;
import yuyu.def.db.id.PKMT_SousaRirekiSyousai;
import yuyu.def.db.meta.GenQMT_SousaRirekiSyousai;
import yuyu.def.db.meta.QMT_SousaRirekiSyousai;
import yuyu.def.db.type.UserType_C_DsSyoriNaiyouKbn;

/**
 * 操作履歴詳細テーブル テーブルのマッピング情報クラスで、 {@link MT_SousaRirekiSyousai} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_SousaRirekiSyousai}</td><td colspan="3">操作履歴詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTtdksikibetuid ttdksikibetuid}</td><td>手続識別ＩＤ</td><td align="center">{@link PKMT_SousaRirekiSyousai ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSousarirekirenno sousarirekirenno}</td><td>操作履歴連番</td><td align="center">{@link PKMT_SousaRirekiSyousai ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriendymd syoriendymd}</td><td>処理終了日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyoriendtime syoriendtime}</td><td>処理終了時刻</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyorinaiyoukbn syorinaiyoukbn}</td><td>処理内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsSyoriNaiyouKbn}</td></tr>
 *  <tr><td>{@link #getSyorisyousai syorisyousai}</td><td>処理詳細</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_SousaRirekiSyousai
 * @see     PKMT_SousaRirekiSyousai
 * @see     QMT_SousaRirekiSyousai
 * @see     GenQMT_SousaRirekiSyousai
 */
@MappedSuperclass
@Table(name=GenMT_SousaRirekiSyousai.TABLE_NAME)
@IdClass(value=PKMT_SousaRirekiSyousai.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsSyoriNaiyouKbn", typeClass=UserType_C_DsSyoriNaiyouKbn.class)
})
public abstract class GenMT_SousaRirekiSyousai extends AbstractExDBEntity<MT_SousaRirekiSyousai, PKMT_SousaRirekiSyousai> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_SousaRirekiSyousai";
    public static final String TTDKSIKIBETUID           = "ttdksikibetuid";
    public static final String SOUSARIREKIRENNO         = "sousarirekirenno";
    public static final String SYORIENDYMD              = "syoriendymd";
    public static final String SYORIENDTIME             = "syoriendtime";
    public static final String SYORINAIYOUKBN           = "syorinaiyoukbn";
    public static final String SYORISYOUSAI             = "syorisyousai";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_SousaRirekiSyousai primaryKey;

    public GenMT_SousaRirekiSyousai() {
        primaryKey = new PKMT_SousaRirekiSyousai();
    }

    public GenMT_SousaRirekiSyousai(String pTtdksikibetuid, Integer pSousarirekirenno) {
        primaryKey = new PKMT_SousaRirekiSyousai(pTtdksikibetuid, pSousarirekirenno);
    }

    @Transient
    @Override
    public PKMT_SousaRirekiSyousai getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_SousaRirekiSyousai> getMetaClass() {
        return QMT_SousaRirekiSyousai.class;
    }

    @Id
    @Column(name=GenMT_SousaRirekiSyousai.TTDKSIKIBETUID)
    public String getTtdksikibetuid() {
        return getPrimaryKey().getTtdksikibetuid();
    }

    public void setTtdksikibetuid(String pTtdksikibetuid) {
        getPrimaryKey().setTtdksikibetuid(pTtdksikibetuid);
    }

    @Id
    @Column(name=GenMT_SousaRirekiSyousai.SOUSARIREKIRENNO)
    public Integer getSousarirekirenno() {
        return getPrimaryKey().getSousarirekirenno();
    }

    public void setSousarirekirenno(Integer pSousarirekirenno) {
        getPrimaryKey().setSousarirekirenno(pSousarirekirenno);
    }

    private BizDate syoriendymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_SousaRirekiSyousai.SYORIENDYMD)
    public BizDate getSyoriendymd() {
        return syoriendymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriendymd(BizDate pSyoriendymd) {
        syoriendymd = pSyoriendymd;
    }

    private String syoriendtime;

    @Column(name=GenMT_SousaRirekiSyousai.SYORIENDTIME)
    public String getSyoriendtime() {
        return syoriendtime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriendtime(String pSyoriendtime) {
        syoriendtime = pSyoriendtime;
    }

    private C_DsSyoriNaiyouKbn syorinaiyoukbn;

    @Type(type="UserType_C_DsSyoriNaiyouKbn")
    @Column(name=GenMT_SousaRirekiSyousai.SYORINAIYOUKBN)
    public C_DsSyoriNaiyouKbn getSyorinaiyoukbn() {
        return syorinaiyoukbn;
    }

    public void setSyorinaiyoukbn(C_DsSyoriNaiyouKbn pSyorinaiyoukbn) {
        syorinaiyoukbn = pSyorinaiyoukbn;
    }

    private String syorisyousai;

    @Column(name=GenMT_SousaRirekiSyousai.SYORISYOUSAI)
    public String getSyorisyousai() {
        return syorisyousai;
    }

    public void setSyorisyousai(String pSyorisyousai) {
        syorisyousai = pSyorisyousai;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_SousaRirekiSyousai.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_SousaRirekiSyousai.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_SousaRirekiSyousai.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}