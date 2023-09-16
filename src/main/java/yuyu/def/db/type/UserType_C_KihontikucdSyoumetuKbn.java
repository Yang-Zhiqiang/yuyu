package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;

/**
 * {@link C_KihontikucdSyoumetuKbn 基本地区コード消滅理由区分} の Hibernate ユーザー定義型です。<br />
 * 基本地区コード消滅理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KihontikucdSyoumetuKbn extends AbstractUserType<C_KihontikucdSyoumetuKbn> {

    @Override
    protected Class<C_KihontikucdSyoumetuKbn> returnType() {
        return C_KihontikucdSyoumetuKbn.class;
    }

    @Override
    protected C_KihontikucdSyoumetuKbn valueOf(String pValue) {
        return C_KihontikucdSyoumetuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KihontikucdSyoumetuKbn pValue) {
        return pValue.getValue();
    }
}
