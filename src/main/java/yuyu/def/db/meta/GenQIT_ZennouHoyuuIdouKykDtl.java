package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.classification.C_ZennoubikinKbn;
import yuyu.def.db.entity.IT_ZennouHoyuuIdouKykDtl;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;
import yuyu.def.db.type.UserType_C_ZennoubikinKbn;

/**
 * 前納保有異動契約明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_ZennouHoyuuIdouKykDtl extends AbstractExDBTable<IT_ZennouHoyuuIdouKykDtl> {

    public GenQIT_ZennouHoyuuIdouKykDtl() {
        this("IT_ZennouHoyuuIdouKykDtl");
    }

    public GenQIT_ZennouHoyuuIdouKykDtl(String pAlias) {
        super("IT_ZennouHoyuuIdouKykDtl", IT_ZennouHoyuuIdouKykDtl.class, pAlias);
    }

    public String IT_ZennouHoyuuIdouKykDtl() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldNumber<IT_ZennouHoyuuIdouKykDtl, Integer> kykmfksnctr = new ExDBFieldNumber<>("kykmfksnctr", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> henkousyoriymd = new ExDBFieldString<>("henkousyoriymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> zennoukessanrecordkbn = new ExDBFieldString<>("zennoukessanrecordkbn", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDateYM> keijyouym = new ExDBFieldString<>("keijyouym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> zennoucalckijyunymd = new ExDBFieldString<>("zennoucalckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, C_ZennoubikinKbn> zennoubikinkbn = new ExDBFieldString<>("zennoubikinkbn", this, UserType_C_ZennoubikinKbn.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> syukeiyakusyuruicd = new ExDBFieldString<>("syukeiyakusyuruicd", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, C_ZennouToukeiListKbn> zennoutoukeilistkbn = new ExDBFieldString<>("zennoutoukeilistkbn", this, UserType_C_ZennouToukeiListKbn.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> zennouwrbkrt = new ExDBFieldString<>("zennouwrbkrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> tndmatutkyrt = new ExDBFieldString<>("tndmatutkyrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> tndzndkhikakukbn = new ExDBFieldString<>("tndzndkhikakukbn", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> zennoukaisiymd = new ExDBFieldString<>("zennoukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, C_ZennouKbn> zennoukbn = new ExDBFieldString<>("zennoukbn", this, UserType_C_ZennouKbn.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> zennoukikan = new ExDBFieldString<>("zennoukikan", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> zennounyuukinymd = new ExDBFieldString<>("zennounyuukinymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> zennounyuukinkgk = new ExDBFieldBizCurrency<>("zennounyuukinkgk", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> toukimatuzennouzndk = new ExDBFieldBizCurrency<>("toukimatuzennouzndk", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> toukijyuutoup = new ExDBFieldBizCurrency<>("toukijyuutoup", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> toukizennouseisangk = new ExDBFieldBizCurrency<>("toukizennouseisangk", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> toukizennounyuukinkgk = new ExDBFieldBizCurrency<>("toukizennounyuukinkgk", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> yokukinenbaraip = new ExDBFieldBizCurrency<>("yokukinenbaraip", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> wrbkrttkyrt = new ExDBFieldBizCurrency<>("wrbkrttkyrt", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> gkdtznnhyj = new ExDBFieldString<>("gkdtznnhyj", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> znngaikakbn = new ExDBFieldString<>("znngaikakbn", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> yenkanyknhyj = new ExDBFieldString<>("yenkanyknhyj", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> znnnyknjikawaserate = new ExDBFieldString<>("znnnyknjikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizDate> znnnyknjikawaseratetkyuymd = new ExDBFieldString<>("znnnyknjikawaseratetkyuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> ksnkisikawaserate = new ExDBFieldString<>("ksnkisikawaserate", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> znncalckjynymdkwsrate = new ExDBFieldString<>("znncalckjynymdkwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, BizNumber> ksnkimatukawaserate = new ExDBFieldString<>("ksnkimatukawaserate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> zennounyuukinkgktkmatu = new ExDBFieldBizCurrency<>("zennounyuukinkgktkmatu", this);

    public final ExDBFieldBizCurrency<IT_ZennouHoyuuIdouKykDtl> tkmatuznnzndktkmatu = new ExDBFieldBizCurrency<>("tkmatuznnzndktkmatu", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_ZennouHoyuuIdouKykDtl, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
