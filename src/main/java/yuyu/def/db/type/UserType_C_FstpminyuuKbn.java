package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_FstpminyuuKbn;

/**
 * {@link C_FstpminyuuKbn 初回Ｐ未入区分} の Hibernate ユーザー定義型です。<br />
 * 初回Ｐ未入区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_FstpminyuuKbn extends AbstractUserType<C_FstpminyuuKbn> {

    @Override
    protected Class<C_FstpminyuuKbn> returnType() {
        return C_FstpminyuuKbn.class;
    }

    @Override
    protected C_FstpminyuuKbn valueOf(String pValue) {
        return C_FstpminyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_FstpminyuuKbn pValue) {
        return pValue.getValue();
    }
}
