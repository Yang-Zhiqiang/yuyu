package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.JT_SiDshrTuki;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HaitoukinsksKbn;
import yuyu.def.db.type.UserType_C_HaitoumeisaiKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_NaiteiKakuteiKbn;
import yuyu.def.db.type.UserType_C_SyoriKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_TumitateDSakuseiKbn;

/**
 * 保険金給付金Ｄ支払統計テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiDshrTuki extends AbstractExDBTable<JT_SiDshrTuki> {

    public GenQJT_SiDshrTuki() {
        this("JT_SiDshrTuki");
    }

    public GenQJT_SiDshrTuki(String pAlias) {
        super("JT_SiDshrTuki", JT_SiDshrTuki.class, pAlias);
    }

    public String JT_SiDshrTuki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiDshrTuki, String> dshrtoukeisikibetukey = new ExDBFieldString<>("dshrtoukeisikibetukey", this);

    public final ExDBFieldNumber<JT_SiDshrTuki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_SiDshrTuki, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SiDshrTuki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SiDshrTuki, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SiDshrTuki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<JT_SiDshrTuki, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<JT_SiDshrTuki, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<JT_SiDshrTuki, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> siharaid = new ExDBFieldBizCurrency<>("siharaid", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> syoriymd2 = new ExDBFieldString<>("syoriymd2", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> kinoubetukijyunymd = new ExDBFieldString<>("kinoubetukijyunymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> gengkwari = new ExDBFieldString<>("gengkwari", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> itibushrgk = new ExDBFieldBizCurrency<>("itibushrgk", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> haitoushrkin = new ExDBFieldBizCurrency<>("haitoushrkin", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedruigk = new ExDBFieldBizCurrency<>("kariwariatedruigk", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedgngkkngk = new ExDBFieldBizCurrency<>("kariwariatedgngkkngk", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedshrgk = new ExDBFieldBizCurrency<>("kariwariatedshrgk", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> dkeisanhaitoukin = new ExDBFieldBizCurrency<>("dkeisanhaitoukin", this);

    public final ExDBFieldString<JT_SiDshrTuki, C_NaiteiKakuteiKbn> dkeisannaiteikakuteikbn = new ExDBFieldString<>("dkeisannaiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> haitoushrkingk = new ExDBFieldBizCurrency<>("haitoushrkingk", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedganrikindshr = new ExDBFieldBizCurrency<>("kariwariatedganrikindshr", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tumitated = new ExDBFieldBizCurrency<>("tumitated", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tumitatedmodosimae = new ExDBFieldBizCurrency<>("tumitatedmodosimae", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tumitatedmodosigo = new ExDBFieldBizCurrency<>("tumitatedmodosigo", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tkbthaitou = new ExDBFieldBizCurrency<>("tkbthaitou", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizDateY> haitounendo2 = new ExDBFieldString<>("haitounendo2", this, BizDateYType.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_HaitoukinsksKbn> haitoukinskskbn = new ExDBFieldString<>("haitoukinskskbn", this, UserType_C_HaitoukinsksKbn.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_HaitoumeisaiKbn> haitoumeisaikbn = new ExDBFieldString<>("haitoumeisaikbn", this, UserType_C_HaitoumeisaiKbn.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDateY> fstkariwariatednendo = new ExDBFieldString<>("fstkariwariatednendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tounendod = new ExDBFieldBizCurrency<>("tounendod", this);

    public final ExDBFieldString<JT_SiDshrTuki, C_NaiteiKakuteiKbn> naiteikakuteikbn = new ExDBFieldString<>("naiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> kariwariatedshrymd = new ExDBFieldString<>("kariwariatedshrymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedruigk2 = new ExDBFieldBizCurrency<>("kariwariatedruigk2", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedgngkkngk2 = new ExDBFieldBizCurrency<>("kariwariatedgngkkngk2", this);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> kariwariatedshrgk2 = new ExDBFieldBizCurrency<>("kariwariatedshrgk2", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> tumitatedtumitateymd = new ExDBFieldString<>("tumitatedtumitateymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_TumitateDSakuseiKbn> tumitatedskskbn = new ExDBFieldString<>("tumitatedskskbn", this, UserType_C_TumitateDSakuseiKbn.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> tumitated2 = new ExDBFieldBizCurrency<>("tumitated2", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizDate> tumitatedshrkrkymd = new ExDBFieldString<>("tumitatedshrkrkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDshrTuki, C_NaiteiKakuteiKbn> naiteikakuteikbn2 = new ExDBFieldString<>("naiteikakuteikbn2", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> haitouganrikincalckari = new ExDBFieldBizCurrency<>("haitouganrikincalckari", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> kariwariatedriritu1 = new ExDBFieldString<>("kariwariatedriritu1", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> kariwariatedriritu2 = new ExDBFieldString<>("kariwariatedriritu2", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<JT_SiDshrTuki> haitouganrikincalctumi = new ExDBFieldBizCurrency<>("haitouganrikincalctumi", this);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> tumitatedriritu1 = new ExDBFieldString<>("tumitatedriritu1", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiDshrTuki, BizNumber> tumitatedriritu2 = new ExDBFieldString<>("tumitatedriritu2", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiDshrTuki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiDshrTuki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiDshrTuki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
