package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_Creditbrerrorcd;
import yuyu.def.classification.C_SyuukeilvKbn;
import yuyu.def.classification.C_UriagekekkaKbn;
import yuyu.def.classification.C_UriagetorihikiKbn;
import yuyu.def.db.entity.IT_KhUriageKekkaData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_Creditbrerrorcd;
import yuyu.def.db.type.UserType_C_SyuukeilvKbn;
import yuyu.def.db.type.UserType_C_UriagekekkaKbn;
import yuyu.def.db.type.UserType_C_UriagetorihikiKbn;

/**
 * 売上結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhUriageKekkaData extends AbstractExDBTable<IT_KhUriageKekkaData> {

    public GenQIT_KhUriageKekkaData() {
        this("IT_KhUriageKekkaData");
    }

    public GenQIT_KhUriageKekkaData(String pAlias) {
        super("IT_KhUriageKekkaData", IT_KhUriageKekkaData.class, pAlias);
    }

    public String IT_KhUriageKekkaData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhUriageKekkaData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> uriagekekkadatarenno = new ExDBFieldString<>("uriagekekkadatarenno", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KhUriageKekkaData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<IT_KhUriageKekkaData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, C_SyuukeilvKbn> syuukeilvkbn = new ExDBFieldString<>("syuukeilvkbn", this, UserType_C_SyuukeilvKbn.class);

    public final ExDBFieldString<IT_KhUriageKekkaData, C_UriagetorihikiKbn> uriagetorihikikbn = new ExDBFieldString<>("uriagetorihikikbn", this, UserType_C_UriagetorihikiKbn.class);

    public final ExDBFieldString<IT_KhUriageKekkaData, BizDate> uriageymd = new ExDBFieldString<>("uriageymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhUriageKekkaData> uriagegk = new ExDBFieldBizCurrency<>("uriagegk", this);

    public final ExDBFieldBizCurrency<IT_KhUriageKekkaData> zeisoukin = new ExDBFieldBizCurrency<>("zeisoukin", this);

    public final ExDBFieldBizCurrency<IT_KhUriageKekkaData> uriagegoukei = new ExDBFieldBizCurrency<>("uriagegoukei", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> syouninno = new ExDBFieldString<>("syouninno", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> creditcardykkigen = new ExDBFieldString<>("creditcardykkigen", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, C_UriagekekkaKbn> uriagekekkakbn = new ExDBFieldString<>("uriagekekkakbn", this, UserType_C_UriagekekkaKbn.class);

    public final ExDBFieldString<IT_KhUriageKekkaData, C_Creditbrerrorcd> creditbrerrorcd = new ExDBFieldString<>("creditbrerrorcd", this, UserType_C_Creditbrerrorcd.class);

    public final ExDBFieldNumber<IT_KhUriageKekkaData, Integer> authorikaisuu = new ExDBFieldNumber<>("authorikaisuu", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhUriageKekkaData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
