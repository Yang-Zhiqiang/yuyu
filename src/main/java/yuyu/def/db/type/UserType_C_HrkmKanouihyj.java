package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HrkmKanouihyj;

/**
 * {@link C_HrkmKanouihyj 振込可能支店表示} の Hibernate ユーザー定義型です。<br />
 * 振込可能支店表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HrkmKanouihyj extends AbstractUserType<C_HrkmKanouihyj> {

    @Override
    protected Class<C_HrkmKanouihyj> returnType() {
        return C_HrkmKanouihyj.class;
    }

    @Override
    protected C_HrkmKanouihyj valueOf(String pValue) {
        return C_HrkmKanouihyj.valueOf(pValue);
    }

    @Override
    protected String toString(C_HrkmKanouihyj pValue) {
        return pValue.getValue();
    }
}
