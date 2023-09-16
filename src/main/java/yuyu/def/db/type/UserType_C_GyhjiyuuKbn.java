package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GyhjiyuuKbn;

/**
 * {@link C_GyhjiyuuKbn 業廃事由区分} の Hibernate ユーザー定義型です。<br />
 * 業廃事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GyhjiyuuKbn extends AbstractUserType<C_GyhjiyuuKbn> {

    @Override
    protected Class<C_GyhjiyuuKbn> returnType() {
        return C_GyhjiyuuKbn.class;
    }

    @Override
    protected C_GyhjiyuuKbn valueOf(String pValue) {
        return C_GyhjiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GyhjiyuuKbn pValue) {
        return pValue.getValue();
    }
}
