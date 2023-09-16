package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MV_DsMailSosinRirekiSyoukai;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール送信履歴照会ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMV_DsMailSosinRirekiSyoukai extends AbstractExDBTable<MV_DsMailSosinRirekiSyoukai> {

    public GenQMV_DsMailSosinRirekiSyoukai() {
        this("MV_DsMailSosinRirekiSyoukai");
    }

    public GenQMV_DsMailSosinRirekiSyoukai(String pAlias) {
        super("MV_DsMailSosinRirekiSyoukai", MV_DsMailSosinRirekiSyoukai.class, pAlias);
    }

    public String MV_DsMailSosinRirekiSyoukai() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MV_DsMailSosinRirekiSyoukai, Integer> dsmailhaisinrenban = new ExDBFieldNumber<>("dsmailhaisinrenban", this);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, String> haisinjidsmailaddress = new ExDBFieldString<>("haisinjidsmailaddress", this);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MV_DsMailSosinRirekiSyoukai, String> haisinerrorcount = new ExDBFieldString<>("haisinerrorcount", this);
}
