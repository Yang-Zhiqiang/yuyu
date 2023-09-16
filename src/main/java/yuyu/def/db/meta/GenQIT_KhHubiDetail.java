package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KhHubiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HasinkyokaKbn;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 契約保全不備詳細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHubiDetail extends AbstractExDBTable<IT_KhHubiDetail> {

    public GenQIT_KhHubiDetail() {
        this("IT_KhHubiDetail");
    }

    public GenQIT_KhHubiDetail(String pAlias) {
        super("IT_KhHubiDetail", IT_KhHubiDetail.class, pAlias);
    }

    public String IT_KhHubiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHubiDetail, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldNumber<IT_KhHubiDetail, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_KhHubiDetail, C_SyoruiCdKbn> hubisyoruicd = new ExDBFieldString<>("hubisyoruicd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_KhHubiDetail, String> hubisyoruinm = new ExDBFieldString<>("hubisyoruinm", this);

    public final ExDBFieldString<IT_KhHubiDetail, String> hubinaiyoucd = new ExDBFieldString<>("hubinaiyoucd", this);

    public final ExDBFieldString<IT_KhHubiDetail, String> hubinaiyoumsg = new ExDBFieldString<>("hubinaiyoumsg", this);

    public final ExDBFieldString<IT_KhHubiDetail, C_UmuKbn> genponhnkykumu = new ExDBFieldString<>("genponhnkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_KhHubiDetail, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiDetail, BizDate> hasinymd = new ExDBFieldString<>("hasinymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiDetail, BizDate> kaisyouymd = new ExDBFieldString<>("kaisyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhHubiDetail, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<IT_KhHubiDetail, C_HasinkyokaKbn> hasinkyokakbn = new ExDBFieldString<>("hasinkyokakbn", this, UserType_C_HasinkyokaKbn.class);

    public final ExDBFieldString<IT_KhHubiDetail, String> hubitourokuktntid = new ExDBFieldString<>("hubitourokuktntid", this);

    public final ExDBFieldString<IT_KhHubiDetail, String> hubisyouninktntid = new ExDBFieldString<>("hubisyouninktntid", this);

    public final ExDBFieldString<IT_KhHubiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHubiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
