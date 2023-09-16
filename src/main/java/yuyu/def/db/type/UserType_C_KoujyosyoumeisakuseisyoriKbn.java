package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;

/**
 * {@link C_KoujyosyoumeisakuseisyoriKbn 控除証明作成処理区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明作成処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosyoumeisakuseisyoriKbn extends AbstractUserType<C_KoujyosyoumeisakuseisyoriKbn> {

    @Override
    protected Class<C_KoujyosyoumeisakuseisyoriKbn> returnType() {
        return C_KoujyosyoumeisakuseisyoriKbn.class;
    }

    @Override
    protected C_KoujyosyoumeisakuseisyoriKbn valueOf(String pValue) {
        return C_KoujyosyoumeisakuseisyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosyoumeisakuseisyoriKbn pValue) {
        return pValue.getValue();
    }
}
