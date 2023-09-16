package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BT_BuntanInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 分担情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_BuntanInfo extends AbstractExDBTable<BT_BuntanInfo> {

    public GenQBT_BuntanInfo() {
        this("BT_BuntanInfo");
    }

    public GenQBT_BuntanInfo(String pAlias) {
        super("BT_BuntanInfo", BT_BuntanInfo.class, pAlias);
    }

    public String BT_BuntanInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_BuntanInfo, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BT_BuntanInfo, String> dairitensyouhincd = new ExDBFieldString<>("dairitensyouhincd", this);

    public final ExDBFieldString<BT_BuntanInfo, String> tesuuryoubuntandrtencd = new ExDBFieldString<>("tesuuryoubuntandrtencd", this);

    public final ExDBFieldString<BT_BuntanInfo, BizDateYM> tesuuryoubuntanstartym = new ExDBFieldString<>("tesuuryoubuntanstartym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_BuntanInfo, BizDateYM> tesuuryoubuntanendym = new ExDBFieldString<>("tesuuryoubuntanendym", this, BizDateYMType.class);

    public final ExDBFieldString<BT_BuntanInfo, BizNumber> tesuuryoubuntanwariai = new ExDBFieldString<>("tesuuryoubuntanwariai", this, BizNumberType.class);
}
