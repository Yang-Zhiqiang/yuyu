package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HokenkinsyuruiKbn;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_KyhkinTaniKbn;
import yuyu.def.db.type.UserType_C_KyuuhuKbn;
import yuyu.def.db.type.UserType_C_NitigakuHokenKngkKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払明細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiDetail extends AbstractExDBTable<JT_SiDetail> {

    public GenQJT_SiDetail() {
        this("JT_SiDetail");
    }

    public GenQJT_SiDetail(String pAlias) {
        super("JT_SiDetail", JT_SiDetail.class, pAlias);
    }

    public String JT_SiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiDetail, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SiDetail, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldString<JT_SiDetail, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<JT_SiDetail, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JT_SiDetail, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldNumber<JT_SiDetail, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> kyksyouhnrenno = new ExDBFieldNumber<>("kyksyouhnrenno", this);

    public final ExDBFieldString<JT_SiDetail, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<JT_SiDetail, C_KyuuhuKbn> kyuuhukbn = new ExDBFieldString<>("kyuuhukbn", this, UserType_C_KyuuhuKbn.class);

    public final ExDBFieldString<JT_SiDetail, C_HokenkinsyuruiKbn> hokenkinsyuruikbn = new ExDBFieldString<>("hokenkinsyuruikbn", this, UserType_C_HokenkinsyuruiKbn.class);

    public final ExDBFieldString<JT_SiDetail, C_Kanjyoukmkcd> kanjyoukmkcd = new ExDBFieldString<>("kanjyoukmkcd", this, UserType_C_Kanjyoukmkcd.class);

    public final ExDBFieldString<JT_SiDetail, C_UmuKbn> checktaisyouumukbn = new ExDBFieldString<>("checktaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiDetail, C_NitigakuHokenKngkKbn> nitigakuhokenkngkkbn = new ExDBFieldString<>("nitigakuhokenkngkkbn", this, UserType_C_NitigakuHokenKngkKbn.class);

    public final ExDBFieldBizCurrency<JT_SiDetail> nitigakuhokenkngk = new ExDBFieldBizCurrency<>("nitigakuhokenkngk", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> nissuubairitu = new ExDBFieldNumber<>("nissuubairitu", this);

    public final ExDBFieldString<JT_SiDetail, C_KyhkinTaniKbn> kyhkintanikbn = new ExDBFieldString<>("kyhkintanikbn", this, UserType_C_KyhkinTaniKbn.class);

    public final ExDBFieldBizCurrency<JT_SiDetail> kyhkg = new ExDBFieldBizCurrency<>("kyhkg", this);

    public final ExDBFieldBizCurrency<JT_SiDetail> yenkyhgk = new ExDBFieldBizCurrency<>("yenkyhgk", this);

    public final ExDBFieldBizCurrency<JT_SiDetail> sitihsyutkyumaeyenhknkngk = new ExDBFieldBizCurrency<>("sitihsyutkyumaeyenhknkngk", this);

    public final ExDBFieldNumber<JT_SiDetail, Integer> hutanponissuu = new ExDBFieldNumber<>("hutanponissuu", this);

    public final ExDBFieldString<JT_SiDetail, BizDate> shrriyuugaitouymd = new ExDBFieldString<>("shrriyuugaitouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiDetail, C_UmuKbn> hknskgnkkntgtumukbn = new ExDBFieldString<>("hknskgnkkntgtumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiDetail, BizNumber> hokenkinshrwariai = new ExDBFieldString<>("hokenkinshrwariai", this, BizNumberType.class);

    public final ExDBFieldString<JT_SiDetail, String> bikoumsg1 = new ExDBFieldString<>("bikoumsg1", this);

    public final ExDBFieldString<JT_SiDetail, String> bikoumsg2 = new ExDBFieldString<>("bikoumsg2", this);

    public final ExDBFieldString<JT_SiDetail, String> bikoumsg3 = new ExDBFieldString<>("bikoumsg3", this);

    public final ExDBFieldString<JT_SiDetail, String> bikoumsg4 = new ExDBFieldString<>("bikoumsg4", this);

    public final ExDBFieldString<JT_SiDetail, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SiDetail, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
