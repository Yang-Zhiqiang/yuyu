package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SinsaisakuseiKbn;

/**
 * {@link C_SinsaisakuseiKbn 新規再作成区分} の Hibernate ユーザー定義型です。<br />
 * 新規再作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SinsaisakuseiKbn extends AbstractUserType<C_SinsaisakuseiKbn> {

    @Override
    protected Class<C_SinsaisakuseiKbn> returnType() {
        return C_SinsaisakuseiKbn.class;
    }

    @Override
    protected C_SinsaisakuseiKbn valueOf(String pValue) {
        return C_SinsaisakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SinsaisakuseiKbn pValue) {
        return pValue.getValue();
    }
}
