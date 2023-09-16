package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosyoumeisyooutKbn;

/**
 * {@link C_KoujyosyoumeisyooutKbn 控除証明書出力区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明書出力区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosyoumeisyooutKbn extends AbstractUserType<C_KoujyosyoumeisyooutKbn> {

    @Override
    protected Class<C_KoujyosyoumeisyooutKbn> returnType() {
        return C_KoujyosyoumeisyooutKbn.class;
    }

    @Override
    protected C_KoujyosyoumeisyooutKbn valueOf(String pValue) {
        return C_KoujyosyoumeisyooutKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosyoumeisyooutKbn pValue) {
        return pValue.getValue();
    }
}
