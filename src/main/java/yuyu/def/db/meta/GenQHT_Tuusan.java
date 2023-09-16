package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_Tuusan;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 通算テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Tuusan extends AbstractExDBTable<HT_Tuusan> {

    public GenQHT_Tuusan() {
        this("HT_Tuusan");
    }

    public GenQHT_Tuusan(String pAlias) {
        super("HT_Tuusan", HT_Tuusan.class, pAlias);
    }

    public String HT_Tuusan() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Tuusan, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnsibous = new ExDBFieldBizCurrency<>("tsnsibous", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnninenmikeikas = new ExDBFieldBizCurrency<>("tsnninenmikeikas", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnninenkeikas = new ExDBFieldBizCurrency<>("tsnninenkeikas", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnninenmikeikahtnkns = new ExDBFieldBizCurrency<>("tsnninenmikeikahtnkns", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnninenkeikadfp = new ExDBFieldBizCurrency<>("tsnninenkeikadfp", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnketsibous = new ExDBFieldBizCurrency<>("tsnketsibous", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnketsibous2 = new ExDBFieldBizCurrency<>("tsnketsibous2", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnsoukktjituhsgk = new ExDBFieldBizCurrency<>("tsnsoukktjituhsgk", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnkktjituhsgk1 = new ExDBFieldBizCurrency<>("tsnkktjituhsgk1", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnkktjituhsgk2 = new ExDBFieldBizCurrency<>("tsnkktjituhsgk2", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnkktitijibrsysnjs = new ExDBFieldBizCurrency<>("tsnkktitijibrsysnjs", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnnkgns = new ExDBFieldBizCurrency<>("tsnnkgns", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnmsnynenbtsousbus = new ExDBFieldBizCurrency<>("tsnmsnynenbtsousbus", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnnenbtitijibrssbs = new ExDBFieldBizCurrency<>("tsnnenbtitijibrssbs", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnitijibrsysnp = new ExDBFieldBizCurrency<>("tsnitijibrsysnp", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> tsnsntktuukahijynsysns = new ExDBFieldBizCurrency<>("tsnsntktuukahijynsysns", this);

    public final ExDBFieldBizCurrency<HT_Tuusan> kykdrtentsns = new ExDBFieldBizCurrency<>("kykdrtentsns", this);

    public final ExDBFieldString<HT_Tuusan, C_UmuKbn> tsnkaigomehrtkumukbn = new ExDBFieldString<>("tsnkaigomehrtkumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_Tuusan, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Tuusan, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
