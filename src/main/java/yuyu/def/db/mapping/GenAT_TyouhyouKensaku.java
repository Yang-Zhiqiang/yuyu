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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.id.PKAT_TyouhyouKensaku;
import yuyu.def.db.meta.GenQAT_TyouhyouKensaku;
import yuyu.def.db.meta.QAT_TyouhyouKensaku;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 帳票検索テーブル テーブルのマッピング情報クラスで、 {@link AT_TyouhyouKensaku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_TyouhyouKensaku}</td><td colspan="3">帳票検索テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getUniqueId uniqueId}</td><td>ユニークＩＤ</td><td align="center">{@link PKAT_TyouhyouKensaku ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getReportKey reportKey}</td><td>帳票キー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey1 kensakuKey1}</td><td>検索キー１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey2 kensakuKey2}</td><td>検索キー２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey3 kensakuKey3}</td><td>検索キー３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey4 kensakuKey4}</td><td>検索キー４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKensakuKey5 kensakuKey5}</td><td>検索キー５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getFirstOutYmd firstOutYmd}</td><td>初回出力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getLastOutYmd lastOutYmd}</td><td>最終出力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getOutCount outCount}</td><td>出力回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLastOutUserId lastOutUserId}</td><td>最終出力ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiKetugouUmuKbn syoruiKetugouUmuKbn}</td><td>書類結合有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getFileSize fileSize}</td><td>ファイルサイズ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getPageCount pageCount}</td><td>ページ数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AT_TyouhyouKensaku
 * @see     PKAT_TyouhyouKensaku
 * @see     QAT_TyouhyouKensaku
 * @see     GenQAT_TyouhyouKensaku
 */
