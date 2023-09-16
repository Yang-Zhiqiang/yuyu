package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknsekkeisousaKbn;

/**
 * {@link C_HknsekkeisousaKbn 保険設計操作区分} の Hibernate ユーザー定義型です。<br />
 * 保険設計操作区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknsekkeisousaKbn extends AbstractUserType<C_HknsekkeisousaKbn> {

    @Override
    protected Class<C_HknsekkeisousaKbn> returnType() {
        return C_HknsekkeisousaKbn.class;
    }

    @Override
    protected C_HknsekkeisousaKbn valueOf(String pValue) {
        return C_HknsekkeisousaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknsekkeisousaKbn pValue) {
        return pValue.getValue();
    }
}
