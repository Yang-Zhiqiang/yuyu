package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DrtensyKbn;
import yuyu.def.db.type.UserType_C_YuuseiKbn;

/**
 * 申込代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosDairiten extends AbstractExDBTable<HT_MosDairiten> {

    public GenQHT_MosDairiten() {
        this("HT_MosDairiten");
    }

    public GenQHT_MosDairiten(String pAlias) {
        super("HT_MosDairiten", HT_MosDairiten.class, pAlias);
    }

    public String HT_MosDairiten() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosDairiten, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_MosDairiten, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_MosDairiten, String> bsyujoyadrtencd = new ExDBFieldString<>("bsyujoyadrtencd", this);

    public final ExDBFieldString<HT_MosDairiten, C_DrtensyKbn> drtensykbn = new ExDBFieldString<>("drtensykbn", this, UserType_C_DrtensyKbn.class);

    public final ExDBFieldString<HT_MosDairiten, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<HT_MosDairiten, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<HT_MosDairiten, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_MosDairiten, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_MosDairiten, String> jimusyocd = new ExDBFieldString<>("jimusyocd", this);

    public final ExDBFieldString<HT_MosDairiten, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);

    public final ExDBFieldString<HT_MosDairiten, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<HT_MosDairiten, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<HT_MosDairiten, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<HT_MosDairiten, String> inputbosyuucd = new ExDBFieldString<>("inputbosyuucd", this);

    public final ExDBFieldString<HT_MosDairiten, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<HT_MosDairiten, String> tratkikouinncd = new ExDBFieldString<>("tratkikouinncd", this);

    public final ExDBFieldString<HT_MosDairiten, C_YuuseiKbn> yuuseikbn = new ExDBFieldString<>("yuuseikbn", this, UserType_C_YuuseiKbn.class);

    public final ExDBFieldString<HT_MosDairiten, String> kyokusyocd = new ExDBFieldString<>("kyokusyocd", this);

    public final ExDBFieldString<HT_MosDairiten, String> yuuseisyainno = new ExDBFieldString<>("yuuseisyainno", this);

    public final ExDBFieldString<HT_MosDairiten, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<HT_MosDairiten, String> gyousekikeijyousakisosikicd = new ExDBFieldString<>("gyousekikeijyousakisosikicd", this);

    public final ExDBFieldString<HT_MosDairiten, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_MosDairiten, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosDairiten, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
