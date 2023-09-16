package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoukaiKanouHyj;
import yuyu.def.db.entity.AM_IdCard;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SyoukaiKanouHyj;

/**
 * ＩＤカードマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_IdCard extends AbstractExDBTable<AM_IdCard> {

    public GenQAM_IdCard() {
        this("AM_IdCard");
    }

    public GenQAM_IdCard(String pAlias) {
        super("AM_IdCard", AM_IdCard.class, pAlias);
    }

    public String AM_IdCard() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_IdCard, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<AM_IdCard, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<AM_IdCard, String> tanmatusiyoukbn = new ExDBFieldString<>("tanmatusiyoukbn", this);

    public final ExDBFieldString<AM_IdCard, String> accesskbn = new ExDBFieldString<>("accesskbn", this);

    public final ExDBFieldString<AM_IdCard, String> idnyuuryokusyanm = new ExDBFieldString<>("idnyuuryokusyanm", this);

    public final ExDBFieldString<AM_IdCard, String> kanjiidnyuuryokusyanm = new ExDBFieldString<>("kanjiidnyuuryokusyanm", this);

    public final ExDBFieldString<AM_IdCard, BizDate> idnyuuryokusyaseiymd = new ExDBFieldString<>("idnyuuryokusyaseiymd", this, BizDateType.class);

    public final ExDBFieldString<AM_IdCard, BizDate> idnyuuryokusyanyuusyaymd = new ExDBFieldString<>("idnyuuryokusyanyuusyaymd", this, BizDateType.class);

    public final ExDBFieldString<AM_IdCard, String> syozokusosikicd = new ExDBFieldString<>("syozokusosikicd", this);

    public final ExDBFieldString<AM_IdCard, String> syozokusisyacd = new ExDBFieldString<>("syozokusisyacd", this);

    public final ExDBFieldString<AM_IdCard, String> syozokusibucd = new ExDBFieldString<>("syozokusibucd", this);

    public final ExDBFieldString<AM_IdCard, String> idnyuuryokusyasikakucd = new ExDBFieldString<>("idnyuuryokusyasikakucd", this);

    public final ExDBFieldString<AM_IdCard, String> idsdpsouhuhyouji = new ExDBFieldString<>("idsdpsouhuhyouji", this);

    public final ExDBFieldString<AM_IdCard, BizDate> idcardsaisyuukousinymd = new ExDBFieldString<>("idcardsaisyuukousinymd", this, BizDateType.class);

    public final ExDBFieldString<AM_IdCard, BizDate> idcardmukouymd = new ExDBFieldString<>("idcardmukouymd", this, BizDateType.class);

    public final ExDBFieldString<AM_IdCard, String> kaikeitantousyakbn = new ExDBFieldString<>("kaikeitantousyakbn", this);

    public final ExDBFieldString<AM_IdCard, String> syanaiyokintantousyakbn = new ExDBFieldString<>("syanaiyokintantousyakbn", this);

    public final ExDBFieldString<AM_IdCard, C_SyoukaiKanouHyj> jinjimynosyoukaihyj = new ExDBFieldString<>("jinjimynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<AM_IdCard, C_SyoukaiKanouHyj> eisyokumynosyoukaihyj = new ExDBFieldString<>("eisyokumynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<AM_IdCard, C_SyoukaiKanouHyj> hudousanmynosyoukaihyj = new ExDBFieldString<>("hudousanmynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<AM_IdCard, C_SyoukaiKanouHyj> kohomynosyoukaihyj = new ExDBFieldString<>("kohomynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<AM_IdCard, C_SyoukaiKanouHyj> kihomynosyoukaihyj = new ExDBFieldString<>("kihomynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<AM_IdCard, String> kikantantoukbn = new ExDBFieldString<>("kikantantoukbn", this);
}
