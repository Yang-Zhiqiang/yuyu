package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsMailHaisinRireki extends AbstractExDBTable<MT_DsMailHaisinRireki> {

    public GenQMT_DsMailHaisinRireki() {
        this("MT_DsMailHaisinRireki");
    }

    public GenQMT_DsMailHaisinRireki(String pAlias) {
        super("MT_DsMailHaisinRireki", MT_DsMailHaisinRireki.class, pAlias);
    }

    public String MT_DsMailHaisinRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsMailHaisinRireki, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsMailHaisinRireki, Integer> dsmailhaisinrenban = new ExDBFieldNumber<>("dsmailhaisinrenban", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> haisinjidsmailaddress = new ExDBFieldString<>("haisinjidsmailaddress", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_DsMailHaisinRireki, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MT_DsMailHaisinRireki, String> syono = new ExDBFieldString<>("syono", this);
}
