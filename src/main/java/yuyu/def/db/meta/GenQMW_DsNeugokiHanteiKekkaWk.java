package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * ＤＳ値動き判定結果ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMW_DsNeugokiHanteiKekkaWk extends AbstractExDBTable<MW_DsNeugokiHanteiKekkaWk> {

    public GenQMW_DsNeugokiHanteiKekkaWk() {
        this("MW_DsNeugokiHanteiKekkaWk");
    }

    public GenQMW_DsNeugokiHanteiKekkaWk(String pAlias) {
        super("MW_DsNeugokiHanteiKekkaWk", MW_DsNeugokiHanteiKekkaWk.class, pAlias);
    }

    public String MW_DsNeugokiHanteiKekkaWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MW_DsNeugokiHanteiKekkaWk, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> bosyuujiaatukaidrtencd = new ExDBFieldString<>("bosyuujiaatukaidrtencd", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> bosyuujibatukaidrtencd = new ExDBFieldString<>("bosyuujibatukaidrtencd", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<MW_DsNeugokiHanteiKekkaWk> kaiyakuhryen = new ExDBFieldBizCurrency<>("kaiyakuhryen", this);

    public final ExDBFieldBizCurrency<MW_DsNeugokiHanteiKekkaWk> itijibrp = new ExDBFieldBizCurrency<>("itijibrp", this);

    public final ExDBFieldBizCurrency<MW_DsNeugokiHanteiKekkaWk> neugokihanteikjnkngk = new ExDBFieldBizCurrency<>("neugokihanteikjnkngk", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, BizNumber> neugokiwari = new ExDBFieldString<>("neugokiwari", this, BizNumberType.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, BizNumber> neugokitoutatulinefile = new ExDBFieldString<>("neugokitoutatulinefile", this, BizNumberType.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, BizNumber> neugokitoutatulinemail = new ExDBFieldString<>("neugokitoutatulinemail", this, BizNumberType.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, C_UmuKbn> neugokihanteiumukbn = new ExDBFieldString<>("neugokihanteiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, C_YouhiKbn> mailsousinyhkbn = new ExDBFieldString<>("mailsousinyhkbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, C_UmuKbn> mailaddresstourokuumukbn = new ExDBFieldString<>("mailaddresstourokuumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MW_DsNeugokiHanteiKekkaWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
