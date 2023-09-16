package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.HW_SikinIdouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;

/**
 * 資金移動ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHW_SikinIdouWk extends AbstractExDBTable<HW_SikinIdouWk> {

    public GenQHW_SikinIdouWk() {
        this("HW_SikinIdouWk");
    }

    public GenQHW_SikinIdouWk(String pAlias) {
        super("HW_SikinIdouWk", HW_SikinIdouWk.class, pAlias);
    }

    public String HW_SikinIdouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HW_SikinIdouWk, BizDate> nyksyoriymd = new ExDBFieldString<>("nyksyoriymd", this, BizDateType.class);

    public final ExDBFieldString<HW_SikinIdouWk, String> itirenno = new ExDBFieldString<>("itirenno", this);

    public final ExDBFieldString<HW_SikinIdouWk, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HW_SikinIdouWk, String> sikinidoumotohonkouzacd = new ExDBFieldString<>("sikinidoumotohonkouzacd", this);

    public final ExDBFieldString<HW_SikinIdouWk, String> sikinidousakihonkouzacd = new ExDBFieldString<>("sikinidousakihonkouzacd", this);

    public final ExDBFieldBizCurrency<HW_SikinIdouWk> sikinidougaku = new ExDBFieldBizCurrency<>("sikinidougaku", this);

    public final ExDBFieldString<HW_SikinIdouWk, String> nykmosno = new ExDBFieldString<>("nykmosno", this);

    public final ExDBFieldString<HW_SikinIdouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HW_SikinIdouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
