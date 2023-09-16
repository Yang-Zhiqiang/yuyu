package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeibiRiyuuKbn;

/**
 * {@link C_SeibiRiyuuKbn 整備理由区分} の Hibernate ユーザー定義型です。<br />
 * 整備理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeibiRiyuuKbn extends AbstractUserType<C_SeibiRiyuuKbn> {

    @Override
    protected Class<C_SeibiRiyuuKbn> returnType() {
        return C_SeibiRiyuuKbn.class;
    }

    @Override
    protected C_SeibiRiyuuKbn valueOf(String pValue) {
        return C_SeibiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeibiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
