package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_BknsyutkKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_BknsyutkKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全備金管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhBikinkanri extends AbstractExDBTable<IT_KhBikinkanri> {

    public GenQIT_KhBikinkanri() {
        this("IT_KhBikinkanri");
    }

    public GenQIT_KhBikinkanri(String pAlias) {
        super("IT_KhBikinkanri", IT_KhBikinkanri.class, pAlias);
    }

    public String IT_KhBikinkanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhBikinkanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> bknkktymd = new ExDBFieldString<>("bknkktymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhBikinkanri, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KhBikinkanri, C_BknrigiKbn> bknrigikbn = new ExDBFieldString<>("bknrigikbn", this, UserType_C_BknrigiKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<IT_KhBikinkanri, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_KhBikinkanri, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<IT_KhBikinkanri, C_BknsyutkKbn> bknsyutkkbn = new ExDBFieldString<>("bknsyutkkbn", this, UserType_C_BknsyutkKbn.class);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> bkngk = new ExDBFieldBizCurrency<>("bkngk", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<IT_KhBikinkanri, C_UmuKbn> gngkkiykumukbn = new ExDBFieldString<>("gngkkiykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_UmuKbn> shrumu = new ExDBFieldString<>("shrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_UmuKbn> sinsaumukbn = new ExDBFieldString<>("sinsaumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_KhBikinkanri, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhBikinkanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhBikinkanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhBikinkanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KhBikinkanri, BizDate> gaikashrkwsratekjnymd = new ExDBFieldString<>("gaikashrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhBikinkanri, BizNumber> gaikashrkwsrate = new ExDBFieldString<>("gaikashrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> yenkazennouseisankgk = new ExDBFieldBizCurrency<>("yenkazennouseisankgk", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> gaikazennouseisankgk = new ExDBFieldBizCurrency<>("gaikazennouseisankgk", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> yenkamikeikap = new ExDBFieldBizCurrency<>("yenkamikeikap", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> gaikamikeikap = new ExDBFieldBizCurrency<>("gaikamikeikap", this);

    public final ExDBFieldBizCurrency<IT_KhBikinkanri> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);
}
