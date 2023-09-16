package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKMT_DsMailHaisinYoyaku;
import yuyu.def.db.mapping.GenMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.GenQMT_DsMailHaisinYoyaku;
import yuyu.def.db.meta.QMT_DsMailHaisinYoyaku;

/**
 * ＤＳメール配信予約テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenMT_DsMailHaisinYoyaku} の JavaDoc を参照してください。
 * @see     GenMT_DsMailHaisinYoyaku
 * @see     PKMT_DsMailHaisinYoyaku
 * @see     QMT_DsMailHaisinYoyaku
 * @see     GenQMT_DsMailHaisinYoyaku
 */
@Entity
public class MT_DsMailHaisinYoyaku extends GenMT_DsMailHaisinYoyaku {

    private static final long serialVersionUID = 1L;

    public MT_DsMailHaisinYoyaku() {
    }

    public MT_DsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {
        super(pDsmailhaisinyoyakuskbtkey);
    }

}
