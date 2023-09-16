package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AnkenJyoutaiKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KykSyubetuKbn;
import yuyu.def.classification.C_LincSyoukaiSyubetuKbn;
import yuyu.def.classification.C_LinchhknseiKbn;
import yuyu.def.db.entity.HT_SkLincSyoukaikekka;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AnkenJyoutaiKbn;
import yuyu.def.db.type.UserType_C_KykKbn;
import yuyu.def.db.type.UserType_C_KykSyubetuKbn;
import yuyu.def.db.type.UserType_C_LincSyoukaiSyubetuKbn;
import yuyu.def.db.type.UserType_C_LinchhknseiKbn;

/**
 * 新契約ＬＩＮＣ他社照会結果テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkLincSyoukaikekka extends AbstractExDBTable<HT_SkLincSyoukaikekka> {

    public GenQHT_SkLincSyoukaikekka() {
        this("HT_SkLincSyoukaikekka");
    }

    public GenQHT_SkLincSyoukaikekka(String pAlias) {
        super("HT_SkLincSyoukaikekka", HT_SkLincSyoukaikekka.class, pAlias);
    }

    public String HT_SkLincSyoukaikekka() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> lincjyusintrrenno = new ExDBFieldString<>("lincjyusintrrenno", this);

    public final ExDBFieldNumber<HT_SkLincSyoukaikekka, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, C_AnkenJyoutaiKbn> ankenjyoutai = new ExDBFieldString<>("ankenjyoutai", this, UserType_C_AnkenJyoutaiKbn.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, C_KykSyubetuKbn> kyksyubetu = new ExDBFieldString<>("kyksyubetu", this, UserType_C_KykSyubetuKbn.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> lincsousinmotokaisya = new ExDBFieldString<>("lincsousinmotokaisya", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, C_KykKbn> kykkbn = new ExDBFieldString<>("kykkbn", this, UserType_C_KykKbn.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> kyknmlinckn = new ExDBFieldString<>("kyknmlinckn", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> kyknmlinckj = new ExDBFieldString<>("kyknmlinckj", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> hhknnmlinckn = new ExDBFieldString<>("hhknnmlinckn", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> hhknnmlinckj = new ExDBFieldString<>("hhknnmlinckj", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, C_LinchhknseiKbn> linchhknseikbn = new ExDBFieldString<>("linchhknseikbn", this, UserType_C_LinchhknseiKbn.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> hhknadrlinckn30 = new ExDBFieldString<>("hhknadrlinckn30", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, BizDate> keiyakuymd = new ExDBFieldString<>("keiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, BizDate> trkmousideymd = new ExDBFieldString<>("trkmousideymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> sgnyung = new ExDBFieldBizCurrency<>("sgnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> sipnyung = new ExDBFieldBizCurrency<>("sipnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> sjnyung = new ExDBFieldBizCurrency<>("sjnyung", this);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> sonotanyuinng = new ExDBFieldBizCurrency<>("sonotanyuinng", this);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> hutuusb = new ExDBFieldBizCurrency<>("hutuusb", this);

    public final ExDBFieldBizCurrency<HT_SkLincSyoukaikekka> sgsbksns = new ExDBFieldBizCurrency<>("sgsbksns", this);

    public final ExDBFieldNumber<HT_SkLincSyoukaikekka, Long> kanyuusyano = new ExDBFieldNumber<>("kanyuusyano", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> linckykkanrino = new ExDBFieldString<>("linckykkanrino", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, C_LincSyoukaiSyubetuKbn> lincsyoukaisyubetu = new ExDBFieldString<>("lincsyoukaisyubetu", this, UserType_C_LincSyoukaiSyubetuKbn.class);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkLincSyoukaikekka, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
