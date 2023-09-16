package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_AuthorikakyhKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_KanryotuutioutKbn;
import yuyu.def.classification.C_KyuukouzaAnnaiKbn;
import yuyu.def.classification.C_KzkykdouKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YykidouuktkKbn;
import yuyu.def.db.entity.IW_KhHaraikataHenkouWk;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_AuthorikakyhKbn;
import yuyu.def.db.type.UserType_C_Hrkkaisuu;
import yuyu.def.db.type.UserType_C_Hrkkeiro;
import yuyu.def.db.type.UserType_C_KanryotuutioutKbn;
import yuyu.def.db.type.UserType_C_KyuukouzaAnnaiKbn;
import yuyu.def.db.type.UserType_C_KzkykdouKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TkiktbrisyuruiKbn;
import yuyu.def.db.type.UserType_C_YokinKbn;
import yuyu.def.db.type.UserType_C_YykidouuktkKbn;

/**
 * 払方変更ワークテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIW_KhHaraikataHenkouWk extends AbstractExDBTable<IW_KhHaraikataHenkouWk> {

    public GenQIW_KhHaraikataHenkouWk() {
        this("IW_KhHaraikataHenkouWk");
    }

    public GenQIW_KhHaraikataHenkouWk(String pAlias) {
        super("IW_KhHaraikataHenkouWk", IW_KhHaraikataHenkouWk.class, pAlias);
    }

    public String IW_KhHaraikataHenkouWk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> kouteikanriid = new ExDBFieldString<>("kouteikanriid", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, BizDate> skssakuseiymd = new ExDBFieldString<>("skssakuseiymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_Hrkkeiro> newhrkkeiro = new ExDBFieldString<>("newhrkkeiro", this, UserType_C_Hrkkeiro.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_Hrkkaisuu> newhrkkaisuu = new ExDBFieldString<>("newhrkkaisuu", this, UserType_C_Hrkkaisuu.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_TkiktbrisyuruiKbn> newtikiktbrisyuruikbn = new ExDBFieldString<>("newtikiktbrisyuruikbn", this, UserType_C_TkiktbrisyuruiKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, BizDateYM> henkouyoteiym = new ExDBFieldString<>("henkouyoteiym", this, BizDateYMType.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_KzkykdouKbn> kzkykdoukbn = new ExDBFieldString<>("kzkykdoukbn", this, UserType_C_KzkykdouKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> kzmeiginmkn = new ExDBFieldString<>("kzmeiginmkn", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> cardkaisyacd = new ExDBFieldString<>("cardkaisyacd", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditcardno1 = new ExDBFieldString<>("creditcardno1", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditcardno2 = new ExDBFieldString<>("creditcardno2", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditcardno3 = new ExDBFieldString<>("creditcardno3", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditcardno4 = new ExDBFieldString<>("creditcardno4", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> ykkigenyy = new ExDBFieldString<>("ykkigenyy", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> ykkigenmm = new ExDBFieldString<>("ykkigenmm", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditmeiginmkn = new ExDBFieldString<>("creditmeiginmkn", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_AuthorikakyhKbn> authorikakyhkbn = new ExDBFieldString<>("authorikakyhkbn", this, UserType_C_AuthorikakyhKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_YykidouuktkKbn> yykidouuktkkbn = new ExDBFieldString<>("yykidouuktkkbn", this, UserType_C_YykidouuktkKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_KyuukouzaAnnaiKbn> kyuukouzaannaikbn = new ExDBFieldString<>("kyuukouzaannaikbn", this, UserType_C_KyuukouzaAnnaiKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_KanryotuutioutKbn> kanryotuutioutkbn = new ExDBFieldString<>("kanryotuutioutkbn", this, UserType_C_KanryotuutioutKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, C_SyorikekkaKbn> zenkaisyorikekkakbn = new ExDBFieldString<>("zenkaisyorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, BizDate> kyuukouzahurikaeymd = new ExDBFieldString<>("kyuukouzahurikaeymd", this, BizDateType.class);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);

    public final ExDBFieldString<IW_KhHaraikataHenkouWk, String> creditkessaiyouno = new ExDBFieldString<>("creditkessaiyouno", this);
}
