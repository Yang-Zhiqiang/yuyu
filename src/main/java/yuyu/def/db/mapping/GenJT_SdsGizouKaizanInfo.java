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
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_TelkknKbn;
import yuyu.def.db.entity.JT_SdsGizouKaizanInfo;
import yuyu.def.db.id.PKJT_SdsGizouKaizanInfo;
import yuyu.def.db.meta.GenQJT_SdsGizouKaizanInfo;
import yuyu.def.db.meta.QJT_SdsGizouKaizanInfo;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_TelkknKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 診断書偽造改竄情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SdsGizouKaizanInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SdsGizouKaizanInfo}</td><td colspan="3">診断書偽造改竄情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SdsGizouKaizanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SdsGizouKaizanInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SdsGizouKaizanInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSindansyogizokaizanumukbn sindansyogizokaizanumukbn}</td><td>診断書偽造改竄有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_NoinitUmuKbn}</td></tr>
 *  <tr><td>{@link #getSindansyogizokaizanjisikbn sindansyogizokaizanjisikbn}</td><td>診断書偽造改竄確認実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TelkknKbn}</td></tr>
 *  <tr><td>{@link #getSindansyogizokaizanriyuu sindansyogizokaizanriyuu}</td><td>診断書偽造改竄理由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SdsGizouKaizanInfo
 * @see     PKJT_SdsGizouKaizanInfo
 * @see     QJT_SdsGizouKaizanInfo
 * @see     GenQJT_SdsGizouKaizanInfo
 */
@MappedSuperclass
@Table(name=GenJT_SdsGizouKaizanInfo.TABLE_NAME)
@IdClass(value=PKJT_SdsGizouKaizanInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_NoinitUmuKbn", typeClass=UserType_C_NoinitUmuKbn.class),
    @TypeDef(name="UserType_C_TelkknKbn", typeClass=UserType_C_TelkknKbn.class)
})
public abstract class GenJT_SdsGizouKaizanInfo extends AbstractExDBEntity<JT_SdsGizouKaizanInfo, PKJT_SdsGizouKaizanInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SdsGizouKaizanInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String SINDANSYOGIZOKAIZANUMUKBN = "sindansyogizokaizanumukbn";
    public static final String SINDANSYOGIZOKAIZANJISIKBN = "sindansyogizokaizanjisikbn";
    public static final String SINDANSYOGIZOKAIZANRIYUU = "sindansyogizokaizanriyuu";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SdsGizouKaizanInfo primaryKey;

    public GenJT_SdsGizouKaizanInfo() {
        primaryKey = new PKJT_SdsGizouKaizanInfo();
    }

    public GenJT_SdsGizouKaizanInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SdsGizouKaizanInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SdsGizouKaizanInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SdsGizouKaizanInfo> getMetaClass() {
        return QJT_SdsGizouKaizanInfo.class;
    }

    @Id
    @Column(name=GenJT_SdsGizouKaizanInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SdsGizouKaizanInfo.SYONO)
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
    @Column(name=GenJT_SdsGizouKaizanInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private C_NoinitUmuKbn sindansyogizokaizanumukbn;

    @Type(type="UserType_C_NoinitUmuKbn")
    @Column(name=GenJT_SdsGizouKaizanInfo.SINDANSYOGIZOKAIZANUMUKBN)
    public C_NoinitUmuKbn getSindansyogizokaizanumukbn() {
        return sindansyogizokaizanumukbn;
    }

    public void setSindansyogizokaizanumukbn(C_NoinitUmuKbn pSindansyogizokaizanumukbn) {
        sindansyogizokaizanumukbn = pSindansyogizokaizanumukbn;
    }

    private C_TelkknKbn sindansyogizokaizanjisikbn;

    @Type(type="UserType_C_TelkknKbn")
    @Column(name=GenJT_SdsGizouKaizanInfo.SINDANSYOGIZOKAIZANJISIKBN)
    public C_TelkknKbn getSindansyogizokaizanjisikbn() {
        return sindansyogizokaizanjisikbn;
    }

    public void setSindansyogizokaizanjisikbn(C_TelkknKbn pSindansyogizokaizanjisikbn) {
        sindansyogizokaizanjisikbn = pSindansyogizokaizanjisikbn;
    }

    private String sindansyogizokaizanriyuu;

    @Column(name=GenJT_SdsGizouKaizanInfo.SINDANSYOGIZOKAIZANRIYUU)
    @MaxLength(max=50)
    @MultiByteStrings
    @InvalidCharacter
    public String getSindansyogizokaizanriyuu() {
        return sindansyogizokaizanriyuu;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSindansyogizokaizanriyuu(String pSindansyogizokaizanriyuu) {
        sindansyogizokaizanriyuu = pSindansyogizokaizanriyuu;
    }

    private String kossyoricd;

    @Column(name=GenJT_SdsGizouKaizanInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SdsGizouKaizanInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SdsGizouKaizanInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SdsGizouKaizanInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}