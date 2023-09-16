package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳ配信エラーリスト２テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsHaisinErrorList2 extends AbstractExDBTable<MT_DsHaisinErrorList2> {

    public GenQMT_DsHaisinErrorList2() {
        this("MT_DsHaisinErrorList2");
    }

    public GenQMT_DsHaisinErrorList2(String pAlias) {
        super("MT_DsHaisinErrorList2", MT_DsHaisinErrorList2.class, pAlias);
    }

    public String MT_DsHaisinErrorList2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsHaisinErrorList2, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldNumber<MT_DsHaisinErrorList2, Integer> dsmailhaisinrenban = new ExDBFieldNumber<>("dsmailhaisinrenban", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsHaisinErrorList2, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> haisinjidsmailaddress = new ExDBFieldString<>("haisinjidsmailaddress", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, BizDate> dsmailsousinymd = new ExDBFieldString<>("dsmailsousinymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHaisinErrorList2, BizDate> dsmailsakujyoymd = new ExDBFieldString<>("dsmailsakujyoymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> haisinerrorcount = new ExDBFieldString<>("haisinerrorcount", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> haisinerrorcount2 = new ExDBFieldString<>("haisinerrorcount2", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsHaisinErrorList2, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
