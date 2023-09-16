package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenJW_HubiKaisyouDetailWk;


/**
 * 支払不備解消詳細ワークテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJW_HubiKaisyouDetailWk} の JavaDoc を参照してください。<br />
 * @see     GenJW_HubiKaisyouDetailWk<br />
 * @see     PKJW_HubiKaisyouDetailWk<br />
 * @see     QJW_HubiKaisyouDetailWk<br />
 * @see     GenQJW_HubiKaisyouDetailWk<br />
 */
@Entity
public class JW_HubiKaisyouDetailWk extends GenJW_HubiKaisyouDetailWk {

    private static final long serialVersionUID = 1L;

    public JW_HubiKaisyouDetailWk() {
    }

    public JW_HubiKaisyouDetailWk(String pKouteikanriid,Integer pRenno3keta) {
        super(pKouteikanriid,pRenno3keta);
    }



}

