package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;

/**
 * {@link C_KoujyosyoumeimsgKbn 控除証明メッセージ区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明メッセージ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KoujyosyoumeimsgKbn extends AbstractUserType<C_KoujyosyoumeimsgKbn> {

    @Override
    protected Class<C_KoujyosyoumeimsgKbn> returnType() {
        return C_KoujyosyoumeimsgKbn.class;
    }

    @Override
    protected C_KoujyosyoumeimsgKbn valueOf(String pValue) {
        return C_KoujyosyoumeimsgKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KoujyosyoumeimsgKbn pValue) {
        return pValue.getValue();
    }
}
