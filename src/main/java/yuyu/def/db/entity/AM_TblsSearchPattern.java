package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAM_TblsSearchPattern;
import yuyu.def.db.mapping.GenAM_TblsSearchPattern;
import yuyu.def.db.meta.GenQAM_TblsSearchPattern;
import yuyu.def.db.meta.QAM_TblsSearchPattern;

/**
 * テーブル照会検索パターンマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_TblsSearchPattern} の JavaDoc を参照してください。
 * @see     GenAM_TblsSearchPattern
 * @see     PKAM_TblsSearchPattern
 * @see     QAM_TblsSearchPattern
 * @see     GenQAM_TblsSearchPattern
 */
@Entity
public class AM_TblsSearchPattern extends GenAM_TblsSearchPattern {

    private static final long serialVersionUID = 1L;

    public AM_TblsSearchPattern() {
    }

    public AM_TblsSearchPattern(
        String pBaseTableId,
        String pBaseSearchDdId,
        String pBaseSearchPtnNm
    ) {
        super(
            pBaseTableId,
            pBaseSearchDdId,
            pBaseSearchPtnNm
        );
    }

}
