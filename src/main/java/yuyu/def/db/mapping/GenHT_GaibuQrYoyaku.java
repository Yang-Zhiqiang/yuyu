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
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku;
import yuyu.def.db.id.PKHT_GaibuQrYoyaku;
import yuyu.def.db.meta.GenQHT_GaibuQrYoyaku;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;

/**
 * 外部用ＱＲ予約テーブル テーブルのマッピング情報クラスで、 {@link HT_GaibuQrYoyaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GaibuQrYoyaku}</td><td colspan="3">外部用ＱＲ予約テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_GaibuQrYoyaku ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">{@link PKHT_GaibuQrYoyaku ○}</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">{@link PKHT_GaibuQrYoyaku ○}</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getSakuseikensuu sakuseikensuu}</td><td>作成件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getQrsakuseiymd qrsakuseiymd}</td><td>ＱＲ作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GaibuQrYoyaku
 * @see     PKHT_GaibuQrYoyaku
 * @see     QHT_GaibuQrYoyaku
 * @see     GenQHT_GaibuQrYoyaku
 */
@MappedSuperclass
@Table(name=GenHT_GaibuQrYoyaku.TABLE_NAME)
@IdClass(value=PKHT_GaibuQrYoyaku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class)
})
public abstract class GenHT_GaibuQrYoyaku extends AbstractExDBEntity<HT_GaibuQrYoyaku, PKHT_GaibuQrYoyaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_GaibuQrYoyaku";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String SAKUSEIKENSUU            = "sakuseikensuu";
    public static final String QRSAKUSEIYMD             = "qrsakuseiymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_GaibuQrYoyaku primaryKey;

    public GenHT_GaibuQrYoyaku() {
        primaryKey = new PKHT_GaibuQrYoyaku();
    }

    public GenHT_GaibuQrYoyaku(
        BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino
    ) {
        primaryKey = new PKHT_GaibuQrYoyaku(
            pSyoriYmd,
            pSkeijimukbn,
            pHknsyuruino
        );
    }

    @Transient
    @Override
    public PKHT_GaibuQrYoyaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_GaibuQrYoyaku> getMetaClass() {
        return QHT_GaibuQrYoyaku.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_GaibuQrYoyaku.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return getPrimaryKey().getSyoriYmd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        getPrimaryKey().setSyoriYmd(pSyoriYmd);
    }

    @Id
    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenHT_GaibuQrYoyaku.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return getPrimaryKey().getSkeijimukbn();
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        getPrimaryKey().setSkeijimukbn(pSkeijimukbn);
    }

    @Id
    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_GaibuQrYoyaku.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return getPrimaryKey().getHknsyuruino();
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        getPrimaryKey().setHknsyuruino(pHknsyuruino);
    }

    private Integer sakuseikensuu;

    @Column(name=GenHT_GaibuQrYoyaku.SAKUSEIKENSUU)
    @Range(min="0", max="99999")
    public Integer getSakuseikensuu() {
        return sakuseikensuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSakuseikensuu(Integer pSakuseikensuu) {
        sakuseikensuu = pSakuseikensuu;
    }

    private BizDate qrsakuseiymd;

    @Type(type="BizDateType")
    @Column(name=GenHT_GaibuQrYoyaku.QRSAKUSEIYMD)
    public BizDate getQrsakuseiymd() {
        return qrsakuseiymd;
    }

    public void setQrsakuseiymd(BizDate pQrsakuseiymd) {
        qrsakuseiymd = pQrsakuseiymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_GaibuQrYoyaku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_GaibuQrYoyaku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}