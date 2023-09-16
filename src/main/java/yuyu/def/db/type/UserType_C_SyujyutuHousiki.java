package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyujyutuHousiki;

/**
 * {@link C_SyujyutuHousiki 手術方式} の Hibernate ユーザー定義型です。<br />
 * 手術方式 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyujyutuHousiki extends AbstractUserType<C_SyujyutuHousiki> {

    @Override
    protected Class<C_SyujyutuHousiki> returnType() {
        return C_SyujyutuHousiki.class;
    }

    @Override
    protected C_SyujyutuHousiki valueOf(String pValue) {
        return C_SyujyutuHousiki.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyujyutuHousiki pValue) {
        return pValue.getValue();
    }
}
