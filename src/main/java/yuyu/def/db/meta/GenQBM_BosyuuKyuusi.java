package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_BoskyuusiKijyunymdKbn;
import yuyu.def.classification.C_BoskyuusiRiyuuKbn;
import yuyu.def.classification.C_HubisyubetuKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.db.entity.BM_BosyuuKyuusi;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_BoskyuusiKijyunymdKbn;
import yuyu.def.db.type.UserType_C_BoskyuusiRiyuuKbn;
import yuyu.def.db.type.UserType_C_HubisyubetuKbn;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_SkeijimuKbn;
import yuyu.def.db.type.UserType_C_SysKbn;

/**
 * 募集休止マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_BosyuuKyuusi extends AbstractExDBTable<BM_BosyuuKyuusi> {

    public GenQBM_BosyuuKyuusi() {
        this("BM_BosyuuKyuusi");
    }

    public GenQBM_BosyuuKyuusi(String pAlias) {
        super("BM_BosyuuKyuusi", BM_BosyuuKyuusi.class, pAlias);
    }

    public String BM_BosyuuKyuusi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_BosyuuKyuusi, C_SysKbn> sksyskbn = new ExDBFieldString<>("sksyskbn", this, UserType_C_SysKbn.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> yoteiriritutkybr1 = new ExDBFieldString<>("yoteiriritutkybr1", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> yoteiriritutkybr2 = new ExDBFieldString<>("yoteiriritutkybr2", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, C_SkeijimuKbn> skeijimukbn = new ExDBFieldString<>("skeijimukbn", this, UserType_C_SkeijimuKbn.class);

    public final ExDBFieldNumber<BM_BosyuuKyuusi, Integer> hanteiyuusendo = new ExDBFieldNumber<>("hanteiyuusendo", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, C_BoskyuusiKijyunymdKbn> boskyuusikijyunymdkbn = new ExDBFieldString<>("boskyuusikijyunymdkbn", this, UserType_C_BoskyuusiKijyunymdKbn.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, BizDate> kyuusiymdfrom = new ExDBFieldString<>("kyuusiymdfrom", this, BizDateType.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, BizDate> kyuusiymdto = new ExDBFieldString<>("kyuusiymdto", this, BizDateType.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, C_BoskyuusiRiyuuKbn> boskyuusiriyuukbn = new ExDBFieldString<>("boskyuusiriyuukbn", this, UserType_C_BoskyuusiRiyuuKbn.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, C_HubisyubetuKbn> hubisyubetukbn = new ExDBFieldString<>("hubisyubetukbn", this, UserType_C_HubisyubetuKbn.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, C_KahiKbn> tokuninkahikbn = new ExDBFieldString<>("tokuninkahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> hubimsg = new ExDBFieldString<>("hubimsg", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> seihowebmessage1 = new ExDBFieldString<>("seihowebmessage1", this);

    public final ExDBFieldString<BM_BosyuuKyuusi, String> seihowebmessage2 = new ExDBFieldString<>("seihowebmessage2", this);
}
