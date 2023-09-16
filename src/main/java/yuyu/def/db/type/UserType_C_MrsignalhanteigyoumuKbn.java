package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;

/**
 * {@link C_MrsignalhanteigyoumuKbn ＭＲシグナル判定業務区分} の Hibernate ユーザー定義型です。<br />
 * ＭＲシグナル判定業務区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MrsignalhanteigyoumuKbn extends AbstractUserType<C_MrsignalhanteigyoumuKbn> {

    @Override
    protected Class<C_MrsignalhanteigyoumuKbn> returnType() {
        return C_MrsignalhanteigyoumuKbn.class;
    }

    @Override
    protected C_MrsignalhanteigyoumuKbn valueOf(String pValue) {
        return C_MrsignalhanteigyoumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MrsignalhanteigyoumuKbn pValue) {
        return pValue.getValue();
    }
}
