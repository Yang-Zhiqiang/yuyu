package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_Syuudaikocd;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AnsyuusysKbn;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_Syuudaikocd;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 新契約収納結果データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkSyuunouKekkaData extends AbstractExDBTable<HT_SkSyuunouKekkaData> {

    public GenQHT_SkSyuunouKekkaData() {
        this("HT_SkSyuunouKekkaData");
    }

    public GenQHT_SkSyuunouKekkaData(String pAlias) {
        super("HT_SkSyuunouKekkaData", HT_SkSyuunouKekkaData.class, pAlias);
    }

    public String HT_SkSyuunouKekkaData() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkSyuunouKekkaData, C_AnsyuusysKbn> ansyuusyskbn = new ExDBFieldString<>("ansyuusyskbn", this, UserType_C_AnsyuusysKbn.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, BizDateYM> jyuutouym = new ExDBFieldString<>("jyuutouym", this, BizDateYMType.class);

    public final ExDBFieldNumber<HT_SkSyuunouKekkaData, Integer> jyutoukaisuuy = new ExDBFieldNumber<>("jyutoukaisuuy", this);

    public final ExDBFieldNumber<HT_SkSyuunouKekkaData, Integer> jyutoukaisuum = new ExDBFieldNumber<>("jyutoukaisuum", this);

    public final ExDBFieldBizCurrency<HT_SkSyuunouKekkaData> rsgaku = new ExDBFieldBizCurrency<>("rsgaku", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, C_Syuudaikocd> syuudaikocd = new ExDBFieldString<>("syuudaikocd", this, UserType_C_Syuudaikocd.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkSyuunouKekkaData, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
