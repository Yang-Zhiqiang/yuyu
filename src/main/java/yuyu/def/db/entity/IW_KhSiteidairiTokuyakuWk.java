package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.mapping.GenIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.GenQIW_KhSiteidairiTokuyakuWk;
import yuyu.def.db.meta.QIW_KhSiteidairiTokuyakuWk;

/**
 * 指定代理請求特約中途付加ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhSiteidairiTokuyakuWk} の JavaDoc を参照してください。
 * @see     GenIW_KhSiteidairiTokuyakuWk
 * @see     PKIW_KhSiteidairiTokuyakuWk
 * @see     QIW_KhSiteidairiTokuyakuWk
 * @see     GenQIW_KhSiteidairiTokuyakuWk
 */
@Entity
public class IW_KhSiteidairiTokuyakuWk extends GenIW_KhSiteidairiTokuyakuWk {

    private static final long serialVersionUID = 1L;

    public IW_KhSiteidairiTokuyakuWk() {
    }

    public IW_KhSiteidairiTokuyakuWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
