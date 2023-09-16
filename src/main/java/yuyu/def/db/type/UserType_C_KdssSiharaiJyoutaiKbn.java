package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KdssSiharaiJyoutaiKbn;

/**
 * {@link C_KdssSiharaiJyoutaiKbn 高度障害Ｓ支払状態区分} の Hibernate ユーザー定義型です。<br />
 * 高度障害Ｓ支払状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KdssSiharaiJyoutaiKbn extends AbstractUserType<C_KdssSiharaiJyoutaiKbn> {

    @Override
    protected Class<C_KdssSiharaiJyoutaiKbn> returnType() {
        return C_KdssSiharaiJyoutaiKbn.class;
    }

    @Override
    protected C_KdssSiharaiJyoutaiKbn valueOf(String pValue) {
        return C_KdssSiharaiJyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KdssSiharaiJyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
