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
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.id.PKHT_MostenkenRireki;
import yuyu.def.db.meta.GenQHT_MostenkenRireki;
import yuyu.def.db.meta.QHT_MostenkenRireki;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 申込点検履歴テーブル テーブルのマッピング情報クラスで、 {@link HT_MostenkenRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_MostenkenRireki}</td><td colspan="3">申込点検履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_MostenkenRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_MostenkenRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSateiketsyorinmkbn sateiketsyorinmkbn}</td><td>査定・決定処理名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SateiketsyorinmKbn}</td></tr>
 *  <tr><td>{@link #getMostenkenkekkakbn mostenkenkekkakbn}</td><td>申込点検結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getTnsketsyacd tnsketsyacd}</td><td>転送先決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKetsyacd ketsyacd}</td><td>決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getPalketsyacd palketsyacd}</td><td>ＰＡＬ決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMostenkencomment mostenkencomment}</td><td>申込点検コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_MostenkenRireki
 * @see     PKHT_MostenkenRireki
 * @see     QHT_MostenkenRireki
 * @see     GenQHT_MostenkenRireki
 */
@MappedSuperclass
@Table(name=GenHT_MostenkenRireki.TABLE_NAME)
@IdClass(value=PKHT_MostenkenRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SateiketsyorinmKbn", typeClass=UserType_C_SateiketsyorinmKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class)
})
public abstract class GenHT_MostenkenRireki extends AbstractExDBEntity<HT_MostenkenRireki, PKHT_MostenkenRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_MostenkenRireki";
    public static final String MOSNO                    = "mosno";
    public static final String RENNO                    = "renno";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SATEIKETSYORINMKBN       = "sateiketsyorinmkbn";
    public static final String MOSTENKENKEKKAKBN        = "mostenkenkekkakbn";
    public static final String TNSKETSYACD              = "tnsketsyacd";
    public static final String KETSYACD                 = "ketsyacd";
    public static final String PALKETSYACD              = "palketsyacd";
    public static final String MOSTENKENCOMMENT         = "mostenkencomment";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_MostenkenRireki primaryKey;

    public GenHT_MostenkenRireki() {
        primaryKey = new PKHT_MostenkenRireki();
    }

    public GenHT_MostenkenRireki(String pMosno, Integer pRenno) {
        primaryKey = new PKHT_MostenkenRireki(pMosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_MostenkenRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_MostenkenRireki> getMetaClass() {
        return QHT_MostenkenRireki.class;
    }

    @Id
    @Column(name=GenHT_MostenkenRireki.MOSNO)
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
    @Column(name=GenHT_MostenkenRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenHT_MostenkenRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private C_SateiketsyorinmKbn sateiketsyorinmkbn;

    @Type(type="UserType_C_SateiketsyorinmKbn")
    @Column(name=GenHT_MostenkenRireki.SATEIKETSYORINMKBN)
    public C_SateiketsyorinmKbn getSateiketsyorinmkbn() {
        return sateiketsyorinmkbn;
    }

    public void setSateiketsyorinmkbn(C_SateiketsyorinmKbn pSateiketsyorinmkbn) {
        sateiketsyorinmkbn = pSateiketsyorinmkbn;
    }

    private C_SyorikekkaKbn mostenkenkekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenHT_MostenkenRireki.MOSTENKENKEKKAKBN)
    public C_SyorikekkaKbn getMostenkenkekkakbn() {
        return mostenkenkekkakbn;
    }

    public void setMostenkenkekkakbn(C_SyorikekkaKbn pMostenkenkekkakbn) {
        mostenkenkekkakbn = pMostenkenkekkakbn;
    }

    private String tnsketsyacd;

    @Column(name=GenHT_MostenkenRireki.TNSKETSYACD)
    public String getTnsketsyacd() {
        return tnsketsyacd;
    }

    public void setTnsketsyacd(String pTnsketsyacd) {
        tnsketsyacd = pTnsketsyacd;
    }

    private String ketsyacd;

    @Column(name=GenHT_MostenkenRireki.KETSYACD)
    @MaxLength(max=15)
    @AlphaDigit
    public String getKetsyacd() {
        return ketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKetsyacd(String pKetsyacd) {
        ketsyacd = pKetsyacd;
    }

    private String palketsyacd;

    @Column(name=GenHT_MostenkenRireki.PALKETSYACD)
    @Length(length=2)
    @SingleByteStrings
    @Digit
    @HostInvalidCharacter
    public String getPalketsyacd() {
        return palketsyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPalketsyacd(String pPalketsyacd) {
        palketsyacd = pPalketsyacd;
    }

    private String mostenkencomment;

    @Column(name=GenHT_MostenkenRireki.MOSTENKENCOMMENT)
    public String getMostenkencomment() {
        return mostenkencomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setMostenkencomment(String pMostenkencomment) {
        mostenkencomment = pMostenkencomment;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_MostenkenRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_MostenkenRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}