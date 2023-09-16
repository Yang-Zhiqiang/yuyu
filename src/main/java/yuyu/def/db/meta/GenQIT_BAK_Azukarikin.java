package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AzukarikinsyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_BAK_Azukarikin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AzukarikinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 預り金バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_Azukarikin extends AbstractExDBTable<IT_BAK_Azukarikin> {

    public GenQIT_BAK_Azukarikin() {
        this("IT_BAK_Azukarikin");
    }

    public GenQIT_BAK_Azukarikin(String pAlias) {
        super("IT_BAK_Azukarikin", IT_BAK_Azukarikin.class, pAlias);
    }

    public String IT_BAK_Azukarikin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_Azukarikin, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_Azukarikin, C_AzukarikinsyuruiKbn> azukarikinsyuruikbn = new ExDBFieldString<>("azukarikinsyuruikbn", this, UserType_C_AzukarikinsyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_Azukarikin, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Azukarikin, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_Azukarikin, BizDate> azukarikinhsiymd = new ExDBFieldString<>("azukarikinhsiymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_Azukarikin> azukarikingk = new ExDBFieldBizCurrency<>("azukarikingk", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_Azukarikin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
