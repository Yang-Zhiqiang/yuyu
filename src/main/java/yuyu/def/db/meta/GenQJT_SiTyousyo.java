package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.JT_SiTyousyo;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_ShrhousiteiKbn;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 保険金給付金支払調書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SiTyousyo extends AbstractExDBTable<JT_SiTyousyo> {

    public GenQJT_SiTyousyo() {
        this("JT_SiTyousyo");
    }

    public GenQJT_SiTyousyo(String pAlias) {
        super("JT_SiTyousyo", JT_SiTyousyo.class, pAlias);
    }

    public String JT_SiTyousyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SiTyousyo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SiTyousyo, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<JT_SiTyousyo, Long> shrtysyrenno = new ExDBFieldNumber<>("shrtysyrenno", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kacd = new ExDBFieldString<>("kacd", this);

    public final ExDBFieldString<JT_SiTyousyo, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<JT_SiTyousyo, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<JT_SiTyousyo, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiTyousyo, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<JT_SiTyousyo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<JT_SiTyousyo, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<JT_SiTyousyo, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<JT_SiTyousyo, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiTyousyo, String> mfadrsiyouhyouji = new ExDBFieldString<>("mfadrsiyouhyouji", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kihrpdmiseibidisp = new ExDBFieldString<>("kihrpdmiseibidisp", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kihrpseibiyoudisp = new ExDBFieldString<>("kihrpseibiyoudisp", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> warimsishrgkbizc = new ExDBFieldBizCurrency<>("warimsishrgkbizc", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> znnphrbizc = new ExDBFieldBizCurrency<>("znnphrbizc", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> ttkekstkganribizc = new ExDBFieldBizCurrency<>("ttkekstkganribizc", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> sshkdbizc = new ExDBFieldBizCurrency<>("sshkdbizc", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> sshkshrgk = new ExDBFieldBizCurrency<>("sshkshrgk", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> mihrkmpbizc = new ExDBFieldBizCurrency<>("mihrkmpbizc", this);

    public final ExDBFieldString<JT_SiTyousyo, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiTyousyo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<JT_SiTyousyo, String> syoritaisyoukbn = new ExDBFieldString<>("syoritaisyoukbn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysytsinyno = new ExDBFieldString<>("shrtysytsinyno", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysyadr1kj = new ExDBFieldString<>("shrtysyadr1kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysyadr2kj = new ExDBFieldString<>("shrtysyadr2kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysyadr3kj = new ExDBFieldString<>("shrtysyadr3kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kjdaihyouuktnm = new ExDBFieldString<>("kjdaihyouuktnm", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysysyuruicd = new ExDBFieldString<>("shrtysysyuruicd", this);

    public final ExDBFieldString<JT_SiTyousyo, String> teknjikihrpseibidisp = new ExDBFieldString<>("teknjikihrpseibidisp", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> kihrkmp = new ExDBFieldBizCurrency<>("kihrkmp", this);

    public final ExDBFieldString<JT_SiTyousyo, String> onlinecentercutkbn = new ExDBFieldString<>("onlinecentercutkbn", this);

    public final ExDBFieldString<JT_SiTyousyo, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<JT_SiTyousyo, String> htykeihihnsyukbn = new ExDBFieldString<>("htykeihihnsyukbn", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> syuseijtshrdbizc = new ExDBFieldBizCurrency<>("syuseijtshrdbizc", this);

    public final ExDBFieldString<JT_SiTyousyo, String> touduketorihouhoukbn = new ExDBFieldString<>("touduketorihouhoukbn", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> nenkinkkn = new ExDBFieldNumber<>("nenkinkkn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<JT_SiTyousyo, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<JT_SiTyousyo, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<JT_SiTyousyo, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<JT_SiTyousyo, String> yokinknmkn = new ExDBFieldString<>("yokinknmkn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<JT_SiTyousyo, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<JT_SiTyousyo, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SiTyousyo, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<JT_SiTyousyo, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<JT_SiTyousyo, String> jigyoukykmndantaicd = new ExDBFieldString<>("jigyoukykmndantaicd", this);

    public final ExDBFieldString<JT_SiTyousyo, String> mnsaiannaihnskakbn = new ExDBFieldString<>("mnsaiannaihnskakbn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> huho2kykdisp = new ExDBFieldString<>("huho2kykdisp", this);

    public final ExDBFieldString<JT_SiTyousyo, C_ShrtysyhknsyuKbn> shrtysyhknsyukbn = new ExDBFieldString<>("shrtysyhknsyukbn", this, UserType_C_ShrtysyhknsyuKbn.class);

    public final ExDBFieldString<JT_SiTyousyo, String> shrtysykurikosidisp = new ExDBFieldString<>("shrtysykurikosidisp", this);

    public final ExDBFieldString<JT_SiTyousyo, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<JT_SiTyousyo, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> synyhsjykykndisp = new ExDBFieldString<>("synyhsjykykndisp", this);

    public final ExDBFieldString<JT_SiTyousyo, String> tblsakuseihunodisp = new ExDBFieldString<>("tblsakuseihunodisp", this);

    public final ExDBFieldString<JT_SiTyousyo, String> daihyouktkbn = new ExDBFieldString<>("daihyouktkbn", this);

    public final ExDBFieldString<JT_SiTyousyo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<JT_SiTyousyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SiTyousyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<JT_SiTyousyo, String> oldtsinyno = new ExDBFieldString<>("oldtsinyno", this);

    public final ExDBFieldString<JT_SiTyousyo, String> oldtsinadr1kj = new ExDBFieldString<>("oldtsinadr1kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> oldtsinadr2kj = new ExDBFieldString<>("oldtsinadr2kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> oldtsinadr3kj = new ExDBFieldString<>("oldtsinadr3kj", this);

    public final ExDBFieldString<JT_SiTyousyo, String> oldkyknmkj = new ExDBFieldString<>("oldkyknmkj", this);

    public final ExDBFieldNumber<JT_SiTyousyo, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<JT_SiTyousyo, String> shrkykhtykeihiyouhyj = new ExDBFieldString<>("shrkykhtykeihiyouhyj", this);

    public final ExDBFieldBizCurrency<JT_SiTyousyo> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);
}
