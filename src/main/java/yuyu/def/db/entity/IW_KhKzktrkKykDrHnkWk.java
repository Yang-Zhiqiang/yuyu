package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.mapping.GenIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.GenQIW_KhKzktrkKykDrHnkWk;
import yuyu.def.db.meta.QIW_KhKzktrkKykDrHnkWk;

/**
 * 家族登録契約者代理特約変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhKzktrkKykDrHnkWk} の JavaDoc を参照してください。
 * @see     GenIW_KhKzktrkKykDrHnkWk
 * @see     PKIW_KhKzktrkKykDrHnkWk
 * @see     QIW_KhKzktrkKykDrHnkWk
 * @see     GenQIW_KhKzktrkKykDrHnkWk
 */
@Entity
public class IW_KhKzktrkKykDrHnkWk extends GenIW_KhKzktrkKykDrHnkWk {

    private static final long serialVersionUID = 1L;

    public IW_KhKzktrkKykDrHnkWk() {
    }

    public IW_KhKzktrkKykDrHnkWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
