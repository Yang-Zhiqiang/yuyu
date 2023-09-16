package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * ＤＳ配信エラーリストテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHaisinErrorList extends AbstractExDBTable<MT_DsHaisinErrorList> {

    public GenQMT_DsHaisinErrorList() {
        this("MT_DsHaisinErrorList");
    }

    public GenQMT_DsHaisinErrorList(String pAlias) {
        super("MT_DsHaisinErrorList", MT_DsHaisinErrorList.class, pAlias);
    }

    public String MT_DsHaisinErrorList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHaisinErrorList, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsHaisinErrorList, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> haisinjidsmailaddress = new ExDBFieldString<>("haisinjidsmailaddress", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> haisinerrorcount = new ExDBFieldString<>("haisinerrorcount", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsHaisinErrorList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
