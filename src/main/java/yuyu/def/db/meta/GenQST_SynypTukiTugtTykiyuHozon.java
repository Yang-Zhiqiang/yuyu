package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;

/**
 * 収入Ｐ統計当月処理中継用保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SynypTukiTugtTykiyuHozon extends AbstractExDBTable<ST_SynypTukiTugtTykiyuHozon> {

    public GenQST_SynypTukiTugtTykiyuHozon() {
        this("ST_SynypTukiTugtTykiyuHozon");
    }

    public GenQST_SynypTukiTugtTykiyuHozon(String pAlias) {
        super("ST_SynypTukiTugtTykiyuHozon", ST_SynypTukiTugtTykiyuHozon.class, pAlias);
    }

    public String ST_SynypTukiTugtTykiyuHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztysrkijyunym = new ExDBFieldString<>("ztysrkijyunym", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztysrkakutyoujobcd = new ExDBFieldString<>("ztysrkakutyoujobcd", this);

    public final ExDBFieldNumber<ST_SynypTukiTugtTykiyuHozon, Integer> ztysequenceno = new ExDBFieldNumber<>("ztysequenceno", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztydatakanrino = new ExDBFieldString<>("ztydatakanrino", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztyjyuutouym = new ExDBFieldString<>("ztyjyuutouym", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztyjyuutoukaisuu = new ExDBFieldString<>("ztyjyuutoukaisuu", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztyhenkousyoriymd = new ExDBFieldString<>("ztyhenkousyoriymd", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztykbnkeiriyousegmentcd = new ExDBFieldString<>("ztykbnkeiriyousegmentcd", this);

    public final ExDBFieldNumber<ST_SynypTukiTugtTykiyuHozon, Long> ztyzennoujiikkatubaraijytgk = new ExDBFieldNumber<>("ztyzennoujiikkatubaraijytgk", this);

    public final ExDBFieldString<ST_SynypTukiTugtTykiyuHozon, String> ztysrdenrenno = new ExDBFieldString<>("ztysrdenrenno", this);
}
