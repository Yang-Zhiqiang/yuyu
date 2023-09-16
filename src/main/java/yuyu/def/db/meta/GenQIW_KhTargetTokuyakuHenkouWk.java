package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_HonninKakninKekkaKbn;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TargetTkHenkouKbn;
import yuyu.def.db.entity.IW_KhTargetTokuyakuHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HassouKbn;
import yuyu.def.db.type.UserType_C_HonninKakninKekkaKbn;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TargetTkHenkouKbn;

/**
 * ターゲット特約変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhTargetTokuyakuHenkouWk extends AbstractExDBTable<IW_KhTargetTokuyakuHenkouWk> {

    public GenQIW_KhTargetTokuyakuHenkouWk() {
        this("IW_KhTargetTokuyakuHenkouWk");
    }

    public GenQIW_KhTargetTokuyakuHenkouWk(String pAlias) {
        super("IW_KhTargetTokuyakuHenkouWk", IW_KhTargetTokuyakuHenkouWk.class, pAlias);
    }

    public String IW_KhTargetTokuyakuHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, BizDate> targettkykkykhenkoymd = new ExDBFieldString<>("targettkykkykhenkoymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, C_TargetTkHenkouKbn> targettkykhnkkbn = new ExDBFieldString<>("targettkykhnkkbn", this, UserType_C_TargetTkHenkouKbn.class);

    public final ExDBFieldNumber<IW_KhTargetTokuyakuHenkouWk, Integer> targettkmokuhyouti = new ExDBFieldNumber<>("targettkmokuhyouti", this);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, C_HonninKakninKekkaKbn> honninkakninkekkakbn = new ExDBFieldString<>("honninkakninkekkakbn", this, UserType_C_HonninKakninKekkaKbn.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, C_HassouKbn> hassoukbn = new ExDBFieldString<>("hassoukbn", this, UserType_C_HassouKbn.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, C_KanryotuutioutKbn> kanryotuutioutkbn = new ExDBFieldString<>("kanryotuutioutkbn", this, UserType_C_KanryotuutioutKbn.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhTargetTokuyakuHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
