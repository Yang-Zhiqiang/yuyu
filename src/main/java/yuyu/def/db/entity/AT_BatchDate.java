package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.id.PKAT_BatchDate;
import yuyu.def.db.mapping.GenAT_BatchDate;
import yuyu.def.db.meta.GenQAT_BatchDate;
import yuyu.def.db.meta.QAT_BatchDate;

/**
 * バッチ日付テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_BatchDate} の JavaDoc を参照してください。
 * @see     GenAT_BatchDate
 * @see     PKAT_BatchDate
 * @see     QAT_BatchDate
 * @see     GenQAT_BatchDate
 */
@Entity
public class AT_BatchDate extends GenAT_BatchDate {

    private static final long serialVersionUID = 1L;

    public AT_BatchDate() {
    }

    public AT_BatchDate(BizDate pBatchExecDate) {
        super(pBatchExecDate);
    }

}
