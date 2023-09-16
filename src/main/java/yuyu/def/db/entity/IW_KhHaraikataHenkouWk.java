package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhHaraikataHenkouWk;
import yuyu.def.db.mapping.GenIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.GenQIW_KhHaraikataHenkouWk;
import yuyu.def.db.meta.QIW_KhHaraikataHenkouWk;

/**
 * 払方変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhHaraikataHenkouWk} の JavaDoc を参照してください。
 * @see     GenIW_KhHaraikataHenkouWk
 * @see     PKIW_KhHaraikataHenkouWk
 * @see     QIW_KhHaraikataHenkouWk
 * @see     GenQIW_KhHaraikataHenkouWk
 */
@Entity
public class IW_KhHaraikataHenkouWk extends GenIW_KhHaraikataHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhHaraikataHenkouWk() {
    }

    public IW_KhHaraikataHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
