package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 共通情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_KyoutuuInfo extends AbstractExDBTable<AT_KyoutuuInfo> {

    public GenQAT_KyoutuuInfo() {
        this("AT_KyoutuuInfo");
    }

    public GenQAT_KyoutuuInfo(String pAlias) {
        super("AT_KyoutuuInfo", AT_KyoutuuInfo.class, pAlias);
    }

    public String AT_KyoutuuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_KyoutuuInfo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<AT_KyoutuuInfo, String> categoryId = new ExDBFieldString<>("categoryId", this);

    public final ExDBFieldString<AT_KyoutuuInfo, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<AT_KyoutuuInfo, String> infoSeqNo = new ExDBFieldString<>("infoSeqNo", this);

    public final ExDBFieldString<AT_KyoutuuInfo, BizDate> hyoujiYmdFrom = new ExDBFieldString<>("hyoujiYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<AT_KyoutuuInfo, BizDate> hyoujiYmdTo = new ExDBFieldString<>("hyoujiYmdTo", this, BizDateType.class);

    public final ExDBFieldString<AT_KyoutuuInfo, String> hyoujiNaiyou = new ExDBFieldString<>("hyoujiNaiyou", this);

    public final ExDBFieldString<AT_KyoutuuInfo, String> infoSikibetuId = new ExDBFieldString<>("infoSikibetuId", this);
}
