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
import yuyu.def.db.entity.BT_TjtIdouNyKh;
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
 * 当日異動内容契約保全テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TjtIdouNyKh extends AbstractExDBTable<BT_TjtIdouNyKh> {

    public GenQBT_TjtIdouNyKh() {
        this("BT_TjtIdouNyKh");
    }

    public GenQBT_TjtIdouNyKh(String pAlias) {
        super("BT_TjtIdouNyKh", BT_TjtIdouNyKh.class, pAlias);
    }

    public String BT_TjtIdouNyKh() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TjtIdouNyKh, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKh, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKh, Integer> recordsakujyohyouji = new ExDBFieldNumber<>("recordsakujyohyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_Kykjyoutai> kykjyoutai = new ExDBFieldString<>("kykjyoutai", this, UserType_C_Kykjyoutai.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_YuukousyoumetuKbn> yuukousyoumetukbn = new ExDBFieldString<>("yuukousyoumetukbn", this, UserType_C_YuukousyoumetuKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, BizDate> syoumetuymd = new ExDBFieldString<>("syoumetuymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_Tuukasyu> tsntuukasyu = new ExDBFieldString<>("tsntuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKh> tsnyousibous = new ExDBFieldBizCurrency<>("tsnyousibous", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKh> tsnyouitijip = new ExDBFieldBizCurrency<>("tsnyouitijip", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKh> tsnyounkgns = new ExDBFieldBizCurrency<>("tsnyounkgns", this);

    public final ExDBFieldNumber<BT_TjtIdouNyKh, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldNumber<BT_TjtIdouNyKh, Integer> kykhhkndouhyouji = new ExDBFieldNumber<>("kykhhkndouhyouji", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TtdktyuuiKbn> ttdktyuuikbn1 = new ExDBFieldString<>("ttdktyuuikbn1", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TtdktyuuiKbn> ttdktyuuikbn2 = new ExDBFieldString<>("ttdktyuuikbn2", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TtdktyuuiKbn> ttdktyuuikbn3 = new ExDBFieldString<>("ttdktyuuikbn3", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TtdktyuuiKbn> ttdktyuuikbn4 = new ExDBFieldString<>("ttdktyuuikbn4", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TtdktyuuiKbn> ttdktyuuikbn5 = new ExDBFieldString<>("ttdktyuuikbn5", this, UserType_C_TtdktyuuiKbn.class);

    public final ExDBFieldNumber<BT_TjtIdouNyKh, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_UmuKbn> kaigomaehrtkykumukbn = new ExDBFieldString<>("kaigomaehrtkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_UmuKbn> pyennykntkykumukbn = new ExDBFieldString<>("pyennykntkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNyKh> tsnyennyknkgk = new ExDBFieldBizCurrency<>("tsnyennyknkgk", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> skjmosno = new ExDBFieldString<>("skjmosno", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_HouteiTyotkseiSyouhnHyjKbn> houteityotkseisyouhnhyj = new ExDBFieldString<>("houteityotkseisyouhnhyj", this, UserType_C_HouteiTyotkseiSyouhnHyjKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_TrhkjiKakKbn> seiritujitrhkjikakkbn = new ExDBFieldString<>("seiritujitrhkjikakkbn", this, UserType_C_TrhkjiKakKbn.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TjtIdouNyKh, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
