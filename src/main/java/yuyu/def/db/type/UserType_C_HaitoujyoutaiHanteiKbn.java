package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitoujyoutaiHanteiKbn;

/**
 * {@link C_HaitoujyoutaiHanteiKbn 配当状態判定区分} の Hibernate ユーザー定義型です。<br />
 * 配当状態判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitoujyoutaiHanteiKbn extends AbstractUserType<C_HaitoujyoutaiHanteiKbn> {

    @Override
    protected Class<C_HaitoujyoutaiHanteiKbn> returnType() {
        return C_HaitoujyoutaiHanteiKbn.class;
    }

    @Override
    protected C_HaitoujyoutaiHanteiKbn valueOf(String pValue) {
        return C_HaitoujyoutaiHanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitoujyoutaiHanteiKbn pValue) {
        return pValue.getValue();
    }
}
