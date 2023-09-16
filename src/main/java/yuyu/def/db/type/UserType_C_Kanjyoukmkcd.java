package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kanjyoukmkcd;

/**
 * {@link C_Kanjyoukmkcd 勘定科目コード} の Hibernate ユーザー定義型です。<br />
 * 勘定科目コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kanjyoukmkcd extends AbstractUserType<C_Kanjyoukmkcd> {

    @Override
    protected Class<C_Kanjyoukmkcd> returnType() {
        return C_Kanjyoukmkcd.class;
    }

    @Override
    protected C_Kanjyoukmkcd valueOf(String pValue) {
        return C_Kanjyoukmkcd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kanjyoukmkcd pValue) {
        return pValue.getValue();
    }
}
