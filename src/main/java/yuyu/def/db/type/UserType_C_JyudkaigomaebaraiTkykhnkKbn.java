package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn;

/**
 * {@link C_JyudkaigomaebaraiTkykhnkKbn 重度介護前払特約変更区分} の Hibernate ユーザー定義型です。<br />
 * 重度介護前払特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JyudkaigomaebaraiTkykhnkKbn extends AbstractUserType<C_JyudkaigomaebaraiTkykhnkKbn> {

    @Override
    protected Class<C_JyudkaigomaebaraiTkykhnkKbn> returnType() {
        return C_JyudkaigomaebaraiTkykhnkKbn.class;
    }

    @Override
    protected C_JyudkaigomaebaraiTkykhnkKbn valueOf(String pValue) {
        return C_JyudkaigomaebaraiTkykhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JyudkaigomaebaraiTkykhnkKbn pValue) {
        return pValue.getValue();
    }
}
