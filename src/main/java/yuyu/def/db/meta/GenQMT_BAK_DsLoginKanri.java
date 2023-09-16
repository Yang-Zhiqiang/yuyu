package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.db.entity.MT_BAK_DsLoginKanri;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BaitaiKbn;

/**
 * ＤＳログイン管理バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMT_BAK_DsLoginKanri extends AbstractExDBTable<MT_BAK_DsLoginKanri> {

    public GenQMT_BAK_DsLoginKanri() {
        this("MT_BAK_DsLoginKanri");
    }

    public GenQMT_BAK_DsLoginKanri(String pAlias) {
        super("MT_BAK_DsLoginKanri", MT_BAK_DsLoginKanri.class, pAlias);
    }

    public String MT_BAK_DsLoginKanri() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, BizDate> syokailoginymd = new ExDBFieldString<>("syokailoginymd", this, BizDateType.class);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> syokailogintime = new ExDBFieldString<>("syokailogintime", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, C_BaitaiKbn> syokailoginbaitaikbn = new ExDBFieldString<>("syokailoginbaitaikbn", this, UserType_C_BaitaiKbn.class);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, BizDate> saisinloginymd = new ExDBFieldString<>("saisinloginymd", this, BizDateType.class);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> saisinlogintime = new ExDBFieldString<>("saisinlogintime", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, C_BaitaiKbn> saisinloginbaitaikbn = new ExDBFieldString<>("saisinloginbaitaikbn", this, UserType_C_BaitaiKbn.class);

    public final ExDBFieldNumber<MT_BAK_DsLoginKanri, Integer> dshnnkakcderrorkaisuu = new ExDBFieldNumber<>("dshnnkakcderrorkaisuu", this);

    public final ExDBFieldNumber<MT_BAK_DsLoginKanri, Integer> dskokyakunmerrorkaisuu = new ExDBFieldNumber<>("dskokyakunmerrorkaisuu", this);

    public final ExDBFieldNumber<MT_BAK_DsLoginKanri, Integer> dskokyakuseiymderrorkaisuu = new ExDBFieldNumber<>("dskokyakuseiymderrorkaisuu", this);

    public final ExDBFieldNumber<MT_BAK_DsLoginKanri, Integer> dskokyakutelnoerrorkaisuu = new ExDBFieldNumber<>("dskokyakutelnoerrorkaisuu", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MT_BAK_DsLoginKanri, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);
}
