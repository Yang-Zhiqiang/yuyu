package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_BunsyoSyubetuKbn;
import yuyu.def.db.type.UserType_C_Channelcd;

/**
 * 文書番号設定マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_BunsyonoSettei extends AbstractExDBTable<BM_BunsyonoSettei> {

    public GenQBM_BunsyonoSettei() {
        this("BM_BunsyonoSettei");
    }

    public GenQBM_BunsyonoSettei(String pAlias) {
        super("BM_BunsyonoSettei", BM_BunsyonoSettei.class, pAlias);
    }

    public String BM_BunsyonoSettei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_BunsyonoSettei, C_BunsyoSyubetuKbn> bunsyosyubetukbn = new ExDBFieldString<>("bunsyosyubetukbn", this, UserType_C_BunsyoSyubetuKbn.class);

    public final ExDBFieldString<BM_BunsyonoSettei, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<BM_BunsyonoSettei, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<BM_BunsyonoSettei, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldNumber<BM_BunsyonoSettei, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<BM_BunsyonoSettei, BizDate> tekiyouYmdFrom = new ExDBFieldString<>("tekiyouYmdFrom", this, BizDateType.class);

    public final ExDBFieldString<BM_BunsyonoSettei, BizDate> tekiyouYmdTo = new ExDBFieldString<>("tekiyouYmdTo", this, BizDateType.class);

    public final ExDBFieldString<BM_BunsyonoSettei, String> bunsyono = new ExDBFieldString<>("bunsyono", this);

    public final ExDBFieldString<BM_BunsyonoSettei, String> siorino = new ExDBFieldString<>("siorino", this);
}
