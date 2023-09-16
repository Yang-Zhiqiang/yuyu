package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenIW_KhHubiKaisyouDetailWk;


/**
 * 契約保全不備解消詳細ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIW_KhHubiKaisyouDetailWk} の JavaDoc を参照してください。<br />
 * @see     GenIW_KhHubiKaisyouDetailWk<br />
 * @see     PKIW_KhHubiKaisyouDetailWk<br />
 * @see     QIW_KhHubiKaisyouDetailWk<br />
 * @see     GenQIW_KhHubiKaisyouDetailWk<br />
 */
@Entity
public class IW_KhHubiKaisyouDetailWk extends GenIW_KhHubiKaisyouDetailWk {

    private static final long serialVersionUID = 1L;

    public IW_KhHubiKaisyouDetailWk() {
    }

    public IW_KhHubiKaisyouDetailWk(String pKouteikanriid,Integer pRenno3keta) {
        super(pKouteikanriid,pRenno3keta);
    }



}

