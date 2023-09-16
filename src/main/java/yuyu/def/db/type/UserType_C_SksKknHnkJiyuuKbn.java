package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SksKknHnkJiyuuKbn;

/**
 * {@link C_SksKknHnkJiyuuKbn 親権者後見人変更事由区分} の Hibernate ユーザー定義型です。<br />
 * 親権者後見人変更事由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SksKknHnkJiyuuKbn extends AbstractUserType<C_SksKknHnkJiyuuKbn> {

    @Override
    protected Class<C_SksKknHnkJiyuuKbn> returnType() {
        return C_SksKknHnkJiyuuKbn.class;
    }

    @Override
    protected C_SksKknHnkJiyuuKbn valueOf(String pValue) {
        return C_SksKknHnkJiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SksKknHnkJiyuuKbn pValue) {
        return pValue.getValue();
    }
}
