package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoukaiKanouHyj;
import yuyu.def.db.entity.BW_IdCardWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SyoukaiKanouHyj;

/**
 * ＩＤカードマスタワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_IdCardWk extends AbstractExDBTable<BW_IdCardWk> {

    public GenQBW_IdCardWk() {
        this("BW_IdCardWk");
    }

    public GenQBW_IdCardWk(String pAlias) {
        super("BW_IdCardWk", BW_IdCardWk.class, pAlias);
    }

    public String BW_IdCardWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_IdCardWk, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<BW_IdCardWk, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<BW_IdCardWk, String> tanmatusiyoukbn = new ExDBFieldString<>("tanmatusiyoukbn", this);

    public final ExDBFieldString<BW_IdCardWk, String> accesskbn = new ExDBFieldString<>("accesskbn", this);

    public final ExDBFieldString<BW_IdCardWk, String> idnyuuryokusyanm = new ExDBFieldString<>("idnyuuryokusyanm", this);

    public final ExDBFieldString<BW_IdCardWk, String> kanjiidnyuuryokusyanm = new ExDBFieldString<>("kanjiidnyuuryokusyanm", this);

    public final ExDBFieldString<BW_IdCardWk, BizDate> idnyuuryokusyaseiymd = new ExDBFieldString<>("idnyuuryokusyaseiymd", this, BizDateType.class);

    public final ExDBFieldString<BW_IdCardWk, BizDate> idnyuuryokusyanyuusyaymd = new ExDBFieldString<>("idnyuuryokusyanyuusyaymd", this, BizDateType.class);

    public final ExDBFieldString<BW_IdCardWk, String> syozokusosikicd = new ExDBFieldString<>("syozokusosikicd", this);

    public final ExDBFieldString<BW_IdCardWk, String> syozokusisyacd = new ExDBFieldString<>("syozokusisyacd", this);

    public final ExDBFieldString<BW_IdCardWk, String> syozokusibucd = new ExDBFieldString<>("syozokusibucd", this);

    public final ExDBFieldString<BW_IdCardWk, String> idnyuuryokusyasikakucd = new ExDBFieldString<>("idnyuuryokusyasikakucd", this);

    public final ExDBFieldString<BW_IdCardWk, String> idsdpsouhuhyouji = new ExDBFieldString<>("idsdpsouhuhyouji", this);

    public final ExDBFieldString<BW_IdCardWk, BizDate> idcardsaisyuukousinymd = new ExDBFieldString<>("idcardsaisyuukousinymd", this, BizDateType.class);

    public final ExDBFieldString<BW_IdCardWk, BizDate> idcardmukouymd = new ExDBFieldString<>("idcardmukouymd", this, BizDateType.class);

    public final ExDBFieldString<BW_IdCardWk, String> kaikeitantousyakbn = new ExDBFieldString<>("kaikeitantousyakbn", this);

    public final ExDBFieldString<BW_IdCardWk, String> syanaiyokintantousyakbn = new ExDBFieldString<>("syanaiyokintantousyakbn", this);

    public final ExDBFieldString<BW_IdCardWk, C_SyoukaiKanouHyj> jinjimynosyoukaihyj = new ExDBFieldString<>("jinjimynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<BW_IdCardWk, C_SyoukaiKanouHyj> eisyokumynosyoukaihyj = new ExDBFieldString<>("eisyokumynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<BW_IdCardWk, C_SyoukaiKanouHyj> hudousanmynosyoukaihyj = new ExDBFieldString<>("hudousanmynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<BW_IdCardWk, C_SyoukaiKanouHyj> kohomynosyoukaihyj = new ExDBFieldString<>("kohomynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<BW_IdCardWk, C_SyoukaiKanouHyj> kihomynosyoukaihyj = new ExDBFieldString<>("kihomynosyoukaihyj", this, UserType_C_SyoukaiKanouHyj.class);

    public final ExDBFieldString<BW_IdCardWk, String> kikantantoukbn = new ExDBFieldString<>("kikantantoukbn", this);
}
