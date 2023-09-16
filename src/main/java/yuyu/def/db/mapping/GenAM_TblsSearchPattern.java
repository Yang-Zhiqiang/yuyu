package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.AM_TblsSearchPattern;
import yuyu.def.db.id.PKAM_TblsSearchPattern;
import yuyu.def.db.meta.GenQAM_TblsSearchPattern;
import yuyu.def.db.meta.QAM_TblsSearchPattern;

/**
 * テーブル照会検索パターンマスタ テーブルのマッピング情報クラスで、 {@link AM_TblsSearchPattern} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsSearchPattern}</td><td colspan="3">テーブル照会検索パターンマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">{@link PKAM_TblsSearchPattern ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBaseSearchDdId baseSearchDdId}</td><td>（ベース）検索項目ID</td><td align="center">{@link PKAM_TblsSearchPattern ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBaseSearchPtnNm baseSearchPtnNm}</td><td>（ベース）検索パターン名</td><td align="center">{@link PKAM_TblsSearchPattern ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSortNo sortNo}</td><td>ソート番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AM_TblsSearchPattern
 * @see     PKAM_TblsSearchPattern
 * @see     QAM_TblsSearchPattern
 * @see     GenQAM_TblsSearchPattern
 */
@MappedSuperclass
@Table(name=GenAM_TblsSearchPattern.TABLE_NAME)
@IdClass(value=PKAM_TblsSearchPattern.class)
public abstract class GenAM_TblsSearchPattern extends AbstractExDBEntity<AM_TblsSearchPattern, PKAM_TblsSearchPattern> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AM_TblsSearchPattern";
    public static final String BASETABLEID              = "baseTableId";
    public static final String BASESEARCHDDID           = "baseSearchDdId";
    public static final String BASESEARCHPTNNM          = "baseSearchPtnNm";
    public static final String SORTNO                   = "sortNo";

    private final PKAM_TblsSearchPattern primaryKey;

    public GenAM_TblsSearchPattern() {
        primaryKey = new PKAM_TblsSearchPattern();
    }

    public GenAM_TblsSearchPattern(
        String pBaseTableId,
        String pBaseSearchDdId,
        String pBaseSearchPtnNm
    ) {
        primaryKey = new PKAM_TblsSearchPattern(
            pBaseTableId,
            pBaseSearchDdId,
            pBaseSearchPtnNm
        );
    }

    @Transient
    @Override
    public PKAM_TblsSearchPattern getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAM_TblsSearchPattern> getMetaClass() {
        return QAM_TblsSearchPattern.class;
    }

    @Id
    @Column(name=GenAM_TblsSearchPattern.BASETABLEID)
    @SingleByteStrings
    public String getBaseTableId() {
        return getPrimaryKey().getBaseTableId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseTableId(String pBaseTableId) {
        getPrimaryKey().setBaseTableId(pBaseTableId);
    }

    @Id
    @Column(name=GenAM_TblsSearchPattern.BASESEARCHDDID)
    public String getBaseSearchDdId() {
        return getPrimaryKey().getBaseSearchDdId();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBaseSearchDdId(String pBaseSearchDdId) {
        getPrimaryKey().setBaseSearchDdId(pBaseSearchDdId);
    }

    @Id
    @Column(name=GenAM_TblsSearchPattern.BASESEARCHPTNNM)
    public String getBaseSearchPtnNm() {
        return getPrimaryKey().getBaseSearchPtnNm();
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setBaseSearchPtnNm(String pBaseSearchPtnNm) {
        getPrimaryKey().setBaseSearchPtnNm(pBaseSearchPtnNm);
    }

    private Integer sortNo;

    @Column(name=GenAM_TblsSearchPattern.SORTNO)
    public Integer getSortNo() {
        return sortNo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSortNo(Integer pSortNo) {
        sortNo = pSortNo;
    }
}