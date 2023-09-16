package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.id.PKAS_Category;
import yuyu.def.db.meta.GenQAS_Category;
import yuyu.def.db.meta.QAS_Category;

/**
 * カテゴリ基幹テーブル テーブルのマッピング情報クラスで、 {@link AS_Category} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_Category}</td><td colspan="3">カテゴリ基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getCategoryId categoryId}</td><td>カテゴリＩＤ</td><td align="center">{@link PKAS_Category ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getCategoryNm categoryNm}</td><td>カテゴリ名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getLinkImage linkImage}</td><td>リンクイメージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTitleStyle titleStyle}</td><td>タイトルスタイル</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AS_Category
 * @see     PKAS_Category
 * @see     QAS_Category
 * @see     GenQAS_Category
 */
@MappedSuperclass
@Table(name=GenAS_Category.TABLE_NAME)
@IdClass(value=PKAS_Category.class)
public abstract class GenAS_Category extends AbstractExDBEntity<AS_Category, PKAS_Category> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AS_Category";
    public static final String CATEGORYID               = "categoryId";
    public static final String SUBSYSTEMID              = "subSystemId";
    public static final String CATEGORYNM               = "categoryNm";
    public static final String SORTNO                   = "sortNo";
    public static final String LINKIMAGE                = "linkImage";
    public static final String TITLESTYLE               = "titleStyle";

    private final PKAS_Category primaryKey;

    public GenAS_Category() {
        primaryKey = new PKAS_Category();
    }

    public GenAS_Category(String pCategoryId) {
        primaryKey = new PKAS_Category(pCategoryId);
    }

    @Transient
    @Override
    public PKAS_Category getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAS_Category> getMetaClass() {
        return QAS_Category.class;
    }

    @Id
    @Column(name=GenAS_Category.CATEGORYID)
    public String getCategoryId() {
        return getPrimaryKey().getCategoryId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCategoryId(String pCategoryId) {
        getPrimaryKey().setCategoryId(pCategoryId);
    }

    private String subSystemId;

    @Column(name=GenAS_Category.SUBSYSTEMID)
    public String getSubSystemId() {
        return subSystemId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

    private String categoryNm;

    @Column(name=GenAS_Category.CATEGORYNM)
    public String getCategoryNm() {
        return categoryNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setCategoryNm(String pCategoryNm) {
        categoryNm = pCategoryNm;
    }

    private Integer sortNo;

    @Column(name=GenAS_Category.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }

    private String linkImage;

    @Column(name=GenAS_Category.LINKIMAGE)
    public String getLinkImage() {
        return linkImage;
    }

    @Trim("both")
    public void setLinkImage(String pLinkImage) {
        linkImage = pLinkImage;
    }

    private String titleStyle;

    @Column(name=GenAS_Category.TITLESTYLE)
    public String getTitleStyle() {
        return titleStyle;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTitleStyle(String pTitleStyle) {
        titleStyle = pTitleStyle;
    }
}
