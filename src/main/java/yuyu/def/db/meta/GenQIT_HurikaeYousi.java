package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_HurikaeYousi;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_NyknaiyouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 振替用紙テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HurikaeYousi extends AbstractExDBTable<IT_HurikaeYousi> {

    public GenQIT_HurikaeYousi() {
        this("IT_HurikaeYousi");
    }

    public GenQIT_HurikaeYousi(String pAlias) {
        super("IT_HurikaeYousi", IT_HurikaeYousi.class, pAlias);
    }

    public String IT_HurikaeYousi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HurikaeYousi, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HurikaeYousi, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_HurikaeYousi, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HurikaeYousi, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_HurikaeYousi, C_NyknaiyouKbn> nyknaiyoukbn = new ExDBFieldString<>("nyknaiyoukbn", this, UserType_C_NyknaiyouKbn.class);

    public final ExDBFieldString<IT_HurikaeYousi, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> rhrkjyuutouym = new ExDBFieldString<>("rhrkjyuutouym", this);

    public final ExDBFieldString<IT_HurikaeYousi, BizDate> hrkkigen = new ExDBFieldString<>("hrkkigen", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_HurikaeYousi> hrkiraikngk = new ExDBFieldBizCurrency<>("hrkiraikngk", this);

    public final ExDBFieldString<IT_HurikaeYousi, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_HurikaeYousi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_HurikaeYousi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
