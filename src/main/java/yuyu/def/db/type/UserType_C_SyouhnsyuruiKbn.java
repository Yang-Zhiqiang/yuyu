package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouhnsyuruiKbn;

/**
 * {@link C_SyouhnsyuruiKbn 商品種類区分} の Hibernate ユーザー定義型です。<br />
 * 商品種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouhnsyuruiKbn extends AbstractUserType<C_SyouhnsyuruiKbn> {

    @Override
    protected Class<C_SyouhnsyuruiKbn> returnType() {
        return C_SyouhnsyuruiKbn.class;
    }

    @Override
    protected C_SyouhnsyuruiKbn valueOf(String pValue) {
        return C_SyouhnsyuruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouhnsyuruiKbn pValue) {
        return pValue.getValue();
    }
}
