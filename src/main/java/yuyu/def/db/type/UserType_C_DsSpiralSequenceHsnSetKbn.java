package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsSpiralSequenceHsnSetKbn;

/**
 * {@link C_DsSpiralSequenceHsnSetKbn ＤＳＳＰＩＲＡＬシークエンス配信設定区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳＳＰＩＲＡＬシークエンス配信設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsSpiralSequenceHsnSetKbn extends AbstractUserType<C_DsSpiralSequenceHsnSetKbn> {

    @Override
    protected Class<C_DsSpiralSequenceHsnSetKbn> returnType() {
        return C_DsSpiralSequenceHsnSetKbn.class;
    }

    @Override
    protected C_DsSpiralSequenceHsnSetKbn valueOf(String pValue) {
        return C_DsSpiralSequenceHsnSetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsSpiralSequenceHsnSetKbn pValue) {
        return pValue.getValue();
    }
}
