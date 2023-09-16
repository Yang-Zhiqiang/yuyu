package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_BAK_SyoriCTL;


/**
 * 処理コントロールバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_BAK_SyoriCTL} の JavaDoc を参照してください。<br />
 * @see     GenHT_BAK_SyoriCTL<br />
 * @see     PKHT_BAK_SyoriCTL<br />
 * @see     QHT_BAK_SyoriCTL<br />
 * @see     GenQHT_BAK_SyoriCTL<br />
 */
@Entity
public class HT_BAK_SyoriCTL extends GenHT_BAK_SyoriCTL {

    private static final long serialVersionUID = 1L;

    public HT_BAK_SyoriCTL() {
    }

    public HT_BAK_SyoriCTL(String pMosno,String pTrkssikibetukey) {
        super(pMosno,pTrkssikibetukey);
    }



}

