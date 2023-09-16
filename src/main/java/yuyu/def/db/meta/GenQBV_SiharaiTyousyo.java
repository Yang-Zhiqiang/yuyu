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
import yuyu.def.db.entity.BV_SiharaiTyousyo;
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
 * 支払調書ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBV_SiharaiTyousyo extends AbstractExDBTable<BV_SiharaiTyousyo> {

    public GenQBV_SiharaiTyousyo() {
        this("BV_SiharaiTyousyo");
    }

    public GenQBV_SiharaiTyousyo(String pAlias) {
        super("BV_SiharaiTyousyo", BV_SiharaiTyousyo.class, pAlias);
    }

    public String BV_SiharaiTyousyo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BV_SiharaiTyousyo, String> subSystemId = new ExDBFieldString<>("subSystemId", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Long> shrtysyrenno = new ExDBFieldNumber<>("shrtysyrenno", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kacd = new ExDBFieldString<>("kacd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> hknkkn = new ExDBFieldNumber<>("hknkkn", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> hrkkkn = new ExDBFieldNumber<>("hrkkkn", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> kyknen = new ExDBFieldNumber<>("kyknen", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> annaihuyouriyuukbn = new ExDBFieldString<>("annaihuyouriyuukbn", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, BizDate> kouryokuhasseiymd = new ExDBFieldString<>("kouryokuhasseiymd", this, BizDateType.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> mfadrsiyouhyouji = new ExDBFieldString<>("mfadrsiyouhyouji", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kihrpdmiseibidisp = new ExDBFieldString<>("kihrpdmiseibidisp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kihrpseibiyoudisp = new ExDBFieldString<>("kihrpseibiyoudisp", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> shrgk = new ExDBFieldBizCurrency<>("shrgk", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> warimsishrgkbizc = new ExDBFieldBizCurrency<>("warimsishrgkbizc", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> znnphrbizc = new ExDBFieldBizCurrency<>("znnphrbizc", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> ttkekstkganribizc = new ExDBFieldBizCurrency<>("ttkekstkganribizc", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> sshkdbizc = new ExDBFieldBizCurrency<>("sshkdbizc", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> sshkshrgk = new ExDBFieldBizCurrency<>("sshkshrgk", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> mihrkmpbizc = new ExDBFieldBizCurrency<>("mihrkmpbizc", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, BizDate> shrymd = new ExDBFieldString<>("shrymd", this, BizDateType.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> syorisosikicd = new ExDBFieldString<>("syorisosikicd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> syoritaisyoukbn = new ExDBFieldString<>("syoritaisyoukbn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysytsinyno = new ExDBFieldString<>("shrtysytsinyno", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysyadr1kj = new ExDBFieldString<>("shrtysyadr1kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysyadr2kj = new ExDBFieldString<>("shrtysyadr2kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysyadr3kj = new ExDBFieldString<>("shrtysyadr3kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> uktnmkj = new ExDBFieldString<>("uktnmkj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kjdaihyouuktnm = new ExDBFieldString<>("kjdaihyouuktnm", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> shrtienrsk = new ExDBFieldBizCurrency<>("shrtienrsk", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> kihons = new ExDBFieldBizCurrency<>("kihons", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysysyuruicd = new ExDBFieldString<>("shrtysysyuruicd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> teknjikihrpseibidisp = new ExDBFieldString<>("teknjikihrpseibidisp", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> kihrkmp = new ExDBFieldBizCurrency<>("kihrkmp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> onlinecentercutkbn = new ExDBFieldString<>("onlinecentercutkbn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_ShrhousiteiKbn> shrhousiteikbn = new ExDBFieldString<>("shrhousiteikbn", this, UserType_C_ShrhousiteiKbn.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> htykeihihnsyukbn = new ExDBFieldString<>("htykeihihnsyukbn", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> syuseijtshrdbizc = new ExDBFieldBizCurrency<>("syuseijtshrdbizc", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> touduketorihouhoukbn = new ExDBFieldString<>("touduketorihouhoukbn", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> nenkinkkn = new ExDBFieldNumber<>("nenkinkkn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> banknmkn = new ExDBFieldString<>("banknmkn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> sitennmkn = new ExDBFieldString<>("sitennmkn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> yokinknmkn = new ExDBFieldString<>("yokinknmkn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, BizDate> sakuseiymd = new ExDBFieldString<>("sakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> kykmnmeigibangou = new ExDBFieldString<>("kykmnmeigibangou", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> uktmnmeigibangou = new ExDBFieldString<>("uktmnmeigibangou", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> jigyoukykmndantaicd = new ExDBFieldString<>("jigyoukykmndantaicd", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> mnsaiannaihnskakbn = new ExDBFieldString<>("mnsaiannaihnskakbn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> huho2kykdisp = new ExDBFieldString<>("huho2kykdisp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, C_ShrtysyhknsyuKbn> shrtysyhknsyukbn = new ExDBFieldString<>("shrtysyhknsyukbn", this, UserType_C_ShrtysyhknsyuKbn.class);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrtysykurikosidisp = new ExDBFieldString<>("shrtysykurikosidisp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> synyhsjykykndisp = new ExDBFieldString<>("synyhsjykykndisp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> tblsakuseihunodisp = new ExDBFieldString<>("tblsakuseihunodisp", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> daihyouktkbn = new ExDBFieldString<>("daihyouktkbn", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> oldtsinyno = new ExDBFieldString<>("oldtsinyno", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> oldtsinadr1kj = new ExDBFieldString<>("oldtsinadr1kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> oldtsinadr2kj = new ExDBFieldString<>("oldtsinadr2kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> oldtsinadr3kj = new ExDBFieldString<>("oldtsinadr3kj", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> oldkyknmkj = new ExDBFieldString<>("oldkyknmkj", this);

    public final ExDBFieldNumber<BV_SiharaiTyousyo, Integer> kykhnkkaisuu = new ExDBFieldNumber<>("kykhnkkaisuu", this);

    public final ExDBFieldString<BV_SiharaiTyousyo, String> shrkykhtykeihiyouhyj = new ExDBFieldString<>("shrkykhtykeihiyouhyj", this);

    public final ExDBFieldBizCurrency<BV_SiharaiTyousyo> shrkykhtykeihi = new ExDBFieldBizCurrency<>("shrkykhtykeihi", this);
}
