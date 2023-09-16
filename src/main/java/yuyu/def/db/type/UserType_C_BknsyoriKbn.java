package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BknsyoriKbn;

/**
 * {@link C_BknsyoriKbn 備金処理区分} の Hibernate ユーザー定義型です。<br />
 * 備金処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BknsyoriKbn extends AbstractUserType<C_BknsyoriKbn> {

    @Override
    protected Class<C_BknsyoriKbn> returnType() {
        return C_BknsyoriKbn.class;
    }

    @Override
    protected C_BknsyoriKbn valueOf(String pValue) {
        return C_BknsyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BknsyoriKbn pValue) {
        return pValue.getValue();
    }
}
