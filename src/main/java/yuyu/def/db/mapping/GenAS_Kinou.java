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
import yuyu.def.classification.C_BatchKyouseiSyuuryouFlag;
import yuyu.def.classification.C_BatchLogHyoujiKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.id.PKAS_Kinou;
import yuyu.def.db.meta.GenQAS_Kinou;
import yuyu.def.db.meta.QAS_Kinou;
import yuyu.def.db.type.UserType_C_BatchKyouseiSyuuryouFlag;
import yuyu.def.db.type.UserType_C_BatchLogHyoujiKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_KinouKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 機能基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_Kinou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Kinou}</td><td colspan="3">機能基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">{@link PKAS_Kinou ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouNm kinouNm}</td><td>機能名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getKinouKbn kinouKbn}</td><td>機能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KinouKbn}</td></tr>
 *  <tr><td>{@link #getJikkouPath jikkouPath}</td><td>実行パス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouSetumei kinouSetumei}</td><td>機能説明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBatchKyouseiSyuuryouFlag batchKyouseiSyuuryouFlag}</td><td>バッチ強制終了フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchKyouseiSyuuryouFlag}</td></tr>
 *  <tr><td>{@link #getMenuHyoujiKahi menuHyoujiKahi}</td><td>メニュー表示可否</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KahiKbn}</td></tr>
 *  <tr><td>{@link #getBatchLogHyoujiKbn batchLogHyoujiKbn}</td><td>バッチログ表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_BatchLogHyoujiKbn}</td></tr>
 *  <tr><td>{@link #getKidouKengenHanteiYouhiKbn kidouKengenHanteiYouhiKbn}</td><td>起動権限判定要否区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_YouhiKbn}</td></tr>
 *  <tr><td>{@link #getKinouTeigiTaisyouKbn kinouTeigiTaisyouKbn}</td><td>機能定義対象区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TaisyouKbn}</td></tr>
 *  <tr><td>{@link #getSyoricd syoricd}</td><td>処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_Kinou
 * @see     PKAS_Kinou
 * @see     QAS_Kinou
 * @see     GenQAS_Kinou
 */
@MappedSuperclass
@Table(name=GenAS_Kinou.TABLE_NAME)
@IdClass(value=PKAS_Kinou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_BatchKyouseiSyuuryouFlag", typeClass=UserType_C_BatchKyouseiSyuuryouFlag.class),
    @TypeDef(name="UserType_C_BatchLogHyoujiKbn", typeClass=UserType_C_BatchLogHyoujiKbn.class),
    @TypeDef(name="UserType_C_KahiKbn", typeClass=UserType_C_KahiKbn.class),
    @TypeDef(name="UserType_C_KinouKbn", typeClass=UserType_C_KinouKbn.class),
    @TypeDef(name="UserType_C_TaisyouKbn", typeClass=UserType_C_TaisyouKbn.class),
    @TypeDef(name="UserType_C_YouhiKbn", typeClass=UserType_C_YouhiKbn.class)
})
public abstract class GenAS_Kinou extends AbstractExDBEntity<AS_Kinou, PKAS_Kinou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_Kinou";
    public static final String KINOUID                  = "kinouId";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYID               = "categoryId";
    public static final String KINOUNM                  = "kinouNm";
    public static final String SORTNO                   = "sortNo";
    public static final String KINOUKBN                 = "kinouKbn";
    public static final String JIKKOUPATH               = "jikkouPath";
    public static final String KINOUSETUMEI             = "kinouSetumei";
    public static final String BATCHKYOUSEISYUURYOUFLAG = "batchKyouseiSyuuryouFlag";
    public static final String MENUHYOUJIKAHI           = "menuHyoujiKahi";
    public static final String BATCHLOGHYOUJIKBN        = "batchLogHyoujiKbn";
    public static final String KIDOUKENGENHANTEIYOUHIKBN = "kidouKengenHanteiYouhiKbn";
    public static final String KINOUTEIGITAISYOUKBN     = "kinouTeigiTaisyouKbn";
    public static final String SYORICD                  = "syoricd";

    private final PKAS_Kinou primaryKey;

    public GenAS_Kinou() {
        primaryKey = new PKAS_Kinou();
    }

    public GenAS_Kinou(String pKinouId) {
        primaryKey = new PKAS_Kinou(pKinouId);
    }

    @Transient
    @Override
    public PKAS_Kinou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_Kinou> getMetaClass() {
        return QAS_Kinou.class;
    }

    @Id
    @Column(name=GenAS_Kinou.KINOUID)
    public String getKinouId() {
        return getPrimaryKey().getKinouId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        getPrimaryKey().setKinouId(pKinouId);
    }

    private String subSystemId;

    @Column(name=GenAS_Kinou.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    @Column(name=GenAS_Kinou.CATEGORYID)
    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    private String kinouNm;

    @Column(name=GenAS_Kinou.KINOUNM)
    public String getKinouNm() {
        return kinouNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouNm(String pKinouNm) {
        kinouNm = pKinouNm;
    }

    private Integer sortNo;

    @Column(name=GenAS_Kinou.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private C_KinouKbn kinouKbn;

    @Type(type="UserType_C_KinouKbn")
    @Column(name=GenAS_Kinou.KINOUKBN)
    public C_KinouKbn getKinouKbn() {
        return kinouKbn;
    }

    public void setKinouKbn(C_KinouKbn pKinouKbn) {
        kinouKbn = pKinouKbn;
    }

    private String jikkouPath;

    @Column(name=GenAS_Kinou.JIKKOUPATH)
    public String getJikkouPath() {
        return jikkouPath;
    }

    @Trim("both")
    public void setJikkouPath(String pJikkouPath) {
        jikkouPath = pJikkouPath;
    }

    private String kinouSetumei;

    @Column(name=GenAS_Kinou.KINOUSETUMEI)
    public String getKinouSetumei() {
        return kinouSetumei;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setKinouSetumei(String pKinouSetumei) {
        kinouSetumei = pKinouSetumei;
    }

    private C_BatchKyouseiSyuuryouFlag batchKyouseiSyuuryouFlag;

    @Type(type="UserType_C_BatchKyouseiSyuuryouFlag")
    @Column(name=GenAS_Kinou.BATCHKYOUSEISYUURYOUFLAG)
    public C_BatchKyouseiSyuuryouFlag getBatchKyouseiSyuuryouFlag() {
        return batchKyouseiSyuuryouFlag;
    }

    public void setBatchKyouseiSyuuryouFlag(C_BatchKyouseiSyuuryouFlag pBatchKyouseiSyuuryouFlag) {
        batchKyouseiSyuuryouFlag = pBatchKyouseiSyuuryouFlag;
    }

    private C_KahiKbn menuHyoujiKahi;

    @Type(type="UserType_C_KahiKbn")
    @Column(name=GenAS_Kinou.MENUHYOUJIKAHI)
    public C_KahiKbn getMenuHyoujiKahi() {
        return menuHyoujiKahi;
    }

    public void setMenuHyoujiKahi(C_KahiKbn pMenuHyoujiKahi) {
        menuHyoujiKahi = pMenuHyoujiKahi;
    }

    private C_BatchLogHyoujiKbn batchLogHyoujiKbn;

    @Type(type="UserType_C_BatchLogHyoujiKbn")
    @Column(name=GenAS_Kinou.BATCHLOGHYOUJIKBN)
    public C_BatchLogHyoujiKbn getBatchLogHyoujiKbn() {
        return batchLogHyoujiKbn;
    }

    public void setBatchLogHyoujiKbn(C_BatchLogHyoujiKbn pBatchLogHyoujiKbn) {
        batchLogHyoujiKbn = pBatchLogHyoujiKbn;
    }

    private C_YouhiKbn kidouKengenHanteiYouhiKbn;

    @Type(type="UserType_C_YouhiKbn")
    @Column(name=GenAS_Kinou.KIDOUKENGENHANTEIYOUHIKBN)
    public C_YouhiKbn getKidouKengenHanteiYouhiKbn() {
        return kidouKengenHanteiYouhiKbn;
    }

    public void setKidouKengenHanteiYouhiKbn(C_YouhiKbn pKidouKengenHanteiYouhiKbn) {
        kidouKengenHanteiYouhiKbn = pKidouKengenHanteiYouhiKbn;
    }

    private C_TaisyouKbn kinouTeigiTaisyouKbn;

    @Type(type="UserType_C_TaisyouKbn")
    @Column(name=GenAS_Kinou.KINOUTEIGITAISYOUKBN)
    public C_TaisyouKbn getKinouTeigiTaisyouKbn() {
        return kinouTeigiTaisyouKbn;
    }

    public void setKinouTeigiTaisyouKbn(C_TaisyouKbn pKinouTeigiTaisyouKbn) {
        kinouTeigiTaisyouKbn = pKinouTeigiTaisyouKbn;
    }

    private String syoricd;

    @Column(name=GenAS_Kinou.SYORICD)
    public String getSyoricd() {
        return syoricd;
    }

    public void setSyoricd(String pSyoricd) {
        syoricd = pSyoricd;
    }
}
