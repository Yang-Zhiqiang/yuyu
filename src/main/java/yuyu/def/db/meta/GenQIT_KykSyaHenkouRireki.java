package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykSyaHenkouRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_Meigihnkjiyuu;
import yuyu.def.db.type.UserType_C_Tdk;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 契約者変更履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KykSyaHenkouRireki extends AbstractExDBTable<IT_KykSyaHenkouRireki> {

    public GenQIT_KykSyaHenkouRireki() {
        this("IT_KykSyaHenkouRireki");
    }

    public GenQIT_KykSyaHenkouRireki(String pAlias) {
        super("IT_KykSyaHenkouRireki", IT_KykSyaHenkouRireki.class, pAlias);
    }

    public String IT_KykSyaHenkouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizDate> meighnksyoriymd = new ExDBFieldString<>("meighnksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, C_Meigihnkjiyuu> meigihnkjiyuu = new ExDBFieldString<>("meigihnkjiyuu", this, UserType_C_Meigihnkjiyuu.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizDate> oldkyksibouymd = new ExDBFieldString<>("oldkyksibouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldkyknmkn = new ExDBFieldString<>("oldkyknmkn", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldkyknmkj = new ExDBFieldString<>("oldkyknmkj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, C_KjkhukaKbn> oldkyknmkjkhukakbn = new ExDBFieldString<>("oldkyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizDate> oldkykseiymd = new ExDBFieldString<>("oldkykseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, C_Kyksei> oldkyksei = new ExDBFieldString<>("oldkyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, C_Tdk> oldkkkyktdk = new ExDBFieldString<>("oldkkkyktdk", this, UserType_C_Tdk.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldtsinyno = new ExDBFieldString<>("oldtsinyno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldtsinadr1kj = new ExDBFieldString<>("oldtsinadr1kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldtsinadr2kj = new ExDBFieldString<>("oldtsinadr2kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldtsinadr3kj = new ExDBFieldString<>("oldtsinadr3kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> oldtsintelno = new ExDBFieldString<>("oldtsintelno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> olddai2tsintelno = new ExDBFieldString<>("olddai2tsintelno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_KykSyaHenkouRireki> kaiyakuhrstgk = new ExDBFieldBizCurrency<>("kaiyakuhrstgk", this);

    public final ExDBFieldBizCurrency<IT_KykSyaHenkouRireki> yenkaiyakuhrstgk = new ExDBFieldBizCurrency<>("yenkaiyakuhrstgk", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizNumber> yenkansantkykwsrate = new ExDBFieldString<>("yenkansantkykwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, BizDate> yenkansantkykwsrateymd = new ExDBFieldString<>("yenkansantkykwsrateymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KykSyaHenkouRireki> kihrkmpsgk = new ExDBFieldBizCurrency<>("kihrkmpsgk", this);

    public final ExDBFieldBizCurrency<IT_KykSyaHenkouRireki> oldkykkihrkmp = new ExDBFieldBizCurrency<>("oldkykkihrkmp", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KykSyaHenkouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_KykSyaHenkouRireki> sonotashrkngkyen = new ExDBFieldBizCurrency<>("sonotashrkngkyen", this);
}
