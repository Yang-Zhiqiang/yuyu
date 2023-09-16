package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KihontikucdSyoumetuKbn;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.db.entity.BM_Address;
import yuyu.def.db.type.UserType_C_KihontikucdSyoumetuKbn;
import yuyu.def.db.type.UserType_C_TodouhukenKbn;

/**
 * 住所マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_Address extends AbstractExDBTable<BM_Address> {

    public GenQBM_Address() {
        this("BM_Address");
    }

    public GenQBM_Address(String pAlias) {
        super("BM_Address", BM_Address.class, pAlias);
    }

    public String BM_Address() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_Address, String> postalCd = new ExDBFieldString<>("postalCd", this);

    public final ExDBFieldString<BM_Address, String> kihontikucdsimo1 = new ExDBFieldString<>("kihontikucdsimo1", this);

    public final ExDBFieldString<BM_Address, C_KihontikucdSyoumetuKbn> kihontikucdsyoumetukbn = new ExDBFieldString<>("kihontikucdsyoumetukbn", this, UserType_C_KihontikucdSyoumetuKbn.class);

    public final ExDBFieldString<BM_Address, String> kjadrkyoutotuusyounmari = new ExDBFieldString<>("kjadrkyoutotuusyounmari", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjtodouhukennmketasuu = new ExDBFieldNumber<>("kjtodouhukennmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjsikugunnmketasuu = new ExDBFieldNumber<>("kjsikugunnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjsikutyousonnmketasuu = new ExDBFieldNumber<>("kjsikutyousonnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjtyousonnmketasuu = new ExDBFieldNumber<>("kjtyousonnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjkyoutotuusyounmketasuu = new ExDBFieldNumber<>("kjkyoutotuusyounmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kjadrketasuu = new ExDBFieldNumber<>("kjadrketasuu", this);

    public final ExDBFieldString<BM_Address, String> knadrkyoutotuusyounmari = new ExDBFieldString<>("knadrkyoutotuusyounmari", this);

    public final ExDBFieldNumber<BM_Address, Integer> kntodouhukennmketasuu = new ExDBFieldNumber<>("kntodouhukennmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> knsikugunnmketasuu = new ExDBFieldNumber<>("knsikugunnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> knsikutyousonnmketasuu = new ExDBFieldNumber<>("knsikutyousonnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> kntyousonnmketasuu = new ExDBFieldNumber<>("kntyousonnmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> knkyoutotuusyounmketasuu = new ExDBFieldNumber<>("knkyoutotuusyounmketasuu", this);

    public final ExDBFieldNumber<BM_Address, Integer> knadrketasuu = new ExDBFieldNumber<>("knadrketasuu", this);

    public final ExDBFieldString<BM_Address, C_TodouhukenKbn> todouhukencd = new ExDBFieldString<>("todouhukencd", this, UserType_C_TodouhukenKbn.class);

    public final ExDBFieldString<BM_Address, String> gyouseikukakucd = new ExDBFieldString<>("gyouseikukakucd", this);

    public final ExDBFieldString<BM_Address, String> ikoumaekihontikucd = new ExDBFieldString<>("ikoumaekihontikucd", this);

    public final ExDBFieldString<BM_Address, String> newynohyouji = new ExDBFieldString<>("newynohyouji", this);

    public final ExDBFieldString<BM_Address, String> adrkj = new ExDBFieldString<>("adrkj", this);

    public final ExDBFieldString<BM_Address, String> adrkn = new ExDBFieldString<>("adrkn", this);

    public final ExDBFieldString<BM_Address, String> adrknblankari = new ExDBFieldString<>("adrknblankari", this);
}
