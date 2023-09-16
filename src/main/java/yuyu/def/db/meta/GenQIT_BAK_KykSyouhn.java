package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_6daiLdKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;
import yuyu.def.db.type.UserType_C_KhnkyhkgbairituKbn;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_Nenkinsyu;
import yuyu.def.db.type.UserType_C_PmnjtkKbn;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_SyukyhkinkataKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TmttknhaibunjyoutaiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 契約商品バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KykSyouhn extends AbstractExDBTable<IT_BAK_KykSyouhn> {

    public GenQIT_BAK_KykSyouhn() {
        this("IT_BAK_KykSyouhn");
    }

    public GenQIT_BAK_KykSyouhn(String pAlias) {
        super("IT_BAK_KykSyouhn", IT_BAK_KykSyouhn.class, pAlias);
    }

    public String IT_BAK_KykSyouhn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_UmuKbn> kykymdsiteiumukbn = new ExDBFieldString<>("kykymdsiteiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> gansknnkaisiymd = new ExDBFieldString<>("gansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> hksknnkaisiymd = new ExDBFieldString<>("hksknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> hkgansknnkaisiymd = new ExDBFieldString<>("hkgansknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_HknkknsmnKbn> hknkknsmnkbn = new ExDBFieldString<>("hknkknsmnkbn", this, UserType_C_HknkknsmnKbn.class);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_HrkkknsmnKbn> hrkkknsmnkbn = new ExDBFieldString<>("hrkkknsmnkbn", this, UserType_C_HrkkknsmnKbn.class);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> haraimanymd = new ExDBFieldString<>("haraimanymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> hknkknmanryouymd = new ExDBFieldString<>("hknkknmanryouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_SyukyhkinkataKbn> syukyhkinkatakbn = new ExDBFieldString<>("syukyhkinkatakbn", this, UserType_C_SyukyhkinkataKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_KhnkyhkgbairituKbn> khnkyhkgbairitukbn = new ExDBFieldString<>("khnkyhkgbairitukbn", this, UserType_C_KhnkyhkgbairituKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_6daiLdKbn> rokudaildkbn = new ExDBFieldString<>("rokudaildkbn", this, UserType_C_6daiLdKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_PmnjtkKbn> pmnjtkkbn = new ExDBFieldString<>("pmnjtkkbn", this, UserType_C_PmnjtkKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KykSyouhn> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldBizCurrency<IT_BAK_KykSyouhn> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> yoteirrthendohosyurrt = new ExDBFieldString<>("yoteirrthendohosyurrt", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> ytirrthndmnskaisuu = new ExDBFieldNumber<>("ytirrthndmnskaisuu", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> kyksjkkktyouseiriritu = new ExDBFieldString<>("kyksjkkktyouseiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Nenkinsyu> nksyukbn = new ExDBFieldString<>("nksyukbn", this, UserType_C_Nenkinsyu.class);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> nenkinkkn = new ExDBFieldNumber<>("nenkinkkn", this);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> nkgnshosyouritu = new ExDBFieldNumber<>("nkgnshosyouritu", this);

    public final ExDBFieldBizCurrency<IT_BAK_KykSyouhn> nkgnshosyougk = new ExDBFieldBizCurrency<>("nkgnshosyougk", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldBizCurrency<IT_BAK_KykSyouhn> gengakugoyenitijibrpstgk = new ExDBFieldBizCurrency<>("gengakugoyenitijibrpstgk", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> yendthnkymd = new ExDBFieldString<>("yendthnkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> setteibairitu = new ExDBFieldString<>("setteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> kykjisisuurendourate = new ExDBFieldString<>("kykjisisuurendourate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> tmttknzoukaritujygn = new ExDBFieldString<>("tmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_TmttknhaibunjyoutaiKbn> tmttknhaibunjyoutai = new ExDBFieldString<>("tmttknhaibunjyoutai", this, UserType_C_TmttknhaibunjyoutaiKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_UmuKbn> gsbunrikzkakuninumu = new ExDBFieldString<>("gsbunrikzkakuninumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, C_UmuKbn> gsbunritaisyou = new ExDBFieldString<>("gsbunritaisyou", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<IT_BAK_KykSyouhn> pharaikomisougaku = new ExDBFieldBizCurrency<>("pharaikomisougaku", this);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizDate> tmttknitenymd = new ExDBFieldString<>("tmttknitenymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> loadinghnkgtumitateriritu = new ExDBFieldString<>("loadinghnkgtumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> rendouritu = new ExDBFieldString<>("rendouritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykSyouhn, BizNumber> teikishrritu = new ExDBFieldString<>("teikishrritu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_BAK_KykSyouhn, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);
}
