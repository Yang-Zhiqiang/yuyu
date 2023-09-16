package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_KengenKoutei;
import yuyu.def.db.mapping.GenWT_KengenKoutei;
import yuyu.def.db.meta.GenQWT_KengenKoutei;
import yuyu.def.db.meta.QWT_KengenKoutei;

/**
 * 権限明細（工程）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_KengenKoutei} の JavaDoc を参照してください。
 * @see     GenWT_KengenKoutei
 * @see     PKWT_KengenKoutei
 * @see     QWT_KengenKoutei
 * @see     GenQWT_KengenKoutei
 */
@Entity
public class WT_KengenKoutei extends GenWT_KengenKoutei {

    private static final long serialVersionUID = 1L;

    public WT_KengenKoutei() {
    }

    public WT_KengenKoutei(
        String pRoleCd,
        String pFlowId,
        String pNodeId
    ) {
        super(
            pRoleCd,
            pFlowId,
            pNodeId
        );
    }

}
