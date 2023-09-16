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
import yuyu.def.db.entity.IT_KhDshrTuki;
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
 * 契約保全Ｄ支払統計テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhDshrTuki extends AbstractExDBTable<IT_KhDshrTuki> {

    public GenQIT_KhDshrTuki() {
        this("IT_KhDshrTuki");
    }

    public GenQIT_KhDshrTuki(String pAlias) {
        super("IT_KhDshrTuki", IT_KhDshrTuki.class, pAlias);
    }

    public String IT_KhDshrTuki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhDshrTuki, String> dshrtoukeisikibetukey = new ExDBFieldString<>("dshrtoukeisikibetukey", this);

    public final ExDBFieldString<IT_KhDshrTuki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<IT_KhDshrTuki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<IT_KhDshrTuki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_SyoriKbn> syorikbn = new ExDBFieldString<>("syorikbn", this, UserType_C_SyoriKbn.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_KhDshrTuki, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_KhDshrTuki, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<IT_KhDshrTuki, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> siharaid = new ExDBFieldBizCurrency<>("siharaid", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> calckijyunymd = new ExDBFieldString<>("calckijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> syoriymd2 = new ExDBFieldString<>("syoriymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> kinoubetukijyunymd = new ExDBFieldString<>("kinoubetukijyunymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> gengkwari = new ExDBFieldString<>("gengkwari", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> itibushrgk = new ExDBFieldBizCurrency<>("itibushrgk", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> haitoushrkin = new ExDBFieldBizCurrency<>("haitoushrkin", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedruigk = new ExDBFieldBizCurrency<>("kariwariatedruigk", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedgngkkngk = new ExDBFieldBizCurrency<>("kariwariatedgngkkngk", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedshrgk = new ExDBFieldBizCurrency<>("kariwariatedshrgk", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> dkeisanhaitoukin = new ExDBFieldBizCurrency<>("dkeisanhaitoukin", this);

    public final ExDBFieldString<IT_KhDshrTuki, C_NaiteiKakuteiKbn> dkeisannaiteikakuteikbn = new ExDBFieldString<>("dkeisannaiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDateY> haitounendo = new ExDBFieldString<>("haitounendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> haitoushrkingk = new ExDBFieldBizCurrency<>("haitoushrkingk", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedganrikindshr = new ExDBFieldBizCurrency<>("kariwariatedganrikindshr", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tumitated = new ExDBFieldBizCurrency<>("tumitated", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tumitatedmodosimae = new ExDBFieldBizCurrency<>("tumitatedmodosimae", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tumitatedmodosigo = new ExDBFieldBizCurrency<>("tumitatedmodosigo", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tkbthaitou = new ExDBFieldBizCurrency<>("tkbthaitou", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizDateY> haitounendo2 = new ExDBFieldString<>("haitounendo2", this, BizDateYType.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_HaitoukinsksKbn> haitoukinskskbn = new ExDBFieldString<>("haitoukinskskbn", this, UserType_C_HaitoukinsksKbn.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_HaitoumeisaiKbn> haitoumeisaikbn = new ExDBFieldString<>("haitoumeisaikbn", this, UserType_C_HaitoumeisaiKbn.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDateY> fstkariwariatednendo = new ExDBFieldString<>("fstkariwariatednendo", this, BizDateYType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tounendod = new ExDBFieldBizCurrency<>("tounendod", this);

    public final ExDBFieldString<IT_KhDshrTuki, C_NaiteiKakuteiKbn> naiteikakuteikbn = new ExDBFieldString<>("naiteikakuteikbn", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> kariwariatedshrymd = new ExDBFieldString<>("kariwariatedshrymd", this, BizDateType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedruigk2 = new ExDBFieldBizCurrency<>("kariwariatedruigk2", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedgngkkngk2 = new ExDBFieldBizCurrency<>("kariwariatedgngkkngk2", this);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> kariwariatedshrgk2 = new ExDBFieldBizCurrency<>("kariwariatedshrgk2", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> tumitatedtumitateymd = new ExDBFieldString<>("tumitatedtumitateymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_TumitateDSakuseiKbn> tumitatedskskbn = new ExDBFieldString<>("tumitatedskskbn", this, UserType_C_TumitateDSakuseiKbn.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> tumitated2 = new ExDBFieldBizCurrency<>("tumitated2", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizDate> tumitatedshrkrkymd = new ExDBFieldString<>("tumitatedshrkrkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhDshrTuki, C_NaiteiKakuteiKbn> naiteikakuteikbn2 = new ExDBFieldString<>("naiteikakuteikbn2", this, UserType_C_NaiteiKakuteiKbn.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> haitouganrikincalckari = new ExDBFieldBizCurrency<>("haitouganrikincalckari", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> kariwariatedriritu1 = new ExDBFieldString<>("kariwariatedriritu1", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> kariwariatedriritu2 = new ExDBFieldString<>("kariwariatedriritu2", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_KhDshrTuki> haitouganrikincalctumi = new ExDBFieldBizCurrency<>("haitouganrikincalctumi", this);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> tumitatedriritu1 = new ExDBFieldString<>("tumitatedriritu1", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhDshrTuki, BizNumber> tumitatedriritu2 = new ExDBFieldString<>("tumitatedriritu2", this, BizNumberType.class);

    public final ExDBFieldString<IT_KhDshrTuki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhDshrTuki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhDshrTuki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
