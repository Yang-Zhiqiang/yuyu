package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Itksyouhn4hyj;

/**
 * {@link C_Itksyouhn4hyj 委託商品４有表示} の Hibernate ユーザー定義型です。<br />
 * 委託商品４有表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Itksyouhn4hyj extends AbstractUserType<C_Itksyouhn4hyj> {

    @Override
    protected Class<C_Itksyouhn4hyj> returnType() {
        return C_Itksyouhn4hyj.class;
    }

    @Override
    protected C_Itksyouhn4hyj valueOf(String pValue) {
        return C_Itksyouhn4hyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_Itksyouhn4hyj pValue) {
        return pValue.getValue();
    }
}
