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
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.id.PKJT_SateiSyouninRireki;
import yuyu.def.db.meta.GenQJT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_SateiSyouninRireki;
import yuyu.def.db.type.UserType_C_HigaitouRiyuuKbn;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定承認履歴テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiSyouninRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiSyouninRireki}</td><td colspan="3">査定承認履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiSyouninRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiSyouninRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSateisyouninskbtkey sateisyouninskbtkey}</td><td>査定承認識別キー</td><td align="center">{@link PKJT_SateiSyouninRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyorikekkakbn syorikekkakbn}</td><td>処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getTennousakisousasyacd tennousakisousasyacd}</td><td>転送先操作者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHushrgeninkbn hushrgeninkbn}</td><td>不支払原因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HushrGeninKbn}</td></tr>
 *  <tr><td>{@link #getHigaitouriyuukbn higaitouriyuukbn}</td><td>非該当理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HigaitouRiyuuKbn}</td></tr>
 *  <tr><td>{@link #getReportcomment reportcomment}</td><td>帳票用コメント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSessyouyhkbn sessyouyhkbn}</td><td>折衝要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiblnkKbn}</td></tr>
 *  <tr><td>{@link #getSessyousisyacd sessyousisyacd}</td><td>折衝支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKaiketuymd kaiketuymd}</td><td>解決日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiSyouninRireki
 * @see     PKJT_SateiSyouninRireki
 * @see     QJT_SateiSyouninRireki
 * @see     GenQJT_SateiSyouninRireki
 */
@MappedSuperclass
@Table(name=GenJT_SateiSyouninRireki.TABLE_NAME)
@IdClass(value=PKJT_SateiSyouninRireki.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HigaitouRiyuuKbn", typeClass=UserType_C_HigaitouRiyuuKbn.class),
    @TypeDef(name="UserType_C_HushrGeninKbn", typeClass=UserType_C_HushrGeninKbn.class),
    @TypeDef(name="UserType_C_SyorikekkaKbn", typeClass=UserType_C_SyorikekkaKbn.class),
    @TypeDef(name="UserType_C_YouhiblnkKbn", typeClass=UserType_C_YouhiblnkKbn.class)
})
public abstract class GenJT_SateiSyouninRireki extends AbstractExDBEntity<JT_SateiSyouninRireki, PKJT_SateiSyouninRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiSyouninRireki";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SATEISYOUNINSKBTKEY      = "sateisyouninskbtkey";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SYORIKEKKAKBN            = "syorikekkakbn";
    public static final String TENNOUSAKISOUSASYACD     = "tennousakisousasyacd";
    public static final String HUSHRGENINKBN            = "hushrgeninkbn";
    public static final String HIGAITOURIYUUKBN         = "higaitouriyuukbn";
    public static final String REPORTCOMMENT            = "reportcomment";
    public static final String SESSYOUYHKBN             = "sessyouyhkbn";
    public static final String SESSYOUSISYACD           = "sessyousisyacd";
    public static final String KAIKETUYMD               = "kaiketuymd";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiSyouninRireki primaryKey;

    public GenJT_SateiSyouninRireki() {
        primaryKey = new PKJT_SateiSyouninRireki();
    }

    public GenJT_SateiSyouninRireki(
        String pSkno,
        String pSyono,
        String pSateisyouninskbtkey
    ) {
        primaryKey = new PKJT_SateiSyouninRireki(
            pSkno,
            pSyono,
            pSateisyouninskbtkey
        );
    }

    @Transient
    @Override
    public PKJT_SateiSyouninRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiSyouninRireki> getMetaClass() {
        return QJT_SateiSyouninRireki.class;
    }

    @Id
    @Column(name=GenJT_SateiSyouninRireki.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiSyouninRireki.SYONO)
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
    @Column(name=GenJT_SateiSyouninRireki.SATEISYOUNINSKBTKEY)
    public String getSateisyouninskbtkey() {
        return getPrimaryKey().getSateisyouninskbtkey();
    }

    public void setSateisyouninskbtkey(String pSateisyouninskbtkey) {
        getPrimaryKey().setSateisyouninskbtkey(pSateisyouninskbtkey);
    }

    private Integer seikyuurirekino;

    @Column(name=GenJT_SateiSyouninRireki.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }

    private C_SyorikekkaKbn syorikekkakbn;

    @Type(type="UserType_C_SyorikekkaKbn")
    @Column(name=GenJT_SateiSyouninRireki.SYORIKEKKAKBN)
    public C_SyorikekkaKbn getSyorikekkakbn() {
        return syorikekkakbn;
    }

    public void setSyorikekkakbn(C_SyorikekkaKbn pSyorikekkakbn) {
        syorikekkakbn = pSyorikekkakbn;
    }

    private String tennousakisousasyacd;

    @Column(name=GenJT_SateiSyouninRireki.TENNOUSAKISOUSASYACD)
    public String getTennousakisousasyacd() {
        return tennousakisousasyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTennousakisousasyacd(String pTennousakisousasyacd) {
        tennousakisousasyacd = pTennousakisousasyacd;
    }

    private C_HushrGeninKbn hushrgeninkbn;

    @Type(type="UserType_C_HushrGeninKbn")
    @Column(name=GenJT_SateiSyouninRireki.HUSHRGENINKBN)
    public C_HushrGeninKbn getHushrgeninkbn() {
        return hushrgeninkbn;
    }

    public void setHushrgeninkbn(C_HushrGeninKbn pHushrgeninkbn) {
        hushrgeninkbn = pHushrgeninkbn;
    }

    private C_HigaitouRiyuuKbn higaitouriyuukbn;

    @Type(type="UserType_C_HigaitouRiyuuKbn")
    @Column(name=GenJT_SateiSyouninRireki.HIGAITOURIYUUKBN)
    public C_HigaitouRiyuuKbn getHigaitouriyuukbn() {
        return higaitouriyuukbn;
    }

    public void setHigaitouriyuukbn(C_HigaitouRiyuuKbn pHigaitouriyuukbn) {
        higaitouriyuukbn = pHigaitouriyuukbn;
    }

    private String reportcomment;

    @Column(name=GenJT_SateiSyouninRireki.REPORTCOMMENT)
    public String getReportcomment() {
        return reportcomment;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setReportcomment(String pReportcomment) {
        reportcomment = pReportcomment;
    }

    private C_YouhiblnkKbn sessyouyhkbn;

    @Type(type="UserType_C_YouhiblnkKbn")
    @Column(name=GenJT_SateiSyouninRireki.SESSYOUYHKBN)
    public C_YouhiblnkKbn getSessyouyhkbn() {
        return sessyouyhkbn;
    }

    public void setSessyouyhkbn(C_YouhiblnkKbn pSessyouyhkbn) {
        sessyouyhkbn = pSessyouyhkbn;
    }

    private String sessyousisyacd;

    @Column(name=GenJT_SateiSyouninRireki.SESSYOUSISYACD)
    @Length(length=3)
    @SingleByteStrings
    public String getSessyousisyacd() {
        return sessyousisyacd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSessyousisyacd(String pSessyousisyacd) {
        sessyousisyacd = pSessyousisyacd;
    }

    private BizDate kaiketuymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SateiSyouninRireki.KAIKETUYMD)
    @ValidDate
    public BizDate getKaiketuymd() {
        return kaiketuymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaiketuymd(BizDate pKaiketuymd) {
        kaiketuymd = pKaiketuymd;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiSyouninRireki.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiSyouninRireki.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiSyouninRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiSyouninRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}