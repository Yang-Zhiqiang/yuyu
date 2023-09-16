package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SiHubiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払不備詳細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiHubiDetail extends AbstractExDBTable<JT_SiHubiDetail> {

    public GenQJT_SiHubiDetail() {
        this("JT_SiHubiDetail");
    }

    public GenQJT_SiHubiDetail(String pAlias) {
        super("JT_SiHubiDetail", JT_SiHubiDetail.class, pAlias);
    }

    public String JT_SiHubiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiHubiDetail, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldNumber<JT_SiHubiDetail, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<JT_SiHubiDetail, C_SyoruiCdKbn> hubisyoruicd = new ExDBFieldString<>("hubisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<JT_SiHubiDetail, String> hubisyoruinm = new ExDBFieldString<>("hubisyoruinm", this);

    public final ExDBFieldString<JT_SiHubiDetail, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<JT_SiHubiDetail, String> hubinaiyoumsg = new ExDBFieldString<>("hubinaiyoumsg", this);

    public final ExDBFieldString<JT_SiHubiDetail, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SiHubiDetail, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiHubiDetail, BizDate> hasinymd = new ExDBFieldString<>("hasinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiHubiDetail, BizDate> kaisyouymd = new ExDBFieldString<>("kaisyouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiHubiDetail, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<JT_SiHubiDetail, String> hubitourokuktntid = new ExDBFieldString<>("hubitourokuktntid", this);

    public final ExDBFieldString<JT_SiHubiDetail, String> hubisyouninktntid = new ExDBFieldString<>("hubisyouninktntid", this);

    public final ExDBFieldString<JT_SiHubiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiHubiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
