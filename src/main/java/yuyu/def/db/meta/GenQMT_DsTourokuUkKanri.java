package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsTtdksyubetuKbn;
import yuyu.def.db.type.UserType_C_TourokustatusKbn;

/**
 * ＤＳ登録受付管理テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsTourokuUkKanri extends AbstractExDBTable<MT_DsTourokuUkKanri> {

    public GenQMT_DsTourokuUkKanri() {
        this("MT_DsTourokuUkKanri");
    }

    public GenQMT_DsTourokuUkKanri(String pAlias) {
        super("MT_DsTourokuUkKanri", MT_DsTourokuUkKanri.class, pAlias);
    }

    public String MT_DsTourokuUkKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, C_DsTtdksyubetuKbn> dsttdksyubetukbn = new ExDBFieldString<>("dsttdksyubetukbn", this, UserType_C_DsTtdksyubetuKbn.class);

    public final ExDBFieldNumber<MT_DsTourokuUkKanri, Integer> datarenno = new ExDBFieldNumber<>("datarenno", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, C_TourokustatusKbn> tourokustatus = new ExDBFieldString<>("tourokustatus", this, UserType_C_TourokustatusKbn.class);

    public final ExDBFieldString<MT_DsTourokuUkKanri, BizDate> dsjimukaisiymd = new ExDBFieldString<>("dsjimukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTourokuUkKanri, BizDate> dsjimukanryouymd = new ExDBFieldString<>("dsjimukanryouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTourokuUkKanri, BizDate> dstourokukanryouymd = new ExDBFieldString<>("dstourokukanryouymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsTourokuUkKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
