package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KituenKbn;
import yuyu.def.classification.C_SinsaKbn;
import yuyu.def.classification.C_SinsabaKbn;
import yuyu.def.classification.C_Sinsatime;
import yuyu.def.classification.C_SyosaiKbn;
import yuyu.def.classification.C_TakuouKbn;
import yuyu.def.db.entity.HT_Houjyou;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KituenKbn;
import yuyu.def.db.type.UserType_C_SinsaKbn;
import yuyu.def.db.type.UserType_C_SinsabaKbn;
import yuyu.def.db.type.UserType_C_Sinsatime;
import yuyu.def.db.type.UserType_C_SyosaiKbn;
import yuyu.def.db.type.UserType_C_TakuouKbn;

/**
 * 報状テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Houjyou extends AbstractExDBTable<HT_Houjyou> {

    public GenQHT_Houjyou() {
        this("HT_Houjyou");
    }

    public GenQHT_Houjyou(String pAlias) {
        super("HT_Houjyou", HT_Houjyou.class, pAlias);
    }

    public String HT_Houjyou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Houjyou, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_Houjyou, C_SyosaiKbn> syosaikbn = new ExDBFieldString<>("syosaikbn", this, UserType_C_SyosaiKbn.class);

    public final ExDBFieldString<HT_Houjyou, C_SinsaKbn> sinsakbn = new ExDBFieldString<>("sinsakbn", this, UserType_C_SinsaKbn.class);

    public final ExDBFieldString<HT_Houjyou, BizDate> kktymd = new ExDBFieldString<>("kktymd", this, BizDateType.class);

    public final ExDBFieldNumber<HT_Houjyou, Integer> sintyou = new ExDBFieldNumber<>("sintyou", this);

    public final ExDBFieldNumber<HT_Houjyou, Integer> taijyuu = new ExDBFieldNumber<>("taijyuu", this);

    public final ExDBFieldString<HT_Houjyou, C_KituenKbn> kituenkbn = new ExDBFieldString<>("kituenkbn", this, UserType_C_KituenKbn.class);

    public final ExDBFieldNumber<HT_Houjyou, Integer> kituenhon = new ExDBFieldNumber<>("kituenhon", this);

    public final ExDBFieldString<HT_Houjyou, String> sinsaicd = new ExDBFieldString<>("sinsaicd", this);

    public final ExDBFieldString<HT_Houjyou, BizDate> sinsaymd = new ExDBFieldString<>("sinsaymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Houjyou, C_Sinsatime> sinsatime = new ExDBFieldString<>("sinsatime", this, UserType_C_Sinsatime.class);

    public final ExDBFieldString<HT_Houjyou, C_TakuouKbn> takuoukbn = new ExDBFieldString<>("takuoukbn", this, UserType_C_TakuouKbn.class);

    public final ExDBFieldString<HT_Houjyou, C_SinsabaKbn> sinsabakbn = new ExDBFieldString<>("sinsabakbn", this, UserType_C_SinsabaKbn.class);

    public final ExDBFieldString<HT_Houjyou, String> hbcmnt = new ExDBFieldString<>("hbcmnt", this);

    public final ExDBFieldString<HT_Houjyou, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Houjyou, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
