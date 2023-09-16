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
import yuyu.def.db.entity.IT_KhTyousyo;
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
 * 契約保全支払調書テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhTyousyo extends AbstractExDBTable<IT_KhTyousyo> {

    public GenQIT_KhTyousyo() {
        this("IT_KhTyousyo");
    }

    public GenQIT_KhTyousyo(String pAlias) {
        super("IT_KhTyousyo", IT_KhTyousyo.class, pAlias);
    }

    public String IT_KhTyousyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhTyousyo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhTyousyo, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<IT_KhTyousyo, Long> shrtysyrenno = new ExDBFieldNumber<>("shrtysyrenno", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kacd = new ExDBFieldString<>("kacd", this);

    public final ExDBFieldString<IT_KhTyousyo, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_KhTyousyo, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<IT_KhTyousyo, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyousyo, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<IT_KhTyousyo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_KhTyousyo, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_KhTyousyo, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_KhTyousyo, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyousyo, String> mfadrsiyouhyouji = new ExDBFieldString<>("mfadrsiyouhyouji", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kihrpdmiseibidisp = new ExDBFieldString<>("kihrpdmiseibidisp", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kihrpseibiyoudisp = new ExDBFieldString<>("kihrpseibiyoudisp", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> warimsishrgkbizc = new ExDBFieldBizCurrency<>("warimsishrgkbizc", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> znnphrbizc = new ExDBFieldBizCurrency<>("znnphrbizc", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> ttkekstkganribizc = new ExDBFieldBizCurrency<>("ttkekstkganribizc", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> sshkdbizc = new ExDBFieldBizCurrency<>("sshkdbizc", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> sshkshrgk = new ExDBFieldBizCurrency<>("sshkshrgk", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> mihrkmpbizc = new ExDBFieldBizCurrency<>("mihrkmpbizc", this);

    public final ExDBFieldString<IT_KhTyousyo, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyousyo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<IT_KhTyousyo, String> syoritaisyoukbn = new ExDBFieldString<>("syoritaisyoukbn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysytsinyno = new ExDBFieldString<>("shrtysytsinyno", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysyadr1kj = new ExDBFieldString<>("shrtysyadr1kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysyadr2kj = new ExDBFieldString<>("shrtysyadr2kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysyadr3kj = new ExDBFieldString<>("shrtysyadr3kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kjdaihyouuktnm = new ExDBFieldString<>("kjdaihyouuktnm", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysysyuruicd = new ExDBFieldString<>("shrtysysyuruicd", this);

    public final ExDBFieldString<IT_KhTyousyo, String> teknjikihrpseibidisp = new ExDBFieldString<>("teknjikihrpseibidisp", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> kihrkmp = new ExDBFieldBizCurrency<>("kihrkmp", this);

    public final ExDBFieldString<IT_KhTyousyo, String> onlinecentercutkbn = new ExDBFieldString<>("onlinecentercutkbn", this);

    public final ExDBFieldString<IT_KhTyousyo, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<IT_KhTyousyo, String> htykeihihnsyukbn = new ExDBFieldString<>("htykeihihnsyukbn", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> syuseijtshrdbizc = new ExDBFieldBizCurrency<>("syuseijtshrdbizc", this);

    public final ExDBFieldString<IT_KhTyousyo, String> touduketorihouhoukbn = new ExDBFieldString<>("touduketorihouhoukbn", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> nenkinkkn = new ExDBFieldNumber<>("nenkinkkn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_KhTyousyo, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_KhTyousyo, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<IT_KhTyousyo, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_KhTyousyo, String> yokinknmkn = new ExDBFieldString<>("yokinknmkn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_KhTyousyo, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_KhTyousyo, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_KhTyousyo, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<IT_KhTyousyo, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<IT_KhTyousyo, String> jigyoukykmndantaicd = new ExDBFieldString<>("jigyoukykmndantaicd", this);

    public final ExDBFieldString<IT_KhTyousyo, String> mnsaiannaihnskakbn = new ExDBFieldString<>("mnsaiannaihnskakbn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> huho2kykdisp = new ExDBFieldString<>("huho2kykdisp", this);

    public final ExDBFieldString<IT_KhTyousyo, C_ShrtysyhknsyuKbn> shrtysyhknsyukbn = new ExDBFieldString<>("shrtysyhknsyukbn", this, UserType_C_ShrtysyhknsyuKbn.class);

    public final ExDBFieldString<IT_KhTyousyo, String> shrtysykurikosidisp = new ExDBFieldString<>("shrtysykurikosidisp", this);

    public final ExDBFieldString<IT_KhTyousyo, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_KhTyousyo, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> synyhsjykykndisp = new ExDBFieldString<>("synyhsjykykndisp", this);

    public final ExDBFieldString<IT_KhTyousyo, String> tblsakuseihunodisp = new ExDBFieldString<>("tblsakuseihunodisp", this);

    public final ExDBFieldString<IT_KhTyousyo, String> daihyouktkbn = new ExDBFieldString<>("daihyouktkbn", this);

    public final ExDBFieldString<IT_KhTyousyo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhTyousyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhTyousyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_KhTyousyo, String> oldtsinyno = new ExDBFieldString<>("oldtsinyno", this);

    public final ExDBFieldString<IT_KhTyousyo, String> oldtsinadr1kj = new ExDBFieldString<>("oldtsinadr1kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> oldtsinadr2kj = new ExDBFieldString<>("oldtsinadr2kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> oldtsinadr3kj = new ExDBFieldString<>("oldtsinadr3kj", this);

    public final ExDBFieldString<IT_KhTyousyo, String> oldkyknmkj = new ExDBFieldString<>("oldkyknmkj", this);

    public final ExDBFieldNumber<IT_KhTyousyo, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<IT_KhTyousyo, String> shrkykhtykeihiyouhyj = new ExDBFieldString<>("shrkykhtykeihiyouhyj", this);

    public final ExDBFieldBizCurrency<IT_KhTyousyo> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);
}
