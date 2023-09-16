package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.mapping.GenJT_SiKekka;


/**
 * 支払処理結果テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiKekka} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiKekka<br />
 * @see     PKJT_SiKekka<br />
 * @see     QJT_SiKekka<br />
 * @see     GenQJT_SiKekka<br />
 */
@Entity
public class JT_SiKekka extends GenJT_SiKekka {

    private static final long serialVersionUID = 1L;

    public JT_SiKekka() {
    }

    public JT_SiKekka(C_ShiharaikekkadataKbn pShiharaikekkadatakbn,String pSyono,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno,C_SyutkKbn pSyutkkbn) {
        super(pShiharaikekkadatakbn,pSyono,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno,pSyutkkbn);
    }



}

