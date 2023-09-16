package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhSiharaiKouzaHenkouWk;


/**
 * 支払口座情報変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhSiharaiKouzaHenkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhSiharaiKouzaHenkouWk<br />
 * @see     PKIW_KhSiharaiKouzaHenkouWk<br />
 * @see     QIW_KhSiharaiKouzaHenkouWk<br />
 * @see     GenQIW_KhSiharaiKouzaHenkouWk<br />
 */
@Entity
public class IW_KhSiharaiKouzaHenkouWk extends GenIW_KhSiharaiKouzaHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhSiharaiKouzaHenkouWk() {
    }

    public IW_KhSiharaiKouzaHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

