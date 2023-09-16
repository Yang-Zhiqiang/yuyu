package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.db.entity.IT_KessanYokukiP;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;

/**
 * 決算用翌期Ｐテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KessanYokukiP extends AbstractExDBTable<IT_KessanYokukiP> {

    public GenQIT_KessanYokukiP() {
        this("IT_KessanYokukiP");
    }

    public GenQIT_KessanYokukiP(String pAlias) {
        super("IT_KessanYokukiP", IT_KessanYokukiP.class, pAlias);
    }

    public String IT_KessanYokukiP() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KessanYokukiP, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDateYM> keijyouym = new ExDBFieldString<>("keijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hknsyukigousdkbn1keta = new ExDBFieldString<>("hknsyukigousdkbn1keta", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x1 = new ExDBFieldString<>("hokensyuruikigouyobi1x1", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x2 = new ExDBFieldString<>("hokensyuruikigouyobi1x2", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x3 = new ExDBFieldString<>("hokensyuruikigouyobi1x3", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x4 = new ExDBFieldString<>("hokensyuruikigouyobi1x4", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x5 = new ExDBFieldString<>("hokensyuruikigouyobi1x5", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x6 = new ExDBFieldString<>("hokensyuruikigouyobi1x6", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x7 = new ExDBFieldString<>("hokensyuruikigouyobi1x7", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x8 = new ExDBFieldString<>("hokensyuruikigouyobi1x8", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x9 = new ExDBFieldString<>("hokensyuruikigouyobi1x9", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x10 = new ExDBFieldString<>("hokensyuruikigouyobi1x10", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x11 = new ExDBFieldString<>("hokensyuruikigouyobi1x11", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x12 = new ExDBFieldString<>("hokensyuruikigouyobi1x12", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x13 = new ExDBFieldString<>("hokensyuruikigouyobi1x13", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x14 = new ExDBFieldString<>("hokensyuruikigouyobi1x14", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi1x15 = new ExDBFieldString<>("hokensyuruikigouyobi1x15", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x1 = new ExDBFieldString<>("hokensyuruikigouyobi2x1", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x2 = new ExDBFieldString<>("hokensyuruikigouyobi2x2", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x3 = new ExDBFieldString<>("hokensyuruikigouyobi2x3", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x4 = new ExDBFieldString<>("hokensyuruikigouyobi2x4", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x5 = new ExDBFieldString<>("hokensyuruikigouyobi2x5", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x6 = new ExDBFieldString<>("hokensyuruikigouyobi2x6", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x7 = new ExDBFieldString<>("hokensyuruikigouyobi2x7", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x8 = new ExDBFieldString<>("hokensyuruikigouyobi2x8", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x9 = new ExDBFieldString<>("hokensyuruikigouyobi2x9", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi2x10 = new ExDBFieldString<>("hokensyuruikigouyobi2x10", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x1 = new ExDBFieldString<>("hokensyuruikigouyobi3x1", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x2 = new ExDBFieldString<>("hokensyuruikigouyobi3x2", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x3 = new ExDBFieldString<>("hokensyuruikigouyobi3x3", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x4 = new ExDBFieldString<>("hokensyuruikigouyobi3x4", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x5 = new ExDBFieldString<>("hokensyuruikigouyobi3x5", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x6 = new ExDBFieldString<>("hokensyuruikigouyobi3x6", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x7 = new ExDBFieldString<>("hokensyuruikigouyobi3x7", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x8 = new ExDBFieldString<>("hokensyuruikigouyobi3x8", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x9 = new ExDBFieldString<>("hokensyuruikigouyobi3x9", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hokensyuruikigouyobi3x10 = new ExDBFieldString<>("hokensyuruikigouyobi3x10", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldNumber<IT_KessanYokukiP, Integer> syoumetucd = new ExDBFieldNumber<>("syoumetucd", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> haraikomip = new ExDBFieldBizCurrency<>("haraikomip", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> syukykp = new ExDBFieldBizCurrency<>("syukykp", this);

    public final ExDBFieldNumber<IT_KessanYokukiP, Integer> zennyknmonth = new ExDBFieldNumber<>("zennyknmonth", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDate> zenyuukinymd = new ExDBFieldString<>("zenyuukinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> jidoukousinhyouji = new ExDBFieldString<>("jidoukousinhyouji", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> tenkanhyouji = new ExDBFieldString<>("tenkanhyouji", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> hosyouikkatumnoshyouji = new ExDBFieldString<>("hosyouikkatumnoshyouji", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> yobi01xv40 = new ExDBFieldString<>("yobi01xv40", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> tkkzkp = new ExDBFieldBizCurrency<>("tkkzkp", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> keizokuphurikaekngk = new ExDBFieldBizCurrency<>("keizokuphurikaekngk", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDateYM> keizokuphurikaekaisiym = new ExDBFieldString<>("keizokuphurikaekaisiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KessanYokukiP, BizDateYM> haraikomipannaisaikaiym = new ExDBFieldString<>("haraikomipannaisaikaiym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KessanYokukiP, BizDate> tkkzkkouryokukaisiymd = new ExDBFieldString<>("tkkzkkouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> hrimngtkykpjyuutouhoukbn = new ExDBFieldString<>("hrimngtkykpjyuutouhoukbn", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDateYM> jkitkpjytym = new ExDBFieldString<>("jkitkpjytym", this, BizDateYMType.class);

    public final ExDBFieldNumber<IT_KessanYokukiP, Long> itijibrzugktkp = new ExDBFieldNumber<>("itijibrzugktkp", this);

    public final ExDBFieldNumber<IT_KessanYokukiP, Long> pazukarikingk = new ExDBFieldNumber<>("pazukarikingk", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> zennoukbn = new ExDBFieldString<>("zennoukbn", this);

    public final ExDBFieldString<IT_KessanYokukiP, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanYokukiP, BizDate> zennounyuukinymd = new ExDBFieldString<>("zennounyuukinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> yokukipbunruicd = new ExDBFieldString<>("yokukipbunruicd", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd1 = new ExDBFieldString<>("misyoricd1", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd2 = new ExDBFieldString<>("misyoricd2", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd3 = new ExDBFieldString<>("misyoricd3", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd4 = new ExDBFieldString<>("misyoricd4", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd5 = new ExDBFieldString<>("misyoricd5", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd6 = new ExDBFieldString<>("misyoricd6", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd7 = new ExDBFieldString<>("misyoricd7", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd8 = new ExDBFieldString<>("misyoricd8", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd9 = new ExDBFieldString<>("misyoricd9", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> misyoricd10 = new ExDBFieldString<>("misyoricd10", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> yobi02xv39 = new ExDBFieldString<>("yobi02xv39", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> kbnkeiriyousegmentkbn = new ExDBFieldString<>("kbnkeiriyousegmentkbn", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> kbnkeiriyourgnbnskkbn = new ExDBFieldString<>("kbnkeiriyourgnbnskkbn", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> suurisyuruicd = new ExDBFieldString<>("suurisyuruicd", this);

    public final ExDBFieldString<IT_KessanYokukiP, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KessanYokukiP, String> kyknendo = new ExDBFieldString<>("kyknendo", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> keiyakum = new ExDBFieldString<>("keiyakum", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> haraikatakbn = new ExDBFieldString<>("haraikatakbn", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> iktyknndp = new ExDBFieldBizCurrency<>("iktyknndp", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> kigetumaenyknyknndp = new ExDBFieldBizCurrency<>("kigetumaenyknyknndp", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> yknndpkei = new ExDBFieldBizCurrency<>("yknndpkei", this);

    public final ExDBFieldBizCurrency<IT_KessanYokukiP> yobi03xn13 = new ExDBFieldBizCurrency<>("yobi03xn13", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> yobi04xv23 = new ExDBFieldString<>("yobi04xv23", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KessanYokukiP, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
