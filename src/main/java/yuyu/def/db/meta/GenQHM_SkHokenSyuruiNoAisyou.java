package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.type.UserType_C_AisyoumeiChannelKbn;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;

/**
 * 保険種類番号愛称マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkHokenSyuruiNoAisyou extends AbstractExDBTable<HM_SkHokenSyuruiNoAisyou> {

    public GenQHM_SkHokenSyuruiNoAisyou() {
        this("HM_SkHokenSyuruiNoAisyou");
    }

    public GenQHM_SkHokenSyuruiNoAisyou(String pAlias) {
        super("HM_SkHokenSyuruiNoAisyou", HM_SkHokenSyuruiNoAisyou.class, pAlias);
    }

    public String HM_SkHokenSyuruiNoAisyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldNumber<HM_SkHokenSyuruiNoAisyou, Integer> hknsyuruinosdfrom = new ExDBFieldNumber<>("hknsyuruinosdfrom", this);

    public final ExDBFieldNumber<HM_SkHokenSyuruiNoAisyou, Integer> hknsyuruinosdto = new ExDBFieldNumber<>("hknsyuruinosdto", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, String> hknsyuruinobetukey1 = new ExDBFieldString<>("hknsyuruinobetukey1", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, C_AisyoumeiChannelKbn> aisyoumeichannelkbn = new ExDBFieldString<>("aisyoumeichannelkbn", this, UserType_C_AisyoumeiChannelKbn.class);

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, String> aisyoumei = new ExDBFieldString<>("aisyoumei", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNoAisyou, String> husyoudakumanualinfo = new ExDBFieldString<>("husyoudakumanualinfo", this);
}
