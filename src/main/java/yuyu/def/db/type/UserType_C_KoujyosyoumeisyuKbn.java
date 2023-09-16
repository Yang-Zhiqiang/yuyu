package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosyoumeisyuKbn;

/**
 * {@link C_KoujyosyoumeisyuKbn 控除証明種類区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosyoumeisyuKbn extends AbstractUserType<C_KoujyosyoumeisyuKbn> {

    @Override
    protected Class<C_KoujyosyoumeisyuKbn> returnType() {
        return C_KoujyosyoumeisyuKbn.class;
    }

    @Override
    protected C_KoujyosyoumeisyuKbn valueOf(String pValue) {
        return C_KoujyosyoumeisyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosyoumeisyuKbn pValue) {
        return pValue.getValue();
    }
}
