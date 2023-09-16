package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DrtensyKbn;
import yuyu.def.classification.C_YuuseiKbn;
import yuyu.def.db.entity.HT_BosDairiten;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DrtensyKbn;
import yuyu.def.db.type.UserType_C_YuuseiKbn;

/**
 * 募集代理店テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_BosDairiten extends AbstractExDBTable<HT_BosDairiten> {

    public GenQHT_BosDairiten() {
        this("HT_BosDairiten");
    }

    public GenQHT_BosDairiten(String pAlias) {
        super("HT_BosDairiten", HT_BosDairiten.class, pAlias);
    }

    public String HT_BosDairiten() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_BosDairiten, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_BosDairiten, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_BosDairiten, String> bsyujoyadrtencd = new ExDBFieldString<>("bsyujoyadrtencd", this);

    public final ExDBFieldString<HT_BosDairiten, C_DrtensyKbn> drtensykbn = new ExDBFieldString<>("drtensykbn", this, UserType_C_DrtensyKbn.class);

    public final ExDBFieldString<HT_BosDairiten, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<HT_BosDairiten, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<HT_BosDairiten, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_BosDairiten, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_BosDairiten, String> jimusyocd = new ExDBFieldString<>("jimusyocd", this);

    public final ExDBFieldString<HT_BosDairiten, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);

    public final ExDBFieldString<HT_BosDairiten, String> cifcd = new ExDBFieldString<>("cifcd", this);

    public final ExDBFieldString<HT_BosDairiten, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<HT_BosDairiten, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<HT_BosDairiten, String> inputbosyuucd = new ExDBFieldString<>("inputbosyuucd", this);

    public final ExDBFieldString<HT_BosDairiten, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<HT_BosDairiten, String> tratkikouinncd = new ExDBFieldString<>("tratkikouinncd", this);

    public final ExDBFieldString<HT_BosDairiten, C_YuuseiKbn> yuuseikbn = new ExDBFieldString<>("yuuseikbn", this, UserType_C_YuuseiKbn.class);

    public final ExDBFieldString<HT_BosDairiten, String> kyokusyocd = new ExDBFieldString<>("kyokusyocd", this);

    public final ExDBFieldString<HT_BosDairiten, String> yuuseisyainno = new ExDBFieldString<>("yuuseisyainno", this);

    public final ExDBFieldString<HT_BosDairiten, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<HT_BosDairiten, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_BosDairiten, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
