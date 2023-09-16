package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SiSyoruisakuseiKbn;

/**
 * {@link C_SiSyoruisakuseiKbn 保険金給付金書類作成区分} の Hibernate ユーザー定義型です。<br />
 * 保険金給付金書類作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SiSyoruisakuseiKbn extends AbstractUserType<C_SiSyoruisakuseiKbn> {

    @Override
    protected Class<C_SiSyoruisakuseiKbn> returnType() {
        return C_SiSyoruisakuseiKbn.class;
    }

    @Override
    protected C_SiSyoruisakuseiKbn valueOf(String pValue) {
        return C_SiSyoruisakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SiSyoruisakuseiKbn pValue) {
        return pValue.getValue();
    }
}
