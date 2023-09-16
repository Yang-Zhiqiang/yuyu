package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KanjyoukmkgroupKbn;

/**
 * {@link C_KanjyoukmkgroupKbn 勘定科目グループ区分} の Hibernate ユーザー定義型です。<br />
 * 勘定科目グループ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KanjyoukmkgroupKbn extends AbstractUserType<C_KanjyoukmkgroupKbn> {

    @Override
    protected Class<C_KanjyoukmkgroupKbn> returnType() {
        return C_KanjyoukmkgroupKbn.class;
    }

    @Override
    protected C_KanjyoukmkgroupKbn valueOf(String pValue) {
        return C_KanjyoukmkgroupKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KanjyoukmkgroupKbn pValue) {
        return pValue.getValue();
    }
}
