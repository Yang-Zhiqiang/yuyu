package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MqkousintrksiraiKbn;

/**
 * {@link C_MqkousintrksiraiKbn ＭＱ更新取消依頼区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱ更新取消依頼区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MqkousintrksiraiKbn extends AbstractUserType<C_MqkousintrksiraiKbn> {

    @Override
    protected Class<C_MqkousintrksiraiKbn> returnType() {
        return C_MqkousintrksiraiKbn.class;
    }

    @Override
    protected C_MqkousintrksiraiKbn valueOf(String pValue) {
        return C_MqkousintrksiraiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MqkousintrksiraiKbn pValue) {
        return pValue.getValue();
    }
}
