package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIW_KhMkhgkHenkouWk;
import yuyu.def.db.mapping.GenIW_KhMkhgkHenkouWk;
import yuyu.def.db.meta.GenQIW_KhMkhgkHenkouWk;
import yuyu.def.db.meta.QIW_KhMkhgkHenkouWk;

/**
 * 目標額変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhMkhgkHenkouWk} の JavaDoc を参照してください。
 * @see     GenIW_KhMkhgkHenkouWk
 * @see     PKIW_KhMkhgkHenkouWk
 * @see     QIW_KhMkhgkHenkouWk
 * @see     GenQIW_KhMkhgkHenkouWk
 */
@Entity
public class IW_KhMkhgkHenkouWk extends GenIW_KhMkhgkHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhMkhgkHenkouWk() {
    }

    public IW_KhMkhgkHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }

}
