package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.HT_SouseirituDairiten;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DrtensyKbn;
import yuyu.def.db.type.UserType_C_YuuseiKbn;

/**
 * 総成立代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SouseirituDairiten extends AbstractExDBTable<HT_SouseirituDairiten> {

    public GenQHT_SouseirituDairiten() {
        this("HT_SouseirituDairiten");
    }

    public GenQHT_SouseirituDairiten(String pAlias) {
        super("HT_SouseirituDairiten", HT_SouseirituDairiten.class, pAlias);
    }

    public String HT_SouseirituDairiten() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SouseirituDairiten, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<HT_SouseirituDairiten, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> bsyujoyadrtencd = new ExDBFieldString<>("bsyujoyadrtencd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, C_DrtensyKbn> drtensykbn = new ExDBFieldString<>("drtensykbn", this, UserType_C_DrtensyKbn.class);

    public final ExDBFieldString<HT_SouseirituDairiten, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> jimusyocd = new ExDBFieldString<>("jimusyocd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> inputbosyuucd = new ExDBFieldString<>("inputbosyuucd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> tratkikouinncd = new ExDBFieldString<>("tratkikouinncd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, C_YuuseiKbn> yuuseikbn = new ExDBFieldString<>("yuuseikbn", this, UserType_C_YuuseiKbn.class);

    public final ExDBFieldString<HT_SouseirituDairiten, String> kyokusyocd = new ExDBFieldString<>("kyokusyocd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> yuuseisyainno = new ExDBFieldString<>("yuuseisyainno", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> gyousekikeijyousakisosikicd = new ExDBFieldString<>("gyousekikeijyousakisosikicd", this);

    public final ExDBFieldString<HT_SouseirituDairiten, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_SouseirituDairiten, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SouseirituDairiten, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
