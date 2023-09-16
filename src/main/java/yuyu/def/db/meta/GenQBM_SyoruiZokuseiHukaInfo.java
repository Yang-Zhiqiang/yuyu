package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 書類属性付加情報マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SyoruiZokuseiHukaInfo extends AbstractExDBTable<BM_SyoruiZokuseiHukaInfo> {

    public GenQBM_SyoruiZokuseiHukaInfo() {
        this("BM_SyoruiZokuseiHukaInfo");
    }

    public GenQBM_SyoruiZokuseiHukaInfo(String pAlias) {
        super("BM_SyoruiZokuseiHukaInfo", BM_SyoruiZokuseiHukaInfo.class, pAlias);
    }

    public String BM_SyoruiZokuseiHukaInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SyoruiZokuseiHukaInfo, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<BM_SyoruiZokuseiHukaInfo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BM_SyoruiZokuseiHukaInfo, C_UmuKbn> tyouhyououtkinousiyouumu = new ExDBFieldString<>("tyouhyououtkinousiyouumu", this, UserType_C_UmuKbn.class);
}
