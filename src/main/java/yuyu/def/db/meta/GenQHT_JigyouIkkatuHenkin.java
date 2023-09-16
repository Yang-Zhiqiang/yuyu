package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_JigyouIkkatuHenkin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HnknhouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 事業一括返金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_JigyouIkkatuHenkin extends AbstractExDBTable<HT_JigyouIkkatuHenkin> {

    public GenQHT_JigyouIkkatuHenkin() {
        this("HT_JigyouIkkatuHenkin");
    }

    public GenQHT_JigyouIkkatuHenkin(String pAlias) {
        super("HT_JigyouIkkatuHenkin", HT_JigyouIkkatuHenkin.class, pAlias);
    }

    public String HT_JigyouIkkatuHenkin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldNumber<HT_JigyouIkkatuHenkin, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldBizCurrency<HT_JigyouIkkatuHenkin> hnkngk = new ExDBFieldBizCurrency<>("hnkngk", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, C_HnknhouKbn> hnknhoukbn = new ExDBFieldString<>("hnknhoukbn", this, UserType_C_HnknhouKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, BizDate> hnknymd = new ExDBFieldString<>("hnknymd", this, BizDateType.class);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, C_UmuKbn> srgohnknumu = new ExDBFieldString<>("srgohnknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_JigyouIkkatuHenkin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
