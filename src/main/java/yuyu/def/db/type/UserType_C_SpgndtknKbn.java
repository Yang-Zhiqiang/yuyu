package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SpgndtknKbn;

/**
 * {@link C_SpgndtknKbn ＳＰ限度特認区分} の Hibernate ユーザー定義型です。<br />
 * ＳＰ限度特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SpgndtknKbn extends AbstractUserType<C_SpgndtknKbn> {

    @Override
    protected Class<C_SpgndtknKbn> returnType() {
        return C_SpgndtknKbn.class;
    }

    @Override
    protected C_SpgndtknKbn valueOf(String pValue) {
        return C_SpgndtknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SpgndtknKbn pValue) {
        return pValue.getValue();
    }
}
