package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;

/**
 * {@link C_MvaTekiyoujyoutaiKbn ＭＶＡ適用状態区分} の Hibernate ユーザー定義型です。<br />
 * ＭＶＡ適用状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MvaTekiyoujyoutaiKbn extends AbstractUserType<C_MvaTekiyoujyoutaiKbn> {

    @Override
    protected Class<C_MvaTekiyoujyoutaiKbn> returnType() {
        return C_MvaTekiyoujyoutaiKbn.class;
    }

    @Override
    protected C_MvaTekiyoujyoutaiKbn valueOf(String pValue) {
        return C_MvaTekiyoujyoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MvaTekiyoujyoutaiKbn pValue) {
        return pValue.getValue();
    }
}
