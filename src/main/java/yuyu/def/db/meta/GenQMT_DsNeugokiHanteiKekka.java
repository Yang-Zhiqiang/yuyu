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
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * ＤＳ値動き判定結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsNeugokiHanteiKekka extends AbstractExDBTable<MT_DsNeugokiHanteiKekka> {

    public GenQMT_DsNeugokiHanteiKekka() {
        this("MT_DsNeugokiHanteiKekka");
    }

    public GenQMT_DsNeugokiHanteiKekka(String pAlias) {
        super("MT_DsNeugokiHanteiKekka", MT_DsNeugokiHanteiKekka.class, pAlias);
    }

    public String MT_DsNeugokiHanteiKekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsNeugokiHanteiKekka, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> bosyuujiaatukaidrtencd = new ExDBFieldString<>("bosyuujiaatukaidrtencd", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> bosyuujibatukaidrtencd = new ExDBFieldString<>("bosyuujibatukaidrtencd", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<MT_DsNeugokiHanteiKekka> kaiyakuhryen = new ExDBFieldBizCurrency<>("kaiyakuhryen", this);

    public final ExDBFieldBizCurrency<MT_DsNeugokiHanteiKekka> itijibrp = new ExDBFieldBizCurrency<>("itijibrp", this);

    public final ExDBFieldBizCurrency<MT_DsNeugokiHanteiKekka> neugokihanteikjnkngk = new ExDBFieldBizCurrency<>("neugokihanteikjnkngk", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, BizNumber> neugokiwari = new ExDBFieldString<>("neugokiwari", this, BizNumberType.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, BizNumber> neugokitoutatulinefile = new ExDBFieldString<>("neugokitoutatulinefile", this, BizNumberType.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, BizNumber> neugokitoutatulinemail = new ExDBFieldString<>("neugokitoutatulinemail", this, BizNumberType.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, C_UmuKbn> neugokihanteiumukbn = new ExDBFieldString<>("neugokihanteiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, C_YouhiKbn> mailsousinyhkbn = new ExDBFieldString<>("mailsousinyhkbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, C_UmuKbn> mailaddresstourokuumukbn = new ExDBFieldString<>("mailaddresstourokuumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsNeugokiHanteiKekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
