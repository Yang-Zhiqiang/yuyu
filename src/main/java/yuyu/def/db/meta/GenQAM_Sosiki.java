package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SosikiNmKbn;
import yuyu.def.db.entity.AM_Sosiki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_SosikiNmKbn;

/**
 * 組織マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_Sosiki extends AbstractExDBTable<AM_Sosiki> {

    public GenQAM_Sosiki() {
        this("AM_Sosiki");
    }

    public GenQAM_Sosiki(String pAlias) {
        super("AM_Sosiki", AM_Sosiki.class, pAlias);
    }

    public String AM_Sosiki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_Sosiki, String> sosikicd = new ExDBFieldString<>("sosikicd", this);

    public final ExDBFieldString<AM_Sosiki, C_SosikiNmKbn> sosikinmkbn = new ExDBFieldString<>("sosikinmkbn", this, UserType_C_SosikiNmKbn.class);

    public final ExDBFieldString<AM_Sosiki, String> sosikinm20 = new ExDBFieldString<>("sosikinm20", this);

    public final ExDBFieldString<AM_Sosiki, String> kanjisosikinm20 = new ExDBFieldString<>("kanjisosikinm20", this);

    public final ExDBFieldString<AM_Sosiki, BizDateYM> sosikihaisiym = new ExDBFieldString<>("sosikihaisiym", this, BizDateYMType.class);

    public final ExDBFieldString<AM_Sosiki, BizDateYM> sosikisinsetuym = new ExDBFieldString<>("sosikisinsetuym", this, BizDateYMType.class);

    public final ExDBFieldString<AM_Sosiki, String> tougetukeisyouusosikicd = new ExDBFieldString<>("tougetukeisyouusosikicd", this);

    public final ExDBFieldString<AM_Sosiki, String> tougetukeisyoueigyoubucd = new ExDBFieldString<>("tougetukeisyoueigyoubucd", this);

    public final ExDBFieldString<AM_Sosiki, String> zengetukeisyousosikicd = new ExDBFieldString<>("zengetukeisyousosikicd", this);

    public final ExDBFieldString<AM_Sosiki, String> zengetukeisyoueigyoubucd = new ExDBFieldString<>("zengetukeisyoueigyoubucd", this);

    public final ExDBFieldString<AM_Sosiki, String> sosikikihontikucd = new ExDBFieldString<>("sosikikihontikucd", this);

    public final ExDBFieldString<AM_Sosiki, String> sosikikanjikaijyuusyo30 = new ExDBFieldString<>("sosikikanjikaijyuusyo30", this);

    public final ExDBFieldString<AM_Sosiki, String> kanjibirunm15 = new ExDBFieldString<>("kanjibirunm15", this);

    public final ExDBFieldString<AM_Sosiki, String> sosikinyuukyokaisuu = new ExDBFieldString<>("sosikinyuukyokaisuu", this);

    public final ExDBFieldString<AM_Sosiki, String> sosikitelno = new ExDBFieldString<>("sosikitelno", this);

    public final ExDBFieldString<AM_Sosiki, String> sosikifaxno = new ExDBFieldString<>("sosikifaxno", this);

    public final ExDBFieldString<AM_Sosiki, BizDate> kouryokukaisiymd = new ExDBFieldString<>("kouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<AM_Sosiki, String> hensosikikihontikucd = new ExDBFieldString<>("hensosikikihontikucd", this);

    public final ExDBFieldString<AM_Sosiki, String> henkanjisosikikaijyuusyo30 = new ExDBFieldString<>("henkanjisosikikaijyuusyo30", this);

    public final ExDBFieldString<AM_Sosiki, String> henkanjibirunm15 = new ExDBFieldString<>("henkanjibirunm15", this);

    public final ExDBFieldString<AM_Sosiki, String> hensosikinyuukyokaisuu = new ExDBFieldString<>("hensosikinyuukyokaisuu", this);

    public final ExDBFieldString<AM_Sosiki, String> hensosikitelno = new ExDBFieldString<>("hensosikitelno", this);

    public final ExDBFieldString<AM_Sosiki, String> hensosikifaxno = new ExDBFieldString<>("hensosikifaxno", this);
}
