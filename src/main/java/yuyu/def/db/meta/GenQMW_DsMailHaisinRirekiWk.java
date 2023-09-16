package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_DsSousinMailSyubetuKbn;

/**
 * ＤＳメール配信履歴ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMW_DsMailHaisinRirekiWk extends AbstractExDBTable<MW_DsMailHaisinRirekiWk> {

    public GenQMW_DsMailHaisinRirekiWk() {
        this("MW_DsMailHaisinRirekiWk");
    }

    public GenQMW_DsMailHaisinRirekiWk(String pAlias) {
        super("MW_DsMailHaisinRirekiWk", MW_DsMailHaisinRirekiWk.class, pAlias);
    }

    public String MW_DsMailHaisinRirekiWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, BizDate> dsdatasakuseiymd = new ExDBFieldString<>("dsdatasakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MW_DsMailHaisinRirekiWk, Integer> dsmailhaisinrenban = new ExDBFieldNumber<>("dsmailhaisinrenban", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> haisinjidsmailaddress = new ExDBFieldString<>("haisinjidsmailaddress", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> dssousinno = new ExDBFieldString<>("dssousinno", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, C_DsSousinMailSyubetuKbn> dssousinmailsyubetukbn = new ExDBFieldString<>("dssousinmailsyubetukbn", this, UserType_C_DsSousinMailSyubetuKbn.class);

    public final ExDBFieldString<MW_DsMailHaisinRirekiWk, String> syono = new ExDBFieldString<>("syono", this);
}
