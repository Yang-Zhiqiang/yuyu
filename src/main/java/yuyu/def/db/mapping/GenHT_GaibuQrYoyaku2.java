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
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.id.PKHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.GenQHT_GaibuQrYoyaku2;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku2;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_MosnoSaibanKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;

/**
 * 外部用ＱＲ予約テーブル２ テーブルのマッピング情報クラスで、 {@link HT_GaibuQrYoyaku2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_GaibuQrYoyaku2}</td><td colspan="3">外部用ＱＲ予約テーブル２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">{@link PKHT_GaibuQrYoyaku2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">{@link PKHT_GaibuQrYoyaku2 ○}</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getHknsyuruino hknsyuruino}</td><td>保険種類番号</td><td align="center">{@link PKHT_GaibuQrYoyaku2 ○}</td><td align="center">V</td><td>{@link C_HknsyuruiNo}</td></tr>
 *  <tr><td>{@link #getMosnosaibankbn mosnosaibankbn}</td><td>申込番号採番区分</td><td align="center">{@link PKHT_GaibuQrYoyaku2 ○}</td><td align="center">V</td><td>{@link C_MosnoSaibanKbn}</td></tr>
 *  <tr><td>{@link #getMosnosaibansuu mosnosaibansuu}</td><td>申込番号採番数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSakuseikensuu sakuseikensuu}</td><td>作成件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getQrsakuseiymd qrsakuseiymd}</td><td>ＱＲ作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_GaibuQrYoyaku2
 * @see     PKHT_GaibuQrYoyaku2
 * @see     QHT_GaibuQrYoyaku2
 * @see     GenQHT_GaibuQrYoyaku2
 */
@MappedSuperclass
@Table(name=GenHT_GaibuQrYoyaku2.TABLE_NAME)
@IdClass(value=PKHT_GaibuQrYoyaku2.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_HknsyuruiNo", typeClass=UserType_C_HknsyuruiNo.class),
    @TypeDef(name="UserType_C_MosnoSaibanKbn", typeClass=UserType_C_MosnoSaibanKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class)
})
public abstract class GenHT_GaibuQrYoyaku2 extends AbstractExDBEntity<HT_GaibuQrYoyaku2, PKHT_GaibuQrYoyaku2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_GaibuQrYoyaku2";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String HKNSYURUINO              = "hknsyuruino";
    public static final String MOSNOSAIBANKBN           = "mosnosaibankbn";
    public static final String MOSNOSAIBANSUU           = "mosnosaibansuu";
    public static final String SAKUSEIKENSUU            = "sakuseikensuu";
    public static final String QRSAKUSEIYMD             = "qrsakuseiymd";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_GaibuQrYoyaku2 primaryKey;

    public GenHT_GaibuQrYoyaku2() {
        primaryKey = new PKHT_GaibuQrYoyaku2();
    }

    public GenHT_GaibuQrYoyaku2(
        BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino,
        C_MosnoSaibanKbn pMosnosaibankbn
    ) {
        primaryKey = new PKHT_GaibuQrYoyaku2(
            pSyoriYmd,
            pSkeijimukbn,
            pHknsyuruino,
            pMosnosaibankbn
        );
    }

    @Transient
    @Override
    public PKHT_GaibuQrYoyaku2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_GaibuQrYoyaku2> getMetaClass() {
        return QHT_GaibuQrYoyaku2.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_GaibuQrYoyaku2.SYORIYMD)
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
    @Column(name=GenHT_GaibuQrYoyaku2.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return getPrimaryKey().getSkeijimukbn();
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        getPrimaryKey().setSkeijimukbn(pSkeijimukbn);
    }

    @Id
    @Type(type="UserType_C_HknsyuruiNo")
    @Column(name=GenHT_GaibuQrYoyaku2.HKNSYURUINO)
    public C_HknsyuruiNo getHknsyuruino() {
        return getPrimaryKey().getHknsyuruino();
    }

    public void setHknsyuruino(C_HknsyuruiNo pHknsyuruino) {
        getPrimaryKey().setHknsyuruino(pHknsyuruino);
    }

    @Id
    @Type(type="UserType_C_MosnoSaibanKbn")
    @Column(name=GenHT_GaibuQrYoyaku2.MOSNOSAIBANKBN)
    public C_MosnoSaibanKbn getMosnosaibankbn() {
        return getPrimaryKey().getMosnosaibankbn();
    }

    public void setMosnosaibankbn(C_MosnoSaibanKbn pMosnosaibankbn) {
        getPrimaryKey().setMosnosaibankbn(pMosnosaibankbn);
    }

    private Integer mosnosaibansuu;

    @Column(name=GenHT_GaibuQrYoyaku2.MOSNOSAIBANSUU)
    public Integer getMosnosaibansuu() {
        return mosnosaibansuu;
    }

    public void setMosnosaibansuu(Integer pMosnosaibansuu) {
        mosnosaibansuu = pMosnosaibansuu;
    }

    private Integer sakuseikensuu;

    @Column(name=GenHT_GaibuQrYoyaku2.SAKUSEIKENSUU)
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
    @Column(name=GenHT_GaibuQrYoyaku2.QRSAKUSEIYMD)
    public BizDate getQrsakuseiymd() {
        return qrsakuseiymd;
    }

    public void setQrsakuseiymd(BizDate pQrsakuseiymd) {
        qrsakuseiymd = pQrsakuseiymd;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_GaibuQrYoyaku2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_GaibuQrYoyaku2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}