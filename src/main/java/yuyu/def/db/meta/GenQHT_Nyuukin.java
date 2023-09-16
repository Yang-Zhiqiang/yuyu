package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_NyuukinHenkinSyoriKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_NyknsyubetuKbn;
import yuyu.def.db.type.UserType_C_NyuukinHenkinSyoriKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_ZenhnknKbn;

/**
 * 入金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Nyuukin extends AbstractExDBTable<HT_Nyuukin> {

    public GenQHT_Nyuukin() {
        this("HT_Nyuukin");
    }

    public GenQHT_Nyuukin(String pAlias) {
        super("HT_Nyuukin", HT_Nyuukin.class, pAlias);
    }

    public String HT_Nyuukin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Nyuukin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_Nyuukin, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_Nyuukin, BizDate> soukinymd = new ExDBFieldString<>("soukinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Nyuukin, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Nyuukin, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Nyuukin, String> nyuukinsyoritime = new ExDBFieldString<>("nyuukinsyoritime", this);

    public final ExDBFieldString<HT_Nyuukin, C_NyknsyubetuKbn> nyknsyubetu = new ExDBFieldString<>("nyknsyubetu", this, UserType_C_NyknsyubetuKbn.class);

    public final ExDBFieldString<HT_Nyuukin, String> soukincd = new ExDBFieldString<>("soukincd", this);

    public final ExDBFieldBizCurrency<HT_Nyuukin> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<HT_Nyuukin, C_Tuukasyu> rstuukasyu = new ExDBFieldString<>("rstuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_Nyuukin, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Nyuukin, String> rssyouno = new ExDBFieldString<>("rssyouno", this);

    public final ExDBFieldString<HT_Nyuukin, C_ZenhnknKbn> zenhnknkbn = new ExDBFieldString<>("zenhnknkbn", this, UserType_C_ZenhnknKbn.class);

    public final ExDBFieldString<HT_Nyuukin, C_UmuKbn> srgonyknumu = new ExDBFieldString<>("srgonyknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_Nyuukin, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldString<HT_Nyuukin, String> denrenno2 = new ExDBFieldString<>("denrenno2", this);

    public final ExDBFieldNumber<HT_Nyuukin, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_Nyuukin, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<HT_Nyuukin, Integer> krkno = new ExDBFieldNumber<>("krkno", this);

    public final ExDBFieldString<HT_Nyuukin, String> dntcd = new ExDBFieldString<>("dntcd", this);

    public final ExDBFieldString<HT_Nyuukin, C_NyuukinHenkinSyoriKbn> nyuukinhenkinsyorikbn = new ExDBFieldString<>("nyuukinhenkinsyorikbn", this, UserType_C_NyuukinHenkinSyoriKbn.class);

    public final ExDBFieldNumber<HT_Nyuukin, Integer> zenhnknrenno = new ExDBFieldNumber<>("zenhnknrenno", this);

    public final ExDBFieldString<HT_Nyuukin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Nyuukin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
