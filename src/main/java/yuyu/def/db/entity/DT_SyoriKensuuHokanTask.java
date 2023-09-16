package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKDT_SyoriKensuuHokanTask;
import yuyu.def.db.mapping.GenDT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.GenQDT_SyoriKensuuHokanTask;
import yuyu.def.db.meta.QDT_SyoriKensuuHokanTask;
import jp.co.slcs.swak.date.BizDate;

/**
 * 処理件数保管（タスク別）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenDT_SyoriKensuuHokanTask} の JavaDoc を参照してください。
 * @see     GenDT_SyoriKensuuHokanTask
 * @see     PKDT_SyoriKensuuHokanTask
 * @see     QDT_SyoriKensuuHokanTask
 * @see     GenQDT_SyoriKensuuHokanTask
 */
@Entity
public class DT_SyoriKensuuHokanTask extends GenDT_SyoriKensuuHokanTask {

    private static final long serialVersionUID = 1L;

    public DT_SyoriKensuuHokanTask() {
    }

    public DT_SyoriKensuuHokanTask(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pTskid,
        String pAccountId
    ) {
        super(
            pKensuuHokanYmd,
            pJimutetuzukicd,
            pTskid,
            pAccountId
        );
    }

}
