package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AM_IdCardYakusyoku;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * ＩＤカード役職マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAM_IdCardYakusyoku extends AbstractExDBTable<AM_IdCardYakusyoku> {

    public GenQAM_IdCardYakusyoku() {
        this("AM_IdCardYakusyoku");
    }

    public GenQAM_IdCardYakusyoku(String pAlias) {
        super("AM_IdCardYakusyoku", AM_IdCardYakusyoku.class, pAlias);
    }

    public String AM_IdCardYakusyoku() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AM_IdCardYakusyoku, String> idkbn = new ExDBFieldString<>("idkbn", this);

    public final ExDBFieldString<AM_IdCardYakusyoku, String> idcd = new ExDBFieldString<>("idcd", this);

    public final ExDBFieldString<AM_IdCardYakusyoku, BizDate> yakusyokuhatureiymd = new ExDBFieldString<>("yakusyokuhatureiymd", this, BizDateType.class);

    public final ExDBFieldString<AM_IdCardYakusyoku, String> yakusyokuhatureino = new ExDBFieldString<>("yakusyokuhatureino", this);

    public final ExDBFieldString<AM_IdCardYakusyoku, String> yakusyokuhatureisosikicd = new ExDBFieldString<>("yakusyokuhatureisosikicd", this);

    public final ExDBFieldString<AM_IdCardYakusyoku, String> yakusyokucd = new ExDBFieldString<>("yakusyokucd", this);
}
