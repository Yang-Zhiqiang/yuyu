package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KiharaiPseisanNaiyouKbn;

/**
 * {@link C_KiharaiPseisanNaiyouKbn 既払込Ｐ精算内容区分} の Hibernate ユーザー定義型です。<br />
 * 既払込Ｐ精算内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KiharaiPseisanNaiyouKbn extends AbstractUserType<C_KiharaiPseisanNaiyouKbn> {

    @Override
    protected Class<C_KiharaiPseisanNaiyouKbn> returnType() {
        return C_KiharaiPseisanNaiyouKbn.class;
    }

    @Override
    protected C_KiharaiPseisanNaiyouKbn valueOf(String pValue) {
        return C_KiharaiPseisanNaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KiharaiPseisanNaiyouKbn pValue) {
        return pValue.getValue();
    }
}
