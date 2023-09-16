package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.db.mapping.GenIT_KhHubiMikaisyouList;


/**
 * 契約保全不備未解消リストテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhHubiMikaisyouList} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhHubiMikaisyouList<br />
 * @see     PKIT_KhHubiMikaisyouList<br />
 * @see     QIT_KhHubiMikaisyouList<br />
 * @see     GenQIT_KhHubiMikaisyouList<br />
 */
@Entity
public class IT_KhHubiMikaisyouList extends GenIT_KhHubiMikaisyouList {

    private static final long serialVersionUID = 1L;

    public IT_KhHubiMikaisyouList() {
    }

    public IT_KhHubiMikaisyouList(String pJimutetuzukicd,String pSyono,C_HassinsakiKbn pHassinsakikbn) {
        super(pJimutetuzukicd,pSyono,pHassinsakikbn);
    }



}

