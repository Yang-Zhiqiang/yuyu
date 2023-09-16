package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.mapping.GenIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.meta.GenQIW_KhSeinengappiSeiTeiseiWk;
import yuyu.def.db.meta.QIW_KhSeinengappiSeiTeiseiWk;

/**
 * 被保険者生年月日・性訂正ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhSeinengappiSeiTeiseiWk} の JavaDoc を参照してください。
 * @see     GenIW_KhSeinengappiSeiTeiseiWk
 * @see     PKIW_KhSeinengappiSeiTeiseiWk
 * @see     QIW_KhSeinengappiSeiTeiseiWk
 * @see     GenQIW_KhSeinengappiSeiTeiseiWk
 */
@Entity
public class IW_KhSeinengappiSeiTeiseiWk extends GenIW_KhSeinengappiSeiTeiseiWk {

    private static final long serialVersionUID = 1L;

    public IW_KhSeinengappiSeiTeiseiWk() {
    }

    public IW_KhSeinengappiSeiTeiseiWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
