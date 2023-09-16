package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SkeiSoftKbn;

/**
 * {@link C_SkeiSoftKbn 新契約ソフト名称区分} の Hibernate ユーザー定義型です。<br />
 * 新契約ソフト名称区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SkeiSoftKbn extends AbstractUserType<C_SkeiSoftKbn> {

    @Override
    protected Class<C_SkeiSoftKbn> returnType() {
        return C_SkeiSoftKbn.class;
    }

    @Override
    protected C_SkeiSoftKbn valueOf(String pValue) {
        return C_SkeiSoftKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SkeiSoftKbn pValue) {
        return pValue.getValue();
    }
}
