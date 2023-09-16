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
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.id.PKJT_SateiKaijyoInfo;
import yuyu.def.db.meta.GenQJT_SateiKaijyoInfo;
import yuyu.def.db.meta.QJT_SateiKaijyoInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定解除情報テーブル テーブルのマッピング情報クラスで、 {@link JT_SateiKaijyoInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiKaijyoInfo}</td><td colspan="3">査定解除情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_SateiKaijyoInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_SateiKaijyoInfo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">{@link PKJT_SateiKaijyoInfo ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKaijokigenymd kaijokigenymd}</td><td>解除期限日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getKossyoricd kossyoricd}</td><td>更新処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKossyorisscd kossyorisscd}</td><td>更新処理詳細コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiKaijyoInfo
 * @see     PKJT_SateiKaijyoInfo
 * @see     QJT_SateiKaijyoInfo
 * @see     GenQJT_SateiKaijyoInfo
 */
@MappedSuperclass
@Table(name=GenJT_SateiKaijyoInfo.TABLE_NAME)
@IdClass(value=PKJT_SateiKaijyoInfo.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenJT_SateiKaijyoInfo extends AbstractExDBEntity<JT_SateiKaijyoInfo, PKJT_SateiKaijyoInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_SateiKaijyoInfo";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String SEIKYUURIREKINO          = "seikyuurirekino";
    public static final String KAIJOKIGENYMD            = "kaijokigenymd";
    public static final String KOSSYORICD               = "kossyoricd";
    public static final String KOSSYORISSCD             = "kossyorisscd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_SateiKaijyoInfo primaryKey;

    public GenJT_SateiKaijyoInfo() {
        primaryKey = new PKJT_SateiKaijyoInfo();
    }

    public GenJT_SateiKaijyoInfo(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino
    ) {
        primaryKey = new PKJT_SateiKaijyoInfo(
            pSkno,
            pSyono,
            pSeikyuurirekino
        );
    }

    @Transient
    @Override
    public PKJT_SateiKaijyoInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_SateiKaijyoInfo> getMetaClass() {
        return QJT_SateiKaijyoInfo.class;
    }

    @Id
    @Column(name=GenJT_SateiKaijyoInfo.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_SateiKaijyoInfo.SYONO)
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
    @Column(name=GenJT_SateiKaijyoInfo.SEIKYUURIREKINO)
    public Integer getSeikyuurirekino() {
        return getPrimaryKey().getSeikyuurirekino();
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        getPrimaryKey().setSeikyuurirekino(pSeikyuurirekino);
    }

    private BizDate kaijokigenymd;

    @Type(type="BizDateType")
    @Column(name=GenJT_SateiKaijyoInfo.KAIJOKIGENYMD)
    @ValidDate
    public BizDate getKaijokigenymd() {
        return kaijokigenymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKaijokigenymd(BizDate pKaijokigenymd) {
        kaijokigenymd = pKaijokigenymd;
    }

    private String kossyoricd;

    @Column(name=GenJT_SateiKaijyoInfo.KOSSYORICD)
    public String getKossyoricd() {
        return kossyoricd;
    }

    public void setKossyoricd(String pKossyoricd) {
        kossyoricd = pKossyoricd;
    }

    private String kossyorisscd;

    @Column(name=GenJT_SateiKaijyoInfo.KOSSYORISSCD)
    public String getKossyorisscd() {
        return kossyorisscd;
    }

    public void setKossyorisscd(String pKossyorisscd) {
        kossyorisscd = pKossyorisscd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_SateiKaijyoInfo.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_SateiKaijyoInfo.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}