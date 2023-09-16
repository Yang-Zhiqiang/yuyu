package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_KyhkinTaniKbn;
import yuyu.def.classification.C_NitigakuHokenKngkKbn;
import yuyu.def.classification.C_SbjiShrKbn;
import yuyu.def.classification.C_SeisankinKanritukaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KyhgndkataKbn;
import yuyu.def.db.type.UserType_C_KyhkinTaniKbn;
import yuyu.def.db.type.UserType_C_NitigakuHokenKngkKbn;
import yuyu.def.db.type.UserType_C_SbjiShrKbn;
import yuyu.def.db.type.UserType_C_SeisankinKanritukaKbn;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 支払商品属性マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SiSyouhnZokusei extends AbstractExDBTable<JM_SiSyouhnZokusei> {

    public GenQJM_SiSyouhnZokusei() {
        this("JM_SiSyouhnZokusei");
    }

    public GenQJM_SiSyouhnZokusei(String pAlias) {
        super("JM_SiSyouhnZokusei", JM_SiSyouhnZokusei.class, pAlias);
    }

    public String JM_SiSyouhnZokusei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_KyhgndkataKbn> kyhgndkatakbn = new ExDBFieldString<>("kyhgndkatakbn", this, UserType_C_KyhgndkataKbn.class);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> kyuuhucd = new ExDBFieldString<>("kyuuhucd", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> syouhnnmgm = new ExDBFieldString<>("syouhnnmgm", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> syouhnnmtyhy = new ExDBFieldString<>("syouhnnmtyhy", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> hyoujijyun = new ExDBFieldNumber<>("hyoujijyun", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> taisyoukkngaishrkahikbn = new ExDBFieldNumber<>("taisyoukkngaishrkahikbn", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> byoumeisetteikbn = new ExDBFieldString<>("byoumeisetteikbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> shrjiyuu = new ExDBFieldString<>("shrjiyuu", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> syoumetuumukbn = new ExDBFieldString<>("syoumetuumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> taisyoukknmae = new ExDBFieldNumber<>("taisyoukknmae", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> taisyoukknato = new ExDBFieldNumber<>("taisyoukknato", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> shrtaisyounissuu = new ExDBFieldNumber<>("shrtaisyounissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> shrtaisyounyuuinnissuu = new ExDBFieldNumber<>("shrtaisyounyuuinnissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> hutanponissuu = new ExDBFieldNumber<>("hutanponissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> itinyuuingendonissuu = new ExDBFieldNumber<>("itinyuuingendonissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> kyhgendonissuu = new ExDBFieldNumber<>("kyhgendonissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> tuusangendonissuu = new ExDBFieldNumber<>("tuusangendonissuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> tuusangendokaisuu = new ExDBFieldNumber<>("tuusangendokaisuu", this);

    public final ExDBFieldBizCurrency<JM_SiSyouhnZokusei> tuusangendogaku = new ExDBFieldBizCurrency<>("tuusangendogaku", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> betusippeihanteinissuu = new ExDBFieldNumber<>("betusippeihanteinissuu", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, BizNumber> nitigakurate = new ExDBFieldString<>("nitigakurate", this, BizNumberType.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_NitigakuHokenKngkKbn> nitigakuhokenkngkkbn = new ExDBFieldString<>("nitigakuhokenkngkkbn", this, UserType_C_NitigakuHokenKngkKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_KyhkinTaniKbn> kyhkintanikbn = new ExDBFieldString<>("kyhkintanikbn", this, UserType_C_KyhkinTaniKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, BizNumber> shrbairitu = new ExDBFieldString<>("shrbairitu", this, BizNumberType.class);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> jisatumensekinensuu = new ExDBFieldNumber<>("jisatumensekinensuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> manryoumaetukisuu = new ExDBFieldNumber<>("manryoumaetukisuu", this);

    public final ExDBFieldNumber<JM_SiSyouhnZokusei, Integer> tyouhyouhyoujikbn = new ExDBFieldNumber<>("tyouhyouhyoujikbn", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> nyuuinitijikinumukbn = new ExDBFieldString<>("nyuuinitijikinumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> sensinitijikinumukbn = new ExDBFieldString<>("sensinitijikinumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<JM_SiSyouhnZokusei> itijikngk = new ExDBFieldBizCurrency<>("itijikngk", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> kyhkintaisyouumukbn = new ExDBFieldString<>("kyhkintaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> kdhokenkintaisyouumukbn = new ExDBFieldString<>("kdhokenkintaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> pmtaisyouumukbn = new ExDBFieldString<>("pmtaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SbjiShrKbn> sbjishrkbn = new ExDBFieldString<>("sbjishrkbn", this, UserType_C_SbjiShrKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> sbmensekitaisyouumukbn = new ExDBFieldString<>("sbmensekitaisyouumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> kyhntgkkatacalcumukbn = new ExDBFieldString<>("kyhntgkkatacalcumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> shrsakugenkknumukbn = new ExDBFieldString<>("shrsakugenkknumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> misyuumikeikadoujiumukbn = new ExDBFieldString<>("misyuumikeikadoujiumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> hokenkngknitigakumsg1 = new ExDBFieldString<>("hokenkngknitigakumsg1", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, String> hokenkngknitigakumsg2 = new ExDBFieldString<>("hokenkngknitigakumsg2", this);

    public final ExDBFieldBizCurrency<JM_SiSyouhnZokusei> lnmaxkngk = new ExDBFieldBizCurrency<>("lnmaxkngk", this);

    public final ExDBFieldBizCurrency<JM_SiSyouhnZokusei> lnminkngk = new ExDBFieldBizCurrency<>("lnminkngk", this);

    public final ExDBFieldBizCurrency<JM_SiSyouhnZokusei> lnseikyuutanisenyen = new ExDBFieldBizCurrency<>("lnseikyuutanisenyen", this);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> calckijyunmiraibicheck = new ExDBFieldString<>("calckijyunmiraibicheck", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> psoutougkhyoujiumu = new ExDBFieldString<>("psoutougkhyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> tmttkngkhyoujiumu = new ExDBFieldString<>("tmttkngkhyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> kaiyakuhrhyoujiumu = new ExDBFieldString<>("kaiyakuhrhyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> kihonshyoujiumu = new ExDBFieldString<>("kihonshyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_UmuKbn> saigaishyoujiumu = new ExDBFieldString<>("saigaishyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SeisankinKanritukaKbn> msyupknrtuukakbn = new ExDBFieldString<>("msyupknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SeisankinKanritukaKbn> mikeikapknrtuukakbn = new ExDBFieldString<>("mikeikapknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SeisankinKanritukaKbn> znnusisnkinknrtuukakbn = new ExDBFieldString<>("znnusisnkinknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);

    public final ExDBFieldString<JM_SiSyouhnZokusei, C_SeisankinKanritukaKbn> krkinknrtuukakbn = new ExDBFieldString<>("krkinknrtuukakbn", this, UserType_C_SeisankinKanritukaKbn.class);
}
