package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_KhHenkouUktkYendtHnk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HnskariyuuKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全変更受付内容（円建変更）バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhHenkouUktkYendtHnk extends AbstractExDBTable<IT_BAK_KhHenkouUktkYendtHnk> {

    public GenQIT_BAK_KhHenkouUktkYendtHnk() {
        this("IT_BAK_KhHenkouUktkYendtHnk");
    }

    public GenQIT_BAK_KhHenkouUktkYendtHnk(String pAlias) {
        super("IT_BAK_KhHenkouUktkYendtHnk", IT_BAK_KhHenkouUktkYendtHnk.class, pAlias);
    }

    public String IT_BAK_KhHenkouUktkYendtHnk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktkYendtHnk, Integer> hozenhenkouuktkrenno = new ExDBFieldNumber<>("hozenhenkouuktkrenno", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizDate> mkhgktttymd = new ExDBFieldString<>("mkhgktttymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> mkhgktttkaiyakuhr = new ExDBFieldBizCurrency<>("mkhgktttkaiyakuhr", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> newkaiyakuhr = new ExDBFieldBizCurrency<>("newkaiyakuhr", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkhr = new ExDBFieldBizCurrency<>("yendthnkhr", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, C_HassouKbn> nyuuryokuhassoukbn = new ExDBFieldString<>("nyuuryokuhassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, C_HnskariyuuKbn> hnskariyuu1 = new ExDBFieldString<>("hnskariyuu1", this, UserType_C_HnskariyuuKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, C_HnskariyuuKbn> hnskariyuu2 = new ExDBFieldString<>("hnskariyuu2", this, UserType_C_HnskariyuuKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkkaiyakuhrgaika = new ExDBFieldBizCurrency<>("yendthnkkaiyakuhrgaika", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkkaiyakuhryen = new ExDBFieldBizCurrency<>("yendthnkkaiyakuhryen", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizNumber> yendthnkjikwsrate = new ExDBFieldString<>("yendthnkjikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> newsyouhncd = new ExDBFieldString<>("newsyouhncd", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktkYendtHnk, Integer> newsyouhnsdno = new ExDBFieldNumber<>("newsyouhnsdno", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkkihons = new ExDBFieldBizCurrency<>("yendthnkkihons", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> newhokenryou = new ExDBFieldBizCurrency<>("newhokenryou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, C_Tuukasyu> newkyktuukasyu = new ExDBFieldString<>("newkyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> newryouritusdno = new ExDBFieldString<>("newryouritusdno", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizNumber> newtumitateriritu = new ExDBFieldString<>("newtumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizNumber> newyoteiriritu = new ExDBFieldString<>("newyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> mkhgk = new ExDBFieldBizCurrency<>("mkhgk", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkkjnkg = new ExDBFieldBizCurrency<>("yendthnkkjnkg", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouUktkYendtHnk, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkbfrsibousyen = new ExDBFieldBizCurrency<>("yendthnkbfrsibousyen", this);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkjiptumitatekin = new ExDBFieldBizCurrency<>("yendthnkjiptumitatekin", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizNumber> yendthnkjisjkkktyouseiritu = new ExDBFieldString<>("yendthnkjisjkkktyouseiritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_KhHenkouUktkYendtHnk> yendthnkjikaiyakukjgk = new ExDBFieldBizCurrency<>("yendthnkjikaiyakukjgk", this);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, BizNumber> yendthnkjikaiyakukoujyoritu = new ExDBFieldString<>("yendthnkjikaiyakukoujyoritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KhHenkouUktkYendtHnk, C_UmuKbn> kaiyakukoujyoritutekiumu = new ExDBFieldString<>("kaiyakukoujyoritutekiumu", this, UserType_C_UmuKbn.class);
}
