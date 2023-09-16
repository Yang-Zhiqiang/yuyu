package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DaisinHiDaisinKbn;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;
import yuyu.def.classification.C_MdhnSchemeDrtenHyouji;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;
import yuyu.def.classification.C_TykatukaiyouDrtenHyouji;
import yuyu.def.db.entity.BM_Dairiten;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DaisinHiDaisinKbn;
import yuyu.def.db.type.UserType_C_KydBosyuuDairitenHyouji;
import yuyu.def.db.type.UserType_C_KydsskKinyuuknHyouji;
import yuyu.def.db.type.UserType_C_MdhnSchemeDrtenHyouji;
import yuyu.def.db.type.UserType_C_TkrtkKinyuuknHyouji;
import yuyu.def.db.type.UserType_C_TykatukaiyouDrtenHyouji;

/**
 * 代理店マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Dairiten extends AbstractExDBTable<BM_Dairiten> {

    public GenQBM_Dairiten() {
        this("BM_Dairiten");
    }

    public GenQBM_Dairiten(String pAlias) {
        super("BM_Dairiten", BM_Dairiten.class, pAlias);
    }

    public String BM_Dairiten() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Dairiten, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<BM_Dairiten, String> drtennm = new ExDBFieldString<>("drtennm", this);

    public final ExDBFieldString<BM_Dairiten, String> kanjidairitennm = new ExDBFieldString<>("kanjidairitennm", this);

    public final ExDBFieldString<BM_Dairiten, BizDate> itakukeiyakuymd = new ExDBFieldString<>("itakukeiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Dairiten, BizDate> itakukeiyakukaiyakuymd = new ExDBFieldString<>("itakukeiyakukaiyakuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Dairiten, BizDate> dairitentourokuymd = new ExDBFieldString<>("dairitentourokuymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Dairiten, C_DaisinHiDaisinKbn> daisinhidaisinkbn = new ExDBFieldString<>("daisinhidaisinkbn", this, UserType_C_DaisinHiDaisinKbn.class);

    public final ExDBFieldString<BM_Dairiten, String> drtkanrisosikicd1 = new ExDBFieldString<>("drtkanrisosikicd1", this);

    public final ExDBFieldString<BM_Dairiten, String> drtkanrisosikicd2 = new ExDBFieldString<>("drtkanrisosikicd2", this);

    public final ExDBFieldString<BM_Dairiten, String> drtkanrisosikicd3 = new ExDBFieldString<>("drtkanrisosikicd3", this);

    public final ExDBFieldString<BM_Dairiten, String> keisyousakidrtencd = new ExDBFieldString<>("keisyousakidrtencd", this);

    public final ExDBFieldString<BM_Dairiten, String> ksymtdrtencd = new ExDBFieldString<>("ksymtdrtencd", this);

    public final ExDBFieldString<BM_Dairiten, String> dairitentelno = new ExDBFieldString<>("dairitentelno", this);

    public final ExDBFieldString<BM_Dairiten, String> dairitenfaxno = new ExDBFieldString<>("dairitenfaxno", this);

    public final ExDBFieldString<BM_Dairiten, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<BM_Dairiten, String> drtentrkno = new ExDBFieldString<>("drtentrkno", this);

    public final ExDBFieldString<BM_Dairiten, BizDate> dairitenkouryokukaisiymd = new ExDBFieldString<>("dairitenkouryokukaisiymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Dairiten, BizDate> dairitenkouryokusyuuryouymd = new ExDBFieldString<>("dairitenkouryokusyuuryouymd", this, BizDateType.class);

    public final ExDBFieldString<BM_Dairiten, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<BM_Dairiten, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<BM_Dairiten, String> drtenjimcd = new ExDBFieldString<>("drtenjimcd", this);

    public final ExDBFieldString<BM_Dairiten, String> daibosyuucd = new ExDBFieldString<>("daibosyuucd", this);

    public final ExDBFieldString<BM_Dairiten, String> bntndrtencd = new ExDBFieldString<>("bntndrtencd", this);

    public final ExDBFieldString<BM_Dairiten, BizNumber> bunwari = new ExDBFieldString<>("bunwari", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, C_MdhnSchemeDrtenHyouji> mdhnschemedrtenhyouji = new ExDBFieldString<>("mdhnschemedrtenhyouji", this, UserType_C_MdhnSchemeDrtenHyouji.class);

    public final ExDBFieldString<BM_Dairiten, C_TykatukaiyouDrtenHyouji> tykatukaiyoudrtenhyouji = new ExDBFieldString<>("tykatukaiyoudrtenhyouji", this, UserType_C_TykatukaiyouDrtenHyouji.class);

    public final ExDBFieldString<BM_Dairiten, C_TkrtkKinyuuknHyouji> tkrtkkinyuuknhyouji = new ExDBFieldString<>("tkrtkkinyuuknhyouji", this, UserType_C_TkrtkKinyuuknHyouji.class);

    public final ExDBFieldString<BM_Dairiten, C_KydsskKinyuuknHyouji> kydsskkinyuuknhyouji = new ExDBFieldString<>("kydsskkinyuuknhyouji", this, UserType_C_KydsskKinyuuknHyouji.class);

    public final ExDBFieldString<BM_Dairiten, C_KydBosyuuDairitenHyouji> kydbosyuudairitenhyouji = new ExDBFieldString<>("kydbosyuudairitenhyouji", this, UserType_C_KydBosyuuDairitenHyouji.class);

    public final ExDBFieldString<BM_Dairiten, String> yuuseijimusyocd = new ExDBFieldString<>("yuuseijimusyocd", this);

    public final ExDBFieldString<BM_Dairiten, String> toukatudairitencd = new ExDBFieldString<>("toukatudairitencd", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x1 = new ExDBFieldString<>("drtensyouhncdkami3x1", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux1 = new ExDBFieldString<>("tsryshrkbntougetux1", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux1 = new ExDBFieldString<>("tsryshrkbnyokugetux1", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx1 = new ExDBFieldString<>("bntnptnkbnx1", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x2 = new ExDBFieldString<>("drtensyouhncdkami3x2", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux2 = new ExDBFieldString<>("tsryshrkbntougetux2", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux2 = new ExDBFieldString<>("tsryshrkbnyokugetux2", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx2 = new ExDBFieldString<>("bntnptnkbnx2", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x3 = new ExDBFieldString<>("drtensyouhncdkami3x3", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux3 = new ExDBFieldString<>("tsryshrkbntougetux3", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux3 = new ExDBFieldString<>("tsryshrkbnyokugetux3", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx3 = new ExDBFieldString<>("bntnptnkbnx3", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x4 = new ExDBFieldString<>("drtensyouhncdkami3x4", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux4 = new ExDBFieldString<>("tsryshrkbntougetux4", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux4 = new ExDBFieldString<>("tsryshrkbnyokugetux4", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx4 = new ExDBFieldString<>("bntnptnkbnx4", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x5 = new ExDBFieldString<>("drtensyouhncdkami3x5", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux5 = new ExDBFieldString<>("tsryshrkbntougetux5", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux5 = new ExDBFieldString<>("tsryshrkbnyokugetux5", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx5 = new ExDBFieldString<>("bntnptnkbnx5", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x6 = new ExDBFieldString<>("drtensyouhncdkami3x6", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux6 = new ExDBFieldString<>("tsryshrkbntougetux6", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux6 = new ExDBFieldString<>("tsryshrkbnyokugetux6", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx6 = new ExDBFieldString<>("bntnptnkbnx6", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x7 = new ExDBFieldString<>("drtensyouhncdkami3x7", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux7 = new ExDBFieldString<>("tsryshrkbntougetux7", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux7 = new ExDBFieldString<>("tsryshrkbnyokugetux7", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx7 = new ExDBFieldString<>("bntnptnkbnx7", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x8 = new ExDBFieldString<>("drtensyouhncdkami3x8", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux8 = new ExDBFieldString<>("tsryshrkbntougetux8", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux8 = new ExDBFieldString<>("tsryshrkbnyokugetux8", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx8 = new ExDBFieldString<>("bntnptnkbnx8", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x9 = new ExDBFieldString<>("drtensyouhncdkami3x9", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux9 = new ExDBFieldString<>("tsryshrkbntougetux9", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux9 = new ExDBFieldString<>("tsryshrkbnyokugetux9", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx9 = new ExDBFieldString<>("bntnptnkbnx9", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x10 = new ExDBFieldString<>("drtensyouhncdkami3x10", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux10 = new ExDBFieldString<>("tsryshrkbntougetux10", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux10 = new ExDBFieldString<>("tsryshrkbnyokugetux10", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx10 = new ExDBFieldString<>("bntnptnkbnx10", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x11 = new ExDBFieldString<>("drtensyouhncdkami3x11", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux11 = new ExDBFieldString<>("tsryshrkbntougetux11", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux11 = new ExDBFieldString<>("tsryshrkbnyokugetux11", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx11 = new ExDBFieldString<>("bntnptnkbnx11", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x12 = new ExDBFieldString<>("drtensyouhncdkami3x12", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux12 = new ExDBFieldString<>("tsryshrkbntougetux12", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux12 = new ExDBFieldString<>("tsryshrkbnyokugetux12", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx12 = new ExDBFieldString<>("bntnptnkbnx12", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x13 = new ExDBFieldString<>("drtensyouhncdkami3x13", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux13 = new ExDBFieldString<>("tsryshrkbntougetux13", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux13 = new ExDBFieldString<>("tsryshrkbnyokugetux13", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx13 = new ExDBFieldString<>("bntnptnkbnx13", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x14 = new ExDBFieldString<>("drtensyouhncdkami3x14", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux14 = new ExDBFieldString<>("tsryshrkbntougetux14", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux14 = new ExDBFieldString<>("tsryshrkbnyokugetux14", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx14 = new ExDBFieldString<>("bntnptnkbnx14", this);

    public final ExDBFieldString<BM_Dairiten, String> drtensyouhncdkami3x15 = new ExDBFieldString<>("drtensyouhncdkami3x15", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbntougetux15 = new ExDBFieldString<>("tsryshrkbntougetux15", this);

    public final ExDBFieldString<BM_Dairiten, String> tsryshrkbnyokugetux15 = new ExDBFieldString<>("tsryshrkbnyokugetux15", this);

    public final ExDBFieldString<BM_Dairiten, String> bntnptnkbnx15 = new ExDBFieldString<>("bntnptnkbnx15", this);

    public final ExDBFieldString<BM_Dairiten, String> tsrybntnaitedrtencdx1 = new ExDBFieldString<>("tsrybntnaitedrtencdx1", this);

    public final ExDBFieldString<BM_Dairiten, BizNumber> tsrybntnwarix1 = new ExDBFieldString<>("tsrybntnwarix1", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, String> tsrybntnaitedrtencdx2 = new ExDBFieldString<>("tsrybntnaitedrtencdx2", this);

    public final ExDBFieldString<BM_Dairiten, BizNumber> tsrybntnwarix2 = new ExDBFieldString<>("tsrybntnwarix2", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, String> tsrybntnaitedrtencdx3 = new ExDBFieldString<>("tsrybntnaitedrtencdx3", this);

    public final ExDBFieldString<BM_Dairiten, BizNumber> tsrybntnwarix3 = new ExDBFieldString<>("tsrybntnwarix3", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, String> tsrybntnaitedrtencdx4 = new ExDBFieldString<>("tsrybntnaitedrtencdx4", this);

    public final ExDBFieldString<BM_Dairiten, BizNumber> tsrybntnwarix4 = new ExDBFieldString<>("tsrybntnwarix4", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, BizNumber> hnsituhykranktougetu = new ExDBFieldString<>("hnsituhykranktougetu", this, BizNumberType.class);

    public final ExDBFieldString<BM_Dairiten, BizNumber> hnsituhykrankyokugetu = new ExDBFieldString<>("hnsituhykrankyokugetu", this, BizNumberType.class);
}
