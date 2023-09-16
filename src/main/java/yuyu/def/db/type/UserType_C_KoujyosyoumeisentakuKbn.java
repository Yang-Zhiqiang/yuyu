package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosyoumeisentakuKbn;

/**
 * {@link C_KoujyosyoumeisentakuKbn 控除証明選択区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明選択区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosyoumeisentakuKbn extends AbstractUserType<C_KoujyosyoumeisentakuKbn> {

    @Override
    protected Class<C_KoujyosyoumeisentakuKbn> returnType() {
        return C_KoujyosyoumeisentakuKbn.class;
    }

    @Override
    protected C_KoujyosyoumeisentakuKbn valueOf(String pValue) {
        return C_KoujyosyoumeisentakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosyoumeisentakuKbn pValue) {
        return pValue.getValue();
    }
}