@MappedSuperclass
@Table(name=GenAT_TyouhyouKensaku.TABLE_NAME)
@IdClass(value=PKAT_TyouhyouKensaku.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenAT_TyouhyouKensaku extends AbstractExDBEntity<AT_TyouhyouKensaku, PKAT_TyouhyouKensaku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_TyouhyouKensaku";
    public static final String UNIQUEID                 = "uniqueId";
    public static final String REPORTKEY                = "reportKey";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYID               = "categoryId";
    public static final String KINOUID                  = "kinouId";
    public static final String KENSAKUKEY1              = "kensakuKey1";
    public static final String KENSAKUKEY2              = "kensakuKey2";
    public static final String KENSAKUKEY3              = "kensakuKey3";
    public static final String KENSAKUKEY4              = "kensakuKey4";
    public static final String KENSAKUKEY5              = "kensakuKey5";
    public static final String SYORIYMD                 = "syoriYmd";
    public static final String FIRSTOUTYMD              = "firstOutYmd";
    public static final String LASTOUTYMD               = "lastOutYmd";
    public static final String OUTCOUNT                 = "outCount";
    public static final String LASTOUTUSERID            = "lastOutUserId";
    public static final String SYORUIKETUGOUUMUKBN      = "syoruiKetugouUmuKbn";
    public static final String FILESIZE                 = "fileSize";
    public static final String PAGECOUNT                = "pageCount";

    private final PKAT_TyouhyouKensaku primaryKey;

    public GenAT_TyouhyouKensaku() {
        primaryKey = new PKAT_TyouhyouKensaku();
    }

    public GenAT_TyouhyouKensaku(String pUniqueId) {
        primaryKey = new PKAT_TyouhyouKensaku(pUniqueId);
    }

    @Transient
    @Override
    public PKAT_TyouhyouKensaku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_TyouhyouKensaku> getMetaClass() {
        return QAT_TyouhyouKensaku.class;
    }

    @Id
    @Column(name=GenAT_TyouhyouKensaku.UNIQUEID)
    public String getUniqueId() {
        return getPrimaryKey().getUniqueId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        getPrimaryKey().setUniqueId(pUniqueId);
    }

    private String reportKey;

    @Column(name=GenAT_TyouhyouKensaku.REPORTKEY)
    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenAT_TyouhyouKensaku.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String subSystemId;

    @Column(name=GenAT_TyouhyouKensaku.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryId;

    @Column(name=GenAT_TyouhyouKensaku.CATEGORYID)
    public String getCategoryId() {
        return categoryId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        categoryId = pCategoryId;
    }

    private String kinouId;

    @Column(name=GenAT_TyouhyouKensaku.KINOUID)
    public String getKinouId() {
        return kinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }

    private String kensakuKey1;

    @Column(name=GenAT_TyouhyouKensaku.KENSAKUKEY1)
    public String getKensakuKey1() {
        return kensakuKey1;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey1(String pKensakuKey1) {
        kensakuKey1 = pKensakuKey1;
    }

    private String kensakuKey2;

    @Column(name=GenAT_TyouhyouKensaku.KENSAKUKEY2)
    public String getKensakuKey2() {
        return kensakuKey2;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey2(String pKensakuKey2) {
        kensakuKey2 = pKensakuKey2;
    }

    private String kensakuKey3;

    @Column(name=GenAT_TyouhyouKensaku.KENSAKUKEY3)
    public String getKensakuKey3() {
        return kensakuKey3;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey3(String pKensakuKey3) {
        kensakuKey3 = pKensakuKey3;
    }

    private String kensakuKey4;

    @Column(name=GenAT_TyouhyouKensaku.KENSAKUKEY4)
    public String getKensakuKey4() {
        return kensakuKey4;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey4(String pKensakuKey4) {
        kensakuKey4 = pKensakuKey4;
    }

    private String kensakuKey5;

    @Column(name=GenAT_TyouhyouKensaku.KENSAKUKEY5)
    public String getKensakuKey5() {
        return kensakuKey5;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKensakuKey5(String pKensakuKey5) {
        kensakuKey5 = pKensakuKey5;
    }

    private BizDate syoriYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_TyouhyouKensaku.SYORIYMD)
    @ValidDate
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

    private BizDate firstOutYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_TyouhyouKensaku.FIRSTOUTYMD)
    @ValidDate
    public BizDate getFirstOutYmd() {
        return firstOutYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFirstOutYmd(BizDate pFirstOutYmd) {
        firstOutYmd = pFirstOutYmd;
    }

    private BizDate lastOutYmd;

    @Type(type="BizDateType")
    @Column(name=GenAT_TyouhyouKensaku.LASTOUTYMD)
    @ValidDate
    public BizDate getLastOutYmd() {
        return lastOutYmd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLastOutYmd(BizDate pLastOutYmd) {
        lastOutYmd = pLastOutYmd;
    }

    private Integer outCount;

    @Column(name=GenAT_TyouhyouKensaku.OUTCOUNT)
    public Integer getOutCount() {
        return outCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOutCount(Integer pOutCount) {
        outCount = pOutCount;
    }

    private String lastOutUserId;

    @Column(name=GenAT_TyouhyouKensaku.LASTOUTUSERID)
    public String getLastOutUserId() {
        return lastOutUserId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setLastOutUserId(String pLastOutUserId) {
        lastOutUserId = pLastOutUserId;
    }

    private C_UmuKbn syoruiKetugouUmuKbn;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenAT_TyouhyouKensaku.SYORUIKETUGOUUMUKBN)
    public C_UmuKbn getSyoruiKetugouUmuKbn() {
        return syoruiKetugouUmuKbn;
    }

    public void setSyoruiKetugouUmuKbn(C_UmuKbn pSyoruiKetugouUmuKbn) {
        syoruiKetugouUmuKbn = pSyoruiKetugouUmuKbn;
    }

    private Long fileSize;

    @Column(name=GenAT_TyouhyouKensaku.FILESIZE)
    public Long getFileSize() {
        return fileSize;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setFileSize(Long pFileSize) {
        fileSize = pFileSize;
    }

    private Integer pageCount;

    @Column(name=GenAT_TyouhyouKensaku.PAGECOUNT)
    public Integer getPageCount() {
        return pageCount;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPageCount(Integer pPageCount) {
        pageCount = pPageCount;
    }
}