package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.DT_SyoriKensuuHokanJimu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 処理件数保管（事務手続別）テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQDT_SyoriKensuuHokanJimu extends AbstractExDBTable<DT_SyoriKensuuHokanJimu> {

    public GenQDT_SyoriKensuuHokanJimu() {
        this("DT_SyoriKensuuHokanJimu");
    }

    public GenQDT_SyoriKensuuHokanJimu(String pAlias) {
        super("DT_SyoriKensuuHokanJimu", DT_SyoriKensuuHokanJimu.class, pAlias);
    }

    public String DT_SyoriKensuuHokanJimu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, BizDate> kensuuHokanYmd = new ExDBFieldString<>("kensuuHokanYmd", this, BizDateType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, String> jimutetuzukicd = new ExDBFieldString<>("jimutetuzukicd", this);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, String> accountId = new ExDBFieldString<>("accountId", this);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, BizNumber> zenjituzanKensuu = new ExDBFieldString<>("zenjituzanKensuu", this, BizNumberType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, BizNumber> zanKensuu = new ExDBFieldString<>("zanKensuu", this, BizNumberType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, BizNumber> kanryoKensuu = new ExDBFieldString<>("kanryoKensuu", this, BizNumberType.class);

    public final ExDBFieldString<DT_SyoriKensuuHokanJimu, String> taskKanryouKensuuarihyouji = new ExDBFieldString<>("taskKanryouKensuuarihyouji", this);
}
