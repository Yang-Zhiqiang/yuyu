package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SdrtntsryrankKbn;

/**
 * {@link C_SdrtntsryrankKbn 総代理店手数料ランク区分} の Hibernate ユーザー定義型です。<br />
 * 総代理店手数料ランク区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SdrtntsryrankKbn extends AbstractUserType<C_SdrtntsryrankKbn> {

    @Override
    protected Class<C_SdrtntsryrankKbn> returnType() {
        return C_SdrtntsryrankKbn.class;
    }

    @Override
    protected C_SdrtntsryrankKbn valueOf(String pValue) {
        return C_SdrtntsryrankKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SdrtntsryrankKbn pValue) {
        return pValue.getValue();
    }
}
