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
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStringsReturnable;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_JimukakuteiKbn;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.id.PKJT_TtdkRireki;
import yuyu.def.db.meta.GenQJT_TtdkRireki;
import yuyu.def.db.meta.QJT_TtdkRireki;
import yuyu.def.db.type.UserType_C_JimukakuteiKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続履歴テーブル テーブルのマッピング情報クラスで、 {@link JT_TtdkRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_TtdkRireki}</td><td colspan="3">手続履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_TtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_TtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTtdkrrkskbtkey ttdkrrkskbtkey}</td><td>手続履歴識別キー</td><td align="center">{@link PKJT_TtdkRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSyorisosikicd syorisosikicd}</td><td>処理組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJimukakuteiumukbn jimukakuteiumukbn}</td><td>事務確定有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JimukakuteiKbn}</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getShrsikibetukey shrsikibetukey}</td><td>支払識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSateisyouninskbtkey sateisyouninskbtkey}</td><td>査定承認識別キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyanaicomment syanaicomment}</td><td>社内用コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_TtdkRireki
 * @see     PKJT_TtdkRireki
 * @see     QJT_TtdkRireki
 * @see     GenQJT_TtdkRireki
 */
@MappedSuperclass
@Table(name=GenJT_TtdkRireki.TABLE_NAME)
@IdClass(value=PKJT_TtdkRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_JimukakuteiKbn", typeClass=UserType_C_JimukakuteiKbn.class)
})
public abstract class GenJT_TtdkRireki extends AbstractExDBEntity<JT_TtdkRireki, PKJT_TtdkRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_TtdkRireki";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String TTDKRRKSKBTKEY           = "ttdkrrkskbtkey";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SYORISOSIKICD            = "syorisosikicd";
    public static final String JIMUKAKUTEIUMUKBN        = "jimukakuteiumukbn";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SHRSIKIBETUKEY           = "shrsikibetukey";
    public static final String SATEISYOUNINSKBTKEY      = "sateisyouninskbtkey";
    public static final String SYANAICOMMENT            = "syanaicomment";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_TtdkRireki primaryKey;

    public GenJT_TtdkRireki() {
        primaryKey = new PKJT_TtdkRireki();
    }

    public GenJT_TtdkRireki(
        String pSkno,
        String pSyono,
        String pTtdkrrkskbtkey
    ) {
        primaryKey = new PKJT_TtdkRireki(
            pSkno,
            pSyono,
            pTtdkrrkskbtkey
        );
    }

    @Transient
    @Override
    public PKJT_TtdkRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_TtdkRireki> getMetaClass() {
        return QJT_TtdkRireki.class;
    }

    @Id
    @Column(name=GenJT_TtdkRireki.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_TtdkRireki.SYONO)
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
    @Column(name=GenJT_TtdkRireki.TTDKRRKSKBTKEY)
    public String getTtdkrrkskbtkey() {
        return getPrimaryKey().getTtdkrrkskbtkey();
    }

    public void setTtdkrrkskbtkey(String pTtdkrrkskbtkey) {
        getPrimaryKey().setTtdkrrkskbtkey(pTtdkrrkskbtkey);
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenJT_TtdkRireki.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private String syorisosikicd;

    @Column(name=GenJT_TtdkRireki.SYORISOSIKICD)
    public String getSyorisosikicd() {
        return syorisosikicd;
    }

    public void setSyorisosikicd(String pSyorisosikicd) {
        syorisosikicd = pSyorisosikicd;
    }

    private C_JimukakuteiKbn jimukakuteiumukbn;

    @Type(type="UserType_C_JimukakuteiKbn")
    @Column(name=GenJT_TtdkRireki.JIMUKAKUTEIUMUKBN)
    public C_JimukakuteiKbn getJimukakuteiumukbn() {
        return jimukakuteiumukbn;
    }

    public void setJimukakuteiumukbn(C_JimukakuteiKbn pJimukakuteiumukbn) {
        jimukakuteiumukbn = pJimukakuteiumukbn;
    }

    private Integer seikyuurirekino;

    @Column(name=GenJT_TtdkRireki.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    private String shrsikibetukey;

    @Column(name=GenJT_TtdkRireki.SHRSIKIBETUKEY)
    public String getShrsikibetukey() {
        return shrsikibetukey;
    }

    public void setShrsikibetukey(String pShrsikibetukey) {
        shrsikibetukey = pShrsikibetukey;
    }

    private String sateisyouninskbtkey;

    @Column(name=GenJT_TtdkRireki.SATEISYOUNINSKBTKEY)
    public String getSateisyouninskbtkey() {
        return sateisyouninskbtkey;
    }

    public void setSateisyouninskbtkey(String pSateisyouninskbtkey) {
        sateisyouninskbtkey = pSateisyouninskbtkey;
    }

    private String syanaicomment;

    @Column(name=GenJT_TtdkRireki.SYANAICOMMENT)
    @MaxLength(max=1500)
    @MultiByteStringsReturnable
    @InvalidCharacter
    public String getSyanaicomment() {
        return syanaicomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyanaicomment(String pSyanaicomment) {
        syanaicomment = pSyanaicomment;
    }

    private String kossyoricd;

    @Column(name=GenJT_TtdkRireki.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_TtdkRireki.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_TtdkRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_TtdkRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}