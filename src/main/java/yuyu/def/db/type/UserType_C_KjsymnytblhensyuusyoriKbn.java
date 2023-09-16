package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;

/**
 * {@link C_KjsymnytblhensyuusyoriKbn 控除証明内容ＴＢＬ編集処理区分} の Hibernate ユーザー定義型です。<br />
 * 控除証明内容ＴＢＬ編集処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KjsymnytblhensyuusyoriKbn extends AbstractUserType<C_KjsymnytblhensyuusyoriKbn> {

    @Override
    protected Class<C_KjsymnytblhensyuusyoriKbn> returnType() {
        return C_KjsymnytblhensyuusyoriKbn.class;
    }

    @Override
    protected C_KjsymnytblhensyuusyoriKbn valueOf(String pValue) {
        return C_KjsymnytblhensyuusyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KjsymnytblhensyuusyoriKbn pValue) {
        return pValue.getValue();
    }
}
