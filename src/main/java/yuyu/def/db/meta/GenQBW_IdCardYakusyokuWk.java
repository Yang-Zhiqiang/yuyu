package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * ＩＤカード役職マスタワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBW_IdCardYakusyokuWk extends AbstractExDBTable<BW_IdCardYakusyokuWk> {

    public GenQBW_IdCardYakusyokuWk() {
        this("BW_IdCardYakusyokuWk");
    }

    public GenQBW_IdCardYakusyokuWk(String pAlias) {
        super("BW_IdCardYakusyokuWk", BW_IdCardYakusyokuWk.class, pAlias);
    }

    public String BW_IdCardYakusyokuWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BW_IdCardYakusyokuWk, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<BW_IdCardYakusyokuWk, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<BW_IdCardYakusyokuWk, BizDate> yakusyokuhatureiymd = new ExDBFieldString<>("yakusyokuhatureiymd", this, BizDateType.class);

    public final ExDBFieldString<BW_IdCardYakusyokuWk, String> yakusyokuhatureino = new ExDBFieldString<>("yakusyokuhatureino", this);

    public final ExDBFieldString<BW_IdCardYakusyokuWk, String> yakusyokuhatureisosikicd = new ExDBFieldString<>("yakusyokuhatureisosikicd", this);

    public final ExDBFieldString<BW_IdCardYakusyokuWk, String> yakusyokucd = new ExDBFieldString<>("yakusyokucd", this);
}
