package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_ImagegazoukaKbn;
import yuyu.def.classification.C_KouteiSakuseiKeikiKbn;
import yuyu.def.classification.C_QrCodeTaikeiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SyoruiTorikomiHouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.id.PKBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.GenQBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.meta.QBM_TorikomiSyoruiHukaInfo;
import yuyu.def.db.type.UserType_C_ImagegazoukaKbn;
import yuyu.def.db.type.UserType_C_KouteiSakuseiKeikiKbn;
import yuyu.def.db.type.UserType_C_QrCodeTaikeiKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_SyoruiTorikomiHouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 取込書類付加情報マスタ テーブルのマッピング情報クラスで、 {@link BM_TorikomiSyoruiHukaInfo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_TorikomiSyoruiHukaInfo}</td><td colspan="3">取込書類付加情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">{@link PKBM_TorikomiSyoruiHukaInfo ○}</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruitorikomihoukbn syoruitorikomihoukbn}</td><td>書類取込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiTorikomiHouKbn}</td></tr>
 *  <tr><td>{@link #getKouteisakuseikeiki kouteisakuseikeiki}</td><td>工程作成契機</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KouteiSakuseiKeikiKbn}</td></tr>
 *  <tr><td>{@link #getQrcodetaikeikbn qrcodetaikeikbn}</td><td>QRコード体系区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_QrCodeTaikeiKbn}</td></tr>
 *  <tr><td>{@link #getTtykknryouhi ttykknryouhi}</td><td>到着予定管理要否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getHozonKikan hozonKikan}</td><td>保存期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSkeijimukbn skeijimukbn}</td><td>新契約事務区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SkeijimuKbn}</td></tr>
 *  <tr><td>{@link #getQrsealumukbn qrsealumukbn}</td><td>QRシール用紙有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getImagegazoukakbn imagegazoukakbn}</td><td>イメージ画像化区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_ImagegazoukaKbn}</td></tr>
 * </table>
 * @see     BM_TorikomiSyoruiHukaInfo
 * @see     PKBM_TorikomiSyoruiHukaInfo
 * @see     QBM_TorikomiSyoruiHukaInfo
 * @see     GenQBM_TorikomiSyoruiHukaInfo
 */
@MappedSuperclass
@Table(name=GenBM_TorikomiSyoruiHukaInfo.TABLE_NAME)
@IdClass(value=PKBM_TorikomiSyoruiHukaInfo.class)
@TypeDefs({
    @TypeDef(name="UserType_C_ImagegazoukaKbn", typeClass=UserType_C_ImagegazoukaKbn.class),
    @TypeDef(name="UserType_C_KouteiSakuseiKeikiKbn", typeClass=UserType_C_KouteiSakuseiKeikiKbn.class),
    @TypeDef(name="UserType_C_QrCodeTaikeiKbn", typeClass=UserType_C_QrCodeTaikeiKbn.class),
    @TypeDef(name="UserType_C_SkeijimuKbn", typeClass=UserType_C_SkeijimuKbn.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_SyoruiTorikomiHouKbn", typeClass=UserType_C_SyoruiTorikomiHouKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenBM_TorikomiSyoruiHukaInfo extends AbstractExDBEntity<BM_TorikomiSyoruiHukaInfo, PKBM_TorikomiSyoruiHukaInfo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_TorikomiSyoruiHukaInfo";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String SYORUITORIKOMIHOUKBN     = "syoruitorikomihoukbn";
    public static final String KOUTEISAKUSEIKEIKI       = "kouteisakuseikeiki";
    public static final String QRCODETAIKEIKBN          = "qrcodetaikeikbn";
    public static final String TTYKKNRYOUHI             = "ttykknryouhi";
    public static final String HOZONKIKAN               = "hozonKikan";
    public static final String SORTNO                   = "sortNo";
    public static final String SKEIJIMUKBN              = "skeijimukbn";
    public static final String QRSEALUMUKBN             = "qrsealumukbn";
    public static final String IMAGEGAZOUKAKBN          = "imagegazoukakbn";

    private final PKBM_TorikomiSyoruiHukaInfo primaryKey;

    public GenBM_TorikomiSyoruiHukaInfo() {
        primaryKey = new PKBM_TorikomiSyoruiHukaInfo();
    }

    public GenBM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        primaryKey = new PKBM_TorikomiSyoruiHukaInfo(pSyoruiCd);
    }

    @Transient
    @Override
    public PKBM_TorikomiSyoruiHukaInfo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_TorikomiSyoruiHukaInfo> getMetaClass() {
        return QBM_TorikomiSyoruiHukaInfo.class;
    }

    @Id
    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return getPrimaryKey().getSyoruiCd();
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        getPrimaryKey().setSyoruiCd(pSyoruiCd);
    }

    private String subSystemId;

    @Column(name=GenBM_TorikomiSyoruiHukaInfo.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private C_SyoruiTorikomiHouKbn syoruitorikomihoukbn;

    @Type(type="UserType_C_SyoruiTorikomiHouKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.SYORUITORIKOMIHOUKBN)
    public C_SyoruiTorikomiHouKbn getSyoruitorikomihoukbn() {
        return syoruitorikomihoukbn;
    }

    public void setSyoruitorikomihoukbn(C_SyoruiTorikomiHouKbn pSyoruitorikomihoukbn) {
        syoruitorikomihoukbn = pSyoruitorikomihoukbn;
    }

    private C_KouteiSakuseiKeikiKbn kouteisakuseikeiki;

    @Type(type="UserType_C_KouteiSakuseiKeikiKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.KOUTEISAKUSEIKEIKI)
    public C_KouteiSakuseiKeikiKbn getKouteisakuseikeiki() {
        return kouteisakuseikeiki;
    }

    public void setKouteisakuseikeiki(C_KouteiSakuseiKeikiKbn pKouteisakuseikeiki) {
        kouteisakuseikeiki = pKouteisakuseikeiki;
    }

    private C_QrCodeTaikeiKbn qrcodetaikeikbn;

    @Type(type="UserType_C_QrCodeTaikeiKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.QRCODETAIKEIKBN)
    public C_QrCodeTaikeiKbn getQrcodetaikeikbn() {
        return qrcodetaikeikbn;
    }

    public void setQrcodetaikeikbn(C_QrCodeTaikeiKbn pQrcodetaikeikbn) {
        qrcodetaikeikbn = pQrcodetaikeikbn;
    }

    private C_YouhiKbn ttykknryouhi;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.TTYKKNRYOUHI)
    public C_YouhiKbn getTtykknryouhi() {
        return ttykknryouhi;
    }

    public void setTtykknryouhi(C_YouhiKbn pTtykknryouhi) {
        ttykknryouhi = pTtykknryouhi;
    }

    private Integer hozonKikan;

    @Column(name=GenBM_TorikomiSyoruiHukaInfo.HOZONKIKAN)
    public Integer getHozonKikan() {
        return hozonKikan;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHozonKikan(Integer pHozonKikan) {
        hozonKikan = pHozonKikan;
    }

    private Integer sortNo;

    @Column(name=GenBM_TorikomiSyoruiHukaInfo.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private C_SkeijimuKbn skeijimukbn;

    @Type(type="UserType_C_SkeijimuKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.SKEIJIMUKBN)
    public C_SkeijimuKbn getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_UmuKbn qrsealumukbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.QRSEALUMUKBN)
    public C_UmuKbn getQrsealumukbn() {
        return qrsealumukbn;
    }

    public void setQrsealumukbn(C_UmuKbn pQrsealumukbn) {
        qrsealumukbn = pQrsealumukbn;
    }

    private C_ImagegazoukaKbn imagegazoukakbn;

    @Type(type="UserType_C_ImagegazoukaKbn")
    @Column(name=GenBM_TorikomiSyoruiHukaInfo.IMAGEGAZOUKAKBN)
    public C_ImagegazoukaKbn getImagegazoukakbn() {
        return imagegazoukakbn;
    }

    public void setImagegazoukakbn(C_ImagegazoukaKbn pImagegazoukakbn) {
        imagegazoukakbn = pImagegazoukakbn;
    }
}