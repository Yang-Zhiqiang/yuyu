package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuintsntknKbn;

/**
 * {@link C_SakuintsntknKbn 索引通算特認区分} の Hibernate ユーザー定義型です。<br />
 * 索引通算特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuintsntknKbn extends AbstractUserType<C_SakuintsntknKbn> {

    @Override
    protected Class<C_SakuintsntknKbn> returnType() {
        return C_SakuintsntknKbn.class;
    }

    @Override
    protected C_SakuintsntknKbn valueOf(String pValue) {
        return C_SakuintsntknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuintsntknKbn pValue) {
        return pValue.getValue();
    }
}
