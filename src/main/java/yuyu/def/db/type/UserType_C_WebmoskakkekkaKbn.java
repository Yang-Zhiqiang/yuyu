package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebmoskakkekkaKbn;

/**
 * {@link C_WebmoskakkekkaKbn Ｗｅｂ申込確認結果区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ申込確認結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebmoskakkekkaKbn extends AbstractUserType<C_WebmoskakkekkaKbn> {

    @Override
    protected Class<C_WebmoskakkekkaKbn> returnType() {
        return C_WebmoskakkekkaKbn.class;
    }

    @Override
    protected C_WebmoskakkekkaKbn valueOf(String pValue) {
        return C_WebmoskakkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebmoskakkekkaKbn pValue) {
        return pValue.getValue();
    }
}
