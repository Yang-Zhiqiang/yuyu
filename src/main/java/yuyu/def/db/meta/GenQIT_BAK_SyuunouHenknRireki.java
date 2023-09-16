package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_ShrriyuuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_BAK_SyuunouHenknRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_ShrriyuuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 収納返金履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_SyuunouHenknRireki extends AbstractExDBTable<IT_BAK_SyuunouHenknRireki> {

    public GenQIT_BAK_SyuunouHenknRireki() {
        this("IT_BAK_SyuunouHenknRireki");
    }

    public GenQIT_BAK_SyuunouHenknRireki(String pAlias) {
        super("IT_BAK_SyuunouHenknRireki", IT_BAK_SyuunouHenknRireki.class, pAlias);
    }

    public String IT_BAK_SyuunouHenknRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<IT_BAK_SyuunouHenknRireki, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, BizDate> denkihyouymd = new ExDBFieldString<>("denkihyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldBizCurrency<IT_BAK_SyuunouHenknRireki> hnkngk = new ExDBFieldBizCurrency<>("hnkngk", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, C_ShrriyuuKbn> shrriyuukbn = new ExDBFieldString<>("shrriyuukbn", this, UserType_C_ShrriyuuKbn.class);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_SyuunouHenknRireki, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);
}
