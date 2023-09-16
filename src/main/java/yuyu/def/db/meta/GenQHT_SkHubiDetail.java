package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_SkHubiDetail;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HasinkyokaKbn;
import yuyu.def.db.type.UserType_C_HassinsakiKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 新契約不備詳細テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_SkHubiDetail extends AbstractExDBTable<HT_SkHubiDetail> {

    public GenQHT_SkHubiDetail() {
        this("HT_SkHubiDetail");
    }

    public GenQHT_SkHubiDetail(String pAlias) {
        super("HT_SkHubiDetail", HT_SkHubiDetail.class, pAlias);
    }

    public String HT_SkHubiDetail() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_SkHubiDetail, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_SkHubiDetail, String> hubisikibetukey = new ExDBFieldString<>("hubisikibetukey", this);

    public final ExDBFieldNumber<HT_SkHubiDetail, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<HT_SkHubiDetail, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<HT_SkHubiDetail, String> skhubikoumokucd = new ExDBFieldString<>("skhubikoumokucd", this);

    public final ExDBFieldString<HT_SkHubiDetail, String> skhubinaiyoucd = new ExDBFieldString<>("skhubinaiyoucd", this);

    public final ExDBFieldString<HT_SkHubiDetail, String> skseibisijinaiyoucd = new ExDBFieldString<>("skseibisijinaiyoucd", this);

    public final ExDBFieldString<HT_SkHubiDetail, C_UmuKbn> tyoubunflg = new ExDBFieldString<>("tyoubunflg", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HT_SkHubiDetail, String> skrenrakujikou = new ExDBFieldString<>("skrenrakujikou", this);

    public final ExDBFieldString<HT_SkHubiDetail, BizDate> trkymd = new ExDBFieldString<>("trkymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkHubiDetail, BizDate> hasinymd = new ExDBFieldString<>("hasinymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkHubiDetail, BizDate> kaisyouymd = new ExDBFieldString<>("kaisyouymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkHubiDetail, C_HassinsakiKbn> hassinsakikbn = new ExDBFieldString<>("hassinsakikbn", this, UserType_C_HassinsakiKbn.class);

    public final ExDBFieldString<HT_SkHubiDetail, C_HasinkyokaKbn> hasinkyokakbn = new ExDBFieldString<>("hasinkyokakbn", this, UserType_C_HasinkyokaKbn.class);

    public final ExDBFieldString<HT_SkHubiDetail, BizDate> hubiitiransksymd = new ExDBFieldString<>("hubiitiransksymd", this, BizDateType.class);

    public final ExDBFieldString<HT_SkHubiDetail, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_SkHubiDetail, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
