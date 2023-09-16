package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.mapping.GenHT_SmbcStyKanriSsRireki;


/**
 * ＳＭＢＣ進捗管理作成履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_SmbcStyKanriSsRireki} の JavaDoc を参照してください。<br />
 * @see     GenHT_SmbcStyKanriSsRireki<br />
 * @see     PKHT_SmbcStyKanriSsRireki<br />
 * @see     QHT_SmbcStyKanriSsRireki<br />
 * @see     GenQHT_SmbcStyKanriSsRireki<br />
 */
@Entity
public class HT_SmbcStyKanriSsRireki extends GenHT_SmbcStyKanriSsRireki {

    private static final long serialVersionUID = 1L;

    public HT_SmbcStyKanriSsRireki() {
    }

    public HT_SmbcStyKanriSsRireki(String pSyono) {
        super(pSyono);
    }



}

