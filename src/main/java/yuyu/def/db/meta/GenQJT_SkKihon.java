package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HubiJyoukyouKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_TyousaJyoukyouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SkKihon;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_HubiJyoukyouKbn;
import yuyu.def.db.type.UserType_C_Kyksei;
import yuyu.def.db.type.UserType_C_SaigaiHigaitouKbn;
import yuyu.def.db.type.UserType_C_SaisateiKbn;
import yuyu.def.db.type.UserType_C_SateiYouhiKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_ShrKekkaKbn;
import yuyu.def.db.type.UserType_C_SyoriJyoutaiKbn;
import yuyu.def.db.type.UserType_C_TyousaJyoukyouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 請求基本テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SkKihon extends AbstractExDBTable<JT_SkKihon> {

    public GenQJT_SkKihon() {
        this("JT_SkKihon");
    }

    public GenQJT_SkKihon(String pAlias) {
        super("JT_SkKihon", JT_SkKihon.class, pAlias);
    }

    public String JT_SkKihon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SkKihon, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SkKihon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SkKihon, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JT_SkKihon, C_SaisateiKbn> saisateikbn = new ExDBFieldString<>("saisateikbn", this, UserType_C_SaisateiKbn.class);

    public final ExDBFieldString<JT_SkKihon, BizDate> siboukaritrkymd = new ExDBFieldString<>("siboukaritrkymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKihon, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<JT_SkKihon, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<JT_SkKihon, BizDate> kykseiymd = new ExDBFieldString<>("kykseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKihon, C_Kyksei> kyksei = new ExDBFieldString<>("kyksei", this, UserType_C_Kyksei.class);

    public final ExDBFieldString<JT_SkKihon, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<JT_SkKihon, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<JT_SkKihon, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKihon, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<JT_SkKihon, C_SyoriJyoutaiKbn> syorijyoutaikbn = new ExDBFieldString<>("syorijyoutaikbn", this, UserType_C_SyoriJyoutaiKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_SateiYouhiKbn> sateiyhkbn = new ExDBFieldString<>("sateiyhkbn", this, UserType_C_SateiYouhiKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_UmuKbn> kakninumukbn = new ExDBFieldString<>("kakninumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_HubiJyoukyouKbn> hubijyoukyoukbn = new ExDBFieldString<>("hubijyoukyoukbn", this, UserType_C_HubiJyoukyouKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_TyousaJyoukyouKbn> tyousajyoukyoukbn = new ExDBFieldString<>("tyousajyoukyoukbn", this, UserType_C_TyousaJyoukyouKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_ShrKekkaKbn> shrkekkakbn = new ExDBFieldString<>("shrkekkakbn", this, UserType_C_ShrKekkaKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_UmuKbn> sbjishrumukbn = new ExDBFieldString<>("sbjishrumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JT_SkKihon, C_SaigaiHigaitouKbn> saigaihigaitoukbn = new ExDBFieldString<>("saigaihigaitoukbn", this, UserType_C_SaigaiHigaitouKbn.class);

    public final ExDBFieldString<JT_SkKihon, BizDate> gaibuinsatuoutymd = new ExDBFieldString<>("gaibuinsatuoutymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SkKihon, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SkKihon, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SkKihon, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SkKihon, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
