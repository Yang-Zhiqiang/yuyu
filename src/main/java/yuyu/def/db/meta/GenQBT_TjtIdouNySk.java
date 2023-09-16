package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Mfrenflg;
import yuyu.def.classification.C_MossyoumetuKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BT_TjtIdouNySk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_Mfrenflg;
import yuyu.def.db.type.UserType_C_MossyoumetuKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_SntkhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 当日異動内容新契約テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBT_TjtIdouNySk extends AbstractExDBTable<BT_TjtIdouNySk> {

    public GenQBT_TjtIdouNySk() {
        this("BT_TjtIdouNySk");
    }

    public GenQBT_TjtIdouNySk(String pAlias) {
        super("BT_TjtIdouNySk", BT_TjtIdouNySk.class, pAlias);
    }

    public String BT_TjtIdouNySk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BT_TjtIdouNySk, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<BT_TjtIdouNySk, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<BT_TjtIdouNySk, Integer> recordsakujyohyouji = new ExDBFieldNumber<>("recordsakujyohyouji", this);

    public final ExDBFieldString<BT_TjtIdouNySk, String> youkyuuno = new ExDBFieldString<>("youkyuuno", this);

    public final ExDBFieldString<BT_TjtIdouNySk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BT_TjtIdouNySk, BizDate> mosymd = new ExDBFieldString<>("mosymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNySk, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNySk, BizDate> sknnkaisiymd = new ExDBFieldString<>("sknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNySk, C_SeirituKbn> seiritukbn = new ExDBFieldString<>("seiritukbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<BT_TjtIdouNySk, BizDate> srsyoriymd = new ExDBFieldString<>("srsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<BT_TjtIdouNySk, C_Mfrenflg> mfrenflg = new ExDBFieldString<>("mfrenflg", this, UserType_C_Mfrenflg.class);

    public final ExDBFieldString<BT_TjtIdouNySk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BT_TjtIdouNySk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BT_TjtIdouNySk, C_Tuukasyu> tsntuukasyu = new ExDBFieldString<>("tsntuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNySk> tsnyousibous = new ExDBFieldBizCurrency<>("tsnyousibous", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNySk> tsnyouitijip = new ExDBFieldBizCurrency<>("tsnyouitijip", this);

    public final ExDBFieldBizCurrency<BT_TjtIdouNySk> tsnyounkgns = new ExDBFieldBizCurrency<>("tsnyounkgns", this);

    public final ExDBFieldNumber<BT_TjtIdouNySk, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldString<BT_TjtIdouNySk, C_SntkhouKbn> sntkhoukbn = new ExDBFieldString<>("sntkhoukbn", this, UserType_C_SntkhouKbn.class);

    public final ExDBFieldString<BT_TjtIdouNySk, BizDateYM> bosyuuym = new ExDBFieldString<>("bosyuuym", this, BizDateYMType.class);

    public final ExDBFieldNumber<BT_TjtIdouNySk, Integer> kykhhkndouhyouji = new ExDBFieldNumber<>("kykhhkndouhyouji", this);

    public final ExDBFieldString<BT_TjtIdouNySk, C_MossyoumetuKbn> mossyoumetukbn = new ExDBFieldString<>("mossyoumetukbn", this, UserType_C_MossyoumetuKbn.class);

    public final ExDBFieldNumber<BT_TjtIdouNySk, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BT_TjtIdouNySk, C_UmuKbn> kaigomaehrtkykumukbn = new ExDBFieldString<>("kaigomaehrtkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BT_TjtIdouNySk, C_UmuKbn> pyennykntkykumukbn = new ExDBFieldString<>("pyennykntkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<BT_TjtIdouNySk> tsnyennyknkgk = new ExDBFieldBizCurrency<>("tsnyennyknkgk", this);

    public final ExDBFieldString<BT_TjtIdouNySk, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<BT_TjtIdouNySk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BT_TjtIdouNySk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BT_TjtIdouNySk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
