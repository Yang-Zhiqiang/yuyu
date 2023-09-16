package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAM_TblsRefLimitSosiki;
import yuyu.def.db.mapping.GenAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.GenQAM_TblsRefLimitSosiki;
import yuyu.def.db.meta.QAM_TblsRefLimitSosiki;

/**
 * テーブル照会参照組織限定マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_TblsRefLimitSosiki} の JavaDoc を参照してください。
 * @see     GenAM_TblsRefLimitSosiki
 * @see     PKAM_TblsRefLimitSosiki
 * @see     QAM_TblsRefLimitSosiki
 * @see     GenQAM_TblsRefLimitSosiki
 */
@Entity
public class AM_TblsRefLimitSosiki extends GenAM_TblsRefLimitSosiki {

    private static final long serialVersionUID = 1L;

    public AM_TblsRefLimitSosiki() {
    }

    public AM_TblsRefLimitSosiki(
        String pBaseTableId,
        String pBaseDdId,
        String pTanmatusettisosikicd
    ) {
        super(
            pBaseTableId,
            pBaseDdId,
            pTanmatusettisosikicd
        );
    }

}
