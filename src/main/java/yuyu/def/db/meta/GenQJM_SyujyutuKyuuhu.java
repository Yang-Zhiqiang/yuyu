package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 手術給付マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SyujyutuKyuuhu extends AbstractExDBTable<JM_SyujyutuKyuuhu> {

    public GenQJM_SyujyutuKyuuhu() {
        this("JM_SyujyutuKyuuhu");
    }

    public GenQJM_SyujyutuKyuuhu(String pAlias) {
        super("JM_SyujyutuKyuuhu", JM_SyujyutuKyuuhu.class, pAlias);
    }

    public String JM_SyujyutuKyuuhu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> syujyutubunruicd = new ExDBFieldString<>("syujyutubunruicd", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<JM_SyujyutuKyuuhu, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, BizDate> syujyututekiyoukkanfrom = new ExDBFieldString<>("syujyututekiyoukkanfrom", this, BizDateType.class);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, BizDate> syujyututekiyoukkanto = new ExDBFieldString<>("syujyututekiyoukkanto", this, BizDateType.class);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, BizNumber> syujyutukyhbairitu = new ExDBFieldString<>("syujyutukyhbairitu", this, BizNumberType.class);

    public final ExDBFieldNumber<JM_SyujyutuKyuuhu, Integer> kyuuhugendokikan = new ExDBFieldNumber<>("kyuuhugendokikan", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> syujyutusyurui = new ExDBFieldString<>("syujyutusyurui", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, C_UmuKbn> tokusyusyujyutukbn = new ExDBFieldString<>("tokusyusyujyutukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JM_SyujyutuKyuuhu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
