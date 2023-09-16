package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriAnnaiFuyouRiyuuKbn;

/**
 * {@link C_SuuriAnnaiFuyouRiyuuKbn 数理案内不要理由区分} の Hibernate ユーザー定義型です。<br />
 * 数理案内不要理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriAnnaiFuyouRiyuuKbn extends AbstractUserType<C_SuuriAnnaiFuyouRiyuuKbn> {

    @Override
    protected Class<C_SuuriAnnaiFuyouRiyuuKbn> returnType() {
        return C_SuuriAnnaiFuyouRiyuuKbn.class;
    }

    @Override
    protected C_SuuriAnnaiFuyouRiyuuKbn valueOf(String pValue) {
        return C_SuuriAnnaiFuyouRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriAnnaiFuyouRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
