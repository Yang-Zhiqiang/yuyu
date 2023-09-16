package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_CrosstkKbn;

/**
 * {@link C_CrosstkKbn クロス特例区分} の Hibernate ユーザー定義型です。<br />
 * クロス特例区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_CrosstkKbn extends AbstractUserType<C_CrosstkKbn> {

    @Override
    protected Class<C_CrosstkKbn> returnType() {
        return C_CrosstkKbn.class;
    }

    @Override
    protected C_CrosstkKbn valueOf(String pValue) {
        return C_CrosstkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_CrosstkKbn pValue) {
        return pValue.getValue();
    }
}
