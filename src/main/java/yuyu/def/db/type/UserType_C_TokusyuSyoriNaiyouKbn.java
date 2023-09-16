package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;

/**
 * {@link C_TokusyuSyoriNaiyouKbn 特殊処理内容区分} の Hibernate ユーザー定義型です。<br />
 * 特殊処理内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TokusyuSyoriNaiyouKbn extends AbstractUserType<C_TokusyuSyoriNaiyouKbn> {

    @Override
    protected Class<C_TokusyuSyoriNaiyouKbn> returnType() {
        return C_TokusyuSyoriNaiyouKbn.class;
    }

    @Override
    protected C_TokusyuSyoriNaiyouKbn valueOf(String pValue) {
        return C_TokusyuSyoriNaiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TokusyuSyoriNaiyouKbn pValue) {
        return pValue.getValue();
    }
}
