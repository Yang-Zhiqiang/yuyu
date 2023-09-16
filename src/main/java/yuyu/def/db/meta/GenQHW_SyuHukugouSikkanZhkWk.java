package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_IjitoukeiTikShrTkykKbn;
import yuyu.def.classification.C_IjitoukeiZennouKbn;
import yuyu.def.classification.C_NensyuuKbn;
import yuyu.def.classification.C_SirajiKykKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HW_SyuHukugouSikkanZhkWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_BosyuuDairitenAtkiKeitaiKbn;
import yuyu.def.db.type.UserType_C_Hhknsei;
import yuyu.def.db.type.UserType_C_IjitoukeiHokensyuruiKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiTikShrTkykKbn;
import yuyu.def.db.type.UserType_C_IjitoukeiZennouKbn;
import yuyu.def.db.type.UserType_C_NensyuuKbn;
import yuyu.def.db.type.UserType_C_SirajiKykKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 主契約複合疾患増幅ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_SyuHukugouSikkanZhkWk extends AbstractExDBTable<HW_SyuHukugouSikkanZhkWk> {

    public GenQHW_SyuHukugouSikkanZhkWk() {
        this("HW_SyuHukugouSikkanZhkWk");
    }

    public GenQHW_SyuHukugouSikkanZhkWk(String pAlias) {
        super("HW_SyuHukugouSikkanZhkWk", HW_SyuHukugouSikkanZhkWk.class, pAlias);
    }

    public String HW_SyuHukugouSikkanZhkWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> hknnendo = new ExDBFieldNumber<>("hknnendo", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> ijitoukeidaihyousyurui = new ExDBFieldString<>("ijitoukeidaihyousyurui", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> kyknendo = new ExDBFieldString<>("kyknendo", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_Hhknsei> hhknsei = new ExDBFieldString<>("hhknsei", this, UserType_C_Hhknsei.class);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> kykage = new ExDBFieldNumber<>("kykage", this);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> toutatunenrei = new ExDBFieldNumber<>("toutatunenrei", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> atukaibetu = new ExDBFieldString<>("atukaibetu", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> ijitoukeisinsahouhou = new ExDBFieldString<>("ijitoukeisinsahouhou", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> ketteikekkaa = new ExDBFieldString<>("ketteikekkaa", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> sibousrank = new ExDBFieldString<>("sibousrank", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> jissituhosyousrank = new ExDBFieldString<>("jissituhosyousrank", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_SirajiKykKbn> sirajikykkbn = new ExDBFieldString<>("sirajikykkbn", this, UserType_C_SirajiKykKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> hrkhouhoukbn = new ExDBFieldString<>("hrkhouhoukbn", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_IjitoukeiHokensyuruiKbn> ijitoukeihokensyuruikbn = new ExDBFieldString<>("ijitoukeihokensyuruikbn", this, UserType_C_IjitoukeiHokensyuruiKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> daisiincd = new ExDBFieldString<>("daisiincd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> tyuusiincd = new ExDBFieldString<>("tyuusiincd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> siincd = new ExDBFieldString<>("siincd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> nenreihousikikbn = new ExDBFieldString<>("nenreihousikikbn", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> hhknsykgycd = new ExDBFieldString<>("hhknsykgycd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> hhkntodouhukencd = new ExDBFieldString<>("hhkntodouhukencd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> botaisisyaeigyouhonbu = new ExDBFieldString<>("botaisisyaeigyouhonbu", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> sisyaeigyoubu = new ExDBFieldString<>("sisyaeigyoubu", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> aatsukaishasoshikicd = new ExDBFieldString<>("aatsukaishasoshikicd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_NensyuuKbn> hhknnensyuukbn = new ExDBFieldString<>("hhknnensyuukbn", this, UserType_C_NensyuuKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> hanbaikeirokbn = new ExDBFieldString<>("hanbaikeirokbn", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_BosyuuDairitenAtkiKeitaiKbn> bosyuudairitenatkikeitaikbn = new ExDBFieldString<>("bosyuudairitenatkikeitaikbn", this, UserType_C_BosyuuDairitenAtkiKeitaiKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_Tuukasyu> hrktuukasyu = new ExDBFieldString<>("hrktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_UmuKbn> initsbjiyensitihsytkhukaumu = new ExDBFieldString<>("initsbjiyensitihsytkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_UmuKbn> jyudkaigomeharaitkhukaumu = new ExDBFieldString<>("jyudkaigomeharaitkhukaumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_IjitoukeiZennouKbn> ijitoukeizennoukbn = new ExDBFieldString<>("ijitoukeizennoukbn", this, UserType_C_IjitoukeiZennouKbn.class);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, C_IjitoukeiTikShrTkykKbn> ijitoukeitikshrtkykkbn = new ExDBFieldString<>("ijitoukeitikshrtkykkbn", this, UserType_C_IjitoukeiTikShrTkykKbn.class);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, BizNumber> ijitoukeikeikan = new ExDBFieldString<>("ijitoukeikeikan", this, BizNumberType.class);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> ijitoukeisiboun = new ExDBFieldNumber<>("ijitoukeisiboun", this);

    public final ExDBFieldString<HW_SyuHukugouSikkanZhkWk, BizNumber> ijitoukeikeikas = new ExDBFieldString<>("ijitoukeikeikas", this, BizNumberType.class);

    public final ExDBFieldNumber<HW_SyuHukugouSikkanZhkWk, Integer> ijitoukeisibous = new ExDBFieldNumber<>("ijitoukeisibous", this);
}
