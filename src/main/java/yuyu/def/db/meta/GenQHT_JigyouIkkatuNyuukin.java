package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZenhnknKbn;

/**
 * 事業一括入金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_JigyouIkkatuNyuukin extends AbstractExDBTable<HT_JigyouIkkatuNyuukin> {

    public GenQHT_JigyouIkkatuNyuukin() {
        this("HT_JigyouIkkatuNyuukin");
    }

    public GenQHT_JigyouIkkatuNyuukin(String pAlias) {
        super("HT_JigyouIkkatuNyuukin", HT_JigyouIkkatuNyuukin.class, pAlias);
    }

    public String HT_JigyouIkkatuNyuukin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldNumber<HT_JigyouIkkatuNyuukin, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, BizDate> soukinymd = new ExDBFieldString<>("soukinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> soukincd = new ExDBFieldString<>("soukincd", this);

    public final ExDBFieldBizCurrency<HT_JigyouIkkatuNyuukin> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> rssyouno = new ExDBFieldString<>("rssyouno", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, C_ZenhnknKbn> zenhnknkbn = new ExDBFieldString<>("zenhnknkbn", this, UserType_C_ZenhnknKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, C_UmuKbn> srgonyknumu = new ExDBFieldString<>("srgonyknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<HT_JigyouIkkatuNyuukin, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_JigyouIkkatuNyuukin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
