package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_TaskSummary;
import yuyu.def.db.mapping.GenWT_TaskSummary;
import yuyu.def.db.meta.GenQWT_TaskSummary;
import yuyu.def.db.meta.QWT_TaskSummary;

/**
 * タスクサマリテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_TaskSummary} の JavaDoc を参照してください。
 * @see     GenWT_TaskSummary
 * @see     PKWT_TaskSummary
 * @see     QWT_TaskSummary
 * @see     GenQWT_TaskSummary
 */
@Entity
public class WT_TaskSummary extends GenWT_TaskSummary {

    private static final long serialVersionUID = 1L;

    public WT_TaskSummary() {
    }

    public WT_TaskSummary(
        String pFlowId,
        String pIwfTskId,
        String pTokenId,
        String pTaskCreateTime
    ) {
        super(
            pFlowId,
            pIwfTskId,
            pTokenId,
            pTaskCreateTime
        );
    }

}
