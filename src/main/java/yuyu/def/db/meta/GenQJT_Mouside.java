package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_PmenKbn;
import yuyu.def.classification.C_SaigaiGeninKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SensinKbn;
import yuyu.def.classification.C_SindansyoSksMaisuuKbn;
import yuyu.def.classification.C_SindansyoSksSiteiKbn;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.classification.C_SyuhiYouhi;
import yuyu.def.classification.C_TiryousakiKbn;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.db.entity.JT_Mouside;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_GeninKbn;
import yuyu.def.db.type.UserType_C_KyksyaSibouUmuKbn;
import yuyu.def.db.type.UserType_C_MousideninKbn;
import yuyu.def.db.type.UserType_C_NayoseYouhi;
import yuyu.def.db.type.UserType_C_PmenKbn;
import yuyu.def.db.type.UserType_C_SaigaiGeninKbn;
import yuyu.def.db.type.UserType_C_SeikyuuSyubetu;
import yuyu.def.db.type.UserType_C_SensinKbn;
import yuyu.def.db.type.UserType_C_SindansyoSksMaisuuKbn;
import yuyu.def.db.type.UserType_C_SindansyoSksSiteiKbn;
import yuyu.def.db.type.UserType_C_SouhusakiKbn;
import yuyu.def.db.type.UserType_C_SyuhiYouhi;
import yuyu.def.db.type.UserType_C_TiryousakiKbn;
import yuyu.def.db.type.UserType_C_UketorininSibouUmuKbn;

/**
 * 申出テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_Mouside extends AbstractExDBTable<JT_Mouside> {

    public GenQJT_Mouside() {
        this("JT_Mouside");
    }

    public GenQJT_Mouside(String pAlias) {
        super("JT_Mouside", JT_Mouside.class, pAlias);
    }

    public String JT_Mouside() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_Mouside, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_Mouside, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_Mouside, C_SeikyuuSyubetu> seikyuusyubetu = new ExDBFieldString<>("seikyuusyubetu", this, UserType_C_SeikyuuSyubetu.class);

    public final ExDBFieldString<JT_Mouside, C_NayoseYouhi> nayoseyouhi = new ExDBFieldString<>("nayoseyouhi", this, UserType_C_NayoseYouhi.class);

    public final ExDBFieldString<JT_Mouside, C_MousideninKbn> mousideninkbn = new ExDBFieldString<>("mousideninkbn", this, UserType_C_MousideninKbn.class);

    public final ExDBFieldString<JT_Mouside, C_SyuhiYouhi> syuhiyouhi = new ExDBFieldString<>("syuhiyouhi", this, UserType_C_SyuhiYouhi.class);

    public final ExDBFieldString<JT_Mouside, String> mousideninnmkj = new ExDBFieldString<>("mousideninnmkj", this);

    public final ExDBFieldString<JT_Mouside, C_UketorininSibouUmuKbn> uketorininsibouumukbn = new ExDBFieldString<>("uketorininsibouumukbn", this, UserType_C_UketorininSibouUmuKbn.class);

    public final ExDBFieldString<JT_Mouside, C_KyksyaSibouUmuKbn> kyksyasibouumukbn = new ExDBFieldString<>("kyksyasibouumukbn", this, UserType_C_KyksyaSibouUmuKbn.class);

    public final ExDBFieldString<JT_Mouside, C_SouhusakiKbn> souhusakikbn = new ExDBFieldString<>("souhusakikbn", this, UserType_C_SouhusakiKbn.class);

    public final ExDBFieldString<JT_Mouside, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JT_Mouside, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JT_Mouside, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JT_Mouside, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JT_Mouside, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<JT_Mouside, C_PmenKbn> pmenkbn = new ExDBFieldString<>("pmenkbn", this, UserType_C_PmenKbn.class);

    public final ExDBFieldString<JT_Mouside, C_GeninKbn> geninkbn = new ExDBFieldString<>("geninkbn", this, UserType_C_GeninKbn.class);

    public final ExDBFieldString<JT_Mouside, BizDate> jikosyosinymd = new ExDBFieldString<>("jikosyosinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, C_SaigaiGeninKbn> saigaigeninkbn = new ExDBFieldString<>("saigaigeninkbn", this, UserType_C_SaigaiGeninKbn.class);

    public final ExDBFieldString<JT_Mouside, BizDate> sibouymd = new ExDBFieldString<>("sibouymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, BizDate> syougaikoteiymd = new ExDBFieldString<>("syougaikoteiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, String> byoumeitourokuno = new ExDBFieldString<>("byoumeitourokuno", this);

    public final ExDBFieldString<JT_Mouside, C_TiryousakiKbn> tiryousakikbn = new ExDBFieldString<>("tiryousakikbn", this, UserType_C_TiryousakiKbn.class);

    public final ExDBFieldString<JT_Mouside, BizDate> nyuuinymd = new ExDBFieldString<>("nyuuinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, BizDate> taiinymd = new ExDBFieldString<>("taiinymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, BizDate> syujyutuymd = new ExDBFieldString<>("syujyutuymd", this, BizDateType.class);

    public final ExDBFieldString<JT_Mouside, String> syujyututourokuno = new ExDBFieldString<>("syujyututourokuno", this);

    public final ExDBFieldString<JT_Mouside, C_SensinKbn> sensinkbn = new ExDBFieldString<>("sensinkbn", this, UserType_C_SensinKbn.class);

    public final ExDBFieldString<JT_Mouside, C_SindansyoSksMaisuuKbn> sindansyosksmaisuukbn = new ExDBFieldString<>("sindansyosksmaisuukbn", this, UserType_C_SindansyoSksMaisuuKbn.class);

    public final ExDBFieldString<JT_Mouside, C_SindansyoSksSiteiKbn> sindansyoskssiteikbn = new ExDBFieldString<>("sindansyoskssiteikbn", this, UserType_C_SindansyoSksSiteiKbn.class);

    public final ExDBFieldNumber<JT_Mouside, Integer> betukyksuu = new ExDBFieldNumber<>("betukyksuu", this);

    public final ExDBFieldString<JT_Mouside, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_Mouside, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_Mouside, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_Mouside, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
