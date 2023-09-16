package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_50onsakuin;

/**
 * {@link C_50onsakuin 50音索引区分} の Hibernate ユーザー定義型です。<br />
 * 50音索引区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_50onsakuin extends AbstractUserType<C_50onsakuin> {

    @Override
    protected Class<C_50onsakuin> returnType() {
        return C_50onsakuin.class;
    }

    @Override
    protected C_50onsakuin valueOf(String pValue) {
        return C_50onsakuin.valueOf(pValue);
    }

    @Override
    protected String toString(C_50onsakuin pValue) {
        return pValue.getValue();
    }
}
