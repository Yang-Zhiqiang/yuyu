package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HenkinriyuuKbn;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HT_Henkin;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HenkinriyuuKbn;
import yuyu.def.db.type.UserType_C_HnknhouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 返金テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Henkin extends AbstractExDBTable<HT_Henkin> {

    public GenQHT_Henkin() {
        this("HT_Henkin");
    }

    public GenQHT_Henkin(String pAlias) {
        super("HT_Henkin", HT_Henkin.class, pAlias);
    }

    public String HT_Henkin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Henkin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_Henkin, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_Henkin, String> hnkninputrenno = new ExDBFieldString<>("hnkninputrenno", this);

    public final ExDBFieldString<HT_Henkin, BizDate> hnknsyoriymd = new ExDBFieldString<>("hnknsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Henkin, String> henkinsyoritime = new ExDBFieldString<>("henkinsyoritime", this);

    public final ExDBFieldBizCurrency<HT_Henkin> hnkngk = new ExDBFieldBizCurrency<>("hnkngk", this);

    public final ExDBFieldString<HT_Henkin, C_Tuukasyu> hnkntuukasyu = new ExDBFieldString<>("hnkntuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HT_Henkin, BizDate> pkakinsyoriymd = new ExDBFieldString<>("pkakinsyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Henkin, C_HnknhouKbn> hnknhoukbn = new ExDBFieldString<>("hnknhoukbn", this, UserType_C_HnknhouKbn.class);

    public final ExDBFieldString<HT_Henkin, BizDate> hnknymd = new ExDBFieldString<>("hnknymd", this, BizDateType.class);

    public final ExDBFieldString<HT_Henkin, C_HenkinriyuuKbn> hnknriyuukbn = new ExDBFieldString<>("hnknriyuukbn", this, UserType_C_HenkinriyuuKbn.class);

    public final ExDBFieldString<HT_Henkin, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HT_Henkin, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HT_Henkin, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HT_Henkin, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HT_Henkin, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<HT_Henkin, C_UmuKbn> srgohnknumu = new ExDBFieldString<>("srgohnknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_Henkin, String> denrenno = new ExDBFieldString<>("denrenno", this);

    public final ExDBFieldNumber<HT_Henkin, Integer> edano = new ExDBFieldNumber<>("edano", this);

    public final ExDBFieldString<HT_Henkin, String> pkakindenrenno = new ExDBFieldString<>("pkakindenrenno", this);

    public final ExDBFieldNumber<HT_Henkin, Integer> pkakindenedano = new ExDBFieldNumber<>("pkakindenedano", this);

    public final ExDBFieldString<HT_Henkin, String> fbsoukindatasikibetukey = new ExDBFieldString<>("fbsoukindatasikibetukey", this);

    public final ExDBFieldNumber<HT_Henkin, Integer> zenhnknrenno = new ExDBFieldNumber<>("zenhnknrenno", this);

    public final ExDBFieldString<HT_Henkin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Henkin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
