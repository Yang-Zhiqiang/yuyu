package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_KoudosgKeizenChkInfo;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 高度障害契前チェック情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_KoudosgKeizenChkInfo extends AbstractExDBTable<JT_KoudosgKeizenChkInfo> {

    public GenQJT_KoudosgKeizenChkInfo() {
        this("JT_KoudosgKeizenChkInfo");
    }

    public GenQJT_KoudosgKeizenChkInfo(String pAlias) {
        super("JT_KoudosgKeizenChkInfo", JT_KoudosgKeizenChkInfo.class, pAlias);
    }

    public String JT_KoudosgKeizenChkInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_KoudosgKeizenChkInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn1 = new ExDBFieldString<>("keizencheckkbn1", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment1 = new ExDBFieldString<>("keizenchecomment1", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn2 = new ExDBFieldString<>("keizencheckkbn2", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment2 = new ExDBFieldString<>("keizenchecomment2", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn3 = new ExDBFieldString<>("keizencheckkbn3", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment3 = new ExDBFieldString<>("keizenchecomment3", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn4 = new ExDBFieldString<>("keizencheckkbn4", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment4 = new ExDBFieldString<>("keizenchecomment4", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn5 = new ExDBFieldString<>("keizencheckkbn5", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment5 = new ExDBFieldString<>("keizenchecomment5", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, C_UmuKbn> keizencheckkbn6 = new ExDBFieldString<>("keizencheckkbn6", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> keizenchecomment6 = new ExDBFieldString<>("keizenchecomment6", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_KoudosgKeizenChkInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
