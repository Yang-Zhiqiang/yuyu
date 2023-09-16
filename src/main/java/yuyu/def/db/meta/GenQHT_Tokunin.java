package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_MassitknKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_SyorisimetknKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.type.UserType_C_IkkatuyouptknKbn;
import yuyu.def.db.type.UserType_C_KakoymdkyytknKbn;
import yuyu.def.db.type.UserType_C_KzmeigitknKbn;
import yuyu.def.db.type.UserType_C_MassitknKbn;
import yuyu.def.db.type.UserType_C_NenkkntknKbn;
import yuyu.def.db.type.UserType_C_NenreiuptknKbn;
import yuyu.def.db.type.UserType_C_SaiteiptknKbn;
import yuyu.def.db.type.UserType_C_SentakuinfotknKbn;
import yuyu.def.db.type.UserType_C_SignalkaihiKbn;
import yuyu.def.db.type.UserType_C_SonotaTokuninKbn;
import yuyu.def.db.type.UserType_C_SpgndtknKbn;
import yuyu.def.db.type.UserType_C_SyorisimetknKbn;
import yuyu.def.db.type.UserType_C_TsngndtknKbn;
import yuyu.def.db.type.UserType_C_YoteiriritutknKbn;

/**
 * 特認テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_Tokunin extends AbstractExDBTable<HT_Tokunin> {

    public GenQHT_Tokunin() {
        this("HT_Tokunin");
    }

    public GenQHT_Tokunin(String pAlias) {
        super("HT_Tokunin", HT_Tokunin.class, pAlias);
    }

    public String HT_Tokunin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_Tokunin, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_Tokunin, C_SpgndtknKbn> spgndtknkbn = new ExDBFieldString<>("spgndtknkbn", this, UserType_C_SpgndtknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_NenkkntknKbn> nenkkntknkbn = new ExDBFieldString<>("nenkkntknkbn", this, UserType_C_NenkkntknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_TsngndtknKbn> tsngndtknkbn = new ExDBFieldString<>("tsngndtknkbn", this, UserType_C_TsngndtknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_SentakuinfotknKbn> sentakuinfotknkbn = new ExDBFieldString<>("sentakuinfotknkbn", this, UserType_C_SentakuinfotknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_SyorisimetknKbn> syorisimetknkbn = new ExDBFieldString<>("syorisimetknkbn", this, UserType_C_SyorisimetknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_KzmeigitknKbn> kzmeigitknkbn = new ExDBFieldString<>("kzmeigitknkbn", this, UserType_C_KzmeigitknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_MassitknKbn> massitknkbn = new ExDBFieldString<>("massitknkbn", this, UserType_C_MassitknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_KakoymdkyytknKbn> kakoymdkyytknkbn = new ExDBFieldString<>("kakoymdkyytknkbn", this, UserType_C_KakoymdkyytknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_SaiteiptknKbn> saiteiptknkbn = new ExDBFieldString<>("saiteiptknkbn", this, UserType_C_SaiteiptknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_YoteiriritutknKbn> yoteiriritutknkbn = new ExDBFieldString<>("yoteiriritutknkbn", this, UserType_C_YoteiriritutknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_NenreiuptknKbn> nenreiuptknkbn = new ExDBFieldString<>("nenreiuptknkbn", this, UserType_C_NenreiuptknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_SignalkaihiKbn> signalkaihikbn = new ExDBFieldString<>("signalkaihikbn", this, UserType_C_SignalkaihiKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_IkkatuyouptknKbn> ikkatuyouptknkbn = new ExDBFieldString<>("ikkatuyouptknkbn", this, UserType_C_IkkatuyouptknKbn.class);

    public final ExDBFieldString<HT_Tokunin, C_SonotaTokuninKbn> sonotatknkbn = new ExDBFieldString<>("sonotatknkbn", this, UserType_C_SonotaTokuninKbn.class);

    public final ExDBFieldString<HT_Tokunin, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HT_Tokunin, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_Tokunin, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
