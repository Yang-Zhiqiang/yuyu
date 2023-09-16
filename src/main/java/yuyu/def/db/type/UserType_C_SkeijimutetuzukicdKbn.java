package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkeijimutetuzukicdKbn;

/**
 * {@link C_SkeijimutetuzukicdKbn 新契約事務手続コード区分} の Hibernate ユーザー定義型です。<br />
 * 新契約事務手続コード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkeijimutetuzukicdKbn extends AbstractUserType<C_SkeijimutetuzukicdKbn> {

    @Override
    protected Class<C_SkeijimutetuzukicdKbn> returnType() {
        return C_SkeijimutetuzukicdKbn.class;
    }

    @Override
    protected C_SkeijimutetuzukicdKbn valueOf(String pValue) {
        return C_SkeijimutetuzukicdKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkeijimutetuzukicdKbn pValue) {
        return pValue.getValue();
    }
}
