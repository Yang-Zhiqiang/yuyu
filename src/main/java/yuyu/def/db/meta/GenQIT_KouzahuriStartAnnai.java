package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 口座振替開始案内テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KouzahuriStartAnnai extends AbstractExDBTable<IT_KouzahuriStartAnnai> {

    public GenQIT_KouzahuriStartAnnai() {
        this("IT_KouzahuriStartAnnai");
    }

    public GenQIT_KouzahuriStartAnnai(String pAlias) {
        super("IT_KouzahuriStartAnnai", IT_KouzahuriStartAnnai.class, pAlias);
    }

    public String IT_KouzahuriStartAnnai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tuutinm = new ExDBFieldString<>("tuutinm", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> aisatumongon1 = new ExDBFieldString<>("aisatumongon1", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> aisatumongon2 = new ExDBFieldString<>("aisatumongon2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> aisatumongon3 = new ExDBFieldString<>("aisatumongon3", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> aisatumongon4 = new ExDBFieldString<>("aisatumongon4", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> aisatumongon5 = new ExDBFieldString<>("aisatumongon5", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai1 = new ExDBFieldString<>("kzhurikaeonegai1", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai2 = new ExDBFieldString<>("kzhurikaeonegai2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai3 = new ExDBFieldString<>("kzhurikaeonegai3", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai4 = new ExDBFieldString<>("kzhurikaeonegai4", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai5 = new ExDBFieldString<>("kzhurikaeonegai5", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai6 = new ExDBFieldString<>("kzhurikaeonegai6", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai7 = new ExDBFieldString<>("kzhurikaeonegai7", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai8 = new ExDBFieldString<>("kzhurikaeonegai8", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai9 = new ExDBFieldString<>("kzhurikaeonegai9", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai10 = new ExDBFieldString<>("kzhurikaeonegai10", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai11 = new ExDBFieldString<>("kzhurikaeonegai11", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai12 = new ExDBFieldString<>("kzhurikaeonegai12", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai13 = new ExDBFieldString<>("kzhurikaeonegai13", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai14 = new ExDBFieldString<>("kzhurikaeonegai14", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhurikaeonegai15 = new ExDBFieldString<>("kzhurikaeonegai15", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> tkbriphurikaeyoteigk = new ExDBFieldString<>("tkbriphurikaeyoteigk", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekzhosokumongon = new ExDBFieldString<>("hurikaekzhosokumongon", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekz1 = new ExDBFieldString<>("hurikaekz1", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekz2 = new ExDBFieldString<>("hurikaekz2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekz3 = new ExDBFieldString<>("hurikaekz3", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekz4 = new ExDBFieldString<>("hurikaekz4", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> hurikaekz5 = new ExDBFieldString<>("hurikaekz5", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawasesosikinmkj = new ExDBFieldString<>("toiawasesosikinmkj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseyno = new ExDBFieldString<>("toiawaseyno", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseadr1kj = new ExDBFieldString<>("toiawaseadr1kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseadr2kj = new ExDBFieldString<>("toiawaseadr2kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseadr3kj = new ExDBFieldString<>("toiawaseadr3kj", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawasetelno = new ExDBFieldString<>("toiawasetelno", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseteluktkkanou1 = new ExDBFieldString<>("toiawaseteluktkkanou1", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawaseteluktkkanou2 = new ExDBFieldString<>("toiawaseteluktkkanou2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawasesosikinmkj2 = new ExDBFieldString<>("toiawasesosikinmkj2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> toiawasetelno2 = new ExDBFieldString<>("toiawasetelno2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea1 = new ExDBFieldString<>("kzhuristartanfreearea1", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea2 = new ExDBFieldString<>("kzhuristartanfreearea2", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea3 = new ExDBFieldString<>("kzhuristartanfreearea3", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea4 = new ExDBFieldString<>("kzhuristartanfreearea4", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea5 = new ExDBFieldString<>("kzhuristartanfreearea5", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea6 = new ExDBFieldString<>("kzhuristartanfreearea6", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea7 = new ExDBFieldString<>("kzhuristartanfreearea7", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea8 = new ExDBFieldString<>("kzhuristartanfreearea8", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea9 = new ExDBFieldString<>("kzhuristartanfreearea9", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> kzhuristartanfreearea10 = new ExDBFieldString<>("kzhuristartanfreearea10", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KouzahuriStartAnnai, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
