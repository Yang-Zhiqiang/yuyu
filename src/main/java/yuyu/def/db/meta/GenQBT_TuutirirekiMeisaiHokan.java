package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BT_TuutirirekiMeisaiHokan;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 通知履歴明細保管テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TuutirirekiMeisaiHokan extends AbstractExDBTable<BT_TuutirirekiMeisaiHokan> {

    public GenQBT_TuutirirekiMeisaiHokan() {
        this("BT_TuutirirekiMeisaiHokan");
    }

    public GenQBT_TuutirirekiMeisaiHokan(String pAlias) {
        super("BT_TuutirirekiMeisaiHokan", BT_TuutirirekiMeisaiHokan.class, pAlias);
    }

    public String BT_TuutirirekiMeisaiHokan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TuutirirekiMeisaiHokan, String> tuutirirekirenno = new ExDBFieldString<>("tuutirirekirenno", this);

    public final ExDBFieldString<BT_TuutirirekiMeisaiHokan, String> tuutirirekino = new ExDBFieldString<>("tuutirirekino", this);

    public final ExDBFieldString<BT_TuutirirekiMeisaiHokan, BizDate> tuutisakuseiymd = new ExDBFieldString<>("tuutisakuseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<BT_TuutirirekiMeisaiHokan, Integer> tuutisakuseino = new ExDBFieldNumber<>("tuutisakuseino", this);

    public final ExDBFieldString<BT_TuutirirekiMeisaiHokan, String> tuutisyuruicd = new ExDBFieldString<>("tuutisyuruicd", this);

    public final ExDBFieldString<BT_TuutirirekiMeisaiHokan, BizDate> hyoujiyoutuutisakuseiymd = new ExDBFieldString<>("hyoujiyoutuutisakuseiymd", this, BizDateType.class);
}
