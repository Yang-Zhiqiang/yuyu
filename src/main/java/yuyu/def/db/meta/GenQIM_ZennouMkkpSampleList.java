package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ZennouKbn;
import yuyu.def.classification.C_ZennouToukeiListKbn;
import yuyu.def.db.entity.IM_ZennouMkkpSampleList;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ZennouKbn;
import yuyu.def.db.type.UserType_C_ZennouToukeiListKbn;

/**
 * 前納未経過Ｐ検証サンプルリストパターンマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_ZennouMkkpSampleList extends AbstractExDBTable<IM_ZennouMkkpSampleList> {

    public GenQIM_ZennouMkkpSampleList() {
        this("IM_ZennouMkkpSampleList");
    }

    public GenQIM_ZennouMkkpSampleList(String pAlias) {
        super("IM_ZennouMkkpSampleList", IM_ZennouMkkpSampleList.class, pAlias);
    }

    public String IM_ZennouMkkpSampleList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_ZennouMkkpSampleList, C_ZennouToukeiListKbn> zennoutoukeilistkbn = new ExDBFieldString<>("zennoutoukeilistkbn", this, UserType_C_ZennouToukeiListKbn.class);

    public final ExDBFieldString<IM_ZennouMkkpSampleList, C_ZennouKbn> zennoukbn = new ExDBFieldString<>("zennoukbn", this, UserType_C_ZennouKbn.class);

    public final ExDBFieldString<IM_ZennouMkkpSampleList, C_Segcd> kbnkeirisegcd = new ExDBFieldString<>("kbnkeirisegcd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<IM_ZennouMkkpSampleList, String> znnmkkpkssamplekslsttitle = new ExDBFieldString<>("znnmkkpkssamplekslsttitle", this);
}
