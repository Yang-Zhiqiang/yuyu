package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 帳票検索テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_TyouhyouKensaku extends AbstractExDBTable<AT_TyouhyouKensaku> {

    public GenQAT_TyouhyouKensaku() {
        this("AT_TyouhyouKensaku");
    }

    public GenQAT_TyouhyouKensaku(String pAlias) {
        super("AT_TyouhyouKensaku", AT_TyouhyouKensaku.class, pAlias);
    }

    public String AT_TyouhyouKensaku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_TyouhyouKensaku, String> uniqueId = new ExDBFieldString<>("uniqueId", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> reportKey = new ExDBFieldString<>("reportKey", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kensakuKey1 = new ExDBFieldString<>("kensakuKey1", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kensakuKey2 = new ExDBFieldString<>("kensakuKey2", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kensakuKey3 = new ExDBFieldString<>("kensakuKey3", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kensakuKey4 = new ExDBFieldString<>("kensakuKey4", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> kensakuKey5 = new ExDBFieldString<>("kensakuKey5", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<AT_TyouhyouKensaku, BizDate> firstOutYmd = new ExDBFieldString<>("firstOutYmd", this, BizDateType.class);

    public final ExDBFieldString<AT_TyouhyouKensaku, BizDate> lastOutYmd = new ExDBFieldString<>("lastOutYmd", this, BizDateType.class);

    public final ExDBFieldNumber<AT_TyouhyouKensaku, Integer> outCount = new ExDBFieldNumber<>("outCount", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, String> lastOutUserId = new ExDBFieldString<>("lastOutUserId", this);

    public final ExDBFieldString<AT_TyouhyouKensaku, C_UmuKbn> syoruiKetugouUmuKbn = new ExDBFieldString<>("syoruiKetugouUmuKbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<AT_TyouhyouKensaku, Long> fileSize = new ExDBFieldNumber<>("fileSize", this);

    public final ExDBFieldNumber<AT_TyouhyouKensaku, Integer> pageCount = new ExDBFieldNumber<>("pageCount", this);
}
