package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkeAnnaiJkKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KzkpannaijiyuuKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.IT_HrkeIraiInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HrkeAnnaiJkKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_KzkpannaijiyuuKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;

/**
 * 振替依頼情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HrkeIraiInfo extends AbstractExDBTable<IT_HrkeIraiInfo> {

    public GenQIT_HrkeIraiInfo() {
        this("IT_HrkeIraiInfo");
    }

    public GenQIT_HrkeIraiInfo(String pAlias) {
        super("IT_HrkeIraiInfo", IT_HrkeIraiInfo.class, pAlias);
    }

    public String IT_HrkeIraiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HrkeIraiInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, C_HrkeAnnaiJkKbn> hrkeannaijkkbn = new ExDBFieldString<>("hrkeannaijkkbn", this, UserType_C_HrkeAnnaiJkKbn.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDate> hrkeyousiymd = new ExDBFieldString<>("hrkeyousiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDate> ryosyuymd = new ExDBFieldString<>("ryosyuymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_HrkeIraiInfo> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDate> torikesiymd = new ExDBFieldString<>("torikesiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDate> hrkkigen = new ExDBFieldString<>("hrkkigen", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_HrkeIraiInfo> hrkiraikngk = new ExDBFieldBizCurrency<>("hrkiraikngk", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_HrkeIraiInfo, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_HrkeIraiInfo, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, C_KzkpannaijiyuuKbn> kzkpannaijiyuukbn = new ExDBFieldString<>("kzkpannaijiyuukbn", this, UserType_C_KzkpannaijiyuuKbn.class);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> comment124keta = new ExDBFieldString<>("comment124keta", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldBizCurrency<IT_HrkeIraiInfo> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HrkeIraiInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
