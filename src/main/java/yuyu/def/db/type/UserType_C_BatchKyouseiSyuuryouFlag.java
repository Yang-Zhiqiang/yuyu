package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BatchKyouseiSyuuryouFlag;

/**
 * {@link C_BatchKyouseiSyuuryouFlag バッチ強制終了フラグ} の Hibernate ユーザー定義型です。<br />
 * バッチ強制終了フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BatchKyouseiSyuuryouFlag extends AbstractUserType<C_BatchKyouseiSyuuryouFlag> {

    @Override
    protected Class<C_BatchKyouseiSyuuryouFlag> returnType() {
        return C_BatchKyouseiSyuuryouFlag.class;
    }

    @Override
    protected C_BatchKyouseiSyuuryouFlag valueOf(String pValue) {
        return C_BatchKyouseiSyuuryouFlag.valueOf(pValue);
    }

    @Override
    protected String toString(C_BatchKyouseiSyuuryouFlag pValue) {
        return pValue.getValue();
    }
}
