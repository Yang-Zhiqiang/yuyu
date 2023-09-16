package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.DT_SyoriKensuuHokanTask;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 処理件数保管（タスク別）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDT_SyoriKensuuHokanTask extends AbstractExDBTable<DT_SyoriKensuuHokanTask> {

    public GenQDT_SyoriKensuuHokanTask() {
        this("DT_SyoriKensuuHokanTask");
    }

    public GenQDT_SyoriKensuuHokanTask(String pAlias) {
        super("DT_SyoriKensuuHokanTask", DT_SyoriKensuuHokanTask.class, pAlias);
    }

    public String DT_SyoriKensuuHokanTask() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, BizDate> kensuuHokanYmd = new ExDBFieldString<>("kensuuHokanYmd", this, BizDateType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, String> tskid = new ExDBFieldString<>("tskid", this);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, String> accountId = new ExDBFieldString<>("accountId", this);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, BizNumber> zenjituzanKensuu = new ExDBFieldString<>("zenjituzanKensuu", this, BizNumberType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, BizNumber> zanKensuu = new ExDBFieldString<>("zanKensuu", this, BizNumberType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanTask, BizNumber> kanryoKensuu = new ExDBFieldString<>("kanryoKensuu", this, BizNumberType.class);
}
