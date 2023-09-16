package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BknTyousaFSyoriKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_SyouhnsyuruiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BknJkuKbn;
import yuyu.def.db.type.UserType_C_BknTyousaFSyoriKbn;
import yuyu.def.db.type.UserType_C_BkncdKbn;
import yuyu.def.db.type.UserType_C_BknrigiKbn;
import yuyu.def.db.type.UserType_C_HokenkinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_HubiJyoukyouKbn;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_SUketoriHouhouKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SeisankinKanritukaKbn;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SiinKbn;
import yuyu.def.db.type.UserType_C_SyouhnsyuruiKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 保険金給付金備金管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiBikinkanri extends AbstractExDBTable<JT_SiBikinkanri> {

    public GenQJT_SiBikinkanri() {
        this("JT_SiBikinkanri");
    }

    public GenQJT_SiBikinkanri(String pAlias) {
        super("JT_SiBikinkanri", JT_SiBikinkanri.class, pAlias);
    }

    public String JT_SiBikinkanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiBikinkanri, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SiBikinkanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> kessankijyunymd = new ExDBFieldString<>("kessankijyunymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_BkncdKbn> bkncdkbn = new ExDBFieldString<>("bkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> bknkktymd = new ExDBFieldString<>("bknkktymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_BknrigiKbn> bknrigikbn = new ExDBFieldString<>("bknrigikbn", this, UserType_C_BknrigiKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> syoruiukeymd = new ExDBFieldString<>("syoruiukeymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> hubikanryouymd = new ExDBFieldString<>("hubikanryouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SyouhnsyuruiKbn> syouhnsyuruikbn = new ExDBFieldString<>("syouhnsyuruikbn", this, UserType_C_SyouhnsyuruiKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JT_SiBikinkanri, String> kyuuhuname = new ExDBFieldString<>("kyuuhuname", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> bkngk = new ExDBFieldBizCurrency<>("bkngk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> shrumu = new ExDBFieldString<>("shrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> sinsaumukbn = new ExDBFieldString<>("sinsaumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> soukiumukbn = new ExDBFieldString<>("soukiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> syoumetuumukbn = new ExDBFieldString<>("syoumetuumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_HubiJyoukyouKbn> hubijyoukyoukbn = new ExDBFieldString<>("hubijyoukyoukbn", this, UserType_C_HubiJyoukyouKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_BknJkuKbn> bknjkukbn = new ExDBFieldString<>("bknjkukbn", this, UserType_C_BknJkuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> shrsyoriymd = new ExDBFieldString<>("shrsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> tyakkinymd = new ExDBFieldString<>("tyakkinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_Tuukasyu> shrtuukasyu = new ExDBFieldString<>("shrtuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> shrkwsratekjnymd = new ExDBFieldString<>("shrkwsratekjnymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizNumber> shrkwsrate = new ExDBFieldString<>("shrkwsrate", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> sitihsyutkyumaeyenhknkngk = new ExDBFieldBizCurrency<>("sitihsyutkyumaeyenhknkngk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> siboukaritrkymd = new ExDBFieldString<>("siboukaritrkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_HushrGeninKbn> hushrgeninkbn = new ExDBFieldString<>("hushrgeninkbn", this, UserType_C_HushrGeninKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SiinKbn> siinkbn = new ExDBFieldString<>("siinkbn", this, UserType_C_SiinKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> kinoussnm = new ExDBFieldString<>("kinoussnm", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_SUketoriHouhouKbn> suketorihouhoukbn = new ExDBFieldString<>("suketorihouhoukbn", this, UserType_C_SUketoriHouhouKbn.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> tutakngk = new ExDBFieldBizCurrency<>("tutakngk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yentutakngk = new ExDBFieldBizCurrency<>("yentutakngk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> kaiyakuhr = new ExDBFieldBizCurrency<>("kaiyakuhr", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkaiyakuhr = new ExDBFieldBizCurrency<>("yenkaiyakuhr", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_NoinitUmuKbn> gengkumukbn = new ExDBFieldString<>("gengkumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> gengkymd = new ExDBFieldString<>("gengkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> jisatumensekiumukbn = new ExDBFieldString<>("jisatumensekiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_BkncdKbn> syuukeiyoubkncdkbn = new ExDBFieldString<>("syuukeiyoubkncdkbn", this, UserType_C_BkncdKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_HokenkinsyuruiKbn> hokenkinsyuruikbn = new ExDBFieldString<>("hokenkinsyuruikbn", this, UserType_C_HokenkinsyuruiKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_BknTyousaFSyoriKbn> bkntyousafsyorikbn = new ExDBFieldString<>("bkntyousafsyorikbn", this, UserType_C_BknTyousaFSyoriKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> bknkktinnd = new ExDBFieldString<>("bknkktinnd", this);

    public final ExDBFieldString<JT_SiBikinkanri, BizDateYM> bknkktiym = new ExDBFieldString<>("bknkktiym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> zennouseisankinumukbn = new ExDBFieldString<>("zennouseisankinumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> zennouseisankgk = new ExDBFieldBizCurrency<>("zennouseisankgk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkazennouseisankgk = new ExDBFieldBizCurrency<>("yenkazennouseisankgk", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> mikeikapumukbn = new ExDBFieldString<>("mikeikapumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> mikeikap = new ExDBFieldBizCurrency<>("mikeikap", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkamikeikap = new ExDBFieldBizCurrency<>("yenkamikeikap", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_UmuKbn> misyuupumukbn = new ExDBFieldString<>("misyuupumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, BizDateYM> misyuupjyuutouym = new ExDBFieldString<>("misyuupjyuutouym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> misyuup = new ExDBFieldBizCurrency<>("misyuup", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkamisyuup = new ExDBFieldBizCurrency<>("yenkamisyuup", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> syonendojikaiikoup = new ExDBFieldBizCurrency<>("syonendojikaiikoup", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkasyonendojikaiikoup = new ExDBFieldBizCurrency<>("yenkasyonendojikaiikoup", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> jinendoikoup = new ExDBFieldBizCurrency<>("jinendoikoup", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkajinendoikoup = new ExDBFieldBizCurrency<>("yenkajinendoikoup", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> seisankgk = new ExDBFieldBizCurrency<>("seisankgk", this);

    public final ExDBFieldBizCurrency<JT_SiBikinkanri> yenkaseisankgk = new ExDBFieldBizCurrency<>("yenkaseisankgk", this);

    public final ExDBFieldString<JT_SiBikinkanri, C_SeisankinKanritukaKbn> msyupknrtuukakbn = new ExDBFieldString<>("msyupknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SeisankinKanritukaKbn> mikeikapknrtuukakbn = new ExDBFieldString<>("mikeikapknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, C_SeisankinKanritukaKbn> znnusisnkinknrtuukakbn = new ExDBFieldString<>("znnusisnkinknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JT_SiBikinkanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiBikinkanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiBikinkanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
