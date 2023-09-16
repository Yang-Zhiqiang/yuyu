package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ListhyjKbn;

/**
 * {@link C_ListhyjKbn 一覧表示区分} の Hibernate ユーザー定義型です。<br />
 * 一覧表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ListhyjKbn extends AbstractUserType<C_ListhyjKbn> {

    @Override
    protected Class<C_ListhyjKbn> returnType() {
        return C_ListhyjKbn.class;
    }

    @Override
    protected C_ListhyjKbn valueOf(String pValue) {
        return C_ListhyjKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ListhyjKbn pValue) {
        return pValue.getValue();
    }
}
