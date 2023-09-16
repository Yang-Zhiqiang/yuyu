package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Kanjidrtflg;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_BAK_KykDairiten;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Kanjidrtflg;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約代理店バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KykDairiten extends AbstractExDBTable<IT_BAK_KykDairiten> {

    public GenQIT_BAK_KykDairiten() {
        this("IT_BAK_KykDairiten");
    }

    public GenQIT_BAK_KykDairiten(String pAlias) {
        super("IT_BAK_KykDairiten", IT_BAK_KykDairiten.class, pAlias);
    }

    public String IT_BAK_KykDairiten() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KykDairiten, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KykDairiten, Integer> drtenrenno = new ExDBFieldNumber<>("drtenrenno", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> drtenkanrisosikicd = new ExDBFieldString<>("drtenkanrisosikicd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> gyousekikeijyousakisosikicd = new ExDBFieldString<>("gyousekikeijyousakisosikicd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, C_UmuKbn> drtenbunumu = new ExDBFieldString<>("drtenbunumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_KykDairiten, C_Kanjidrtflg> kanjidrtflg = new ExDBFieldString<>("kanjidrtflg", this, UserType_C_Kanjidrtflg.class);

    public final ExDBFieldString<IT_BAK_KykDairiten, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_KykDairiten, BizDate> ikanymd = new ExDBFieldString<>("ikanymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> bsyujoyadrtencd = new ExDBFieldString<>("bsyujoyadrtencd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> bsyujdrtencd = new ExDBFieldString<>("bsyujdrtencd", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> bsyujbosyuutrkno = new ExDBFieldString<>("bsyujbosyuutrkno", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KykDairiten, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
