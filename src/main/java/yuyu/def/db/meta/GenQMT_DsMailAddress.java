package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.type.UserType_C_DsMailSousinJyoutaiKbn;
import yuyu.def.db.type.UserType_C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.db.type.UserType_C_DsMailTourokuJyoutaiKbn;

/**
 * ＤＳメールアドレステーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_DsMailAddress extends AbstractExDBTable<MT_DsMailAddress> {

    public GenQMT_DsMailAddress() {
        this("MT_DsMailAddress");
    }

    public GenQMT_DsMailAddress(String pAlias) {
        super("MT_DsMailAddress", MT_DsMailAddress.class, pAlias);
    }

    public String MT_DsMailAddress() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_DsMailAddress, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MT_DsMailAddress, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);

    public final ExDBFieldString<MT_DsMailAddress, C_DsMailTourokuJyoutaiKbn> dsmailtourokujyoutaikbn = new ExDBFieldString<>("dsmailtourokujyoutaikbn", this, UserType_C_DsMailTourokuJyoutaiKbn.class);

    public final ExDBFieldString<MT_DsMailAddress, String> dsmailaddress = new ExDBFieldString<>("dsmailaddress", this);

    public final ExDBFieldString<MT_DsMailAddress, C_DsMailSousinJyoutaiKbn> dsmailsousinjyoutaikbn = new ExDBFieldString<>("dsmailsousinjyoutaikbn", this, UserType_C_DsMailSousinJyoutaiKbn.class);

    public final ExDBFieldString<MT_DsMailAddress, C_DsMailSousinTeisiRiyuuKbn> dsmailsousintisrykbn = new ExDBFieldString<>("dsmailsousintisrykbn", this, UserType_C_DsMailSousinTeisiRiyuuKbn.class);

    public final ExDBFieldString<MT_DsMailAddress, String> dstourokuymdtime = new ExDBFieldString<>("dstourokuymdtime", this);

    public final ExDBFieldString<MT_DsMailAddress, String> dskousinymdtime = new ExDBFieldString<>("dskousinymdtime", this);

    public final ExDBFieldString<MT_DsMailAddress, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_DsMailAddress, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MT_DsMailAddress, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
