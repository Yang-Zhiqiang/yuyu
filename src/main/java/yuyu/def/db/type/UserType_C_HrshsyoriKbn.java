package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrshsyoriKbn;

/**
 * {@link C_HrshsyoriKbn 返戻金支払処理区分} の Hibernate ユーザー定義型です。<br />
 * 返戻金支払処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrshsyoriKbn extends AbstractUserType<C_HrshsyoriKbn> {

    @Override
    protected Class<C_HrshsyoriKbn> returnType() {
        return C_HrshsyoriKbn.class;
    }

    @Override
    protected C_HrshsyoriKbn valueOf(String pValue) {
        return C_HrshsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrshsyoriKbn pValue) {
        return pValue.getValue();
    }
}
