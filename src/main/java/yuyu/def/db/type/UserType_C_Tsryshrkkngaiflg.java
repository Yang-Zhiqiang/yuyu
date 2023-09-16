package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tsryshrkkngaiflg;

/**
 * {@link C_Tsryshrkkngaiflg 手数料支払期間外フラグ} の Hibernate ユーザー定義型です。<br />
 * 手数料支払期間外フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tsryshrkkngaiflg extends AbstractUserType<C_Tsryshrkkngaiflg> {

    @Override
    protected Class<C_Tsryshrkkngaiflg> returnType() {
        return C_Tsryshrkkngaiflg.class;
    }

    @Override
    protected C_Tsryshrkkngaiflg valueOf(String pValue) {
        return C_Tsryshrkkngaiflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tsryshrkkngaiflg pValue) {
        return pValue.getValue();
    }
}
