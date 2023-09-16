package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HurihunoKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.IT_MinyuList;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_HurihunoKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 未入一覧表テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_MinyuList extends AbstractExDBTable<IT_MinyuList> {

    public GenQIT_MinyuList() {
        this("IT_MinyuList");
    }

    public GenQIT_MinyuList(String pAlias) {
        super("IT_MinyuList", IT_MinyuList.class, pAlias);
    }

    public String IT_MinyuList() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_MinyuList, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_MinyuList, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_MinyuList, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MinyuList, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<IT_MinyuList, String> drtentsinyno = new ExDBFieldString<>("drtentsinyno", this);

    public final ExDBFieldString<IT_MinyuList, String> drtentsinadrkj = new ExDBFieldString<>("drtentsinadrkj", this);

    public final ExDBFieldString<IT_MinyuList, String> drtennmkj = new ExDBFieldString<>("drtennmkj", this);

    public final ExDBFieldString<IT_MinyuList, String> tsinyno = new ExDBFieldString<>("tsinyno", this);

    public final ExDBFieldString<IT_MinyuList, String> tsinadr1kj = new ExDBFieldString<>("tsinadr1kj", this);

    public final ExDBFieldString<IT_MinyuList, String> tsinadr2kj = new ExDBFieldString<>("tsinadr2kj", this);

    public final ExDBFieldString<IT_MinyuList, String> tsinadr3kj = new ExDBFieldString<>("tsinadr3kj", this);

    public final ExDBFieldString<IT_MinyuList, String> tsintelno = new ExDBFieldString<>("tsintelno", this);

    public final ExDBFieldString<IT_MinyuList, String> dai2tsintelno = new ExDBFieldString<>("dai2tsintelno", this);

    public final ExDBFieldString<IT_MinyuList, String> kyknmkj = new ExDBFieldString<>("kyknmkj", this);

    public final ExDBFieldString<IT_MinyuList, String> hhknnmkj = new ExDBFieldString<>("hhknnmkj", this);

    public final ExDBFieldString<IT_MinyuList, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<IT_MinyuList, BizDate> kykymd = new ExDBFieldString<>("kykymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MinyuList, C_Hrkkeiro> hrkkeiro = new ExDBFieldString<>("hrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IT_MinyuList, C_Hrkkaisuu> hrkkaisuu = new ExDBFieldString<>("hrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IT_MinyuList, BizDateYM> jkipjytym = new ExDBFieldString<>("jkipjytym", this, BizDateYMType.class);

    public final ExDBFieldBizCurrency<IT_MinyuList> hrkp = new ExDBFieldBizCurrency<>("hrkp", this);

    public final ExDBFieldString<IT_MinyuList, BizDate> yykknmnryymd = new ExDBFieldString<>("yykknmnryymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MinyuList, C_HurihunoKbn> hurihunokbn = new ExDBFieldString<>("hurihunokbn", this, UserType_C_HurihunoKbn.class);

    public final ExDBFieldString<IT_MinyuList, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IT_MinyuList, String> banknmkj = new ExDBFieldString<>("banknmkj", this);

    public final ExDBFieldString<IT_MinyuList, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IT_MinyuList, String> sitennmkj = new ExDBFieldString<>("sitennmkj", this);

    public final ExDBFieldString<IT_MinyuList, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IT_MinyuList, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IT_MinyuList, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IT_MinyuList, BizDate> nexthurikaeymd = new ExDBFieldString<>("nexthurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IT_MinyuList, String> rcreditcardno = new ExDBFieldString<>("rcreditcardno", this);

    public final ExDBFieldString<IT_MinyuList, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_MinyuList, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_MinyuList, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
