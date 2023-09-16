package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_JiketteiKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_JigyouIkkatu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_JiketteiKbn;
import yuyu.def.db.type.UserType_C_SeirituKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 事業一括テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_JigyouIkkatu extends AbstractExDBTable<HT_JigyouIkkatu> {

    public GenQHT_JigyouIkkatu() {
        this("HT_JigyouIkkatu");
    }

    public GenQHT_JigyouIkkatu(String pAlias) {
        super("HT_JigyouIkkatu", HT_JigyouIkkatu.class, pAlias);
    }

    public String HT_JigyouIkkatu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_JigyouIkkatu, String> daimosno = new ExDBFieldString<>("daimosno", this);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> mosnrkumu = new ExDBFieldString<>("mosnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> kktnrkumu = new ExDBFieldString<>("kktnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> hjynrkumu = new ExDBFieldString<>("hjynrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> nyknnrkumu = new ExDBFieldString<>("nyknnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> nyknwarinrkumu = new ExDBFieldString<>("nyknwarinrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_UmuKbn> itijiketnrkumu = new ExDBFieldString<>("itijiketnrkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_JiketteiKbn> jiketteikbn = new ExDBFieldString<>("jiketteikbn", this, UserType_C_JiketteiKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, C_SeirituKbn> jgyiktsrkbn = new ExDBFieldString<>("jgyiktsrkbn", this, UserType_C_SeirituKbn.class);

    public final ExDBFieldString<HT_JigyouIkkatu, BizDate> jgyiktsrymd = new ExDBFieldString<>("jgyiktsrymd", this, BizDateType.class);

    public final ExDBFieldString<HT_JigyouIkkatu, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_JigyouIkkatu, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
