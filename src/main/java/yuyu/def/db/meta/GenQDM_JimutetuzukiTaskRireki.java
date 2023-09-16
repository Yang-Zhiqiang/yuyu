package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.DM_JimutetuzukiTaskRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 事務手続タスクマスタ履歴保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDM_JimutetuzukiTaskRireki extends AbstractExDBTable<DM_JimutetuzukiTaskRireki> {

    public GenQDM_JimutetuzukiTaskRireki() {
        this("DM_JimutetuzukiTaskRireki");
    }

    public GenQDM_JimutetuzukiTaskRireki(String pAlias) {
        super("DM_JimutetuzukiTaskRireki", DM_JimutetuzukiTaskRireki.class, pAlias);
    }

    public String DM_JimutetuzukiTaskRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DM_JimutetuzukiTaskRireki, BizDate> kensuuHokanYmd = new ExDBFieldString<>("kensuuHokanYmd", this, BizDateType.class);

    public final ExDBFieldString<DM_JimutetuzukiTaskRireki, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<DM_JimutetuzukiTaskRireki, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DM_JimutetuzukiTaskRireki, String> workflowTskId = new ExDBFieldString<>("workflowTskId", this);

    public final ExDBFieldString<DM_JimutetuzukiTaskRireki, String> workflowTskNm = new ExDBFieldString<>("workflowTskNm", this);

    public final ExDBFieldNumber<DM_JimutetuzukiTaskRireki, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldNumber<DM_JimutetuzukiTaskRireki, Integer> worklistHyoujiFlag = new ExDBFieldNumber<>("worklistHyoujiFlag", this);
}
