package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 保険証券付加情報データテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_HokenSyoukenHukaInfo extends AbstractExDBTable<IT_HokenSyoukenHukaInfo> {

    public GenQIT_HokenSyoukenHukaInfo() {
        this("IT_HokenSyoukenHukaInfo");
    }

    public GenQIT_HokenSyoukenHukaInfo(String pAlias) {
        super("IT_HokenSyoukenHukaInfo", IT_HokenSyoukenHukaInfo.class, pAlias);
    }

    public String IT_HokenSyoukenHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> nksyuruinmsyouken = new ExDBFieldString<>("nksyuruinmsyouken", this);

    public final ExDBFieldNumber<IT_HokenSyoukenHukaInfo, Integer> teikiikkatubaraitukisuu = new ExDBFieldNumber<>("teikiikkatubaraitukisuu", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> znntikiktbriyhrkgktuktype = new ExDBFieldString<>("znntikiktbriyhrkgktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> znntikiktbriyenhrkgk = new ExDBFieldBizCurrency<>("znntikiktbriyenhrkgk", this);

    public final ExDBFieldNumber<IT_HokenSyoukenHukaInfo, Integer> znnkai2 = new ExDBFieldNumber<>("znnkai2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizNumber> hutanhiyustmkyakkjrtmin = new ExDBFieldString<>("hutanhiyustmkyakkjrtmin", this, BizNumberType.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizNumber> hutanhiyustmkyakkjrtmax = new ExDBFieldString<>("hutanhiyustmkyakkjrtmax", this, BizNumberType.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> fstpznnkngktuktype = new ExDBFieldString<>("fstpznnkngktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> fstpznnkngk = new ExDBFieldBizCurrency<>("fstpznnkngk", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dskjnkngkktuktype = new ExDBFieldString<>("dskjnkngkktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dskjnkngk = new ExDBFieldBizCurrency<>("dskjnkngk", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> tikiktbriyhrkgktuktype = new ExDBFieldString<>("tikiktbriyhrkgktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> tikiktbriyenhrkgk = new ExDBFieldBizCurrency<>("tikiktbriyenhrkgk", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_UmuKbn> kzktirasidouhuukbn1 = new ExDBFieldString<>("kzktirasidouhuukbn1", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_UmuKbn> kzktirasidouhuukbn2 = new ExDBFieldString<>("kzktirasidouhuukbn2", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_UmuKbn> kykdairitirasidouhuukbn = new ExDBFieldString<>("kykdairitirasidouhuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_UmuKbn> skhtirasidouhuukbn = new ExDBFieldString<>("skhtirasidouhuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> yakkannewoldkbn = new ExDBFieldString<>("yakkannewoldkbn", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg1 = new ExDBFieldString<>("kzktourokuservicemsg1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg2 = new ExDBFieldString<>("kzktourokuservicemsg2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg3 = new ExDBFieldString<>("kzktourokuservicemsg3", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg4 = new ExDBFieldString<>("kzktourokuservicemsg4", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg5 = new ExDBFieldString<>("kzktourokuservicemsg5", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg6 = new ExDBFieldString<>("kzktourokuservicemsg6", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg7 = new ExDBFieldString<>("kzktourokuservicemsg7", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kzktourokuservicemsg8 = new ExDBFieldString<>("kzktourokuservicemsg8", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzknmkj118 = new ExDBFieldString<>("trkkzknmkj118", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Seibetu> trkkzksei1 = new ExDBFieldString<>("trkkzksei1", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizDate> trkkzkseiymd1 = new ExDBFieldString<>("trkkzkseiymd1", this, BizDateType.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkyno1 = new ExDBFieldString<>("trkkzkyno1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr1kj1 = new ExDBFieldString<>("trkkzkadr1kj1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr2kj1 = new ExDBFieldString<>("trkkzkadr2kj1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr3kj1 = new ExDBFieldString<>("trkkzkadr3kj1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzktelno1 = new ExDBFieldString<>("trkkzktelno1", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Seibetu> trkkzksei2 = new ExDBFieldString<>("trkkzksei2", this, UserType_C_Seibetu.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzknmkj218 = new ExDBFieldString<>("trkkzknmkj218", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizDate> trkkzkseiymd2 = new ExDBFieldString<>("trkkzkseiymd2", this, BizDateType.class);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkyno2 = new ExDBFieldString<>("trkkzkyno2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr1kj2 = new ExDBFieldString<>("trkkzkadr1kj2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr2kj2 = new ExDBFieldString<>("trkkzkadr2kj2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzkadr3kj2 = new ExDBFieldString<>("trkkzkadr3kj2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> trkkzktelno2 = new ExDBFieldString<>("trkkzktelno2", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> kykdairinm18 = new ExDBFieldString<>("kykdairinm18", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, String> hhkndairinm = new ExDBFieldString<>("hhkndairinm", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, BizNumber> rendouritu = new ExDBFieldString<>("rendouritu", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> teikisiharaikin = new ExDBFieldBizCurrency<>("teikisiharaikin", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgkyentype = new ExDBFieldString<>("dai1sbjiuktgkyentype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk01 = new ExDBFieldBizCurrency<>("dai1zennouzndk01", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype01 = new ExDBFieldString<>("dai1zennouzndktype01", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk01 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk01", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype01 = new ExDBFieldString<>("dai1sbjiuktgktype01", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka01 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun01 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu01 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk02 = new ExDBFieldBizCurrency<>("dai1zennouzndk02", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype02 = new ExDBFieldString<>("dai1zennouzndktype02", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk02 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk02", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype02 = new ExDBFieldString<>("dai1sbjiuktgktype02", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka02 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun02 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu02 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk03 = new ExDBFieldBizCurrency<>("dai1zennouzndk03", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype03 = new ExDBFieldString<>("dai1zennouzndktype03", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk03 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk03", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype03 = new ExDBFieldString<>("dai1sbjiuktgktype03", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka03 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun03 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu03 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk04 = new ExDBFieldBizCurrency<>("dai1zennouzndk04", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype04 = new ExDBFieldString<>("dai1zennouzndktype04", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk04 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk04", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype04 = new ExDBFieldString<>("dai1sbjiuktgktype04", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka04 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun04 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu04 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk05 = new ExDBFieldBizCurrency<>("dai1zennouzndk05", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype05 = new ExDBFieldString<>("dai1zennouzndktype05", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk05 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk05", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype05 = new ExDBFieldString<>("dai1sbjiuktgktype05", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka05 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun05 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu05 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1zennouzndk06 = new ExDBFieldBizCurrency<>("dai1zennouzndk06", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1zennouzndktype06 = new ExDBFieldString<>("dai1zennouzndktype06", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgk06 = new ExDBFieldBizCurrency<>("dai1sbjiuktgk06", this);

    public final ExDBFieldString<IT_HokenSyoukenHukaInfo, C_Tuukasyu> dai1sbjiuktgktype06 = new ExDBFieldString<>("dai1sbjiuktgktype06", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyendaka06 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyendaka06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenkijyun06 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenkijyun06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> dai1sbjiuktgkyenyasu06 = new ExDBFieldBizCurrency<>("dai1sbjiuktgkyenyasu06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka01 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka02 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka03 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka04 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka05 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka06 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka07 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka07", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka08 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka08", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka09 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka09", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkydaka10 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkydaka10", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun01 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun02 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun03 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun04 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun05 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun06 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun07 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun07", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun08 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun08", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun09 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun09", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkykijyun10 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkykijyun10", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu01 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu01", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu02 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu02", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu03 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu03", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu04 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu04", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu05 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu05", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu06 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu06", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu07 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu07", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu08 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu08", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu09 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu09", this);

    public final ExDBFieldBizCurrency<IT_HokenSyoukenHukaInfo> kaigomaehrjrugkyyasu10 = new ExDBFieldBizCurrency<>("kaigomaehrjrugkyyasu10", this);
}
