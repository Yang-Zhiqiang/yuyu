package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 期日到来案内テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KijituTouraiAnnai extends AbstractExDBTable<IT_KijituTouraiAnnai> {

    public GenQIT_KijituTouraiAnnai() {
        this("IT_KijituTouraiAnnai");
    }

    public GenQIT_KijituTouraiAnnai(String pAlias) {
        super("IT_KijituTouraiAnnai", IT_KijituTouraiAnnai.class, pAlias);
    }

    public String IT_KijituTouraiAnnai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> shskyno = new ExDBFieldString<>("shskyno", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> shsadr1kj = new ExDBFieldString<>("shsadr1kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> shsadr2kj = new ExDBFieldString<>("shsadr2kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> shsadr3kj = new ExDBFieldString<>("shsadr3kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> tuutinm20keta = new ExDBFieldString<>("tuutinm20keta", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta1 = new ExDBFieldString<>("hrkykkmsg32keta1", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta2 = new ExDBFieldString<>("hrkykkmsg32keta2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta3 = new ExDBFieldString<>("hrkykkmsg32keta3", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta4 = new ExDBFieldString<>("hrkykkmsg32keta4", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta5 = new ExDBFieldString<>("hrkykkmsg32keta5", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta6 = new ExDBFieldString<>("hrkykkmsg32keta6", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta7 = new ExDBFieldString<>("hrkykkmsg32keta7", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkykkmsg32keta8 = new ExDBFieldString<>("hrkykkmsg32keta8", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea1 = new ExDBFieldString<>("kjttrnnfreearea1", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea2 = new ExDBFieldString<>("kjttrnnfreearea2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea3 = new ExDBFieldString<>("kjttrnnfreearea3", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea4 = new ExDBFieldString<>("kjttrnnfreearea4", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea5 = new ExDBFieldString<>("kjttrnnfreearea5", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea6 = new ExDBFieldString<>("kjttrnnfreearea6", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea7 = new ExDBFieldString<>("kjttrnnfreearea7", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, BizDate> hurikaeymd = new ExDBFieldString<>("hurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo1 = new ExDBFieldString<>("kzinfo1", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo2 = new ExDBFieldString<>("kzinfo2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo3 = new ExDBFieldString<>("kzinfo3", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo4 = new ExDBFieldString<>("kzinfo4", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo5 = new ExDBFieldString<>("kzinfo5", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo6 = new ExDBFieldString<>("kzinfo6", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo7 = new ExDBFieldString<>("kzinfo7", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kzinfo8 = new ExDBFieldString<>("kzinfo8", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hknjytukikan = new ExDBFieldString<>("hknjytukikan", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkgk1 = new ExDBFieldString<>("hrkgk1", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkgk2 = new ExDBFieldString<>("hrkgk2", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkgk3 = new ExDBFieldString<>("hrkgk3", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> hrkgk4 = new ExDBFieldString<>("hrkgk4", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea8 = new ExDBFieldString<>("kjttrnnfreearea8", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea9 = new ExDBFieldString<>("kjttrnnfreearea9", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea10 = new ExDBFieldString<>("kjttrnnfreearea10", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea11 = new ExDBFieldString<>("kjttrnnfreearea11", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea12 = new ExDBFieldString<>("kjttrnnfreearea12", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> kjttrnnfreearea13 = new ExDBFieldString<>("kjttrnnfreearea13", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KijituTouraiAnnai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
