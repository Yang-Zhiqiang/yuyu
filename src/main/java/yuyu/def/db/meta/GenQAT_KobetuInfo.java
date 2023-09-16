package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.AT_KobetuInfo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 個別情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQAT_KobetuInfo extends AbstractExDBTable<AT_KobetuInfo> {

    public GenQAT_KobetuInfo() {
        this("AT_KobetuInfo");
    }

    public GenQAT_KobetuInfo(String pAlias) {
        super("AT_KobetuInfo", AT_KobetuInfo.class, pAlias);
    }

    public String AT_KobetuInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<AT_KobetuInfo, String> userId = new ExDBFieldString<>("userId", this);

    public final ExDBFieldString<AT_KobetuInfo, String> infoSeqNo = new ExDBFieldString<>("infoSeqNo", this);

    public final ExDBFieldString<AT_KobetuInfo, BizDate> hyoujiYmdFrom = new ExDBFieldString<>("hyoujiYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<AT_KobetuInfo, BizDate> hyoujiYmdTo = new ExDBFieldString<>("hyoujiYmdTo", this, BizDateType.class);

    public final ExDBFieldString<AT_KobetuInfo, String> hyoujiNaiyou = new ExDBFieldString<>("hyoujiNaiyou", this);

    public final ExDBFieldString<AT_KobetuInfo, String> infoSikibetuId = new ExDBFieldString<>("infoSikibetuId", this);
}
