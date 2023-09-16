package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TrhkjiKakKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_HouteiTyotkseiSyouhnHyjKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Kykjyoutai;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_TrhkjiKakKbn;
import yuyu.def.db.type.UserType_C_TtdktyuuiKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YuukousyoumetuKbn;

/**
 * 当日異動内容契約保全一時保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TjtIdouNyKhItjhzn extends AbstractExDBTable<BT_TjtIdouNyKhItjhzn> {

    public GenQBT_TjtIdouNyKhItjhzn() {
        this("BT_TjtIdouNyKhItjhzn");
    }

    public GenQBT_TjtIdouNyKhItjhzn(String pAlias) {
        super("BT_TjtIdouNyKhItjhzn", BT_TjtIdouNyKhItjhzn.class, pAlias);
    }

    public String BT_TjtIdouNyKhItjhzn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKhItjhzn, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKhItjhzn, Integer> recordsakujyohyouji = new ExDBFieldNumber<>("recordsakujyohyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_Tuukasyu> tsntuukasyu = new ExDBFieldString<>("tsntuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKhItjhzn> tsnyousibous = new ExDBFieldBizCurrency<>("tsnyousibous", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKhItjhzn> tsnyouitijip = new ExDBFieldBizCurrency<>("tsnyouitijip", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKhItjhzn> tsnyounkgns = new ExDBFieldBizCurrency<>("tsnyounkgns", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKhItjhzn, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldNumber<BT_TjtIdouNyKhItjhzn, Integer> kykhhkndouhyouji = new ExDBFieldNumber<>("kykhhkndouhyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TtdktyuuiKbn> ttdktyuuikbn1 = new ExDBFieldString<>("ttdktyuuikbn1", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TtdktyuuiKbn> ttdktyuuikbn2 = new ExDBFieldString<>("ttdktyuuikbn2", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TtdktyuuiKbn> ttdktyuuikbn3 = new ExDBFieldString<>("ttdktyuuikbn3", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TtdktyuuiKbn> ttdktyuuikbn4 = new ExDBFieldString<>("ttdktyuuikbn4", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TtdktyuuiKbn> ttdktyuuikbn5 = new ExDBFieldString<>("ttdktyuuikbn5", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldNumber<BT_TjtIdouNyKhItjhzn, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_UmuKbn> kaigomaehrtkykumukbn = new ExDBFieldString<>("kaigomaehrtkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_UmuKbn> pyennykntkykumukbn = new ExDBFieldString<>("pyennykntkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKhItjhzn> tsnyennyknkgk = new ExDBFieldBizCurrency<>("tsnyennyknkgk", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> skjmosno = new ExDBFieldString<>("skjmosno", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_HouteiTyotkseiSyouhnHyjKbn> houteityotkseisyouhnhyj = new ExDBFieldString<>("houteityotkseisyouhnhyj", this, UserType_C_HouteiTyotkseiSyouhnHyjKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_TrhkjiKakKbn> seiritujitrhkjikakkbn = new ExDBFieldString<>("seiritujitrhkjikakkbn", this, UserType_C_TrhkjiKakKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TjtIdouNyKhItjhzn, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
