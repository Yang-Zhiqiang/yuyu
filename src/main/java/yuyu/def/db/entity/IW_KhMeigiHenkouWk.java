package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhMeigiHenkouWk;


/**
 * 名義変更ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhMeigiHenkouWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhMeigiHenkouWk<br />
 * @see     PKIW_KhMeigiHenkouWk<br />
 * @see     QIW_KhMeigiHenkouWk<br />
 * @see     GenQIW_KhMeigiHenkouWk<br />
 */
@Entity
public class IW_KhMeigiHenkouWk extends GenIW_KhMeigiHenkouWk {

    private static final long serialVersionUID = 1L;

    public IW_KhMeigiHenkouWk() {
    }

    public IW_KhMeigiHenkouWk(String pKouteikanriid) {
        super(pKouteikanriid);
    }



}

