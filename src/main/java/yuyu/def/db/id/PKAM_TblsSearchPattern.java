package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.AM_TblsSearchPattern;
import yuyu.def.db.mapping.GenAM_TblsSearchPattern;
import yuyu.def.db.meta.GenQAM_TblsSearchPattern;
import yuyu.def.db.meta.QAM_TblsSearchPattern;

/**
 * テーブル照会検索パターンマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_TblsSearchPattern}</td><td colspan="3">テーブル照会検索パターンマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseTableId baseTableId}</td><td>（ベース）テーブルID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseSearchDdId baseSearchDdId}</td><td>（ベース）検索項目ID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBaseSearchPtnNm baseSearchPtnNm}</td><td>（ベース）検索パターン名</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sortNo</td><td>ソート番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     AM_TblsSearchPattern
 * @see     GenAM_TblsSearchPattern
 * @see     QAM_TblsSearchPattern
 * @see     GenQAM_TblsSearchPattern
 */
public class PKAM_TblsSearchPattern extends AbstractExDBPrimaryKey<AM_TblsSearchPattern, PKAM_TblsSearchPattern> {

    private static final long serialVersionUID = 1L;

    public PKAM_TblsSearchPattern() {
    }

    public PKAM_TblsSearchPattern(
        String pBaseTableId,
        String pBaseSearchDdId,
        String pBaseSearchPtnNm
    ) {
        baseTableId = pBaseTableId;
        baseSearchDdId = pBaseSearchDdId;
        baseSearchPtnNm = pBaseSearchPtnNm;
    }

    @Transient
    @Override
    public Class<AM_TblsSearchPattern> getEntityClass() {
        return AM_TblsSearchPattern.class;
    }

    private String baseTableId;

    public String getBaseTableId() {
        return baseTableId;
    }

    public void setBaseTableId(String pBaseTableId) {
        baseTableId = pBaseTableId;
    }
    private String baseSearchDdId;

    public String getBaseSearchDdId() {
        return baseSearchDdId;
    }

    public void setBaseSearchDdId(String pBaseSearchDdId) {
        baseSearchDdId = pBaseSearchDdId;
    }
    private String baseSearchPtnNm;

    public String getBaseSearchPtnNm() {
        return baseSearchPtnNm;
    }

    public void setBaseSearchPtnNm(String pBaseSearchPtnNm) {
        baseSearchPtnNm = pBaseSearchPtnNm;
    }

}