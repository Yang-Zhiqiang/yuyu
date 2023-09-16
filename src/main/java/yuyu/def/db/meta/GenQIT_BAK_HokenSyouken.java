package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.db.entity.IT_BAK_HokenSyouken;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_AisyoumeiKbn;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_InsizeiShryouhiKbn;
import yuyu.def.db.type.UserType_C_KjkhukaKbn;
import yuyu.def.db.type.UserType_C_SinsaihkKbn;
import yuyu.def.db.type.UserType_C_SyoukenUktKbn;
import yuyu.def.db.type.UserType_C_SyoukenUktMidasiKbn;
import yuyu.def.db.type.UserType_C_SyoukensaihkKbn;
import yuyu.def.db.type.UserType_C_TantouCdKbn;
import yuyu.def.db.type.UserType_C_TokusyuSyoriNaiyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YakkanJyuryouKbn;

/**
 * 保険証券バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_HokenSyouken extends AbstractExDBTable<IT_BAK_HokenSyouken> {

    public GenQIT_BAK_HokenSyouken() {
        this("IT_BAK_HokenSyouken");
    }

    public GenQIT_BAK_HokenSyouken(String pAlias) {
        super("IT_BAK_HokenSyouken", IT_BAK_HokenSyouken.class, pAlias);
    }

    public String IT_BAK_HokenSyouken() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SinsaihkKbn> sinsaihkkbn = new ExDBFieldString<>("sinsaihkkbn", this, UserType_C_SinsaihkKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukensaihkKbn> syoukensaihkkbn = new ExDBFieldString<>("syoukensaihkkbn", this, UserType_C_SyoukensaihkKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_InsizeiShryouhiKbn> insizeishryouhikbn = new ExDBFieldString<>("insizeishryouhikbn", this, UserType_C_InsizeiShryouhiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> koujyosyoumeiumukbn = new ExDBFieldString<>("koujyosyoumeiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> suiihyouumukbn = new ExDBFieldString<>("suiihyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> kanryoutuutiumukbn = new ExDBFieldString<>("kanryoutuutiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> stdrsktirasidouhuukbn = new ExDBFieldString<>("stdrsktirasidouhuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> dstirasidouhuukbn = new ExDBFieldString<>("dstirasidouhuukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_AisyoumeiKbn> aisyoumeikbn = new ExDBFieldString<>("aisyoumeikbn", this, UserType_C_AisyoumeiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_UmuKbn> syotnshuyoupostumukbn = new ExDBFieldString<>("syotnshuyoupostumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd1 = new ExDBFieldString<>("hyoujiranhidarimsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd2 = new ExDBFieldString<>("hyoujiranhidarimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd3 = new ExDBFieldString<>("hyoujiranhidarimsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd4 = new ExDBFieldString<>("hyoujiranhidarimsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd5 = new ExDBFieldString<>("hyoujiranhidarimsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd6 = new ExDBFieldString<>("hyoujiranhidarimsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd7 = new ExDBFieldString<>("hyoujiranhidarimsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd8 = new ExDBFieldString<>("hyoujiranhidarimsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd9 = new ExDBFieldString<>("hyoujiranhidarimsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd10 = new ExDBFieldString<>("hyoujiranhidarimsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd11 = new ExDBFieldString<>("hyoujiranhidarimsgcd11", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd12 = new ExDBFieldString<>("hyoujiranhidarimsgcd12", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd13 = new ExDBFieldString<>("hyoujiranhidarimsgcd13", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd14 = new ExDBFieldString<>("hyoujiranhidarimsgcd14", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd15 = new ExDBFieldString<>("hyoujiranhidarimsgcd15", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd16 = new ExDBFieldString<>("hyoujiranhidarimsgcd16", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd17 = new ExDBFieldString<>("hyoujiranhidarimsgcd17", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd18 = new ExDBFieldString<>("hyoujiranhidarimsgcd18", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd19 = new ExDBFieldString<>("hyoujiranhidarimsgcd19", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranhidarimsgcd20 = new ExDBFieldString<>("hyoujiranhidarimsgcd20", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd1 = new ExDBFieldString<>("hyoujiranmigiimsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd2 = new ExDBFieldString<>("hyoujiranmigiimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd3 = new ExDBFieldString<>("hyoujiranmigiimsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd4 = new ExDBFieldString<>("hyoujiranmigiimsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd5 = new ExDBFieldString<>("hyoujiranmigiimsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd6 = new ExDBFieldString<>("hyoujiranmigiimsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd7 = new ExDBFieldString<>("hyoujiranmigiimsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd8 = new ExDBFieldString<>("hyoujiranmigiimsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd9 = new ExDBFieldString<>("hyoujiranmigiimsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd10 = new ExDBFieldString<>("hyoujiranmigiimsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd11 = new ExDBFieldString<>("hyoujiranmigiimsgcd11", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd12 = new ExDBFieldString<>("hyoujiranmigiimsgcd12", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd13 = new ExDBFieldString<>("hyoujiranmigiimsgcd13", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd14 = new ExDBFieldString<>("hyoujiranmigiimsgcd14", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd15 = new ExDBFieldString<>("hyoujiranmigiimsgcd15", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd16 = new ExDBFieldString<>("hyoujiranmigiimsgcd16", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd17 = new ExDBFieldString<>("hyoujiranmigiimsgcd17", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd18 = new ExDBFieldString<>("hyoujiranmigiimsgcd18", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd19 = new ExDBFieldString<>("hyoujiranmigiimsgcd19", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hyoujiranmigiimsgcd20 = new ExDBFieldString<>("hyoujiranmigiimsgcd20", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> hyoujiransknnkaisiymd = new ExDBFieldString<>("hyoujiransknnkaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> hyoujiranyoteiriritu = new ExDBFieldString<>("hyoujiranyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> hyoujiransjkkktusirrt = new ExDBFieldString<>("hyoujiransjkkktusirrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hknsyukigou = new ExDBFieldString<>("hknsyukigou", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syohakkouymd = new ExDBFieldString<>("syohakkouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hanbainm = new ExDBFieldString<>("hanbainm", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> seisikihknnm = new ExDBFieldString<>("seisikihknnm", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> kouryokukaisiymd = new ExDBFieldString<>("kouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_KjkhukaKbn> kyknmkjkhukakbn = new ExDBFieldString<>("kyknmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_KjkhukaKbn> hhknnmkjkhukakbn = new ExDBFieldString<>("hhknnmkjkhukakbn", this, UserType_C_KjkhukaKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> hhknseiymd = new ExDBFieldString<>("hhknseiymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> hhknnen = new ExDBFieldNumber<>("hhknnen", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn1 = new ExDBFieldString<>("syoukenuktmidasikbn1", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn1 = new ExDBFieldString<>("syoukenuktkbn1", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm1 = new ExDBFieldString<>("syoukenuktnm1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari1 = new ExDBFieldString<>("syoukenuktbnwari1", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn2 = new ExDBFieldString<>("syoukenuktmidasikbn2", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn2 = new ExDBFieldString<>("syoukenuktkbn2", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm2 = new ExDBFieldString<>("syoukenuktnm2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari2 = new ExDBFieldString<>("syoukenuktbnwari2", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn3 = new ExDBFieldString<>("syoukenuktmidasikbn3", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn3 = new ExDBFieldString<>("syoukenuktkbn3", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm3 = new ExDBFieldString<>("syoukenuktnm3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari3 = new ExDBFieldString<>("syoukenuktbnwari3", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn4 = new ExDBFieldString<>("syoukenuktmidasikbn4", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn4 = new ExDBFieldString<>("syoukenuktkbn4", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm4 = new ExDBFieldString<>("syoukenuktnm4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari4 = new ExDBFieldString<>("syoukenuktbnwari4", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn5 = new ExDBFieldString<>("syoukenuktmidasikbn5", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn5 = new ExDBFieldString<>("syoukenuktkbn5", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm5 = new ExDBFieldString<>("syoukenuktnm5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari5 = new ExDBFieldString<>("syoukenuktbnwari5", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn6 = new ExDBFieldString<>("syoukenuktmidasikbn6", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn6 = new ExDBFieldString<>("syoukenuktkbn6", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm6 = new ExDBFieldString<>("syoukenuktnm6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari6 = new ExDBFieldString<>("syoukenuktbnwari6", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn7 = new ExDBFieldString<>("syoukenuktmidasikbn7", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn7 = new ExDBFieldString<>("syoukenuktkbn7", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm7 = new ExDBFieldString<>("syoukenuktnm7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari7 = new ExDBFieldString<>("syoukenuktbnwari7", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn8 = new ExDBFieldString<>("syoukenuktmidasikbn8", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn8 = new ExDBFieldString<>("syoukenuktkbn8", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm8 = new ExDBFieldString<>("syoukenuktnm8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari8 = new ExDBFieldString<>("syoukenuktbnwari8", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn9 = new ExDBFieldString<>("syoukenuktmidasikbn9", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn9 = new ExDBFieldString<>("syoukenuktkbn9", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm9 = new ExDBFieldString<>("syoukenuktnm9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari9 = new ExDBFieldString<>("syoukenuktbnwari9", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktMidasiKbn> syoukenuktmidasikbn10 = new ExDBFieldString<>("syoukenuktmidasikbn10", this, UserType_C_SyoukenUktMidasiKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_SyoukenUktKbn> syoukenuktkbn10 = new ExDBFieldString<>("syoukenuktkbn10", this, UserType_C_SyoukenUktKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syoukenuktnm10 = new ExDBFieldString<>("syoukenuktnm10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> syoukenuktbnwari10 = new ExDBFieldString<>("syoukenuktbnwari10", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> pmsgcd1 = new ExDBFieldString<>("pmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> pmsgcd2 = new ExDBFieldString<>("pmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> pmsgcd3 = new ExDBFieldString<>("pmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> ptuukatype = new ExDBFieldString<>("ptuukatype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> hokenryou = new ExDBFieldBizCurrency<>("hokenryou", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> ptuuka = new ExDBFieldString<>("ptuuka", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> ptokuyakumsgcd = new ExDBFieldString<>("ptokuyakumsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> phrkkknmidasikbn = new ExDBFieldString<>("phrkkknmidasikbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hrkkknmsgkbn = new ExDBFieldString<>("hrkkknmsgkbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hrkkaisuumsgkbn = new ExDBFieldString<>("hrkkaisuumsgkbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hrkkitukimsgkbn = new ExDBFieldString<>("hrkkitukimsgkbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hrkhouhoumsgkbn = new ExDBFieldString<>("hrkhouhoumsgkbn", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban1 = new ExDBFieldNumber<>("syukyktkykrenban1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn1 = new ExDBFieldString<>("syukyktkykmsgkbn1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn1 = new ExDBFieldString<>("syukyktkyksmsgkbn1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn1 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype1 = new ExDBFieldString<>("syukyktkykstuukatype1", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk1 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk1", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn1 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn1", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn1 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto1 = new ExDBFieldString<>("syutkdai1hknkknymdto1", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto1 = new ExDBFieldString<>("syutkdai2hknkknymdto1", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban2 = new ExDBFieldNumber<>("syukyktkykrenban2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn2 = new ExDBFieldString<>("syukyktkykmsgkbn2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn2 = new ExDBFieldString<>("syukyktkyksmsgkbn2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn2 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype2 = new ExDBFieldString<>("syukyktkykstuukatype2", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk2 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk2", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn2 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn2", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn2 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto2 = new ExDBFieldString<>("syutkdai1hknkknymdto2", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto2 = new ExDBFieldString<>("syutkdai2hknkknymdto2", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban3 = new ExDBFieldNumber<>("syukyktkykrenban3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn3 = new ExDBFieldString<>("syukyktkykmsgkbn3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn3 = new ExDBFieldString<>("syukyktkyksmsgkbn3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn3 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype3 = new ExDBFieldString<>("syukyktkykstuukatype3", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk3 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk3", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn3 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn3", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn3 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto3 = new ExDBFieldString<>("syutkdai1hknkknymdto3", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto3 = new ExDBFieldString<>("syutkdai2hknkknymdto3", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban4 = new ExDBFieldNumber<>("syukyktkykrenban4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn4 = new ExDBFieldString<>("syukyktkykmsgkbn4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn4 = new ExDBFieldString<>("syukyktkyksmsgkbn4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn4 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype4 = new ExDBFieldString<>("syukyktkykstuukatype4", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk4 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk4", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn4 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn4", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn4 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto4 = new ExDBFieldString<>("syutkdai1hknkknymdto4", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto4 = new ExDBFieldString<>("syutkdai2hknkknymdto4", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban5 = new ExDBFieldNumber<>("syukyktkykrenban5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn5 = new ExDBFieldString<>("syukyktkykmsgkbn5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn5 = new ExDBFieldString<>("syukyktkyksmsgkbn5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn5 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype5 = new ExDBFieldString<>("syukyktkykstuukatype5", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk5 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk5", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn5 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn5", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn5 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto5 = new ExDBFieldString<>("syutkdai1hknkknymdto5", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto5 = new ExDBFieldString<>("syutkdai2hknkknymdto5", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban6 = new ExDBFieldNumber<>("syukyktkykrenban6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn6 = new ExDBFieldString<>("syukyktkykmsgkbn6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn6 = new ExDBFieldString<>("syukyktkyksmsgkbn6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn6 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype6 = new ExDBFieldString<>("syukyktkykstuukatype6", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk6 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk6", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn6 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn6", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn6 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto6 = new ExDBFieldString<>("syutkdai1hknkknymdto6", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto6 = new ExDBFieldString<>("syutkdai2hknkknymdto6", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban7 = new ExDBFieldNumber<>("syukyktkykrenban7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn7 = new ExDBFieldString<>("syukyktkykmsgkbn7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn7 = new ExDBFieldString<>("syukyktkyksmsgkbn7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn7 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype7 = new ExDBFieldString<>("syukyktkykstuukatype7", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk7 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk7", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn7 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn7", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn7 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto7 = new ExDBFieldString<>("syutkdai1hknkknymdto7", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto7 = new ExDBFieldString<>("syutkdai2hknkknymdto7", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban8 = new ExDBFieldNumber<>("syukyktkykrenban8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn8 = new ExDBFieldString<>("syukyktkykmsgkbn8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn8 = new ExDBFieldString<>("syukyktkyksmsgkbn8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn8 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype8 = new ExDBFieldString<>("syukyktkykstuukatype8", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk8 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk8", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn8 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn8", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn8 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto8 = new ExDBFieldString<>("syutkdai1hknkknymdto8", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto8 = new ExDBFieldString<>("syutkdai2hknkknymdto8", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban9 = new ExDBFieldNumber<>("syukyktkykrenban9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn9 = new ExDBFieldString<>("syukyktkykmsgkbn9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn9 = new ExDBFieldString<>("syukyktkyksmsgkbn9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn9 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype9 = new ExDBFieldString<>("syukyktkykstuukatype9", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk9 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk9", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn9 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn9", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn9 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto9 = new ExDBFieldString<>("syutkdai1hknkknymdto9", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto9 = new ExDBFieldString<>("syutkdai2hknkknymdto9", this, BizDateType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykrenban10 = new ExDBFieldNumber<>("syukyktkykrenban10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykmsgkbn10 = new ExDBFieldString<>("syukyktkykmsgkbn10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkyksmsgkbn10 = new ExDBFieldString<>("syukyktkyksmsgkbn10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syukyktkykhknkknmsgkbn10 = new ExDBFieldString<>("syukyktkykhknkknmsgkbn10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> syukyktkykstuukatype10 = new ExDBFieldString<>("syukyktkykstuukatype10", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> syukyktkykhknkngk10 = new ExDBFieldBizCurrency<>("syukyktkykhknkngk10", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai1hknkkn10 = new ExDBFieldNumber<>("syukyktkykdai1hknkkn10", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> syukyktkykdai2hknkkn10 = new ExDBFieldNumber<>("syukyktkykdai2hknkkn10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai1hknkknymdto10 = new ExDBFieldString<>("syutkdai1hknkknymdto10", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> syutkdai2hknkknymdto10 = new ExDBFieldString<>("syutkdai2hknkknymdto10", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd1 = new ExDBFieldString<>("kykniyustmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd2 = new ExDBFieldString<>("kykniyustmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd3 = new ExDBFieldString<>("kykniyustmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd4 = new ExDBFieldString<>("kykniyustmsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd5 = new ExDBFieldString<>("kykniyustmsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd6 = new ExDBFieldString<>("kykniyustmsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd7 = new ExDBFieldString<>("kykniyustmsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd8 = new ExDBFieldString<>("kykniyustmsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd9 = new ExDBFieldString<>("kykniyustmsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd10 = new ExDBFieldString<>("kykniyustmsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd11 = new ExDBFieldString<>("kykniyustmsgcd11", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd12 = new ExDBFieldString<>("kykniyustmsgcd12", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd13 = new ExDBFieldString<>("kykniyustmsgcd13", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd14 = new ExDBFieldString<>("kykniyustmsgcd14", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kykniyustmsgcd15 = new ExDBFieldString<>("kykniyustmsgcd15", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> kykniyustitjbrptuuktype = new ExDBFieldString<>("kykniyustitjbrptuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kykniyustitjbrp = new ExDBFieldBizCurrency<>("kykniyustitjbrp", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd1 = new ExDBFieldString<>("stnaiyouranmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd2 = new ExDBFieldString<>("stnaiyouranmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd3 = new ExDBFieldString<>("stnaiyouranmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd4 = new ExDBFieldString<>("stnaiyouranmsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd5 = new ExDBFieldString<>("stnaiyouranmsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd6 = new ExDBFieldString<>("stnaiyouranmsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd7 = new ExDBFieldString<>("stnaiyouranmsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd8 = new ExDBFieldString<>("stnaiyouranmsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd9 = new ExDBFieldString<>("stnaiyouranmsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd10 = new ExDBFieldString<>("stnaiyouranmsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd11 = new ExDBFieldString<>("stnaiyouranmsgcd11", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd12 = new ExDBFieldString<>("stnaiyouranmsgcd12", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd13 = new ExDBFieldString<>("stnaiyouranmsgcd13", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd14 = new ExDBFieldString<>("stnaiyouranmsgcd14", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd15 = new ExDBFieldString<>("stnaiyouranmsgcd15", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd16 = new ExDBFieldString<>("stnaiyouranmsgcd16", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd17 = new ExDBFieldString<>("stnaiyouranmsgcd17", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd18 = new ExDBFieldString<>("stnaiyouranmsgcd18", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd19 = new ExDBFieldString<>("stnaiyouranmsgcd19", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyouranmsgcd20 = new ExDBFieldString<>("stnaiyouranmsgcd20", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sonotanyransiteituuka = new ExDBFieldString<>("sonotanyransiteituuka", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> sonotanyrannykntuktype = new ExDBFieldString<>("sonotanyrannykntuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sonotanyrannykntuukap = new ExDBFieldBizCurrency<>("sonotanyrannykntuukap", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sonotanyrannykntuukasyu = new ExDBFieldString<>("sonotanyrannykntuukasyu", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyranenkhrikmrate = new ExDBFieldString<>("sonotanyranenkhrikmrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyranstigikwsrate = new ExDBFieldString<>("sonotanyranstigikwsrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> sonotanyrankjnkngktuktype = new ExDBFieldString<>("sonotanyrankjnkngktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sonotanyrankjnkngk = new ExDBFieldBizCurrency<>("sonotanyrankjnkngk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyrankjnkngkrate = new ExDBFieldString<>("sonotanyrankjnkngkrate", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sonotanyrankjnkngktuuka = new ExDBFieldString<>("sonotanyrankjnkngktuuka", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> sonotanyranpentuktype = new ExDBFieldString<>("sonotanyranpentuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sonotanyranpenknsngk = new ExDBFieldBizCurrency<>("sonotanyranpenknsngk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyranmkhwariai = new ExDBFieldString<>("sonotanyranmkhwariai", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyranytirrt = new ExDBFieldString<>("sonotanyranytirrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyransjkkktusirrt = new ExDBFieldString<>("sonotanyransjkkktusirrt", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stnaiyourangaimsgcd = new ExDBFieldString<>("stnaiyourangaimsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> shsnmkj = new ExDBFieldString<>("shsnmkj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> tnknmissmsg = new ExDBFieldString<>("tnknmissmsg", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> errormsgcd = new ExDBFieldString<>("errormsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sisyacd = new ExDBFieldString<>("sisyacd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> duhutusnrntousaadrmsgcd = new ExDBFieldString<>("duhutusnrntousaadrmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> duhutusnrnsyono = new ExDBFieldString<>("duhutusnrnsyono", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Channelcd> channelcd = new ExDBFieldString<>("channelcd", this, UserType_C_Channelcd.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dairitenmidasikbn = new ExDBFieldString<>("dairitenmidasikbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> drtennm1kj = new ExDBFieldString<>("drtennm1kj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> drtennm2kj = new ExDBFieldString<>("drtennm2kj", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> aisatumsgcd = new ExDBFieldString<>("aisatumsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> ccmsgcd = new ExDBFieldString<>("ccmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hskmsgcd = new ExDBFieldString<>("hskmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hosyounymsgcd = new ExDBFieldString<>("hosyounymsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hosyounyhihknsyameikanji = new ExDBFieldString<>("hosyounyhihknsyameikanji", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboumidasimsgcd = new ExDBFieldString<>("siboumidasimsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboumidasimsgcd2 = new ExDBFieldString<>("siboumidasimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknmsgcd1 = new ExDBFieldString<>("siboudai1hknkknmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknmsgcd2 = new ExDBFieldString<>("siboudai1hknkknmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknigimsgcd = new ExDBFieldString<>("siboudai1hknkknigimsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknigimsgcd2 = new ExDBFieldString<>("siboudai1hknkknigimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknhrsmsgcd = new ExDBFieldString<>("siboudai1hknkknhrsmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknhrsmsgcd2 = new ExDBFieldString<>("siboudai1hknkknhrsmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai1hknkknsmrmsgcd = new ExDBFieldString<>("siboudai1hknkknsmrmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai2hknkknmsgcd1 = new ExDBFieldString<>("siboudai2hknkknmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai2hknkknmsgcd2 = new ExDBFieldString<>("siboudai2hknkknmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai2hknkknsmsgcd = new ExDBFieldString<>("siboudai2hknkknsmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai2hknkknsmsgcd2 = new ExDBFieldString<>("siboudai2hknkknsmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai3hknkknmsgcd1 = new ExDBFieldString<>("siboudai3hknkknmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboudai3hknkknmsgcd2 = new ExDBFieldString<>("siboudai3hknkknmsgcd2", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> siboudai1hknkkn = new ExDBFieldNumber<>("siboudai1hknkkn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> siboudai1hknkknymdto = new ExDBFieldString<>("siboudai1hknkknymdto", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> sibouitjbrpyentuuktype = new ExDBFieldString<>("sibouitjbrpyentuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sibouitjbrpyentuukgk = new ExDBFieldBizCurrency<>("sibouitjbrpyentuukgk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> siboudai1kjnkngktuuktype = new ExDBFieldString<>("siboudai1kjnkngktuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> siboudai1kjnkngk = new ExDBFieldBizCurrency<>("siboudai1kjnkngk", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> siboudai2hknkkn = new ExDBFieldNumber<>("siboudai2hknkkn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> siboudai2hknkknymdto = new ExDBFieldString<>("siboudai2hknkknymdto", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> siboudai2kjnkngktuuktype = new ExDBFieldString<>("siboudai2kjnkngktuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> siboudai2kjnkngk = new ExDBFieldBizCurrency<>("siboudai2kjnkngk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> siboudai3kjnkngktuuktype = new ExDBFieldString<>("siboudai3kjnkngktuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> siboudai3kjnkngk = new ExDBFieldBizCurrency<>("siboudai3kjnkngk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> dai1skwsrateyendaka = new ExDBFieldString<>("dai1skwsrateyendaka", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> dai1skwsrateyenkijyun = new ExDBFieldString<>("dai1skwsrateyenkijyun", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> dai1skwsrateyenyasu = new ExDBFieldString<>("dai1skwsrateyenyasu", this, BizNumberType.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu01 = new ExDBFieldNumber<>("dai1skeikanensuu01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd01 = new ExDBFieldString<>("dai1sibousnenoutouymd01", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype01 = new ExDBFieldString<>("dai1stuuktype01", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s01 = new ExDBFieldBizCurrency<>("dai1s01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu01 = new ExDBFieldString<>("dai1syenyendakaumu01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu01 = new ExDBFieldString<>("dai1syenyenkijyunumu01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu01 = new ExDBFieldString<>("dai1syenyenyasuumu01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype01 = new ExDBFieldString<>("dai1syentuuktype01", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka01 = new ExDBFieldBizCurrency<>("dai1syenyendaka01", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun01 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun01", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu01 = new ExDBFieldBizCurrency<>("dai1syenyenyasu01", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu02 = new ExDBFieldNumber<>("dai1skeikanensuu02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd02 = new ExDBFieldString<>("dai1sibousnenoutouymd02", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype02 = new ExDBFieldString<>("dai1stuuktype02", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s02 = new ExDBFieldBizCurrency<>("dai1s02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu02 = new ExDBFieldString<>("dai1syenyendakaumu02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu02 = new ExDBFieldString<>("dai1syenyenkijyunumu02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu02 = new ExDBFieldString<>("dai1syenyenyasuumu02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype02 = new ExDBFieldString<>("dai1syentuuktype02", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka02 = new ExDBFieldBizCurrency<>("dai1syenyendaka02", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun02 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun02", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu02 = new ExDBFieldBizCurrency<>("dai1syenyenyasu02", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu03 = new ExDBFieldNumber<>("dai1skeikanensuu03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd03 = new ExDBFieldString<>("dai1sibousnenoutouymd03", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype03 = new ExDBFieldString<>("dai1stuuktype03", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s03 = new ExDBFieldBizCurrency<>("dai1s03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu03 = new ExDBFieldString<>("dai1syenyendakaumu03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu03 = new ExDBFieldString<>("dai1syenyenkijyunumu03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu03 = new ExDBFieldString<>("dai1syenyenyasuumu03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype03 = new ExDBFieldString<>("dai1syentuuktype03", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka03 = new ExDBFieldBizCurrency<>("dai1syenyendaka03", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun03 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun03", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu03 = new ExDBFieldBizCurrency<>("dai1syenyenyasu03", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu04 = new ExDBFieldNumber<>("dai1skeikanensuu04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd04 = new ExDBFieldString<>("dai1sibousnenoutouymd04", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype04 = new ExDBFieldString<>("dai1stuuktype04", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s04 = new ExDBFieldBizCurrency<>("dai1s04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu04 = new ExDBFieldString<>("dai1syenyendakaumu04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu04 = new ExDBFieldString<>("dai1syenyenkijyunumu04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu04 = new ExDBFieldString<>("dai1syenyenyasuumu04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype04 = new ExDBFieldString<>("dai1syentuuktype04", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka04 = new ExDBFieldBizCurrency<>("dai1syenyendaka04", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun04 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun04", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu04 = new ExDBFieldBizCurrency<>("dai1syenyenyasu04", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu05 = new ExDBFieldNumber<>("dai1skeikanensuu05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd05 = new ExDBFieldString<>("dai1sibousnenoutouymd05", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype05 = new ExDBFieldString<>("dai1stuuktype05", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s05 = new ExDBFieldBizCurrency<>("dai1s05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu05 = new ExDBFieldString<>("dai1syenyendakaumu05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu05 = new ExDBFieldString<>("dai1syenyenkijyunumu05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu05 = new ExDBFieldString<>("dai1syenyenyasuumu05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype05 = new ExDBFieldString<>("dai1syentuuktype05", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka05 = new ExDBFieldBizCurrency<>("dai1syenyendaka05", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun05 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun05", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu05 = new ExDBFieldBizCurrency<>("dai1syenyenyasu05", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu06 = new ExDBFieldNumber<>("dai1skeikanensuu06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd06 = new ExDBFieldString<>("dai1sibousnenoutouymd06", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype06 = new ExDBFieldString<>("dai1stuuktype06", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s06 = new ExDBFieldBizCurrency<>("dai1s06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu06 = new ExDBFieldString<>("dai1syenyendakaumu06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu06 = new ExDBFieldString<>("dai1syenyenkijyunumu06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu06 = new ExDBFieldString<>("dai1syenyenyasuumu06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype06 = new ExDBFieldString<>("dai1syentuuktype06", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka06 = new ExDBFieldBizCurrency<>("dai1syenyendaka06", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun06 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun06", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu06 = new ExDBFieldBizCurrency<>("dai1syenyenyasu06", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu07 = new ExDBFieldNumber<>("dai1skeikanensuu07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd07 = new ExDBFieldString<>("dai1sibousnenoutouymd07", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype07 = new ExDBFieldString<>("dai1stuuktype07", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s07 = new ExDBFieldBizCurrency<>("dai1s07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu07 = new ExDBFieldString<>("dai1syenyendakaumu07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu07 = new ExDBFieldString<>("dai1syenyenkijyunumu07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu07 = new ExDBFieldString<>("dai1syenyenyasuumu07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype07 = new ExDBFieldString<>("dai1syentuuktype07", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka07 = new ExDBFieldBizCurrency<>("dai1syenyendaka07", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun07 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun07", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu07 = new ExDBFieldBizCurrency<>("dai1syenyenyasu07", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu08 = new ExDBFieldNumber<>("dai1skeikanensuu08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd08 = new ExDBFieldString<>("dai1sibousnenoutouymd08", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype08 = new ExDBFieldString<>("dai1stuuktype08", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s08 = new ExDBFieldBizCurrency<>("dai1s08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu08 = new ExDBFieldString<>("dai1syenyendakaumu08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu08 = new ExDBFieldString<>("dai1syenyenkijyunumu08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu08 = new ExDBFieldString<>("dai1syenyenyasuumu08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype08 = new ExDBFieldString<>("dai1syentuuktype08", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka08 = new ExDBFieldBizCurrency<>("dai1syenyendaka08", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun08 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun08", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu08 = new ExDBFieldBizCurrency<>("dai1syenyenyasu08", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu09 = new ExDBFieldNumber<>("dai1skeikanensuu09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd09 = new ExDBFieldString<>("dai1sibousnenoutouymd09", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype09 = new ExDBFieldString<>("dai1stuuktype09", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s09 = new ExDBFieldBizCurrency<>("dai1s09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu09 = new ExDBFieldString<>("dai1syenyendakaumu09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu09 = new ExDBFieldString<>("dai1syenyenkijyunumu09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu09 = new ExDBFieldString<>("dai1syenyenyasuumu09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype09 = new ExDBFieldString<>("dai1syentuuktype09", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka09 = new ExDBFieldBizCurrency<>("dai1syenyendaka09", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun09 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun09", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu09 = new ExDBFieldBizCurrency<>("dai1syenyenyasu09", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> dai1skeikanensuu10 = new ExDBFieldNumber<>("dai1skeikanensuu10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> dai1sibousnenoutouymd10 = new ExDBFieldString<>("dai1sibousnenoutouymd10", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktype10 = new ExDBFieldString<>("dai1stuuktype10", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1s10 = new ExDBFieldBizCurrency<>("dai1s10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumu10 = new ExDBFieldString<>("dai1syenyendakaumu10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkijyunumu10 = new ExDBFieldString<>("dai1syenyenkijyunumu10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumu10 = new ExDBFieldString<>("dai1syenyenyasuumu10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktype10 = new ExDBFieldString<>("dai1syentuuktype10", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendaka10 = new ExDBFieldBizCurrency<>("dai1syenyendaka10", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyun10 = new ExDBFieldBizCurrency<>("dai1syenyenkijyun10", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasu10 = new ExDBFieldBizCurrency<>("dai1syenyenyasu10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1stuuktypehuryo = new ExDBFieldString<>("dai1stuuktypehuryo", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1shuryo = new ExDBFieldBizCurrency<>("dai1shuryo", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyendakaumuhuryo = new ExDBFieldString<>("dai1syenyendakaumuhuryo", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenkjnumuhuryo = new ExDBFieldString<>("dai1syenyenkjnumuhuryo", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dai1syenyenyasuumuhuryo = new ExDBFieldString<>("dai1syenyenyasuumuhuryo", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai1syentuuktypehuryo = new ExDBFieldString<>("dai1syentuuktypehuryo", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyendakahuryo = new ExDBFieldBizCurrency<>("dai1syenyendakahuryo", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenkijyunhuryo = new ExDBFieldBizCurrency<>("dai1syenyenkijyunhuryo", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai1syenyenyasuhuryo = new ExDBFieldBizCurrency<>("dai1syenyenyasuhuryo", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> initsbjiyenkasaiteihsygk = new ExDBFieldBizCurrency<>("initsbjiyenkasaiteihsygk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai2stuuktype = new ExDBFieldString<>("dai2stuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai2s = new ExDBFieldBizCurrency<>("dai2s", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai2syentuuktype = new ExDBFieldString<>("dai2syentuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai2syenyendaka = new ExDBFieldBizCurrency<>("dai2syenyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai2syenyenkijyun = new ExDBFieldBizCurrency<>("dai2syenyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai2syenyenyasu = new ExDBFieldBizCurrency<>("dai2syenyenyasu", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai3stuuktype = new ExDBFieldString<>("dai3stuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai3s = new ExDBFieldBizCurrency<>("dai3s", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> dai3syentuuktype = new ExDBFieldString<>("dai3syentuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai3syenyendaka = new ExDBFieldBizCurrency<>("dai3syenyendaka", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai3syenyenkijyun = new ExDBFieldBizCurrency<>("dai3syenyenkijyun", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> dai3syenyenyasu = new ExDBFieldBizCurrency<>("dai3syenyenyasu", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sibouinjiptnkbn = new ExDBFieldString<>("sibouinjiptnkbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> mkhyouyensysnikoumsgcd = new ExDBFieldString<>("mkhyouyensysnikoumsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> mkhyouyensysnikoumsgcd2 = new ExDBFieldString<>("mkhyouyensysnikoumsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> mkhyouyensysnikoumsgcd3 = new ExDBFieldString<>("mkhyouyensysnikoumsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> mkhyouyensysnikougktype = new ExDBFieldString<>("mkhyouyensysnikougktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> mkhyouyensysnikougk = new ExDBFieldBizCurrency<>("mkhyouyensysnikougk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> mkhyouyensysnikouwra = new ExDBFieldString<>("mkhyouyensysnikouwra", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykmsgcd1 = new ExDBFieldString<>("kaigomaehrtkykmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykmsgcd2 = new ExDBFieldString<>("kaigomaehrtkykmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykmsgcdst1 = new ExDBFieldString<>("kaigomaehrtkykmsgcdst1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykmsgcdst2 = new ExDBFieldString<>("kaigomaehrtkykmsgcdst2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehruktgkumu = new ExDBFieldString<>("kaigomaehruktgkumu", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykkyktuuka = new ExDBFieldString<>("kaigomaehrtkykkyktuuka", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kaigomaehrtkykstdmsgcd = new ExDBFieldString<>("kaigomaehrtkykstdmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> kaigomaehrjrugktype = new ExDBFieldString<>("kaigomaehrjrugktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen01 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn01 = new ExDBFieldString<>("kaigomaehrstikkn01", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk01 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk01", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen02 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn02 = new ExDBFieldString<>("kaigomaehrstikkn02", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk02 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk02", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen03 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn03 = new ExDBFieldString<>("kaigomaehrstikkn03", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk03 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk03", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen04 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn04 = new ExDBFieldString<>("kaigomaehrstikkn04", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk04 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk04", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen05 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen05", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn05 = new ExDBFieldString<>("kaigomaehrstikkn05", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk05 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk05", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen06 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen06", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn06 = new ExDBFieldString<>("kaigomaehrstikkn06", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk06 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk06", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen07 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen07", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn07 = new ExDBFieldString<>("kaigomaehrstikkn07", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk07 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk07", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen08 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen08", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn08 = new ExDBFieldString<>("kaigomaehrstikkn08", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk08 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk08", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen09 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen09", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn09 = new ExDBFieldString<>("kaigomaehrstikkn09", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk09 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk09", this);

    public final ExDBFieldNumber<IT_BAK_HokenSyouken, Integer> kaigomaehrsikuhhknnen10 = new ExDBFieldNumber<>("kaigomaehrsikuhhknnen10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> kaigomaehrstikkn10 = new ExDBFieldString<>("kaigomaehrstikkn10", this, BizNumberType.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> kaigomaehrjrugk10 = new ExDBFieldBizCurrency<>("kaigomaehrjrugk10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdue01 = new ExDBFieldString<>("hutanhiyustmmsgcdue01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdue02 = new ExDBFieldString<>("hutanhiyustmmsgcdue02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdue03 = new ExDBFieldString<>("hutanhiyustmmsgcdue03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdue04 = new ExDBFieldString<>("hutanhiyustmmsgcdue04", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmknsnhyuptn = new ExDBFieldString<>("hutanhiyustmknsnhyuptn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdst01 = new ExDBFieldString<>("hutanhiyustmmsgcdst01", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdst02 = new ExDBFieldString<>("hutanhiyustmmsgcdst02", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hutanhiyustmmsgcdst03 = new ExDBFieldString<>("hutanhiyustmmsgcdst03", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> stdstmmsgcd = new ExDBFieldString<>("stdstmmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> fstpmsgcd = new ExDBFieldString<>("fstpmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> fstphrkpkngkkeituuktype = new ExDBFieldString<>("fstphrkpkngkkeituuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> fstphrkpkngkkei = new ExDBFieldBizCurrency<>("fstphrkpkngkkei", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> fstponegaimsgcd = new ExDBFieldString<>("fstponegaimsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> dsmsgcd = new ExDBFieldString<>("dsmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syouhnhutaimsgcd1 = new ExDBFieldString<>("syouhnhutaimsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> syouhnhutaimsgcd2 = new ExDBFieldString<>("syouhnhutaimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> pyentuuktype = new ExDBFieldString<>("pyentuuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> pyen = new ExDBFieldBizCurrency<>("pyen", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> toiawasesakihanyoumsgcd = new ExDBFieldString<>("toiawasesakihanyoumsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> annaihanyoumsgcd = new ExDBFieldString<>("annaihanyoumsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd1 = new ExDBFieldString<>("wmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd2 = new ExDBFieldString<>("wmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd3 = new ExDBFieldString<>("wmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd1 = new ExDBFieldString<>("wtyuuijikoumsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd2 = new ExDBFieldString<>("wtyuuijikoumsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd3 = new ExDBFieldString<>("wtyuuijikoumsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd4 = new ExDBFieldString<>("wtyuuijikoumsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd5 = new ExDBFieldString<>("wtyuuijikoumsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> witijibrptuktype = new ExDBFieldString<>("witijibrptuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> witijibrp = new ExDBFieldBizCurrency<>("witijibrp", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> wyenhrkgktuktype = new ExDBFieldString<>("wyenhrkgktuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> wyenhrkgk = new ExDBFieldBizCurrency<>("wyenhrkgk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_Tuukasyu> wyenitijibrptuktype = new ExDBFieldString<>("wyenitijibrptuktype", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> wyenitijibrp = new ExDBFieldBizCurrency<>("wyenitijibrp", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> koujyosyoumeimsgcd1 = new ExDBFieldString<>("koujyosyoumeimsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> koujyosyoumeimsgcd2 = new ExDBFieldString<>("koujyosyoumeimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> koujyosyoumeimsgcd3 = new ExDBFieldString<>("koujyosyoumeimsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> koujyosyoumeihskmsgcd = new ExDBFieldString<>("koujyosyoumeihskmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nenkoujyosyoumeihskmsgcd = new ExDBFieldString<>("nenkoujyosyoumeihskmsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn1 = new ExDBFieldString<>("tokusyusyorinaiyoukbn1", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn2 = new ExDBFieldString<>("tokusyusyorinaiyoukbn2", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn3 = new ExDBFieldString<>("tokusyusyorinaiyoukbn3", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn4 = new ExDBFieldString<>("tokusyusyorinaiyoukbn4", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn5 = new ExDBFieldString<>("tokusyusyorinaiyoukbn5", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn6 = new ExDBFieldString<>("tokusyusyorinaiyoukbn6", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn7 = new ExDBFieldString<>("tokusyusyorinaiyoukbn7", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn8 = new ExDBFieldString<>("tokusyusyorinaiyoukbn8", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn9 = new ExDBFieldString<>("tokusyusyorinaiyoukbn9", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn10 = new ExDBFieldString<>("tokusyusyorinaiyoukbn10", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn11 = new ExDBFieldString<>("tokusyusyorinaiyoukbn11", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn12 = new ExDBFieldString<>("tokusyusyorinaiyoukbn12", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn13 = new ExDBFieldString<>("tokusyusyorinaiyoukbn13", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn14 = new ExDBFieldString<>("tokusyusyorinaiyoukbn14", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn15 = new ExDBFieldString<>("tokusyusyorinaiyoukbn15", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn16 = new ExDBFieldString<>("tokusyusyorinaiyoukbn16", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TokusyuSyoriNaiyouKbn> tokusyusyorinaiyoukbn17 = new ExDBFieldString<>("tokusyusyorinaiyoukbn17", this, UserType_C_TokusyuSyoriNaiyouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> kyknmkn = new ExDBFieldString<>("kyknmkn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> hhknnmkn = new ExDBFieldString<>("hhknnmkn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> sonotanyrannkshrstartymd = new ExDBFieldString<>("sonotanyrannkshrstartymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyrannenkinkkn = new ExDBFieldString<>("sonotanyrannenkinkkn", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> sonotanyranyensysnhkhnkymd = new ExDBFieldString<>("sonotanyranyensysnhkhnkymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyrantumitateriritu = new ExDBFieldString<>("sonotanyrantumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyrantmttknzkrtjygn = new ExDBFieldString<>("sonotanyrantmttknzkrtjygn", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sonotanyransetteibairitu = new ExDBFieldString<>("sonotanyransetteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sonotanyrantmttkngktuktype = new ExDBFieldString<>("sonotanyrantmttkngktuktype", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sonotanyranteiritutmttkngk = new ExDBFieldBizCurrency<>("sonotanyranteiritutmttkngk", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> sonotanyransisuutmttkngk = new ExDBFieldBizCurrency<>("sonotanyransisuutmttkngk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sonotanyransisuunm = new ExDBFieldString<>("sonotanyransisuunm", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizDate> kgmaehrtkdai1hknkknmnryymd = new ExDBFieldString<>("kgmaehrtkdai1hknkknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd1 = new ExDBFieldString<>("nkmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd2 = new ExDBFieldString<>("nkmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd3 = new ExDBFieldString<>("nkmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd4 = new ExDBFieldString<>("nkmsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd5 = new ExDBFieldString<>("nkmsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd6 = new ExDBFieldString<>("nkmsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd7 = new ExDBFieldString<>("nkmsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd8 = new ExDBFieldString<>("nkmsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd9 = new ExDBFieldString<>("nkmsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkmsgcd10 = new ExDBFieldString<>("nkmsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd1 = new ExDBFieldString<>("siboukyuuhukinmsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd2 = new ExDBFieldString<>("siboukyuuhukinmsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd3 = new ExDBFieldString<>("siboukyuuhukinmsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd4 = new ExDBFieldString<>("siboukyuuhukinmsgcd4", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd5 = new ExDBFieldString<>("siboukyuuhukinmsgcd5", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd6 = new ExDBFieldString<>("siboukyuuhukinmsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd7 = new ExDBFieldString<>("siboukyuuhukinmsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd8 = new ExDBFieldString<>("siboukyuuhukinmsgcd8", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd9 = new ExDBFieldString<>("siboukyuuhukinmsgcd9", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siboukyuuhukinmsgcd10 = new ExDBFieldString<>("siboukyuuhukinmsgcd10", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> nkshrstartzenymd = new ExDBFieldString<>("nkshrstartzenymd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> mkhyouyennkhknhentktype = new ExDBFieldString<>("mkhyouyennkhknhentktype", this);

    public final ExDBFieldBizCurrency<IT_BAK_HokenSyouken> mkhyouyennkhknhentkmkhgk = new ExDBFieldBizCurrency<>("mkhyouyennkhknhentkmkhgk", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> mkhyouyennkhknhentkmkhwari = new ExDBFieldString<>("mkhyouyennkhknhentkmkhwari", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> haibunwarimsgcd1 = new ExDBFieldString<>("haibunwarimsgcd1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> haibunwarimsgcd2 = new ExDBFieldString<>("haibunwarimsgcd2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> haibunwarimsgcd3 = new ExDBFieldString<>("haibunwarimsgcd3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> teiritutmtthbnwr = new ExDBFieldString<>("teiritutmtthbnwr", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sisuutmtthbnwr = new ExDBFieldString<>("sisuutmtthbnwr", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sisuuannaimsg1 = new ExDBFieldString<>("sisuuannaimsg1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sisuuannaimsg2 = new ExDBFieldString<>("sisuuannaimsg2", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sisuuannaimsg3 = new ExDBFieldString<>("sisuuannaimsg3", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> hutanhiyustmytijihiritu = new ExDBFieldString<>("hutanhiyustmytijihiritu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd21 = new ExDBFieldString<>("wmsgcd21", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd22 = new ExDBFieldString<>("wmsgcd22", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd23 = new ExDBFieldString<>("wmsgcd23", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd31 = new ExDBFieldString<>("wmsgcd31", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd32 = new ExDBFieldString<>("wmsgcd32", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcd33 = new ExDBFieldString<>("wmsgcd33", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wmsgcdst1 = new ExDBFieldString<>("wmsgcdst1", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd6 = new ExDBFieldString<>("wtyuuijikoumsgcd6", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> wtyuuijikoumsgcd7 = new ExDBFieldString<>("wtyuuijikoumsgcd7", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_TantouCdKbn> tantocd = new ExDBFieldString<>("tantocd", this, UserType_C_TantouCdKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> phrkktuki = new ExDBFieldString<>("phrkktuki", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, C_YakkanJyuryouKbn> yakkanjyuryouhoukbn = new ExDBFieldString<>("yakkanjyuryouhoukbn", this, UserType_C_YakkanJyuryouKbn.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> yakkanbunsyono = new ExDBFieldString<>("yakkanbunsyono", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> siorino = new ExDBFieldString<>("siorino", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sioriwebuktriannaimsgcd = new ExDBFieldString<>("sioriwebuktriannaimsgcd", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, String> sagyoukbn = new ExDBFieldString<>("sagyoukbn", this);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sisuuupkaisuu = new ExDBFieldString<>("sisuuupkaisuu", this, BizNumberType.class);

    public final ExDBFieldString<IT_BAK_HokenSyouken, BizNumber> sisuudownkaisuu = new ExDBFieldString<>("sisuudownkaisuu", this, BizNumberType.class);
}
