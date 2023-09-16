package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.WT_ImageArriveNotice;

/**
 * 到着予定通知情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQWT_ImageArriveNotice extends AbstractExDBTable<WT_ImageArriveNotice> {

    public GenQWT_ImageArriveNotice() {
        this("WT_ImageArriveNotice");
    }

    public GenQWT_ImageArriveNotice(String pAlias) {
        super("WT_ImageArriveNotice", WT_ImageArriveNotice.class, pAlias);
    }

    public String WT_ImageArriveNotice() {
        return getAliasExpression();
    }

    public final ExDBFieldString<WT_ImageArriveNotice, String> arriveKey = new ExDBFieldString<>("arriveKey", this);

    public final ExDBFieldString<WT_ImageArriveNotice, String> torikomiSyoruiCd = new ExDBFieldString<>("torikomiSyoruiCd", this);

    public final ExDBFieldString<WT_ImageArriveNotice, String> gyoumuKey = new ExDBFieldString<>("gyoumuKey", this);

    public final ExDBFieldString<WT_ImageArriveNotice, String> flowId = new ExDBFieldString<>("flowId", this);

    public final ExDBFieldString<WT_ImageArriveNotice, String> subSystemId = new ExDBFieldString<>("subSystemId", this);
}
