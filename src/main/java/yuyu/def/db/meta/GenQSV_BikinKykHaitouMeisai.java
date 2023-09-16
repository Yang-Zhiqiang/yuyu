package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.SV_BikinKykHaitouMeisai;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 備金契約配当明細情報ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQSV_BikinKykHaitouMeisai extends AbstractExDBTable<SV_BikinKykHaitouMeisai> {

    public GenQSV_BikinKykHaitouMeisai() {
        this("SV_BikinKykHaitouMeisai");
    }

    public GenQSV_BikinKykHaitouMeisai(String pAlias) {
        super("SV_BikinKykHaitouMeisai", SV_BikinKykHaitouMeisai.class, pAlias);
    }

    public String SV_BikinKykHaitouMeisai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_TkiktbrisyuruiKbn> tikiktbrisyuruikbn = new ExDBFieldString<>("tikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> bknkktymd = new ExDBFieldString<>("bknkktymd", this, BizDateType.class);

    public final ExDBFieldNumber<SV_BikinKykHaitouMeisai, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_BknrigiKbn> bknrigikbn = new ExDBFieldString<>("bknrigikbn", this, UserType_C_BknrigiKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldBizCurrency<SV_BikinKykHaitouMeisai> bkngk = new ExDBFieldBizCurrency<>("bkngk", this);

    public final ExDBFieldBizCurrency<SV_BikinKykHaitouMeisai> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_UmuKbn> syoriumukbn = new ExDBFieldString<>("syoriumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<SV_BikinKykHaitouMeisai> sitihsyutkyumaeyenhknkngk = new ExDBFieldBizCurrency<>("sitihsyutkyumaeyenhknkngk", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<SV_BikinKykHaitouMeisai, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);
}
